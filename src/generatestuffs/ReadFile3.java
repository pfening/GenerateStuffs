package generatestuffs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadFile3 {

    static String fs=System.getProperty("file.separator");
    static String hd=System.getProperty("user.home");
    static String dbfolder;
    static String dbname;
    static String dbfullpath;
            
    public static void main(String[] args) throws IOException {
        
        StringWriter sql = new StringWriter();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\NetBeansProjects\\GenerateStuffs\\src\\generatestuffs\\testfile.txt"))){

            String row;            
    
            while ((row = br.readLine()) != null) {

                if (row.contains("project:")){
                    String proj_val = row.split(":")[1];
                    dbfolder=proj_val;
                    dbname=proj_val+".db";
                    dbfullpath=hd + fs + dbfolder + fs + dbname;
                    
                    File path = new File(hd + fs + dbfolder);            
                    if (!path.exists()) {
                            path.mkdir();
                            }                    
                    }
                
                if (row.contains("table_data:")){
                    String table_val = row.split(":")[1];
                    String[] tables = table_val.split(",");
                    
                    for( String table : tables) {                        
                        String tab = table.split("\\(")[0].replace(" ", "");
                        sql.append("CREATE TABLE '" + tab +"' ('" + tab + "_id' INTEGER PRIMARY KEY AUTOINCREMENT");
                        String fields = table.split("[\\(\\)]")[1];
                        for (String col : fields.split(" ")){
                            sql.append(", '" + col + "' TEXT");
                            }
                        sql.append(");");
                    }
                }
                
                if (row.contains("relations:")){
                    String relations = row.split(":")[1];
                    String[] rel_val = relations.split(",");
                    
                    for( String rel : rel_val) {                        
                        System.out.println(rel);
                    }                   
                }
            }

    Connection conn = null;
    Statement stmt = null;

    String dbpath ="jdbc:sqlite:" + dbfullpath;
    try{
       Class.forName("org.sqlite.JDBC");
       conn = DriverManager.getConnection(dbpath);
       stmt = conn.createStatement();
       stmt.executeUpdate(sql.toString());
         }
    catch(ClassNotFoundException | SQLException e)
         {
             System.out.println("Error processing results: " + e.toString());
             try
             {
                 stmt.close();
                 conn.close();
             }
             catch(Exception ex)
             {
             }
          }

        } catch (IOException e) {
        }         
    }
}

package generatestuffs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class ReadFile3 {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\NetBeansProjects\\GenerateStuffs\\src\\generatestuffs\\testfile.txt"))){

            String row;
            StringWriter sql = new StringWriter();
            
                public static String fs=System.getProperty("file.separator");
    public static String hd=System.getProperty("user.home");

    public static String dbfolder="dbtest";

    public static String dbname="test.db";

    public static String dbfullpath=hd + fs + dbfolder + fs + dbname;

	public static void main(String[] args) {

		File path = new File(hd + fs + dbfolder);

		if (!path.exists()) {
                    path.mkdir();
                    }
        try{
		File dbfile = new File(dbfullpath);
 		if (dbfile.createNewFile()){
                    //String sql = null;
                    //sql = "CREATE TABLE IF NOT EXISTS list (hostname STRING PRIMARY KEY, ip STRING, uid STRING, pass STRING, description STRING, app STRING, tsocks STRING)";
                    //selectdb.write(sql);                                
                    }
	}catch (IOException e) {
	}
        }   
            
                
            while ((row = br.readLine()) != null) {

                if (row.contains("project:")){
                    String proj_val = row.split(":")[1];
                    System.out.println(proj_val);
                    //sql.append(proj_val);
                    
                }
                if (row.contains("table_data:")){
                    String table_val = row.split(":")[1];
                    //System.out.println(table_val);
                    String[] tables = table_val.split(",");
                    for( String table : tables) {
                        //System.out.println(table);
                        
                        String tab = table.split("\\(")[0].replace(" ", "");
                        System.out.print("CREATE TABLE '" + tab +"' ('" + tab + "_id' INTEGER PRIMARY KEY AUTOINCREMENT");
                        sql.append("CREATE TABLE '" + tab +"' ('" + tab + "_id' INTEGER PRIMARY KEY AUTOINCREMENT");
                        String fields = table.split("[\\(\\)]")[1];
                        //System.out.println("Fields: " + fields);
                        for (String col : fields.split(" ")){
                            System.out.print(", '" + col + "' TEXT");
                            sql.append(", '" + col + "' TEXT");
                        }
                        System.out.print(");");
                        sql.append(");");
                        System.out.println("");
                    }
                }
            }
            System.out.println(sql);
        } catch (IOException e) {
        } 
        

    }
}

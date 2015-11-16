package generatestuffs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile2 {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\NetBeansProjects\\GenerateStuffs\\src\\generatestuffs\\testfile.txt"))){
            
            String row;
            while ((row = br.readLine()) != null) {

                if (row.contains("project:")){
                    String proj_val = row.split(":")[1];
                    System.out.println(proj_val);
                }
                if (row.contains("table_data:")){
                    String table_val = row.split(":")[1];
                    //System.out.println(table_val);
                    String[] tables = table_val.split(",");
                    for( String table : tables) {
                        //System.out.println(table);
                        
                        String tab = table.split("\\(")[0].replace(" ", "");
                        System.out.print("CREATE TABLE '" + tab +"' ('" + tab + "_id' INTEGER PRIMARY KEY AUTOINCREMENT");
                        String fields = table.split("[\\(\\)]")[1];
                        //System.out.println("Fields: " + fields);
                        for (String col : fields.split(" ")){
                            System.out.print(", '" + col + "' TEXT");
                        }
                        System.out.print(");");
                        System.out.println("");
                    }
                }
            }

        } catch (IOException e) {
        } 

    }
}

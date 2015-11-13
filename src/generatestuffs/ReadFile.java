package generatestuffs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\NetBeansProjects\\GenerateStuffs\\src\\generatestuffs\\testfile.txt"))){
            
            String row;
            while ((row = br.readLine()) != null) {
                //System.out.println(row);
                String[] split = row.split("\\)");
                int tablesCount = split.length;
                System.out.println(tablesCount);
                for(int i=0; i<tablesCount; i++){
                    //System.out.println("Table count is: " + i);
                    String table = split[i].split("\\(")[0].replace(" ", "");
                    System.out.println("Table name: " + table);
                    String fields = split[i].split("\\(")[1];
                    System.out.println("Fields: " + fields);
                }
                                                    
            }

        } catch (IOException e) {
        } 

    }
}

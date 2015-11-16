package generatestuffs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readjson {
     public static void main(String[] args) {

	JSONParser parser = new JSONParser();

	try {

		Object obj = parser.parse(new FileReader("C:\\NetBeansProjects\\GenerateStuffs\\src\\generatestuffs\\test.json"));

		JSONObject jsonObject = (JSONObject) obj;

		String name = (String) jsonObject.get("project");
		System.out.println(name);

		JSONObject tables = (JSONObject) jsonObject.get("tables");
                
                Set keySet = tables.keySet();

                Object[] keyArray = keySet.toArray();
                for( Object element : keyArray) {
                    System.out.println( "Table name: " + element ); 
                    Object elem_vals = tables.get(element);

                    String[] cols = elem_vals.toString().split(",");
                    for( String col : cols) {
                        System.out.println("oszlop: " + col);
                    }
                 }


	} catch (FileNotFoundException e) {
	} catch (IOException | ParseException e) {
	}

     }

}
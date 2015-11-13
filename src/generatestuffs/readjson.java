/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatestuffs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
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

		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("tables");
		Iterator<String> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	} catch (FileNotFoundException e) {
	} catch (IOException | ParseException e) {
	}

     }

}
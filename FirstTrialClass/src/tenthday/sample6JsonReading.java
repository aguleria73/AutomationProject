package tenthday;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample6JsonReading {

	public static void main(String[] args) {
		
		
		try {
			String sample6_path = System.getProperty("user.dir") + "/sample6.json";
			FileReader fr = new FileReader(sample6_path);
			JSONParser jp = new JSONParser();
			
			JSONObject jobj1 = (JSONObject) jp.parse(fr);
			System.out.println(jobj1.toJSONString());
			
			JSONObject jobj2 = (JSONObject) jobj1.get("menu");
			String id = (String) jobj2.get("id");
			String value1 = (String) jobj2.get("value");
			System.out.println("Menu key value:- ");
			System.out.println(id);
			System.out.println(value1);
			System.out.println("   ");
			
			JSONObject jobj3 = (JSONObject) jobj2.get("popup");
			
			JSONArray jarr1 = (JSONArray) jobj3.get("menuitem");
			System.out.println("Menu Item value:- ");
			
			for(int i = 0; i<jarr1.size(); i++)
			{
				JSONObject jobj4 = (JSONObject) jarr1.get(i);
				String value2 = (String) jobj4.get("value");
				String onclick = (String) jobj4.get("onclick");
				
				System.out.println("Values:- "+ value2 + ", " + "On click:- "+ onclick);
				System.out.println(" ");
			}
			System.out.println("  ");
		
		
		} catch (Exception e) {
			System.out.println("Error is:- " + e);
		}
		

	}
		
}

package tenthday;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample5jsonReading {

	public static void main(String[] args) {
		
		try {
			
			String sample5_path = System.getProperty("user.dir") + "/sample5.json";
			FileReader fr = new FileReader(sample5_path);
			JSONParser jp = new JSONParser();
			
			JSONArray jarr1 = (JSONArray) jp.parse(fr);
			
			for(int i =0; i<jarr1.size(); i++)
			{
				JSONObject jobj1 = (JSONObject) jarr1.get(i);
				Set<String> keys = jobj1.keySet();
				Iterator<String> it = keys.iterator();
				
				while(it.hasNext())
				{
					String keyname = it.next();
					String values = (String) jobj1.get(keyname);
					System.out.println("Key:- " + keyname + ", "+ "Value:-"+ values);
				}
				System.out.println(" ");
			}
			
		} catch (Exception e) {
			System.out.println("Error is:- " + e);
		}

	}

}

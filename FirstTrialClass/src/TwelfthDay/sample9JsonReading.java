package TwelfthDay;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample9JsonReading {

	public static void main(String[] args) {
		sample9();

	}
	
	public static void sample9() {
		
		try {
			String sample9Path = System.getProperty("user.dir") + "/sample9.json";
			FileReader fr = new FileReader(sample9Path);
			JSONParser jsnp  = new JSONParser();
			
			JSONObject jsnobj1 = (JSONObject) jsnp.parse(fr);
			JSONObject jsnobj2 = (JSONObject) jsnobj1.get("menu");
			String header = (String) jsnobj2.get("header");
			System.out.println("Header:- " + header);
			
			JSONArray jsnarr1 = (JSONArray) jsnobj2.get("items");
			
			for(int a=0; a<jsnarr1.size(); a++) 
			{
				JSONObject jsnobj3 = (JSONObject) jsnarr1.get(a);
				
				if(jsnobj3 == null) 
				{
					System.out.println("null values in array:- "+ a);
					continue;
				}
				System.out.println("  ");
	            System.out.println("Object Start " + a + ": " + jsnobj3.toJSONString());

				
				Set< String> st1 = jsnobj3.keySet();
				Iterator<String> it1 = st1.iterator();
				
				while(it1.hasNext()) 
				{
					String keyname = it1.next();
					Object values =  jsnobj3.get(keyname);
					System.out.println(keyname + " --> " + values );
				}
				
				System.out.println(" ");
				System.out.println("----Object End " + a + " ----");
//				System.out.println(" ");
			}
			
		} catch (Exception e) {
			System.out.println("Error are:- " + e);
		}
		
		
	}
	

}

package tenthday;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample4Jsonreading {

	public static void main(String[] args) {
		
		try {
			
			String sample4_path = System.getProperty("user.dir") + "/sample4.json";
			FileReader fr = new FileReader(sample4_path);
			JSONParser jp = new JSONParser();
			
			JSONObject jobj_1 = (JSONObject) jp.parse(fr);
			System.out.println(jobj_1);
			
			JSONObject jobj_2 = (JSONObject) jobj_1.get("glossary");
			System.out.println(jobj_2);
			String title1 = (String) jobj_2.get("title");
			System.out.println("  ");
			System.out.println("Glossary Title:- " + title1);
			System.out.println("  ");
			
			JSONObject jobj_3 = (JSONObject) jobj_2.get("GlossDiv");
//			System.out.println(jobj_3.toJSONString());
			String title2 = (String) jobj_3.get("title");
			System.out.println("GlossDiv Title is:- " + title2);
			System.out.println(" " );
			
			
		
			
			JSONObject jobj_4 = (JSONObject) jobj_3.get("GlossList");
			JSONObject jobj_5 = (JSONObject) jobj_4.get("GlossEntry");
			String id = (String) jobj_5.get("ID");
			String SortAs = (String) jobj_5.get("SortAs");
			String GlossTerm = (String) jobj_5.get("GlossTerm");
			String Acronym = (String) jobj_5.get("Acronym");
			String Abbrev = (String) jobj_5.get("Abbrev");
			
			System.out.println("GlossEntry ID:- " + id + " " + "GlossEntry SortAs:- " + SortAs
					+ " " + "GlossEntry GlossTerm:- " + GlossTerm + " " +"GlossEntry Acronym:- " 
					+ Acronym + " " + "GlossEntry Abbrev:- "+ Abbrev);
			System.out.println(" " );
			
			
			JSONObject jobj_6 = (JSONObject) jobj_5.get("GlossDef");
			String para = (String) jobj_6.get("para");
			System.out.println("GlossDef Para:- " + para);
			System.out.println(" " );
			
			JSONArray jarr_1 = (JSONArray) jobj_6.get("GlossSeeAlso");
			
			for(int a =0; a < jarr_1.size(); a++) 
			{
				System.out.println("Gloss See Also:- " + jarr_1.get(a));
				
			}
			System.out.println(" " );
			
			String GlossSee = (String) jobj_5.get("GlossSee");
			System.out.println("GlossSee:- " + GlossSee);
			
			
		} catch (Exception e) {
			System.out.println("Error is:- " + e);
		}
	}
}

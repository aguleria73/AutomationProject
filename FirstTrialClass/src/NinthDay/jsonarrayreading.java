package NinthDay;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonarrayreading {

	public static void main(String[] args) throws IOException, ParseException {
		
		String path = System.getProperty("user.dir") + "/sample3.json";
		
		FileReader f_read = new FileReader(path);
		JSONParser json_pars = new JSONParser();
		
		JSONArray j_arr = (JSONArray) json_pars.parse(f_read);
		System.out.println(j_arr.toJSONString());
		
//		JSONObject j_obj = (JSONObject) j_arr.get(0);
//		System.out.println(j_obj.toJSONString());
		System.out.println(" ");
		
		for(int i=0; i<j_arr.size();i++) 
		{
			JSONObject j_obj = (JSONObject) j_arr.get(i);
			System.out.println(j_obj.toJSONString());
			
			
			String firstname = (String) j_obj.get("first_name");
			System.out.println("First Name is:- " + firstname);
			
			String lastname = (String) j_obj.get("last_name");
			System.out.println("Last Name is:- " + lastname);
			
			String email = (String) j_obj.get("email");
			System.out.println("Email is:- " + email);
			System.out.println(" " );
		}
				
		
		
	}

}

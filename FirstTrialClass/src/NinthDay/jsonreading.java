package NinthDay;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonreading {

	public static void main(String[] args) throws IOException, ParseException {
		
		String jsonpath = System.getProperty("user.dir")+ "/sample1.json";
		
		FileReader freader = new FileReader(jsonpath); // Reading json file data
		
		JSONParser jsonp = new JSONParser();  
		
		JSONObject jsonobj = (JSONObject) jsonp.parse(freader); // Convert data into java object (json object & json array)
		System.out.println(jsonobj.toJSONString());
		
		String size1 = (String) jsonobj.get("color");
		System.out.println("Color Name:- " + size1);
		
		System.out.println(jsonobj.get("price"));

	}

}

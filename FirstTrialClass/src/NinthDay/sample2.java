package NinthDay;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class sample2 {

	public static void main(String[] args) throws IOException, ParseException {
		String sample2 = System.getProperty("user.dir") + "/sample2.json";
		System.out.println(sample2);
		
		FileReader fr = new FileReader(sample2);
		JSONParser jp = new JSONParser();
		
		JSONObject jn_obj = (JSONObject) jp.parse(fr); 
		System.out.println(jn_obj.toJSONString());
		
		String fname = (String) jn_obj.get("firstName");
		String lname = (String) jn_obj.get("lastName");
		String age = (String) jn_obj.get("age");
		String gender = (String) jn_obj.get("gender");
		
		System.out.println(" ");
		System.out.println("First Name:- " + fname + ", " + "Last Name:- " 
				+ lname + ", " + "Age:-" + age + ", " + "Gender:- " + gender );
		System.out.println(" ");
		
		JSONObject jn_obj2 = (JSONObject) jn_obj.get("address");
		
		String streetAddress = (String) jn_obj2.get("streetAddress");
		String city = (String) jn_obj2.get("city");
		String state = (String) jn_obj2.get("state");
		String pincode = (String) jn_obj2.get("pincode");
		
		System.out.println("Street Address:- " + streetAddress + ", " + "City:- " 
				+ city + ", " + "State:-" + state + ", " + "Pin Code:- " + pincode );
		System.out.println(" ");
		
		
		JSONArray jn_arr1 = (JSONArray) jn_obj.get("phoneNumbers");
		
		System.out.println(" Phone numbers");
		for(int a = 0; a < jn_arr1.size(); a++) 
		{
			JSONObject jn_obj3 = (JSONObject) jn_arr1.get(a);
			String number = (String) jn_obj3.get("number");
			String type = (String) jn_obj3.get("type");
			
			
			System.out.println("Number:- " + number + " " + "Type:- " + type);
		}
		System.out.println("  ");
		System.out.println(" Private Phone numbers");
		
		
		JSONArray jn_arr2 = (JSONArray) jn_obj.get("phoneNumbersPrivate");
		for(int b=0; b<jn_arr2.size(); b++) 
		{
			JSONObject jn_obj4 = (JSONObject) jn_arr2.get(b);
			
			String number = (String) jn_obj4.get("number");
			String type = (String) jn_obj4.get("type");
			
			System.out.println("Private Number:- " + number + " " + "Private Type:- " + type);
			
			
		}
		

	}

}

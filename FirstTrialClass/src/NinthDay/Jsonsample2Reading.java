package NinthDay;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Jsonsample2Reading {

	public static void main(String[] args) throws IOException, ParseException {
		
		String sample2_path = System.getProperty("user.dir") + "/sample2.json";
		
		FileReader sample2_reader = new FileReader(sample2_path);
		JSONParser sample2_json_pars = new JSONParser();
		
		JSONObject sample2_jsonobj = (JSONObject) sample2_json_pars.parse(sample2_reader);
		
		System.out.println(sample2_jsonobj.toJSONString());
		
		String first_name = (String) sample2_jsonobj.get("firstName");
		String last_name = (String) sample2_jsonobj.get("lastName");
		String age = (String) sample2_jsonobj.get("age");
		String gender = (String) sample2_jsonobj.get("gender");
		
		System.out.println("  ");
		System.out.println("First name:- " + first_name);
		System.out.println("Last name:- " + last_name);
		System.out.println("Age:- " + age);
		System.out.println("Gender:- " + gender);
		System.out.println("  ");
		
		JSONObject address_jsonobj = (JSONObject) sample2_jsonobj.get("address");
		
		String streetAddress = (String)address_jsonobj.get("streetAddress");
		String city = (String)address_jsonobj.get("city");
		String state = (String)address_jsonobj.get("state");
		String pincode = (String) address_jsonobj.get("pincode");
		
		System.out.println("***** Address *****");
		System.out.println("Street Address:- " + streetAddress);
		System.out.println("City:- " + city);
		System.out.println("State:- " + state);
		System.out.println("Pin Code:-" + pincode);
		System.out.println("   ");
		
		
		
		JSONArray jsonarr_phoneNumbers = (JSONArray) sample2_jsonobj.get("phoneNumbers");
		//System.out.println(jsonarr_phoneNumbers.toJSONString());
		
		System.out.println("***** Phone Numbers are *****");
		
		for(int phonenumber = 0; phonenumber < jsonarr_phoneNumbers.size(); phonenumber++) 
		{
			
		JSONObject jsonobj_numberType1 = (JSONObject) jsonarr_phoneNumbers.get(phonenumber);
		//System.out.println(jsonobj_numberType1.toJSONString());
		
		System.out.println("---- Numbers 1 and Type 1 are ----");
		String number1 = (String) jsonobj_numberType1.get("number");
		String type1 = (String) jsonobj_numberType1.get("type");
		
		System.out.println("Number:- " + number1);
		System.out.println("Type:- " + type1);
		System.out.println("    ");
		}

		JSONArray jsonArr_phoneNumbersPrivate = (JSONArray) sample2_jsonobj.get("phoneNumbersPrivate");
//		System.out.println(jsonArr_phoneNumbersPrivate.toJSONString());
		System.out.println("***** Phone Numbers Private are *****");
		
		for(int phoneNumbersPrivate =0; phoneNumbersPrivate<jsonArr_phoneNumbersPrivate.size(); phoneNumbersPrivate++) 
		{
			JSONObject jsonobj_numberType2 = (JSONObject) jsonArr_phoneNumbersPrivate.get(phoneNumbersPrivate);
//			System.out.println(jsonobj_numberType2.toJSONString());
			
			System.out.println("---- Numbers 2 and Type 2 are ----");
			String number2 = (String) jsonobj_numberType2.get("number");
			String type2 = (String) jsonobj_numberType2.get("type");
			
			System.out.println("Number:-" + number2);
			System.out.println("Type:-" + type2);
			System.out.println("  ");
		}
		

	}
	

}

package NinthDay;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class creatingJson {

	public static void main(String[] args) {
		
		JSONObject json1 = new JSONObject();
		json1.put("first_name", "Ashish");
		json1.put("last_name", "Guleria");
		json1.put("age", 30);
		json1.put("email", "aguleria73@gmail.com");
		json1.put("is_active", true);
		System.out.println(json1.toJSONString());
		System.out.println("   ");
		
		JSONObject json2 = new JSONObject();
		json2.put("first_name", "Deepak");
		json2.put("last_name", "Rana");
		json2.put("age", 25);
		json2.put("email", "deepak@gmail.com");
		json2.put("is_active", false);
		System.out.println(json2.toJSONString());
		System.out.println("   ");
		
		
		
		JSONArray jsonarr1 = new JSONArray();
		jsonarr1.add(json1);
		jsonarr1.add(json2);
		System.out.println(jsonarr1.toJSONString());

		
		
	}

}

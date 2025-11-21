package TwelfthDay;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample8JsonReading {

	public static void main(String[] args) {
		sample8();

	}
	
	public static void sample8() {
		
		try {
		String sample8_path = System.getProperty("user.dir") + "/sample8.json";
		FileReader fr = new FileReader(sample8_path);
		JSONParser jsnpar = new JSONParser();
		JSONObject jsnobj1 = (JSONObject) jsnpar.parse(fr);
		
		JSONObject jsnobj2 = (JSONObject)jsnobj1.get("web-app");
		JSONArray jsnarr1 = (JSONArray) jsnobj2.get("servlet");
		
		System.out.println("--- servlet array of object values Start ---");
		
		for(int a = 0; a<jsnarr1.size(); a++) 
		{
			JSONObject jsnobj3 = (JSONObject) jsnarr1.get(a);
//			System.out.println(jsnobj3.toJSONString());
			String servlet_name = (String) jsnobj3.get("servlet-name");
			String servlet_class = (String) jsnobj3.get("servlet-class");
			System.out.println("Servlet-name:-" + servlet_name + "," + " " + "Servlet-class" + servlet_class);
			System.out.println("  ");
			
			JSONObject jsnobj4 = (JSONObject) jsnobj3.get("init-param");
//			System.out.println(jsnobj4.toJSONString());
			
			if(jsnobj4 != null) {
				System.out.println("init-param start:- " + a);
				System.out.println(" ");
				
				Set<String> st = jsnobj4.keySet();
				Iterator<String> it = st.iterator();
				
				while(it.hasNext()) {
					String key = it.next();
					Object values = jsnobj4.get(key);
					System.out.println("Key:- " + key + " ---> "+ "  "+ "Value:- "+ values);
				}
			} 
			System.out.println(" ");
			System.out.println("init-param End:- " + a);
			System.out.println(" ");
			System.out.println("--- servlet array of object values End ---");
			System.out.println(" ");
			

			JSONObject jsnobj5 = (JSONObject) jsnobj2.get("servlet-mapping");
			System.out.println("--- servlet-mapping Start---"+a);
			Set<String> st1 = jsnobj5.keySet();
			Iterator<String> it1 = st1.iterator();
			while(it1.hasNext())
			{
				String key1 = it1.next();
				String values1 = (String) jsnobj5.get(key1);
				
				System.out.println("Key:- " + key1 + " ---> "+ "  "+ "Value:- "+ values1);
				
			}
		
//			System.out.println(" ");
			System.out.println("--- servlet-mapping End---"+a);
			System.out.println(" ");
		}
		
		System.out.println("--- taglib Start---");
		JSONObject jsnobj6 = (JSONObject) jsnobj2.get("taglib");
		Set<String> st2 = jsnobj6.keySet();
		Iterator<String> it2 = st2.iterator();
		while(it2.hasNext()) 
		{
			String key2 = it2.next();
			String values2 = (String) jsnobj6.get(key2);
			System.out.println("Key:- " + key2 + " ---> "+ "  "+ "Value:- "+ values2);
		}
		
		System.out.println(" ");
		System.out.println("--- taglib End---");
		System.out.println(" ");
		
		
		} catch (Exception e) {
			System.out.println("Error of sample 7 " + e);
		}
	}

}

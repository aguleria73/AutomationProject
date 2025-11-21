package TwelfthDay;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample10JsonReading {

	public static void main(String[] args) {
		sample10();

	}

	public static void sample10() {
		
		try {
			String sample10path = System.getProperty("user.dir")+ "/sample10.json";
			FileReader fr = new FileReader(sample10path);
			JSONParser jsnpar = new JSONParser();
			JSONObject jsnobj1 = (JSONObject) jsnpar.parse(fr);
			
			JSONObject jsnobj2 = (JSONObject) jsnobj1.get("widget");
			String debug = (String) jsnobj2.get("debug");
			System.out.println("Debug:- " + debug);
			System.out.println("  ");
			
			
			JSONObject jsnobj3 = (JSONObject) jsnobj2.get("window");
			String title = (String) jsnobj3.get("title");
			String name = (String) jsnobj3.get("name");
			Long width = (Long) jsnobj3.get("width");
			Long height = (Long) jsnobj3.get("height");
			
			System.out.println("Title:- " + title);
			System.out.println("name:- " + name);
			System.out.println("width:- " + width);
			System.out.println("height:- " + height);
			System.out.println(" ");
			System.out.println("Window Object close");
			System.out.println(" ");
			
			
			JSONObject jsnobj4 = (JSONObject) jsnobj2.get("image");
			String src = (String) jsnobj4.get("src");
			String name1 = (String) jsnobj4.get("name");
			Long hOffset = (Long) jsnobj4.get("hOffset");
			Long vOffset = (Long) jsnobj4.get("vOffset");
			String alignment = (String) jsnobj4.get("alignment");
			
			System.out.println("Src:- " + src);
			System.out.println("Name:- " + name1);
			System.out.println("hOffset:- " + hOffset);
			System.out.println("vOffset:- " + vOffset);
			System.out.println("alignment:- " + alignment);
			System.out.println(" ");
			System.out.println("image Object close");
			System.out.println(" ");
			
				 
			JSONObject jsnobj5 = (JSONObject) jsnobj2.get("text");
			String data = (String) jsnobj5.get("data");
			Long size = (Long) jsnobj5.get("size");
			String style = (String) jsnobj5.get("style");				
			String name3 = (String) jsnobj5.get("name");
			Long hOffset1 = (Long) jsnobj5.get("hOffset");
			Long vOffset1 = (Long) jsnobj5.get("vOffset");
			String alignment1 = (String) jsnobj5.get("alignment");
			String onMouseUp = (String) jsnobj5.get("onMouseUp");
			
					
			System.out.println("data:- " + data);
			System.out.println("size:- " + size);
			System.out.println("Name:- " + name3);
			System.out.println("style:- " + style);
			System.out.println("hOffset:- " + hOffset1);
			System.out.println("vOffset:- " + vOffset1);
			System.out.println("alignment:- " + alignment1);
			System.out.println("onMouseUp:- " + onMouseUp);
			System.out.println(" ");
			System.out.println("Text Object close");
		
		} catch (Exception err) 
		{
			System.out.println("Error is" + err);
		}
		
		
	}
}

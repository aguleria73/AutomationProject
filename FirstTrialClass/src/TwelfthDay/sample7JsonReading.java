package TwelfthDay;

import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class sample7JsonReading {

	public static void main(String[] args) {
		sample7();

	}
	
	public static void sample7() 
	{
		try {
			
			String sample7_path = System.getProperty("user.dir") + "/sample7.json";
			
			
			FileReader fr = new FileReader(sample7_path);
			JSONParser jsnpar = new JSONParser();
			
			JSONObject jsnobj1 = (JSONObject) jsnpar.parse(fr);
			
			JSONObject jsnobj2 = (JSONObject) jsnobj1.get("widget");
			String debug = (String) jsnobj2.get("debug");
			System.out.println("----Widget object value are----");
			System.out.println("Widget:- "+ debug);
			System.out.println("   ");
			
			JSONObject jsnobj3 = (JSONObject) jsnobj2.get("window");
		      
		    String title = (String) jsnobj3.get("title");
			String name1 = (String) jsnobj3.get("name");

			// for geting integer value
			Long width = (Long) jsnobj3.get("width"); 
			Long height = (Long) jsnobj3.get("height");
			
			//for geting integer value
//			int width = ((Long) jsnobj3.get("width")).intValue(); 
//			int height = ((Long) jsnobj3.get("height")).intValue();
			
			System.out.println("---Window object value----");
			System.out.println("Title:- " + title + "," + " "+ "name:- " + name1);
			System.out.println("Width:- " + width + " " + "Height:- " + height);
			System.out.println("   ");
			
			JSONObject jsnobj4 = (JSONObject) jsnobj2.get("image");
			System.out.println("----Image object values are----");
			
			String src = (String) jsnobj4.get("src");
			String name2 = (String) jsnobj4.get("name");
			Long hOffset = (Long) jsnobj4.get("hOffset");
			Long vOffset = (Long) jsnobj4.get("vOffset");
			String alignment = (String) jsnobj4.get("alignment");
			
			System.out.println("Src:- " + src + ", " + " " + "Name:- " + name2 + "," + " " + "hOffset:- " 
					+ hOffset + ", " + " " + "vOffset:- " + vOffset + ", " + " " + "Alignment:- " + alignment);
			System.out.println("   ");
			
			
			JSONObject jsnobj5 = (JSONObject) jsnobj2.get("text");
			System.out.println("----Text object values are----");
			
			String data = (String) jsnobj5.get("data");
			Long size = (Long) jsnobj5.get("size");
			String style = (String) jsnobj5.get("style");
			String name3 = (String) jsnobj5.get("name");
			Long hOffset2 = (Long) jsnobj5.get("hOffset");
			Long vOffset2 = (Long) jsnobj5.get("vOffset");
			String alignment2 = (String) jsnobj5.get("alignment");
			String onMouseUp = (String) jsnobj5.get("onMouseUp");
			
			System.out.println("Data:- " + data + ", " + " " + "Size:- " + size + "," + " " + 
					"Style:- " + style + ", "+ " "+ "Name:- "+ name3 +"," + " " + "hOffset:- " 
					+ hOffset2 + ", " + " " + "vOffset:- " + vOffset2);
			
			System.out.println("Alignment:- " + alignment2 + "," + " "+ "onMouseUp:- " + onMouseUp);
			
			
		} catch (Exception e) {
			System.out.println("Error of sample 7 " + e);
		}
		
		
		
	}

}

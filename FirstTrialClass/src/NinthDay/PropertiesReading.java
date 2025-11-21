package NinthDay;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReading {

	public static void main(String[] args) throws IOException {
		
		//System.out.println(System.getProperty("user.dir")); // getting path of property file
		
		String propertyPath = System.getProperty("user.dir") + "/PropertyFile.properties";
		Properties props = new Properties();
		
		FileInputStream fis = new FileInputStream(propertyPath); // Read data (in bytes) from a file
		props.load(fis); // loading the property file
		
		System.out.println(props.getProperty("username"));
		System.out.println(props.getProperty("password"));
		System.out.println(props.getProperty("url"));
		

		
//		try {
//			
//		} catch (Exception e) {
//			System.out.println("Error is:-" + e.toString());
//		}
	}

}

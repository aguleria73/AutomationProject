package listener;

import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		
		Date date = new Date();
		String PathDate = date.toString().replaceAll(":", "_").replaceAll(" ", "_");
		System.out.println(PathDate);
		

	}

}

package TwentyTwoDay;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateUser {
	
	@Test (dataProvider = "GetData")
	public void createUser(String Browser, String UserType, String email, int phonenumber) {
		
		System.out.println(Browser);
		System.out.println(UserType);
		System.out.println(email);
		System.out.println(phonenumber);
		System.out.println("--------- ");
		
	}
	
	@DataProvider
	public Object[][] GetData() {
		
		Object[][] ObjectData = new Object [3][4]; // [row][column]
		
		ObjectData[0][0] = "Chrome";
		ObjectData[0][1] = "Admin";
		ObjectData[0][2] = "admin@gmail.com";
		ObjectData[0][3] = 987654321;
		
		ObjectData[1][0] = "FireFox";
		ObjectData[1][1] = "SuperAdmin";
		ObjectData[1][2] = "superadmin@gmail.com";
		ObjectData[1][3] = 987654321;
		
		ObjectData[2][0] = "Safari";
		ObjectData[2][1] = "Member";
		ObjectData[2][2] = "member@gmail.com";
		ObjectData[2][3] = 987654321;
		
		return ObjectData;
		
	}

}

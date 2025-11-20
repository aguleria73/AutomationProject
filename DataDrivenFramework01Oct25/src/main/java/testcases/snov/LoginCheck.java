package testcases.snov;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginCheck {

	@Test(dataProvider = "getData")
	public void login(String userName, String password)
	{
		System.out.println(userName + " - " + password);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] ="u1";
		data[0][1] ="p1";
		
		data[1][0] ="u2";
		data[1][1] ="p2";
		
		data[2][0] ="u3";
		data[2][1] ="p3";
		
		return data;
	}
	
	@Test
	public void verifyLogin() 
	{
		System.out.println("Verifing login");
	} 
}

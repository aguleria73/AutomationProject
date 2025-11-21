package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void login() {
		
		String ExpectedResult = "One";
		String ActualResult = "Two";
		
//		Assert.assertEquals(ActualResult, ExpectedResult);
//		System.out.println("This line will NOT execute if assert fails");
		Assert.fail(" ---------- A ------------ ");
		Assert.fail("Test case failed");
		Assert.fail(" ---------- B ------------ ");
	}
	
	
	
}

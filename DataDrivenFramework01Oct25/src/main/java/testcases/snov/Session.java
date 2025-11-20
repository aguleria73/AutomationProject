package testcases.snov;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


import testbase.BaseTest;

public class Session extends BaseTest{

	@Test
	public void doLogin(ITestContext context) throws InterruptedException 
	{
		System.out.println("In do-Login");
		
//		ApplicationKeywords app = (ApplicationKeywords) context.getAttribute("app");
		app.openExistingBrowser("Chrome");
		app.navigates("url");
		Thread.sleep(1000);
//		app.click("email_xpath");
//		app.clearText("email_xpath");
//		app.type("email_xpath", "guleriaa22@gmail.com");
//		app.click("password_xpath");
//		app.clearText("password_xpath");
//		app.type("password_xpath", "Ashish@123");
//		app.click("nextButton_xpath");
//		Thread.sleep(1000);
		
		boolean userNameResult = app.validateText("expectedTextOfUserName", "actualTextOfUserName_xpath");
		if(!userNameResult) 
		{
			System.out.println("UserName Text is not matched");
			Assert.fail();
		} else 
		{
			System.out.println("UserName Text is matched");
		}
		
		
	}
}

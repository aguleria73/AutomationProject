package testcases.snov;

import org.testng.annotations.Test;

import Keywords.ApplicationKeywords;

public class CreateLead extends ApplicationKeywords{

	@Test
	public void createLead() throws InterruptedException {
		
		
		// calling function through extends the class
		openExistingBrowser("chrome");
		navigates("https://app.snov.io/");
		
		String emailXpath ="//*[@id='app']/div/div/div/div[2]/div[1]/div/div/div[2]/form/div[1]/input";
		click(emailXpath);
		type(emailXpath, "aguleria73@gmail.com");
		
		String showHideXpath = "//*[@id='app']/div/div/div/div[2]/div[1]/div/div/div[2]/form/div[2]/div";
		click(showHideXpath);
		
		String passwordXpath = "//*[@id='app']/div/div/div/div[2]/div[1]/div/div/div[2]/form/div[2]/input";
		click(passwordXpath);
		type(passwordXpath, "123456");
		
		clearText(emailXpath);
		clearText(passwordXpath);
		
//		String loginButtonXpath = "//*[@id='app']/div/div/div/div[2]/div[1]/div/div/div[2]/form/button";
//		click(loginButtonXpath);
	}
	
}

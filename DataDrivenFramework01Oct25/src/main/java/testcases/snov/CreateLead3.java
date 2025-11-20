package testcases.snov;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Keywords.ApplicationKeywords;
import testbase.BaseTest;

public class CreateLead3 extends BaseTest {
	
	@Test
	public void Lead2(ITestContext context) throws InterruptedException {

		// Calling function by object Reference
		
//		ApplicationKeywords appkeywords = new ApplicationKeywords();
//		appkeywords.openExistingBrowser("Chrome");
//		appkeywords.navigates("url"); // getting data from property file
//		Thread.sleep(1000);
		System.out.println("In Lead2");
		
//		appkeywords.click("email_xpath");
//		appkeywords.clearText("email_xpath");
//		appkeywords.type("email_xpath", "guleriaa22@gmail.com"); // getting data from property file
//
//		appkeywords.click("password_xpath");
//		appkeywords.clearText("password_xpath");
//		appkeywords.type("password_xpath", "Ashish@123"); // getting data from property file
//		
//		appkeywords.click("nextButton_xpath"); // getting data from property file
//		Thread.sleep(3000);
		
		boolean result = app.validateText("expectedTextOfUserName", "actualTextOfUserName_xpath");
		if(!result) 
		{
			System.out.println("User name Text is not found:- FAILED");
			Assert.fail();
		} else 
		{
			System.out.println("User name text matched");
		}
			
//		boolean result = appkeywords.validateElementPresent("actualTextOfUserName_xpath");
//		if(!result) 
//		{
//			System.out.println("Text is not found:- So Test case is FAILED");
//			Assert.fail();
//		} 
//		else 
//		{
//			System.out.println("Test Case pass");
//		}
//		
		
//		Thread.sleep(1500);
		app.moveToElements("dealsButton_xpath");
		app.click("deals_xpath");
		
//		Thread.sleep(1500);
		boolean resultOfDealText = app.validateText("expectedDealText", "acutalDealText_xpath");
		if(!resultOfDealText) 
		{
			System.out.println("Deal text is not found:- FAILED");
			Assert.fail();
		}
		else 
		{
			System.out.println("Deal text matched");
		}
		
		app.click("dealCreateButton_xpath");
		Thread.sleep(1500);
		app.type("dealName_xpath", "Test create deal");
		
		app.moveToElements("pipelineNeedsDefined_xpath");
		app.click("pipelineNeedsDefined_xpath");
		
		app.moveToElements("valueEditMoveToElement_xpath");
		app.click("valueEditIcon_xpath");
		
//		Thread.sleep(1000);
		app.click("valueCurrencyDropdownIcon_xpath");
//		appkeywords.type("valueCurrencyDropdownSearch_xpath", "Indian");
		Thread.sleep(1000);
		app.selectCurrency("valueCurrencyDropdownData_xpath", "Indian Rupee (INR)");
//		appkeywords.type("enterValue_xpath", "20");
		
		
//		appkeywords.type("prospectName_xpath", "Create first deal");
//		appkeywords.click("prospectList_xpath");
//		appkeywords.click("prospectListValue_xpath");
//		appkeywords.click("saveButton_xpath");
		
	}

}

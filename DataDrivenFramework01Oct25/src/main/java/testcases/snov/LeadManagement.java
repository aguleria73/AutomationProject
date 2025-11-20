package testcases.snov;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import testbase.BaseTest;

public class LeadManagement extends BaseTest{

	@Test
	public void createLead(ITestContext context) throws InterruptedException 
	{
		System.out.println("In Create lead");
		
//		ApplicationKeywords app = (ApplicationKeywords) context.getAttribute("app");
		// now object is created in before method in BaseTest class
		
		JSONObject data = (JSONObject) context.getAttribute("data");
		
		String currency = (String) data.get("currency");
		String value = (String) data.get("value");
		String prospectname = (String) data.get("prospectname");
		String email = (String) data.get("email");
		String prospectlist = (String) data.get("prospectlist");
		
		app.moveToElements("dealsButton_xpath");
		app.click("deals_xpath");
		
		boolean dealTextResult = app.validateText("expectedDealText", "acutalDealText_xpath");
		if(!dealTextResult) 
		{
			System.out.println("Deal Text is not found");
			Assert.fail();
		} else 
		{
			System.out.println("Deal text is found");
		}
		
		app.click("dealCreateButton_xpath");
		Thread.sleep(1500);
//		app.type("dealName_xpath", "Deal creating one");
		
		app.moveToElements("valueEditMoveToElement_xpath");
		app.click("valueEditIcon_xpath");
		app.click("valueCurrencyDropdownIcon_xpath");
		Thread.sleep(1500);
//		app.selectCurrency("valueCurrencyDropdownData_xpath", "Indian Rupee (INR)");
		app.selectCurrency("valueCurrencyDropdownData_xpath", currency);
//		app.type("enterValue_xpath", "100");
		app.type("enterValue_xpath", value);
		
//		app.type("prospectName_xpath", "Create deal 2");
		app.type("prospectName_xpath", prospectname);
		app.click("prospectList_xpath");
//		app.click("prospectListValue_xpath");
		app.selectProspect("prospectListDropdown_xpath", "Prospect list");
		
		
		
		app.click("saveButton_xpath");
		Thread.sleep(1500);
		app.click("afterDealCreatedClickOnDeal_xpath");
		
		app.reportFailure("Some non critical failure 1", false);
		app.reportFailure("Some non critical failure 2", false);
		app.reportFailure("Some non critical failure 3", true);
		app.assertAll();
	} 
	
	@Test
	public void verifyLead(ITestContext context) 
	{
		System.out.println("In verify lead");
//		ApplicationKeywords app = (ApplicationKeywords) context.getAttribute("app");
		// now object is created in before method
		boolean createdDealText  = app.validateText("expectedTextOfCreatedDeal", "actualTextOfCreatedDeal_xpath" );
		if(!createdDealText)
		{
			System.out.println("Created Deal Text is not MATCHED");
			Assert.fail();
		} else
		{
			System.out.println("Created Deal Text is MATCHED");
		}
		
		
	}
	
	
	@Test
	public void deleteLead(ITestContext context) 
	{
		System.out.println("In Delete lead");
	}
	
	
}

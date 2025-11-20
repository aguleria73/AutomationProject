package Keywords;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ApplicationKeywords extends ValidationKeyword {
	
	public ApplicationKeywords() {
		String path = System.getProperty("user.dir") + "/src/test/resources/env.properties";
//		System.out.println(path);
		System.out.println(" ");
		prop = new Properties();
		envProp = new Properties();
		try 
		{
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			String environment = prop.getProperty("environment");
//			System.out.println(environment);
			path = System.getProperty("user.dir") + "/src/test/resources/" + environment + ".properties";
			System.out.println(" ");
//			System.out.println(path);
			fis = new FileInputStream(path);
			envProp.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Error in property file:- ");
			e.printStackTrace(); // print error in detail on console
		}
//		String gettingURL = envProp.getProperty("url");
//		System.out.println(gettingURL);
		softAssert = new SoftAssert();
	}

	public void login() {
		
	}
	
	public void selectDateFromCalender() {
		
	}
	public void selectCurrency(String locatorKey, String selectData) {
		test.log(Status.INFO, "Selecting Currency value :- "+ locatorKey + " " + "Selected Currency " + selectData);
		try {
			WebElement allData = driver.findElement(getLocatorKey(locatorKey));
			List<WebElement> list = allData.findElements(By.tagName("li"));
			for (int a=1; a<=list.size(); a++) 
			{
				WebElement getCurrency = list.get(a);
				String text = getCurrency.getText().trim();
				if (text.equals(selectData))
				{
					getCurrency.click();
					System.out.println("Selected currency: " + text);
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error in:- " + e);
		}
	}
	
	public void selectProspect(String locatorKey, String selectData) {
		test.log(Status.INFO, "Selecting prospect value :- "+ locatorKey + " " + "Selected prospect " + selectData);
		try {
			WebElement allData = driver.findElement(getLocatorKey(locatorKey));
			List<WebElement> list = allData.findElements(By.tagName("li"));
			for (int a=0; a<list.size(); a++) 
			{
				WebElement getProspect = list.get(a);
				String text = getProspect.getText().trim();
				if (text.equals(selectData))
				{
					getProspect.click();
					System.out.println("Selected prospect: " + text);
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error in:- " + e);
		}
	}
	
	public void setReport(ExtentTest test) 
	{
		this.test = test;
	}
}

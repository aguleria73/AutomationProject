package TestCases.suiteA;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reports.ExtentManager;

public class LoginTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void ForReport() {
		
		reports = ExtentManager.getReports();
		test = reports.createTest("Login Test");
		
	}
	
	@AfterTest
	public void quit() {
		
		reports.flush();
	}
	
	@Test
	public void login() {
		
		test.log(Status.INFO, "Starting login test");
		test.log(Status.INFO, "Opening Browser");

		String ExpectedResult = "One";
		String ActualResult = "Two";
		
//		Assert.assertEquals(ActualResult, ExpectedResult);
//		System.out.println("This line will NOT execute if assert fails");
//		Assert.fail(" ---------- A ------------ ");
		System.out.println(" ---------- A ------------ ");
//		Assert.fail("Test case failed");
//		Assert.fail(" ---------- B ------------ ");
		System.out.println(" ---------- B ------------ ");
		
		test.addScreenCaptureFromPath("/Users/apple/Downloads/WhatsApp Image 2025-08-05 at 10.21.30.jpeg","Screenshot Pass");
		test.log(Status.PASS, "Test case login pass"); 
//		reports.flush();
		
	
	}
	
	
}

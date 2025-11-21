package TestCases.suiteA;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reports.ExtentManager;

public class CreateUser {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void ForReport() {
		
		reports = ExtentManager.getReports();
		test = reports.createTest("Create user Test");
		
	}
	
	@AfterTest
	public void quit() {
		
		reports.flush();
	}
	
	
	@Test (dataProvider = "GetData")
	public void createUser(String Browser, String UserType, String email, int phonenumber) {
		
		test.log(Status.INFO, "Enter in create user");
		test.log(Status.INFO, Browser +" "+ UserType+" "+ email +" "+ phonenumber );
//		System.out.println(Browser);
//		System.out.println(UserType);
//		System.out.println(email);
//		System.out.println(phonenumber);
		System.out.println("--------- ");
		test.log(Status.PASS, "Test case Create user pass");
		
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

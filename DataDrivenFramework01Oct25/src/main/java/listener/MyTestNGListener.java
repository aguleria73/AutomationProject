package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyTestNGListener implements ITestListener {
	
	public void onTestFailure(ITestResult results) {
		
		System.out.println("On Test failure");
		System.out.println(" ------- ");
		System.out.println(" ");
		System.out.println(results.getThrowable().getMessage());
		ExtentTest test = (ExtentTest) results.getTestContext().getAttribute("test");
		test.log(Status.FAIL, results.getThrowable().getMessage());
	}
	
	public void onTestSuccess(ITestResult results) {
		
		System.out.println("On test Success");
		System.out.println(" ++++++++ ");
		System.out.println(" ");
		ExtentTest test = (ExtentTest) results.getTestContext().getAttribute("test");
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestStart(ITestResult results) {
		System.out.println("On test Start");
		System.out.println(" ******* ");
		System.out.println(" ");
		
	}
	
	public void onTestSkip(ITestResult results) {
		System.out.println("On test Skip");
		System.out.println(" !!!!!!!!! ");
		System.out.println(" ");
		ExtentTest test = (ExtentTest) results.getTestContext().getAttribute("test");
		test.log(Status.SKIP, results.getName()+ " - Test Skipped");
	}

}

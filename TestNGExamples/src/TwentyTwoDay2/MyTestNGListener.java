package TwentyTwoDay2;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestNGListener implements ITestListener {
	
	public void onTestFailure(ITestResult results) {
		
		System.out.println("On Test failure");
		System.out.println(" ------- ");
		System.out.println(" ");
	}
	
	public void onTestSuccess(ITestResult results) {
		
		System.out.println("On test Success");
		System.out.println(" ++++++++ ");
		System.out.println(" ");
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
	}

}

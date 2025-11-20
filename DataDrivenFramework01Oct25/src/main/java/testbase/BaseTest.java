package testbase;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Keywords.ApplicationKeywords;
import Reports.ExtentManager;
import runner.DataUtil;
import runner.ReadingXLS;

public class BaseTest {

	public ApplicationKeywords app;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context) throws NumberFormatException, IOException, ParseException 
	{
		System.out.println(" ---- Before Test Start ---- ");
		String dataFlag = context.getCurrentXmlTest().getParameter("dataflag");
		String datafilepath = context.getCurrentXmlTest().getParameter("datafilepath");
		String iteration = context.getCurrentXmlTest().getParameter("iteration");
		String suitename = context.getCurrentXmlTest().getParameter("suitename");
		
		System.out.println("dataFlag:- " + dataFlag);
		System.out.println("datafilepath:- " + datafilepath);
		System.out.println("iteration:- " + iteration);
		System.out.println("suitename:- " + suitename);

		// for json file
//		JSONObject data = new DataUtil().getTestData(datafilepath, dataFlag, Integer.parseInt(iteration));
		
		// for excel file
		JSONObject data = new ReadingXLS().getTestData(suitename, dataFlag, Integer.parseInt(iteration) +1, datafilepath);
		System.out.println("Base Test Data for Excel:- " + data.toJSONString());
		
		System.out.println("------ One-------" + data.toJSONString());
		String runmode = (String) data.get("runmode");
		context.setAttribute("data", data);
		
		
		
		app = new ApplicationKeywords(); // 1 app keyword object for entire test
		context.setAttribute("app", app);
		report = ExtentManager.getReport();
		test = report.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting Test" + context.getCurrentXmlTest().getName());
		context.setAttribute("report", report);
		context.setAttribute("test", test);
		System.out.println("------ 1 line ------ ");
		if(runmode.equals("N")) 
		{
			System.out.println("------ 2 line ------ ");
			test.log(Status.SKIP, "Skipping test as data runmode is N");
			throw new SkipException("Skipping test as data runmode is N");
		}
		app.setReport(test);
		System.out.println("------ 3 line ------ ");
//		context.setAttribute("report", report);
//		context.setAttribute("test", test);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) 
	{
		System.out.println("  ");
		System.out.println(" ---- Before Method Start ---- ");
		app = (ApplicationKeywords) context.getAttribute("app");
		report = (ExtentReports) context.getAttribute("report");
		test = (ExtentTest) context.getAttribute("test");
	}
	
	@AfterTest
	public void quit(ITestContext context)
	{
		System.out.println("-----------After Test----------");
		app = (ApplicationKeywords) context.getAttribute("app");
		if(app!= null) 
		{
			app.quit();
		}
		
		report = (ExtentReports) context.getAttribute("report");
		
		if (report!= null) 
		{
			report.flush();
		}
			
	}
	
}

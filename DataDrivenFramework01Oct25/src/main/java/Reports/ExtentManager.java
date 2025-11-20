package Reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	static ExtentReports reports;
	public static String screenshotFolderPath;
	

	public static ExtentReports getReport() 
	{
		if(reports == null) 
		{
		String path = System.getProperty("user.dir");
		Date date = new Date();
		String replaceDate = date.toString().replace(" ", "_").replace(":", "_");
		reports = new ExtentReports();
		ExtentSparkReporter sparkReports = new ExtentSparkReporter(path + "/Reports/" + replaceDate + "/");
		screenshotFolderPath =  path + "/Reports/" + replaceDate + "/Screenshot";
		File file = new File(screenshotFolderPath);
		file.mkdirs();
		sparkReports.config().setReportName("Automation Testing Reports");
		sparkReports.config().setDocumentTitle("Automation Testing");
		reports.attachReporter(sparkReports);
		}
		
		return reports;
	}

}

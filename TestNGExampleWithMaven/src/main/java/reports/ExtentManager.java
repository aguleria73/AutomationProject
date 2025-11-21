package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentReports reports;

	public static ExtentReports getReports() {
		
		if(reports == null) 
		{
			String path = System.getProperty("user.dir");
			Date date = new Date();
			String PathDate = date.toString().replaceAll(":", "_").replaceAll(" ", "_");
			reports = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path + "/reports/" + PathDate + "/");
			
			String reportFolder = path + "/reports/" + PathDate + "/Screenshots";
			File file = new File(reportFolder);
			file.mkdirs();
			
			sparkReporter.config().setReportName("Testing of Website");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");
			reports.attachReporter(sparkReporter);
		}
		return reports;
	}
}

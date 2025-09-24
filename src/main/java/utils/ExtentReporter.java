package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter 
{
	  private static ExtentReports extent;

	    public static ExtentReports getReportInstance() {  
	      
	                  ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
	            spark.config().setReportName("BlueSwift Test Report");
	            spark.config().setDocumentTitle("BlueSwift Results");

	            extent = new ExtentReports();
	            extent.attachReporter(spark);

	            extent.setSystemInfo("Tester", "Monika");
	            extent.setSystemInfo("Browser", "Chrome");
	        
	        return extent;
	    }
}

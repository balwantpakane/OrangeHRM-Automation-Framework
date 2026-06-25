package com.hrms.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager 
{
	private static ExtentReports extent;
	
	public static ExtentReports getReportInstance()
	{
		if(extent==null)
		{
			String reportPath = System.getProperty("user.dir")+"/test-output/ExtentReport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			
			reporter.config().setReportName("HRM Automation Test Report");
			reporter.config().setDocumentTitle("Test Execution Report");
			reporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Project", "HRMS");
			extent.setSystemInfo("Tester", "Balwant");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
		}
		return extent;
	}

}

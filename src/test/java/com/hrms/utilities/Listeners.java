package com.hrms.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener
{	
	ExtentReports extent = ExtentReportManager.getReportInstance();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "Test CasemPASSED: "+result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().log(Status.FAIL, "Test Case FAILED: "+result.getMethod().getMethodName());
		extentTest.get().log(Status.FAIL, result.getThrowable());
		
		String screenshotPath = ScreenShotUtils.captureScreenshot(result.getMethod().getMethodName());
		extentTest.get().fail("Screenshot of failure", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}

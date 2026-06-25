package com.hrms.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hrms.base.BaseTest;

public class ScreenShotUtils 
{
	public static String captureScreenshot(String testName)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String screenshotPath = System.getProperty("user.dir")+"/screenshots/"+testName+"_"+timestamp+".png";
		
		File srcFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotPath);
		
		try 
		{
			FileUtils.copyFile(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return screenshotPath;
	}
}

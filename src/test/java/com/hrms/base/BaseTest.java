package com.hrms.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void setupBrowser()
	{
		driver=new SafariDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		try 
		{
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}

}

package com.hrms.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	
	//constructor - gets driver from base file
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By usernameTextBox = By.name("username");
	By passwordTextBox = By.name("password");
	By loginButton = By.xpath("//button[@type='submit']");
	By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	
	//Points-Action
	public void enterUsername(String uname)
	{
		driver.findElement(usernameTextBox).sendKeys(uname);
	}
	
	public void enterPassword(String pwd) 
	{
		driver.findElement(passwordTextBox).sendKeys(pwd);
	}
	
	public void clickLogin() 
	{
		driver.findElement(loginButton).click();
		
		try 
		{
			Thread.sleep(4000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	//LogIN Verify
	public boolean isDashboardDisplayed()
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

}

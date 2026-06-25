package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrms.base.BaseTest;
import com.hrms.pages.LoginPage;
import com.hrms.utilities.ExcelUtils;

@Listeners(com.hrms.utilities.Listeners.class)

public class LoginTest extends BaseTest 
{
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData()
	{
		String path = System.getProperty("user.dir") + "/testdata/LoginData.xlsx";
		Object[][] loginData = ExcelUtils.getTestData(path, "Sheet1");
		return loginData;
	}
	
	@Test(dataProvider = "LoginData")
	public void verifyValidLogin(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
//		Assert.assertTrue(loginPage.isDashboardDisplayed(),"Login failed for user: "+username);
	
		if (password.equals("admin123")) 
		{
			Assert.assertTrue(loginPage.isDashboardDisplayed(),"Valid Credentials: " +username+ "Login faild");
			System.out.println("PASS : Valid Login for User: "+username);
		}
		else 
		{
			Assert.assertFalse(loginPage.isDashboardDisplayed(),"Invalid Credentials but login: "+username);
			System.out.println("Executed: Invalid Login for user: "+username+ "| Password: "+password);
		}
	}
	
}



/*
package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.base.BaseTest;
import com.hrms.pages.LoginPage;

public class LoginTest extends BaseTest 
{
	@Test
	public void verifyValidLogin()
	{
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLogin();
		
		Assert.assertTrue(loginPage.isDashboardDisplayed(),"Login Faild - Dashoard not Visible");
		System.out.println("----Login Successful----");
	}
}
*/
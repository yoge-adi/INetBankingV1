package com.inetBanking.testCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
public class TC_LoginTest_001 extends BaseClass
{
	Logger logger = LogManager.getLogger(TC_LoginTest_001.class);
	@Test
	public void loginTest() throws IOException 
	{
		//driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("hi*****************");
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			System.out.println("hello");
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else 
		{
			logger.info("Login test failed");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
}

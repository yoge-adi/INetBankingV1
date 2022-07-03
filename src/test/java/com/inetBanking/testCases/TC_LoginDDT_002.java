package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	
	Logger logger = LogManager.getLogger(TC_LoginDDT_002.class);
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login Failed");
			captureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	public boolean isAlertPresent() 
	{
		try
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}
	@DataProvider(name ="LoginData")
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1",1);
		String loginData[][] = new String[rowNum][colCount];
		for (int i = 1; i <=rowNum;i++) {
			for (int j = 0; j < colCount; j++) 
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}

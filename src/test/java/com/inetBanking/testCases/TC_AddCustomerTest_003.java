package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import org.apache.logging.log4j.Logger;
public class TC_AddCustomerTest_003 extends BaseClass
{
	Logger logger = LogManager.getLogger(TC_AddCustomerTest_003.class);
	@Test
	public void addNewcustomer() throws InterruptedException, IOException 
	{
		LoginPage lp =  new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details...");
		
		addcust.customerName("Yogesh");
		addcust.custGender("male");
		addcust.custdob("28", "03", "1986");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("411061");
		addcust.custtelephoneno("7767951116");
		
		String email = randomString()+ "@gmail.com";
		addcust.custemailid(email);
		
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started....");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
			
		}
		else 
		{
			logger.info("Test Case Failed....");
			captureScreen(driver, "addNewcustomer");
			Assert.assertTrue(false);
		}
		

	}
	
	
	
}

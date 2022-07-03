package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass
{
	Logger logger = LogManager.getLogger(TC_EditCustomerTest_004.class);
	
	@Test
	public void editCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided to edit the customer details..");
		lp.setPassword(password);
		logger.info("password is provided for edit customer details..");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		EditCustomerPage editcust = new EditCustomerPage(driver);
		editcust.clickEditCustomer();
		editcust.entercustID("123456");
		logger.info("Custeomer id is provided for edit the customer..");
		
		editcust.editCustSubmit();
		logger.info("Validation started for edit customer details");
		boolean result1	= driver.getPageSource().contains("Customer details edited Successfully..");
		if (result1== true) {
			
			Assert.assertTrue(true);
			logger.info("Test case passed");
			
			
		} else {
			logger.info("Test case failed");
			captureScreen(driver, "editCustomer");
			Assert.assertTrue(false);

		}
	}
	
	

}

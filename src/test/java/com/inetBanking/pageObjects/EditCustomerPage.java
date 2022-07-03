package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage 
{
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how = How.CSS, using = "[href=\"EditCustomer.php\"]")
	@CacheLookup
	WebElement lnkeditcustomer;
	
	
	@FindBy(how = How.NAME, using ="cusid" )
	@CacheLookup
	WebElement txtcustomerid;
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement btneditcustsubmit;
	
	public void clickEditCustomer() {
		lnkeditcustomer.click();
	}
	
	public void entercustID(String cid) {
		txtcustomerid.sendKeys(String.valueOf(cid));
	}
	
	public void editCustSubmit() {
		btneditcustsubmit.click();

	}
	
	
	
	

}

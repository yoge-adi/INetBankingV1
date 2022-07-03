package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String brwsr) {
		if (brwsr.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if (brwsr.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if (brwsr.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseURL);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomString() 
	{
		String generatedstring	= RandomStringUtils.randomAlphabetic(5); 
		return generatedstring;
	}
	public static String randomNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}	
}

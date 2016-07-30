package SuperNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;

public class SuperNG 
{
	WebDriver driver;
	@BeforeClass
	@Test
   public void preCondition() throws EncryptedDocumentException, InvalidFormatException, IOException
   {
	   String xlpath = "./Input_Files/Excel/InputData.xlsx";
	   String sheetname = "Sheet1";
	   
	   String browser = Excel_Transactions.getCellValue(xlpath, sheetname, 1, 0);
	 if(browser.equalsIgnoreCase("chrome")){
		   System.setProperty("Webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   Reporter.log("chrome is launched", true);}
	else if(browser.equalsIgnoreCase("ie")){
		   System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
	       driver = new InternetExplorerDriver();
	       driver.manage().window().maximize();
	       Reporter.log("IE is launched", true);}
	else if(browser.equalsIgnoreCase("MozillaFirefox")){
		System.setProperty("WebDriver.firefox.profile", "default");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Reporter.log("mozilla is launched", true);}
	else{
		System.setProperty("WebDriver.firefox.profile", "default");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Reporter.log("mozilla is launched", true);}
	  
Excel_Transactions.getRowCount(xlpath, sheetname);
Excel_Transactions.properties();
   }
	
	@AfterClass
	@Test
	public void postcondition()
	{
		driver.quit();
	}
}

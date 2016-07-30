package TestNGClasses;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;

public class VerifyBrokenLinks_TestNG
{
@Test

public void VerifyBrokenLinks() throws IOException
	{
	String xlpath = "./Input_Files/Excel/InputData.xlsx";
	String sheetname = "VerifyBrokenLinks_data";
    String browsertype1 = Excel_Transactions.getCellValue(xlpath, sheetname, 1, 0);
    if(browsertype1.equalsIgnoreCase("MozillaFirefox"))
    {
WebDriver  drive_brokenLinks = new FirefoxDriver();
//drive_brokenLinks.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
drive_brokenLinks.manage().timeouts().implicitlyWait(111, TimeUnit.SECONDS);
drive_brokenLinks.manage().window().maximize();
String currentUrl = Excel_Transactions.getCellValue(xlpath, sheetname, 1, 1); // get URL from excel
drive_brokenLinks.get(currentUrl);
List<WebElement> alllinks = drive_brokenLinks.findElements(By.tagName("a"));
for(int i=0;i<alllinks.size();i++)
{
WebElement ele = alllinks.get(i);
Reporter.log("url : " + ele, true);
String eachurl = ele.getAttribute("href");
Reporter.log("url : " + eachurl, true);
Excel_Transactions.VerifyBrokenLinks(eachurl);
}
    }
else
{
	Reporter.log("there are no broken links find", true);
}
 


String browsertype2 = Excel_Transactions.getCellValue(xlpath, sheetname, 1, 1);
if(browsertype2.equalsIgnoreCase("ie"))
{
//WebDriver  driverOne = new FirefoxDriver();
System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
WebDriver driverOne = new InternetExplorerDriver();
driverOne.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
driverOne.manage().window().maximize();
String urlOne = Excel_Transactions.getCellValue(xlpath, sheetname, 1, 1); // get URL from excel
driverOne.get(urlOne);
List<WebElement> links = driverOne.findElements(By.tagName("a"));
boolean isValid = false;
for(int j=0;j<=links.size();j++)
{
Reporter.log("inside for loop");	
Excel_Transactions.getResponseCode(links.get(j).getAttribute("href"));
if(isValid)
{
	Reporter.log("Valid Link of actitime is :"  + links.get(j).getAttribute("href"), true);
	driverOne.get(links.get(j).getAttribute("href"));	
}
else
 {
	Reporter.log("Invalid Liks of actitime is :" + links.get(j).getAttribute("href"), true);
  }
 } 
}

System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
WebDriver driverTwo = new ChromeDriver();
driverTwo.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
driverTwo.manage().window().maximize();
String urlTwo = Excel_Transactions.getCellValue(xlpath, sheetname, 1, 1); // get URL from excel
driverTwo.get(urlTwo);
List<WebElement> linksTwo = driverTwo.findElements(By.tagName("a"));
boolean isValid2 = false;
for(int k=0;k<=linksTwo.size();k++)
{
Reporter.log("inside for loop", true);	
Excel_Transactions.getResponseCode(linksTwo.get(k).getAttribute("href"));
if(isValid2)
{
	Reporter.log("Valid Link of actitime is :"  + linksTwo.get(k).getAttribute("href"), true);
	driverTwo.get(linksTwo.get(k).getAttribute("href"));	
}
else
 {
	Reporter.log("Invalid Liks of actitime is :" + linksTwo.get(k).getAttribute("href"), true);
  }
 }
}	
}


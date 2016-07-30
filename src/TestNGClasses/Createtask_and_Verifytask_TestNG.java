package TestNGClasses;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;
import Scripts_WebPages.CreateTask;
import Scripts_WebPages.CreateTask_NewUser;
import Scripts_WebPages.CreatedTask_Verify_and_deletecreatedtask;
import Scripts_WebPages.POM_ActiTime_BasePage_OR_Generic_WebElements;
import Scripts_WebPages.POM_ActitimeLogin;
import SuperNG.SuperNG;

public class Createtask_and_Verifytask_TestNG
{
	@Test
	public void createtask_and_logout() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
//open browser
				String xlpath = "./Input_Files/Excel/InputData.xlsx";
		        String sheetname = "login";
		        
              WebDriver driver;
		      int rc=Excel_Transactions.getRowCount(xlpath, sheetname);
		      for(int i=1;i<=rc;i++)
		        {
		        	String browser = Excel_Transactions.getCellValue(xlpath, sheetname, i, 0);
		        	System.out.println(i+" "+browser);
		        	if(browser.equalsIgnoreCase("chrome"))
		        	{
		        		System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
		        		driver = new ChromeDriver();
		        		driver.manage().window().maximize();
		        		Reporter.log("chrome is launched", true);
		             }
		       else if(browser.equalsIgnoreCase("ie"))
		       {
		   		   System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
		   	       driver = new InternetExplorerDriver();
		   	       driver.manage().window().maximize();
		   	       Reporter.log("IE is launched", true);
		   	       }
				else 
				   		{
				   		//System.setProperty("WebDriver.firefox.profile", "default");
				   		driver = new FirefoxDriver();
				   		driver.manage().window().maximize();
				   		Reporter.log("mozilla is launched", true);
				        }
		        	
// Lunching the URL       	
			 String Url = Excel_Transactions.getCellValue(xlpath, sheetname, i, 1);
			 driver.get(Url);
			 Reporter.log("opening URL", true);
			 driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
			 
// Login into actitime 
		   POM_ActitimeLogin login = new POM_ActitimeLogin(driver);
		   String un = Excel_Transactions.getCellValue(xlpath, sheetname, i, 2);
		   String pw = Excel_Transactions.getCellValue(xlpath, sheetname, i, 3);  // input thru parameterization
           //login.Function_login("admin", "manager");   //Hard coded input
		   login.Function_login(un, pw);   
		   Reporter.log("actitimeUser login successfully", true);
		   
// click on Task header which is in base page
		   POM_ActiTime_BasePage_OR_Generic_WebElements bp = new POM_ActiTime_BasePage_OR_Generic_WebElements(driver);
		   bp.Tasks_headers();
		   
//Click on Task button 
		  
		  String xl = "C:/Praveen/Eclips_Workspace/Healthcare_Automation/Input_Files/Excel/InputData.xlsx";
		  String sheet = "createtask";
		  int rc2= Excel_Transactions.getRowCount(xl, sheet);
		    for(int j=1;j<=rc2;j++)
		  {
			  String customer = Excel_Transactions.getCellValue(xl, sheet, j, 0);
			  String project = Excel_Transactions.getCellValue(xl, sheet, j, 1);
			  String tasks = Excel_Transactions.getCellValue(xl, sheet, j, 2);
			  String desc = Excel_Transactions.getCellValue(xl, sheet, j, 3);
			  String estimate_time = Excel_Transactions.getCellValue(xl, sheet, j, 4);
			  //String date = Excel_Transactions.getCellValue(xl, sheet, j, 5);  
		  
			  CreateTask task = new CreateTask(driver);
			  task.createtask();
// Process to create new task
		      CreateTask_NewUser    newuser = new CreateTask_NewUser(driver);
		      newuser.CreateNewTask(customer, project, tasks, desc, estimate_time);
		      Reporter.log("new task created successfully", true);
//Verify whether new task has been created /not
		  
//Selecting of all checkbox to delete allallActive customers & projects
		      CreatedTask_Verify_and_deletecreatedtask  deletetask = new CreatedTask_Verify_and_deletecreatedtask(driver);
		      deletetask.Verify_and_delete_createdtask();
		      Reporter.log("created task Verified & deleted", true);
		  }
		 bp.logout();
		 driver.close(); 
		  }  
	}
}






//Back up Scripts
/*
 WebDriver   drive_brokenLinks = new FirefoxDriver();
drive_brokenLinks.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
drive_brokenLinks.manage().window().maximize();
String currentUrl = Excel_Transactions.getCellValue(xlpath, sheetname, 4, 1); // get URL from excel
drive_brokenLinks.get(currentUrl);
List<WebElement> alllinks = drive_brokenLinks.findElements(By.tagName("a"));
for(int i=0;i<alllinks.size();i++)
{
	WebElement ele = alllinks.get(i);
	String eachurl = ele.getAttribute("href");
	Reporter.log("url : " + eachurl, true);
	Excel_Transactions.VerifyBrokenLinks(eachurl);
}	

System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
WebDriver driverOne = new InternetExplorerDriver();
driverOne.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
driverOne.manage().window().maximize();
String urlOne = Excel_Transactions.getCellValue(xlpath, sheetname, 5, 1); // get URL from excel
driverOne.get(urlOne);
List<WebElement> links = driverOne.findElements(By.tagName("a"));
boolean isValid = false;
for(int i=0;i<=links.size();i++)
{
	Excel_Transactions.getResponseCode(links.get(i).getAttribute("href"));
	if(isValid)
	{
		Reporter.log("Valid Link of actitime is :"  + links.get(i).getAttribute("href"), true);
		driverOne.get(links.get(i).getAttribute("href"));	
	}
	else
	{
		Reporter.log("Invalid Liks of actitime is :" + links.get(i).getAttribute("href"), true);
	}
}

*/


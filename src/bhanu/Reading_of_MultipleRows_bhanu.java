package bhanu;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;
import Scripts_WebPages.CreateTask;
import Scripts_WebPages.CreateTask_NewUser;
import Scripts_WebPages.CreatedTask_Verify_and_deletecreatedtask;
import Scripts_WebPages.POM_ActiTime_BasePage_OR_Generic_WebElements;
import Scripts_WebPages.POM_ActitimeLogin;

public class Reading_of_MultipleRows_bhanu 
{
	@Test
	public void testA() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//open browser
		String xlpath = "./Input_Files/Excel/InputData.xlsx";
        String sheetname = "login";
        WebDriver driver;
        int rc=Excel_Transactions.getRowCount(xlpath, sheetname);
        for(int i=1;i<=rc;i++)
        {
        	String browser = Excel_Transactions.getCellValue(xlpath, sheetname, i, 0);
        	System.out.println(i+browser);
        	if(browser.equalsIgnoreCase("chrome")){
        		System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
        		driver = new ChromeDriver();
        		driver.manage().window().maximize();
        		Reporter.log("chrome is launched", true);
        		}
        	else if(browser.equalsIgnoreCase("ie")){
   		   System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
   	       driver = new InternetExplorerDriver();
   	       driver.manage().window().maximize();
   	       Reporter.log("IE is launched", true);}
		   	else 
		   		{
		   		//System.setProperty("WebDriver.firefox.profile", "default");
		   		driver = new FirefoxDriver();
		   		driver.manage().window().maximize();
		   		Reporter.log("mozilla is launched", true);
		        }
		   	String Url = Excel_Transactions.getCellValue(xlpath, sheetname, i, 1);
	 driver.get(Url);
	 Reporter.log("opening URL", true);
	 driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
		//login
	 POM_ActitimeLogin login=new POM_ActitimeLogin(driver);
	 String un=Excel_Transactions.getCellValue(xlpath, sheetname, i, 2);
	 String pw=Excel_Transactions.getCellValue(xlpath, sheetname, i, 3);
	 System.out.println("***"+un+pw);
	 login.Function_login(un, pw);
		//create task
	 POM_ActiTime_BasePage_OR_Generic_WebElements bp = new POM_ActiTime_BasePage_OR_Generic_WebElements(driver);
	   bp.Tasks_headers();
	   
	  CreateTask task = new CreateTask(driver);
	  task.createtask();
	  
	  String xl = "C:/Praveen/Eclips_Workspace/Healthcare_Automation/Input_Files/Excel/InputData.xlsx";
	  String sheet = "createtask";
	 
		  String customer = Excel_Transactions.getCellValue(xl, sheet, i, 0);
		  String project = Excel_Transactions.getCellValue(xl, sheet, i, 1);
		  String tasks = Excel_Transactions.getCellValue(xl, sheet, i, 2);
		  String desc = Excel_Transactions.getCellValue(xl, sheet, i, 3);
		  String estimate_time = Excel_Transactions.getCellValue(xl, sheet, i, 4);
		  //String date = Excel_Transactions.getCellValue(xl, sheet, i, 5);  
	  
		  CreateTask_NewUser newuser = new CreateTask_NewUser(driver);
		  newuser.CreateNewTask(customer, project, tasks, desc, estimate_time);
		  Reporter.log("new task created successfully", true);
	  
		  CreatedTask_Verify_and_deletecreatedtask  deletetask = new CreatedTask_Verify_and_deletecreatedtask(driver);
		  deletetask.Verify_and_delete_createdtask();
		  Reporter.log("created task Verified & deleted", true);
	  
		  //logout
		  driver.findElement(By.id("logoutLink")).click();
		  driver.close();
        }	
	}

}
package TestNGClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;
import Scripts_WebPages.CreateCustomer;
import Scripts_WebPages.CreateCustomerForm;
import Scripts_WebPages.CreateNewProjectForm;
import Scripts_WebPages.CreateTask;
import Scripts_WebPages.POM_ActiTime_BasePage_OR_Generic_WebElements;
import Scripts_WebPages.POM_ActitimeLogin;


public class CreateCustomer_and_Project 
{
	WebDriver driver;
	
	@Test
	public void createCustomerProject() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
   String xl = "./Input_Files/Excel/InputData.xlsx";
   String sheetname="login";
   int rc = Excel_Transactions.getRowCount(xl, sheetname);
   for(int i=1;i<=rc;i++)
   {
	   String browsertype = Excel_Transactions.getCellValue(xl, sheetname, i, 0);
	   Reporter.log(" browser type is :  " +   browsertype, true );
	   if(browsertype.equalsIgnoreCase("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
		   driver = new ChromeDriver();
		   Reporter.log("Chrome is launch", true);
		   driver.manage().window().maximize();
	   }
	   else if(browsertype.equalsIgnoreCase("ie"))
	   {
		   System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
		   driver.manage().window().maximize();
		   Reporter.log("IE is launch", true);
	   }
	   else if(browsertype.equalsIgnoreCase("MozillaFirefox"))
	   {
		   driver = new FirefoxDriver();
		   driver.manage().window().maximize();
		   Reporter.log("Mozila is launch", true);
	   }	   
	   
	   
	   String url = Excel_Transactions.getCellValue(xl, sheetname, i, 1);
	   driver.get(url);
	   Reporter.log("actitime url launched", true);
	   driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
	   
	   String un = Excel_Transactions.getCellValue(xl, sheetname, i, 2);
	   String pw = Excel_Transactions.getCellValue(xl, sheetname, i, 3);
	   POM_ActitimeLogin loginclass = new POM_ActitimeLogin(driver);
	   loginclass.Function_login(un, pw);
	   Reporter.log("actitime user logged In", true);
	   
	   POM_ActiTime_BasePage_OR_Generic_WebElements baseclass = new POM_ActiTime_BasePage_OR_Generic_WebElements(driver);
	   baseclass.Tasks_headers();
	   
	   CreateTask task = new CreateTask(driver);
	   task.ClickOn_ProjectCustomersLink();
	   
	   CreateCustomer customer = new CreateCustomer(driver);
	   customer.CreateCustomerbutton();
	   
	   String sheet2 = "CreateCustomer";
	  int rc2 =  Excel_Transactions.getRowCount(xl, sheet2);
	   for(int j=1;j<=rc2;j++)
	   {
		   String cn = Excel_Transactions.getCellValue(xl, sheet2, rc2, 0);
	       String cd = Excel_Transactions.getCellValue(xl, sheet2, rc2, 1);   
	   CreateCustomerForm ccf = new CreateCustomerForm(driver);
	   ccf.CreateNewCustomer(cn, cd);
	   Reporter.log("Customer is created", true);   
	   
	   String sheet3 = "CreateProject";
	   int rc3 = Excel_Transactions.getRowCount(xl, sheet3);
	   for(int k=1;k<=rc3;k++)
	   {
		   String pn = Excel_Transactions.getCellValue(xl, sheet3, k, 0);
		   String pd = Excel_Transactions.getCellValue(xl, sheet3, k, 1);
		   CreateNewProjectForm cnpf = new CreateNewProjectForm(driver);
		   cnpf.CreateProject(pn, pd);
		   Reporter.log("project is created", true);
	   }	 
	   }
   }
	}
}
   
   

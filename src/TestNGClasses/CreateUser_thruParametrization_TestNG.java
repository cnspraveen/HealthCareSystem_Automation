package TestNGClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;
import Scripts_WebPages.CreateUser;
import Scripts_WebPages.POM_ActiTime_BasePage_OR_Generic_WebElements;
import Scripts_WebPages.POM_ActitimeLogin;
import SuperNG.SuperNG;

public class CreateUser_thruParametrization_TestNG// extends SuperNG 
{
	
	@Test
   public void loginintoActtime() throws EncryptedDocumentException, InvalidFormatException, IOException
   {
		WebDriver drive = null;
	       Reporter.log("trying to login", true);
// String xl = "./Input_Files/Excel/InputData.xlsx";
		   //String sheet1 = "login";
		   String xl = "./Input_Files/Excel/InputData.xlsx";
		   String sheet1 = "login";
		  int rowcount = Excel_Transactions.getRowCount(xl, sheet1);
		   for(int c=1;c<=rowcount;c++)
		   {
			   String getbrowsertype =Excel_Transactions.getCellValue(xl, sheet1, c, 0);
			   Reporter.log( c + " browser type is: " + getbrowsertype, true);
			   if(getbrowsertype.equalsIgnoreCase("chrome"))
			   {
				   System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
				   drive = new ChromeDriver();
				   drive.manage().window().maximize();
				   Reporter.log("Chrome is launched", true);
			   }
			   else 
				   if(getbrowsertype.equalsIgnoreCase("MozillaFirefox"))
			   {
					drive = new FirefoxDriver();
				   drive.manage().window().maximize();
				   Reporter.log("Firefox is launched", true);
			   }
		   
		   
		   String url = Excel_Transactions.getCellValue(xl, sheet1, c, 1);
		   drive.get(url);
		   Reporter.log("URL launched", true);
		   drive.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		   
   
		  // int rc = Excel_Transactions.getRowCount(xl, sheet1);
		   //Reporter.log("rc is : "  + rc, true );
		 //  for(int a=1;a<=rc;a++)
		  // {
		   String username = Excel_Transactions.getCellValue(xl, sheet1, c, 2);
		   String Password = Excel_Transactions.getCellValue(xl, sheet1, c, 3);
	       POM_ActitimeLogin logn = new POM_ActitimeLogin(drive);
	       logn.Function_login(username, Password);
	       Reporter.log("actitime login successfully", true);
		   //}
		   
		   POM_ActiTime_BasePage_OR_Generic_WebElements bp = new POM_ActiTime_BasePage_OR_Generic_WebElements(drive);
		   bp.Users_headers();
		   
		   String sheet2 = "CreateUser";
		   int rc2 = Excel_Transactions.getRowCount(xl, sheet2);
		   String[] res=new String[rc2];
		   for(int b=1;b<=rc2;b++)
		   {
		  String fn =Excel_Transactions.getCellValue(xl, sheet2, b, 0);
		  String mn = Excel_Transactions.getCellValue(xl, sheet2, b, 1);
		  String ln =Excel_Transactions.getCellValue(xl, sheet2, b, 2);
		  String un =Excel_Transactions.getCellValue(xl, sheet2, b, 3);
		  String pw =Excel_Transactions.getCellValue(xl, sheet2, b, 4);
		  String rty_pw =Excel_Transactions.getCellValue(xl, sheet2, b, 5);
		  String email = Excel_Transactions.getCellValue(xl, sheet2, b, 6);
		   		   
		   CreateUser cu = new CreateUser(drive);
		  res[b-1] = cu.createUser(fn, mn, ln, un, pw, rty_pw, email);
		  
		   Reporter.log("actitime user created successfully", true);
		   }
		   Excel_Transactions.setCellValue(xl, sheet2,res );
		   Reporter.log("got it!!!!!", true);
		   
		   Reporter.log("User created & deleted number of times", true);
		   //bp.logout();
		   drive.close();
		   }
	}
}

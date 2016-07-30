package TestNGClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericClasses.Excel_Transactions;
import Scripts_WebPages.CreateUser;
import Scripts_WebPages.POM_ActiTime_BasePage_OR_Generic_WebElements;
import Scripts_WebPages.POM_ActitimeLogin;
import Scripts_WebPages.WorkSchedule_CorporateSchedule;
import SuperNG.SuperNG;

public class CreateNewUser_DeleteUser_TestNG extends SuperNG
{
   @Test
   public void login() throws EncryptedDocumentException, InvalidFormatException, IOException
   {
	
	   POM_ActitimeLogin login = new POM_ActitimeLogin(driver);
	   Reporter.log("user is logining", true);
	   login.ErrMsg();
	   login.Function_login("admin", "manager");
	   Reporter.log("actitime login successfully", true);
	   
	   CreateUser newuser = new CreateUser(driver);
	   POM_ActiTime_BasePage_OR_Generic_WebElements bp = new POM_ActiTime_BasePage_OR_Generic_WebElements(driver);
	   WorkSchedule_CorporateSchedule cs = new WorkSchedule_CorporateSchedule(driver);
	   
	   bp.Users_headers();
	   newuser.createUser("swamy", "swamy", "swamy", "swamy", "swamy", "swamy","cns.praveen66@gmail.com");
	   
	   try{Thread.sleep(5);}
	   catch (InterruptedException e){
		Reporter.log("Exception caught during thread.sleep", true);}
	   
	   Reporter.log("Swamy user is created successfully", true);
	       
	    bp.WorkSchedule_headers();
	    cs.workSchedule();
	    
	    bp.logout();
	    Reporter.log("actitime logout successfully", true);  
   }
}

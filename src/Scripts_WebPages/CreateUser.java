package Scripts_WebPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import GenericClasses.Excel_Transactions;

public class CreateUser 
{
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text() = 'User']")
	private WebElement userbutton;
	
	@FindBy(id="userDataLightBox_firstNameField")
	private WebElement firstname;
	
	@FindBy(id="userDataLightBox_middleNameField")
	private WebElement middlename;
	
	@FindBy(id="userDataLightBox_lastNameField")
	private WebElement lastname;
	
	@FindBy(id="userDataLightBox_usernameField")
	private WebElement username;
	
	@FindBy(id="userDataLightBox_passwordField")
	private WebElement password;
	
	@FindBy(id="userDataLightBox_passwordCopyField")
	private WebElement retrypassword;
	
	@FindBy(id= "userDataLightBox_emailField")
	private WebElement email;
	
	@FindBy(id="ext-gen53")
	private WebElement dateAndTimeZone;
	
	@FindBy(id = "ext-gen81")
	private WebElement overtime_dropdown_inUserCreationPopup;
	
	@FindBy(id= "ext-gen123")
	private WebElement  CalculateAutomticallyVisibleForTheUser;
	
	@FindBy(id= "userDataLightBox_submitOtherUserTimeTrackChBox")
	//  OR   @FindBy(xpath="//label[contains(text(), 'Modify Time-Track of Other Users')]")
	private WebElement ModifyTimeTrackofOtherUser;
		
	@FindBy(id= "userDataLightBox_generateTimeReportsChBox")
	private WebElement GenerateTimeReports;
	
	@FindBy(id= "userDataLightBox_manageCustomersProjectsChBox")
	private WebElement manageCustomersProjects;
	
	@FindBy(id= "userDataLightBox_manageAccountsLabel")
	private WebElement manageAccountsChBox;
	
	@FindBy(id= "userDataLightBox_manageGeneralSettingsChBox")
	private WebElement userDataLightBox_manageSystemSettings;
	
	@FindBy(id= "userDataLightBox_commitBtn")
	private WebElement CreateUser;
	
//	@FindBy(xpath = "(//div[@class='name'])[1]")
//	private WebElement newusercretaed_verify;
	
	//Excel_Transactions.getRowCount();
	//@FindBy(xpath = Excel_Transactions.") 
	//private WebElement User_EditLink1;
	
	@FindBy(xpath = "//div[contains(text(), 'swamy, swamy swamy. (swamy)')]/../..//span[contains(text(), 'Edit')]")//partialLinkText = "Edit") 
	private WebElement User_EditLink1;
	
	@FindBy(id="userDataLightBox_deleteBtn")
	private WebElement User_deletebutton;
	
	
	
	public CreateUser(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public String createUser(String fn,String mn,String ln, String un,String pw, String retry_pw, String emailid) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		userbutton.click();
		//if(firstname.isEnabled())
		//{
			driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
			firstname.sendKeys(fn);
			middlename.sendKeys(mn);
			lastname.sendKeys(ln);
			username.sendKeys(un);
			password.sendKeys(pw);
			retrypassword.sendKeys(retry_pw);
			email.sendKeys(emailid);
			//overtime_dropdown_inUserCreationPopup.click();
		/*	Select select = new Select(overtime_dropdown_inUserCreationPopup);
			select.selectByIndex(2) ; */
			//dateAndTimeZone.click();
			ModifyTimeTrackofOtherUser.click();
			GenerateTimeReports.click();
			manageCustomersProjects.click();
			manageAccountsChBox.click(); 
			userDataLightBox_manageSystemSettings.click(); 
			CreateUser.click();		
			
			String xp="//div[text()='"+ln+", "+fn+" "+mn+". ("+un+")']";
			System.out.println("XPATH IS "+xp);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
			String text = driver.findElement(By.xpath(xp)).getText();
			String s=" ";
			//boolean b = text.contains("swamy, swamy");
			String xl = "./Input_Files/Excel/InputData.xlsx";
			String sheet2 = "CreateUser";			   
			/*int rcount = Excel_Transactions.getRowCount(xl, sheet2);
			for(int m=1;m<=rcount;m++)
			{*/
			   boolean b = text.contains(Excel_Transactions.getCellValue(xl, sheet2, 1, 1));
			   Reporter.log( " browser type is: " + b, true);
			   
			if(b)
			{
				s="pass";
				Reporter.log("user is created", true);
			}
			else
			{
				s="fail";
				Reporter.log("user is not created", true);
			}	
			Reporter.log("status = " +s, true);	
			Reporter.log(Excel_Transactions.getCellValue(xl, sheet2, 1, 7), true);
	        // } // for loop close
		   String xp2=xp+"/../..//span[contains(text(), 'Edit')]";
			driver.findElement(By.xpath(xp2)).click();
			User_deletebutton.click();if(driver.switchTo().alert().getText().contains("delete this user account?"))
			{
			driver.switchTo().alert().accept();
			}
			else{driver.switchTo().alert().dismiss();}			
			
			 String xll = ".\\Input_Files\\Excel\\InputData.xlsx";
			 Reporter.log(xll, true);
			   String sheet11 = "login";
			   Reporter.log(sheet11, true);
//			   try
//			   {
//			   FileInputStream fis2 = new FileInputStream(".\\Input_Files\\Excel\\InputData.xlsx"); 
//			   Workbook  wb2 = WorkbookFactory.create(fis2);
//			   Sheet sheet2 = wb2.getSheet("login");
//			   int rowcount2 = sheet2.getLastRowNum();
//			   System.out.println(rowcount2);
//			   for(int a=1;a<=rowcount2;a++)
//			   {
//				  //System.out.println("hi");
//				  Workbook wb=new XSSFWorkbook();
//				   wb.createSheet("login").createRow(a).createCell(8).setCellValue(s);
//				   FileOutputStream fos = new FileOutputStream(".\\Input_Files\\Excel\\InputData.xlsx");  //C:\\InputData.xlsx");
//				   wb.write(fos);
//				   fos.close();
//				   System.out.println("hello");
//			   }
//			   
//			   }
//			   catch(Exception e)
//			   {
//				   Reporter.log(e + " " , true);
//			   }
//			   finally
//			   {
//				   Reporter.log("Finally executed!!!!", true);
//			   }
//			   
			
			Assertion asset = new Assertion();
			asset.assertEquals("swamy, swamy swamy. (swamy)", "swamy, swamy swamy. (swamy)");
			Reporter.log("assetEquals pass the condition" + asset , true);
			asset.assertNotEquals("Swamy, swamy swamy. (swamy)", "swamy, swamy swamy. (swamy)");
			Reporter.log("assetNotEquals pass the condition" + asset, true ); 
			
			asset.assertSame("swamy, swamy swamy. (swamy)", "swamy, swamy swamy. (swamy)");
			Reporter.log("assetSame pass the condition" + asset, true );
			asset.assertNotSame("Swamy, swamy swamy. (swamy)", "swamy, swamy swamy. (swamy)");
			Reporter.log("assetNotSame pass the condition" + asset, true);
			asset.assertTrue(true);   // In case if you put false which is wrong, we will get error in log.....java.lang.AssertionError: expected [true] but found [false] in Console/Report.html 
			Reporter.log("assetTrue pass the condition" + asset, true);
			asset.assertFalse(false);  //In case if you put true which is wrong, we will get error in log....java.lang.AssertionError: expected [false] but found [true]
			Reporter.log("assetFalse pass the condition" + asset, true);
			//asset.fail();
			
			
		    SoftAssert sa = new SoftAssert();
			sa.assertEquals("swamy, swamy swamy. (swamy)", "swamy, swamy swamy. (swamy)");
			Reporter.log("SoftAssert AssertEquals pass the condition" + asset, true);
			
			
			return s;
			
		//}
	}
	}
	
	
	
	
	
	
	
	
	
	
	



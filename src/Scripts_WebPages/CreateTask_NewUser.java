package Scripts_WebPages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import GenericClasses.Excel_Transactions;

public class CreateTask_NewUser extends POM_ActiTime_BasePage_OR_Generic_WebElements
{
  private WebDriver driver;
  
  @FindBy(name = "customerId")//xpath = "//select(@name='customerId')")
  private WebElement CustomerTypeWeblist;
  
  @FindBy(xpath = "//input[@name='customerName']")
  private WebElement EnterCustomerName;
  
  @FindBy(xpath = "//input[@name='projectName']")
  private WebElement EnterProjectName;
  
  @FindBy(xpath = "//input[@id='task[0].name']")
  private WebElement EnterTaskName;
  
  @FindBy(xpath = "//img[@id='task[0].image']")
  private WebElement Enter_CommentImage;
  
  @FindBy(xpath = "//textarea[@id='editDescriptionPopupText']")
  private WebElement EnterText;
  
  @FindBy(xpath = "//input[@id='scbutton']")
  private WebElement ClickOn_OK_button_ofCommentImage;
  
  @FindBy(xpath = "//input[@id='task[0].budgetedTimeStr']")
  private WebElement Enter_Estimataion;
  
  @FindBy(xpath = "//img[@id='ext-gen7']")
  private WebElement click_OnCalender;
  
  @FindBy(xpath = "//span[contains(text()='23')]")
  private WebElement Selectdate_fromCalender;
  
  @FindBy(id="ext-gen124")
  private WebElement ClickOn_OKButton_inCalender;
  
  @FindBy(xpath = "//input[@id='task[0].markedToBeAddedToUserTasks']")
  private WebElement Select_CheckBox;
  
  @FindBy(xpath = "//input[@id='active_customers']")
  private WebElement Selectlistofactiveprojectsandcustomersoption;
  
  @FindBy(xpath = "//input[@value='Create Tasks']")
  private WebElement CreateTask_button;
  
  //This comes in new page. hence selenium is not able to idenitify.
  //@FindBy(xpath = "//span[contains(text(), '1 new task was added to the customer')]")
  //private WebElement NewTaskCreation_SucessMsg_Verify;
  
  public CreateTask_NewUser(WebDriver driver)
  {
	  super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public void CreateNewTask(String customername, String projectname, String taskname,String entertext, String est_time) throws EncryptedDocumentException, InvalidFormatException, IOException
  {
	    /*  String xlpath = "C:/Praveen/Eclips_Workspace/Healthcare_Automation/Input_Files/Excel/InputData.xlsx";
	    String sheet = "createtask";
	       int rc= Excel_Transactions.getRowCount(xlpath, sheet);
	      for(int i=0;i<=rc;i++){
	      }*/
	  
	      Select select = new Select(CustomerTypeWeblist);
	  	  if(select != null)
	  	  {
	  		select.selectByVisibleText("-- new customer --");
	  		EnterCustomerName.sendKeys(customername);
	  		EnterProjectName.sendKeys(projectname);
	  		EnterTaskName.sendKeys(taskname);
	  		Enter_CommentImage.click();
	  		EnterText.sendKeys(entertext);
	  		ClickOn_OK_button_ofCommentImage.click();
	  		Enter_Estimataion.sendKeys(est_time);
	  		click_OnCalender.click();
	  		ClickOn_OKButton_inCalender.click();
	  		//Selectdate_fromCalender.click();
	  		Select_CheckBox.click();
	  		Selectlistofactiveprojectsandcustomersoption.click();
	  		CreateTask_button.click();	
	  		Reporter.log("New Task created", true);
	  	  }
  }
  
  /*public void VerifyMsg()
  {
	  String text = NewTaskCreation_SucessMsg_Verify.getText();
	  if(text.contains("1 new task was added "))
	  { Reporter.log("New Task created & verified successfully"); }
	  else
        Reporter.log("New Task is not verified");
   }*/
  
  }


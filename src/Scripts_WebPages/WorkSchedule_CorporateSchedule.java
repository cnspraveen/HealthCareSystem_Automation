package Scripts_WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import SuperNG.SuperNG;

public class WorkSchedule_CorporateSchedule
{
   private WebDriver driver;
   @FindBy(id="formatSelectorElm")
   private WebElement SelectNumberOfMonthsLink;
   
   @FindBy(xpath = "//img[@src = '/img/default/work_days/selected_month.gif?hash=1106883454']")
   
   private WebElement threecalender_option;
   //4 months path:     img/default/work_days/other_month.gif?hash=1106883454
   
   //     //td[contains(text(), 'April')]/..//span[text()='15']   
   @FindBy(xpath = "//span[text()='15']")
   private WebElement April_15_2016;
   String MarchMonth = "//td[contains(text(), 'March')]";
   String AprilMonth = "//td[contains(text(), 'April')]";
   
   public WorkSchedule_CorporateSchedule(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }	
   
   public void workSchedule()
   { 
	   SelectNumberOfMonthsLink.click();
	   try{
		   Thread.sleep(5);}
	   catch(Exception e){
		   Reporter.log("error while selecting 3 calender option", true);}
	   threecalender_option.click();
	   if(AprilMonth.contains("April")){
		   April_15_2016.click();
	   Reporter.log("Click on April 15th 2016", true);}
	   else if(MarchMonth.contains("March")){
		   Reporter.log("error ", true);}
	   }
   }
   
   
   
 

package Scripts_WebPages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreatedTask_Verify_and_deletecreatedtask
{
	private WebDriver driver;
	
   @FindBy(xpath = "//span[contains(text(), '1 new task was added')]")
   private WebElement newtaskadded_verifyMsg;
 //  "//input[@
   //@FindBy(xpath = "//input[contains(@type='checkbox')]")
   @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement selectAllCheckboxes;

   @FindBy(xpath = "//input[@value = 'Delete Selected']")
   private WebElement deleteButton_todeleteall;
   
   @FindBy(xpath = "//input[@value='Delete This Customer']")
   private WebElement ClickOn_DeleteThisCustomerButton_In_PoPUp;
   
   @FindBy(xpath = "//a[text()='Open Tasks']")
   private WebElement OpenTask;
   
   public CreatedTask_Verify_and_deletecreatedtask(WebDriver driver)
   {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }

public void Verify_and_delete_createdtask()
{
	String text = newtaskadded_verifyMsg.getText();
	if(text.contains("1 new task was added"))
	{Reporter.log(text, true);}

 driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
 driver.findElement(By.xpath("//a[text()='cust2122']/../../../../../..//input[@type='checkbox']"));

 deleteButton_todeleteall.click();
 ClickOn_DeleteThisCustomerButton_In_PoPUp.click();
 OpenTask.click();
 
 /*selectAllCheckboxes.click(); */
//List<WebElement> listWE = driver.findElements(By.xpath("//input[@type='checkbox']"));
 //Reporter.log("Checkboxes are" + listWE);
/* for(int k=0;k<=listWE.size();k++)
 {
 WebElement ele = driver.findElement(By.name("customers[k]"));
 Reporter.log(listWE.get(k).getText(), true);
 listWE.get(k).click();
  } */
 
	/*for (WebElement e:listWE)
	 {
		 e.click();
	 }*/
	 
	 /* for(int k=0;k<=listWE.size();k++)
    {
	 Iterator iter = listWE.iterator();
     while(iter.hasNext())
	 {
	   System.out.println(iter.next());
		 }
		 
   //WebElement ele = driver.findElement(By.name("customers[k]"));
   Reporter.log(listWE.get(k).getText(), true);
   listWE.get(k).click();
    }
	deleteButton_todeleteall.click();
	ClickOn_DeleteThisCustomerButton_In_PoPUp.click();
/*	try
	{Thread.sleep(11);
	Reporter.log("Wait to appear Alert Pop-up");}
	catch(Exception e)
	{ Reporter.log("Exception caught!!!!!");}
	Alert alert = driver.switchTo().alert();
	Reporter.log("click on ");
	alert.accept();
	Reporter.log("Clicked on Alert Pop-up"); */
	
	
}
}
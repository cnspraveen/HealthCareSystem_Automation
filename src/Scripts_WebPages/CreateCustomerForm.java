package Scripts_WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerForm extends POM_ActiTime_BasePage_OR_Generic_WebElements
{
   private WebDriver driver;
   
   @FindBy(xpath="//input[@name='name']")
   private WebElement CustomerNameText;
   
   @FindBy(xpath = "//textarea[@name='description']")
   private WebElement CustomerDesc;
   
	@FindBy(xpath = "//input[@value='create_blank_customer']")
	private WebElement create_blank_customer;
	
	@FindBy(xpath="//input[@id='add_project_action']")
	private WebElement createNewProjectradiobutton;
	
	@FindBy(xpath="//input[@name='createCustomerSubmit']")
	private WebElement createCustomerSubmitbtn;
	
   public CreateCustomerForm(WebDriver driver)
   {
	   super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);	   
   }
   
    public void CreateNewCustomer(String CusName, String CusDesc)
    {
    	CustomerNameText.sendKeys(CusName);
    	CustomerDesc.sendKeys(CusDesc);
    	create_blank_customer.click();
    	createNewProjectradiobutton.click();
    	createCustomerSubmitbtn.click();
    	System.out.println("New Customer with project created succesfully");
    }
}

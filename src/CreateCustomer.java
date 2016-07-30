import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Scripts_WebPages.POM_ActiTime_BasePage_OR_Generic_WebElements;



public class CreateCustomer extends POM_ActiTime_BasePage_OR_Generic_WebElements
{
	private WebDriver driver;
	@FindBy(xpath = "//div[@id='createCustomerDiv']")
	private WebElement CreateCustomerbutton;
	
	private CreateCustomer(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void ClickCreateCustomer()
    {
    	CreateCustomerbutton.click();
    	System.out.println("clicked on CreateCustomerbutton");
    }
}

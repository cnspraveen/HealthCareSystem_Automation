package Scripts_WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomer extends POM_ActiTime_BasePage_OR_Generic_WebElements
{
	private WebDriver driver;
	
	@FindBy(xpath="//a[@href='/project/customers_projects.do']")
	private WebElement project_customers_link;
	
	@FindBy(xpath="//div[@id='createCustomerDiv']")
	private WebElement createcustomerbtn;
	
	public CreateCustomer(WebDriver  driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CreateCustomerbutton()
	{
		//project_customers_link.click();
		createcustomerbtn.click();
	}
	

}

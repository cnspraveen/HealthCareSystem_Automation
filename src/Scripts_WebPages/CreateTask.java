package Scripts_WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTask //extends POM_ActiTime_BasePage_OR_Generic_WebElements
{
    private WebDriver driver;
    
    @FindBy(xpath = "//span[contains(text(), 'Create Tasks')]")
    private WebElement CreateTask;
    
	@FindBy(xpath="//a[@href='/project/customers_projects.do']")
	private WebElement project_customers_link;
    
    public CreateTask(WebDriver driver)
    {
    	//super(driver);
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void createtask()
    {
    	//Tasks_headers();
    	CreateTask.click();
    	System.out.println("Create Task button clicked");
    }
    
    public void ClickOn_ProjectCustomersLink()
    {
    	project_customers_link.click();
    	System.out.println("Project Customer linked clicked");
    }
}


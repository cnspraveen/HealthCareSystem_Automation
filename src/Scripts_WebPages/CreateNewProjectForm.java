package Scripts_WebPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CreateNewProjectForm extends POM_ActiTime_BasePage_OR_Generic_WebElements
{

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement projectname;
	
	@FindBy(xpath =  "//textarea[@name='description']")
	private WebElement projectDesc;
	
	@FindBy(xpath="//option[contains(text(),'ln, fn ml. (un)')]")    //linkText ="     ln, fn ml. (un)")
	private WebElement  availableuUser;
	
   @FindBy(xpath = "//input[@class='actionsButtons'][1]")
   private WebElement AddButtonToAssociateUser;
   
   @FindBy(xpath="//input[@name='afterCreateAction']")
   private WebElement showlistofprojects;
   
   	@FindBy(xpath="//input[@name='createProjectSubmit']")
   	private WebElement CreateProjectSubmit_btn;
   	
   	public CreateNewProjectForm(WebDriver driver)
   	{
   		super(driver);
   		this.driver = driver;
   		PageFactory.initElements(driver, this);	
   	}
   		
   public void CreateProject(String projname, String projdesc) throws InterruptedException
   {
	   /*Select select = new Select(projectname);
	   List<WebElement> allList = select.getOptions();
	   for(int i=0;i<=allList.size();i++)
	   {
		     String txt =allList.get(i).getText();
		     if(txt.contains("aaaaa")){ select.selectByIndex(i);}
		     System.out.println("Customer aaaaa selected");
	   }*/
	   
	   
	   projectname.sendKeys(projname);
	   projectDesc.sendKeys(projdesc);
	   //Thread.sleep(2000);
	   Reporter.log("before selecting user", true);
	   availableuUser.click();
	   Reporter.log("After selecting user", true);
	   AddButtonToAssociateUser.click();
	   showlistofprojects.click();
	   CreateProjectSubmit_btn.click();  
   }
}

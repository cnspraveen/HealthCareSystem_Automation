package Scripts_WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import SuperNG.SuperNG;

public class POM_ActitimeLogin
{
	private WebDriver driver;
	
	@FindBy(id="username")
	private WebElement loginUN;
	
	@FindBy(name = "pwd")
	private WebElement loginPW;
	
	@FindBy(id="loginButton")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//span[@class = 'errormsg']")
	private WebElement ErrMsg;
	
	// Constructor
	public POM_ActitimeLogin(WebDriver driver)                             
	{
		//import org.openqa.selenium.support.PageFactory;
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	// All below are Methods
	public void Function_login(String un, String pw)                   
	{
		loginUN.sendKeys(un);
		loginPW.sendKeys(pw);
		loginbutton.click();
	}
		
	public void ErrMsg()
	{
		ErrMsg.getTagName();
		ErrMsg.getText();
	}
}

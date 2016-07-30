package Scripts_WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import SuperNG.SuperNG;

public class POM_ActiTime_BasePage_OR_Generic_WebElements
{
private WebDriver driver;

//xpath = div[conatins(text(), 'Time-Track')
@FindBy(linkText = "Time-Track")
private WebElement timetrack_header;

@FindBy(linkText = "Tasks")
private WebElement Tasks_header;

@FindBy(linkText = "Reports")
private WebElement Reports_header;

@FindBy(linkText = "Users")
private WebElement Users_header;

@FindBy(linkText = "Work Schedule")
private WebElement WorkSchedule_header;

@FindBy(linkText = "Notifications")
private WebElement Notifications_header;

@FindBy(id = "logoutLink")     //xpath = "//a[contains(text(),'Logout')]")   //id = "logoutLink")
private WebElement logoutLink;

@FindBy(xpath = "//div[@class = 'popup_menu_arrow']")
private WebElement dropdown;

@FindBy(xpath = "//a[text() = 'Billing Types']")
private WebElement billingTypes_in_dropdown;

////div[contains(text(), 'Leave Types')]")
@FindBy(xpath = "//a[text() = 'Leave Types']")
private WebElement leaveTypes_in_dropdown;

@FindBy(xpath = "//a[text() = 'General Settings']")
private WebElement GeneralSetting_in_dropdown;

public POM_ActiTime_BasePage_OR_Generic_WebElements(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void timetrack_header_headers()
{
	timetrack_header.click();
	Reporter.log("Clicked on timetrack_header", true);
}

public void Tasks_headers()
{
	Tasks_header.click();
	Reporter.log("Clicked on Tasks_header", true);
}

public void Reports_headers()
{
	Reports_header.click();
	Reporter.log("Clicked on Reports_headers", true);
}

public void Users_headers()
{
	Users_header.click();
	Reporter.log("Clicked on User header", true);
}

public void WorkSchedule_headers()
{
	WorkSchedule_header.click();
	Reporter.log("clicked on WorkSchedule header ", true);
}

public void Notifications_headers()
{
	Notifications_header.click();
	Reporter.log("clicked on Notfications header", true);
}

public void logout()
{
	logoutLink.click();
	Reporter.log("Logout successfully", true);
}

public void select_BillingType()
{
	if(dropdown.isEnabled())
	{
		dropdown.click();
		billingTypes_in_dropdown.click();
		Reporter.log("billingType is selected", true);
	}
}

public void select_leaveType()
{
	dropdown.click();
	leaveTypes_in_dropdown.click();
	Reporter.log("Leave Type is selected", true);
}

public void select_GeneralSettings()
{
	dropdown.click();
	GeneralSetting_in_dropdown.click();
	Reporter.log("GeneralSetting_is selected_in_dropdown ", true);
}

}

package bhanu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Xpath_various_types 
{
	public static void main(String[] args) 
	{
	        WebDriver driver = new FirefoxDriver();
            driver.get("http://localhost:5050/login.do");
List<WebElement> links= driver.findElements(By.xpath("//a"));
System.out.println(links);
            
            

	}

}

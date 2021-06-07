package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomeClass { 
	
	WebDriver driver;
	
	By fname = By.id("fname");
	By dropdown = By.id("testingDropdown");

	
	public HomeClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setName(String name)
	{
		driver.findElement(fname).sendKeys(name);
	}
	
	public void clickOndropdown(int value) {
		
		WebElement dropDown=driver.findElement(dropdown);
		Select obj = new Select(dropDown);
		obj.selectByIndex(value);
	}
}

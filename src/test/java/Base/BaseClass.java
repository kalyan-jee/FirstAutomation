package Base;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import dataprovider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.HomeClass;

public class BaseClass {
  
	WebDriver driver;
	HomeClass homeClassObj;
	ConfigFileReader objconfig = new ConfigFileReader();
	
	String log4Jpath = System.getProperty("user.dir")+"/log4j.properties";
	Logger logger = Logger.getLogger(BaseClass.class.getName());
	 
	//static ExtentTest test;
	 //static   ExtentReports report;
	 @BeforeClass
	 public static  void startTest()
	 {
	 //report = new ExtentReports(System.getProperty("user.dir")+"/test-ouput/MyReport.html");
	// test = report.startTest("ExtentDemo");
	 }

	@BeforeTest
	public void setup() {
		
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	@Test(priority = 0)
	public void firstTestCase()
	{
		
		driver.get(objconfig.URL());
	
		String title = driver.getTitle();
		Assert.assertEquals(title, "Sample Test3 Page");
		logger.info("Title Verified");
	}
	
	@Test(priority = 1)
	public void secondTestCase()
	{
	    homeClassObj = new HomeClass(driver);
		homeClassObj.setName(objconfig.getFirstName());
		logger.info("Name send");
		homeClassObj.clickOndropdown(3);
		logger.info("DropDown Selected");
	}
	@Test(priority = 2)
	public void ThirdTestCase()
	{
		
	}
	
	public void teardown()
	{
	    
		//report.flush();
		driver.quit();
	}
}

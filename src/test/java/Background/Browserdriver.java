package Background;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.Propertyclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserdriver 
{

	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";
	public static Logger logger = LogManager.getLogger("class");  
	public String Browser_Name = null;
	public String Browser_Version = null ;
	
	public static void extreport()
	{
		report = new ExtentReports(reportpath+"extenreport.html",true);
		test= report.startTest("Extent report");
		
	}
	
	public static void reportclose()
	{
		//test.close();
		report.flush();
		
	}
	
	public void browserselection(String browser)
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//test//java//log4j.properties");
		//String browser=Propertyclass.propreaddata().getProperty("brower");
		if(browser.equalsIgnoreCase("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		logger.info("before launch");
		WebDriverManager.chromedriver().setup();
		logger.info("after launch");
		
		//ChromeOptions c=new ChromeOptions();
		//c.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		 Browser_Name = cap.getBrowserName();
		 Browser_Version = cap.getVersion();
		logger.debug("browser intialize");
		logger.info("info log");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", 
					"D:\\Software\\edgedriver_win64_93\\msedgedriver.exe");
			driver = new EdgeDriver();
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			 Browser_Name = cap.getBrowserName();
			 Browser_Version = cap.getVersion();
			 System.out.println(Browser_Version);
		}
	}
	
	public String urldata()
	{
		String urlvlue=Propertyclass.propreaddata().getProperty("URL");
		return urlvlue;
	}
	
	public void maximize()
	{
		driver.manage().window().maximize();
	}
}

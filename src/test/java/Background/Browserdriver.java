package Background;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.Propertyclass;

public class Browserdriver 
{

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";
	public static Logger logger = LogManager.getLogger("class");  
	
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
	
	public void browserselection()
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//test//java//log4j.properties");
		String browser=Propertyclass.propreaddata().getProperty("brower");
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		logger.debug("browser intialize");
		logger.info("info log");
		}
		else
		{
			System.setProperty("webdriver.edge.driver", 
					"D:\\Software\\edgedriver_win64_93\\msedgedriver.exe");
			driver = new EdgeDriver();
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

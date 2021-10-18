package Testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Background.Browserdriver;
import Commonmethods.commonsclass;
import Pages.Flightsearch;
import Utils.excelread;

public class FlightsearchTestcase extends Browserdriver
{

	@BeforeSuite
	public void launch()
	{
		browserselection();
		extreport();
	}
	
	@BeforeTest
	public void launchurl()
	{
		driver.get(urldata());
		maximize();
	}
	
	@Test(priority=0,dataProvider = "flightsearch" , dataProviderClass=dataproviderclass.class)
	public void validsearch(String fromlist,String Tolist,String date,String retundate)
	{
		try
		{
		System.out.println(fromlist +";"+ Tolist +";"+date);
		Flightsearch f= new Flightsearch(driver);
		f.fromlist(fromlist);
		logger.info("From list is clikced andpassed in tes case step");
		f.Tolist(Tolist);
		logger.info("To list is clikced andpassed in tes case step");
		f.depaturedate(date);
		logger.info("Date is clikced and passed in tes case step");
		//f.returndate( retundate);
		f.searchbutton();
		String scrnshotpath=commonsclass.takescreenshot(driver);
		driver.navigate().back();
		test.log(LogStatus.PASS,test.addScreenCapture(scrnshotpath));
		String outcomettile=driver.getTitle();
		System.out.println(outcomettile);
		Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", outcomettile,"This is invalid value");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, e);
			logger.error("unable to execute the test case" +e);
		}
			
	}
	

	
	
	@AfterSuite
	public void teardonw()
	{
		reportclose();
		driver.quit();
	}
}

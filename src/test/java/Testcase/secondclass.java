package Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Background.Browserdriver;
import Commonmethods.commonsclass;
import Pages.Flightsearch;

public class secondclass extends beforeannotations
{
	

	@Test(priority=0,dataProvider = "flightsearch" , dataProviderClass=dataproviderclass.class)
	public void validsearch_class2(String fromlist,String Tolist,String date,String retundate)
	{
		try
		{
		System.out.println(fromlist +";"+ Tolist +";"+date);
		Flightsearch f= new Flightsearch(getdriver());
		f.fromlist(fromlist);
		logger.info("From list is clikced andpassed in tes case step");
		f.Tolist(Tolist);
		logger.info("To list is clikced andpassed in tes case step");
		f.depaturedate(date);
		logger.info("Date is clikced and passed in tes case step");
		//f.returndate( retundate);
		f.searchbutton();
		String scrnshotpath=commonsclass.takescreenshot(getdriver());
		getdriver().navigate().back();
		test.log(LogStatus.PASS,test.addScreenCapture(scrnshotpath));
		String outcomettile=getdriver().getTitle();
		System.out.println(outcomettile);
		Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", outcomettile,"This is invalid value");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, e);
			logger.error("unable to execute the test case" +e);
		}
			
	}
	

}

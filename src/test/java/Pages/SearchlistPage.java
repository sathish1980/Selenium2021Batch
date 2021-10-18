package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.commonsclass;

public class SearchlistPage extends commonsclass
{

	@FindBy (xpath="(//div[@class='listingRhs']//p)[1]")
	WebElement textvalue;
	WebDriver driver;
	
	public SearchlistPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void refundablefarescheckbox()
	{
		waitelementtobeclickable(driver,By.xpath("(//span[@class='customCheckbox']//span)[1]"));
		String text = textvalue.getText();
	}
}

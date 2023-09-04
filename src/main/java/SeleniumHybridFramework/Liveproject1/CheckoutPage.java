package SeleniumHybridFramework.Liveproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumHybridFramework.Abstractcomponants.Abstractcomponants;

public class CheckoutPage extends Abstractcomponants {

WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']") WebElement Entercountrytab;
	@FindBy(xpath="//button[contains(@class, 'ta-item')])[2]")WebElement Selectcountry;
	@FindBy(css="action__submit")WebElement submit;
	By elevisible= By.cssSelector("action__submit");
	
public void selectCountry(String Countryname)
{
	Actions a = new Actions(driver);
	a.sendKeys(Entercountrytab,Countryname).build().perform();
	Selectcountry.click();
}
public void submitOrder()
{
	elementTobeAppear(elevisible);
	submit.click();
}
	}

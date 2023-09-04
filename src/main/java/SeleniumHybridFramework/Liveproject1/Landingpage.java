package SeleniumHybridFramework.Liveproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumHybridFramework.Abstractcomponants.Abstractcomponants;

public class Landingpage extends Abstractcomponants{

	WebDriver driver;
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")WebElement Username;
	@FindBy(id="userPassword")WebElement password;
	@FindBy(xpath="//input[@value='Login']")WebElement Submitbutton;
	
	public productcatalogue loginwithValidCredentials(String UserID , String passwordenter)
	{
		Username.sendKeys(UserID);
		password.sendKeys(passwordenter);
		Submitbutton.click();
		productcatalogue productcatalogue= new productcatalogue(driver);
		return productcatalogue;
	}
	 
  public void goTO()
  {
		driver.get("https://rahulshettyacademy.com/client");
  }

}

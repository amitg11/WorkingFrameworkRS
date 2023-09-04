package SeleniumHybridFramework.Liveproject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	WebDriver driver;
	
	public Cartpage(WebDriver driver)
	{
		//super(driver);
		PageFactory.initElements(driver,this);
		this.driver= driver;
	}
	
@FindBy(xpath="//div[@class='cartSection']/h3")List<WebElement> addedpro;
@FindBy(xpath="//div/ul/li[3]/button") WebElement checkoutbutton;


	public Boolean addedProducts(String productname)
	{
		Boolean match= addedpro.stream().anyMatch(prod1 -> prod1.getText().equalsIgnoreCase(productname));
	return match;
	}
	
	public void checkoutItems()
	{
		checkoutbutton.click();
	}
}

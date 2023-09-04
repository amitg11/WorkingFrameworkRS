/**
 * 
 */
package SeleniumHybridFramework.Liveproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumHybridFramework.Abstractcomponants.Abstractcomponants;

public class Confirmationpage extends Abstractcomponants {
WebDriver driver;
@FindBy(css=".hero-primary")WebElement confirmationmessage;

String s = driver.findElement(By.cssSelector(".hero-primary")).getText();	
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
			
		PageFactory.initElements(driver,this);
	}
	
	public String verifymessage()
	{
		return confirmationmessage.getText();
	}

}

package SeleniumHybridFramework.Abstractcomponants;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponants {
	
	
	WebDriver driver;
@FindBy(css="button[routerlink='/dashboard/cart']")WebElement cartheader;
	

	public Abstractcomponants(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void elementTobeAppear(By Findby)
	{
	
	WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(3000));
	w.until(ExpectedConditions.visibilityOfElementLocated(Findby));
	}
	
	public void elementtoBeDisappear() throws InterruptedException
	{
		Thread.sleep(3000);
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(3000));
		//w.until(ExpectedConditions.invisibilityOfElementLocated(Findbydis));
	}
	public void goToCartPage()
	{
		cartheader.click();
	}
}

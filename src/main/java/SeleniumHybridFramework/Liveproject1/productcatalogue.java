package SeleniumHybridFramework.Liveproject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumHybridFramework.Abstractcomponants.Abstractcomponants;

public class productcatalogue extends Abstractcomponants {

	WebDriver driver;
	public productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")List<WebElement> products;
	By productby= By.cssSelector(".mb-3");
	By addtocart= By.cssSelector(".card-body button:last-of-type");
	By toastmessage =By.id("toast-container");
	By spinner	=By.cssSelector(".ng-animating");

public List<WebElement> selectProducts()
{
	elementTobeAppear(productby);
	return products;

}
public WebElement getproductByName(String productname)
{
	WebElement prod = selectProducts().stream()
			.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname))
			.findFirst().orElse(null);
return prod;
}

public void addProductToCart(String productname) throws InterruptedException
{

	WebElement prod=getproductByName(productname);
	prod.findElement(addtocart).click();
	elementTobeAppear(toastmessage);
	Thread.sleep(3000);
	
}

}


package SeleniumHybridFramework.Liveproject1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumHybridFramework.basetest.Basetest;

public class Standsubmit1 extends Basetest {

@Test
public void submitOrder() throws InterruptedException, IOException

		{
			String productname = "ZARA COAT 3";
			Landingpage landingpage= launchApplication();
			productcatalogue productcatalogue= landingpage.loginwithValidCredentials("practice1123@gmail.com", "Aa@12345678");
			List<WebElement> products= productcatalogue.selectProducts();
			productcatalogue.addProductToCart(productname);
			productcatalogue.goToCartPage();
		//	Cartpage cartpage= new Cartpage(driver);
				
//		boolean match= cartpage.addedProducts(productname);
	//	Assert.assertTrue(match);
	//	cartpage.checkoutItems();
//		CheckoutPage checkoutPage = new CheckoutPage(driver);
//		checkoutPage.selectCountry("India");
//		checkoutPage.submitOrder();
//		Confirmationpage confirmationpage= new Confirmationpage(driver);
//		String s=	confirmationpage.verifymessage();
//			Assert.assertTrue(s.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//			driver.close();

		}
}
	

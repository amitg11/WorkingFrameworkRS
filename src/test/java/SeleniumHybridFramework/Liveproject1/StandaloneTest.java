package SeleniumHybridFramework.Liveproject1;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {

		{
			String productname = "ZARA COAT 3";
		//	WebDriverManager.edgedriver().setup();
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
			driver.get("https://rahulshettyacademy.com/client");
			driver.manage().window().maximize();
			driver.findElement(By.id("userEmail")).sendKeys("practice1123@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Aa@12345678");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(3000));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

			WebElement prod = products.stream()
					.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname))
					.findFirst().orElse(null);

			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
			WebElement carticon;
			Thread.sleep(3000);
			carticon = driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"));
			carticon.click();

			List<WebElement> cartprod = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

			boolean match = cartprod.stream().anyMatch(prod1 -> prod1.getText().equalsIgnoreCase(productname));
			Assert.assertTrue(match);

			driver.findElement(By.xpath("//div/ul/li[3]/button")).click();
			// driver.findElement(By.xpath("//*[@placeholder='Select
			// Country']")).sendKeys("India");
			Actions a = new Actions(driver);

			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
			WebElement send = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
			send.click();
			send.sendKeys("India");
			Actions ac = a.moveToElement(driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")))
					.click();
			ac.build().perform();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
			 driver.findElement(By.cssSelector(".action__submit")).click();
			
		
			String s = driver.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertTrue(s.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			//driver.close();

		}

	}
}

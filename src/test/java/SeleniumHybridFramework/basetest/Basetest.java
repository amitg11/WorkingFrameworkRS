package SeleniumHybridFramework.basetest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import SeleniumHybridFramework.Liveproject1.Cartpage;
import SeleniumHybridFramework.Liveproject1.Landingpage;

public class Basetest {
	
	WebDriver driver;
	Landingpage landingpage;
	
	
	public WebDriver intializeDriver() throws IOException
	{
		WebDriver driver = new EdgeDriver();
//	Properties pro = new Properties();
//	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumHybridFramework\\resources\\Globaldata.properties");
//	pro.load(file);		
//	String browsername= pro.getProperty("browser");
//	if(browsername.equalsIgnoreCase("Chrome"))
//	{
//	
//		//	WebDriverManager.edgedriver().setup();
//			WebDriverManager.chromedriver().setup();
//			 driver = new ChromeDriver();
//				
//	}
//	else if(browsername.equalsIgnoreCase("edge"))
//	{
//		System.setProperty("webdriver.edge.driver", "D:\\Softwares\\selenium-server\\115_Edgedriver\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
	return driver;

}
	
	public Landingpage launchApplication() throws IOException
	{
		driver= intializeDriver();
		//driver.manage().window().maximize();
		Landingpage pagelands= new Landingpage(driver);
		pagelands.goTO();
	//	landingpage.goTO();
		return pagelands;
	}
	
	
}

package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Browsers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver ;
	}
	
	public static WebDriver openOperasBrowser()
	{
		System.setProperty("webdriver.opera.driver", "F:\\Automation Class\\New Chrome 2022\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver ;
	}

}

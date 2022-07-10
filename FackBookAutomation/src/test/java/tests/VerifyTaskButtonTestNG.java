package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browsers.Base;
import pom.Headers;
import pom.LoginPage;
import utils.Utility;

public class VerifyTaskButtonTestNG extends Base{
	
	WebDriver driver ;
	Headers headers ;
	LoginPage loginPage ;
	int testID ;
	
	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(String browser) {
		System.out.println("before test");
		
		if(browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browser.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		if(browser.equals("Opera"))
		{
			driver = openOperasBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMOobjects() {
		loginPage = new LoginPage(driver);
		headers = new Headers(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() {
		System.out.println("before method");
		driver.get("http://desktop-b2220qc/login.jsp");

		String userName = Utility.getDataFromExcel("DataSheet", 1, 0);
		loginPage.sendUserName(userName);
		
		String password = Utility.getDataFromExcel("DataSheet", 1, 1);
		loginPage.sendPassword(password);
		
		loginPage.selectKeepMeLogin();
		loginPage.clickOnLogin();
	}
	
	@Test
	public void toVerifyTaskButton() {
		testID = 10101;
		
		System.out.println("test A");
		headers.openTasks();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "http://desktop-b2220qc/tasks/otasklist.do");
		Assert.assertEquals(title, "actiTIME - Open Tasks");
		
	}
	
	@Test
	public void toVerifyReportButton() {
		testID = 10121 ;
		System.out.println("test B");
		
		headers.openReportsTrack();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(url);
		System.out.println(title);

	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) {
		System.out.println("after method");
		
		if(ITestResult.FAILURE == result.getStatus() )
		{
			Utility.capturetScreen(driver, testID);
		}
		
		headers.clickOnLogout();
	}
	
	@AfterClass
	public void clearObject() {
		loginPage = null ;
		headers = null;
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("after class");
		driver.quit();
		driver = null;
		System.gc(); // garbage collector
	}
	


}

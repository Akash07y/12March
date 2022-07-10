package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy (xpath = "//input[@name='username']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@name='pwd']") 
	private WebElement password ;
	
	@FindBy (xpath = "//input[@name='remember']") 
	private WebElement keepMeLoginCheckbox ;
	
	@FindBy (xpath = "//a[text()='Login']") 
	private WebElement loginButton ;
	
	@FindBy (xpath = "common matching xpath") 
	private List<WebElement> ele ;
	
	private WebDriver driver ;
	private WebDriverWait wait ;
	private Actions action;
	
	public LoginPage(WebDriver driver)  // driver1 = driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		action = new Actions(driver);
	}
	
	public void sendUserName(String user) {
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(userName));
	
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	
	public void selectKeepMeLogin() {
		keepMeLoginCheckbox.click();
		action.moveToElement(keepMeLoginCheckbox).click().build().perform();
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	
	// OR
	
	public void loginToApplication() {
		userName.sendKeys("admin");
		password.sendKeys("manager");
		keepMeLoginCheckbox.click();
		loginButton.click();
	}
	
	
	
	
}

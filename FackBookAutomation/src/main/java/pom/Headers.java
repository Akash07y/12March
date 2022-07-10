package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Headers {

	@FindBy (xpath = "//a[@class='content tt']") 
	private WebElement timetrack ;
	
	@FindBy (xpath = "//a[@class='content tasks']") 
	private WebElement task ;
	
	@FindBy (xpath = "//a[@class='content reports']") 
	private WebElement report ;
	
	@FindBy (xpath = "//a[@class='content users']") 
	private WebElement user;
	
	@FindBy (xpath = "//a[text()='Logout']") 
	private WebElement logout;
	
	public Headers(WebDriver driver)  // driver1 = driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openTimeTrack() {
		timetrack.click();
	}
	
	public void openTasks() {
		task.click();
	}
	
	public void openReportsTrack() {
		report.click();
	}
	
	public void openUserList() {
		user.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
}

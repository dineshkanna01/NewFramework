package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Login extends AbstractBasePage{
	
	public Admin_Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	@FindBy(name="j_username")
	WebElement uName;
	
	
	
	@FindBy(name="j_password")
	WebElement pWord;
	
	@FindBy(name="submit")
	WebElement subMit;

	public Admin_Login loginPage() {
		
		uName.sendKeys("dinesh.kanna");
		pWord.sendKeys("Disser@01");
		subMit.click();
		
		return null;

	}
	
}

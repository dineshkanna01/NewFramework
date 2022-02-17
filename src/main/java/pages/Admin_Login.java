package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Helper;

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

	@FindBy(id="next")
	WebElement nxt;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitbutton;
	
	@FindBy(xpath = "//*[@class='dropdown']")
	WebElement myAccount;

	@FindBy(xpath = "//*[@class='dropdown-content pull-right']/a[4]")
	WebElement logoutButton;
	
	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement mailId;
	
	@FindBy(className="VfPpkd-vQzf8d")
	WebElement idNext;
	
	public Admin_Login loginPage() throws Exception {

		uName.sendKeys("dkanna");
		pWord.sendKeys("Pa$$word08");
		subMit.click();
		nxt.click();
		
//		Email_OTP emailotp = new Email_OTP();
//		String otp = Email_OTP.emailOTP();
//		System.out.println("email OTP is ............." + otp);
		
		submitbutton.click();
		myAccount.click();
		logoutButton.click();
		return null;

	}
	
	public void otp() {

		Helper.initilization_Gmail();
		Helper.implict(10);
		mailId.sendKeys("dinesh.kanna@pegs.com");
		idNext.click();
		
	}
	
	public Admin_Login logOut() {
		
		myAccount.click();
		logoutButton.click();
		return null;
		

	}

}

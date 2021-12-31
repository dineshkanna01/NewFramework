package pages;

import Utility.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class CancelBookingPage extends AbstractBasePage{

	public CancelBookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	@FindBy(id="reservation-lookup")
	WebElement myBooking;
	
	@FindBy(id="confirmation-code")
	WebElement conCode;
	
	@FindBy(id="confirmation-email")
	WebElement conEmail;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement lookup;
	
	@FindBy(xpath ="//a[text()=\"Got it!\"]")
	WebElement gotIt;
	
	@FindBy(xpath ="//a[contains(text(),'Cancel reservation')]")
	WebElement canReservation;
	
	@FindBy(xpath ="//span[text()=\"No\"]")
	WebElement clickNo;
	
	@FindBy(id="summary_reservation_confirmation_code")
	WebElement confirmCode;
	
	@FindBy(xpath="//strong[contains(text(),'qtest')]")
	WebElement qtestCode;
	
	
	public CancelBookingPage cancelBooking(String code, String email) throws Exception {
		myBooking.click();
//		Thread.sleep(2000);
		TestBase.implict(3);
		conCode.sendKeys(code);
		conEmail.sendKeys(email);
//		BrowserFactory.screenShot("MybookingPage");
//		Thread.sleep(2000);
		TestBase.implict(3);
		lookup.click();
//		Thread.sleep(3000);
		TestBase.implict(3);
		String txtCode = qtestCode.getText();
		Thread.sleep(1000);
		System.out.println("Cancellation ID: "+txtCode);
		
//		Assert.assertEquals(txtCode, "QTEST1100001797");
//		gotIt.click();
		canReservation.click();
		Thread.sleep(1000);
		clickNo.click();
		return null;
	}
}

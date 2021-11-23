package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CancelBookingPage extends TestBase{

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
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
	
	@FindBy(xpath ="//a[text()=\"Cancel reservation\"]")
	WebElement canReservation;
	
	@FindBy(xpath ="//span[text()=\"No\"]")
	WebElement clickNo;
	
	
	public CancelBookingPage cancelBooking(String code, String email) throws Exception {
		myBooking.click();
		conCode.sendKeys(code);
		conEmail.sendKeys(email);
		screenShot("MybookingPage");
		lookup.click();
		Thread.sleep(1000);
		gotIt.click();
		canReservation.click();
		Thread.sleep(1000);
		clickNo.click();
		return null;
	}
}

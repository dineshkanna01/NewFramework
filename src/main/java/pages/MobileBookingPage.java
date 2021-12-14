package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;

public class MobileBookingPage extends AbstractBasePage{
	
ExcelData e = new ExcelData();
	
	public MobileBookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	@FindBy(xpath ="//a[text()=\"Got it!\"]")
	WebElement gotIt;
	
	@FindBy(xpath="//div[text()=\"29\"]")
	WebElement arrivalDate;
	
	@FindBy(xpath="//div[text()=\"30\"]")
	WebElement departureDate;
	
	@FindBy(xpath="//button[text()=\"Select Room\"]")
	WebElement select;
	
	@FindBy(xpath="(//span[@class=\"clearfix\"])[1]")
	WebElement nextPage;
	
	@FindBy(name="commit")
	WebElement continu;
	
	@FindBy(xpath="//input[@title=\"Bed type preference\"]")
	WebElement bedType;
	
	@FindBy(xpath="//li[text()=\"King\"]")
	WebElement bedSize;
	
	@FindBy(id="details_form_roomer_attributes_full_name")
	WebElement fullName;
	
	@FindBy(id="details_form_roomer_attributes_phone_number")
	WebElement phNo;
	
	@FindBy(id="details_form_roomer_attributes_email")
	WebElement email;
	
	@FindBy(id="details_form_billing_address_attributes_address")
	WebElement address;
	
	@FindBy(xpath="//input[@placeholder=\"Country\"]")
	WebElement selectCon;
	
	@FindBy(xpath="//li[text()=\"India\"]")
	WebElement countryName;
	
	@FindBy(xpath="//select[@placeholder=\"State\"]")
	WebElement selectState;
	
	@FindBy(xpath="//option[text()=\"Tamil Nadu\"]")
	WebElement stateName;
	
	@FindBy(id="details_form_billing_address_attributes_city")
	WebElement city;
	
	@FindBy(id="details_form_billing_address_attributes_zipcode")
	WebElement zipcode;
	
	@FindBy(id="accept-tandc")
	WebElement accept;
	
	@FindBy(xpath="//button[text()=\"Complete Reservation\"]")
	WebElement resComplete;
	
	@FindBy(xpath="//span[contains(text(),'qtest11')]")
	WebElement conId;
	
	@FindBy(id="cardName")
	WebElement cName;
	
	@FindBy(id="details_form_credit_card_attributes_card_number")
	WebElement cNum;
	
	@FindBy(id="details_form_credit_card_attributes_expiration_date")
	WebElement eDate;
	
	@FindBy(id="cardCsc")
	WebElement cCsc;
	
	@FindBy(xpath="(//input[@title=\"Country\"])[2]")
	WebElement cCountry;
	
	@FindBy(xpath="//li[text()=\"India\"]")
	WebElement cState;
	
	@FindBy(id="card_zip")
	WebElement cZip;
	
	
	
	
	
	public MobileBookingPage completeReservation() throws Exception {
		
		gotIt.click();
		arrivalDate.click();
		departureDate.click();
		select.click();
		nextPage.click();
		continu.click();
		bedType.click();
		bedSize.click();
		fullName.sendKeys("Dineshkanna");
		phNo.sendKeys("8992244499");
		email.sendKeys("dinesh.kanna@igtsolutions.com");
		address.sendKeys("Chennai");
		selectCon.click();
		countryName.click();
		selectState.click();
		stateName.click();
		city.sendKeys("Chennai");
		zipcode.sendKeys("600066");
		cName.sendKeys("Dineshkanna");
		cNum.sendKeys("4111");
		cNum.sendKeys("1111");
		cNum.sendKeys("1111");
		cNum.sendKeys("1111");
		eDate.sendKeys("04");
		eDate.sendKeys("23");
		cCsc.sendKeys("222");
		cCountry.click();
		cState.click();
		
		cZip.sendKeys("600044");
		accept.click();
		resComplete.click();
		
		String text = conId.getText();
		System.out.println("Confirmation Code: "+text);
		TestBase.screenShot("Mobile Booking Confirmation");
		
		return null;

	}
	
	
	
}

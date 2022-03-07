package com.mb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.be.pom.AccessCodeBookingPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class MobileBookingsWithValidOfferCodePage  extends TestBase{
	public WebDriver driver;
	public MobileBookingsWithValidOfferCodePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//div[text()='Rate Plans']")
	WebElement ratePlan;

	@FindBy(xpath = "(//*[contains(@href,'manageRatePlan')])[1]")
	WebElement accessCode;

	@FindBy(xpath = "//input[@name='selectedRatePlanName']")
	WebElement selectRatePlan;

	@FindBy(xpath = "//a[@tabindex='-1']")
	WebElement SummerSpecialSS;                                    //span[text()='1569']

	@FindBy(xpath = "//input[@name='go']")
	WebElement GO;

	@FindBy(xpath = "(//*[contains(@href,'#')])[1]")
	WebElement addAccessCode;

	@FindBy(xpath = "//input[@name='accessCode']")
	WebElement addAccessCodeText;

	@FindBy(xpath = "//input[@name='save']")
	WebElement save;
	
	@FindBy(xpath = "(//a[text()='Edit'])[2]")
	WebElement editAccessCode;
	
	@FindBy(xpath = "(//td[@width='300'])[last()]")
	WebElement accessCodeName;
	
	public String UrlTilte() {
		return driver.getTitle();

	}

	/*
	 * Method to input offercode details
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage invalidOfferCodeReservation() {
		Helper.sleep(2000);
//		WebElement a1 = getDriver().findElement(By.xpath("//button[@class='rate-button -to-slim test']"));
//		a1.click();
		Helper.clickEle("//button[@class='rate-button -to-slim test']");
		Helper.eleXpath("//input[@placeholder='Enter code']", ExcelData.getCellData("MobileB", "InvalidOfferCode", 2));
		Helper.clickEle("//span[text()='Search']");
		Helper.sleep(5000);
		
		return null;
	}
	
	
	
	/*
	 * Method to input edited offercode details
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage editedOfferCodeReservation() {
		Helper.sleep(2000);
//		WebElement a1 = getDriver().findElement(By.xpath("//button[@class='rate-button -to-slim test']"));
//		a1.click();
		Helper.clickEle("//button[@class='rate-button -to-slim test']");
		Helper.eleXpath("//input[@placeholder='Enter code']", ExcelData.getCellData("MobileB", "EditOfferCode", 2));
		Helper.clickEle("//span[text()='Search']");
		Helper.sleep(5000);
		
		return null;
	}
	
	/*
	 * Method to verify invalid offercode
	 * 
	 */
public boolean verifyInvalidOfferCode() {
	WebElement invalidOfferCodeWarning = Helper.abcd("//div[@class='pull-right color-red ng-binding ng-scope']");
	if (invalidOfferCodeWarning.isDisplayed()) {
		String code = invalidOfferCodeWarning.getText();
		System.out.println("Invalid Offer Code Warning is: " + code);
		return true;
	} else {
		System.out.println("NA");
		return false;
	}
}

/*
 * Method to verify valid offercode
 * 
 */
public boolean verifyValidOfferCode() {
WebElement validOfferCodeWarning = Helper.abcd("//div[@class='modal-body -theme-border']");
if (validOfferCodeWarning.isDisplayed()) {
	String code = validOfferCodeWarning.getText();
	System.out.println("Offer Code applied verification : " + code);
	return true;
} else {
	System.out.println("NA");
	return false;
}
}

/*
 * Method to  config access code
 * 
 */
public MobileBookingsWithInvalidOfferCodePage createAccessCode1()  {
	ratePlan.click();
	accessCode.click();
	selectRatePlan.sendKeys(ExcelData.getCellData("MobileB", "RatePlan", 2));
	SummerSpecialSS.click();
	GO.click();
	addAccessCode.click();
	addAccessCodeText.sendKeys(ExcelData.getCellData("MobileB", "InvalidOfferCode", 2));
	save.click();
	return null;
}

/*
 * Method to select the date range
 * 
 */
public MBPNormalMobileBookingwithAdultsandChild dateSelection() {
	Helper.clickEle("//button[@class='button -block -theme-bg']");
	Helper.currentDate();
	Helper.nextDate();
	Helper.implict(2);
	Helper.clickEle("//a[contains(text(),'Got it!')]");
	Helper.clickEle("//button[@class='button -block -lg -theme-bg get-recap-token']");
	
	return null;
}

/*s
 * Method to select no of guest TC01
 * 
 */
public MBPNormalMobileBookingwithAdultsandChild selectGuest() {
	//Helper.clickEle("//button[@class='button -block -theme-bg']");
	Helper.clickEle("//button[@class=\"navbar_button text-capitalize\"]");
	Helper.clickEle("(//button[@class='rangepicker_plus -theme-color'])[2]");
	Helper.clickEle("//input[@value='Done']");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	Helper.clickEle("//button[@class='button -block -theme-bg']");
	Helper.clickEle("//a[contains(text(),'Got it!')]");
	Helper.clickEle("//button[@class='button -block -lg -theme-bg get-recap-token']");
	Helper.clickEle("//button[@class='button -block -theme-bg']");
	return null;
}

/*
 * Method to select room type
 * 
 */
public MBPNormalMobileBookingwithAdultsandChild selectRoom() {
	Helper.clickEle("(//img[@class='comp-rm-arrow'])[1]");
	return null;
}

/*
 * Method to select offer
 * 
 */
public MBPNormalMobileBookingwithAdultsandChild avlOffers() {
	Helper.implict(8);
	Helper.clickEle("//label[@class='radio']");
	Helper.clickEle("//input[@data-disable-with='Continue']");
	return null;
}
/*
 * Method to input all details
 * 
 */
public MBPNormalMobileBookingwithAdultsandChild comReservation() {
	Helper.implict(8);
	Helper.eleXpath("//input[@title=\"Full Name\"]", ExcelData.getCellData("MobileB", "FullName", 2));
	Helper.eleXpath("//input[@title=\"Phone number\"]", ExcelData.getCellData("MobileB", "PhoneN", 2));
	Helper.eleXpath("//input[@title=\"Email\"]", ExcelData.getCellData("MobileB", "Email", 2));
	Helper.eleXpath("//input[@title=\"Address\"]", ExcelData.getCellData("MobileB", "Address", 2));
	Helper.clickEle("(//input[@placeholder=\"Country\"])[1]");
	Helper.eleXpath("(//input[@placeholder=\"Search\"])[1]", ExcelData.getCellData("MobileB", "Country", 2));
	Helper.coXpath();
	Helper.stXpath();
	Helper.eleXpath("//input[@placeholder=\"City\"]", ExcelData.getCellData("MobileB", "City", 2));
	Helper.eleXpath("(//input[@placeholder=\"Zip code\"])[1]", ExcelData.getCellData("MobileB", "ZipCode", 2));
	Helper.eleXpath("//input[@placeholder=\"Name on card\"]", ExcelData.getCellData("MobileB", "FullName", 2));
	Helper.eleXpath("//input[@placeholder=\"Card number\"]", ExcelData.getCellData("MobileB", "CardNum", 2));
	Helper.eleXpath("//input[@placeholder=\"Card number\"]", ExcelData.getCellData("MobileB", "CardNum", 3));
	Helper.eleXpath("//input[@placeholder=\"Card number\"]", ExcelData.getCellData("MobileB", "CardNum", 4));
	Helper.eleXpath("//input[@placeholder=\"Card number\"]", ExcelData.getCellData("MobileB", "CardNum", 5));
	Helper.eleXpath("//input[@placeholder=\"Expiration (MM/YY)\"]", ExcelData.getCellData("MobileB", "ExpD", 2));
	Helper.eleXpath("//input[@placeholder=\"Expiration (MM/YY)\"]", ExcelData.getCellData("MobileB", "ExpD", 3));
	Helper.eleXpath("//input[@placeholder=\"Code\"]", ExcelData.getCellData("MobileB", "CCode", 2));
	Helper.clickEle("(//input[@placeholder=\"Country\"])[2]");
	Helper.eleXpath("(//input[@placeholder=\"Country\"])[2]", ExcelData.getCellData("MobileB", "Country", 2));
	Helper.coXpath2();
	Helper.eleXpath("(//input[@placeholder=\"Zip code\"])[2]", ExcelData.getCellData("MobileB", "ZipCode", 2));
	Helper.clickEle("(//input[@class='tandc-checkbox'])");
	Helper.clickEle("(//button[@class='button -xlg -block -theme-bg'])");
	Helper.sleep(5000);
	return null;
}

/*
 * Method to verify reservation
 * 
 */
public boolean verifyConfirmationCode() {
	WebElement confirmcode = Helper.abcd("//span[text()='Confirmation code #']//following::span[1]");
	if (confirmcode.isDisplayed()) {
		String code = confirmcode.getText();
		System.out.println("Confirmation code is: " + code);
		return true;
	} else {
		System.out.println("NA");
		return false;
	}
}

/*
 * Method to edit access code 
 * 
 */
public AccessCodeBookingPage editCreatedAccessCode()  {
//	ratePlan.click();
//	accessCode.click();
//	selectRatePlan.sendKeys(ExcelData.getCellData("Booking", "RatePlan", 2));
//	SummerSpecialSS.click();
//	GO.click();
	editAccessCode.click();
	addAccessCodeText.clear();
	addAccessCodeText.sendKeys(ExcelData.getCellData("MobileB","EditOfferCode", 2));
	save.click();
	return null;
}
/*
 * Method to verify  access code edited
 *  returns boolean value
 * 
 */
public boolean verifyAccessCodeCreated()  {
	String ActText =(ExcelData.getCellData("MobileB", "InvalidOfferCode", 2));
	System.out.println(ActText + " Actual Text");
	String expText =accessCodeName.getText();
	System.out.println(expText + " " + "ExpectedText");
	if (ActText.equalsIgnoreCase(expText)) {
		System.out.println(" access code rate plan created");
		return true;
	} else {
		System.out.println("access code rate plan not created");
		return false;

	}
}

/*
 * Method to verify  access code edited
 *  returns boolean value
 * 
 */
public boolean verifyAccessCodeEdited()  {
	String ActText =(ExcelData.getCellData("MobileB", "EditOfferCode", 2));
	System.out.println(ActText + " Actual Text");
	String expText =accessCodeName.getText();
	System.out.println(expText + " " + "ExpectedText");
	if (ActText.equalsIgnoreCase(expText)) {
		System.out.println(" access code rate plan edited");
		return true;
	} else {
		System.out.println("access code rate plan not edited");
		return false;

	}
}
}

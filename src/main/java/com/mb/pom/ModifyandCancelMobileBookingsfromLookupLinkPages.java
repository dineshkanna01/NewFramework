package com.mb.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.AboutThePropertyPages;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class ModifyandCancelMobileBookingsfromLookupLinkPages extends TestBase {
	public WebDriver driver;

	public ModifyandCancelMobileBookingsfromLookupLinkPages(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "")
	WebElement confirmMailId;

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to select the date range
	 * 
	 */
	public MBPNormalMobileBookingwithAdultsandChild dateSelection() {
		Helper.currentDate();
		Helper.nextDate();
		Helper.implict(2);
		return null;
	}

	/*
	 * Method to select no of guest TC01
	 * 
	 */
	public MBPNormalMobileBookingwithAdultsandChild noAdult() {
		Helper.clickEle("//button[@class=\"navbar_button text-capitalize\"]");
		Helper.clickEle("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.clickEle("//input[@value='Done']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Helper.clickEle("//a[contains(text(),'Got it!')]");
		Helper.clickEle("//button[@class='button -block -lg -theme-bg get-recap-token']");
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
		Helper.clickEle("(//label[@class=\"radio\"])[1]");
		Helper.clickEle("//input[@data-disable-with='Continue']");
		return null;
	}

	/*
	 * Method to input all booking details
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
	 * Method to get Confirmation code
	 */
	public AboutThePropertyPages getConfirmationNo() {
		WebElement confirmcode = Helper.abcd("//span[text()='Confirmation code #']//following::span[1]");
		String b = confirmcode.getText();
		System.out.println("Confirmation code  " + b);
		ExcelData.write_CellData("LoginPageData", 1, 10, b);
		return null;
	}

	/*
	 * Method to get Confirmation code
	 */
	public AboutThePropertyPages getConfirmationMailId() {
		String b = confirmMailId.getText();
		System.out.println("Confirmation code" + b);
		ExcelData.write_CellData("LoginPageData", 1, 11, b);
		return null;
	}

	/*
	 * Method to input details in mob lookup
	 */
	public CancelWebBookingFromMobilePages MobLookup() {
		Helper.clickEle("//em[@class='header_toggle_lines']");
		Helper.clickEle("//a[text()='My reservations']");
		Helper.sleep(5000);
		// Helper.eleXpath("//input[@id='confirmation_code']",
		// ExcelData.getCellData("LoginPageData", "WebConfirmCode", 2));
		Helper.eleXpath("//input[@id='email']", ExcelData.getCellData("LoginPageData", "MobConfirmMailId", 2));
		Helper.eleXpath("//input[@id='confirmation_code']",
				ExcelData.getCellData("LoginPageData", "MobConfirmCode", 2));
		Helper.clickEle("//button[text()='Lookup']");
		return null;
	}

	/*
	 * Method to scroll down
	 * 
	 */
	public CancelWebBookingFromMobilePages scrollDownTen() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		return null;
	}
	/*
	 * Method to cancel reservation
	 */
	public CancelWebBookingFromMobilePages clickOnCancelinMobWebBEReservation()  {
		Helper.sleep(5000);
		//Helper.clickEle("//a[contains(text(),'Got it!')]");
		Helper.clickEle("//button[text()='Cancel reservation']");
		Helper.clickEle("//span[text()='Yes']");
		return null;
	}
	/*
	 * Method to call hotel reservation
	 */
	public CancelWebBookingFromMobilePages clickOnCallHotelinMobWebBEReservation()  {
		Helper.sleep(5000);
		//Helper.clickEle("//a[contains(text(),'Got it!')]");
		Helper.clickEle("//button[text()='Change reservation']");
		//Helper.clickEle("//a[text()='Call Hotel']");
		//Helper.clickEle("//span[text()='Yes']");
		return null;
	}
	/*
	 * Method to get cancellation code 
	 */
	public boolean verifyMobileCancellationCode() {
		WebElement cancellation = Helper.abcd("(//div[@class='content']/p)[2]");
		if (cancellation.isDisplayed()) {
			String code = cancellation.getText();
			System.out.println("Cancellation code is: " + code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
	/*
	 * Method to verify reservation
	 * 
	 */
	public boolean verifyCallHotelOption() {
		WebElement callHotelOption = Helper.abcd("//a[text()='Call Hotel']");
		if (callHotelOption.isDisplayed()) {
			String code = callHotelOption.getText();
			System.out.println("To modify the mobile  reservation: " + code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
}
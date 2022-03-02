package com.mb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class MBPNormalMobileBookingwithAdultsandChild extends TestBase {

	public WebDriver driver;

	public MBPNormalMobileBookingwithAdultsandChild(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@aria-label=\"dismiss cookie message\"]")
	WebElement gotIt;

	@FindBy(xpath = "//button[@class=\"navbar_button text-capitalize\"]")
	WebElement dDselect;

	// button[@class='navbar_button text-capitalize']
	@FindBy(xpath = "(//button[@class='rangepicker_plus -theme-color'])[1]")
	WebElement addAdult;

	@FindBy(xpath = "(//button[@class='rangepicker_plus -theme-color'])[2]")
	WebElement addChild;

	@FindBy(xpath = "//input[@title=\"Full Name\"]")
	WebElement fullName;

	@FindBy(xpath = "//span[text()='Confirmation code #']")
	WebElement confirmcodeHeading;

//	@FindBy(xpath = "//span[text()='Confirmation code #']//following::span[1]")
//	WebElement confirmcode;

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
	public MBPNormalMobileBookingwithAdultsandChild noAdultTC01() {
		Helper.javaScript("//button[@class=\"navbar_button text-capitalize\"]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("//input[@value='Done']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Helper.javaScript("//a[contains(text(),'Got it!')]");
		Helper.javaScript("//button[@class='button -block -lg -theme-bg get-recap-token']");
		return null;
	}

	/*
	 * Method to select no of guest TC02
	 * 
	 */
	public MBPNormalMobileBookingwithAdultsandChild noAdultTC02() {
		Helper.sleep(3000);
		Helper.javaScript("//button[@class=\"navbar_button text-capitalize\"]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[1]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[1]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("//input[@value='Done']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Helper.javaScript("//a[contains(text(),'Got it!')]");
		Helper.javaScript("//button[@class='button -block -lg -theme-bg get-recap-token']");
		return null;
	}

	/*
	 * Method to select no of guest TC03
	 * 
	 */
	public MBPNormalMobileBookingwithAdultsandChild noAdultTC03() {
		Helper.javaScript("//button[@class=\"navbar_button text-capitalize\"]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");
		Helper.javaScript("//input[@value='Done']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Helper.javaScript("//a[contains(text(),'Got it!')]");
		Helper.javaScript("//button[@class='button -block -lg -theme-bg get-recap-token']");
		return null;
	}

	/*
	 * Method to select room type
	 * 
	 */
	public MBPNormalMobileBookingwithAdultsandChild selectRoom() {
		Helper.javaScript("(//img[@class='comp-rm-arrow'])[1]");
		return null;
	}

	/*
	 * Method to select offer
	 * 
	 */
	public MBPNormalMobileBookingwithAdultsandChild avlOffers() {
		Helper.implict(8);
		Helper.javaScript("(//label[@class=\"radio\"])[2]");
		Helper.javaScript("//input[@data-disable-with='Continue']");
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
		Helper.javaScript("(//input[@placeholder=\"Country\"])[1]");
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
		Helper.javaScript("(//input[@placeholder=\"Country\"])[2]");
		Helper.eleXpath("(//input[@placeholder=\"Country\"])[2]", ExcelData.getCellData("MobileB", "Country", 2));
		Helper.coXpath2();
		Helper.eleXpath("(//input[@placeholder=\"Zip code\"])[2]", ExcelData.getCellData("MobileB", "ZipCode", 2));
		Helper.javaScript("(//input[@class='tandc-checkbox'])");
		Helper.javaScript("(//button[@class='button -xlg -block -theme-bg'])");
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
}

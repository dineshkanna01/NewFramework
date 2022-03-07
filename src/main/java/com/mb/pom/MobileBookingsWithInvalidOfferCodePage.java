package com.mb.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class MobileBookingsWithInvalidOfferCodePage  extends TestBase {
	public WebDriver driver;
	public MobileBookingsWithInvalidOfferCodePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();

	}
	
	/*
	 * Method to input offercode details
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage invalidOfferCodeReservation() {
		Helper.javaScript("//button[@class='rate-button -to-slim test']");
		Helper.eleXpath("//input[@placeholder='Enter code']", ExcelData.getCellData("MobileB", "InvalidOfferCode", 2));
		Helper.javaScript("//span[text()='Search']");
		Helper.sleep(5000);
		return null;
	}
	
	/*
	 * Method to verify offercode
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
}
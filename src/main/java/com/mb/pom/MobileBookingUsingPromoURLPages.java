package com.mb.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class MobileBookingUsingPromoURLPages extends TestBase {
	public WebDriver driver;

	public MobileBookingUsingPromoURLPages(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Rate Plans']")
	WebElement ratePlan;

	@FindBy(xpath = "//*[contains(@href,'retrieveRateTypes.do')]")
	WebElement ratePlanListAll;

	public String UrlTilte() {
		return driver.getTitle();

	}

	/*
	 * Method to click on rateplan
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage clickRatePlan() {
		ratePlan.click();
		ratePlanListAll.click();
		return null;
	}

	/*
	 * Method to click on edit
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage editRatePlan() {
		String rp = ExcelData.getCellData("MobileB", "RatePlan", 2);
		Helper.clickEle("//td[contains(text(),'" + rp + "')]//following::a[1]");
		return null;
	}
	/*
	 * Method to right click on the element
	 * 
	 */

	public MobileBookingsWithInvalidOfferCodePage copyPromoURL() throws Exception {
		Helper.mouseOver("(//*[contains(@href,'promoRate?')])[1]");
		Helper.robotClass();
		return null;
		}
}
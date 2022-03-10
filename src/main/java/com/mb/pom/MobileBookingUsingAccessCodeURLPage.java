package com.mb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class MobileBookingUsingAccessCodeURLPage extends TestBase {

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
	
	@FindBy(xpath = "(//a[@target='_blank'])[3]")
	WebElement uRL;
	
	@FindBy(xpath = "//a[text()='My bookings']")
	WebElement webText;
	
	
	

	
	
	
	public MobileBookingUsingAccessCodeURLPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	
	}
	
	
	/*
	 * Method to inputFieldTc_01
	 * 
	 */
	public MobileBookingUsingAccessCodeURLPage inputFieldTc_01()  {
		ratePlan.click();
		accessCode.click();
		selectRatePlan.sendKeys(ExcelData.getCellData("MobileB", "RatePlan", 2));
		SummerSpecialSS.click();
		GO.click();
		Helper.sleep(5000);
//	   Helper.mouseOver("(//a[@target='_blank'])[3]");
//	   Helper.robotClass();
		return null;
	}
	
	public MobileBookingUsingAccessCodeURLPage getAccessCodeUrl() {
		WebElement promoUrl = getDriver().findElement(By.xpath("//a[contains(text(),'promoRate')]"));
		String attribute = promoUrl.getAttribute("href");
		System.out.println("copiedUrl: "+attribute);
		ExcelData.write_MBCellData("LoginPageData", 4, 0, attribute);
		return null;

	}
	
	/*
	 * Method to inputFieldTc_01
	 * 
	 */
	public MobileBookingUsingAccessCodeURLPage inputFieldTc_02()  {
		ratePlan.click();
		accessCode.click();
		selectRatePlan.sendKeys(ExcelData.getCellData("MobileB", "RatePlan", 2));
		SummerSpecialSS.click();
		GO.click();
	    uRL.click();
	    Helper.sleep(6000);
		return null;
	}
	
	/*
	 * Method to verify reservation
	 * 
	 */
	public boolean verifyWebBookingPage() {
		if (webText.isDisplayed()) {
			System.out.println("Web Booking page display");
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
	
	
}

package com.cc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class DenialReasonineverypageofbookingPage extends TestBase {

	@FindBy(xpath = "//a[@data-target=\"#denial_reason\"]")
	WebElement denialReasonField;
	@FindBy(name = "reason")
	WebElement reason;
	@FindBy(xpath = "//textarea[@id=\"exampleTextarea\"]")
	WebElement commentField;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement saveReason;
	@FindBy(xpath = "//button[text()='Start Over']")
	WebElement startOver;
	@FindBy(xpath = "//h3[text()='Reason for denial']")
	WebElement denialPopupHead;

	public DenialReasonineverypageofbookingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to verify Denial Reason field visibilty
	 * 
	 */
	public boolean verifyDenialReasonVisible() {
		if (denialReasonField.isDisplayed()) {
			String a = denialReasonField.getText();
			System.out.println(a+ " field is displayed");
			return true;
		} else {
			System.out.println("Denial Reason field is not displayed");
			return false;
		}
	}
	
	/*
	 * Method to click Denial Reason Field
	 * 
	 */
	public DenialReasonineverypageofbookingPage clickDenialReasonField() {
		denialReasonField.click();
		return null;
	}

	/*
	 * Method to input Denial Reason
	 * 
	 */
	public DenialReasonineverypageofbookingPage inputDenialReason() {
		Select a = new Select(reason);
		a.selectByVisibleText(ExcelData.CC_getCellData("DenialReason", "Reason", 2));
		Helper.explicit(commentField, 10);
		commentField.sendKeys(ExcelData.CC_getCellData("DenialReason", "Comment", 2));
		saveReason.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Method to get title Before selecting denial reason
	 * 
	 */
	public DenialReasonineverypageofbookingPage titleBefore() {
		String t = getDriver().getTitle();
		System.out.println("title before is "+t);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 33,t);
		return null;
	}
	
	
	/*
	 * Method to get title After selecting denial reason
	 * 
	 */
	public DenialReasonineverypageofbookingPage titleAfter() {
		String t = getDriver().getTitle();
		System.out.println("title after is "+t);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 34,t);
		return null;
	}
	
	/*
	 * Method to verify title of page before after denial reason selection are same or not
	 */
	public boolean verifyTitle() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "TitleBefore", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "TitleAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("user is navigated to homepage");
			return true;
		} else {
			System.out.println("user is not navigated to homepage");
			return false;
		}
	}
	
	/*
	 * Method to click start over
	 * 
	 */
	public DenialReasonineverypageofbookingPage clickstartOver() {
	startOver.click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	return null;
	}
	
	/*
	 * Method to verify title of page before after denial reason selection are same or not
	 */
	public boolean verifyDenialReasonPopupHeading() {
		if (denialPopupHead.isDisplayed()) {
			System.out.println(denialPopupHead.getText());
			return true;
		} else {
			System.out.println("error");
			return false;
		}
	}
	
}

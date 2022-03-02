package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

/*
 * Page class for IBE_Config_Standard Flow 
 * @author Sudhakar Mourya
 */
public class IBE_Config_StandardFlowPage extends TestBase {

	@FindBy(xpath = "//div[contains(@class,'alert ')]")
	WebElement subdomainSuccessfullyUpdated;

	@FindBy(xpath = "//p[text()='Select a room']")
	WebElement selectRoomText;

	@FindBy(xpath = "//a[text()='My bookings']")
	WebElement myBookingText;


	public IBE_Config_StandardFlowPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to verify Standard flow selected
	 */
	public boolean verifySubdomainUpdated() {
		if(subdomainSuccessfullyUpdated.isDisplayed()) {
			System.out.println("standard flow configure");
			return true;
		}
		else {
			System.out.println("standard flow is not configure");
			return false;
		}
	}

	/*
	 * Method to verify IBE Config Standard flow TC-02
	 */
	public boolean verifyIBE_ConfigStandardFlow_TC_02() {
		if(myBookingText.isDisplayed()) {
			System.out.println("Standard flow is selected");
			return true;
		}
		else {
			System.out.println("Standard flow is not selected");
			return false;
		}
	}

	/*
	 * Method to verify IBE Config Yankee flow TC-02
	 */
	public boolean verifyIBE_ConfigYankeeFlow_TC_02() {
		if(selectRoomText.isDisplayed()) {
			System.out.println("Yankee flow is selected");
			return true;
		}
		else {
			System.out.println("Yankee flow is not selected");
			return false;
		}
	}
}

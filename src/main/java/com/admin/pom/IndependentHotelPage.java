package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.AbstractBasePage;

public class IndependentHotelPage extends AbstractBasePage {
	
	@FindBy(xpath = "//a[text()='Independent Hotels']")
	WebElement selectIndependentHotel;

	@FindBy(xpath = "//a[text()='x'][1]")
	WebElement backToProperties;

	@FindBy(xpath = "//h1[text()='Administrator Home']")
	WebElement adminText;
	
	public IndependentHotelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	 * Method to select Independent Hotel
	 */
	
	public IndependentHotelPage selectingIndependentHotel() {
		selectIndependentHotel.click();
		return null;
	}

	/*
	 * Method to go back to properties
	 */
	
	public IndependentHotelPage independentHotels() {
		backToProperties.click();
		return null;
	}

	/*
	 * Method to verify Independent Hotel created
	 * return boolean value
	 */
	
	public boolean verifyIndependentHotelCreated(){
//		backToProperties.click();
	String r = adminText.getText();
	System.out.println(r);
		if (adminText.isDisplayed()) {
			System.out.println("Independent Hotel Created");
			return true;
		} else {
			System.out.println("Independent Hotel not Created");
			return false;
		}
	}
}

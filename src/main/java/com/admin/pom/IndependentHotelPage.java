package com.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import pages.AbstractBasePage;

public class IndependentHotelPage extends AbstractBasePage {
	ExcelData e = new ExcelData();

	@FindBy(xpath = "//a[text()='Independent Hotels']")
	WebElement selectIndependentHotel;

	@FindBy(xpath = "//a[text()='x'][1]")
	WebElement backToProperties;

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
		String code = e.getCellData("Property", "Code", 2);
		System.out.println(code);
		WebElement w = driver.findElement(By.xpath("//td[text()='" + code + "']"));
		if (w.isDisplayed()) {
			System.out.println("Independent Hotel Created");
			return true;
		} else {
			System.out.println("Independent Hotel not Created");
			return false;
		}
	}
}

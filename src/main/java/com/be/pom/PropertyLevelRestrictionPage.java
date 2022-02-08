package com.be.pom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
* POM class to Apply Property Level Restriction
* @Author Uzair Asar
*/

public class PropertyLevelRestrictionPage extends TestBase {

	ExcelData e = new ExcelData();

	@FindBy(id = "search_arrival_date")
	WebElement checkInCalander;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;

	@FindBy(id = "search_departure_date")
	WebElement checkOutCalander;

	@FindBy(xpath = "//td[text()='2']")
	WebElement checkOutDate;

	@FindBy(id = "check-availability-btn")
	WebElement checkAvailability;

	@FindBy(xpath = "//button[@class='room-book-now-button']")
	WebElement bookNow;

	@FindBy(xpath = "//*[contains(@href,'Restrictions.do?brand_id=20&prop_id=50')]")
	WebElement adminPropertyYieldRestrictionOption;

	@FindBy(xpath = "//input[@value='Not Allow']")
	WebElement adminDoNotAllowOption;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement adminSaveButton;

	@FindBy(xpath = "//input[@value='Allow']")
	WebElement adminAllowOption;

	@FindBy(xpath = "//div[@ng-hide='showRoomInfo']")
	WebElement errorText;

	@FindBy(xpath = "//input[@value='Not Allow After Time']")
	WebElement adminDoNotAllowAfterOption;

	@FindBy(id = "denySameDayReservationsAfterMin")
	WebElement minOption;

	@FindBy(xpath = "(//option[@value='1'])[2]")
	WebElement minSelect;

	@FindBy(xpath = "//input[@value='Y']")
	WebElement adminMaxLOSY;

	@FindBy(xpath = "//input[@value='N']")
	WebElement adminMaxLOSN;

	@FindBy(xpath = "//input[@name='maxLOS']")
	WebElement adminInputMaxLOS;

	@FindBy(xpath = "(//div//div//h3)[1]")
	WebElement maxLOSErrorText;

	@FindBy(xpath = "//input[@name='minLeadTime']")
	WebElement adminMinLeadTime;

	@FindBy(xpath = "//input[@name='maxLeadTime']")
	WebElement adminMaxLeadTime;
	
	@FindBy(xpath = "//a[text()='Start over']")
	WebElement startOver;

	public PropertyLevelRestrictionPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to check Availability in BE
	 */
	
	public PropertyLevelRestrictionPage availabilityCheck() {
		TestBase.implict(3);
		checkInCalander.click();
		TestBase.implict(3);
		checkInDate.click();
		TestBase.implict(3);

		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to input check in date in BE
	 */
	
	public PropertyLevelRestrictionPage availabilityCheckDates() {
		TestBase.implict(3);
		checkInCalander.click();
		TestBase.implict(3);
		checkInDate.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to verify Text in BE
	 * return string s
	 */
	
	public String verifyBookNowBtn() {
		String s = bookNow.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to select Property Yield Restriction
	 */
	
	public PropertyLevelRestrictionPage adminPropertyYeildRestriction() {
		TestBase.implict(3);
		adminPropertyYieldRestrictionOption.click();
		return null;
	}

	/*
	 * Method to apply do not allow option
	 */
	
	public PropertyLevelRestrictionPage adminDoNotAllowOption() {
		TestBase.implict(3);
		adminDoNotAllowOption.click();
		return null;
	}

	/*
	 * Method to save restriction
	 */
	
	public PropertyLevelRestrictionPage adminSave() {
		TestBase.implict(3);
		adminSaveButton.click();
		return null;
	}

	/*
	 * Method to allow same day restriction
	 */
	
	public PropertyLevelRestrictionPage adminAllowOption() {
		TestBase.implict(3);
		adminAllowOption.click();
		return null;
	}

	/*
	 * Method to verify text for no booking available
	 * return String s
	 */
	
	public String verifyNoBookingText() {
		TestBase.implict(3);
		String s = errorText.getText();
		String subS = s.substring(0, 43);
		System.out.println("Error Text: " + subS);
		return subS;
	}

	/*
	 * Method to apply do not allow after restriction
	 */
	
	public PropertyLevelRestrictionPage adminDoNotAllowAfterOption() {
		TestBase.implict(3);
		adminDoNotAllowAfterOption.click();
		TestBase.implict(3);
		minOption.click();
		TestBase.implict(3);
		minSelect.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to apply maxLOS restriction
	 */
	
	public PropertyLevelRestrictionPage adminImposeMaxLOS() {
		TestBase.implict(3);
		adminMaxLOSY.click();
		TestBase.implict(3);
		adminInputMaxLOS.clear();
		TestBase.implict(3);
		adminInputMaxLOS.sendKeys(e.getCellData("PropertyRestriction", "MaxLOS", 2));
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to check Availability for maxLOS
	 */
	
	public PropertyLevelRestrictionPage availabilityCheckForMaxLOS() throws InterruptedException {
		TestBase.implict(3);
		Thread.sleep(2000);
		checkInCalander.click();
		TestBase.implict(3);
		checkInDate.click();
		TestBase.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(e.getCellData("PropertyRestriction", "MaxLOS", 2));
		c.add(Calendar.DAY_OF_MONTH, (m + 1));
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		TestBase.implict(3);

		checkOutCalander.click();
		TestBase.implict(3);
		checkOutCalander.clear();
		checkOutCalander.sendKeys(newDate);
		Thread.sleep(3000);
		TestBase.implict(3);

		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to verify maxLOS text
	 */
	
	public String verifyMaxLOSErrorText() {
		String s = maxLOSErrorText.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to remove maxLOS
	 */
	
	public PropertyLevelRestrictionPage adminRemoverMaxLOS() {
		TestBase.implict(3);
		adminMaxLOSN.click();
		adminInputMaxLOS.clear();
		return null;
	}

	/*
	 * Method to apply min lead time restriction
	 */
	
	public PropertyLevelRestrictionPage adminMinLeadTime() {
		TestBase.implict(3);
		adminMinLeadTime.sendKeys(e.getCellData("PropertyRestriction", "MinLeadTime", 2));
		return null;
	}

	/*
	 * Method to clear min lead time restriction
	 */
	
	public PropertyLevelRestrictionPage adminMinLeadTimeClear() {
		TestBase.implict(3);
		adminMinLeadTime.clear();
		return null;
	}

	/*
	 * Method to clear max lead time restriction
	 */
	
	public PropertyLevelRestrictionPage adminMaxLeadTimeClear() {
		TestBase.implict(3);
		adminMaxLeadTime.clear();
		return null;
	}

	/*
	 * Method to apply max lead time restriction
	 */
	
	public PropertyLevelRestrictionPage adminMaxLeadTime() {
		TestBase.implict(3);
		adminMaxLeadTime.sendKeys(e.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		return null;
	}
	
	/*
	 * Method to check availability for max lead time restriction
	 */
	
	public PropertyLevelRestrictionPage availabilityCheckForMaxLeadTime() throws InterruptedException {
		TestBase.implict(3);
		Thread.sleep(2000);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(e.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, m);
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		TestBase.implict(3);

		checkInCalander.click();
		TestBase.implict(3);
		checkInCalander.clear();
		checkInCalander.sendKeys(newDate);
		Thread.sleep(3000);
		TestBase.implict(3);

		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to check availability for min max lead time restriction
	 */
	
	public PropertyLevelRestrictionPage availabilityCheckForMinMaxLeadTime() throws InterruptedException {
		TestBase.implict(3);
		Thread.sleep(2000);
		checkInCalander.click();
		TestBase.implict(3);
		checkInDate.click();
		TestBase.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(e.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, m);
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		TestBase.implict(3);
		
		checkInCalander.click();
		TestBase.implict(3);
		checkInCalander.clear();
		checkInCalander.sendKeys(newDate);
		
		TestBase.implict(3);

		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to check availability for min max lead time and maxLOS restriction
	 */
	
	public PropertyLevelRestrictionPage availabilityCheckForMinMaxLOSLeadTime() throws InterruptedException {
		TestBase.implict(3);
		checkInCalander.click();
//		checkInCalander.clear();
		Thread.sleep(2000);
		TestBase.implict(3);
		checkInDate.click();
		TestBase.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(e.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, (m + 1));
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		TestBase.implict(3);

		checkOutCalander.click();
		TestBase.implict(3);
		checkOutCalander.clear();
		checkOutCalander.sendKeys(newDate);
		Thread.sleep(3000);
//		TestBase.implict(3);

		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to check availability for min max lead time and maxLOS restriction error 2
	 */
	
	public PropertyLevelRestrictionPage availabilityCheckForMinMaxLOSLeadTime08() throws InterruptedException {
		TestBase.implict(3);
		Thread.sleep(2000);
		checkInCalander.click();
		Thread.sleep(2000);
//		TestBase.implict(3);
		checkInDate.click();
		TestBase.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(e.getCellData("PropertyRestriction", "MinLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, m);
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		TestBase.implict(3);

		checkOutCalander.click();
		TestBase.implict(3);
		checkOutCalander.clear();
		checkOutCalander.sendKeys(newDate);
		Thread.sleep(3000);
//		TestBase.implict(3);

		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click on bookNow
	 */
	
	public PropertyLevelRestrictionPage bookNow() {
		TestBase.implict(3);
		bookNow.click();
		return null;
	}

	/*
	 * Method to click on start over
	 */
	
	public PropertyLevelRestrictionPage startOver() {
		TestBase.implict(3);
		startOver.click();
		return null;
	}
	
}

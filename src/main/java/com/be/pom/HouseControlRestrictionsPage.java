package com.be.pom;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.Popup;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.RatesandInventoryPage;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * Pom class for HouseControlRestrictions
 * @author Rudraksh Aggarwal
 */

public class HouseControlRestrictionsPage extends TestBase {

	ExcelData e = new ExcelData();
	public static WebDriver driver;

	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;

	@FindBy(xpath = "//*[@name='endDate']")
	WebElement enddate;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;

	@FindBy(xpath = "(//input[@value='O'])[1]")
	WebElement openYieldControl;

	@FindBy(xpath = "(//input[@value='C'])[1]")
	WebElement closeYieldControl;

	@FindBy(xpath = "//*[@id='minLOS']")
	WebElement minLos;

	@FindBy(xpath = "//*[@id='maxLOS']")
	WebElement maxLos;

	@FindBy(xpath = "//*[@value='Quick Entry']")
	WebElement quickEntryBtn;

	@FindBy(xpath = "//input[@name='btnUpdate']")
	WebElement updateButton;

	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirmButton;

	@FindBy(xpath = "//div[@id='errorAlertPopup']/div")
	WebElement popupStayThrough;

	@FindBy(id = "search_arrival_date")
	WebElement calender;

	@FindBy(id = "search_departure_date")
	WebElement calenderCheckOut;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;

	@FindBy(xpath = "//*[contains(@name,'minLOS_')]")
	List<WebElement> allMinLOS;

	@FindBy(xpath = "//*[contains(@name,'maxLOS_')]")
	List<WebElement> allMaxLOS;

	@FindBy(xpath = "(//button[@type='submit'])[last()]")
	WebElement bookNow;

	@FindBy(xpath = "(//input[@value=\"CTA\"])[1]")
	WebElement cta;

	@FindBy(name = "noOfRoomsAvailable")
	WebElement roomsAvailable;

	@FindBy(xpath = "//input[@value='All']")
	WebElement allRadioButton;

	public HouseControlRestrictionsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to select date range in admin : current day date and next day date
	 */
	public HouseControlRestrictionsPage selectDateRange() {

		TestBase.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date " + currentDate);
		startdate.sendKeys(currentDate);
		// startdate.sendKeys(e.getCellData("HouseInventoryRestrictions", "Date", 2));
		TestBase.implict(3);

		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		nextDaydate = formatter.format(after);
		System.out.println("next day date " + nextDaydate);
		enddate.sendKeys(nextDaydate);
		// enddate.sendKeys(e.getCellData("HouseInventoryRestrictions", "EndDate", 2));
		return null;
	}

	/*
	 * Method to click submit button
	 */
	public HouseControlRestrictionsPage clickSubmitButton() {

		submit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method to select open yield control
	 */
	public HouseControlRestrictionsPage openYieldControls() {
		openYieldControl.click();

		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to select closed yield control
	 */
	public HouseControlRestrictionsPage closeYieldControls() {
		closeYieldControl.click();

		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to select Closed To Arrival yield control
	 */
	public HouseControlRestrictionsPage selectCloseToArrival() {
		cta.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to clear All Min LOS
	 */
	public HouseControlRestrictionsPage clearAllMinLOS() {
		List<WebElement> li = allMinLOS;

		for (WebElement i : li) {
			i.clear();
			TestBase.implict(3);
		}
		return null;
	}

	/*
	 * Method to clear All Max LOS
	 */
	public HouseControlRestrictionsPage clearAllMaxLOS() {
		List<WebElement> li = allMaxLOS;

		for (WebElement i : li) {
			i.clear();
			TestBase.implict(3);
		}
		return null;
	}

	/*
	 * Method to input fields TC01
	 */
	public HouseControlRestrictionsPage inputFieldTC01() {
		minLos.sendKeys(e.getCellData("HouseInventoryRestrictions", "MinStayThrough", 2));
		return null;
	}

	/*
	 * Method to input fields TC02
	 */
	public HouseControlRestrictionsPage inputFieldTC02() {
		maxLos.sendKeys(e.getCellData("HouseInventoryRestrictions", "MaxStayThrough", 2));
		return null;
	}

	/*
	 * Method to select date in Booking Engine: current day date and date after 6
	 * days
	 */
	public HouseControlRestrictionsPage selectDateTC02() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calender.click();
		TestBase.implict(2);
		checkInDate.click();

		String sixDaysAfter = "";

		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DAY_OF_YEAR, +6);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		sixDaysAfter = formatter.format(after);
		System.out.println("date after 6 days " + sixDaysAfter);

		calenderCheckOut.clear();
		calenderCheckOut.sendKeys(sixDaysAfter);

		return null;
	}

	/*
	 * Method to select date in Booking Engine:CheckIn date after 2 days
	 */
	public HouseControlRestrictionsPage selectDateTC06() {
		// TO GET DATE after 2 days
		String twodaysafterdate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +2);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		twodaysafterdate = formatter.format(after);
		System.out.println("date after 2 days " + twodaysafterdate);

		calender.sendKeys(twodaysafterdate);
		return null;
	}

	/*
	 * Method to click Quick Entry Button
	 */
	public HouseControlRestrictionsPage clickQuickEntrybutton() {
		quickEntryBtn.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click update Button
	 */
	public HouseControlRestrictionsPage clickUpdateButton() {
		updateButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click confirm Button
	 */
	public HouseControlRestrictionsPage clickConfirmButton() {
		confirmButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method for verification Stay Through
	 */
	public boolean verificationStayThrough() {
		if (popupStayThrough.isDisplayed()) {
			String popup = popupStayThrough.getText();
			int p = popup.length();
			String p2 = popup.substring(0, (p - 3));
			System.out.println(p2);
		}
		return true;
	}

	/*
	 * Method for verification Book Now is Visible
	 */
	public boolean verification_BookNowVisible() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		if (bookNow.isDisplayed()) {
			// String bn = bookNow.getText();
			System.out.println("BookNow button is displayed");
			return true;
		}

		else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method for verification Book Now is not Visible
	 */
	public boolean verification_BookNowNotVisible() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		if (bookNow.isDisplayed()) {
			System.out.println("NA");
			return true;

		} else {
			System.out.println("Book Now button is not displayed");
			return false;
		}
	}

	/*
	 * Method to input availability of rooms
	 */
	public void inputFieldRoomAvailable(String num) {
		roomsAvailable.clear();
		roomsAvailable.sendKeys(num);

	}

	/*
	 * Method to select Day of Week
	 */
	public void selectDayofWeek() {
		allRadioButton.click();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		String stringDay = sdf.format(new Date());
		System.out.println("Today is:" + stringDay);

		WebElement currentday = getDriver().findElement(By.xpath("//input[@value='" + stringDay + "']"));
		currentday.click();
	}

}

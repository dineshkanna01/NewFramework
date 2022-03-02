package com.be.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.RatePlanPage;
import com.admin.pom.RatesandInventoryPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class GroupBlockBookingPage extends TestBase {

	@FindBy(xpath = "//input[@maxlength='50']")
	WebElement name;

	@FindBy(xpath = "//input[@maxlength='20']")
	WebElement blockCode;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement room;

	@FindBy(xpath = "//input[@onclick='saveSubmit()']")
	WebElement save;

	@FindBy(xpath = "//input[@name='blockReleaseDate']")
	WebElement releaseDate;

	@FindBy(xpath = "//input[@name='checkInSDate']")
	WebElement checkIndate;

	@FindBy(xpath = "//input[@name='checkInEDate']")
	WebElement checkOutdate;

	@FindBy(xpath = "(//img[@align='baseline'])[3]")
	WebElement checkOutCalendar;
	
	@FindBy(xpath = "(//a[@style='padding-left: 15px'])[last()]")
	WebElement manageInventory;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;
	
	@FindBy(id = "noOfRoomsAvailable")
	WebElement roomAvailable;
	
	@FindBy(xpath = "//input[@value='Quick Entry']")
	WebElement quickEntry;
	
	@FindBy(xpath = "//input[@value='Update']")
	WebElement update;
	
	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirm;

	@FindBy(name = "name")
	WebElement nameRatePlan;
	
	@FindBy(name = "rateCode")
	WebElement ratePlanCode;
	
	@FindBy(name = "shortDescription")
	WebElement shortDescription;
	
	@FindBy(name = "bookingSDate")
	WebElement startDate;
	
	@FindBy(name = "checkInSDate")
	WebElement firstCheckInDate;
	
	@FindBy(xpath = "(//input[@name='roomTypes'])[1]")
	WebElement roomCheckbox;
	
	@FindBy(name = "save")
	WebElement saveButton;
	
	@FindBy(xpath = "//input[@name='floatingRate' and @value='N']")
	WebElement deriveRatesNoButton;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement pegsImage ;  
	
	@FindBy(xpath="(//input[@name='ownInventory'])[3]")
	WebElement groupBlockCheckBox; 
	
	@FindBy(xpath="//input[@class='row_4_all']")
	WebElement diwaliRatePlan; 
	
	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;

	@FindBy(xpath = "//*[@name='endDate']")
	WebElement enddate;
	
	@FindBy(xpath = "//input[@class='input rateInput_0']")
	WebElement rate;
	
	@FindBy(xpath = "(//a[contains(@href,'./retrieve')])[last()]")
	WebElement editGroupBlock;
	
	@FindBy(xpath = "(//a[contains(@href,'./retrieveRa')])[last()]")
	WebElement editRatePlan;
	
	@FindBy(xpath = "(//a[contains(@href,'./retrieveRa')])[last()]")
	WebElement rT3PromotionalUrl;
	
	@FindBy(xpath = "//h1[text()='Group Blocks']")
	WebElement groupBlockText;
	
	public GroupBlockBookingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to Enter Group Block Name
	 */
	public GroupBlockBookingPage enterGroupBlockName() {
		name.sendKeys(ExcelData.getCellData("GroupBlockBooking","Name",2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to Enter Group Block Code
	 */
	public GroupBlockBookingPage enterGroupBlockCode() {
		blockCode.sendKeys(ExcelData.getCellData("GroupBlockBooking","Code",2));
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to Enter Group Block Code1
	 */
	public GroupBlockBookingPage enterGroupBlockCode1() {
		blockCode.clear();
		blockCode.sendKeys(ExcelData.getCellData("GroupBlockBooking","Code",3));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on Room
	 */
	public GroupBlockBookingPage selectRoom() {
		room.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on save
	 */
	public GroupBlockBookingPage clickOnSaveButton() {
		save.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click on Manage Inventory
	 */
	public GroupBlockBookingPage clickOnManageInventory() {
		manageInventory.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click on Submit
	 */
	public GroupBlockBookingPage clickOnSubmit() {
		submit.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to Enter Room Available
	 */
	public GroupBlockBookingPage enterRoomAvailable() {
		roomAvailable.sendKeys(ExcelData.getCellData("GroupBlockBooking","RoomAvailable",2));
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click on Quick Entry
	 */
	public GroupBlockBookingPage clickOnQuickEntry() {
		quickEntry.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click on Update
	 */
	public GroupBlockBookingPage clickOnUpdate() {
		update.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on Confirm
	 */
	public GroupBlockBookingPage clickOnConfirm() {
		confirm.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to select Diwali rate plan
	 */
	public GroupBlockBookingPage selectDiwaliRatePlan() {
		Helper.implict(6);
		diwaliRatePlan.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click on edit of last group block
	 */
	public GroupBlockBookingPage editGroupBlock() {
		editGroupBlock.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to Select Release Date
	 */
	public GroupBlockBookingPage selectReleaseDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YY"); // updated
		String strDate = dateFormat.format(date);
		System.out.println(strDate + "******");
		releaseDate.sendKeys(strDate);

		return null;
	}

	/*
	 * Method to Select First Check-in Date
	 */
	public GroupBlockBookingPage selectFirstCheckInDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YY"); // updated
		String strDate = dateFormat.format(date);
		System.out.println(strDate + "******");
		checkIndate.sendKeys(strDate);

		return null;
	}
	
	/*
	 * Method to update Rate
	 */
	public GroupBlockBookingPage enterRate(){
		rate.clear();
		rate.sendKeys(ExcelData.getCellData("GroupBlockBooking","Rate",2));
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to Edit Rate Plan
	 */
	public GroupBlockBookingPage editRatePlan(){
		editRatePlan.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click on RT3 promotional Url
	 */
	public GroupBlockBookingPage clickOnRT3Url(){
		rT3PromotionalUrl.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to verify tc-02
	 */
	public boolean verifytc02() {
		if (groupBlockText.isDisplayed()) {
			System.out.println("Group Block is edited");
			return true;
		} else
			System.out.println("Group Block is not edited");
		return false;
	}

	/*
	 * Method to Select Last Check-out Date
	 */
	public GroupBlockBookingPage selectLastCheckOutDate() {
		// TO GET DATE after 5 days
		String twodaysafterdate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +8);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		twodaysafterdate = formatter.format(after);
		System.out.println("date after 2 days " + twodaysafterdate);
		try {
			checkOutdate.sendKeys(twodaysafterdate);}
		catch(Exception e) {
			System.out.println("NA");
		}
		return null;
   }
	
	/*
	 * Method to input field for TC_01
	 */
	public GroupBlockBookingPage inputFields_tc_01() {
		name.sendKeys(ExcelData.getCellData("GroupBlockBooking", "NameRatePlan", 2));
		Helper.implict(1);
		ratePlanCode.sendKeys(ExcelData.getCellData("GroupBlockBooking", "RateTypeCode", 2));
		Helper.implict(1);
		shortDescription.sendKeys(ExcelData.getCellData("GroupBlockBooking", "ShortDescription", 2));
		Helper.implict(1);
		pegsImage.sendKeys("C:\\Users\\Sudhakar.Mourya\\Downloads\\Pegasus image.png");
		Helper.implict(3);
		roomCheckbox.click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		startDate.sendKeys(strDate);
		Helper.implict(1);
		firstCheckInDate.sendKeys(strDate);
		groupBlockCheckBox.click();
		deriveRatesNoButton.click();
		saveButton.click();
		return null;
	}
	
	/*
	 * Method to select date range for current day date and next 5 day
	 */
	public GroupBlockBookingPage selectDateRange() {

		Helper.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date " + currentDate);
		startdate.sendKeys(currentDate);
		// startdate.sendKeys(ExcelData.getCellData("HouseInventoryRestrictions", "Date", 2));
		Helper.implict(3);

		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +5);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		nextDaydate = formatter.format(after);
		System.out.println("next day date " + nextDaydate);
		enddate.sendKeys(nextDaydate);
		// enddate.sendKeys(ExcelData.getCellData("HouseInventoryRestrictions", "EndDate", 2));
		return null;
	}
}





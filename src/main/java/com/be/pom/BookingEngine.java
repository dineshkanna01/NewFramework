package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.AddOnsPage;
import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class BookingEngine extends TestBase {

	@FindBy(xpath = "//input[@id='search_arrival_date']")
	WebElement checkInCalander;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;

	@FindBy(xpath = "//input[@id='search_departure_date']")
	WebElement checkOutCalander;

	@FindBy(xpath = "//td[text()='2']")
	WebElement checkOutDate;

	@FindBy(xpath = "//button[@id='check-availability-btn']")
	WebElement checkAvailability;

	@FindBy(xpath = "//button[@class='room-book-now-button']")
	WebElement bookNow;

	@FindBy(xpath = "//*[contains(@href,'BedTypes.do?method=list&brand_id=20&prop_id=50')]")
	WebElement adminBedTypeOption;

	@FindBy(xpath = "//*[contains(@href,'BedTypes.do?method=addNew&brand_id=20&prop_id=50')]")
	WebElement adminANewBedType;

	@FindBy(name = "name")
	WebElement bedName;

	@FindBy(name = "code")
	WebElement bedCode;

	@FindBy(name = "save")
	WebElement saveBedType;

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameTextField;

	@FindBy(xpath = "//input[@name='code']")
	WebElement codeTextField;

	@FindBy(xpath = "//textarea[@name='shortDesc']")
	WebElement shortDescriptionTextField;

	@FindBy(xpath = "//input[@name='price']")
	WebElement priceField;

	@FindBy(xpath = "//*[@name='save' and @class='input']")
	WebElement savebutton;

	@FindBy(xpath = "//input[@type='radio' and @value='true']")
	WebElement addOnActive;

	@FindBy(name = "addOnStartDate")
	WebElement addOnStartDate;

	@FindBy(xpath = "//input[@name='name']")
	WebElement roomName;

	@FindBy(xpath = "//input[@name='code']")
	WebElement roomCode;

	@FindBy(xpath = "//input[@name='gdsRoomCode']")
	WebElement gdsCode;

	@FindBy(xpath = "(//input[@name='selectedBedIds'])[1]")
	WebElement bigsizeBed;

	@FindBy(xpath = "(//input[@name='selectedBedIds'])[2]")
	WebElement doubleBed;

	@FindBy(xpath = "(//input[@name='selectedBedIds'])[3]")
	WebElement marvelousBed;

	@FindBy(xpath = "(//input[@name='selectedBedIds'])[2]")
	WebElement exquisiteBed;

	@FindBy(xpath = "//input[@name='extraAdultPerRoomCharge']")
	WebElement extraAdultPerRoomCharge;

	@FindBy(xpath = "//input[@name='extraChildPerRoomCharge']")
	WebElement extraChildPerRoomCharge;

	@FindBy(xpath = "//select[@name='maxOccupantsForDefaultPrice']")
	WebElement maxNoOfAdultForDefaultPrice;

	@FindBy(xpath = "//input[@name='minAdultOccupancy']")
	WebElement minAdult;

	@FindBy(xpath = "//input[@name='maxAdultOccupancy']")
	WebElement maxAdult;

	@FindBy(xpath = "//input[@name='minChilOccupancy']")
	WebElement minChild;

	@FindBy(xpath = "//input[@name='maxChilOccupancy']")
	WebElement maxChild;

	@FindBy(xpath = "//input[@name='totalMaxOccupancy']")
	WebElement totalOccupancy;

	@FindBy(xpath = "//input[@name='save']")
	WebElement saveButton;

	@FindBy(xpath = "(//input[@name='selectedBedIds'])[last()]")
	WebElement selectBedType;

	@FindBy(xpath = "//input[@type='file']")
	WebElement pegsImage;

	@FindBy(id = "selectedAddons_0")
	WebElement selectAddOn;

	@FindBy(xpath = "//*[@id='8']/li[1]/a")
	WebElement ratePlanListAll;

	@FindBy(xpath = "(//*[@tf_colkey='name'][1]/following::td[33]/a[1])[1]")
	WebElement editBARRatePlan;

	@FindBy(xpath = "//*[@name='C801']")
	WebElement selectRatePlan;

	@FindBy(id = "rooms_available_801")
	WebElement rateGridAvailability;

	@FindBy(xpath = "(//*[@class='rooms-list-title ng-binding'])[last()]")
	WebElement selectRoomBE;

	@FindBy(xpath = "//*[@headers='summary_reservation_title']")
	WebElement verifyRoomName;

	@FindBy(xpath = "//*[@headers='summary_reservation_offer']")
	WebElement verifyRatePlanName;

	@FindBy(xpath = "//*[@headers='summary_reservation_other_services']")
	WebElement verifyAddOnName;

	public BookingEngine(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	public BookingEngine adminBedType() {
		adminBedTypeOption.click();
		adminANewBedType.click();
		bedName.sendKeys(ExcelData.getCellData("BookingEngine", "BedName", 2));
		bedCode.sendKeys(ExcelData.getCellData("BookingEngine", "BedCode", 2));
		saveBedType.click();
		Helper.implict(5);
		return null;
	}

	public BookingEngine FirstPage() {
		Helper.implict(3);
		checkInCalander.click();
		checkInDate.click();
		Helper.implict(3);

		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	public String verifyBookNowBtn() {
		String s = bookNow.getText();
		System.out.println("First Page : " + s);
		return s;
	}

	public AddOnsPage inputTextFieldsAddOnsTc01() {
		nameTextField.click();

		nameTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Name_TC01", 2));
		Helper.implict(2);

		codeTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Code_TC01", 2));
		Helper.implict(2);

		shortDescriptionTextField.sendKeys(ExcelData.getCellData("AddOnsData", "ShortDescription_TC01", 2));
		Helper.implict(2);

		priceField.sendKeys(ExcelData.getCellData("AddOnsData", "Price_TC01", 2));
		Helper.implict(2);
		addOnActive.click();

		// DateFormat dateFormat = new SimpleDateFormat("MM/DD/YY");
		// Date date = new Date();
		// String strDate = dateFormat.format(date);

		addOnStartDate.sendKeys(ExcelData.getCellData("AddOnsData", "StartDate", 2));
		return null;
	}

	public AddOnsPage clickOnSave() {
		savebutton.click();
		Helper.implict(4);

		return null;
	}

	public BookingEngine inputRoomData() {
		roomName.sendKeys(ExcelData.getCellData("Sheet1", "roomName", 2));
		Helper.implict(5);
		roomCode.sendKeys(ExcelData.getCellData("Sheet1", "roomCode", 2));
		selectBedType.click();
		pegsImage.sendKeys("C:\\Users\\uzair.asar\\Pictures\\Room2.jpg");
		Helper.implict(4);
		selectAddOn.click();
		extraAdultPerRoomCharge.sendKeys("100");
		extraChildPerRoomCharge.sendKeys("30");
		maxNoOfAdultForDefaultPrice.sendKeys("2");
		minAdult.sendKeys("1");
		maxAdult.sendKeys("3");
		minChild.sendKeys("0");
		maxChild.sendKeys("3");
		totalOccupancy.sendKeys("6");

		saveButton.click();
		return null;

	}

	public BookingEngine editRatePlanAddOn() throws InterruptedException {
		Helper.implict(5);
		ratePlanListAll.click();

		editBARRatePlan.click();
		return null;

	}

	public BookingEngine selectRatePlan() throws InterruptedException {
		selectRatePlan.click();
		Helper.implict(3);
		return null;
	}

	public BookingEngine availability() {
		Helper.implict(3);
		rateGridAvailability.sendKeys(ExcelData.getCellData("RateGrid", "Availability", 2));
		Helper.implict(3);
		return null;
	}

	public BookingEngine beRoomSelect() {
		Helper.implict(3);
		selectRoomBE.click();
		Helper.implict(3);
		return null;
	}

	public BookingEngine verificationAddOn() throws InterruptedException {

		Thread.sleep(1000);

		String addOn = verifyAddOnName.getText();
		System.out.println("AddOn name is: " + addOn);

		return null;
	}

	public BookingEngine verification() throws InterruptedException {
		Helper.implict(3);

		String room = verifyRoomName.getText();
		System.out.println("Room name is:" + room);

		Thread.sleep(1000);
		String ratePlan = verifyRatePlanName.getText();
		String RP = ratePlan.substring(0, 3);
		System.out.println("Rate Plan name is: " + RP);
		Thread.sleep(1000);
		return null;
	}
}
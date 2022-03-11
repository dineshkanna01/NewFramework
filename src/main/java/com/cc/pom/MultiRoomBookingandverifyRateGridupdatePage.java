package com.cc.pom;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.admin.pom.RatesandInventoryPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/* POM class for MultiRoomBookingandverifyRateGridupdatePage  
* @author Rudraksh Aggarwal
*/
public class MultiRoomBookingandverifyRateGridupdatePage extends TestBase {

	@FindBy(xpath = "(//select[contains(@class,'rooms-quantity-select')])[last()]")
	WebElement roomsDropdown;

	@FindBy(xpath = "(//span[contains(@class,'icon-add')])[1]")
	WebElement plusIcon;

	@FindBy(xpath = "//input[@id='multi-room-details']")
	WebElement sameDetailsCheckbox;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement completeReservation;

	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;

	@FindBy(xpath = "//*[@name='endDate']")
	WebElement enddate;

	@FindBy(name = "start")
	WebElement checkInDate;

	@FindBy(name = "end")
	WebElement checkOutDate;

	@FindBy(xpath = "//span[text()='Room 1']")
	WebElement room1;

	@FindBy(xpath = "//span[text()='Room 1']/following::input[1]")
	WebElement room1Delete;

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

	@FindBy(xpath = "//input[@name='save'][2]")
	WebElement editSave;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement checkbox2;

	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	WebElement checkbox3;

	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	WebElement checkbox4;

	@FindBy(xpath = "(//input[@type='checkbox'])[5]")
	WebElement checkbox5;

	@FindBy(xpath = "(//input[@type='checkbox'])[6]")
	WebElement checkbox6;

	@FindBy(xpath = "(//input[@type='checkbox'])[7]")
	WebElement checkbox7;

	@FindBy(xpath = "(//input[@type='checkbox'])[8]")
	WebElement checkbox8;

	@FindBy(xpath = "(//input[@type='checkbox'])[last()]")
	WebElement lastCheckbox;

	@FindBy(xpath = "//input[@name='delete']")
	WebElement delete;

	@FindBy(xpath = "//input[@value='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "//input[@type='file']")
	WebElement pegsImage;

	@FindBy(xpath = " (//a[contains(@href,'displayEditRoom')])[last()]")
	WebElement edit;

	@FindBy(xpath = "//li[text()='Duplicate Code']")
	WebElement roomDuplicateCode;

	@FindBys(@FindBy(xpath = " //table[@id='dataTable']//tr/td[3]"))
	List<WebElement> allRoomName;

	@FindBy(xpath = "//table[@id='dataTable']//tr[8]/td[4]")
	WebElement editedRoomCode;

	@FindBy(id = "ms-opt-1")
	WebElement selectFirstRoomType;

	@FindBy(id = "ms-opt-2")
	WebElement selectsecondRoomType;

	@FindBy(xpath = "//button[@type='button']")
	WebElement selectRoomTypedropdwn;

	@FindBy(xpath = "(//input[contains(@id,'rate_')])[1]")
	WebElement rateGridRate;

	@FindBy(xpath = "(//a[text()='Select'])[1]")
	WebElement selectRoom;

	@FindBy(xpath = "(//a[text()='Select'])[2]")
	WebElement selectRoom2;

	@FindBy(xpath = "(//input[@name='selectedItems'])[last()]")
	WebElement selectRoomCheckboxAdmin;

	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(
			getDriver());
	RatesandInventoryPage rip = new RatesandInventoryPage(getDriver());
	ModifyBookingfromconfirmationpagePage mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
	SoftAssert soft = new SoftAssert();

	public MultiRoomBookingandverifyRateGridupdatePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to select NumOfRooms TC01
	 */
	public MultiRoomBookingandverifyRateGridupdatePage selectNumOfRoomsTC01() {
		Helper.explicit(roomsDropdown, 10);
		Select a = new Select(roomsDropdown);
		a.selectByValue(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "NoOfRooms", 2));
		return null;
	}

	/*
	 * Method to select NumOfRooms TC02
	 */
	public MultiRoomBookingandverifyRateGridupdatePage selectNumOfRoomsTC02() {
		Helper.explicit(roomsDropdown, 10);
		Select a = new Select(roomsDropdown);
		a.selectByValue(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "NoOfRooms", 3));
		return null;
	}

	/*
	 * Method to click plus icon to add rooms
	 */
	public MultiRoomBookingandverifyRateGridupdatePage clickPlusIcon() {
		Helper.waitVisibility(20, "(//span[contains(@class,'icon-add')])[1]");
		plusIcon.click();
		return null;
	}

	/*
	 * Method to click same Guest tDetails CheckBox
	 */
	public MultiRoomBookingandverifyRateGridupdatePage sameGuestDetailsCheckBox() {
		Helper.waitVisibility(20, "//input[@id='multi-room-details']");
		JavascriptExecutor ex = (JavascriptExecutor) getDriver();
		ex.executeScript("arguments[0].click();", sameDetailsCheckbox);
		return null;
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-5000)");
	}

	public void scroll2() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,100)");
	}

	public void scroll3() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,200)");
	}

	public void scroll4() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,240)");
	}

	public void scroll5() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");
	}

	public void clickCompleteReservation() {
		WebElement element = getDriver().findElement(By.xpath("//input[@name='commit']"));
		JavascriptExecutor ex = (JavascriptExecutor) getDriver();
		ex.executeScript("arguments[0].click();", element);
	}

	/*
	 * Method to click select Date Range TC02 admin
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeTC02() {
		Helper.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for admin " + currentDate);
		startdate.sendKeys(currentDate);
		Helper.implict(3);
		// TO GET NEXT DAY DATE after 3 days
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +3);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		nextDaydate = formatter.format(after);
		System.out.println("next date after 3 days for admin " + nextDaydate);
		enddate.sendKeys(nextDaydate);
		return null;
	}

	/*
	 * Method to click select Date Range TC07 admin
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeTC07() {
		Helper.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for admin " + currentDate);
		startdate.sendKeys(currentDate);
		Helper.implict(3);
		// TO GET NEXT DAY DATE after 2 days
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +2);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		nextDaydate = formatter.format(after);
		System.out.println("next date after 2 days for admin " + nextDaydate);
		enddate.sendKeys(nextDaydate);
		return null;
	}

	/*
	 * Method to click select Date Range CC TC02
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeCCTC02() {
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for cc " + currentDate);
		// TO GET NEXT 3 DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +3);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		nextDaydate = formatter.format(after);
		System.out.println("next date after 3 days for cc " + nextDaydate);
		Helper.explicit(checkInDate, 10);
		checkInDate.sendKeys(currentDate);
		checkInDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(nextDaydate);
		return null;
	}

	/*
	 * Method to click select Date Range CC TC07
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeCCTC07() {
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for cc " + currentDate);
		// TO GET NEXT 3 DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +2);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		nextDaydate = formatter.format(after);
		System.out.println("next date after 2 days for cc " + nextDaydate);
		Helper.explicit(checkInDate, 10);
		checkInDate.sendKeys(currentDate);
		checkInDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(nextDaydate);
		return null;
	}

	/*
	 * Method to take SS and Compare Before After Multi 2 Same Room Rate Grid Update
	 * 1 day TC01
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterMulti2SameRoomRateGridUpdate1DayTC01(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		File outputfile = new File(f1 + ".png");
		ImageIO.write(screenshot1.getImage(), "PNG", outputfile);
		String destination = System.getProperty("user.dir") + "/target/ImagesCompare/" + f1 + ".png";
		File finalDestination = new File(destination);
		FileUtils.moveFile(outputfile, finalDestination);
		Helper.sleep(2000);
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.selectDateRangeCCTC01();
		selectNumOfRoomsTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		clickPlusIcon();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different and rate grid updated for 1 day TC01");
			return true;
		} else {
			System.out.println("Both images are same and rate grid not updated for 1 day TC01");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Multi 2 Same Room Rate Grid Update
	 * 3 days TC02
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterMulti2SameRoomRateGridUpdate3DaysTC02(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		File outputfile = new File(f1 + ".png");
		ImageIO.write(screenshot1.getImage(), "PNG", outputfile);
		String destination = System.getProperty("user.dir") + "/target/ImagesCompare/" + f1 + ".png";
		File finalDestination = new File(destination);
		FileUtils.moveFile(outputfile, finalDestination);
		Helper.sleep(2000);
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		selectDateRangeCCTC02();
		selectNumOfRoomsTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		clickPlusIcon();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		scroll2();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different and rate grid updated for 3 days TC02 ");
			return true;
		} else {
			System.out.println("Both images are same and rate grid not updated for 3 days TC02");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Multi 3 Same Room Rate Grid Update
	 * 1 day TC03
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterMulti3SameRoomRateGridUpdate1DayTC03(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		nsrb.selectDateRangeCCTC01();
		selectNumOfRoomsTC02();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		clickPlusIcon();
		Helper.implict(3);
		clickPlusIcon();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different and rate grid updated for 1 day TC03");
			return true;
		} else {
			System.out.println("Both images are same and rate grid not updated for 1 day TC03");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Multi 3 Same Room Rate Grid Update
	 * 3 days TC04
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterMulti3SameRoomRateGridUpdate3DaysTC04(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		selectDateRangeCCTC02();
		selectNumOfRoomsTC02();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		clickPlusIcon();
		Helper.implict(3);
		clickPlusIcon();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		scroll2();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different and rate grid updated for 3 days TC04");
			return true;
		} else {
			System.out.println("Both images are same and rate grid not updated for 3 days TC04");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Selecting 3rooms First and Remove
	 * 1 Room After
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterSelecting3roomsFirstandRemove1RoomAfter(String filename1,
			String filename2) throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
//		openURL("cc_url");
//		nsrb.enterCCuser();
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		nsrb.selectDateRangeCCTC01();
		selectNumOfRoomsTC02();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		clickPlusIcon();
		Helper.implict(3);
		clickPlusIcon();
		nsrb.clickpaymentButton();
		RemoveAroom();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		scroll2();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println(
					"Both images are different and rate grid updated for 1 day Selecting3roomsFirstandRemove1RoomAfter TC05");
			return true;
		} else {
			System.out.println(
					"Both images are same and rate grid not updated for 1 day Selecting3roomsFirstandRemove1RoomAfter TC05");
			return false;
		}
	}

	/*
	 * Method to Remove a room
	 * 
	 */
	public void RemoveAroom() {
		Actions action = new Actions(getDriver());
		action.moveToElement(room1).pause(Duration.ofSeconds(5)).click(room1Delete).build().perform();
		Helper.sleep(5000);
	}

	/*
	 * Method to select second Room
	 */
	public void selectsecondRoom() {
		Helper.sleep(7000);
		String a = (ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "RoomName", 2));
		System.out.println(a);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		room.click();
		Helper.implict(1);
		selectRoom2.click();
	}

	/*
	 * Method to take SS and Compare Before After Selecting 2 diff rooms for 1 day
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterSelecting2diffroomsfor1day(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		nsrb.selectDateRangeCCTC01();
		selectNumOfRoomsTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		selectsecondRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		select2Rooms();
		scroll4();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println(
					"Both images are different and rate grid updated for 1 day after Selecting 2 diff rooms TC06");
			return true;
		} else {
			System.out.println(
					"Both images are same and rate grid not updated for 1 day after Selecting 2 diff rooms TC06");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Selecting 2 diff rooms for 2 days
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterSelecting2diffroomsfor2days(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		selectDateRangeCCTC02();
		selectNumOfRoomsTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		selectsecondRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		select2Rooms();
		scroll5();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println(
					"Both images are different and rate grid updated for 2 days after Selecting 2 diff rooms TC07");
			return true;
		} else {
			System.out.println(
					"Both images are same and rate grid not updated for 2 days after Selecting 2 diff rooms TC07");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Selecting 2 diff rooms for 3 days
	 * 
	 */
	public boolean takeSSandCompareBeforeAfterSelecting2diffroomsfor3days(String filename1, String filename2)
			throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		selectDateRangeCCTC02();
		selectNumOfRoomsTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomFirst();
		selectsecondRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		sameGuestDetailsCheckBox();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		scroll();
		Helper.sleep(2000);
		clickCompleteReservation();
		soft.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Helper.sleep(2000);
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		select2Rooms();
		scroll5();
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println(
					"Both images are different and rate grid updated for 3 days after Selecting 2 diff rooms TC08");
			return true;
		} else {
			System.out.println(
					"Both images are same and rate grid not updated for 3 days after Selecting 2 diff rooms TC08");
			return false;
		}
	}

	/*
	 * Method for create room
	 */
	public void createRoom() {
		roomName.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "RoomName", 2));
		roomCode.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "RoomCode", 2));
		// select category
		WebElement a = getDriver().findElement(By.xpath("//*[@name='selectedTag']"));
		Select s = new Select(a);
		s.selectByVisibleText("All Rooms");
		// select bed types all
		List<WebElement> e = getDriver().findElements(By.xpath("//input[@name='selectedBedIds']"));
		for (WebElement i : e) {
			i.click();
		}
		// img
		pegsImage.sendKeys(
				"C:\\Users\\Rudraksh.aggarwal\\Desktop\\pp\\NewFramework\\src\\test\\resources\\testData\\DB.jpg");
		extraAdultPerRoomCharge
				.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "ExtraAdultChargePerRoom", 2));
		extraChildPerRoomCharge
				.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "ExtraChildChargePerRoom", 2));
		// select limit adult
		WebElement b = getDriver().findElement(By.xpath("//*[@name='maxOccupantsForDefaultPrice']"));
		Select q = new Select(b);
		q.selectByVisibleText("4");
		minAdult.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "minAdult", 2));
		maxAdult.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "maxAdult", 2));
		minChild.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "minChild", 2));
		maxChild.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "maxChild", 2));
		totalOccupancy.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "Occ", 2));
	}

	/*
	 * Method for click on save button
	 */
	public void clickOnSave() {
		saveButton.click();
		Helper.sleep(5000);
	}

	/*
	 * Method to click select first Room Type
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage select2Rooms() {
		Helper.implict(3);
		if (selectFirstRoomType.isSelected()) {
			System.out.println("selected");
		} else {
			selectFirstRoomType.click();
		}
		Helper.implict(3);

		selectsecondRoomType.click();

		selectRoomTypedropdwn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to input Field Rate
	 */
	public void inputFieldRate() {
		rateGridRate.clear();
		rateGridRate.sendKeys(ExcelData.CC_getCellData("MultiRoomBookingRateGridUpdate", "Rate", 2));
	}

	/*
	 * Method to delete room
	 */
	public void deleteRoom() {
		Helper.sleep(3000);
		selectRoomCheckboxAdmin.click();
		delete.click();
		Helper.waitVisibility(60, "//input[@value='Yes']");
		yesButton.click();
		Helper.sleep(2000);
	}

}

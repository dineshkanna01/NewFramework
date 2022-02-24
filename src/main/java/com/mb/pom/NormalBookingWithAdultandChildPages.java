package com.mb.pom;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.be.pom.AccessCodeBookingPage;



import Utility.ExcelData;
import base.Helper;
import base.TestBase;



public class NormalBookingWithAdultandChildPages extends TestBase {


	// @FindBy(xpath="//button[@class=\"navbar_button text-capitalize\"]")
	// WebElement dDselect;



	// @FindBy(xpath="(//button[@class=\"rangepicker_plus -theme-color\"])[1]")
	// WebElement addAdult;
	//
	// @FindBy(xpath="(//button[@class=\"rangepicker_plus -theme-color\"])[2]")
	// WebElement addChild;
	//
	// @FindBy(xpath="//input[@value=\"done\"]")
	// WebElement done;
	//
	@FindBy(xpath ="//a[contains(text(),'Got it!')]")
	WebElement gotIt;



	@FindBy(xpath = "//*[contains(@class,'-theme-color icon -arrow-bottom')]")
	WebElement dDselect;
	
	// button[@class='navbar_button text-capitalize']
	@FindBy(xpath = "(//button[@class='rangepicker_plus -theme-color'])[1]")
	WebElement addAdult;



	@FindBy(xpath = "(//button[@class='rangepicker_plus -theme-color'])[2]")
	WebElement addChild;



	@FindBy(xpath = "//input[@value='Done']")
	WebElement done;



	@FindBy(xpath = "//button[@class='button -block -lg -theme-bg get-recap-token']")
	WebElement clickSelectRoom;



	@FindBy(xpath = "//img[@class='comp-rm-arrow']")
	WebElement selectRoom;



	@FindBy(xpath = "//input[@data-disable-with='Continue']")
	WebElement clickContinue;



	@FindBy(xpath = "//input[@title='Full Name']")
	WebElement guestDetailsFullName;



	@FindBy(xpath = "//input[@placeholder='Phone number']")
	WebElement phoneNumber;



	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement eMail;



	@FindBy(xpath = "//input[@placeholder='Address']")
	WebElement adress;



	@FindBy(xpath = "(//input[@placeholder='Country'])[1]")
	WebElement countryBillingAdress;



	@FindBy(xpath = "(//input[@placeholder='Country'])[2]")
	WebElement countryPaymentDetails;



	@FindBy(xpath = "//li[text()='India']")
	WebElement countryIndia;



	@FindBy(xpath = "//select[@name='state']")
	WebElement state;



	@FindBy(xpath = "//option[text()='Delhi']")
	WebElement stateDelhi;



	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement city;



	@FindBy(xpath = "(//input[@placeholder='Zip code'])[1]")
	WebElement zipCodeBillingAdresss;



	@FindBy(xpath = "(//input[@placeholder='Zip code'])[2]")
	WebElement zipCodePaymentDetails;



	@FindBy(xpath = "//input[@placeholder='Name on card']")
	WebElement nameOnCards;



	@FindBy(xpath = "//input[@placeholder='Card number']")
	WebElement cardNumber;



	@FindBy(xpath = "//input[@placeholder='Expiration (MM/YY)']")
	WebElement expiration;



	@FindBy(xpath = "//input[@placeholder='Code']")
	WebElement ccCode;



	@FindBy(xpath = "//input[@class='tandc-checkbox']")
	WebElement tAndC;



	@FindBy(xpath = "//button[@class='button -xlg -block -theme-bg']")
	WebElement completeReservation;



	public WebDriver driver;



	public NormalBookingWithAdultandChildPages(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}



	public String UrlTilte() {
		return driver.getTitle();



	}



	/*
	 * Method for select date range
	 */
	public NormalBookingWithAdultandChildPages selectDateRange() throws InterruptedException {

		// TO GET CURRENT DATE
		Helper.javaScript("//a[contains(text(),'Got it!')]");
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date " + currentDate);
		Thread.sleep(3000);



		// WebElement a= getDriver().findElement(By.xpath("(//*[text()='"+ currentDate+
		// "'])[1]"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='" + currentDate + "'])[1]")));
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("NA");
		}
		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date " + nextDaydate);
		WebElement b = getDriver().findElement(By.xpath("(//*[text()='" + nextDaydate + "'])[1]"));
		try {
			b.click();
		} catch (Exception e) {
			System.out.println("NA");
		}

		return null;
	}
	/*
	 * Method for java script executor
	 */

	public AccessCodeBookingPage JavaScriptExcecutor() {
		WebElement element = driver.findElement(By.id("gbqfd"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		return null;
	}



	/*
	 * Method for click got it
	 */
	// public NormalBookingWithAdultandChildPages clickGotIt() {
	// gotIt.click();
	// return null;
	// }
	/*
	 * Method for select minimum adult and child
	 */
	public NormalBookingWithAdultandChildPages selectMinimumAdultandChild() throws Exception {
		// gotIt.click();
		// Helper.explicit(dDselect, 10);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.javaScript("//button[@class='navbar_button text-capitalize']");

		Helper.javaScript("(//button[@class='rangepicker_plus -theme-color'])[2]");

		Helper.javaScript("//input[@value='Done']");

		Thread.sleep(5000);
		Helper.javaScript("//button[@class='button -block -lg -theme-bg get-recap-token']");
		// dDselect.click();
		//addChild.click();
		//done.click();


		return null;
	}



	/*
	 * Method for select maximum adult and child
	 */
	public NormalBookingWithAdultandChildPages selectMaximumAdultandChild() {
		dDselect.click();
		addAdult.click();
		addAdult.click();
		addChild.click();
		addChild.click();
		addChild.click();
		done.click();
		return null;
	}



	/*
	 * Method for select minimum adult and maximum child
	 */
	public NormalBookingWithAdultandChildPages selectMinAdultandMaxChild() {
		dDselect.click();
		addChild.click();
		addChild.click();
		addChild.click();
		done.click();
		return null;
	}



	/*
	 * Method for complete reservation
	 */
	public NormalBookingWithAdultandChildPages completeReservation() {
		// gotIt.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// clickSelectRoom.click();
		// selectRoom.click();
		clickContinue.click();
		guestDetailsFullName.sendKeys(ExcelData.getCellData("MobileB", "FullName", 2));
		phoneNumber.sendKeys(ExcelData.getCellData("MobileB", "PhoneN", 2));
		eMail.sendKeys(ExcelData.getCellData("MobileB", "Email", 2));
		adress.sendKeys(ExcelData.getCellData("MobileB", "Address", 2));
		countryBillingAdress.click();
		countryIndia.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		state.click();
		city.sendKeys(ExcelData.getCellData("MobileB", "City", 2));
		zipCodeBillingAdresss.sendKeys(ExcelData.getCellData("MobileB", "ZipCode", 2));
		nameOnCards.sendKeys(ExcelData.getCellData("MobileB", "FullName", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MobileB", "CardNum", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MobileB", "CardNum", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MobileB", "CardNum", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MobileB", "CardNum", 2));
		expiration.sendKeys(ExcelData.getCellData("MobileB", "ExpD", 2));
		ccCode.sendKeys(ExcelData.getCellData("MobileB", "CCode", 2));
		countryPaymentDetails.click();
		countryIndia.click();
		zipCodePaymentDetails.sendKeys(ExcelData.getCellData("MobileB", "ZipCode", 2));
		tAndC.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		completeReservation.click();



		return null;
	}



}
package com.bookingengine;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * Pom class for Payment Gateway
 * @author Sudhakar Mourya
 * @author Rudraksh Aggarwal
 */

public class PaymentGatewayPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

	public PaymentGatewayPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='enabled']")
	WebElement enableButton;

	@FindBy(xpath = "(//input[@type='radio'])[3]")
	WebElement yesButton;

	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement noButton;

	@FindBy(xpath = "//select[@name='selectedPaymentGateway']")
	WebElement paymentGateway;

	@FindBy(xpath = "//input[@name='merchantId']")
	WebElement merchantId;

	@FindBy(xpath = "//input[@name='accessCode']")
	WebElement accessCode;

	@FindBy(xpath = "//input[@name='secureHashSecret']")
	WebElement secureHashSecret;

	@FindBy(xpath = "//input[@name='delay']")
	WebElement delayTime;

	@FindBy(xpath = "//input[@name='orderValidDuration']")
	WebElement orderTime;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement updateButton;

	@FindBy(xpath = "//h1[text()='Administrator Home']")
	WebElement administratorName;

	/*
	 * Method for select payment gateway
	 */
	public PaymentGatewayPage selectPaymentGateway(String paymentGatewayName) {
		TestBase.implict(3);
		Select s = new Select(paymentGateway);
		s.selectByVisibleText(paymentGatewayName);
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to verify JCC Auto Populate
	 */

	public PaymentGatewayPage verifyJCCAutoPopulate() {
		if (enableButton.isSelected()) {
			System.out.println("Values are autopopulated");
		} else
			System.out.println("Values are not autopopulated");
		return null;

	}

	/*
	 * Method for click on enable button
	 */
	public PaymentGatewayPage clickEnableButton() {
		enableButton.click();
		return null;
	}

	/*
	 * Method for click on yes button
	 */
	public PaymentGatewayPage clickYesButton() {
		yesButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method for click on no button
	 */
	public PaymentGatewayPage clickNoButton() {
		noButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method for click on update button
	 */
	public PaymentGatewayPage clickUpdateButton() {
		updateButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method for clear merchant id
	 */
	public PaymentGatewayPage clearMerchantId() {
		merchantId.clear();
		return null;
	}

	/*
	 * Method for clear access code
	 */
	public PaymentGatewayPage clearAccessCode() {
		accessCode.clear();
		return null;
	}

	/*
	 * Method for clear secure hash secret
	 */
	public PaymentGatewayPage clearSecureHashSecret() {
		secureHashSecret.clear();
		return null;
	}

	/*
	 * Method for enter order time
	 */
	public PaymentGatewayPage orderTime() {
		orderTime.sendKeys(e.getCellData("Sheet1", "OrderTime", 2));
		return null;
	}

	/*
	 * Method for enter delay time
	 */
	public PaymentGatewayPage delayTime() {
		delayTime.sendKeys(e.getCellData("Sheet1", "DelayTime", 2));
		return null;
	}

	/*
	 * Method for clear delay time
	 */
	public PaymentGatewayPage clearDelayTime() {
		delayTime.clear();
		return null;
	}

	/*
	 * Method for enter shift4 delay time
	 */
	public PaymentGatewayPage delayTime_SHIFT4() {
		delayTime.sendKeys(e.getCellData("Sheet1", "DelayTime", 3));
		return null;
	}

	/*
	 * Method for enter jcc merchant id
	 */
	public PaymentGatewayPage merchantId_JCC() {
		merchantId.sendKeys(e.getCellData("Sheet1", "MerchantId", 2));
		return null;
	}

	/*
	 * Method for enter jcc bookings merchant id
	 */
	public PaymentGatewayPage merchantId_JCCbookings() {
		merchantId.sendKeys(e.getCellData("JCCBookings", "MerchantID", 2));
		// merchantId.sendKeys("0099349011");

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='0099349011';", merchantId);

		return null;
	}

	/*
	 * Method for enter jcc bookings access code
	 */
	public PaymentGatewayPage accessCode_JCC() {
		accessCode.sendKeys(e.getCellData("JCCBookings", "AccessCode", 2));
		// accessCode.sendKeys("402971");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='402971';", accessCode);
		return null;
	}

	/*
	 * Method for enter jcc bookings secure hash secret
	 */
	public PaymentGatewayPage secureHashSecret_JCC() {
		 secureHashSecret.sendKeys(e.getCellData("JCCBookings", "SecureHashSecret",2));
		// 2));

		// secureHashSecret.sendKeys("6Sra64ja");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='6Sra64ja';", secureHashSecret);
		return null;
	}

	/*
	 * Method for enter jcc bookings secure hash secret for TC06
	 */
	public PaymentGatewayPage secureHashSecret_JCCTC06() {
		secureHashSecret.sendKeys(e.getCellData("JCCBookings", "SecureHashSecret", 3));
		return null;
	}

	public PaymentGatewayPage secureHashSecret_JCCTC06reset() {
		secureHashSecret.sendKeys(e.getCellData("JCCBookings", "SecureHashSecret", 2));
		return null;
	}

	/*
	 * Method for enter simplepay merchant id
	 */
	public PaymentGatewayPage merchantId_SIMPLEPAY() {
		merchantId.sendKeys(e.getCellData("Sheet1", "MerchantId", 3));
		return null;
	}

	/*
	 * Method for enter jcc access code
	 */
	public PaymentGatewayPage accessCode() {
		accessCode.sendKeys(e.getCellData("Sheet1", "AccessCode", 2));
		return null;
	}

	/*
	 * Method for enter simplpay access code
	 */
	public PaymentGatewayPage accessCode_SIMPLEPAY() {
		accessCode.sendKeys(e.getCellData("Sheet1", "AccessCode", 3));
		return null;
	}

	/*
	 * Method for enter jcc secure hash secret
	 */
	public PaymentGatewayPage secureHashSecret() {
		secureHashSecret.sendKeys(e.getCellData("Sheet1", "SecureHashSecret", 2));
		return null;
	}

	/*
	 * Method for enter shift4 secure hash secret
	 */
	public PaymentGatewayPage secureHashSecret_SHIFT4() {
		secureHashSecret.sendKeys(e.getCellData("Sheet1", "SecureHashSecret", 3));
		return null;
	}

	/*
	 * Method for enter simplepay secure hash secret
	 */
	public PaymentGatewayPage secureHashSecret_SIMPLEPAY() {
		secureHashSecret.sendKeys(e.getCellData("Sheet1", "SecureHashSecret", 4));
		return null;
	}

	/*
	 * Method for getting administrator name text
	 * 
	 * @return String administrator name
	 */
	public String administratorname() {
		return administratorName.getText();
	}

}

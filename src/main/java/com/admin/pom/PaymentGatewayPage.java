package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class PaymentGatewayPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

	public PaymentGatewayPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='enabled']")
	WebElement enableButton;

	@FindBy(xpath="(//input[@type='radio'])[3]")
	WebElement yesButton;

	@FindBy(xpath="//select[@name='selectedPaymentGateway']")
	WebElement paymentGateway;

	@FindBy(xpath="//input[@name='merchantId']")
	WebElement merchantId;

	@FindBy(xpath="//input[@name='accessCode']")
	WebElement accessCode;

	@FindBy(xpath="//input[@name='secureHashSecret']")
	WebElement secureHashSecret;

	@FindBy(xpath="//input[@name='delay']")
	WebElement delayTime;

	@FindBy(xpath="//input[@name='orderValidDuration']")
	WebElement orderTime;

	@FindBy(xpath="//input[@value='Update']")
	WebElement updateButton;

	@FindBy(xpath="//h1[text()='Administrator Home']")
	WebElement administratorName;


	public PaymentGatewayPage selectPaymentGateway(String paymentGatewayName) {
		TestBase.implict(3);
		Select s=new Select(paymentGateway);
		s.selectByVisibleText(paymentGatewayName);
		TestBase.implict(3);
		return null;
	}

	public PaymentGatewayPage clickEnableButton() {
		enableButton.click();
		return null;
	}

	public PaymentGatewayPage clickYesButton() {
		yesButton.click();
		TestBase.implict(3);
		return null;
	}

	public PaymentGatewayPage clickUpdateButton() {
		updateButton.click();
		return null;
	}

	public PaymentGatewayPage clearMerchantId() {
		merchantId.clear();
		return null;
	}

	public PaymentGatewayPage clearAccessCode() {
		accessCode.clear();
		return null;
	}

	public PaymentGatewayPage clearSecureHashSecret() {
		secureHashSecret.clear();
		return null;
	}

	public PaymentGatewayPage orderTime() throws Exception {
		orderTime.sendKeys(e.getCellData("Sheet1","OrderTime",2));
		return null;
	}

	public PaymentGatewayPage delayTime() throws Exception {
		delayTime.sendKeys(e.getCellData("Sheet1","DelayTime",2));
		return null;
	}
	
	public PaymentGatewayPage clearDelayTime() {
		delayTime.clear();
		return null;
	}

	public PaymentGatewayPage delayTime_SHIFT4() throws Exception {
		delayTime.sendKeys(e.getCellData("Sheet1","DelayTime",3));
		return null;
	}

	public PaymentGatewayPage merchantId_JCC() throws Exception {
		merchantId.sendKeys(e.getCellData("Sheet1","MerchantId",2));
		return null;
	}

	public PaymentGatewayPage merchantId_SIMPLEPAY() throws Exception {
		merchantId.sendKeys(e.getCellData("Sheet1","MerchantId",3));
		return null;
	}

	public PaymentGatewayPage accessCode_JCC() throws Exception {
		accessCode.sendKeys(e.getCellData("Sheet1","AccessCode",2));
		return null;
	}

	public PaymentGatewayPage accessCode_SIMPLEPAY() throws Exception {
		accessCode.sendKeys(e.getCellData("Sheet1","AccessCode",3));
		return null;
	}

	public PaymentGatewayPage secureHashSecret_JCC() throws Exception {
		secureHashSecret.sendKeys(e.getCellData("Sheet1","SecureHashSecret",2));
		return null;
	}

	public PaymentGatewayPage secureHashSecret_SHIFT4() throws Exception {
		secureHashSecret.sendKeys(e.getCellData("Sheet1","SecureHashSecret",3));
		return null;
	}

	public PaymentGatewayPage secureHashSecret_SIMPLEPAY() throws Exception {
		secureHashSecret.sendKeys(e.getCellData("Sheet1","SecureHashSecret",4));
		return null;
	}

    public String administratorname() {
		return administratorName.getText();
	}

}

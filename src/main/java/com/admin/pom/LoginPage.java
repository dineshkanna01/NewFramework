package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class LoginPage extends AbstractBasePage{

	ExcelData e = new ExcelData();

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}
	@FindBy(xpath="//input[@name='j_username']")
	WebElement username;
	@FindBy(xpath="//input[@name='j_password']")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;

	@FindBy(xpath="//button[text()='Next']")
	WebElement nextButton;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitButton;

	@FindBy(xpath = "//input[@value='Clear']")
	WebElement clearButton;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotPassword;

	@FindBy(xpath = "//input[@name='username']")
	WebElement fUsername;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement fSubmitButton;

	//	@FindBy(xpath = "//a[text()='Return Home']")
	//	WebElement ReturnHome;

	@FindBy(xpath = "//*[contains(text(),'Username and/or pass')]")
	WebElement header3;

	@FindBy(xpath = "//h1[text()='Administrator Home']")
	WebElement header1;

	@FindBy(xpath = "//*[text() = 'A password request has been made.']")
	WebElement forgotPasswordText;

	@FindBy(xpath = "//*[@class='dropdown']")
	WebElement myAccount;

	@FindBy(xpath = "//*[@class='dropdown-content pull-right']/a[4]")
	WebElement logoutButton;
	
	@FindBy(xpath = "//a[text()='here']")
	WebElement returnLoginPage;
	
	@FindBy(xpath = "//a[text()='Return Home']")
	WebElement returnLoginPage2;

	public LoginPage login() throws Exception {
		Thread.sleep(3000);
		username.click();
		username.clear();;
		username.sendKeys(e.getCellData("LoginPageData", "Username", 2));
		Thread.sleep(3000);
		password.click();
		password.clear();
		password.sendKeys(e.getCellData("LoginPageData", "Password", 2));
		loginButton.click();

		return null;
	}

	public LoginPage username() throws Exception {
		TestBase.implict(3);
		username.sendKeys(e.getCellData("LoginPageData", "Username", 2));
		TestBase.implict(3);
		return null;
	}

	public LoginPage password() throws Exception {
		TestBase.implict(3);
		password.sendKeys(e.getCellData("LoginPageData", "Password", 2));
		TestBase.implict(3);
		return null;
	}

	public LoginPage loginButton() throws Exception {
		TestBase.implict(3);
		loginButton.click();
		TestBase.implict(3);
		return null;
	}

	public LoginPage twoFactorAuthentication() throws Exception {
		nextButton.click();

		TestBase.implict(3);
		submitButton.click();

		TestBase.implict(3);
		return null;
	}

	public String verifyLogin() throws Exception {
		TestBase.implict(3);
		String s = header1.getText();
		return s;
	}

	public LoginPage clearButton() throws Exception {
//		Thread.sleep(2000);
		TestBase.implict(3);
		clearButton.click();
		TestBase.implict(3);

		return null;

	}

	public String verifyClearButton() {
		TestBase.implict(3);
		String clear = clearButton.getAttribute("value");
		System.out.println(clear);
		return clear;
	}

	public boolean verifyFieldsCleared() {
		TestBase.implict(3);
		String pass = password.getAttribute("value");
		String ele = username.getAttribute("value");
//		System.out.println(ele);
//		System.out.println(pass);
		TestBase.implict(3);
		if (ele.isEmpty() && pass.isEmpty()) {
			System.out.println("Fields are cleared");
			return true;
		} else
			System.out.println("Fields are not cleared");
		return false;
	}

	public LoginPage forgotPassword() throws Exception {
		TestBase.implict(3);
		forgotPassword.click();
		TestBase.implict(3);
		fUsername.click();
		fUsername.sendKeys(e.getCellData("LoginPageData", "Username_02", 2));
		TestBase.implict(3);
		email.sendKeys(e.getCellData("LoginPageData", "ForgotEmail", 2));
		TestBase.implict(3);
		fSubmitButton.click();
		TestBase.implict(3);

		return null;

	}
	
	public LoginPage ReturnHome() throws Exception {
		
		returnLoginPage2.click();
		TestBase.implict(3);

		return null;

	}
	
	public String verifyForgotPassword() {
		TestBase.implict(3);
		String s = forgotPasswordText.getText();
		System.out.println(s);
		return s;
	}

	public LoginPage invalidUserName() throws Exception {
		TestBase.implict(3);
		username.sendKeys(e.getCellData("LoginPageData", "InvalidUserName", 2));
		TestBase.implict(3);
		return null;

	}

	public String verifyLoginNotSuccess() throws Exception {
		TestBase.implict(3);
		String s = header3.getText();
		return s;
	}

	public LoginPage invalidPassword() throws Exception {
		
		TestBase.implict(3);
		password.sendKeys(e.getCellData("LoginPageData", "InvalidPassword", 2));
		return null;

	}

	public LoginPage logout() throws InterruptedException {
		Thread.sleep(3000);
		myAccount.click();
		logoutButton.click();
		driver.close();
		return null;
	}

}

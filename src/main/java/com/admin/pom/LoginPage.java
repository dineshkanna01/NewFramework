package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
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
		Thread.sleep(3000);
		username.sendKeys(e.getCellData("LoginPage", "Username", 2));
		Thread.sleep(1000);
		return null;
	}

	public LoginPage password() throws Exception {
		Thread.sleep(3000);
		password.sendKeys(e.getCellData("LoginPage", "Password", 2));
		Thread.sleep(1000);
		return null;
	}

	public LoginPage loginButton() throws Exception {
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(1000);
		return null;
	}

	public LoginPage twoFactorAuthentication() throws Exception {
		nextButton.click();

		Thread.sleep(30000);
		submitButton.click();

		Thread.sleep(3000);
		return null;
	}

	public String verifyLogin() throws Exception {

		String s = header1.getText();
		return s;
	}

	public LoginPage clearButton() throws Exception {
		Thread.sleep(2000);
		clearButton.click();
		Thread.sleep(1000);

		return null;

	}

	public String verifyClearButton() {
		String clear = clearButton.getAttribute("value");
		System.out.println(clear);
		return clear;
	}

	public boolean verifyFieldsCleared() {
		String pass = password.getAttribute("value");
		String ele = username.getAttribute("value");
//		System.out.println(ele);
//		System.out.println(pass);

		if (ele.isEmpty() && pass.isEmpty()) {
			System.out.println("Fields are cleared");
			return true;
		} else
			System.out.println("Fields are not cleared");
		return false;
	}

	public LoginPage forgotPassword() throws Exception {

		forgotPassword.click();
		Thread.sleep(2000);
		fUsername.click();
		fUsername.sendKeys(e.getCellData("LoginPage", "Username_02", 2));
		Thread.sleep(1000);
		email.sendKeys(e.getCellData("LoginPage", "ForgotEmail", 2));
		Thread.sleep(1000);
		fSubmitButton.click();
		Thread.sleep(1000);

		return null;

	}
	
	public String verifyForgotPassword() {
		
		String s = forgotPasswordText.getText();
		System.out.println(s);
		return s;
	}

	public LoginPage invalidUserName() throws Exception {
		Thread.sleep(3000);
		username.sendKeys(e.getCellData("LoginPage", "InvalidUserName", 2));
		Thread.sleep(1000);
		return null;

	}

	public String verifyLoginNotSuccess() throws Exception {

		String s = header3.getText();
		return s;
	}

	public LoginPage invalidPassword() throws Exception {
		Thread.sleep(3000);
		password.sendKeys(e.getCellData("LoginPage", "InvalidPassword", 2));
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

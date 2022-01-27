package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
* POM class to login to AdminPortal
* @Author Uzair Asar
*/
public class LoginPage extends AbstractBasePage{

	ExcelData e = new ExcelData();

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
	
	public LoginPage clickClearButton()  {
		TestBase.implict(3);
		clearButton.click();
		TestBase.implict(3);
		return null;
		}

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}
	
	public LoginPage login() {
		TestBase.implict(6);
		username.click();
		username.clear();;
		username.sendKeys(e.getCellData("LoginPageData", "Username", 2));
		TestBase.implict(6);
		password.click();
		password.clear();
		password.sendKeys(e.getCellData("LoginPageData", "Password", 2));
		loginButton.click();

		return null;
	}

	/*
	 * Method to provide user name to the login
	 */

	public LoginPage username() {
		TestBase.implict(6);
		username.click();
		username.clear();
		username.sendKeys(e.getCellData("LoginPageData", "Username", 2));
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to provide password to the login
	 */

	public LoginPage password() {
		TestBase.implict(6);
		password.click();
		password.clear();
		TestBase.implict(3);
		password.sendKeys(e.getCellData("LoginPageData", "Password", 2));
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click on loginButton
	 */

	public LoginPage loginButton() {
		TestBase.implict(3);
		loginButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * 2FA
	 */

	public LoginPage twoFactorAuthentication() {
		nextButton.click();

		TestBase.implict(3);
		submitButton.click();

		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to verify successfully login
	 * returns string s
	 */

	public String verifyLogin() {
		TestBase.implict(3);
		String s = header1.getText();
		return s;
	}

	/*
	 * Method to clear user name and password fields
	 */

	public LoginPage clearButton() {
		TestBase.implict(3);
		clearButton.click();
		TestBase.implict(3);

		return null;

	}

	/*
	 * Method to verify clear button is visible
	 * returns string s
	 */

	public String verifyClearButton() {
		TestBase.implict(3);
		String clear = clearButton.getAttribute("value");
		System.out.println(clear);
		return clear;
	}

	/*
	 * Method to verify fields are cleared
	 * return boolean value
	 */

	public boolean verifyFieldsCleared() {
		TestBase.implict(3);
		String pass = password.getAttribute("value");
		String ele = username.getAttribute("value");
		TestBase.implict(3);
		if (ele.isEmpty() && pass.isEmpty()) {
			System.out.println("Fields are cleared");
			return true;
		} else
			System.out.println("Fields are not cleared");
		return false;
	}

	/*
	 * Method to click on Forgot password and generating new password
	 */

	public LoginPage forgotPassword() {
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

	/*
	 * Method to return back to login page
	 */

	public LoginPage ReturnHome() {

		returnLoginPage2.click();
		TestBase.implict(3);

		return null;

	}

	/*
	 * Method to verify password change request sent
	 * returns string s
	 */

	public String verifyForgotPassword() {
		TestBase.implict(3);
		String s = forgotPasswordText.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to provide invalid user name
	 */

	public LoginPage invalidUserName() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		username.click();
		username.clear();
		username.sendKeys(e.getCellData("LoginPageData", "InvalidUserName", 2));
		TestBase.implict(3);
		return null;

	}

	/*
	 * Method verify user can't login with invalid user name and invalid password
	 * returns string s
	 */

	public String verifyLoginNotSuccess() {
		TestBase.implict(3);
		String s = header3.getText();
		return s;
	}

	/*
	 * Method to provide invalid password
	 */

	public LoginPage invalidPassword() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		password.click();
		password.clear();

		password.sendKeys(e.getCellData("LoginPageData", "InvalidPassword", 2));
		return null;

	}

	/*
	 * Method to logout after login
	 */

	public LoginPage logout() {
		TestBase.implict(3);
		myAccount.click();
		logoutButton.click();
		driver.close();
		return null;
	}

}

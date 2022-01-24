package com.admin;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.LoginPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class AdminLogin extends TestBase{
	
	public static Utilitylog logger;
//	LoginPage lp = new LoginPage(getDriver());

	public AdminLogin() {
		super();
		logger = new Utilitylog(AdminLogin.class.getName());
	}

	LoginPage lp;
	
	@BeforeMethod
	public void setup() throws Exception {
		lp = new LoginPage(getDriver());
		lp.clearButton();
	}

//	@Test(priority = 1)
	@Description("Verify the Admin Login")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Login")
	@Story("Story: Admin Page Login")
	@Step("Verify Admin Page Login Presence")
	public void Admin_Login_TC_01() throws Exception {
		extentTest = extent.startTest("Admin_Login_TC_01");
		
		lp.clearButton();
		lp.username();
		lp.password();
		lp.loginButton();
//		lp.TwoFactorAuthentication();
		
		allureScreenshot("Administrator Home After Login");
		screenShot("Administrator Home After Login");
		
		String home = lp.verifyLogin();
		System.out.println(home);
		Assert.assertEquals(home, "Administrator Home");
		
		lp.logout();
	}

	@Test(priority = 2)
	@Description("Verify the user is able to use \"clear\" functionality on the login page.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Clear Username Password")
	@Story("Story: Clear Fields")
	@Step("Verify fields are being cleared")
	public void Admin_Login_TC_02() throws Exception {
		extentTest = extent.startTest("Admin_Login_TC_02");
		
		lp.clearButton();
		lp.username();
		lp.password();
		
		allureScreenshot("Before Fields Cleared");
		screenShot("Before Fields Cleared");
		
		String clearbtn = lp.verifyClearButton();
		System.out.println(clearbtn);
		Assert.assertEquals(clearbtn, "Clear");
		
		assertFalse(lp.verifyFieldsCleared());
		lp.clearButton();
		
		allureScreenshot("After Fields Cleared");
		screenShot("After Fields Cleared");
		
		assertTrue(lp.verifyFieldsCleared());
	}

	@Test(priority = 3)
	@Description("Verify the user is successfully able to change his password through the \"Forgot your password\" link")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Frogot Password")
	@Story("Story: Change Password by Forgot Password")
	@Step("Verify Forgot Password works")
	public void Admin_Login_TC_03() throws Exception {
		extentTest = extent.startTest("Admin_Login_TC_03");
		
		lp.clearButton();
		lp.forgotPassword();
		
		allureScreenshot("Reset Sent Password");
		screenShot("Reset Sent Password");
		
		String ForgotPassSent = lp.verifyForgotPassword();
		Assert.assertEquals(ForgotPassSent, "A password request has been made.");
		
		lp.ReturnHome();
//		lp.logout();
	}

	@Test(priority = 4)
	@Description("Verify the user is not able to sign in with invalid credentials (invalid username)")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Invalid User")
	@Story("Story: Can't login")
	@Step("Verify login won't happen")
	public void Admin_Login_TC_04() throws Exception {
		extentTest = extent.startTest("Admin_Login_TC_04");
		
//		lp.clearButton();
		lp.invalidUserName();
		lp.password();
		lp.loginButton();
		
		allureScreenshot("Incorrect Username Typed");
		screenShot("Incorrect Username Error");
		
		String fail = lp.verifyLoginNotSuccess();
		System.out.println("Username is incorrect.");
		Assert.assertEquals(fail, "Username and/or password is incorrect. Please try again.");
	}

	@Test(priority = 5)
	@Description("Verify the user is not able to sign in with invalid credentials (invalid password)")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Invalid Password")
	@Story("Story: Can't login")
	@Step("Verify login won't happen")
	public void Admin_Login_TC_05() throws Exception {
		extentTest = extent.startTest("Admin_Login_TC_05");
		
//		lp.clearButton();
		lp.username();
		lp.invalidPassword();
		lp.loginButton();
		
		allureScreenshot("Incorrect Password Typed");
		screenShot("Incorrect Password Error");
		
		String fail = lp.verifyLoginNotSuccess();
		System.out.println("Password is incorrect.");
		Assert.assertEquals(fail, "Username and/or password is incorrect. Please try again.");
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}

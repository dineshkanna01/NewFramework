package com.admin;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.GuestPreferenceQuestionsPage;
import com.admin.pom.LoginPage;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

/*
 *Test class for Guest Preference Questions
 * @author Rudraksh Aggarwal
 */
public class Guest_Preferences_Questions extends TestBase {

	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	GuestPreferenceQuestionsPage gpp;

	public Guest_Preferences_Questions() {
		super();
		logger = new Utilitylog(Guest_Preferences_Questions.class.getName());
	}

	@BeforeMethod
	public void setup() {

		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		gpp = new GuestPreferenceQuestionsPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to add Guest Preference Questions for Single Selection type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:GuestPreferenceQuestions")
	@Story("GuestPreferenceQuestions Page")
	@Step("Verify that the user is able to add Guest Preference Questions")
	public void GuestPreferencesQuestions_01() {

		extentTest = extent.startTest("GuestPreferencesQuestions_01");
		logger.info("TestCase Started");

		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickGuestPreferenceQuestionsTab();
		ahp.clickAddNewGuestPreference();

		allureScreenshot("GuestPreference Page");
		screenShot("GuestPreference Page");

		gpp.selectSingleType();
		Assert.assertFalse(gpp.verifyMaxOptionsAllowedInputField());
		gpp.inputTextFieldsSingleType();
		gpp.clickOnSave();

		allureScreenshot("Guest preference question created");
		screenShot("Guest preference question created");

		Assert.assertTrue(gpp.verifyGuestPrefQuesName());

		gpp.clickOnDelete();
		gpp.clickOnOK();

		Assert.assertTrue(gpp.verifyGuestPrefQuesName_Delete());

		// lp.logout();
		logger.info("TestCase Ended");

	}

	@Test(priority = 2)
	@Description("Verify that the user is able to add Guest Preference Questions for Multiple Selection type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:GuestPreferenceQuestions")
	@Story("GuestPreferenceQuestions Page")
	@Step("Verify that the user is able to add Guest Preference Questions")
	public void GuestPreferencesQuestions_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("GuestPreferencesQuestions_02");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickGuestPreferenceQuestionsTab();
		 */

		ahp.clickAddNewGuestPreference();

		allureScreenshot("GuestPreference Page");
		screenShot("GuestPreference Page");

		gpp.selectMultipleType();
		Assert.assertTrue(gpp.verifyMaxOptionsAllowedInputField());
		gpp.inputTextFieldsMultipleType();
		gpp.clickOnSave();

		allureScreenshot("Guest preference question created");
		screenShot("Guest preference question created");

		Assert.assertTrue(gpp.verifyGuestPrefQuesName());

		gpp.clickOnDelete();
		gpp.clickOnOK();

		Assert.assertTrue(gpp.verifyGuestPrefQuesName_Delete());

//		lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is able to add Guest Preference Questions for Free Text type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:GuestPreferenceQuestions")
	@Story("GuestPreferenceQuestions Page")
	@Step("Verify that the user is able to add Guest Preference Questions")
	public void GuestPreferencesQuestions_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("GuestPreferencesQuestions_03");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickGuestPreferenceQuestionsTab();
		 */

		ahp.clickAddNewGuestPreference();

		allureScreenshot("GuestPreference Page");
		screenShot("GuestPreference Page");

		Assert.assertTrue(gpp.verifyMaxOptionsAllowedField());

		gpp.selectFreeTextType();
		gpp.inputTextFieldsFreeTextType();

		Assert.assertFalse(gpp.verifyMaxOptionsAllowedField());

		gpp.clickOnSave();

		allureScreenshot("Guest preference question created");
		screenShot("Guest preference question created");

		Assert.assertTrue(gpp.verifyGuestPrefQuesName());

		gpp.clickOnDelete();
		gpp.clickOnOK();

		Assert.assertTrue(gpp.verifyGuestPrefQuesName_Delete());
		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify that the user is able to add and delete Guest Preference Questions")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:GuestPreferenceQuestions")
	@Story("GuestPreferenceQuestions Page")
	@Step("Verify that the user is able to add Guest Preference Questions")
	public void GuestPreferencesQuestions_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("GuestPreferencesQuestions_04");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickGuestPreferenceQuestionsTab();
		 */

		ahp.clickAddNewGuestPreference();

		allureScreenshot("GuestPreference Page");
		screenShot("GuestPreference Page");

		gpp.inputTextFieldsSingleType();
		gpp.clickOnSave();

		allureScreenshot("Guest preference question created");
		screenShot("Guest preference question created");

		Assert.assertTrue(gpp.verifyGuestPrefQuesName());

		gpp.clickOnDelete();
		gpp.clickOnOK();

		allureScreenshot("Guest preference question Deleted");
		screenShot("Guest preference question Deleted");

		Assert.assertTrue(gpp.verifyGuestPrefQuesName_Delete());
//		lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify that the user is able to edit Guest Preference Questions and change category")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:GuestPreferenceQuestions")
	@Story("GuestPreferenceQuestions Page")
	@Step("Verify that the user is able to add Guest Preference Questions")
	public void GuestPreferencesQuestions_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("GuestPreferencesQuestions_05");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickGuestPreferenceQuestionsTab();
		 */

		ahp.clickAddNewGuestPreference();

		gpp.inputTextFieldsSingleType();
		gpp.clickOnSave();

		allureScreenshot("Guest preference question created");
		screenShot("Guest preference question created");

		Assert.assertTrue(gpp.verifyGuestPrefQuesCategory());

		allureScreenshot("Guest preference question Category");
		screenShot("Guest preference question Category");

		gpp.clickOnEdit();
		gpp.selectCategoryRadioButton();
		gpp.clickOnSave();

		allureScreenshot("Guest preference question Category changed");
		screenShot("Guest preference question Category changed");

		Assert.assertFalse(gpp.verifyGuestPrefQuesCategory());

		gpp.clickOnDelete();
		gpp.clickOnOK();
		lp.logout();
		logger.info("TestCase Ended");
	}

	@AfterSuite
	public void report() {
		try {
			mail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cmdPrompt();
	}
}

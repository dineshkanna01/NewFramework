package com.admin;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.IndependentHotelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.NewPropertyPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class IndependentHotel extends TestBase{


	public static Utilitylog logger;
	LoginPage lp = new LoginPage(getDriver());
	
	public IndependentHotel() {
		super();
		logger = new Utilitylog(IndependentHotel.class.getName());
	}

	@BeforeMethod
	public void setup() {
		initilization();
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to create a new independent Hotel in the CRS system.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: New  Independent Property")
	@Story("Story: Independent Hotel Created")
	@Step("Verify New Independent Hotel Created")
	public void Admin_CreateIndependentHotel_TC_01() throws Throwable {
		LoginPage lp = new LoginPage(getDriver());
		extentTest = extent.startTest("Admin_CreateIndependentHotel_TC_01");
		lp.clearButton();
		lp.username();
		lp.password();
		lp.loginButton();
//		lp.TwoFactorAuthentication();
		allureScreenshot("Logged In");
		IndependentHotelPage ihp = new IndependentHotelPage(getDriver());
		ihp.selectingIndependentHotel();
		allureScreenshot("Independent Hotel");
		NewPropertyPage npp = new NewPropertyPage(getDriver());
		npp.newPropertyEditPage();
		allureScreenshot("Property Edit Page Filled");
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		npp.propertyDefaultPage();
		allureScreenshot("Property Default Page Filled");
		String DefaultSave = npp.verifyDefaultSaveButton();
		Assert.assertEquals(DefaultSave, "  Save  ");
		npp.propertyDefaultPageSaveButton();
		ihp.independentHotels();
		allureScreenshot("Independent Hotel Found");
		assertTrue(ihp.verifyIndependentHotelCreated());
		lp.logout();

	}

//	@AfterMethod
	public void browerClose() throws InterruptedException {
		getDriver().quit();
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}

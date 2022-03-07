package com.mobilebooking;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.mb.pom.MobileBookingsWithValidOfferCodePage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class MobileBookingsWithValidOfferCodeScenario extends TestBase {
	public static Utilitylog logger;

	public MobileBookingsWithValidOfferCodeScenario() {
		super();
		logger = new Utilitylog(MobileBookingsWithInvalidOfferCodeScenario.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	MobileBookingsWithValidOfferCodePage voc;

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		voc = new MobileBookingsWithValidOfferCodePage(getDriver());
		ahp = new AdministratorHomePage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify that user is  able to do bookings with valid offer code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Mobile bookings with valid offer code scenario")
	@Story("Mobile bookings with valid offer code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithInvalidOfferCode_TC_01()   {
		extentTest = extent.startTest("NormalBookingsWithInvalidOfferCode_TC_01");
		lp.clickClearButton();
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty3();
		voc.createAccessCode1();
		allureScreenshot("Access Code Created");
		screenShot("Access Code Created");
		Assert.assertTrue(voc.verifyAccessCodeCreated());
	}

	@Test(priority = 2)
	@Description("Verify that user is  able to  edited offer code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Mobile bookings with valid offer code scenario")
	@Story("Mobile bookings with valid offer code scenario")
	@Step("Verify that user is  able to  edited offer code")
	public void NormalBookingsWithInvalidOfferCode_TC_02() throws AWTException {
		extentTest = extent.startTest("NormalBookingsWithInvalidOfferCode_TC_02");
		voc.editCreatedAccessCode();
		allureScreenshot("Access Code edited");
		screenShot("Access Code edited");
		Assert.assertTrue(voc.verifyAccessCodeEdited());
	}
	@Test(priority = 3)
	@Description("Verify that user is  able to do bookings with edited offer code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Mobile bookings with invalid offer code scenario")
	@Story("Mobile bookings with invalid offer code scenario")
	public void NormalBookingsWithInvalidOfferCode_TC_03() throws AWTException {
		extentTest = extent.startTest("NormalBookingsWithInvalidOfferCode_TC_03");
		mobileTest("Moto G4", 318, 850);
		voc.editedOfferCodeReservation();
		Assert.assertTrue(voc.verifyValidOfferCode());
		allureScreenshot("Access Code Applied");
		screenShot("Access Code Applied");
		voc.dateSelection();
		allureScreenshot("Date selected");
		screenShot("Date selected");
		voc.selectRoom();
		allureScreenshot("Verify rateplan");
		screenShot("Verify rateplan");
		voc.avlOffers();
		voc.comReservation();
		allureScreenshot("Confirmation page");
		screenShot("Confirmation page");
		Assert.assertTrue(voc.verifyConfirmationCode());
		logger.info("TestCase Ended");




	}
}
package com.mobilebooking;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.mb.pom.CancelWebBookingFromMobilePages;
import com.mb.pom.MobileBookingUsingPromoURLPages;

import base.Helper;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class CancelWebBookingFromMobileScenario  extends TestBase{
	
	public static Utilitylog logger;

	public CancelWebBookingFromMobileScenario() {
		super();
		logger = new Utilitylog(CancelWebBookingFromMobileScenario.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	CancelWebBookingFromMobilePages cwfm;
	
	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cwfm =new CancelWebBookingFromMobilePages(getDriver());
	}
	@Test(priority = 1)
	@Description("Verify that user is  able to cancel a Web booking in mobile")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Cancel Web Booking From Mobile Scenario")
	@Story("Cancel Web Booking From Mobile Scenario")
	@Step("Verify user should able to Cancel Web Booking From Mobile ")
	public void MobileBookingUsingPromoURL_TC_01()  {
		extentTest = extent.startTest("CancelWebBookingFromMobileScenario");

	openURL("be_url3");
	//cwfm.selectDate();
	cwfm.webBEReservation();
	//Assert.assertTrue(cwfm.displayConfirmationCode());
	cwfm.getConfirmationNo();
//	cwfm.getConfirmationMailId();
	
	allureScreenshot("WebBooking Successful");
	screenShot("Cancel WebBooking Successful");
	//cwfm.getConfirmationMailId();
	mobileTest("Moto G4", 318,850);
	cwfm.cancelinMobWebBEReservation();
	cwfm.scrollDownTen();
	cwfm.clickOnCancelinMobWebBEReservation();
	allureScreenshot("Cancel WebBooking From Mobile");
	screenShot("Cancel WebBooking From Mobile");
	Assert.assertTrue(cwfm.verifyMobileCancellationCode());

}
	
}
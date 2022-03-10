package com.mobilebooking;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.admin.pom.LoginPage;
import com.mb.pom.MBPNormalMobileBookingwithAdultsandChild;

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


public class MBPNormalBookingsWithAdultsandChildScenario extends TestBase {

	public static Utilitylog logger;
	MBPNormalMobileBookingwithAdultsandChild mbp;
	LoginPage lp;
	public MBPNormalBookingsWithAdultsandChildScenario() {
		super();
		logger = new Utilitylog(MBPNormalBookingsWithAdultsandChildScenario.class.getName());
		mbp= new MBPNormalMobileBookingwithAdultsandChild(getDriver());
		lp = new LoginPage(getDriver());
	}
	@Test(priority = 1)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithAdultsandChildScenario_TC_01()  {
		extentTest = extent.startTest("NormalBookingsWithAdultsandChildScenario_TC_01");
		logger.info("TestCase Started");
		getDriver().quit();
		mobileTest("Moto G4", 318,850);
		mbp.dateSelection();
		allureScreenshot("Date selected");
		screenShot("Date selected");
		mbp.noAdultTC01();
		mbp.selectRoom();
		mbp.avlOffers();
		allureScreenshot("Offer selected");
		screenShot("Offer selected");
		mbp.comReservation();
		allureScreenshot("Confirmation page");
		screenShot("Confirmation page");
		Assert.assertTrue(mbp.verifyConfirmationCode());
		logger.info("TestCase Ended");
//		getDriver().close();
		//getDriver().quit();
	
}
	
	@Test(priority = 2)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithAdultsandChildScenario_TC_02()  {
		extentTest = extent.startTest("NormalBookingsWithAdultsandChildScenario_TC_02");
		logger.info("TestCase Started");
		Helper.refreshURL();
		mbp.dateSelection();
		allureScreenshot("Date selected");
		screenShot("Date selected");
		mbp.noAdultTC02();
		allureScreenshot("guest selected");
		screenShot("Guest selected");
		mbp.selectRoom();
		mbp.avlOffers();
		allureScreenshot("Offer selected");
		screenShot("Offer selected");
		mbp.comReservation();
		allureScreenshot("Confirmation page");
		screenShot("Confirmation page");
		Assert.assertTrue(mbp.verifyConfirmationCode());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 3)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithAdultsandChildScenario_TC_03()  {
		extentTest = extent.startTest("NormalBookingsWithAdultsandChildScenario_TC_03");
		logger.info("TestCase Started");
		Helper.refreshURL();
		mbp.dateSelection();
		allureScreenshot("Date selected");
		screenShot("Date selected");
		mbp.noAdultTC03();
		allureScreenshot("guest selected");
		screenShot("Guest selected");
		mbp.selectRoom();
		mbp.avlOffers();
		allureScreenshot("Offer selected");
		screenShot("Offer selected");
		mbp.comReservation();
		allureScreenshot("Confirmation page");
		screenShot("Confirmation page");
		Assert.assertTrue(mbp.verifyConfirmationCode());
		logger.info("TestCase Ended");
	}

}

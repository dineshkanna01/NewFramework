package com.mobilebooking;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.mb.pom.MBPNormalMobileBookingwithAdultsandChild;
import com.mb.pom.MobileBookingUsingAccessCodeURLPage;
//import com.mb.pom.MobileBookingUsingPromoURLPages;

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

public class MobileBookingUsingAccessCodeURL extends TestBase {

	public static Utilitylog logger;
	
	LoginPage lp;
	AdministratorHomePage ahp;
	MBPNormalMobileBookingwithAdultsandChild mbp;
//	MobileBookingUsingPromoURLPages PURL;
	SoftAssert soft;
	MobileBookingUsingAccessCodeURLPage mbac;
	
	public MobileBookingUsingAccessCodeURL() {
	   super();
	logger = new Utilitylog(MobileBookingUsingAccessCodeURL.class.getName());}
	
	@BeforeMethod
	public void setup() {
		mbp= new MBPNormalMobileBookingwithAdultsandChild(getDriver());
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
//		PURL =new MobileBookingUsingPromoURLPages(getDriver());
		mbac= new MobileBookingUsingAccessCodeURLPage(getDriver());
		soft = new SoftAssert();
	}
	
	@Test(priority = 1)
	@Description("Verify user should able to do mobile booking using access Code URL")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Mobile booking using Access Code URL")
	@Story("Mobile booking using Access Code URL")
	@Step("Verify user should able to do mobile booking using access Code URL")
	public void MobileBookingUsingAccessCodeURL_TC_01() throws Exception  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("MobileBookingUsingAccessCodeURL_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty3();
		mbac.inputFieldTc_01();
//		Helper.copyAndPaste();
//		mbac.getAccessCodeUrl(); 
		Helper.sleep(4000);
		Helper.copiedUrl("Moto G4", 412, 845);
//		Helper.openNewTab();
//		Helper.paste();

//		mobileTest("Moto G4", 318,850);
//		mbp.dateSelection();
//		allureScreenshot("Date selected");
//		screenShot("Date selected");
//		mbp.noAdultTC01();
//		mbp.selectRoom();
//		mbp.avlOffers();
//		allureScreenshot("Offer selected");
//		screenShot("Offer selected");
//		mbp.comReservation();
//		allureScreenshot("Confirmation page");
//		screenShot("Confirmation page");
//		Assert.assertTrue(mbp.verifyConfirmationCode());
//		logger.info("TestCase Ended");
               
}
	
//	@Test(priority = 2)
	@Description("Verify user should not able to do mobile booking using access Code URL by clicking on the link")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Mobile booking using Access Code URL")
	@Story("Mobile booking using Access Code URL")
	@Step("Not able to do mobile booking by clicking access Code link")
	public void MobileBookingUsingAccessCodeURL_TC_02() throws Exception  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("MobileBookingUsingAccessCodeURL_TC_02");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty3();
		mbac.inputFieldTc_02();
		allureScreenshot("Web booking page displayed");
		screenShot("Web booking page displayed");
		soft.assertTrue(mbac.verifyWebBookingPage());
		logger.info("TestCase Ended");
	}	
}


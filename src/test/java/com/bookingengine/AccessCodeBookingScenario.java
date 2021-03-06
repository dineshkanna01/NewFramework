package com.bookingengine;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.AboutPropertyCreationScenario;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.AccessCodeBookingPage;

import Utility.ExcelData;
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


/*
 * Test class for  Access code booking scenario
 * @author Ankita mohamanasingh
 */

public class AccessCodeBookingScenario extends TestBase {

	public static Utilitylog logger;

	public AccessCodeBookingScenario() {
		super();
		logger = new Utilitylog(AboutPropertyCreationScenario.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	AccessCodeBookingPage acb;

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		acb = new AccessCodeBookingPage(getDriver());
	}


	@Test(priority = 1)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void manageAccessCodeBookingsScenario_TC_01() {
		
		extentTest = extent.startTest("manageAccessCodeBookingsScenario_TC_01");
		openURL("be_url3");
		acb.AccessCodeRatePlanInBE();
		acb.scrollDownTen();
		allureScreenshot("AccessCodeRatePlanNotdisplaying");
		screenShot("AccessCodeRatePlanNotdisplaying");
		Helper.switchWindow(0);
		lp.clickClearButton();
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty3();
		acb.createAccessCode();
		allureScreenshot("AccessCodeCreated");
		screenShot("AccessCodeCreated");
		Helper.switchWindow(1);
		getDriver().navigate().back();
		acb.AccessCodeRatePlanInBE();
		acb.scrollDownFive();	
		allureScreenshot("AccessCodeRatePlandisplaying");
		screenShot("AccessCodeRatePlandisplaying");
		Assert.assertTrue(acb.verifyAccessCodeRatePlan());
		getDriver().close();
		Helper.switchWindow(0);

	}

	@Test(priority = 2)
	@Description("Verify that user is able to do bookings from access code URL")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is able to do bookings from access code URL")
	public void manageAccessCodeBookingsScenario_TC_02() {

		extentTest = extent.startTest("manageAccessCodeBookingsScenario_TC_02");
		acb.clickOnCreatedAccessCodeURL();
		Helper.switchWindow(1);
		allureScreenshot("AccessCodeURLOpen");
		screenShot("AccessCodeURLOpen");
		acb.goToCreatedAccessCodeURL();
		Assert.assertTrue(acb.verifyReservationSuccessful());
		allureScreenshot("ReservationSuccessful");
		screenShot("ReservationSuccessful");
		getDriver().close();
		Helper.switchWindow(0);
//		openBEurlinNewTab2();
		openURL("be_url3");
		
	}

	@Test(priority = 3)
	@Description("Verify that user is able to change the access code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is able to change the access code")
	public void manageAccessCodeBookingsScenario_TC_03() {

		extentTest = extent.startTest("manageAccessCodeBookingsScenario_TC_03");
		acb.AccessCodeRatePlanInBE();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)");
		allureScreenshot("AccessCodeRatePlanbeforeEdit");
		screenShot("AccessCodeRatePlanbeforeEdit");
		Helper.switchWindow(0);
		acb.editCreatedAccessCode();
		Assert.assertTrue(acb.verifyAccessCodeEdited());
		allureScreenshot("AccessCodeNameEdied");
		screenShot("AccessCodeNameEdied");
		Helper.switchWindow(1);
		getDriver().navigate().back();
		acb.EditedAccessCodeRatePlanInBE();
		js.executeScript("window.scrollBy(0,500)"); 
		allureScreenshot("AccessCodeRatePlanAfterEdit");
		screenShot("AccessCodeRatePlanAfterEdit");
		Assert.assertTrue(acb.verifyAccessCodeRatePlan());
		
	}

	@Test(priority = 4)
	@Description("Verify that user is able to delete the access code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is able to change the access code")
	public void manageAccessCodeBookingsScenario_TC_04() {
		
		extentTest = extent.startTest("manageAccessCodeBookingsScenario_TC_04");	
		Helper.switchWindow(0);
		acb.deleteCreatedAccessCodeURL();
		Assert.assertTrue(acb.verifyAccessCodeDeleted());
		allureScreenshot("AccessCodeRatePlanDeleted");
		screenShot("AccessCodeRatePlanAfterDeleted");
		lp.logout();

	}

}

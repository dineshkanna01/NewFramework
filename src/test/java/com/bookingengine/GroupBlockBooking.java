package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatesandInventoryPage;
import com.be.pom.GroupBlockBookingPage;

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

public class GroupBlockBooking extends TestBase{
	
	public static Utilitylog logger;

	LoginPage lp;
	AdministratorHomePage ahp;
	SoftAssert soft;
	GroupBlockBookingPage gbbp;
	RatesandInventoryPage rip;
	
	public GroupBlockBooking() {
		super();
		logger = new Utilitylog(GroupBlockBooking.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		soft = new SoftAssert();
		rip= new RatesandInventoryPage(getDriver());
	    gbbp= new GroupBlockBookingPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user is able to do configuration for Group Block Booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Group Block Booking")
	@Story("Group Block Booking")
	@Step("Configure for Group Block Booking")
	public void GroupBlockBooking_TC_01() throws InterruptedException  {
	    logger.info("TestCase Started");
		extentTest = extent.startTest("GroupBlockBooking_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.clickOnGroupBlockTab();
		ahp.clickOnAddNewGroupBlock();
		gbbp.enterGroupBlockName();
		gbbp.enterGroupBlockCode();
		gbbp.selectRoom();
		gbbp.selectReleaseDate();
		gbbp.selectFirstCheckInDate();
		gbbp.selectLastCheckOutDate();
		gbbp.clickOnSaveButton();
		gbbp.clickOnManageInventory();
		gbbp.clickOnSubmit();
		gbbp.enterRoomAvailable();
		gbbp.clickOnQuickEntry();
		gbbp.clickOnUpdate();
		gbbp.clickOnConfirm();
		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();
		gbbp.inputFields_tc_01();
		ahp.selectRatesandInventory();
		rip.selectRateGrid();
		gbbp.selectDiwaliRatePlan();
		rip.continueButton();
		gbbp.selectDateRange();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		gbbp.enterRate();
		rip.clickQuickEntrybutton();
		allureScreenshot("Rate update");
		screenShot("Rate update");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		
		rip.selectRateGrid();
		gbbp.selectDiwaliRatePlan();
		rip.continueButton();
		gbbp.selectDateRange();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
	    logger.info("TestCase Ended");
	}	
	

	@Test(priority = 2)
	@Description("Verify user is able to Edit  Group Block")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Group Block Booking")
	@Story("Group Block Booking")
	@Step("Edit Group Block Booking")
	public void GroupBlockBooking_TC_02() throws InterruptedException  {
	    logger.info("TestCase Started");
		extentTest = extent.startTest("GroupBlockBooking_TC_02");
	
		ahp.clickOnGroupBlockTab();
		ahp.clickOnListAllGroupBlock();
		gbbp.editGroupBlock();
		gbbp.enterGroupBlockCode1();
		gbbp.clickOnSaveButton();
		soft.assertTrue(gbbp.verifytc02());
		soft.assertAll();
		logger.info("TestCase Ended");
		 lp.logout();
	}	
	
//	@Test(priority = 3)
	@Description("Verify user is able to make reservation with Group Block Booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Group Block Booking")
	@Story("Group Block Booking")
	@Step("Make reservation from Group Block Booking")
	public void GroupBlockBooking_TC_03() throws InterruptedException  {
	    logger.info("TestCase Started");
		extentTest = extent.startTest("GroupBlockBooking_TC_03");
	
		ahp.clickRatePlansTab();
		ahp.clickOnListAllRatePlan();
		gbbp.editRatePlan();
		gbbp.clickOnRT3Url();
		
		
		
		
		logger.info("TestCase Ended");
	}	
	
//	@Test(priority = 4)
	@Description("Verify user is not able to book hotel  except Check-in & Check-out date range")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Group Block Booking")
	@Story("Group Block Booking")
	@Step("Not able to book hotel if select date which not mention in rate plan")
	public void GroupBlockBooking_TC_04() throws InterruptedException  {
	    logger.info("TestCase Started");
		extentTest = extent.startTest("GroupBlockBooking_TC_04");
	
		Helper.switchWindow(0);
		gbbp.clickOnRT3Url();
		
		
		
		
		logger.info("TestCase Ended");
	}	
}

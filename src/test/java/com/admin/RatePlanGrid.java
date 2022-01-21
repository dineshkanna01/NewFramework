package com.admin;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatesandInventoryPage;

import Utility.ExcelData;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class RatePlanGrid extends TestBase{

	ExcelData e = new ExcelData();
	public static Utilitylog logger;

	public RatePlanGrid() {
		super();
		logger = new Utilitylog(RatePlanGrid.class.getName());
	}

	LoginPage lp;
	AdministratorHomePage ahp;
	RatesandInventoryPage rip;

	@BeforeMethod
	public void setup() {

		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rip  = new RatesandInventoryPage(getDriver());

	}

	@Test(priority=1)
	@Description("Verify that the user is able to Update a Rate in Rate Grid for a Rate Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_01() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_01");
		logger.info("Test Case Started");

		lp.login();
		allureScreenshot("Login");


		// Administrator Page

		ahp.selectBrand();// Select the brand

		ahp.selectProperty();// Select the property
		allureScreenshot("Property");

		ahp.selectRatesandInventory();

		// Select Rate Grid

		rip.selectRateGrid();
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		allureScreenshot("RateGrid");
		//Select All room type in Rate plan
		rip.selectALLRoomType();
		//Enter the Rate
		rip.updateRate();

		rip.clickQuickEntrybutton();
		allureScreenshot("RateEntry");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");

		rip.selectRateGrid();
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");

		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		Assert.assertTrue(rip.verifyRate());
		allureScreenshot("VerifyRates");


		logger.info("Test Case Ended");

	}

	@Test(priority=2)
	@Description("Verify the check-uncheck for Rate and inventory Sticky override in Rate Grid")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_02() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_02");
		logger.info("Test Case Started");
		//		lp.login();
		//		allureScreenshot("Login");
		//		//Administrator Page
		//		
		//		ahp.selectBrand();// Select the brand
		//
		//		ahp.selectProperty();// Select the property
		//		allureScreenshot("Property");
		//
		//		ahp.selectRatesandInventory();

		//Select Rate Grid

		rip.selectRateGrid();
		//Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		//Select Date range
		rip.selectDateRange();
		//click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		//Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		//Select All room type in Rate plan
		rip.selectALLRoomType();

		//Select Sticky Override Check for Rate and Inventory 
		rip.stickyCheck();
		rip.clickQuickEntrybutton();
		allureScreenshot("QuickEntry");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");


		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		//Verify Check
		Assert.assertTrue(rip.verifyStickyRates());
		Assert.assertTrue(rip.verifyStickyInventory());
		allureScreenshot("VerifyCheckStickyRate&Inv");

		//Select All room type in Rate plan
		rip.selectALLRoomType();
		//Select Sticky Override Uncheck for Rate and Inventory 
		rip.stickyUncheck();
		rip.clickQuickEntrybutton();
		allureScreenshot("QuickEntry");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");

		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		//Verify Uncheck
		Assert.assertFalse(rip.verifyStickyRates());
		Assert.assertFalse(rip.verifyStickyInventory());
		allureScreenshot("VerifyUnCheckStickyRate&Inv");


		logger.info("Test Case Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is able to update minLOS and maxLOS in rate grid")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_03() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_03");
		logger.info("Test Case Started");
		//		lp.login();
		//		allureScreenshot("Login");
		//
		//		// Administrator Page
		//		ahp.selectBrand();// Select the brand
		//
		//		ahp.selectProperty();// Select the property
		//		allureScreenshot("Property");
		//
		//		ahp.selectRatesandInventory();
		// Select Rate Grid

		rip.selectRateGrid();
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		//Select All room type in Rate plan
		rip.selectALLRoomType();
		// UPdate MIN and MAX LOS
		rip.updateMinMaxLOS();

		rip.clickQuickEntrybutton();
		allureScreenshot("QuickEntry");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");

		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		// Verify MIN and MAX LOS
		Assert.assertTrue(rip.verifyMaxLOS());
		Assert.assertTrue(rip.verifyMinLOS());
		allureScreenshot("Verify MIN and MAX LOS");

		logger.info("Test Case Ended");

	}

	@Test(priority=4)
	@Description("Verify all the selected rate plans are displayed under Rate grid  page.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_04() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_04");
		logger.info("Test Case Started");
		//		lp.login();
		//		allureScreenshot("Login");
		//		
		//		//Administrator Page
		//		
		//		ahp.selectBrand();// Select the brand
		//
		//		ahp.selectProperty();// Select the property
		//		allureScreenshot("Property");
		//
		//		ahp.selectRatesandInventory();

		//Select Rate Grid

		rip.selectRateGrid();
		//Select Rate plan
		rip.selectRatePlan();

		//Select Rate plan2
		rip.selectRatePlan2();
		allureScreenshot("select2RatePlans");
		rip.continueButton();
		//Select Date range
		rip.selectDateRange();
		//click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		//Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		Assert.assertTrue(rip.verifyRatePlan(e.getCellData("RateGrid", "Rateplan1", 2)));
		Assert.assertTrue(rip.verifyRatePlan2(e.getCellData("RateGrid", "Rateplan2", 2)));
		allureScreenshot("VerifyRatePlans");

		logger.info("Test Case Ended");

	}

	@Test(priority = 5)
	@Description("Verify that the user is able to update  Open Yield controls for a Rate plan under Rate grid  page.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_05() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_05");
		logger.info("Test Case Started");
		//		lp.login();
		//		allureScreenshot("Login");
		//
		//		// Administrator Page
		//		
		//		ahp.selectBrand();// Select the brand
		//
		//		ahp.selectProperty();// Select the property
		//		allureScreenshot("Property");
		//
		//		ahp.selectRatesandInventory();

		// Select Rate Grid

		rip.selectRateGrid();
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		rip.openYieldControls();

		rip.clickQuickEntrybutton();
		allureScreenshot("QuickEntry");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");

		// Verify
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		Assert.assertTrue(rip.verifyopenYieldControls());
		allureScreenshot("VerifyopenYieldContorls");


		logger.info("Test Case Ended");
	}

	@Test(priority = 6)
	@Description("Verify that the user is able to update  Close Yield controls for a Rate plan under Rate grid  page.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_06() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_06");
		logger.info("Test Case Started");
		//		lp.login();
		//		allureScreenshot("Login");
		//
		//		// Administrator Page
		//		
		//		ahp.selectBrand();// Select the brand
		//
		//		ahp.selectProperty();// Select the property
		//		allureScreenshot("Property");
		//
		//		ahp.selectRatesandInventory();

		// Select Rate Grid

		rip.selectRateGrid();
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		//Select All room type in Rate plan
		rip.selectALLRoomType();
		rip.closeYieldControls();

		rip.clickQuickEntrybutton();
		allureScreenshot("QuickEntry");
		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");

		// Verify
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		Assert.assertTrue(rip.verifycloseYieldControls());
		allureScreenshot("VerifycloseYieldContorls");


		logger.info("Test Case Ended");

	}

	@Test(priority=7)
	@Description("Verify that the user is able to Update rates for Specific days of week")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Rate Plan Grid")
	@Story("Story: Rate Plan Grid Page")
	@Step("Verify Rate Plan Grid Presence")
	public void rateGrid_TC_07() throws Exception {

		extentTest = extent.startTest("RateGrid_TC_07");
		logger.info("Test Case Started");
		//		lp.login();
		//		allureScreenshot("Login");
		//
		//		// Administrator Page
		//		
		//		ahp.selectBrand();// Select the brand
		//
		//		ahp.selectProperty();// Select the property
		//		allureScreenshot("Property");
		//
		//		ahp.selectRatesandInventory();

		// Select Rate Grid
		rip.selectRateGrid();
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();

		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();
		//Select All room type in Rate plan
		rip.selectALLRoomType();

		rip.updateRateforDaysOfweek();

		rip.clickQuickEntrybutton();
		allureScreenshot("QuickEntry");

		rip.clickUpdatebutton();
		rip.clickConfirmbutton();
		allureScreenshot("confirm");

		// Verify
		// Select Rate plan
		rip.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		// Select Date range
		rip.selectDateRange();
		// click on override Checkbox
		rip.clickoverrideRoomCheckbox();
		// Click on Daily Rate and Inventory Button
		rip.clickdailyRateInvbutton();

		Assert.assertTrue(rip.verifyRate());
		allureScreenshot("VerifyRates");

		lp.logout();
		logger.info("Test Case Ended");


	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}

}

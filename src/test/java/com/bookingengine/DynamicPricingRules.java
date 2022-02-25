package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.DynamicPricingRulesPage;

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
 * Test class for Dynamic Pricing Rule
 * @author Sudhakar Mourya
 */
public class DynamicPricingRules extends TestBase{

	public static Utilitylog logger;

	LoginPage lp;
	AdministratorHomePage ahp;
	com.be.pom.DynamicPricingRulesPage dprp;
	SoftAssert soft;

	public DynamicPricingRules() {
		super();
		logger = new Utilitylog(DynamicPricingRules.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		dprp = new DynamicPricingRulesPage(getDriver());
		soft = new SoftAssert();
	}

	@Test(priority = 1)
	@Description("Verify user is able to add Dynamic Pricing Rules")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Dynamic Pricing Rules")
	@Story("DynamicPricingRules Page")
	@Step("Verify Dynamic Pricing Rules	Added")
	public void dynamicPricingRule_TC_01() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("dynamicPricingRule_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		openURL("be_url4");
		dprp.availabilityCheck();
		dprp.clickOnBooknow();
		soft.assertTrue(dprp.verifyDprNotAddedOnBar());
		allureScreenshot("DPR is not added");
		screenShot("DPR is not added");
		Helper.switchWindow(0);
		ahp.clickOnDynamicPricingRulesTab();
		ahp.clickOnAddNewDPR();
		dprp.enterRuleName(ExcelData.getCellData("DynamicPricingRule", "ruleName",2));
		dprp.enterRuleCode(ExcelData.getCellData("DynamicPricingRule", "ruleCode",2));
		dprp.enterShortDescription(ExcelData.getCellData("DynamicPricingRule", "shortDescription",2));
		dprp.selectDiscountType();
		dprp.clickOnAllNightradioButton();
		dprp.enterPercentage(ExcelData.getCellData("DynamicPricingRule", "percentage",2));
		dprp.clickOnBarCheckbox();
		dprp.clickOnSave();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		allureScreenshot("DPR Added");
		screenShot("DPR Added");
		soft.assertTrue(dprp.verifyDprAddedOnBar());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to edit Dynamic Pricing Rules")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Dynamic Pricing Rules")
	@Story("DynamicPricingRules Page")
	@Step("Verify Dynamic Pricing Rules	edited")
	public void dynamicPricingRule_TC_02() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("dynamicPricingRule_TC_02");
		getDriver().navigate().refresh();
		soft.assertTrue(dprp.verifyExcitingPlanText());
		allureScreenshot("Exciting Plan Text visible");
		screenShot("Exciting Plan Text visible");
		Helper.switchWindow(0);
		dprp.clickOnFirstFewNights();
		Helper.implict(4);
		dprp.clearShortDescription();
		dprp.enterShortDescription(ExcelData.getCellData("DynamicPricingRule", "shortDescription",3));
		dprp.clickOnSave();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		soft.assertTrue(dprp.verifyLatestPlanText());
		allureScreenshot("Latest Plan Text visible");
		screenShot("Latest Plan Text visible");
		logger.info("TestCase Ended");
		Helper.switchWindow(0);
	}

	@Test(priority = 3)
	@Description("Verify user is able to Delete Dynamic Pricing Rules")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Dynamic Pricing Rules")
	@Story("DynamicPricingRules Page")
	@Step("Verify Dynamic Pricing Rules Deleted")
	public void dynamicPricingRule_TC_03() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("dynamicPricingRule_TC_03");
		ahp.clickOnAddNewDPR();
		dprp.enterRuleName(ExcelData.getCellData("DynamicPricingRule", "ruleName",3));
		dprp.enterRuleCode(ExcelData.getCellData("DynamicPricingRule", "ruleCode",3));
		dprp.enterShortDescription(ExcelData.getCellData("DynamicPricingRule", "shortDescription",2));
		dprp.selectDiscountType();
		dprp.clickOnAllNightradioButton();
		dprp.enterPercentage(ExcelData.getCellData("DynamicPricingRule", "percentage",3));
		dprp.clickOnBarCheckbox();
		dprp.clickOnSave();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		soft.assertTrue(dprp.verifyDprAddedOnBar());
		allureScreenshot("DPR is showing");
		screenShot("DPR is showing");
		Helper.switchWindow(0);
		dprp.clickOnDelete();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		soft.assertTrue(dprp.verifyDprNotAddedOnBar());
		allureScreenshot("DPR is Deleted");
		screenShot("DPR is Deleted");
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is able to add Dynamic Pricing Rules for Day of week")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Dynamic Pricing Rules")
	@Story("DynamicPricingRules Page")
	@Step("Verify Dynamic Pricing Rules	added for days of week")
	public void dynamicPricingRule_TC_04() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("dynamicPricingRule_TC_04");
		Helper.switchWindow(0);
		ahp.clickOnAddNewDPR();
		dprp.enterRuleName(ExcelData.getCellData("DynamicPricingRule", "ruleName",4));
		dprp.enterRuleCode(ExcelData.getCellData("DynamicPricingRule", "ruleCode",4));
		dprp.enterShortDescription(ExcelData.getCellData("DynamicPricingRule", "shortDescription",2));
		dprp.selectDiscountType();
		dprp.selectDayofWeek();
		dprp.clickOnBarCheckbox();
		dprp.clickOnSave();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		soft.assertTrue(dprp.verifyDprAddedOnBar());
		logger.info("TestCase Ended");
		Helper.switchWindow(0);
		dprp.clickOnDelete();
	}

	@Test(priority = 5)
	@Description("Verify user is not able to add Dynamic Pricing Rules if the dpr with same code already exists")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Dynamic Pricing Rules")
	@Story("DynamicPricingRules Page")
	@Step("Verify Dynamic Pricing Rules	should not added with existing dpr code")
	public void dynamicPricingRule_TC_05() throws InterruptedException {

		logger.info("TestCase Started");
		extentTest = extent.startTest("dynamicPricingRule_TC_05");
		ahp.clickOnAddNewDPR();
		dprp.enterRuleName(ExcelData.getCellData("DynamicPricingRule", "ruleName",5));
		dprp.enterRuleCode(ExcelData.getCellData("DynamicPricingRule", "ruleCode",2));
		dprp.enterShortDescription(ExcelData.getCellData("DynamicPricingRule", "shortDescription",2));
		dprp.selectDiscountType();
		dprp.clickOnAllNightradioButton();
		dprp.enterPercentage(ExcelData.getCellData("DynamicPricingRule", "percentage",2));
		dprp.clickOnBarCheckbox();
		dprp.clickOnSave();
		soft.assertTrue(dprp.verifyExistingCodeErrorMsg());
		allureScreenshot("Existing code error msg page");
		screenShot("Existing code error msg page");
		logger.info("TestCase Ended");
		dprp.clickOnListAllDpr();
		dprp.clickOnDelete();
		lp.logout();
	}

}

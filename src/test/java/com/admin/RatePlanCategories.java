package com.admin;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatePlanCategoriesPage;

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
 * Test class for Rate plan categories
 * @author Rudraksh Aggarwal
 */
public class RatePlanCategories extends TestBase{
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatePlanCategoriesPage rcp;

	public RatePlanCategories() {
		super();
		logger = new Utilitylog(RatePlanCategories.class.getName());
	}

	@BeforeMethod
	public void setup()  {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rcp = new RatePlanCategoriesPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to enable the rate plan categories")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan Categories")
	@Story("RatePlan Categories Page")
	@Step("Verify user is able to enable rate plan categories ")
	public void RatePlanCategories_TC_01()  {

		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlanCategories_TC_01");
		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickRatePlansTab();
		ahp.clickRatePlanCategories();

		allureScreenshot("Rate Plan Categories Page");
		screenShot("Rate Plan Categories Page");

		rcp.selectRadioButton();
		rcp.clickOnSave();

		allureScreenshot("Add New Category Option");
		screenShot("Add New Category Option");

		Assert.assertTrue(rcp.verifyAddNewCategory());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify that the user is able to add and delete single rate plan category")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan Categories")
	@Story("RatePlan Categories Page")
	@Step("Verify user is able to add and single Delete rate plan category")
	public void RatePlanCategories_TC_02()  {
		extentTest = extent.startTest("RatePlanCategories_TC_02");
		logger.info("TestCase Started");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickRatePlansTab();
		 * 
		 * ahp.clickRatePlanCategories();
		 */

		rcp.inputfields_tc02();
		rcp.clickOnSave();

		allureScreenshot("Category Created");
		screenShot("Category Created");

		Assert.assertTrue(rcp.verifyName());

		rcp.deleteCategory();
		Assert.assertTrue(rcp.verifyMessage());

		allureScreenshot("Category Deleted");
		screenShot("Category Deleted");
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is able to add and delete Multiple rate plan categories")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan Categories")
	@Story("RatePlan Categories Page")
	@Step("Verify user is able to add and multiple Delete rate plan categories")
	public void RatePlanCategories_TC_03()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlanCategories_TC_03");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickRatePlansTab(); ahp.clickRatePlanCategories();
		 */

		rcp.inputfields_tc02();
		rcp.clickOnSave();

		allureScreenshot("Category Created");
		screenShot("Category Created");

		Assert.assertTrue(rcp.verifyName());
		rcp.inputfields_tc03();
		rcp.clickOnSave();

		allureScreenshot("Category Created");
		screenShot("Category Created");

		Assert.assertTrue(rcp.verifyName_tc03());

		rcp.deleteCategory();

		allureScreenshot("Category Deleted");
		screenShot("Category Deleted");

		rcp.deleteCategory();

		allureScreenshot("Category Deleted");
		screenShot("Category Deleted");

		Assert.assertTrue(rcp.verifyMessage());

		rcp.selectRadioButtonNo();
		rcp.clickOnSave();
		Assert.assertFalse(rcp.verifyAddNewCategory());

		lp.logout();
		logger.info("TestCase Ended");
	}

	@AfterSuite
	public void report()  {
		try {
			mail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmdPrompt();
	}
}

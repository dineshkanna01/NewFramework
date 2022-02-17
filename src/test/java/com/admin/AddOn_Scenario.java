package com.admin;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AddOnsPage;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;

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
 * Test Class for Add On Scenario
 * @author Rudraksh Aggarwal
 */
public class AddOn_Scenario extends TestBase {
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	AddOnsPage aop;

	public AddOn_Scenario() {
		super();
		logger = new Utilitylog(AddOn_Scenario.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		aop = new AddOnsPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to Create an Add On")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:AddOn")
	@Story("AddOns Page")
	@Step("Verify user is able to Create Add On")
	public void AddOn_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOn_TC_01");
		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickAddOnsTab();
		ahp.clickAddNewAddOnsTab();

		aop.inputTextFieldsAddOnsTc01();
		aop.clickOnSave();

		allureScreenshot("AddOn created");
		screenShot("AddOn created");

		Assert.assertTrue(aop.verifyAddOnName());

		aop.clickOnCheckbox();
		aop.clickOnDelete();
		aop.clickOnYes();

		Assert.assertTrue(aop.verifyAddOnName_Delete());

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify that the user is able to Create and Delete a different Add On")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:AddOn")
	@Story("AddOns Page")
	@Step("Verify user is able to Create and Delete Add On")
	public void AddOn_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOn_TC_02");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickAddOnsTab();
		 */
		ahp.clickAddNewAddOnsTab();

		aop.inputTextFieldsAddOnsTc02();
		aop.clickOnSave();

		allureScreenshot("AddOn created");
		screenShot("AddOn created");

		Assert.assertTrue(aop.verifyAddOnName());

		aop.clickOnCheckbox();
		aop.clickOnDelete();
		aop.clickOnYes();

		allureScreenshot("AddOn Deleted");
		screenShot("AddOn Deleted");

		Assert.assertTrue(aop.verifyAddOnName_Delete());

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is not able to create an Add On with same code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:AddOn")
	@Story("AddOns Page")
	@Step("Verify user is able not able to Create Addon with same code")
	public void AddOn_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOn_TC_03");

		/*
		 * lp.login();
		 * 
		 * allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickAddOnsTab();
		 */

		ahp.clickAddNewAddOnsTab();

		aop.inputTextFieldsAddOnsTc03();
		aop.clickOnSave();

		allureScreenshot("AddOn created");
		screenShot("AddOn created");

		ahp.clickAddNewAddOnsTab();
		aop.inputTextFieldsAddOnsTc03();
		aop.clickOnSave();

		allureScreenshot("Duplicate code error message");
		screenShot("Duplicate code error message");

		Assert.assertTrue(aop.verifyDuplicate_tc03());

		aop.clickOnCancel();

		aop.clickOnCheckbox();
		aop.clickOnDelete();
		aop.clickOnYes();

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

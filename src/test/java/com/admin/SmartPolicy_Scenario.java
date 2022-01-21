package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.SmartPoliciesPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class SmartPolicy_Scenario extends TestBase{


	public static Utilitylog logger;

	public SmartPolicy_Scenario() {
		super();
		logger = new Utilitylog(SmartPolicy_Scenario.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	SmartPoliciesPage spp;

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		spp = new SmartPoliciesPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to Add Smart Policy")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:SmartPolcies")
	@Story("Smart Policies Page")
	@Step("Verify user is able to add smart policy")
	public void SmartPolicy_TC_01() throws Exception {
		logger.info("TestCase Started");
		extentTest = extent.startTest("SmartPolicy_TC_01");

		lp.login();
		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickSmartPoliciesTab();
		ahp.clickAddNewSmartPolicies();

		allureScreenshot("Smart Policies Page");
		screenShot("Smart Policies Page");

		spp.inputTextFieldsSmartPoliciesTc01();
		spp.selectCategoryFromDropdown();
		spp.clickOnSave();

		allureScreenshot("Smart Policies Created");
		screenShot("Smart Policies Created");

		Assert.assertTrue(spp.verifySmartPolicyName_tc01());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify that the user is able to Add or Delete Smart Policy")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:SmartPolcies")
	@Story("Smart Policies Page")
	@Step("Verify user is able to Add or Delete Smart Policy")
	public void SmartPolicy_TC_02() throws Exception {
		logger.info("TestCase Started");
		extentTest = extent.startTest("SmartPolicy_TC_02");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * ahp.clickSmartPoliciesTab();
		 */

		ahp.clickAddNewSmartPolicies();

		allureScreenshot("Smart Policies Page");
		screenShot("Smart Policies Page");

		spp.inputTextFieldsSmartPoliciesTc02();
		spp.selectCategoryFromDropdown();
		spp.clickOnSave();

		allureScreenshot("Smart Policies Created");
		screenShot("Smart Policies Created");

		Assert.assertTrue(spp.verifySmartPolicyName_tc02());

		spp.deleteSmartPolicies();

		allureScreenshot("Smart Policies Deleted");
		screenShot("Smart Policies Deleted");

		Assert.assertFalse(spp.verifySmartPolicyName_tc02());
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is not able to Add Smart Policy with same name")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:SmartPolcies")
	@Story("Smart Policies Page")
	@Step("Verify user is not able to add smart policy having same name")
	public void SmartPolicy_TC_03() throws Exception {
		logger.info("TestCase Started");
		extentTest = extent.startTest("SmartPolicy_TC_03");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickSmartPoliciesTab();
		 */
		
		ahp.clickAddNewSmartPolicies();

		allureScreenshot("Smart Policies Page");
		screenShot("Smart Policies Page");

		spp.inputTextFieldsSmartPoliciesTc03();
		spp.selectCategoryFromDropdown();
		spp.clickOnSave();

		allureScreenshot("Smart Policies Created");
		screenShot("Smart Policies Created");

		Assert.assertTrue(spp.verifySmartPolicyName_tc03());

		ahp.clickAddNewSmartPolicies();
		spp.inputTextFieldsSmartPoliciesTc03();
		spp.selectCategoryFromDropdown();
		spp.clickOnSave();

		Assert.assertTrue(spp.verifyDuplicateErrorMessage_tc03());

		allureScreenshot("Duplicate Policy error message");
		screenShot("Duplicate Policy error message");

		spp.clickOnCancel();
		spp.deleteSmartPolicies();

		lp.logout();
		logger.info("TestCase Ended");
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}

}

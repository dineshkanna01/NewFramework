package com.admin;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.BrandPage;
import com.admin.pom.LoginPage;
import com.admin.pom.NewPropertyPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class PropertyCreationTestCases extends TestBase{

	public static Utilitylog logger;
	public PropertyCreationTestCases() {
		super();
		logger = new Utilitylog(PropertyCreationTestCases.class.getName());
	}

	@BeforeMethod
	public void setup() {
		initilization();
	}
	
	@Test(priority = 1)
	@Description("Verify that the user is able to create a new property")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: New Property")
	@Story("Story: Property Created")
	@Step("Verify New Property Created")
	public void Admin_AddNewPropertyScenario_TC_01() throws Throwable {
		LoginPage lp = new LoginPage(getDriver());
		extentTest = extent.startTest("Admin_AddNewPropertyScenario_TC_01");
		lp.clearButton();
		lp.username();
		lp.password();
		lp.loginButton();
//		lp.twoFactorAuthentication();
		allureScreenshot("Logged In");
		BrandPage bp = new BrandPage(getDriver());
		bp.openBrands();
		allureScreenshot("Brands Open");
		bp.brandSelect();
		NewPropertyPage npp = new NewPropertyPage(getDriver());
		npp.newPropertyEditPage();
		allureScreenshot("Property Edit Page Filled");
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		npp.propertyDefaultPage();
		allureScreenshot("Property Default Page Filled");
		String defaultSave = npp.verifyDefaultSaveButton();
		Assert.assertEquals(defaultSave, "  Save  ");
		npp.propertyDefaultPageSaveButton();
		npp.propertyMasterPage();
		allureScreenshot("Property Master Page Filled");
		String masterSave = npp.verifyMasterSaveButton();
		Assert.assertEquals(masterSave, "Save");
		npp.masterSaveButton();
		String administratorText = npp.verifyAdministratorTextAfterSave();
		Assert.assertEquals(administratorText, "Administrator Home");
		allureScreenshot("Property Created Administrator page Displayed");
		lp.logout();
	}
	
	@Test(priority = 2)
	@Description("Verify user should not be able to add a new Property due to the non uniqueness of property code.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Duplicate Property")
	@Story("Story: Property Not Created")
	@Step("Verify Duplicate Property Created")
	public void Admin_AddNewPropertyScenario_TC_02() throws Throwable {
		LoginPage lp = new LoginPage(getDriver());
		extentTest = extent.startTest("Admin_AddNewPropertyScenario_TC_02");
		lp.clearButton();
		lp.username();
		lp.password();
		lp.loginButton();
//		lp.twoFactorAuthentication();
		allureScreenshot("Logged In");
		BrandPage bp = new BrandPage(getDriver());
		bp.openBrands();
		allureScreenshot("Brands Open");
		bp.brandSelect();
		NewPropertyPage npp = new NewPropertyPage(getDriver());
		npp.newPropertyEditPage();
		allureScreenshot("Property Edit Page Filled");
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		String duplicatePropCode = npp.verifyDuplicatePropert();
		Assert.assertEquals(duplicatePropCode, "Duplicate property code.");
		lp.logout();
	}
	
//	@AfterMethod
	public void browerClose() throws InterruptedException {
		getDriver().quit();
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}

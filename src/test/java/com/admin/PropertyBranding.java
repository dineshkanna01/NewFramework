package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.BrandPage;
import com.admin.pom.LoginPage;
import com.admin.pom.NewPropertyPage;
import com.admin.pom.PropertyBrandingPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class PropertyBranding extends TestBase{


	public static Utilitylog logger;
	public PropertyBranding() {
		super();
		logger = new Utilitylog(PropertyBranding.class.getName());
	}

//	@BeforeMethod
//	public void setup() {
//		initilization();
//	}
	
	@Test(priority = 1)
	@Description("Verify user should be able to manage Property Branding")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Branding Property")
	@Story("Story: Property Branding Created")
	@Step("Verify New Property Branding Created")
	public void Admin_PropertyBrandingScenario_TC_01() throws Exception {
		LoginPage lp = new LoginPage(getDriver());
		extentTest = extent.startTest("Admin_PropertyBrandingScenario_TC_01");
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
		PropertyBrandingPage pbp = new PropertyBrandingPage(getDriver());
		pbp.selectProperty();
		pbp.propertyBrandConfig();
		allureScreenshot("Property Branding Page Filled");
		String saveButton = pbp.verifySaveButton();
		Assert.assertEquals(saveButton, "Save");
		pbp.saveButton();
		allureScreenshot("Administrator Home After Save");
		NewPropertyPage npp = new NewPropertyPage(getDriver());
		String administratorText = npp.verifyAdministratorTextAfterSave();
		Assert.assertEquals(administratorText, "Administrator Home");
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

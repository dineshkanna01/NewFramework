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

/*
* Test class for Property branding configuration
* @Author : UzairAsar
*/
public class PropertyBranding extends TestBase{
	
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	
	public PropertyBranding() {
		super();
		logger = new Utilitylog(PropertyBranding.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		pbp = new PropertyBrandingPage(getDriver());
		bp = new BrandPage(getDriver());
	}
	
	@Test(priority = 1)
	@Description("Verify user should be able to manage Property Branding")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Branding Property")
	@Story("Story: Property Branding Created")
	@Step("Verify New Property Branding Created")
	public void Admin_PropertyBrandingScenario_TC_01(){
		extentTest = extent.startTest("Admin_PropertyBrandingScenario_TC_01");
		lp.login();
		allureScreenshot("Logged In");
		screenShot("Logged In");
		bp.openBrands();
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		bp.brandSelect();
		pbp.selectProperty();
		pbp.propertyBrandConfig();
		allureScreenshot("Property Branding Page Filled");
		screenShot("Property Branding Page Filled");
		String saveButton = pbp.verifySaveButton();
		Assert.assertEquals(saveButton, "Save");
		pbp.saveButton();
		allureScreenshot("Administrator Home After Save");
		screenShot("Administrator Home After Save");
		NewPropertyPage npp = new NewPropertyPage(getDriver());
		String administratorText = npp.verifyAdministratorTextAfterSave();
		Assert.assertEquals(administratorText, "Administrator Home");
		lp.logout();
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}

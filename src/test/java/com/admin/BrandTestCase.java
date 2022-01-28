package com.admin;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.BrandPage;
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
* Test class for Brand creation
* @Author : UzairAsar
*/
public class BrandTestCase extends TestBase{
	
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;

	public BrandTestCase() {
		super();
		logger = new Utilitylog(BrandTestCase.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		bp = new BrandPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to create a new brand in the CRS system")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: New Brand")
	@Story("Story: Create New Brand")
	@Step("Verify New Brand Created")
	public void Admin_AddNewBrand_TC_01(){
		extentTest = extent.startTest("Admin_AddNewBrand_TC_01");
		
		lp.clearButton();
		lp.username();
		lp.password();
		lp.loginButton();
//		lp.twoFactorAuthentication();
		
		allureScreenshot("Logged In");
		screenShot("Logged In");
		
		bp.openBrands();
		bp.createNewBrand();
		
		allureScreenshot("Administrator Home After Save");
		screenShot("Administrator Home After Save");
		
		assertTrue(bp.verifyBrandCreated());
	}
	
	@Test(priority = 2)
	@Description("Verify User should not be able to add a Brand in CRS Admin due to duplicate brand name.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: New Brand")
	@Story("Story: Cannot create New Brand")
	@Step("Verify New Brand not Created")
	public void Admin_AddNewBrand_TC_02(){
		extentTest = extent.startTest("Admin_AddNewBrand_TC_02");
		
		allureScreenshot("Brands open");
		screenShot("Brands open");
		
		bp.duplicateBrand();
		
		allureScreenshot("Duplicate Brand Name Error");
		screenShot("Duplicate Brand Name Error");
		
		String dupError = bp.verifyDuplicateBrand();
		System.out.println(dupError);
		Assert.assertEquals(dupError, "Brand Name already used.");
		
		bp.cancelButton();
	}
	
	@Test(priority = 3)
	@Description("Verify user should not be able to add a Brand in CRS Admin due to passing blank space in brand name")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: New Brand")
	@Story("Story: Cannot create New Brand due to blank brand name")
	@Step("Verify New Brand not Created")
	public void Admin_AddNewBrand_TC_03(){
		extentTest = extent.startTest("Admin_AddNewBrand_TC_03");
		
		allureScreenshot("Brands open");
		screenShot("Brands open");
		
		bp.blankBrandName();
		
		allureScreenshot("Blank Brand Name Error");
		screenShot("Blank Brand Name Error");
		
		String blankField = bp.verifyBlankBrandName();
		System.out.println(blankField);
		Assert.assertEquals(blankField, "Brand Name is required.");
		
		lp.logout();
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}

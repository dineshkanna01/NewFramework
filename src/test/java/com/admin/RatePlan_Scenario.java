package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AddOnsPage;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatePlanCategoriesPage;
import com.admin.pom.RatePlanPage;

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

/*
 * Test class for Rate plan
 * @author Rudraksh Aggarwal
 */
public class RatePlan_Scenario extends TestBase{
	ExcelData e = new ExcelData();
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatePlanPage rpp;
	AddOnsPage aop;
	RatePlanCategoriesPage rcp;

	public RatePlan_Scenario() {
		super();
		logger = new Utilitylog(RatePlanCategories.class.getName());
	}

	@BeforeMethod
	public void setup() {

		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rpp = new RatePlanPage(getDriver());
		aop = new AddOnsPage(getDriver());
		rcp = new RatePlanCategoriesPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify that the user is able to create and delete a fixed rate plan ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify user is able to create and delete fixed rate plan")
	public void RatePlan_TC_01()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_01");

		lp.login();
		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.inputFields_tc01();
		rpp.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());
		Assert.assertTrue(rpp.verifyRateAssociation());

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify that the user is able to create and delete a Floating rate plan ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify user is able to create and delete Floating rate plan")
	public void RatePlan_TC_02()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_02");

//		
//		 lp.login(); allureScreenshot("Login"); screenShot("Login");
//		  
//		  ahp.selectBrand(); ahp.selectProperty();
//		  
//		  allureScreenshot("Property Selected"); screenShot("Property Selected");
//		  
//		 ahp.clickRatePlansTab();

		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.selectRoomType();
		rpp.inputFields_tc02();
		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());
		Assert.assertFalse(rpp.verifyRateAssociation());

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

//		 lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is able to create and delete a rate plan having an Add-On ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify user is able to create and delete rate plan having add on")
	public void RatePlan_TC_03()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_03");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 */

		ahp.clickAddOnsTab();
		ahp.clickAddNewAddOnsTab();
		aop.inputTextFieldsAddOnsRatePlan();
		aop.clickOnSave();

		allureScreenshot("AddOn created");
		screenShot("AddOn created");

		Assert.assertTrue(aop.verifyAddOnName());

		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.inputFields_tc01();
		rpp.selectRoomType();
		rpp.deriveRatesNo();

		rpp.attachAddOns();

		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());
		Assert.assertTrue(rpp.verifyRateAssociation());

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

		ahp.clickAddOnsTab();
		ahp.clickListAllAddOn();

		aop.clickOnCheckbox();
		aop.clickOnDelete();
		aop.clickOnYes();

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify the Attach Add-ons button is visible or not for different Rate Type Classifications.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify the Attach Add-ons button is visible or not for different Rate Type Classifications.")
	public void RatePlan_TC_04()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_04");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 */

		ahp.clickRatePlansTab();

		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.verifyAddOnbuttonforDiffClassifications();

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify the user is able to add a Rate Plan to a Rate Plan Category")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify the user is able to add Rate Plan to Rate Plan Category")
	public void RatePlan_TC_05()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_05");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickRatePlansTab();
		 */

		ahp.clickRatePlanCategories();
		rcp.selectRadioButton();
		rcp.clickOnSave();
		Assert.assertTrue(rcp.verifyAddNewCategory());

		rcp.inputfields_tc02();
		rcp.clickOnSave();

		Assert.assertTrue(rcp.verifyName());

		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.inputFields_tc05();
		rpp.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();

		Assert.assertEquals(rpp.verifyTc05(), e.getCellData("RatePlanPageData", "Name_TC01", 2));

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		ahp.clickRatePlanCategories();
		rcp.deleteCategory();
		rcp.selectRadioButtonNo();
		rcp.clickOnSave();

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("Verify the user is not able to create a rate plan if there is no room in the selected property")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify the user is not able to create rate plan if there is no room in selected property")
	public void RatePlan_TC_06()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_06");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 */
		rpp.propertyNoRoom();

		ahp.clickRatePlansTab();

		ahp.clickAddNewRatePlansTab();

		Assert.assertTrue(rpp.verifyApplicationError());

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 7)
	@Description("Verify the user is not able to create a rate plan with Duplicate Rate Code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify the user is not able to create rate plan with Duplicate Rate Code")
	public void RatePlan_TC_07()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_07");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickRatePlansTab();
		 */
		rpp.clickOnCross();
		ahp.selectProperty();
		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.inputFields_tc01();
		rpp.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());

		ahp.clickAddNewRatePlansTab();
		rpp.inputFields_tc01();
		rpp.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();

		allureScreenshot("Duplicate error message");
		screenShot("Duplicate error message");

		Assert.assertTrue(rpp.verifyDuplicateError());

		rpp.clickOnCancel();
		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

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

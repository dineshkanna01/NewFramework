package com.admin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.TaxesAndFeesPage;

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

public class TaxesAndFees extends TestBase {

	public static Utilitylog logger;
	ExcelData e = new ExcelData();

	public TaxesAndFees() {
		super();
		logger = new Utilitylog(TaxesAndFees.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	TaxesAndFeesPage tf;

	@BeforeMethod
	public void setup() {
		
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		tf = new TaxesAndFeesPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user is able to add taxe ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxe")
	public void aboutPropertyTaxCreationScenario_TC_01() throws Exception {

		extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_01");
		lp.clearButton();
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.selectPropertyManagement();

		tf.clickTaxesAndFees();
		tf.clickaddNewTaxtoProperty();
		tf.addtax();
		tf.clickSave();
		allureScreenshot("taxCreated");
		screenShot("TaxCreated");
		tf.verifyTaxCreated();
		Assert.assertTrue(tf.verifyTaxCreated());

	}

//	 @Test(priority=2)
	@Description("Verify user is able to add taxes and then edit the name ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxes and then edit the name ")
	public void aboutPropertyRoomCreationScenario_TC_02() throws Exception { //// Getting Error

		
		tf.clickTaxesAndFees();
		tf.clickaddNewTaxtoProperty();
		tf.updateTheTaxName();
		tf.clickSave();
		allureScreenshot("taxCreated");
		screenShot("TaxCreated");
		Assert.assertTrue(tf.verifyCreatedTaxForEdit());
		Assert.assertTrue(tf.verifyTaxEdited());

		tf.editTheCreatedTax();
		tf.clickSave();
		allureScreenshot("taxEdited");
		screenShot("taxEdited");
		Assert.assertFalse(tf.verifyTaxEdited());

	}

//	 @Test(priority=3)
	@Description("Verify user is able to update tax amount")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxes for charge type percent")
	public void aboutPropertyTaxCreationScenario_TC_03() throws Exception {
		
		extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_03");
		Assert.assertFalse(tf.verifyExistedTaxAmountEdited());
		tf.updateTaxAmount();
		tf.clickSave();
		allureScreenshot("TaxUpdated");
		screenShot("TaxUpdated");
		Assert.assertTrue(tf.verifyExistedTaxAmountEdited());     

	}

//	 @Test(priority=4)
	@Description("Verify user is able delete tax amount for already existing tax .")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxes for charge type percent")
	public void aboutPropertyTaxCreationScenario_TC_04() throws Exception {

		 extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_04");
		tf.clickDeleteTax();
		allureScreenshot("TaxDeleted");
		screenShot("TaxDeleted");
		Assert.assertTrue(tf.verifyDeletedTax());

	}
}

package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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

/*
* Test class for  Tax Scenario
* @author Ankita mohamanasingh
*/
public class TaxScenario extends TestBase {
	
	public static Utilitylog logger;
	ExcelData e = new ExcelData();

	public TaxScenario() {
		super();
		logger = new Utilitylog(TaxScenario.class.getName());
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
	@Description("Verify user is able to add tax ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxe")
	public void aboutPropertyTaxCreationScenario_TC_01()  {

		extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_01");
		lp.clickClearButton();
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
		Assert.assertTrue(tf.verifyTaxCreated());

	}

	 @Test(priority=2)
	@Description("Verify user is able to add taxes and then edit the name ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxes and then edit the name ")
	public void aboutPropertyRoomCreationScenario_TC_02()  { 
		
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

	 @Test(priority=3)
	@Description("Verify user is able to update tax amount")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxes for charge type percent")
	public void aboutPropertyTaxCreationScenario_TC_03()  {
		extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_03");
		Assert.assertFalse(tf.verifyExistedTaxAmountEdited());
		tf.updateTaxAmount();
		tf.clickSave();
		allureScreenshot("TaxUpdated");
		screenShot("TaxUpdated");
		Assert.assertTrue(tf.verifyExistedTaxAmountEdited());     
      }

	@Test(priority=4)
	@Description("Verify user is able delete tax amount for already existing tax .")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Taxes Scenario ")
	@Story("About the property tax creation scenario")
	@Step("Verify user is able to add taxes for charge type percent")
	public void aboutPropertyTaxCreationScenario_TC_04()  {
		 extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_04");
		tf.clickDeleteTax();
		allureScreenshot("TaxDeleted");
		screenShot("TaxDeleted");
		tf.clickOnOKDelete();
		Assert.assertTrue(tf.verifyDeletedTax());
	}

	 @Test(priority=5)
		@Description("Verify user is able to edit Charge frequency")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:Taxes Scenario ")
		@Story("About the property tax creation scenario")
		@Step("Verify user is able to add taxes for charge type percent")
		public void aboutPropertyTaxCreationScenario_TC_05()  {
			extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_05");
			tf.clickaddNewTaxtoProperty();
			tf.addTaxToEditChargeFrequency();
			tf.clickSave();
			allureScreenshot("taxCreated");
			screenShot("TaxCreated");
			Assert.assertTrue(tf.verifyCreatedTaxForEditChargeFreqency());
			Assert.assertFalse(tf.verifyTaxFrquencyEdited());

			tf.changeChargeFreqency();
			tf.clickSave();
			allureScreenshot("TaxFrequencyUpdated");
			screenShot("TaxFrequencyUpdated");
			Assert.assertTrue(tf.verifyTaxFrquencyEdited());     
	      }
	 
	 @Test(priority=6)
		@Description("Verify user is able to update charge basis for existed Tax")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:Taxes Scenario ")
		@Story("About the property tax creation scenario")
		@Step("Verify user is able to update charge basis for existed Tax")
		public void aboutPropertyTaxCreationScenario_TC_06()  {
			extentTest = extent.startTest("aboutPropertyTaxCreationScenario_TC_06");
			Assert.assertFalse(tf.verifyTaxBasisEdited());
			tf.changeChargeBasis();
			tf.clickSave();
			allureScreenshot("TaxUpdated");
			screenShot("TaxUpdated");
			Assert.assertTrue(tf.verifyTaxBasisEdited());     
	      }
	 @Test(priority = 31)
		public void deleteAllCreatedAboutTheProperty() throws InterruptedException {
		tf.deleteAllTax();
			
			
	 }
		@AfterSuite
		public void report() throws Exception {

			mail();

			cmdPrompt();
		}

}

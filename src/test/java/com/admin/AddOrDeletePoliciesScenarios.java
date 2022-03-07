package com.admin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.PoliciesPage;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;
public class AddOrDeletePoliciesScenarios extends TestBase{
	
	public static Utilitylog logger;
	
	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	PoliciesPage pp;
	
	public AddOrDeletePoliciesScenarios() {
		super();
		logger = new Utilitylog(AddOrDeletePoliciesScenarios.class.getName());
	}
	
	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		pp = new PoliciesPage(getDriver());
	}
	
	@Test(priority = 1)
	@Description("Verify that the user is able to Add or Delete Policy for Credit Card Guarantee")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is able to add or Delete policy")
	public void AddOrDeletePolicies_TC_01()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOrDeletePolicies_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.clickPoliciesTab();
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPoliciesTc01();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyName_tc01());
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyName_tc01());
		// lp.logout();
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 2)
	@Description("Verify that the user is able to Add or Delete Policy for Direct Bill")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is able to add or Delete policy")
	public void AddOrDeletePolicies_TC_02()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOrDeletePolicies_TC_02");
		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickPoliciesTab();
		 */
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPoliciesTc02();
		pp.selectGuarenteeDropdown_Tc02();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyName_tc02());
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyName_tc02());
		// lp.logout();
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 3)
	@Description("Verify that the user is able to Add or Delete Policy for Pre Payment/Deposit fixed amount")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is able to add or Delete policy")
	public void AddOrDeletePolicies_TC_03()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOrDeletePolicies_TC_03");
		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickPoliciesTab();
		 */
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPolicies();
		pp.selectGuarenteeDropdown_Tc03();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyName());
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyName());
		// lp.logout();
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 4)
	@Description("Verify that the user is able to Add or Delete Policy for Number of Nights")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is able to add or Delete policy")
	public void AddOrDeletePolicies_TC_04()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOrDeletePolicies_TC_04");
		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickPoliciesTab();
		 */
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPolicies();
		pp.selectGuarenteeDropdown_Tc04();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyName());
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyName());
//		lp.logout();
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 5)
	@Description("Verify that the user is able to Add or Delete Policy for Percentage of Amount")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is able to add or Delete policy")
	public void AddOrDeletePolicies_TC_05()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOrDeletePolicies_TC_05");
		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickPoliciesTab();
		 */
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPolicies();
		pp.selectGuarenteeDropdown_Tc05();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyName());
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyName());
//		lp.logout();
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 6)
	@Description("Verify that the user is able to Add or Delete Policy for Non Guarentee")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is able to add or Delete policy")
	public void addOrDeletePolicies_TC_06()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("addOrDeletePolicies_TC_06");
		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickPoliciesTab();
		 */
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPoliciesTc06();
		pp.selectGuarenteeDropdown_Tc06();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyNameTc06());
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyNameTc06());
//		lp.logout();
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 7)
	@Description("Verify that the user is not able to Add Policy having same code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Polcies")
	@Story("Policies Page")
	@Step("Verify user is not able to add policy having same code")
	public void AddOrDeletePolicies_TC_07()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("AddOrDeletePolicies_TC_07");
		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickPoliciesTab();
		 */
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPoliciesTc01();
		pp.clickAddNewCancellationWindow();
		allureScreenshot("Cancellation Window Page");
		screenShot("Cancellation Window Page");
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		allureScreenshot("Policy Created");
		screenShot("Policy Created");
		Assert.assertTrue(pp.verifyPolicyName_tc01());
		ahp.clickAddNewPolicy();
		pp.inputTextFieldsPoliciesTc07();
		pp.clickAddNewCancellationWindow();
		pp.inputAddNewCancellationWindow();
		pp.clickSave();
		Assert.assertTrue(pp.verifyDuplicateErrorMessage_tc07());
		allureScreenshot("Duplicate Policy error message");
		screenShot("Duplicate Policy error message");
		pp.clickOnCancel();
		pp.deletePolicies();
		allureScreenshot("Policy Deleted");
		screenShot("Policy Deleted");
		Assert.assertFalse(pp.verifyPolicyName_tc01());
		lp.logout();
		logger.info("TestCase Ended");
	}
}

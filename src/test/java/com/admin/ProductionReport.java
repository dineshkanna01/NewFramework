package com.admin;

import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;

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

public class ProductionReport extends TestBase{

	ExcelData e = new ExcelData();
	public static Utilitylog logger;

	public ProductionReport() {
		super();
		logger = new Utilitylog(ProductionReport.class.getName());
	}

	LoginPage lp;
	AdministratorHomePage ahp;
	ReportsPage rep;
	
	@BeforeMethod
	public void setup() {
	
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rep = new ReportsPage(getDriver());
	}
	
	@Test(priority=1)
	@Description("Verify the user is able to view Production Report for Room Type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Production Report")
	@Story("Story: Production Report Page")
	@Step("Verify Production Report Presence")
	public void productionReport_TC_01() throws Exception {
		
      extentTest = extent.startTest("ProductionReport_TC_01");
      logger.info("Test Case Started");
		lp.login();

		allureScreenshot("Login");
		// Administrator Page
		
		ahp.selectBrand();// Select the brand

		ahp.selectProperty();// Select the property
		allureScreenshot("Property");

		ahp.selectReports();

		rep.selectProductionReport();
		
		rep.selectDateRange();
		
		//Select room type
		rep.selectRoomtype();
		allureScreenshot("Room Type slected");
		
		//View Report
		rep.viewReport();
		
		Assert.assertTrue(rep.verifyReportisvisible());
		allureScreenshot("Production_report");
//		Assert.assertTrue(rep.verifyRoomType());

//		lp.logout();
		logger.info("Test Case Ended");
			
	}
	
	@Test(priority=2)
	@Description("Verify the user is able to view Production Report for Rate Type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Production Report")
	@Story("Story: Production Report Page")
	@Step("Verify Production Report Presence")
	public void productionReport_TC_02() throws Exception {
		
		extentTest = extent.startTest("ProductionReport_TC_02");
		logger.info("Test Case Started");
//		lp.login();

//		allureScreenshot("Login");
		// Administrator Page
		
//		ahp.selectBrand();// Select the brand

//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");

//		ahp.selectReports();

		rep.selectProductionReport();
		
		rep.selectDateRange();
		
		//Select room type
		rep.selectRatetype();
		allureScreenshot("RateType selected");
		
		//View Report
		rep.viewReport();
		
		Assert.assertTrue(rep.verifyReportisvisible());
		allureScreenshot("Production_report");
//		Assert.assertTrue(rep.verifyRateType());
		

//		lp.logout();
		logger.info("Test Case Ended");
		
	}
	
	@Test(priority=3)
	@Description("Verify that the user is able to view Production Report for Rate Classification")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Production Report")
	@Story("Story: Production Report Page")
	@Step("Verify Production Report Presence")
	public void productionReport_TC_03() throws Exception {
		
		extentTest = extent.startTest("ProductionReport_TC_03");
		logger.info("Test Case Started");
//		lp.login();
//
//		allureScreenshot("Login");
//		// Administrator Page
//		
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();

		rep.selectProductionReport();
		
		rep.selectDateRange();
		
		//Select room type
		rep.selectRateClassification();
		allureScreenshot("RateClassification");
		
		//View Report
		rep.viewReport();
		
		Assert.assertTrue(rep.verifyReportisvisible());
		allureScreenshot("Production_report");
//		Assert.assertTrue(rep.verifyRateClassification());
		

		logger.info("Test Case Ended");
			
	}
	
	@Test(priority=4)
	@Description("Verify that the user is able to view and download Production Report in excel format")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Production Report")
	@Story("Story: Production Report Page")
	@Step("Verify Production Report Presence")
	public void productionReport_TC_04() throws Exception {
		
      extentTest = extent.startTest("ProductionReport_TC_01");
      logger.info("Test Case Started");
//		lp.login();
//
//		allureScreenshot("Login");
//		// Administrator Page
//		
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();

		rep.selectProductionReport();
		
		rep.selectDateRange();
		
		//Select room type
		rep.selectRoomtype();
		allureScreenshot("Room Type slected");
		
		//View Report
		rep.viewReport();
		
		Assert.assertTrue(rep.verifyReportisvisible());
		allureScreenshot("Production_report");


		rep.excelButton();
//		Assert.assertTrue(rep.downloadProductionReports());
		
		
		logger.info("Test Case Ended");
			
	}
	

	@Test(priority=5)
	@Description("Verify that the user is able to view and download Production Report in pdf format")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Production Report")
	@Story("Story: Production Report Page")
	@Step("Verify Production Report Presence")
	public void productionReport_TC_05() throws Exception {
		
      extentTest = extent.startTest("ProductionReport_TC_01");
      logger.info("Test Case Started");
//		lp.login();
//
//		allureScreenshot("Login");
//		// Administrator Page
//		
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();

		rep.selectProductionReport();
		
		rep.selectDateRange();
		
		//Select room type
		rep.selectRoomtype();
		allureScreenshot("Room Type slected");
		
		//View Report
		rep.viewReport();
		
		Assert.assertTrue(rep.verifyReportisvisible());
		allureScreenshot("Production_report");


		rep.pdfButton();
//		Assert.assertTrue(rep.downloadProductionReports());
		
		

		lp.logout();
		logger.info("Test Case Ended");
			
	}
	


	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
	
	
}

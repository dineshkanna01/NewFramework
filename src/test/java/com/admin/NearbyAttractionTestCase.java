package com.admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.NearbyAttractionPage;

import Utility.ExcelData;
import base.TestBase;

public class NearbyAttractionTestCase extends TestBase {

	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	NearbyAttractionPage nap;
	SoftAssert soft;

	public NearbyAttractionTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		lp=new LoginPage(getDriver());	
		ahp=new AdministratorHomePage(getDriver());
		nap=new NearbyAttractionPage(getDriver());
		soft= new SoftAssert();
	}

	@Test
	public void nearbyAttraction_TC_01() throws Exception {
		extentTest = extent.startTest("nearbyAttraction_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickPropertyManagementTab();
		ahp.clickNearbyAttractionTab();
		nap.clickAddNew();
		nap.enterNearbyAttractionName(e.getCellData("Sheet1","attractionName",2));
		nap.enterCategory1();
		nap.enterDescription();
		nap.selectCountry("India");
		nap.enterAddress();
		nap.enterZipcode();
		nap.clickFindLat();
		nap.clickSave();
		String actText=nap.nearbyAttraction();
		String expText=e.getCellData("Sheet1","attractionName",2);
		soft.assertEquals(actText, expText,"Actual is match with expected");
		soft.assertAll();
	}

	@Test
	public void nearbyAttraction_TC_02() throws Exception {
		extentTest = extent.startTest("nearbyAttraction_TC_02");
		nap.clickAddNew();
		nap.enterNearbyAttractionName(e.getCellData("Sheet1","attractionName",3));
		nap.enterCategory1();
		nap.enterDescription();
		nap.selectCountry("India");
		nap.enterAddress();
		nap.enterZipcode();
		nap.clickFindLat();
		nap.clickSave();
		nap.clickEdit();
		nap.clearCategory();
		nap.enterCategory2();
		nap.clickSave();
		String actText=nap.nearbyCategory();
		String expText=e.getCellData("Sheet1","Category",3);
		soft.assertEquals(actText, expText,"Actual is match with expexted");
		soft.assertAll();
	}

	@Test
	public void nearbyAttraction_TC_03() throws Exception {
		extentTest = extent.startTest("nearbyAttraction_TC_03");
		nap.clickAddNew();
		nap.enterNearbyAttractionName(e.getCellData("Sheet1","attractionName",4));
		nap.enterCategory1();
		nap.enterDescription();
		nap.selectCountry("India");
		nap.enterAddress();
		nap.enterZipcode();
		nap.clickFindLat();
		nap.clickSave();
		nap.clickLastCheckbox();
		nap.clickDelete();
		nap.clickYes();
	    soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",4)));
	    soft.assertAll();
	}
	
	@Test
	public void nearbyAttraction_TC_04() throws Exception {
		extentTest = extent.startTest("nearbyAttraction_TC_04");
		nap.clickAddNew();
		nap.enterNearbyAttractionName(e.getCellData("Sheet1","attractionName",5));
		nap.enterCategory1();
		nap.enterDescription();
		nap.selectCountry("India");
		nap.enterAddress();
		nap.enterZipcode();
		nap.clickFindLat();
		nap.clickSave();

		nap.clickAddNew();
		nap.enterNearbyAttractionName(e.getCellData("Sheet1","attractionName",6));
		nap.enterCategory1();
		nap.enterDescription();
		nap.selectCountry("India");
		nap.enterAddress();
		nap.enterZipcode();
		nap.clickFindLat();
		nap.clickSave();
		nap.clickCheckbox3();
		nap.clickCheckbox4();
		nap.clickDelete();
		nap.clickYes();
	    soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",5)));
	    soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",6)));
	    soft.assertAll();
	    lp.logout();
	  }

	
    @AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
    
}

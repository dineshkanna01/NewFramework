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

/*
 * Test class for Nearby Attraction Page
 * @author Sudhakar Mourya
 */
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

	/*
	 * Method for nearby attraction TC01
	 */
	@Test
	public void nearbyAttraction_TC_01(){
		extentTest = extent.startTest("nearbyAttraction_TC_01");
		try {
			lp.login();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		allureScreenshot("Added Nearby Attraction");
		String actText=nap.nearbyAttraction();
		String expText=e.getCellData("Sheet1","attractionName",2);
		soft.assertEquals(actText, expText,"Actual is match with expected");
		soft.assertAll();
	}

	/*
	 * Method for nearby attraction TC02
	 */
	@Test
	public void nearbyAttraction_TC_02(){
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
		allureScreenshot("Added Nearby Attraction");
		nap.clickEdit();
		nap.clearCategory();
		nap.enterCategory2();
		nap.clickSave();
		allureScreenshot("Edited Nearby Attraction");
		String actText=nap.nearbyCategory();
		String expText=e.getCellData("Sheet1","Category",3);
		soft.assertEquals(actText, expText,"Actual is match with expexted");
		soft.assertAll();
	}

	/*
	 * Method for nearby attraction TC03
	 */
	@Test
	public void nearbyAttraction_TC_03(){
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
		allureScreenshot("Deleted single Nearby Attraction");
	    soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",4)));
	    soft.assertAll();
	}
	
	/*
	 * Method for nearby attraction TC04
	 */
	@Test
	public void nearbyAttraction_TC_04(){
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
		nap.clickCheckbox1();
		nap.clickCheckbox2();
		nap.clickCheckbox3();
		nap.clickCheckbox4();
		nap.clickDelete();
		nap.clickYes();
		allureScreenshot("Deleted Multiple Nearby Attraction");
		soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",2)));
		soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",3)));
	    soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",5)));
	    soft.assertTrue(nap.checkNearByAttractionDeleted(e.getCellData("Sheet1","attractionName",6)));
	    soft.assertAll();
		lp.logout();
	  }

	
    @AfterSuite
	public void report(){
		try {
			mail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmdPrompt();
	}
}

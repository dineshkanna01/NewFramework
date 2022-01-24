package com.admin;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.AmenitiesForSpecificRoomPage;
import com.admin.pom.LoginPage;

import Utility.ExcelData;
import base.TestBase;

public class AmenitiesForSpecificRoomTest extends TestBase {

	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	AmenitiesForSpecificRoomPage asr;
	SoftAssert soft;
	
	public AmenitiesForSpecificRoomTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
	    lp=new LoginPage(getDriver());	
		ahp=new AdministratorHomePage(getDriver());
		asr=new AmenitiesForSpecificRoomPage(getDriver());
		soft= new SoftAssert();
	}
	
	    @Test
		public void amenitiesForSpecificRoom_TC_01() throws Exception {
	    	extentTest = extent.startTest("amenitiesForSpecificRoom_TC_01");
			lp.login();
			ahp.selectBrand();
			ahp.selectProperty();
			ahp.clickPropertyManagementTab();	
			ahp.clickOnAmenities();
			asr.clickOnAddAmenities();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",2));
			asr.selectPropertyAmenities();
			asr.clickOnSave();
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC01());
			soft.assertAll();	
		}
	
		@Test
		public void amenitiesForSpecificRoom_TC_02() throws Exception {
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_02");
			asr.clickOnAddAmenities();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",3));
			asr.selectCommonRoomAmenities();
			asr.clickOnSave();
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC02());
			soft.assertAll();	
		}
		
		@Test
		public void amenitiesForSpecificRoom_TC_03() throws Exception {
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_03");
			asr.clickOnAddAmenities();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",4));
			asr.selectRoomSpecificAmenities();
			asr.clickOnSave();
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC03());
			soft.assertAll();	
		}
	
		 @Test
		public void amenitiesForSpecificRoom_TC_04() throws Exception {
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_04");
			asr.clickOnEdit();
			asr.clearAmenitiesName();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",5));
			asr.selectCommonRoomAmenities();
			asr.clickOnSave();
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC04());
			soft.assertAll();	
		}
	
		 @Test
		 public void amenitiesForSpecificRoom_TC_05() throws Exception {
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_05");
			asr.clickOnDelete();
		    soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC05(e.getCellData("Sheet1","amenitiesName",5)));
		    soft.assertAll();	
		    lp.logout();	
		}
	
    @AfterSuite
    public void report() throws Exception {
	mail();
	cmdPrompt();
    }
}

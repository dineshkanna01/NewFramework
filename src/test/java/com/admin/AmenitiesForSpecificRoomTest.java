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

/*
 * Test class for Amenities For Specific Room
 * @author Sudhakar Mourya
 */
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
	
	 /*
	  * Method for amenities for specific room TC01
	  */
	    @Test
		public void amenitiesForSpecificRoom_TC_01(){
	    	extentTest = extent.startTest("amenitiesForSpecificRoom_TC_01");
			try {
				lp.login();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ahp.selectBrand();
			ahp.selectProperty();
			ahp.clickPropertyManagementTab();	
			ahp.clickOnAmenities();
			asr.clickOnAddAmenities();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",2));
			asr.selectPropertyAmenities();
			asr.clickOnSave();
			allureScreenshot("Added, Property Amenity");
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC01());
			soft.assertAll();	
		}
	
	    /*
		 * Method for amenities for specific room TC02
		 */
		@Test
		public void amenitiesForSpecificRoom_TC_02(){
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_02");
			asr.clickOnAddAmenities();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",3));
			asr.selectCommonRoomAmenities();
			asr.clickOnSave();
			allureScreenshot("Added, Common to all room amenities");
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC02());
			soft.assertAll();	
		}
		
		/*
		 * Method for amenities for specific room TC03
		 */
		@Test
		public void amenitiesForSpecificRoom_TC_03(){
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_03");
			asr.clickOnAddAmenities();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",4));
			asr.selectRoomSpecificAmenities();
			asr.clickOnSave();
			allureScreenshot("Added, Specific to some room amenities");
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC03());
			soft.assertAll();	
		}
	
		/*
		 * Method for amenities for specific room TC04
		 */
		 @Test
		public void amenitiesForSpecificRoom_TC_04(){
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_04");
			asr.clickOnEdit();
			asr.clearAmenitiesName();
			asr.enterAmenitiesName(e.getCellData("Sheet1","amenitiesName",5));
			asr.selectCommonRoomAmenities();
			asr.clickOnSave();
			allureScreenshot("Deleted,Specific to some room only amenities");
			soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC04());
			soft.assertAll();	
		}
	
		 /*
		  * Method for amenities for specific room TC05
		  */
		 @Test
		 public void amenitiesForSpecificRoom_TC_05(){
			extentTest = extent.startTest("amenitiesForSpecificRoom_TC_05");
			asr.deleteCommonRoomAmenity();
			allureScreenshot("Edited,Specific to some room only amenities");
		    soft.assertTrue(asr.verifyAmentitiesForSpecificRoom_TC05(e.getCellData("Sheet1","amenitiesName",5)));
		    soft.assertAll();	
		    asr.deleteAmenity();
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

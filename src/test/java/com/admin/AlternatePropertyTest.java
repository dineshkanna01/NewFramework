package com.admin;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.AlternatePropertiesPage;
import com.admin.pom.LoginPage;

import Utility.ExcelData;
import base.TestBase;

/*
 * Test class for Alternate Properties
 * @author Sudhakar Mourya
 */
public class AlternatePropertyTest extends TestBase {
	
	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	AlternatePropertiesPage app;
	SoftAssert soft;
	
	public AlternatePropertyTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		lp=new LoginPage(getDriver());	
		ahp=new AdministratorHomePage(getDriver());
		app=new AlternatePropertiesPage(getDriver());
		soft= new SoftAssert();
	}
	
	 /*
	  * Method for alternate property TC01
	  */
	@Test
	public void alternateProperty_TC_01(){
		extentTest = extent.startTest("alternateProperty_TC_01");
		try {
			lp.login();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickPropertyManagementTab();
		ahp.clickAlternatePropertyTab();
		app.clickAddProperty();
		app.enterPropertyCode1();
		app.clickSaveButton();
		allureScreenshot("Added alternate property");
		String actText=app.propertyName();
		String expText=e.getCellData("Sheet1","PropCode",10);
		soft.assertEquals(actText, expText,"Actual is not match with expexted");
		soft.assertAll();
	}

	 /*
	  * Method for alternate property TC02
	  */
	@Test
	public void alternateProperty_TC_02(){
		extentTest = extent.startTest("alternateProperty_TC_02");
		app.clickAddProperty();
		app.enterPropertyCode2();
		app.clickSaveButton();
		app.clickLastCheckBox();
		app.clickDeleteButton();
		allureScreenshot("Deleted single alternate property");
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",2)));
		soft.assertAll();
	}

	 /*
	  * Method for alternate property TC03
	  */
	@Test()
	public void alternateProperty_TC_03(){
		extentTest = extent.startTest("alternateProperty_TC_03");
		app.addMultipleProp();
		app.clickMultipleCheckBox();
		app.clickDeleteButton();
		allureScreenshot("Deleted multiple alternate property");
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",2)));
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",3)));
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",4)));
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",5)));
		soft.assertAll();
	}

	 /*
	  * Method for alternate property TC04
	  */
	@Test
	public void alternateProperty_TC_04(){
		extentTest = extent.startTest("alternateProperty_TC_04");
		app.clickAddProperty();
		app.enterInvalidPropertyCode();
		app.clickSaveButton();
		allureScreenshot("Invalid property code error msg");
		String actErrorMsg=app.invalidPropCode();
		String expErrorMsg = e.getCellData("Sheet1","InvalidPropErrorMsg",2);
		soft.assertEquals(actErrorMsg, expErrorMsg,"Actual msg is not match with expected");
		soft.assertAll();
		//app.deleteFirstProperty();
			lp.logout();
	}

}

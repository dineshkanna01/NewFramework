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
	@Test
	public void alternateProperty_TC_01() throws Exception {
		extentTest = extent.startTest("alternateProperty_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickPropertyManagementTab();
		ahp.clickAlternatePropertyTab();
		app.clickAddProperty();
		app.enterPropertyCode1();
		app.clickSaveButton();
		String actText=app.propertyName();
		String expText=e.getCellData("Sheet1","PropCode",10);
		soft.assertEquals(actText, expText,"Actual is not match with expexted");
		soft.assertAll();
	}

	@Test
	public void alternateProperty_TC_02() throws Exception {
		extentTest = extent.startTest("alternateProperty_TC_02");
		app.clickAddProperty();
		app.enterPropertyCode2();
		app.clickSaveButton();
		app.clickLastCheckBox();
		app.clickDeleteButton();
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",2)));
		soft.assertAll();
	}

	@Test()
	public void alternateProperty_TC_03() throws Exception {
		extentTest = extent.startTest("alternateProperty_TC_03");
		app.addMultipleProp();
		app.clickMultipleCheckBox();
		app.clickDeleteButton();
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",3)));
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",4)));
		soft.assertTrue(app.checkPropertyDeleted(e.getCellData("Sheet1","HotelName",5)));
		soft.assertAll();
	}

	@Test
	public void alternateProperty_TC_04() throws Exception {
		extentTest = extent.startTest("alternateProperty_TC_04");
		app.clickAddProperty();
		app.enterInvalidPropertyCode();
		app.clickSaveButton();
		String actErrorMsg=app.invalidPropCode();
		String expErrorMsg = e.getCellData("Sheet1","InvalidPropErrorMsg",2);
		soft.assertEquals(actErrorMsg, expErrorMsg,"Actual msg is not match with expected");
		soft.assertAll();
		lp.logout();
	}

    @AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
    
}

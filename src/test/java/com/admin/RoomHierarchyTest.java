package com.admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RoomHierarchyPage;

import Utility.ExcelData;
import base.TestBase;

public class RoomHierarchyTest extends TestBase {

	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	RoomHierarchyPage rhp;
	SoftAssert soft;

	public RoomHierarchyTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rhp = new RoomHierarchyPage(getDriver());
		soft = new SoftAssert();
	}

	@Test
	public void roomHierarchy_TC_01() throws Exception {
		extentTest = extent.startTest("roomHierarchy_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickOnRoomTab();
		ahp.clickOnRoomHierarchy();
		rhp.selectBaseroom();
		rhp.clearStartDate();
		rhp.enterStarDate1();
		rhp.clearEndDate();
		rhp.enterEndDate1();
		rhp.clickOnSave();
		String actText=rhp.administratorname();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Room Hierarchy has updated");
		soft.assertAll();
	}

	@Test
	public void roomHierarchy_TC_02() throws Exception {
		extentTest = extent.startTest("roomHierarchy_TC_02");
		ahp.clickOnRoomHierarchy();
		rhp.selectBaseroom();
		rhp.clearStartDate();
		rhp.enterStarDate1();
		rhp.clearEndDate();
		rhp.enterEndDate1();
		rhp.clickOnSave();
		ahp.clickOnRoomHierarchy();
		rhp.clearStartDate();
		rhp.enterStarDate2();
		rhp.clearEndDate();
		rhp.enterEndDate2();
		rhp.clickOnSave();
		String actText=rhp.administratorname();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Room Hierarchy has updated");
		soft.assertAll();
	}

	@Test
	public void roomHierarchy_TC_03() throws Exception {
		extentTest = extent.startTest("roomHierarchy_TC_03");
		ahp.clickOnRoomHierarchy();
		rhp.selectBaseroom();
		rhp.clearStartDate();
		rhp.clearEndDate();
		rhp.clickOnSave();
		String actText=rhp.roomHierarchyError();
		String expText=e.getCellData("Sheet1","roomHierarchyErrorMsg",2);
		soft.assertEquals(actText, expText,"Room Hierarchy has not updated, TC is pass");
		soft.assertAll();
		lp.logout();
	}

	@AfterSuite
	public void report() throws Exception {
	mail();
	cmdPrompt();

	}
	
}

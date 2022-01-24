package com.admin;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.CallCenterSettingsPage;
import com.admin.pom.LoginPage;

import Utility.ExcelData;
import base.TestBase;

public class CallCenterSettingsTest extends TestBase {

	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	CallCenterSettingsPage ccsp;
	SoftAssert soft;

	public CallCenterSettingsTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		lp=new LoginPage(getDriver());	
		ahp=new AdministratorHomePage(getDriver());
		ccsp=new CallCenterSettingsPage(getDriver());
		soft= new SoftAssert();
	}
				
	@Test
	public void callCenterSettings_TC_01() throws Exception {
		extentTest = extent.startTest("callCenterSettings_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickPropertyManagementTab();
		ahp.callCenterSettings();
		ccsp.clearAnnouncementMsg();
		ccsp.enterAnnouncementMsg();
		ccsp.clickOnActivateAnnouncement();
		ccsp.clickOnSave();
		String actText=ccsp.administratorName();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Call center enable");
		soft.assertAll();
       }

	@Test
	public void callCenterSettings_TC_02() throws Exception {
		extentTest = extent.startTest("callCenterSettings_TC_02");
		ahp.callCenterSettings();
		ccsp.clearAnnouncementMsg();
		ccsp.enterAnnouncementMsg();
		ccsp.clickOnDeactivateAnnouncement();
		ccsp.clickOnSave();
		String actText=ccsp.administratorName();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Call center disable");
		soft.assertAll();
		lp.logout();
     }
	
	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}	
	
}

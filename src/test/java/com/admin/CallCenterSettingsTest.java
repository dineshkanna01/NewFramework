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

/*
 * Test class for Call Center Settings
 * @author Sudhakar Mourya
 */
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
	
	/*
	 * Method for call center settings TC01
	 */
	@Test
	public void callCenterSettings_TC_01(){
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
		allureScreenshot("Enable call center setting");
		String actText=ccsp.administratorName();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Call center enable");
		soft.assertAll();
       }

	/*
	 * Method for call center settings TC02
	 */
	@Test
	public void callCenterSettings_TC_02(){
		extentTest = extent.startTest("callCenterSettings_TC_02");
		ahp.callCenterSettings();
		ccsp.clearAnnouncementMsg();
		ccsp.enterAnnouncementMsg();
		ccsp.clickOnDeactivateAnnouncement();
		ccsp.clickOnSave();
		allureScreenshot("Disable call center setting");
		String actText=ccsp.administratorName();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Call center disable");
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

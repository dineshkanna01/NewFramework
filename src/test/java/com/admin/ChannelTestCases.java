package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.PropertyBrandingPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

/*
* Test class for Channel creation
* @Author : UzairAsar
*/
public class ChannelTestCases extends TestBase{
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	
	public ChannelTestCases() {
		super();
		logger = new Utilitylog(ChannelTestCases.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		pbp = new PropertyBrandingPage(getDriver());
		cp = new ChannelPage(getDriver());
		bp = new BrandPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that the user is able to add GDS Channel")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: New  GDS Added")
	@Story("Story: GDS Channel Created and Deleted")
	@Step("Verify GDS Channel Created")
	public void Admin_Channel_TC_01(){
		extentTest = extent.startTest("Admin_Channel_TC_01");
		
		lp.clearButton();
		lp.username();
		lp.password();
		lp.loginButton();
//		lp.twoFactorAuthentication();
		
		allureScreenshot("Logged In");
		screenShot("Logged In");
		
		bp.openBrands();
		
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		
		bp.brandSelect();
		pbp.selectProperty();
		cp.openPropertyTab();
		cp.openChannels();
		
		allureScreenshot("Channel Open");
		screenShot("Channel Open");
		
		cp.selectingChannel();
		cp.addGDS();
		
		String submitButton = cp.verifySaveButton();
		Assert.assertEquals(submitButton, "Submit");
		
		cp.saveButton();
		
		allureScreenshot("GDS Page");
		screenShot("GDS Page");
		
		cp.openChannels();
		
		String GDSChannelVerify = cp.verifyGDSChannel();
		Assert.assertEquals(GDSChannelVerify, "GDS");
		
		allureScreenshot("GDS Created");
		screenShot("GDS Created");
		
		cp.deleteChannelSelected();
		
		String DeleteButton = cp.verifyDeleteButton();
		Assert.assertEquals(DeleteButton, "Delete");
		
		cp.deleteButton();
		cp.alertPopUp();
	}

	@Test(priority = 2)
	@Description("Verify that the user is able to add PMS Channel")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: New  PMS Added")
	@Story("Story: PMS Channel Created and Deleted")
	@Step("Verify PMS Channel Created")
	public void Admin_Channel_TC_02(){
		extentTest = extent.startTest("Admin_Channel_TC_02");
		
		cp.openPropertyTab();
		cp.openChannels();
		
		allureScreenshot("Channel Open");
		screenShot("Channel Open");
		
		cp.selectingChannel();
		cp.addPMS();
		cp.URI();
		cp.retryInterval();
		cp.maxRetryCount();
		
		String submitButton = cp.verifySaveButton();
		Assert.assertEquals(submitButton, "Submit");
		
		cp.saveButton();
		
		allureScreenshot("PMS Page");
		screenShot("PMS Page");
		
		cp.openPropertyTab();
		cp.openChannels();
		
		String PMSChannelVerify = cp.verifyPMSChannel();
		Assert.assertEquals(PMSChannelVerify, "PMS");
		
		allureScreenshot("PMS Created");
		screenShot("PMS Created");
		
		cp.deleteChannelSelected();
		
		String DeleteButton = cp.verifyDeleteButton();
		Assert.assertEquals(DeleteButton, "Delete");
		
		cp.deleteButton();
		cp.alertPopUp();
	}

	@Test(priority = 3)
	@Description("Verify user should not be able to add PMS Channels due to URI blank field")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: New PMS not Added")
	@Story("Story: PMS Channel not Created")
	@Step("Verify PMS Channel not Created due to blank URI")
	public void Admin_Channel_TC_03() {
		extentTest = extent.startTest("Admin_Channel_TC_03");
		
		cp.openPropertyTab();
		cp.openChannels();
		
		allureScreenshot("Channel Open");
		screenShot("Channel Open");
		
		cp.selectingChannel();
		cp.addPMS();
		cp.retryInterval();
		cp.maxRetryCount();
		
		String submitButton = cp.verifySaveButton();
		Assert.assertEquals(submitButton, "Submit");
		
		cp.saveButton();
		
		allureScreenshot("Error URI Blank");
		screenShot("Error URI Blank");
		
		String URIText = cp.verifyURIBlankText();
		Assert.assertEquals(URIText, "Request URI is required");
	}
	
	@Test(priority = 4)
	@Description("Verify user should not be able to add PMS Channels due to blank retry interval value.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: New PMS not Added")
	@Story("Story: PMS Channel not Created")
	@Step("Verify PMS Channel not Created due to blank Retry Interva")
	public void Admin_Channel_TC_04(){
		extentTest = extent.startTest("Admin_Channel_TC_04");
		
		cp.openPropertyTab();
		cp.openChannels();
		
		allureScreenshot("Channel Open");
		screenShot("Channel Open");
		
		cp.selectingChannel();
		cp.addPMS();
		cp.URI();
		cp.maxRetryCount();
		
		String submitButton = cp.verifySaveButton();
		Assert.assertEquals(submitButton, "Submit");
		
		cp.saveButton();
		
		allureScreenshot("Error Retry Interval Blank");
		screenShot("Error Retry Interval Blank");
		
		String RetryIntervalText = cp.verifyRetryIntervalBlankText();
		Assert.assertEquals(RetryIntervalText, "Retry interval is either not given, too big, or not a number. Enter a number that is not higher than 2,147,483,646. Use 0 for no retry interval.");		
	}
	
	@Test(priority = 5)
	@Description("Verify user should not be able to add PMS Channels due to blank retry interval value.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: New PMS not Added")
	@Story("Story: PMS Channel not Created")
	@Step("Verify PMS Channel not Created due to blank Retry Interva")
	public void Admin_Channel_TC_05(){
		extentTest = extent.startTest("Admin_Channel_TC_05");
		
		cp.openPropertyTab();
		cp.openChannels();
		
		allureScreenshot("Channel Open");
		screenShot("Channel Open");
		
		cp.selectingChannel();
		cp.addPMS();
		cp.URI();
		cp.retryInterval();
		
		String submitButton = cp.verifySaveButton();
		Assert.assertEquals(submitButton, "Submit");
		
		cp.saveButton();
		
		allureScreenshot("Error Max Retry Count Blank");
		screenShot("Error Max Retry Count Blank");
		
		String MaxRetryCountText = cp.verifyMaxRetryCountBlankText();
		Assert.assertEquals(MaxRetryCountText, "Max retry count is either not given, too big, or not a number. Enter a number that is not higher than 255. Use 0 for no max retry count.");
		
		lp.logout();
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}

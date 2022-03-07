package com.bookingengine;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.HouseControlRestrictionsPage;
import com.be.pom.JCCBookingsPage;
import Utility.ExcelData;
import base.Helper;
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
 * Test class for HouseControlRestrictions
 * @author Rudraksh Aggarwal
 */
public class HouseControlRestrictions extends TestBase {
	
	public static Utilitylog logger;
	
	// objects
	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	JCCBookingsPage jbp;
	HouseControlRestrictionsPage hrp;
	public HouseControlRestrictions() {
		super();
		logger = new Utilitylog(JCCBookings.class.getName());
	}
	
	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		hrp = new HouseControlRestrictionsPage(getDriver());
	}
	
	@Test(priority = 1)
	@Description("User should be able to create House Restrictions Open Min Stay Through")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:House Restrictions")
	@Story("House Restrictionss")
	@Step("User should be able to create House Restrictions Open Min Stay Through")
	public void HouseControlRestrictions_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("HouseControlRestrictions_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.selectRatesandInventory();
		ahp.selectHouseInventoryRestrictions();
		allureScreenshot("House Control Restrictions Page");
		screenShot("House Control Restrictions Page");
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.inputFieldTC01();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		allureScreenshot("House Control Restrictions confirm");
		screenShot("House Control Restrictions confirm");
		openURL("be_url1");
		allureScreenshot("Booking Engine");
		screenShot("Booking Engine");
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("House Control Restrictions min stay through booking engine");
		screenShot("House Control Restrictions min stay through booking engine");
		Assert.assertTrue(hrp.verificationStayThrough());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 2)
	@Description("User should be able to create House Restrictions Open Max Stay Through")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:House Restrictions")
	@Story("House Restrictionss")
	@Step("User should be able to create House Restrictions Open Max Stay Through")
	public void HouseControlRestrictions_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("HouseControlRestrictions_TC_02");
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.inputFieldTC02();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		allureScreenshot("House Control Restrictions confirm");
		screenShot("House Control Restrictions confirm");
		Helper.switchWindow(1);
		Helper.refreshBE();
		hrp.selectDateTC02();
		jbp.clickAvailibilityButton();
		allureScreenshot("House Control Restrictions max stay through booking engine");
		screenShot("House Control Restrictions max stay through booking engine");
		Assert.assertTrue(hrp.verificationStayThrough());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 3)
	@Description("User should be able to create House Restrictions Closed")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:House Restrictions")
	@Story("House Restrictionss")
	@Step("User should be able to create House Restrictions Closed")
	public void HouseControlRestrictions_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("HouseControlRestrictions_TC_03");
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		allureScreenshot("House Control Restrictions confirm");
		screenShot("House Control Restrictions confirm");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now Visible");
		screenShot("Book Now Visible");
		Assert.assertTrue(hrp.verification_BookNowVisible());
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.closeYieldControls();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now not Visible");
		screenShot("Book Now not Visible");
		Assert.assertFalse(hrp.verification_BookNowNotVisible());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 4)
	@Description("User should be able to create House Restrictions Open Closed to Arrival")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:House Restrictions")
	@Story("House Restrictionss")
	@Step("User should be able to create House Restrictions Open Closed to Arrival")
	public void HouseControlRestrictions_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("HouseControlRestrictions_TC_04");
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		allureScreenshot("House Control Restrictions confirm");
		screenShot("House Control Restrictions confirm");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now Visible");
		screenShot("Book Now Visible");
		Assert.assertTrue(hrp.verification_BookNowVisible());
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.selectCloseToArrival();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now not Visible");
		screenShot("Book Now not Visible");
		Assert.assertFalse(hrp.verification_BookNowNotVisible());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 5)
	@Description("User should be able to remove and add availability")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:House Restrictions")
	@Story("House Restrictionss")
	@Step("User should be able to remove and add availability")
	public void HouseControlRestrictions_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("HouseControlRestrictions_TC_05");
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.inputFieldRoomAvailable("0");
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		allureScreenshot("House Control Restrictions confirm");
		screenShot("House Control Restrictions confirm");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now not Visible");
		screenShot("Book Now not Visible");
		Assert.assertFalse(hrp.verification_BookNowNotVisible());
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.openYieldControls();
		hrp.inputFieldRoomAvailable("100");
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now Visible");
		screenShot("Book Now Visible");
		Assert.assertTrue(hrp.verification_BookNowVisible());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 6)
	@Description("User should be able to create House Control Restriction Days of Week Closed")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:House Restrictions")
	@Story("House Restrictionss")
	@Step("User should be able to create House Control Restriction Days of Week Closed")
	public void HouseControlRestrictions_TC_06() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("HouseControlRestrictions_TC_06");
		Helper.switchWindow(0);
		hrp.selectDateRange();
		hrp.clickSubmitButton();
		hrp.closeYieldControls();
		hrp.selectDayofWeek();
		hrp.clearAllMinLOS();
		hrp.clearAllMaxLOS();
		hrp.clickQuickEntrybutton();
		hrp.clickUpdateButton();
		hrp.clickConfirmButton();
		allureScreenshot("House Control Restrictions confirm");
		screenShot("House Control Restrictions confirm");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now not Visible");
		screenShot("Book Now not Visible");
		Assert.assertFalse(hrp.verification_BookNowNotVisible());
		Helper.refreshBE();
		hrp.selectDateTC06();
		jbp.clickAvailibilityButton();
		allureScreenshot("Book Now Visible");
		screenShot("Book Now Visible");
		Assert.assertTrue(hrp.verification_BookNowVisible());
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}
}
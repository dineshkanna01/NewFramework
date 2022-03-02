package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.CalendarViewBookingsPage;
import com.be.pom.IBE_Config_StandardFlowPage;
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
 * Test class for IBE_Config_Standard Flow 
 * @author Sudhakar Mourya
 */
public class IBE_Config_StandardFlow extends TestBase{

	public static Utilitylog logger;

	LoginPage lp;
	AdministratorHomePage ahp;
	CalendarViewBookingsPage cvbp;
	SoftAssert soft;
	IBE_Config_StandardFlowPage icsp;
	public IBE_Config_StandardFlow() {
		super();
		logger = new Utilitylog(IBE_Config_StandardFlow.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cvbp=new CalendarViewBookingsPage(getDriver());
		icsp=new IBE_Config_StandardFlowPage(getDriver());
		soft = new SoftAssert();
	}

	@Test(priority = 1)
	@Description("User should be able to select Standard flow in IBE config")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("IBE Config_StandardFlow")
	@Story("IBE Config_StandardFlow")
	@Step("select standard flow in IBE Config")
	public void IBE_Config_StandardFlow_TC_01()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("IBE_Config_StandardFlow_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		openURL("config_url");
		cvbp.login_IBE_Config();
		cvbp.clickOnPortalsetting();
		cvbp.enterSubdomain();
		cvbp.clickOnPencilIcon();
		cvbp.selectStandardFlow();
		cvbp.clickOnSave();
		soft.assertTrue(icsp.verifySubdomainUpdated());
		allureScreenshot("select standard flow");
		screenShot("select standard flow");
		getDriver().close();
		Helper.switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("User should be able to see Standard flow in Booking Engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("IBE Config_StandardFlow")
	@Story("IBE Config_StandardFlow")
	@Step("see standard flow in Booking engine")
	public void IBE_Config_StandardFlow_TC_02()  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("IBE_Config_StandardFlow_TC_02");
		openURL("be_url4");
		allureScreenshot("Booking engine standard flow display");
		screenShot("Booking engine standard flow display");
		soft.assertFalse(icsp.verifyIBE_ConfigStandardFlow_TC_02());
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}
}

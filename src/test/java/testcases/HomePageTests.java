package testcases;


import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import base.TestBase;
import extend.TestReport;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;
import pages.BookingPages;

public class HomePageTests extends TestBase{
	
	TestReport tp = new TestReport();
	ExtentReports extent;
	ExtentTest extentTest;
	
	public static Utilitylog logger;
	
	public HomePageTests() {
		super();
		logger=new Utilitylog(HomePageTests.class.getName());
	}

	@BeforeMethod
	public void setup() {
		initilization();
	}

	@Test(priority=1)
	@Description("Verify the company Title on the HomePage...")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Title")
	@Story("Story: Title Presence")
	@Step("Verify Title Presence")
	public void verifyPageTitleTest() {
		BookingPages bookingPages = new BookingPages(getDriver());
//		extentTest = extent.startTest("verifyPageTitleTest");
		String title = bookingPages.UrlTilte();
		System.out.println(title);
		logger.info(title);
		Assert.assertEquals(title, "Make a reservation on qatest1");
	}
	
//	@Test(priority=2)
	@Description("Verify the Booking HomePage...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: HomePage Booking")
	@Story("Story: Booking HomePage")
	@Step("Verify Booking HomePage Presence")
	public void firstpage() throws Exception {
		logger.info("Booking Started");
		BookingPages bp = new BookingPages(getDriver());
		bp.firstPage();
		implict(8);
		bp.secondpage();
		bp.thirdPage("5425233430109903");
		bp.confirmPage();
		String title = bp.UrlTilte();
		System.out.println(title);
		Assert.assertEquals(title, "Reservation confirmation on qatest1");
		logger.info("Booking Ended");
		
	}
	
	@AfterMethod
	public void browerClose() {
		getDriver().quit();
	}
	
	@AfterSuite
	public void report() throws Exception {
		//mail();
		//cmdPrompt();
	}
	
	@AfterTest
	public void jdbcCon() throws Exception {
//		con();
//		select("select * from rateplan");
	}
}

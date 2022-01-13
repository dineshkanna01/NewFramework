package testcases;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.BrowserFactory;
import base.TestBase;
import extend.TestReport;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;
import multibrowser.MBrowser;
import pages.CancelBookingPage;

public class CancelReservation extends TestBase{
	
//	TestReport tp = new TestReport();
//	WebDriver driver;
//	ExtentReports extent;
//	ExtentTest extentTest;
	
	
	public static Utilitylog logger;
	
	public CancelReservation() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		logger=new Utilitylog(HomePageTests.class.getName());
	}
	
	@Test(priority=2)
	@Description("Verify the Booking firstpage...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: CancelReservationPage of Booking")
	@Story("Story: Booking CancelReservationPage")
	@Step("Verify Booking CancelReservationPage")
	public void cancel() throws Exception {
		logger.info("Cancel Reservation started");
		CancelBookingPage CP = new CancelBookingPage(getDriver());
		extentTest = extent.startTest("Cancel a reservation");
		CP.cancelBooking("qtest1100002261", "dinesh.kanna@igtsolutions.com");
//		allureScreenshot("CancelPage");
		screenShot("New Cancel Page");
		logger.info("Cancel Reservation done");
	}
	
	@AfterMethod
	public void browerClose() {
		getDriver().quit();
	}
	
	@AfterClass
	public void report() throws Exception {
		mail();
		
	}
	
	@AfterSuite
	public void extendReport() {
//		TestReport.extentTest = TestReport.extent.startTest("Make a reservation");
//		String title = driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals(title,"Reservation confirmation on qatest1");
		cmdPrompt();
	}
	
	
}

package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.SendEmail;
import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
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
	
	public static CancelBookingPage CP;
	public static Utilitylog logger;
	MBrowser mb;
	
	public CancelReservation() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		CP = new CancelBookingPage();
		logger=new Utilitylog(HomePage.class.getName());
		
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
		CP.cancelBooking("qtest1100001711", "dinesh.kanna@igtsolutions.com");
		screenShot("cancellation page");
		logger.info("Cancel Reservation done");
		
	}
	
	@AfterMethod
	public void browerClose() {
		driver.quit();
	}
	
	@AfterClass
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
	
	
}

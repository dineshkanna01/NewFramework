package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;
import pages.CancelBookingPage;

public class CancelReservation extends TestBase{
	
	public static CancelBookingPage CP;
	public static Utilitylog logger;
	
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
		CP.cancelBooking("QTEST1100001690", "dinesh.kanna@igtsolutions.com");
		screenShot("cancellation page");
		logger.info("Cancel Reservation done");
		
	}
	
	@AfterMethod
	public void browerClose() {
		driver.quit();
	}
}

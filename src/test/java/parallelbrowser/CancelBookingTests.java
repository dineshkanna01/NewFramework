package parallelbrowser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Utility.BrowserFactory;
import Utility.DriverFactory;
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

public class CancelBookingTests {

	public static Utilitylog logger;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		BrowserFactory.initilizationmultibrowser(browserName);
		logger=new Utilitylog(CancelBookingTests.class.getName());
	}

	@Test()
	@Description("Verify the CancelReservationPage...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: CancelReservationPage of Booking")
	@Story("Story: Booking CancelReservationPage")
	@Step("Verify Booking CancelReservationPage")
	public void cancelBookingTests() throws Exception {
		logger.info("Cancel Reservation started");
		CancelBookingPage cancelBookingPage = new CancelBookingPage(BrowserFactory.getDriver());
		cancelBookingPage.cancelBooking("qtest1100001797", "dinesh.kanna@igtsolutions.com");
//		BrowserFactory.screenShot("cancellation page");
		logger.info("Cancel Booking done");
	}

	@AfterMethod
	public void browerClose() {
		BrowserFactory.getDriver().quit();
	}

	@AfterSuite
	public void afterSuite() {
		BrowserFactory.cmdPrompt();
	}
}

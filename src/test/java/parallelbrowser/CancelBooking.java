package parallelbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import Utility.DriverFactory;
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
import pages.CancelBookingPage;

public class CancelBooking extends TestBase{

	public WebDriver driver = null;

	public static CancelBookingPage CP;
	public static Utilitylog logger;

	public CancelBooking() {
		super();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		driver=BrowserFactory.initilizationmultibrowser(browserName);
		DriverFactory.getInstance().setDriver(driver);
		driver=DriverFactory.getInstance().getDriver();

		CP = new CancelBookingPage();
		logger=new Utilitylog(CancelBooking.class.getName());

	}

	@Test()
	@Description("Verify the CancelReservationPage...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: CancelReservationPage of Booking")
	@Story("Story: Booking CancelReservationPage")
	@Step("Verify Booking CancelReservationPage")
	public void cancel() throws Exception {
		logger.info("Cancel Reservation started");
		CP.cancelBooking("qtest1100001762", "dinesh.kanna@igtsolutions.com");
		screenShot("cancellation page");
		logger.info("Cancel Booking done");

	}

	@AfterMethod
	public void browerClose() {
		driver.quit();
	}
}

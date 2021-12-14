package mobiletesting;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
import pages.MobileBookingPage;

public class MobileBooking extends TestBase{
	
public static Utilitylog logger;
	
	public MobileBooking() {
		super();
		logger=new Utilitylog(MobileBooking.class.getName());
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		mobileTest("Moto G4", 318, 850);
	}
	
	@Test(priority=1)
	@Description("Verify the Mobile Booking HomePage...")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Mobile Booking")
	@Story("Story: Mobile Booking Page")
	@Step("Verify Mobile Booking Page Presence")
	public void mobileBookPage() throws Exception {
		
		logger.info("Booking Started");
		MobileBookingPage mp = new MobileBookingPage(getDriver());
		mp.completeReservation();
		String title = mp.UrlTilte();
		System.out.println("Title of Page : " +title);
		Assert.assertEquals(title, "qatest1");
		logger.info("Booking Ended");
		
	}
	
	@AfterMethod
	public void browerClose() {
		getDriver().quit();
	}
	
	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}

}

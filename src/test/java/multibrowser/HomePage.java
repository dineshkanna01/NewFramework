package multibrowser;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
import pages.BookingPages;

public class HomePage extends TestBase{
	
	
	public static BookingPages bp;
	public static Utilitylog logger;
	
	public HomePage() {
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		initilizationmultibrowser(browserName);
		logger=new Utilitylog(HomePage.class.getName());
	}
	
//	@Test(priority=1)
	@Description("Verify the company Title on the HomePage...")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Title")
	@Story("Story: Title Presence")
	@Step("Verify Title Presence")
	public void title() {
		String title = bp.UrlTilte();
		System.out.println(title);
		logger.info(title);
		Assert.assertEquals(title, "Make a reservation on qatest1");
	}
	
	@Test(priority=2)
	@Description("Verify the Booking HomePage...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: HomePage Booking")
	@Story("Story: Booking HomePage")
	@Step("Verify Booking HomePage Presence")
	public void firstpage() throws Exception {
		logger.info("Booking Started");
		bp.firstPage();
		Helper.implict(8);
		bp.secondpage();
		bp.thirdPage("5425233430109903");
		bp.confirmPage();
		String title = bp.UrlTilte();
		System.out.println(title);
		Assert.assertEquals(title, "Reservation confirmation on qatest1");
		logger.info("Booking Ended");
//		
	}
	
	@AfterMethod
	public void browerClose() {
		getDriver().quit();
	}
	
}

package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
import pages.BookingDiffAdults;

@Test
public class DiffAdults extends TestBase{

	public static BookingDiffAdults bda;
	public static Utilitylog logger;
	
	public DiffAdults() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		bda = new BookingDiffAdults();
		logger=new Utilitylog(HomePageTests.class.getName());
		
	}
	
	@Description("Verify the Booking Different Adults...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: Additional Adults and child Booking")
	@Story("Story: Booking Additional Adults and child")
	@Step("Verify Booking Additional Adults and child Presence")
	public void firstpage() throws Exception {
		logger.info("Booking Started");
		String title = bda.UrlTilte();
		System.out.println("FirstPage Title: "+title);
		Assert.assertEquals(title, "Make a reservation on qatest1");
		bda.firstPage("11/24/2021", "2", "2");
		implict(6);
		bda.secondpage("dk", "s", "dinesh.kanna@igtsolutions.com", "Nice Hotel");
		bda.thirdPage("India", "Chennai", "Chennai", "Tamil Nadu", "600066", "9437875541");
		bda.confirmPage();
		String resTitle = bda.UrlTilte();
		System.out.println("FirstPage Title: "+resTitle);
		Assert.assertEquals(resTitle, "Reservation confirmation on qatest1");
		logger.info("Booking Ended");
	}
	
	@AfterMethod
	public void browerClose() {
//		driver.quit();
	}
	
	@AfterClass
	public void report() throws Exception {
		cmdPrompt();
//		mail();
	}
}

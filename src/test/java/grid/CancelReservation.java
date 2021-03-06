package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.TestUtils;
import base.TestBase;
import extend.TestReport;
import logfile.Utilitylog;
import pages.CancelBookingPage;
import testcases.HomePageTests;

public class CancelReservation extends TestReport{
	
	public static CancelBookingPage CP;
	public static Utilitylog logger;
	public static String nodeURL;
	
	public CancelReservation() {
		super();
	}
	
	
	@Parameters({"portNo"})
	@BeforeMethod
	public void setup(String portNo) throws Exception {

		if (portNo.equalsIgnoreCase("4455")) {
			nodeURL = "http://192.168.29.138:4444/wd/hub";
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WIN10);

			ChromeOptions options= new ChromeOptions();
			options.merge(capabilities);
			try {
				tdriver.set(new RemoteWebDriver(new URL(nodeURL), options));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
			getDriver().get("https://qatest1.qa-igt.reztrip3-qa.com/");
			CP = new CancelBookingPage(getDriver());
			logger=new Utilitylog(HomePageTests.class.getName());

		}else if(portNo.equalsIgnoreCase("4456")) {
			nodeURL = "http://192.168.29.138:4444/wd/hub";

			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WIN10);

			FirefoxOptions options2= new FirefoxOptions();
			options2.merge(capabilities);
			try {
				tdriver.set(new RemoteWebDriver(new URL(nodeURL), options2));
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
			getDriver().get("https://qatest1.qa-igt.reztrip3-qa.com/");
			CP = new CancelBookingPage(getDriver());
			logger=new Utilitylog(HomePageTests.class.getName());
		}
		
	}
	
	@Test(priority=2)
	public void cancel() throws Exception {
		logger.info("Cancel Reservation started");
		extentTest = extent.startTest("First Cancellation");
		CP.cancelBooking("QTEST1100004572", "dinesh.kanna@igtsolutions.com");
//		screenShot("cancellation page");
		String title = CP.UrlTilte();
		System.out.println(title);
		Assert.assertEquals(title, "Reservation confirmation on qatest1");
		logger.info("Cancel Reservation done");
		
	}
	
//	@Test(priority=3)
	public void cancel2() throws Exception {
		logger.info("Cancel Reservation started");
		extentTest = extent.startTest("Second Cancellation");
		CP.cancelBooking("QTEST1100004572", "dinesh.kanna@igtsolutions.com");
//		screenShot("cancellation page");
		String title = CP.UrlTilte();
		System.out.println(title);
		Assert.assertEquals(title, "Reservation1 confirmation on qatest1");
		logger.info("Cancel Reservation done");
		
	}
	
	@AfterMethod
	public void browserClose() {
		getDriver().quit();
	}
	
	@AfterSuite
	public void report() throws Exception {
//		mail();
//		cmdPrompt();
	}
	
	
}

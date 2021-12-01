package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.TestUtils;
import base.TestBase;
import logfile.Utilitylog;
import pages.CancelBookingPage;
import testcases.HomePageTests;

public class CancelReservation extends TestBase{
	
	public static CancelBookingPage CP;
	public static Utilitylog logger;
	
	public CancelReservation() {
		super();
	}
	
	@Parameters({"portNo"})
	@BeforeMethod
	public void setup(String portNo) throws Exception {


		if (portNo.equalsIgnoreCase("8888")) {
//			nodeURL = "http://192.168.1.6:4444/wd/hub";
			nodeURL = " http://192.168.1.6:5647/wd/hub";
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

		}else if(portNo.equalsIgnoreCase("4456")) {
			nodeURL = "http://192.168.1.2:4456/wd/hub";

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

		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		getDriver().get("https://qatest1.qa-igt.reztrip3-qa.com/");
		CP = new CancelBookingPage(getDriver());
		logger=new Utilitylog(HomePageTests.class.getName());
		
	}
	
	@Test(priority=2)
	public void cancel() throws Exception {
		logger.info("Cancel Reservation started");
		CP.cancelBooking("qtest1100001711", "dinesh.kanna@igtsolutions.com");
		screenShot("cancellation page");
		logger.info("Cancel Reservation done");
		
	}
	
	@AfterMethod
	public void browerClose() {
		getDriver().quit();
	}
	
	@AfterClass
	public void report() throws Exception {
//		mail();
//		cmdPrompt();
	}
	
	
}

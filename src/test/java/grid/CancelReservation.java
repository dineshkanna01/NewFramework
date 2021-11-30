package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.TestUtils;
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
import testcases.HomePage;

public class CancelReservation extends TestBase{
	
	public static CancelBookingPage CP;
	public static Utilitylog logger;
	
	public CancelReservation() {
		super();
	}
	
	@Parameters({"portNo"})
	@BeforeMethod
	public void setup(String portNo) throws Exception {


		if (portNo.equalsIgnoreCase("4455")) {
			nodeURL = "http://192.168.1.2:4455/wd/hub";
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WIN10);

			ChromeOptions options= new ChromeOptions();
			options.merge(capabilities);

			try {
				driver = new RemoteWebDriver(new URL(nodeURL), options);
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
				driver = new RemoteWebDriver(new URL(nodeURL), options2);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get("https://qatest1.qa-igt.reztrip3-qa.com/");
		CP = new CancelBookingPage();
		logger=new Utilitylog(HomePage.class.getName());
		
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
		driver.quit();
	}
	
	@AfterClass
	public void report() throws Exception {
//		mail();
//		cmdPrompt();
	}
	
	
}

package jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.BrowserFactory;
import Utility.JiraPolicy;
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
import pages.BookingPages;
import pages.CancelBookingPage;
import testcases.HomePageTests;

public class JiraTest extends TestBase{
	
public static Utilitylog logger;
	
	public JiraTest() {
		super();
		logger=new Utilitylog(JiraTest.class.getName());
	}

	@BeforeMethod
	public void setup() {
		initilization();
	}

	@JiraPolicy(logTicketReady=true)
	@Test
	public void test() throws Exception {
		
		logger.info("Cancel Reservation started");
		CancelBookingPage CP = new CancelBookingPage(getDriver());
		CP.cancelBooking("QTEST1100002237", "dinesh.kanna@igtsolutions.com");
		BrowserFactory.screenShot("cancellation page");
		String title = CP.UrlTilte();
		System.out.println(title);
		Assert.assertEquals(title, "Reservation confirmation on qatest12");
		logger.info("Cancel Reservation done");
		
	}
	
	@AfterMethod
	public void browerClose() {
//		getDriver().quit();
	}
	
	@AfterSuite
	public void report() throws Exception {
		//mail();
		//cmdPrompt();
	}
	
	@AfterTest
	public void jdbcCon() throws Exception {
//		con();
//		select("select * from rateplan");
	}
	

}

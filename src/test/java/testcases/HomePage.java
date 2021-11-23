package testcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SendEmail;
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
	
	@BeforeMethod
	public void setup() {
		initilization();
		bp = new BookingPages();
		logger=new Utilitylog(HomePage.class.getName());
		
	}
	
//	@Test(priority=1)
//	@Description("Verify the company Title on the HomePage...")
//	@Severity(SeverityLevel.CRITICAL)
//	@Epic("EP01")
//	@Feature("Feature1: Title")
//	@Story("Story: Title Presence")
//	@Step("Verify Title Presence")
//	public void title() {
//		String title = bp.UrlTilte();
//		System.out.println(title);
//		logger.info(title);
//		Assert.assertEquals(title, "Make a reservation on qatest1");
//	}
	
	@Test(priority=2)
	@Description("Verify the Booking firstpage...")
	@Severity(SeverityLevel.MINOR)
	@Epic("EP01")
	@Feature("Feature2: FirstPage of Booking")
	@Story("Story: Booking firstpage Presence")
	@Step("Verify Booking firstpage Presence")
	public void firstpage() throws Exception {
		logger.info("Booking Started");
		bp.firstPage("11/24/2021");
		screenShot("SecondPage");
		Thread.sleep(4000);
		bp.secondpage("dk", "s", "dinesh.kanna@igtsolutions.com", "Nice Hotel");
		screenShot("ThirdPage");
		bp.thirdPage("India", "Chennai", "Chennai", "Tamil Nadu", "600066", "9437875541");
		logger.info("Booking Ended");
		
	}
	
	@AfterMethod
	public void browerClose() {
		driver.quit();
	}
	
	@AfterClass
	public void report() throws Exception {
		cmdPrompt();
//		sendingMail();
//		SendEmail.mail();
	}
	
	@AfterTest
	public void jdbcCon() throws Exception {
//		con();
//		select("select * from employees");
	}
}

package com.mobilebooking;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.admin.AboutPropertyCreationScenario;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.AccessCodeBookingPage;
import com.mb.pom.NormalBookingWithAdultandChildPages;



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



/*
 * Test class for Normal Bookings With Adults and Child Scenario
 * @author Ankita mohamanasingh
 */



public class NormalBookingsWithAdultsandChildScenario extends TestBase {
	public static Utilitylog logger;



	public NormalBookingsWithAdultsandChildScenario() {
		super();
		logger = new Utilitylog(NormalBookingsWithAdultsandChildScenario.class.getName());

	}



	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalBookingWithAdultandChildPages nba;
	MobileBookingPage mbp;



	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		nba = new NormalBookingWithAdultandChildPages(getDriver());
		mbp=new MobileBookingPage(getDriver());
	}
	@Test(priority = 1)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithAdultsandChildScenario_TC_01() throws Exception {
		extentTest = extent.startTest("NormalBookingsWithAdultsandChildScenario_TC_01");
		//openURL("be_url5");
		//mobileTest("Samsung Galaxy S8+", 360, 740);
		mobileTest("Moto G4", 318,850);
		//mbp.completeReservation();
		//nba.clickGotIt();
		nba.selectDateRange();



		nba.selectMinimumAdultandChild();
		nba.completeReservation();

	}

	//@Test(priority = 2)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithAdultsandChildScenario_TC_02() throws Exception {
		extentTest = extent.startTest("NormalBookingsWithAdultsandChildScenario_TC_01");
		openURL("be_url5");
		// mobileTest("Moto G4", 318, 700);
		nba.selectDateRange();
		nba.selectMaximumAdultandChild();
		nba.completeReservation();

	}

	//@Test(priority = 3)
	@Description("Verify that user is getting access code rate plan in BE")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Manage access code scenario")
	@Story("Manage access code scenario")
	@Step("Verify that user is getting access code rate plan in BE")
	public void NormalBookingsWithAdultsandChildScenarioTC_03() throws Exception {
		extentTest = extent.startTest("NormalBookingsWithAdultsandChildScenario_TC_01");
		openURL("be_url5");
		//mobileTest("Moto G4", 318, 700);
		nba.selectDateRange();
		nba.selectMinAdultandMaxChild();
		nba.completeReservation();



	}



}
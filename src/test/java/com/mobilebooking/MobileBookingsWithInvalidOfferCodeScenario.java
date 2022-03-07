package com.mobilebooking;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.mb.pom.MobileBookingsWithInvalidOfferCodePage;


import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

	/*
	 * Test class for Normal Bookings With Adults and Child Scenario 
	 * @author Ankita mohamanasingh
	 */

	public class MobileBookingsWithInvalidOfferCodeScenario  extends TestBase  {
		public static Utilitylog logger;

		public MobileBookingsWithInvalidOfferCodeScenario() {
			super();
			logger = new Utilitylog(MobileBookingsWithInvalidOfferCodeScenario.class.getName());
	}

		// objects
		LoginPage lp;
		AdministratorHomePage ahp;
		MobileBookingsWithInvalidOfferCodePage ioc;

		@BeforeMethod
		public void setup() {
			lp = new LoginPage(getDriver());
			ioc = new MobileBookingsWithInvalidOfferCodePage(getDriver());
			
		}
		@Test(priority = 1)
		@Description("Verify that user is not able to do bookings with invalid offer code")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:Mobile bookings with invalid offer code scenario")
		@Story("Mobile bookings with invalid offer code scenario")
		@Step("Verify that user is getting access code rate plan in BE")
		public void NormalBookingsWithInvalidOfferCode_TC_01()  {
			extentTest = extent.startTest("NormalBookingsWithInvalidOfferCode_TC_01");
			logger.info("TestCase Started");
			mobileTest("Moto G4", 318, 850);
			ioc.invalidOfferCodeReservation();
			Assert.assertTrue(ioc.verifyInvalidOfferCode());
					
		}
	}


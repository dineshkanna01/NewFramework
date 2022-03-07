package com.mobilebooking;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.mb.pom.MobileBookingUsingPromoURLPages;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class MobileBookingUsingPromoURLScenario extends TestBase{
	
		public static Utilitylog logger;

		public MobileBookingUsingPromoURLScenario() {
			super();
			logger = new Utilitylog(MobileBookingUsingPromoURLScenario.class.getName());
		}

		// objects
		LoginPage lp;
		AdministratorHomePage ahp;
		MobileBookingUsingPromoURLPages PURL;
		
		@BeforeMethod
		public void setup() {
			lp = new LoginPage(getDriver());
			ahp = new AdministratorHomePage(getDriver());
			PURL =new MobileBookingUsingPromoURLPages(getDriver());
		}
		@Test(priority = 1)
		@Description("Verify that user is  able to do bookings with Promo URL")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:Mobile  bookings using Promo URL Scenario")
		@Story("Mobile  bookings using Promo URL Scenario")
		@Step("Verify user should able to do mobile booking using promo URL")
		public void MobileBookingUsingPromoURL_TC_01() throws Exception  {
			extentTest = extent.startTest("MobileBookingUsingPromoURL_TC_01");
			//mobileTest("Moto G4", 318, 850);
			//river.manage().window().setPosition(new Point(0, -1000));
			lp.clickClearButton();
			lp.login();
			ahp.selectBrand();
			ahp.selectProperty3();
			PURL.clickRatePlan();
			PURL.editRatePlan();
			PURL.copyPromoURL();
			
	}

}


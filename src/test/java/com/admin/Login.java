package com.admin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.TestBase;
import extend.TestReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;
import pages.Admin_Login;

public class Login extends TestBase {
	
	TestReport tp = new TestReport();
	public static Utilitylog logger;
	
	public Login() {
		super();
		logger=new Utilitylog(Login.class.getName());
	}
	
//	@BeforeMethod
	public void setup() {
		initilization_Admin();
//		initilization_Gmail();
	}
	
	@Test
	@Description("Verify the Admin Login")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Login")
	@Story("Story: Admin Page Login")
	@Step("Verify Admin Page Login Presence")
	public void login() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qa-igt.ttaws.com/admin/login.jsp");
		Admin_Login al = new Admin_Login(getDriver());
//		extentTest = extent.startTest("Cancel a reservation");
		al.loginPage();
//		al.logOut();
		
//		al.otp();
		
	}
	
//	@AfterMethod
	public void browerClose() {
//		getDriver().quit();
	}
	

}

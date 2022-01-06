package admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
import pages.Admin_Login;

public class Login extends TestBase {
	
	public static Utilitylog logger;
	
	public Login() {
		super();
		logger=new Utilitylog(Login.class.getName());
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
	}
	
	@Test
	@Description("Verify the Admin Login")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Login")
	@Story("Story: Admin Page Login")
	@Step("Verify Admin Page Login Presence")
	public void login() {
		Admin_Login al = new Admin_Login(getDriver());
		al.loginPage();
	}
	
	@AfterMethod
	public void browerClose() {
		getDriver().quit();
	}
	
	@AfterSuite
	public void report() throws Exception {
		//mail();
		cmdPrompt();
	}
	

}

package pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;

public class PostRequest extends TestBase{

	@BeforeClass
	public void setup() {
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("------------Execution Started------------");
	}
	
	@Test
	public void post() throws Exception {
		TestResponse();
	}
	
	@AfterClass
	public void TearDown() {
		System.out.println("------------Execution Ended------------");
	}
	
}

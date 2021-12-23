package API;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import logfile.Utilitylog;

import java.util.logging.Logger;

public class RestAssuredPost extends TestBase{

	public static final Logger LOGGER = Logger.getLogger(RestAssuredPost.class.getName());
	public static Utilitylog logger;

	public RestAssuredPost() {
		super();
		logger=new Utilitylog(RestAssuredPost.class.getName());
		
	}

	@BeforeTest
	public void setup() {
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("------------Execution Started------------");
	}

	@Test()
	public void post() throws Exception {
		logger.info("------------AvailNotif Execution Started------------");
		TestResponse("AvailNotif");
		logger.info("------------AvailNotif Execution Ended------------");
	}

	@Test()
	public void post2() throws Exception {
		logger.info("------------RateAmount Execution Started------------");
		TestResponse("RateAmount");
		logger.info("------------RateAmount Execution Ended------------");
	}

	@Test()
	public void post3() throws Exception {
		logger.info("------------RatePlan Execution Started------------");
		TestResponse("RatePlan");
		logger.info("------------RatePlan Execution Ended------------");
	}

//	@Test(priority=4)
	public void post4() throws Exception {
		logger.info("------------Execution Started------------");
//		otaHotelService("ReadRQ");
		logger.info("------------Execution Ended------------");
	}

	@AfterTest
	public void TearDown() {
		System.out.println("------------Execution Ended------------");
	}
}

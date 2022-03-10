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
	public void roomRateLevelRestrictionHMS() throws Exception {
		logger.info("------------RoomRateLevelRestriction HMS Execution Started------------");
//		extentTest = extent.startTest("roomRateLevelRestrictionHMS");
		TestResponse("RoomRateLevelRestrictionHMS");
		logger.info("------------RoomRateLevelRestriction HMS Execution Ended------------");
		logger.info("--------------DataBase Validation-----------");
		select("SELECT * FROM intg_interface;");
	}
	
//	@Test()
	public void rateLevelRestrictionHMS() throws Exception {
		logger.info("------------RateLevelRestriction HMS Execution Started------------");
		extentTest = extent.startTest("rateLevelRestrictionHMS");
		TestResponse("RateLevelRestrictionHMS");
		logger.info("------------RateLevelRestriction HMS Execution Ended------------");
	}
	
//	@Test()
	public void houseLevelRestrictionHMS() throws Exception {
		logger.info("------------HouseLevelRestriction HMS Execution Started------------");
		extentTest = extent.startTest("houseLevelRestrictionHMS");
		TestResponse("HouseLevelRestrictionHMS");
		logger.info("------------HouseLevelRestriction HMS Execution Ended------------");
	}
	
//	@Test()
	public void invCountNotifRQ() throws Exception {
		logger.info("------------InvCountNotifRQ HMS Execution Started------------");
		extentTest = extent.startTest("invCountNotifRQ");
		TestResponse("InvCountNotifRQ");
		logger.info("------------InvCountNotifRQ HMS Execution Ended------------");
	}
	
//	@Test()
	public void ratePlanNotifRQ() throws Exception {
		logger.info("------------RatePlanNotifRQ HMS Execution Started------------");
		extentTest = extent.startTest("ratePlanNotifRQ");
		TestResponse("RatePlanNotifRQ");
		logger.info("------------RatePlanNotifRQ HMS Execution Ended------------");
	}
	
//	@Test()
	public void resNotifRQ() throws Exception {
		logger.info("------------InBound Reservation HMS Execution Started------------");
		TestResponse("ResNotifRQ");
		logger.info("------------InBound Reservation HMS Execution Ended------------");
	}

//	@Test()
	public void availNotif() throws Exception {
		logger.info("------------AvailNotif Execution Started------------");
		TestResponse("AvailNotif");
		logger.info("------------AvailNotif Execution Ended------------");
	}

//	@Test()
	public void rateAmnt() throws Exception {
		logger.info("------------RateAmount Execution Started------------");
		TestResponse("RateAmount");
		logger.info("------------RateAmount Execution Ended------------");
	}

//	@Test()
	public void ratePlan() throws Exception {
		logger.info("------------RatePlan Execution Started------------");
		TestResponse("RatePlan");
		logger.info("------------RatePlan Execution Ended------------");
	}

//	@Test(priority=4)
	public void readRQ() throws Exception {
		logger.info("------------Execution Started------------");
		otaHotelService("ReadRQ");
		logger.info("------------Execution Ended------------");
	}

	@AfterTest
	public void TearDown() {
		System.out.println("------------Execution Ended------------");
	}
}

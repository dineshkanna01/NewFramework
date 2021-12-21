package restAPI;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import logfile.Utilitylog;
import testcases.HomePageTests;

public class Post extends TestBase{

	public static Utilitylog logger;
	
	public Post() {
		super();
		logger=new Utilitylog(Post.class.getName());
	}
	
	@BeforeClass
	public void setup() {
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("------------Execution Started------------");
	}
	
	@Test(priority=1)
	public void post() throws Exception {
//		TestResponse();
		
		logger.info("------------Execution Started------------");
		postResp("RatePlan");
		//		otaHotelService("AvailNotif");
		logger.info("------------Execution Ended------------");
	}
	
//	@Test(priority=2)
	public void post2() throws Exception {
		logger.info("------------Execution Started------------");
		otaHotelService("RateAmount");
		logger.info("------------Execution Ended------------");
	}
	
//	@Test(priority=3)
	public void post3() throws Exception {
		logger.info("------------Execution Started------------");
		otaHotelService("RatePlan");
		logger.info("------------Execution Ended------------");
	}
	
//	@Test(priority=4)
	public void post4() throws Exception {
		logger.info("------------Execution Started------------");
		otaHotelService("ReadRQ");
		logger.info("------------Execution Ended------------");
	}
	
	@AfterClass
	public void TearDown() {
		System.out.println("------------Execution Ended------------");
	}
}

package API;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import logfile.Utilitylog;

public class HttpClientAPI extends TestBase{

	public static Utilitylog logger;

	public HttpClientAPI() {
		super();
		logger=new Utilitylog(HttpClientAPI.class.getName());
	}

	@BeforeTest
	public void setup() {
		System.out.println("------------Execution Started------------");
	}

	@Test()
	public void availNotif() throws Exception {
		logger.info("------------AvailNotif Execution Started------------");
		otaHotelService("AvailNotif");
		logger.info("------------AvailNotif Execution Ended------------");
	}

	@Test()
	public void rateAmnt() throws Exception {
		logger.info("------------RateAmount Execution Started------------");
		otaHotelService("RateAmount");
		logger.info("------------RateAmount Execution Ended------------");
	}

	@Test()
	public void ratePlan() throws Exception {
		logger.info("------------RatePlan Execution Started------------");
		otaHotelService("RatePlan");
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

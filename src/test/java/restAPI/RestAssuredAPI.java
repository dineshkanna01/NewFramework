package restAPI;

import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.ConfigManager;
import io.restassured.RestAssured;

public class RestAssuredAPI {
	static String BASE_URL = ConfigManager.getInstance().getString("base_url");
	@BeforeClass
	public void setup() {
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("------------Execution Started------------");
	}
	
	@Test
	public static void postResp(String fileXmlName) throws Exception {
		String path = "src/test/resources/xmlFiles/";
		FileInputStream fi = new FileInputStream(path +"fileXmlName"+".xml");
		RestAssured.baseURI=BASE_URL;
		RestAssured.given().body(IOUtils.toString(fi,"UTF-8")).post().then().log().all().assertThat().statusCode(200);
		
	}
	
	@AfterClass
	public void TearDown() {
		System.out.println("------------Execution Ended------------");
	}

}

package base;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import logfile.Utilitylog;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.TestUtils;
import cmdprompt.SyncPipe;
import extend.TestReport;
import helper.JsonHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import pages.BookingPages;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;

import Utility.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import javax.net.ssl.*;

public class TestBase {

	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	public static Properties prop; 
	public static WebDriver driver;
	public static Platform WIN10;
	public static String nodeURL;
	public static String portNo;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\config\\Configuration.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		}
		else if(browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tdriver.set(new EdgeDriver());
		}else {
			System.out.println("No browser");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("url"));
	}
	
	public static void initilization_Admin() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			String downloadFilepath = System.getProperty("user.dir") + "\\target\\CrsReports";
			Map<String, Object> preferences = new Hashtable<String, Object>();
			preferences.put("profile.default_content_settings.popups", 0);
			preferences.put("download.prompt_for_download", "false");
			preferences.put("download.default_directory", downloadFilepath);

			// disable flash and the PDF viewer
			preferences.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", preferences);
			options.addArguments("user-data-dir=C:\\Users\\Dinesh.Kanna\\AppData\\Local\\Google\\Chrome\\User Data");
			tdriver.set(new ChromeDriver(options));
		}
		else if(browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tdriver.set(new EdgeDriver());
		}else {
			System.out.println("No browser");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("admin_url"));
	}
	
	public static void initilization_Gmail() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		}
		else if(browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tdriver.set(new EdgeDriver());
		}else {
			System.out.println("No browser");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);

		getDriver().get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%26ogbl%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	
	public static void initGmail() {
		WebDriverManager.chromedriver().setup();
		tdriver.set(new ChromeDriver());
		getDriver().get("https://www.google.co.in/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);

	}

	public static void initilizationmultibrowser(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tdriver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		getDriver().get("https://qatest1.qa-igt.reztrip3-qa.com/");
	}

	public static void setUp() {

		if (portNo.equalsIgnoreCase("4455")) {
			nodeURL = "http://192.168.1.5:4455/wd/hub";
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WIN10);

			ChromeOptions options= new ChromeOptions();
			options.merge(capabilities);
			try {
				tdriver.set(new RemoteWebDriver(new URL(nodeURL), options));
				getDriver().manage().window().maximize();
				getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
				getDriver().get(prop.getProperty("url"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}else if(portNo.equalsIgnoreCase("4456")) {
			nodeURL = "http://192.168.1.5:4456/wd/hub";

			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WIN10);

			FirefoxOptions options2= new FirefoxOptions();
			options2.merge(capabilities);

			try {
				tdriver.set(new RemoteWebDriver(new URL(nodeURL), options2));
				getDriver().manage().window().maximize();
				getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
				getDriver().get(prop.getProperty("url"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}
	}

	public static void mobileTest(String emulation, int w, int h) throws Exception {

		WebDriverManager.chromedriver().setup();
		Map<String, String> deviceMobEmu= new HashMap<String, String>();
		deviceMobEmu.put("deviceName", emulation);
		//		deviceMobEmu.put("deviceName", "Moto G4");
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", deviceMobEmu);
		tdriver.set(new ChromeDriver(chromeOptions));

		Dimension d = new Dimension(w, h);
		getDriver().manage().window().setSize(d);

		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		getDriver().get("https://qatest1.qa-igt.reztrip3-qa.com/");

	}
	public void launchUrl() {
		// TODO Auto-generated method stub

	}

	public static void screenShot(String fileName) throws Exception {
		File file=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File(".//target//ScreenshotPath/"+fileName+".jpg"));
	}

	public static void implict(int num) {
		getDriver().manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}

	public void allureScreenshot(String screenshotName) {
		Allure.addAttachment(screenshotName, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
	
	public static void cmdPrompt() {
		String [] command = {"cmd"};
		Process p;
		try {
			p=Runtime.getRuntime().exec(command);

			new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			new Thread(new SyncPipe(p.getInputStream(), System.err)).start();
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			String path = System.getProperty("user.dir")+"\\allure-results";
			stdin.println("allure serve " + path);

			stdin.close();
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mail() throws Exception {

		final String username = "dinesh.kanna@pegs.com";
		final String password = "Disser@01";
		String fromEmail = "dinesh.kanna@pegs.com";
		String toEmail = "dinesh.kanna@pegs.com";


		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put ("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "465");
		// authentication with Session class
		Session s= Session.getDefaultInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message m = new MimeMessage(s);
		try {
			m.setFrom(new InternetAddress(fromEmail));
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			m.setSubject("Email Report");
			m.setText("New Mail");

			Date dt=new Date();
			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
			String stDate=format.format(dt);
			
			m.setSubject("Execution report on "+stDate);
			BodyPart messageBodyPart=new MimeBodyPart();
			messageBodyPart.setText("Hi \n"
					+ "Updated reports are attached. Kindly check..");
			Multipart multipart= new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			File file=new File(System.getProperty("user.dir") + "\\test-output\\emailable-report.html");

			messageBodyPart = new MimeBodyPart();
			DataSource source=new FileDataSource(file.getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Report ");
			multipart.addBodyPart(messageBodyPart);
			m.setContent(multipart);
			Transport.send(m);

		} catch (AddressException e) {
			e.printStackTrace();
		}

	}

	@BeforeTest
//	public void setExtent(){
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		extent = new ExtentReports(System.getProperty("user.dir")+"/Html/ExtentReport.html", true);
//	}
	public void generateReport() {

		initilization_Admin();// for single time login and logout

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String strDate = dateFormat.format(date);

		String f1 = ".\\target\\" + File.separator + "ExtentReport" + File.separator + "TestReport_" + strDate + ".html";
		System.out.println("path" + f1);
		TestBase.extent = new ExtentReports(f1, Boolean.valueOf(true));
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver tdriver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) tdriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/target/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getHost());
			
			String screenshotPath = TestReport.getScreenshot(getDriver(), result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			getDriver().quit();
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			getDriver().quit();
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS ==>" + result.getName());
			extentTest.log(LogStatus.PASS, "Test Case STATUS IS ==>" + result.getStatus());
			extentTest.log(LogStatus.PASS, "Test Case PACKAGENAME IS ==>" + result.getInstanceName());
		}
		
//		getDriver().quit();
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		
	}


	public static Connection con() {
		try {
			String JDBC_Driver = "com.mysql.jdbc.Driver";
			String urlDB = "jdbc:mysql://localhost:3306/DBname";
			String user = "dineshkanna";
			String pass = "123456";
			Class.forName(JDBC_Driver);
			Connection connect=DriverManager.getConnection(urlDB, user, pass);
			return connect;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public static ArrayList<String> select(String query) throws Exception  {
		Connection conn = con();
		PreparedStatement statement = conn.prepareStatement(query);

		ResultSet result = statement.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while (result.next()) {
			array.add(result.getString("url"));
		}
		return array;

	}


	public static String jsonFile(String User, String jsonLocation, String value) throws Exception {
		JsonHelper helper=new JsonHelper();
		Map<String,String> map=new HashMap<String,String>();

		map=helper.readJsonFile(User,jsonLocation);
		//		System.out.println(map);
		System.out.println(map.get(value));
		System.out.println(map.get("AadharNumber"));
		System.out.println(map.get("DateofBirth"));

		//		map=helper.readJsonFile("addUser1","UserManagementTest.json");
		//		System.out.println(map);
		//		System.out.println(map.get("userName"));
		//		System.out.println(map.get("AadharNumber"));
		//		System.out.println(map.get("DateofBirth"));
		return value;
	}

	static String BASE_URL = ConfigManager.getInstance().getString("base_url");

	public static void TestResponse(String fileXmlName) throws Exception {

		String path = "src/test/resources/xmlFiles/";
		FileInputStream fi = new FileInputStream(path +fileXmlName+".xml");
		RestAssured.baseURI=BASE_URL;

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.body(IOUtils.toString(fi,"UTF-8"));

		io.restassured.response.Response response = httpRequest.request(Method.POST);
		httpRequest.header("Content-Type", "application/xml");
		
		int statusCode = response.statusCode();
		System.out.println("Status Code: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		System.out.println("ContentType : "+response.contentType());
		System.out.println("Status : "+response.getStatusLine());
		
		String responseBody = response.getBody().asString();
		System.out.println("Respose Body : " +responseBody);
		Assert.assertEquals(responseBody.contains("Success"), true);
		
		System.out.println("Headers : "+response.getHeaders()+"\n");
		
	}


	public static void postResp(String fileXmlName) throws Exception {

		String path = "src/test/resources/xmlFiles/";
		FileInputStream fi = new FileInputStream(path +fileXmlName+".xml");
		RestAssured.baseURI=BASE_URL;
		RestAssured.given()
		.body(IOUtils.toString(fi,"UTF-8"))
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);

	}

	public void otaHotelService(String xmlName) throws IOException {
		
		try {
			final TrustManager[] trustAllCerts = new TrustManager[]{
					new X509TrustManager() {
						@Override
						public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
						}

						@Override
						public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
						}

						@Override
						public java.security.cert.X509Certificate[] getAcceptedIssuers() {
							return new java.security.cert.X509Certificate[]{};
						}
					}
			};

			final SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
			builder.hostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

			OkHttpClient client = builder.build();
			MediaType mediaType = MediaType.parse("text/xml; charset=utf-8");
			String path = "src/test/resources/xmlFiles/";
			File input = new File(path +xmlName +".xml");


			RequestBody body = RequestBody.create(input, mediaType);

			Request request = new Request.Builder()
					.url(BASE_URL)
					.method("POST", body)
					.addHeader("Content-Type", "text/xml; charset=utf-8")
					.build();

			Response response = client.newCall(request).execute();
//          Response response2 = response.networkResponse();
			int statusCode = response.code();
			System.out.println("Status Code : "+statusCode);
			Assert.assertEquals(statusCode, 200);
			System.out.println("Protocol : " +response.protocol());
			System.out.println("ResponseBody : "+response.body().string());
			System.out.println("ContentType : "+response.body().contentType());
			boolean successful = response.isSuccessful();
			System.out.println("isSuccessful : "+successful);
			Assert.assertEquals(successful, true);
			System.out.println("Header : "+response.headers());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();

	}


	public static WebDriver getDriver() {
		return tdriver.get();
	}
}

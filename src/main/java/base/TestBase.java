package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

import logfile.Utilitylog;
import org.apache.commons.io.FileUtils;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Utility.TestUtils;
import cmdprompt.SyncPipe;
import helper.JsonHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BookingPages;


public class TestBase {


	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	public static Properties prop; 
	public static WebDriver driver1;
	public static Platform WIN10;
	public static String nodeURL;
	public static String portNo;

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

	public static void screenShot(String fileName) {
		prop = new Properties();
		File file=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/ScreenshotPath/"+fileName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void implict(int num) {
		getDriver().manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}


	public static void cmdPrompt() {
		String [] command = {"cmd"};
		Process p;
		try {
			p=Runtime.getRuntime().exec(command);

			new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			new Thread(new SyncPipe(p.getInputStream(), System.err)).start();
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			stdin.println("allure serve C:\\Users\\Dinesh.Kanna\\eclipse-workspace\\FrameworkIGT\\allure-results");

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

			//			Date dt=new Date();
			//			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
			//			String stDate=format.format(dt);
			//
			//			m.setSubject("Execution report on"+stDate);
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

	public static WebDriver getDriver() {
		return tdriver.get();
	}
}

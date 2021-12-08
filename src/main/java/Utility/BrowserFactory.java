package Utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import cmdprompt.SyncPipe;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver getDriver() {
		return tdriver.get();
	}

	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();

	public static WebDriver initilizationmultibrowser(String browserName) {
		WebDriver driver = null;
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
		tdriver.get().manage().window().maximize();
		tdriver.get().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		tdriver.get().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		tdriver.get().get("https://qatest1.qa-igt.reztrip3-qa.com/");
		return tdriver.get();
	}

	public static void screenShot(String fileName) {
		File file=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path1 = System.getProperty("user.dir")+"\\target\\ScreenshotPath";
		try {
			FileUtils.copyFile(file, new File(path1+fileName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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



}

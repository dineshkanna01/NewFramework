package grid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class test {
	
	WebDriver driver;

	@Test(priority=1)
	public void tc() throws Exception {
		
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WIN10);
			
			ChromeOptions options= new ChromeOptions();
			options.merge(capabilities);
			
			driver=new RemoteWebDriver(new URL("http://192.168.1.2:4455/wd/hub"),options);
			driver.manage().window().maximize();
			driver.get("https://www.igtsolutions.com/");
//			System.out.println("Title: "+driver.getTitle());
			driver.quit();
	}
	
	@Test(priority=2)
	public void tc4() throws Exception {

		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WIN10);

		FirefoxOptions options2= new FirefoxOptions();
		options2.merge(capabilities);

		driver=new RemoteWebDriver(new URL("http://192.168.1.2:4456/wd/hub"),options2);
		driver.manage().window().maximize();
		driver.get("https://www.igtsolutions.com/");
//		System.out.println("Title: "+driver.getTitle());
		driver.quit();

	}

}

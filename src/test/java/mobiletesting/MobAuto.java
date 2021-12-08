package mobiletesting;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Utility.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobAuto {
	
	@Test
	public void validation() {
		WebDriverManager.chromedriver().setup();
		Map<String, String> deviceMobEmu= new HashMap<String, String>();
//		deviceMobEmu.put("deviceName", emulation);
		deviceMobEmu.put("deviceName", "Moto G4");
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", deviceMobEmu);
		WebDriver driver= new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get("https://sacqa6.qa2.reztrip3-qa.com/mobile/");
		
		driver.findElement(By.xpath("//a[text()=\"Got it!\"]")).click();
		
//		driver.quit();
		
	}

}

package mobiletesting;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobAuto {
	
	@DataProvider
	public Object[][] mobileEmulations(){
		return new Object[][] {
			{"iPhone 6", 380, 812},
//			{"Moto G4", 315, 850}			
		};
	}
	
	@Test(dataProvider="mobileEmulations")
	public void mobileTest(String emulation, int w, int h) throws Exception {
		WebDriverManager.chromedriver().setup();
		Map<String, String> deviceMobEmu= new HashMap<String, String>();
		deviceMobEmu.put("deviceName", emulation);
//		deviceMobEmu.put("deviceName", "Moto G4");
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", deviceMobEmu);
		WebDriver driver= new ChromeDriver(chromeOptions);
		Dimension d = new Dimension(w, h);
		driver.manage().window().setSize(d);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get("https://qatest1.qa-igt.reztrip3-qa.com/");
		
		driver.findElement(By.xpath("//a[text()=\"Got it!\"]")).click();
//		driver.findElement(By.xpath("//div[text()=\"December 2021\"]//following-sibling::div[@class=\"calendar_days ng-scope\"]//child::div[@class=\"calendar_day \"]//child::div[@class=\"calendar_day_num\"]")).sendKeys("22");
		driver.findElement(By.xpath("//div[text()=\"29\"]")).click();
		driver.findElement(By.xpath("//div[text()=\"30\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Select Room\"]")).click();
		
		driver.findElement(By.xpath("(//span[@class=\"clearfix\"])[1]")).click();
		driver.findElement(By.name("commit")).click();
//		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@title=\"Bed type preference\"]")).click();
		driver.findElement(By.xpath("//li[text()=\"King\"]")).click();
		driver.findElement(By.id("details_form_roomer_attributes_full_name")).sendKeys("Dineshkanna");
		driver.findElement(By.id("details_form_roomer_attributes_phone_number")).sendKeys("8899776655");
		driver.findElement(By.id("details_form_roomer_attributes_email")).sendKeys("dinesh.kanna@igtsolutions.com");
		driver.findElement(By.id("details_form_billing_address_attributes_address")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@placeholder=\"Country\"]")).click();
		driver.findElement(By.xpath("//li[text()=\"India\"]")).click();
		driver.findElement(By.xpath("//select[@placeholder=\"State\"]")).click();
		driver.findElement(By.xpath("//option[text()=\"Tamil Nadu\"]")).click();
		driver.findElement(By.id("details_form_billing_address_attributes_city")).sendKeys("Chennai");
		driver.findElement(By.id("details_form_billing_address_attributes_zipcode")).sendKeys("600033");

		driver.findElement(By.id("cardName")).sendKeys("Dk");
		driver.findElement(By.id("details_form_credit_card_attributes_card_number")).sendKeys("5425233430109903");
		driver.findElement(By.id("details_form_credit_card_attributes_card_number")).sendKeys("5425233430109903");
		driver.findElement(By.id("details_form_credit_card_attributes_card_number")).sendKeys("5425233430109903");
		driver.findElement(By.id("details_form_credit_card_attributes_card_number")).sendKeys("5425233430109903");
		
		driver.findElement(By.id("details_form_credit_card_attributes_expiration_date")).sendKeys("11");
		driver.findElement(By.id("details_form_credit_card_attributes_expiration_date")).sendKeys("23");
		
		driver.findElement(By.id("cardCsc")).sendKeys("222");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@title=\"Country\"])[2]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@placeholder=\"Search\"]")).sendKeys("India");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()=\"India\"]")).click();
//		driver.findElement(By.xpath("//li[contains(text(),'India')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("card_zip")).sendKeys("600044");
		
		driver.findElement(By.id("accept-tandc")).click();
		driver.findElement(By.xpath("//button[text()=\"Complete Reservation\"]")).click();
		
//		Thread.sleep(6000);
//		String text = driver.findElement(By.xpath("//span[contains(text(),'qtest11')]")).getText();
//		System.out.println("Confirmation Id: "+text);
		
//		driver.quit();
		
	}

}

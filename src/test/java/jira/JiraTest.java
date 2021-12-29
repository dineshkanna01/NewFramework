package jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.JiraPolicy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JiraTest {
	
	@JiraPolicy(logTicketReady=true)
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.igtsolutions.com/");
        
        String title = driver.getTitle();
        Assert.assertEquals(title, "IGT Solutions: BPM, IT and Digital Services & Solutions Provider1");
        System.out.println(title);
        
        driver.close();
        
//        driver.findElement(By.name("q")).sendKeys("IGTSOLUTION");
//        driver.findElement(By.xpath("(//input[@class=\"gNO89b\"])[2]")).click();
        
        
	}

}

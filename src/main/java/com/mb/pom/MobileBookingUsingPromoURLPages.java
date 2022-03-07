package com.mb.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;

public class MobileBookingUsingPromoURLPages extends TestBase {
	public WebDriver driver;

	public MobileBookingUsingPromoURLPages(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Rate Plans']")
	WebElement ratePlan;

	@FindBy(xpath = "//*[contains(@href,'retrieveRateTypes.do')]")
	WebElement ratePlanListAll;

	public String UrlTilte() {
		return driver.getTitle();

	}

	/*
	 * Method to click on rateplan
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage clickRatePlan() {
		ratePlan.click();
		ratePlanListAll.click();
		return null;
	}

	/*
	 * Method to click on edit
	 * 
	 */
	public MobileBookingsWithInvalidOfferCodePage editRatePlan() {
		String rp = ExcelData.getCellData("MobileB", "RatePlan", 2);

		WebElement a = getDriver().findElement(By.xpath("//td[contains(text(),'" + rp + "')]//following::a[1]"));
		a.click();

		return null;
	}
	/*
	 * Method to right click on the element
	 * 
	 */

	public MobileBookingsWithInvalidOfferCodePage copyPromoURL() throws Exception {
		
//			Actions action = new Actions(getDriver());
//			action.moveToElement(element).click().perform();
//			
//        action.contextClick(rightClickElement).build().perform();
//        WebElement getCopyText =getDriver().findElement(By.xpath("(//*[contains(@href,'promoRate?')])[1]"));

		Actions action = new Actions(getDriver());
//		WebElement a = getDriver().findElement(By.xpath("(//*[contains(@href,'promoRate?')])[1]"));
//		action.moveToElement(a).contextClick().build().perform();
//		WebElement a = getDriver().findElement(By.xpath("(//*[contains(@href,'promoRate?')])[1]"));
//		action.moveToElement(a).contextClick(a).pause(java.time.Duration.ofSeconds(3))
//		.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ENTER).build().perform();
		
		WebElement a = getDriver().findElement(By.xpath("(//*[contains(@href,'promoRate?')])[1]"));
		action.moveToElement(a).contextClick(a).perform();
		
		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_DOWN);
		for (int i = 1; i <=5; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
//		driver.switchTo().alert().accept();
		
//		WebElement link = getDriver().findElement(By.partialLinkText("promoRate?property=100&mode=b&pm=true&sr=1569&vr=3"));
//		String linkLocatin = link.getAttribute("href");
//		System.out.println("Link  "+linkLocatin);
//		return null;
		
//		Actions action = new Actions(getDriver());
//		WebElement a = getDriver().findElement(By.xpath("(//*[contains(@href,'promoRate?')])[1]")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
		
		//WebElement l = getDriver().findElement(By.xpath("(//*[contains(@href,'promoRate?')])[1]"));
	//	Actions a = new Actions(getDriver());
	     // a.moveToElement(l).click();
		//action.moveToElement(a).contextClick().build().perform();
		
	 return null;
		}
}
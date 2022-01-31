package com.be.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;


public class JCCBookingsPage extends TestBase {

	ExcelData e = new ExcelData();
	public static WebDriver driver;



	public JCCBookingsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}



	public String UrlTilte() {
		return driver.getTitle();
	}

	public void bETC01() {

		openBEurlinNewTab();// open BE url in that tab

		// do your operations..... and switch back to admin if you want to or close browser

		switchWindow(0);
//		getDriver().switchTo().window(switchTabs().get(0));// switch to main tab(admin portal in this case)
		switchWindow(1);
//		getDriver().switchTo().window(switchTabs().get(1)); // switch to BE tab again if you want to
		switchWindow(0);
		switchWindow(2);

	}
}

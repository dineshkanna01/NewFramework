package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Helper;
import base.TestBase;

/*
 * POM class for Interactive reports
 * @Author Uzair Asar
 */

public class InteractiveReportsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Interactive Reporting']")
	WebElement interactiveReportingTab;

	@FindBy(xpath = "//a[text()='Interactive Reports']")
	WebElement interactiveReportOption;

	public InteractiveReportsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to enable Compound Access Code
	 */

	public InteractiveReportsPage openInteractiveReports() {
		Helper.implict(3);
		interactiveReportingTab.click();
		Helper.implict(3);
		interactiveReportOption.click();
		return null;

	}
}
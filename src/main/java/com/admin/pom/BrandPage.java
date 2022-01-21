package com.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import pages.AbstractBasePage;

public class BrandPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

	public BrandPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Brands']")
	WebElement brands;

	@FindBy(xpath = "//a[text()='Add a New Brand']")
	WebElement addBrand;

	@FindBy(xpath = "//input[@name='brandName']")
	WebElement brandName;

	@FindBy(xpath = "//input[@name='brandCode']")
	WebElement brandCode;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//*[text()='Brand Name already used.']")
	WebElement duplicateError;

	@FindBy(xpath = "//*[text()='Brand Name is required.']")
	WebElement blankBrandName;

	@FindBy(xpath = "//a[text()='RTest']")
	WebElement selectBrand;

	public void openBrands() throws Exception {

		brands.click();
		Thread.sleep(2000);
	}

	public BrandPage createNewBrand() throws Exception {

		addBrand.click();
		brandName.sendKeys(e.getCellData("Brand", "BrandName", 2));
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
		return null;
	}

	public boolean verifyBrandCreated() throws Throwable {
		String bName = e.getCellData("Brand", "BrandName", 2);
		WebElement w = driver.findElement(By.xpath("//a[text()='" + bName + "']"));
//		WebElement w = driver.findElement(By.xpath("//*[text()='A2']"));
		if (w.isDisplayed()) {
			System.out.println("Brand Created");
			return true;
		} else {
			System.out.println("Brand not Created");
			return false;
		}
	}

	public BrandPage duplicateBrand() throws Exception {

		addBrand.click();
		brandName.sendKeys(e.getCellData("Brand", "BrandName", 2));
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
		return null;
	}

	public String verifyDuplicateBrand() throws Exception {

		String s = duplicateError.getText();
		return s;
	}

	public BrandPage blankBrandName() throws Exception {

		addBrand.click();
//		BrandName.sendKeys(e.getCellDataUZA("Brand", "BrandName", 2));
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
		return null;
	}

	public String verifyBlankBrandName() throws Exception {

		String s = blankBrandName.getText();
		return s;
	}

	public BrandPage brandSelect() {
		selectBrand.click();
		return null;
	}

}

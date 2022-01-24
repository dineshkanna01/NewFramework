package com.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
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
	
	@FindBy(xpath = "//input[@value = 'Cancel']")
	WebElement cancelButton;

	public void openBrands() throws Exception {
		TestBase.implict(3);
		brands.click();
		TestBase.implict(3);
	}

	public BrandPage createNewBrand() throws Exception {
		TestBase.implict(3);
		addBrand.click();
		TestBase.implict(3);
		brandName.sendKeys(e.getCellData("Brand", "BrandName", 2));
		TestBase.implict(3);
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		TestBase.implict(3);
		saveButton.click();
		TestBase.implict(3);
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
		TestBase.implict(3);
		addBrand.click();
		TestBase.implict(3);
		brandName.sendKeys(e.getCellData("Brand", "BrandName", 2));
		TestBase.implict(3);
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		TestBase.implict(3);
		saveButton.click();
		TestBase.implict(3);
		return null;
	}
	
	public BrandPage cancelButton() throws Exception {
		TestBase.implict(3);
		cancelButton.click();
		TestBase.implict(3);
		return null;
	}

	public String verifyDuplicateBrand() throws Exception {

		String s = duplicateError.getText();
		return s;
	}

	public BrandPage blankBrandName() throws Exception {
		TestBase.implict(3);
		addBrand.click();
		TestBase.implict(3);
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		TestBase.implict(3);
		saveButton.click();
		TestBase.implict(3);
		return null;
	}

	public String verifyBlankBrandName() throws Exception {

		String s = blankBrandName.getText();
		return s;
	}

	public BrandPage brandSelect() {
		TestBase.implict(3);
		selectBrand.click();
		TestBase.implict(3);
		return null;
	}
}

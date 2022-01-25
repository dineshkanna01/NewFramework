package com.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
* POM class to Create Band
* @Author Uzair Asar
*/
public class BrandPage extends AbstractBasePage {
	ExcelData e = new ExcelData();

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

	public BrandPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to open brands
	 */
	
	public void openBrands(){
		TestBase.implict(3);
		brands.click();
		TestBase.implict(3);
	}

	/*
	 * Method to Create a brand
	 */
	
	public BrandPage createNewBrand() {
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

	/*
	 * Method to verify brand created
	 * returns boolean value
	 */
	
	public boolean verifyBrandCreated() {
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

	/*
	 * Method to create brand with duplicate brand name
	 */
	
	public BrandPage duplicateBrand(){
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

	/*
	 * Method to click on cancel button
	 */
	
	public BrandPage cancelButton(){
		TestBase.implict(3);
		cancelButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to verify brand name is duplicate
	 * returns string s
	 */
	
	public String verifyDuplicateBrand(){

		String s = duplicateError.getText();
		return s;
	}

	/*
	 * Method to create brand with blank brand name field
	 */
	
	public BrandPage blankBrandName(){
		TestBase.implict(3);
		addBrand.click();
		TestBase.implict(3);
		brandCode.sendKeys(e.getCellData("Brand", "BrandCode", 2));
		TestBase.implict(3);
		saveButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to verify blank name provided in brand name fields
	 * returns string s
	 */
	
	public String verifyBlankBrandName() {

		String s = blankBrandName.getText();
		return s;
	}

	/*
	 * Method to select a brand
	 */
	
	public BrandPage brandSelect() {
		TestBase.implict(3);
		selectBrand.click();
		TestBase.implict(3);
		return null;
	}
}

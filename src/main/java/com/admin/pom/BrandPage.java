package com.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Helper;
import pages.AbstractBasePage;

/*
* POM class to Create Band
* @Author Uzair Asar
*/
public class BrandPage extends AbstractBasePage {
	
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
	
	@FindBy(xpath = "//a[text()='x'][1]")
	WebElement brandClose;
	
	@FindBy(xpath = "(//a[text()='Edit'])[1]")
	WebElement editBrand;

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
		Helper.implict(3);
		brands.click();
		Helper.implict(3);
	}

	/*
	 * Method to Create a brand
	 */
	
	public BrandPage createNewBrand() {
		Helper.implict(3);
		addBrand.click();
		Helper.implict(3);
		DateFormat dateFormat = new SimpleDateFormat("mmss");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		String f1 ="Uz"+strDate;
		System.out.println(f1);
		brandName.sendKeys(f1);
		Helper.implict(3);
		brandCode.sendKeys(f1);
		Helper.implict(3);
		saveButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify brand created
	 * returns boolean value
	 */
	
	public boolean verifyBrandCreated() {
		if (brandClose.isDisplayed()) {
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
		Helper.implict(3);
		editBrand.click();
		String s = brandName.getAttribute("value");
		String c = brandCode.getAttribute("value");
		System.out.println(s);
		System.out.println(c);
		driver.navigate().back();
		addBrand.click();
		Helper.implict(3);
		brandName.sendKeys(s);
		Helper.implict(3);
		brandCode.sendKeys(c);
		Helper.implict(3);
		saveButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on cancel button
	 */
	
	public BrandPage cancelButton(){
		Helper.implict(3);
		cancelButton.click();
		Helper.implict(3);
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
		Helper.implict(3);
		addBrand.click();
		Helper.implict(3);
		DateFormat dateFormat = new SimpleDateFormat("mmss");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		String f1 ="Uz"+strDate;
		brandCode.sendKeys(f1);
		Helper.implict(3);
		saveButton.click();
		Helper.implict(3);
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
		Helper.implict(3);
		selectBrand.click();
		Helper.implict(3);
		return null;
	}
}

package com.admin.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class NearbyAttractionPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

	public NearbyAttractionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@value='Add New']")
	WebElement addNew;

	@FindBy(xpath="//input[@name='name']")
	WebElement name;

	@FindBy(xpath="//input[@name='category']")
	WebElement category;

	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;

	@FindBy(xpath="//select[@name='selectedCountry']")
	WebElement country;

	@FindBy(xpath="//textarea[@name='address1']")
	WebElement address;

	@FindBy(xpath="//input[@name='zipCode']")
	WebElement zipcode;

	@FindBy(xpath="//a[text()='Find Lat/Long']")
	WebElement findLat;

	@FindBy(xpath="//input[@name='btnSave']") 
	WebElement save;

	@FindBy(xpath="(//a[text()='Edit'])[last()]")
	WebElement edit;

	@FindBy(xpath="//input[@value='Delete']")
	WebElement delete;

	@FindBy(xpath="//input[@value='Yes']")
	WebElement yesButton;

	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement checkbox1;

	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement checkbox2;

	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	WebElement checkbox3;

	@FindBy(xpath="(//input[@type='checkbox'])[4]")
	WebElement checkbox4;

	@FindBy(xpath="(//input[@type='checkbox'])[last()]")
	WebElement lastCheckbox;

    @FindBy(xpath="//td[text()='Shopping mall']")
	WebElement nearbyAttractionName;

	@FindBy(xpath="//td[text()='A2']")
	WebElement nearbyAttractionCategory;
	
	@FindBys(@FindBy(xpath="//table[@id='dataTable']//tr/td[2]"))
	List<WebElement> allNearbyAttraction;


	public NearbyAttractionPage clickAddNew() {
		addNew.click();
		return null;
	}

	public NearbyAttractionPage enterNearbyAttractionName(String attractionName){
		name.sendKeys(attractionName);
		return null;
	}

	public NearbyAttractionPage enterCategory1() throws Exception {
		category.sendKeys(e.getCellData("Sheet1","Category",2));
		return null;
	}

	public NearbyAttractionPage enterCategory2() throws Exception {
		category.sendKeys(e.getCellData("Sheet1","Category",3));
		return null;
	}

	public NearbyAttractionPage clearCategory() {
		category.clear();
		return null;
	}

	public NearbyAttractionPage enterDescription() throws Exception {
		description.sendKeys(e.getCellData("Sheet1","Description",2));
		return null;
	}

	public NearbyAttractionPage selectCountry(String CountryName) {
		Select s=new Select(country);
		s.selectByVisibleText(CountryName);
		return null;
	}

	public NearbyAttractionPage enterAddress() throws Exception {
		address.sendKeys(e.getCellData("Sheet1","Address",2));
		return null;
	}

	public NearbyAttractionPage enterZipcode() throws Exception {
		zipcode.sendKeys(e.getCellData("Sheet1","Zipcode",2));
		return null;
	}

	public NearbyAttractionPage clickFindLat() throws InterruptedException {
		TestBase.implict(5);
		findLat.click();
		Thread.sleep(2000);
		return null;
	}

	public NearbyAttractionPage clickSave() throws InterruptedException {
		save.click();
		TestBase.implict(5);
		return null;
	}

	public NearbyAttractionPage clickYes() {
		yesButton.click();
		return null;
	}

	public NearbyAttractionPage clickEdit() {
		edit.click();
		return null;
	}

	public NearbyAttractionPage clickDelete() {
		delete.click();
		return null;
	}

	public NearbyAttractionPage clickCheckbox1() {
		checkbox1.click();
		return null;
	}

	public NearbyAttractionPage clickCheckbox2() {
		checkbox2.click();
		return null;
	}

	public NearbyAttractionPage clickCheckbox3() {
		checkbox3.click();
		return null;
	}

	public NearbyAttractionPage clickCheckbox4() {
		checkbox4.click();
		return null;
	}

	public NearbyAttractionPage clickLastCheckbox() {
		lastCheckbox.click();
		return null;
	}

	public String nearbyAttraction()  {
		return nearbyAttractionName.getText();
	}

	public String nearbyCategory()  {
		return nearbyAttractionCategory.getText();
	}

	
	public boolean checkNearByAttractionDeleted(String DeletedAttraction) {
		int a=0;
		for (WebElement SingleProp : allNearbyAttraction) {
			String ProName = SingleProp.getText();
			if(ProName.equals(DeletedAttraction)) {
             a++;
			}
		}
		if(a>0) {
			return false;
		}else {
		return true;
		}
   }

}

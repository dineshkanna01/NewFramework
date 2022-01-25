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

/*
 * Pom class for Nearby Attraction Page
 * @author Sudhakar Mourya
 */
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

/*
 * Methd for click on add new
 */
	public NearbyAttractionPage clickAddNew() {
		addNew.click();
		return null;
	}

	/*
	 * Methd for enter nearby attraction name
	 */
	public NearbyAttractionPage enterNearbyAttractionName(String attractionName){
		name.sendKeys(attractionName);
		return null;
	}

	/*
	 * Methd for enter category1
	 */
	public NearbyAttractionPage enterCategory1() {
		category.sendKeys(e.getCellData("Sheet1","Category",2));
		return null;
	}

	/*
	 * Methd for enter category2
	 */
	public NearbyAttractionPage enterCategory2() {
		category.sendKeys(e.getCellData("Sheet1","Category",3));
		return null;
	}

	/*
	 * Methd for clear category
	 */
	public NearbyAttractionPage clearCategory() {
		category.clear();
		return null;
	}

	/*
	 * Methd for enter description
	 */
	public NearbyAttractionPage enterDescription(){
		description.sendKeys(e.getCellData("Sheet1","Description",2));
		return null;
	}

	/*
	 * Methd for select country
	 */
	public NearbyAttractionPage selectCountry(String CountryName) {
		Select s=new Select(country);
		s.selectByVisibleText(CountryName);
		return null;
	}

	/*
	 * Method for enter address
	 */
	public NearbyAttractionPage enterAddress(){
		address.sendKeys(e.getCellData("Sheet1","Address",2));
		return null;
	}

	/*
	 * Method for enter zipcode
	 */
	public NearbyAttractionPage enterZipcode(){
		zipcode.sendKeys(e.getCellData("Sheet1","Zipcode",2));
		return null;
	}

	/*
	 * Method for click on findlat
	 */
	public NearbyAttractionPage clickFindLat() throws InterruptedException{
		TestBase.implict(5);
		findLat.click();
		Thread.sleep(2000);
		return null;
	}

	/*
	 * Method for click on save button
	 */
	public NearbyAttractionPage clickSave(){
		save.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method for click on yes button
	 */
	public NearbyAttractionPage clickYes() {
		yesButton.click();
		return null;
	}

	/*
	 * Method for click on edit button
	 */
	public NearbyAttractionPage clickEdit() {
		edit.click();
		return null;
	}

	/*
	 * Method for click on delete button
	 */
	public NearbyAttractionPage clickDelete() {
		delete.click();
		return null;
	}

	/*
	 * Method for click on checkbox1
	 */
	public NearbyAttractionPage clickCheckbox1() {
		checkbox1.click();
		return null;
	}

	/*
	 * Method for click on checkbox2
	 */
	public NearbyAttractionPage clickCheckbox2() {
		checkbox2.click();
		return null;
	}

	/*
	 * Method for click on checkbox3
	 */
	public NearbyAttractionPage clickCheckbox3() {
		checkbox3.click();
		return null;
	}

	/*
	 * Method for click on checkbox4
	 */
	public NearbyAttractionPage clickCheckbox4() {
		checkbox4.click();
		return null;
	}

	/*
	 * Method for click on last checkbox
	 */
	public NearbyAttractionPage clickLastCheckbox() {
		lastCheckbox.click();
		return null;
	}

	/*
	 * Method for getting administrator name text
	 * @return String administrator name
	 */
	public String nearbyAttraction()  {
		return nearbyAttractionName.getText();
	}

	/*
	 * Method for getting nearby category text
	 * @return String category text
	 */
	public String nearbyCategory()  {
		return nearbyAttractionCategory.getText();
	}

	/*
	 * Method for checking nearby attraction deleted
	 */
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

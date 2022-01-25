package com.admin.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * Pom class for Alternate Properties
 * @author Sudhakar Mourya
 */
public class AlternatePropertiesPage extends AbstractBasePage {
	ExcelData e = new ExcelData();


	public AlternatePropertiesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Add Property']")
	WebElement addProperty;

	@FindBy(xpath="//input[@name='propertyCode']")
	WebElement propertyCode;

	@FindBy(xpath="//input[@value='Save']")
	WebElement save;

	@FindBy(xpath="(//input[@type='checkbox'])[1]") 
	WebElement checkBox1;

	@FindBy(xpath="(//input[@type='checkbox'])[last()]") 
	WebElement lastCheckBox;

	@FindBy(xpath="(//input[@type='checkbox'])[2]") 
	WebElement checkBox2;

	@FindBy(xpath="(//input[@type='checkbox'])[3]") 
	WebElement checkBox3;

	@FindBy(xpath="(//input[@type='checkbox'])[4]") 
	WebElement checkBox4;

	@FindBy(xpath="(//input[@type='checkbox'])[5]") 
	WebElement checkBox5;

	@FindBy(xpath="//input[@value='Delete']")
	WebElement delete;

	@FindBy(xpath="//table[@width='600']/tbody//tr[2]/td[2]")
	WebElement propName;

	@FindBy(xpath="//li[text()='Invalid property code.']")
	WebElement invalidPropErrorMsg;

	@FindBys(@FindBy(xpath="//table[@width='600']//tr/td[2]"))
	List<WebElement> allProperty;
/*
 * Method for click on add property
 */
	public AlternatePropertiesPage clickAddProperty() {
		addProperty.click();
		TestBase.implict(3);
		return null; 
	}

	/*
	 * Method for enter property code
	 */
	public AlternatePropertiesPage enterPropertyCode1(){
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",2));
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method for enter property code
	 */
	public AlternatePropertiesPage enterPropertyCode2(){
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",3));
		TestBase.implict(3);
		return null;
	}
	
	/*
	 * Method for enter invalid property code
	 */
	public AlternatePropertiesPage enterInvalidPropertyCode(){
		propertyCode.sendKeys(e.getCellData("Sheet1","InvalidPropCode",2));
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method for click on yes button
	 */
	public AlternatePropertiesPage clickSaveButton(){
		save.click();
		return null;
	}

	/*
	 * Method for add multiple property
	 */
	public AlternatePropertiesPage addMultipleProp(){
		addProperty.click();
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",4));
		save.click();
		addProperty.click();
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",5));
		save.click();
		addProperty.click();
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",6));
		save.click();
		return null;
	}
	
	/*
	 * Method for click on last checkbox
	 */
    public AlternatePropertiesPage clickLastCheckBox() {
		lastCheckBox.click();
		TestBase.implict(3);
		return null;
	}
    
    /*
	 * Method for click on multiple checkbox
	 */
	public AlternatePropertiesPage clickMultipleCheckBox() {
		checkBox2.click();
		TestBase.implict(3);

		checkBox3.click();
		TestBase.implict(3);

		checkBox4.click();
		TestBase.implict(3);
		return null;
	}
	
	/*
	 * Method for click on delete button
	 */
    public AlternatePropertiesPage clickDeleteButton(){
		delete.click();
		driver.switchTo().alert().accept();
		TestBase.implict(5);
		return null;
	}

    /*
	 * Method for getting property name text
	 * @return String property name
	 */
	public String propertyName()  {
		return propName.getText();
	}

	  /*
	   * Method for getting invalid property code text
	   * @return String error msg
	   */
	public String invalidPropCode(){
		return invalidPropErrorMsg.getText();
	}
     
	    /*
		 * Method for checking deleted property
		 */
	public boolean checkPropertyDeleted(String DeletedPropName) {
		int a=0;
		for (WebElement SingleProp : allProperty) {
			String ProName = SingleProp.getText();
			if(ProName.equals(DeletedPropName)) {
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

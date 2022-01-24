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

	public AlternatePropertiesPage clickAddProperty() {
		addProperty.click();
		TestBase.implict(3);
		return null; 
	}

	public AlternatePropertiesPage enterPropertyCode1() throws Exception {
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",2));
		TestBase.implict(3);
		return null;
	}

	public AlternatePropertiesPage enterPropertyCode2() throws Exception {
		propertyCode.sendKeys(e.getCellData("Sheet1","PropCode",3));
		TestBase.implict(3);
		return null;
	}
	
	public AlternatePropertiesPage enterInvalidPropertyCode() throws Exception {
		propertyCode.sendKeys(e.getCellData("Sheet1","InvalidPropCode",2));
		TestBase.implict(3);
		return null;
	}

	public AlternatePropertiesPage clickSaveButton() throws InterruptedException {
		save.click();
		return null;
	}

	public AlternatePropertiesPage addMultipleProp() throws Exception {
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
    public AlternatePropertiesPage clickLastCheckBox() {
		lastCheckBox.click();
		TestBase.implict(3);
		return null;
	}
	public AlternatePropertiesPage clickMultipleCheckBox() {
		checkBox2.click();
		TestBase.implict(3);

		checkBox3.click();
		TestBase.implict(3);

		checkBox4.click();
		TestBase.implict(3);
		return null;
	}
	
    public AlternatePropertiesPage clickDeleteButton() throws InterruptedException {
		delete.click();
		driver.switchTo().alert().accept();
		TestBase.implict(5);
		return null;
	}

	public String propertyName()  {
		return propName.getText();
	}

	public String invalidPropCode() throws Exception {
		return invalidPropErrorMsg.getText();
	}

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

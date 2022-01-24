package com.admin.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class AddOnsPage extends AbstractBasePage {
	ExcelData e = new ExcelData();

	public AddOnsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameTextField;

	@FindBy(xpath = "//input[@name='code']")
	WebElement codeTextField;

	@FindBy(xpath = "//textarea[@name='shortDesc']")
	WebElement shortDescriptionTextField;

	@FindBy(xpath = "//input[@name='price']")
	WebElement priceField;

	@FindBy(xpath = "//*[@name='save' and @class='input']")
	WebElement savebutton;

	@FindBy(xpath = "(//*[@type='checkbox'])[last()]")
	WebElement selectCheckbox;

	@FindBy(xpath = "//*[@name='delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//*[@value='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "//*[text()='Duplicate Code']")
	WebElement duplicate;

	@FindBy(xpath = "//input[@type='radio' and @value='true']")
	WebElement addOnActive;

	@FindBy(name = "addOnStartDate")
	WebElement addOnStartDate;

	@FindBy(xpath = "(//*[contains(@href,'/admin/action/editAddOn.do')])[last()]")
	WebElement e2;

	@FindBy(xpath = "//li[text()='No Add On available ']")
	WebElement e3;
	
	@FindBy(xpath = "//*[@value='Cancel']")
	WebElement cancelButton;

	public AddOnsPage inputTextFieldsAddOnsTc01() throws Exception {
		nameTextField.click();

		nameTextField.sendKeys(e.getCellData("AddOnsData", "Name_TC01", 2));
		TestBase.implict(2);

		codeTextField.sendKeys(e.getCellData("AddOnsData", "Code_TC01", 2));
		TestBase.implict(2);

		shortDescriptionTextField.sendKeys(e.getCellData("AddOnsData", "ShortDescription_TC01", 2));
		TestBase.implict(2);

		priceField.sendKeys(e.getCellData("AddOnsData", "Price_TC01", 2));
		TestBase.implict(2);
		return null;
	}

	public AddOnsPage inputTextFieldsAddOnsTc02() throws Exception {
		nameTextField.click();

		nameTextField.sendKeys(e.getCellData("AddOnsData", "Name_TC02", 2));
		TestBase.implict(2);

		codeTextField.sendKeys(e.getCellData("AddOnsData", "Code_TC02", 2));
		TestBase.implict(2);

		shortDescriptionTextField.sendKeys(e.getCellData("AddOnsData", "ShortDescription_TC02", 2));
		TestBase.implict(2);

		priceField.sendKeys(e.getCellData("AddOnsData", "Price_TC02", 2));
		TestBase.implict(2);

		return null;
	}

	public AddOnsPage inputTextFieldsAddOnsTc03() throws Exception {
		nameTextField.click();

		nameTextField.sendKeys(e.getCellData("AddOnsData", "Name_TC03", 2));
		TestBase.implict(2);

		codeTextField.sendKeys(e.getCellData("AddOnsData", "Code_TC03", 2));
		TestBase.implict(2);

		shortDescriptionTextField.sendKeys(e.getCellData("AddOnsData", "ShortDescription_TC03", 2));
		TestBase.implict(2);

		priceField.sendKeys(e.getCellData("AddOnsData", "Price_TC03", 2));
		TestBase.implict(2);

		return null;
	}

	public AddOnsPage inputTextFieldsAddOnsRatePlan() throws Exception {
		nameTextField.click();

		nameTextField.sendKeys(e.getCellData("AddOnsData", "Name_TC02", 2));
		TestBase.implict(2);

		codeTextField.sendKeys(e.getCellData("AddOnsData", "Code_TC02", 2));
		TestBase.implict(2);

		shortDescriptionTextField.sendKeys(e.getCellData("AddOnsData", "ShortDescription_TC02", 2));
		TestBase.implict(2);

		priceField.sendKeys(e.getCellData("AddOnsData", "Price_TC02", 2));
		TestBase.implict(2);

		addOnActive.click();

		addOnStartDate.sendKeys(e.getCellData("RatePlanPageData", "AddOnStartDate", 2));

		return null;
	}

	public AddOnsPage clickOnSave() throws InterruptedException {
		savebutton.click();
		TestBase.implict(4);

		return null;
	}

	public boolean verifyAddOnName_tc01() throws Exception {

		if (e2.isDisplayed()) {
			String AddOnName = e2.getText();
			System.out.println(AddOnName + ": AddOn created");
			return true;

		} else
			return false;
	}

	public boolean verifyAddOnName_tc02() throws Exception {
		if (e2.isDisplayed()) {
			String AddOnName = e2.getText();
			System.out.println(AddOnName + ": AddOn created");
			return true;

		} else
			return false;
	}

	public boolean verifyAddOnName_tc03() throws Exception {
		if (e2.isDisplayed()) {
			String AddOnName = e2.getText();
			System.out.println(AddOnName + ": AddOn created");
			return true;

		} else
			return false;
	}

	public boolean verifyAddOnName_Delete() throws Exception {
		if (e3.isDisplayed()) {
			System.out.println("Add-On is Deleted");
			return true;
		} else
			return false;
	}


	public AddOnsPage clickOnCheckbox() throws InterruptedException {
		selectCheckbox.click();
		TestBase.implict(2);
		return null;
	}

	public AddOnsPage clickOnDelete() throws InterruptedException {
		deleteButton.click();
		TestBase.implict(2);
		return null;
	}

	public AddOnsPage clickOnYes() throws InterruptedException {
		yesButton.click();
		TestBase.implict(2);
		return null;
	}

	public boolean verifyDuplicate_tc03() throws Exception {

		String Duplicate = driver.findElement(By.xpath("//*[text()='Duplicate Code']")).getText();
		Duplicate = Duplicate.replaceAll("\\s+", "");
		System.out.println(Duplicate + "####");

		String error = "Duplicate Code";
		error = error.replaceAll("\\s+", "");

		System.out.println(error + "$$$");

		if (Duplicate.equals(error)) {
			System.out.println("error- Duplicate Code");
		}
		return true;

	}

	public AddOnsPage clickOnCancel() throws InterruptedException {
		cancelButton.click();
		driver.findElement(By.xpath("//*[@id='7']/li[1]/a")).click();
		TestBase.implict(3);

		return null;
	}
}

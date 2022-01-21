package com.admin.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class RatePlanCategoriesPage extends AbstractBasePage{

	ExcelData e = new ExcelData();

	public RatePlanCategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//*[@name='Submit3']")
	WebElement saveButton;

	@FindBy(xpath = "//*[@id='addNewCategoryButton']/input")
	WebElement addNewCategoryButton;

	@FindBy(xpath = "//input[@name='categoryName']")
	WebElement categoryName;

	@FindBy(xpath = "(//*[@name='editCategoryLink'])[1]")
	WebElement verifyCategoryName;
	
	@FindBy(xpath = "(//*[@name='deleteCategoryLink'])[1]")
	WebElement deleteCategory;
	
	@FindBy(xpath = "//*[@id='showSuccessMessage']")
	WebElement verifyMessageDelete;

	public RatePlanCategoriesPage selectRadioButton() throws InterruptedException {
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("true"))
				radbut.get(i).click();
			TestBase.implict(2);

		}
		return null;
	}
	
	public RatePlanCategoriesPage selectRadioButtonNo() throws InterruptedException {
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("false"))
				radbut.get(i).click();
			TestBase.implict(2);

		}
		return null;
	}

	public RatePlanCategoriesPage clickOnSave() throws InterruptedException {
		saveButton.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyAddNewCategory() throws InterruptedException {
		try {
		if (addNewCategoryButton.isDisplayed()) {
			System.out.println("Add New Category option is visible");
			return true;
		} else {
			System.out.println("Add New Category option is not visible");
			return false;
		}
		}
		catch(Exception e) {
			System.out.println("Add New Rate plan category option is already enabled");	
			return true;
		}
		
	}

	public RatePlanCategoriesPage inputfields_tc02() throws Exception {
		addNewCategoryButton.click();
		TestBase.implict(1);
		categoryName.sendKeys(e.getCellData("RatePlanCategoriesData", "CategoryName", 2));
		return null;

	}
	public RatePlanCategoriesPage inputfields_tc03() throws Exception {
		addNewCategoryButton.click();
		TestBase.implict(1);
		categoryName.sendKeys(e.getCellData("RatePlanCategoriesData", "CategoryNameTC_03", 2));
		return null;

	}

	public boolean verifyName() throws Exception {
		String CName = verifyCategoryName.getText();
		CName = CName.replaceAll("\\s+", "");
		System.out.println(CName + "####");

		String ExcelCategoryName = e.getCellData("RatePlanCategoriesData", "CategoryName", 2);
		ExcelCategoryName = ExcelCategoryName.replaceAll("\\s+", "");

		System.out.println(ExcelCategoryName + "$$$");

		if (CName.equals(ExcelCategoryName)) {
			System.out.println("Category created");
			return true;
		} else {
			System.out.println("Category Deleted");
			return false;

		}
	}
	public boolean verifyName_tc03() throws Exception {
		String CName = verifyCategoryName.getText();
		CName = CName.replaceAll("\\s+", "");
		System.out.println(CName + "####");

		String ExcelCategoryName = e.getCellData("RatePlanCategoriesData", "CategoryNameTC_03", 2);
		ExcelCategoryName = ExcelCategoryName.replaceAll("\\s+", "");

		System.out.println(ExcelCategoryName + "$$$");

		if (CName.equals(ExcelCategoryName)) {
			System.out.println("Category created");
			return true;
		} else {
			System.out.println("Category Deleted");
			return false;

		}
	}

	public RatePlanCategoriesPage deleteCategory() throws InterruptedException {
		deleteCategory.click();    
        Alert alert = driver.switchTo().alert();		
        alert.accept();	
    	Thread.sleep(3000);
        
		return null;
	}
	
	public boolean verifyMessage() throws InterruptedException {
		if (verifyMessageDelete.isDisplayed()) {
			System.out.println("Category is Deleted");
			return true;
		} else {
			System.out.println("Category is not Deleted");
			return false;
		}
	}

}

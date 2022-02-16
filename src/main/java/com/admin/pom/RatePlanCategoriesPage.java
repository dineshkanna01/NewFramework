package com.admin.pom;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;
/*
 * Pom class for Rate plan categories
 * @author Rudraksh Aggarwal
 */
public class RatePlanCategoriesPage extends AbstractBasePage{
	
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
	
	public RatePlanCategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	 * Method to select radio button
	 */
	public RatePlanCategoriesPage selectRadioButton() {
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("true"))
				radbut.get(i).click();
			Helper.implict(2);
		}
		return null;
	}
	/*
	 * Method to select radio button
	 */
	public RatePlanCategoriesPage selectRadioButtonNo() {
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("false"))
				radbut.get(i).click();
			Helper.implict(2);
		}
		return null;
	}
	/*
	 * Method to click on save button
	 */
	public RatePlanCategoriesPage clickOnSave() {
		saveButton.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to verify add new category
	 * 
	 * @return boolean value
	 */
	public boolean verifyAddNewCategory() {
		try {
			if (addNewCategoryButton.isDisplayed()) {
				System.out.println("Add New Category option is visible");
				return true;
			} else {
				System.out.println("Add New Category option is not visible");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Add New Rate plan category option is already enabled");
			return true;
		}
	}
	/*
	 * Method to input fields for TC02
	 */
	public RatePlanCategoriesPage inputfields_tc02() {
		addNewCategoryButton.click();
		Helper.implict(1);
		categoryName.sendKeys(ExcelData.getCellData("RatePlanCategoriesData", "CategoryName", 2));
		return null;
	}
	/*
	 * Method to input fields for TC03
	 */
	public RatePlanCategoriesPage inputfields_tc03() {
		addNewCategoryButton.click();
		Helper.implict(1);
		categoryName.sendKeys(ExcelData.getCellData("RatePlanCategoriesData", "CategoryNameTC_03", 2));
		return null;
	}
	/*
	 * Method to verify policy name
	 * 
	 * @return boolean value
	 */
	public boolean verifyName() {
		String CName = verifyCategoryName.getText();
		CName = CName.replaceAll("\\s+", "");
		System.out.println(CName + "####");
		String ExcelCategoryName = ExcelData.getCellData("RatePlanCategoriesData", "CategoryName", 2);
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
	/*
	 * Method to verify policy name TC03
	 * 
	 * @return boolean value
	 */
	public boolean verifyName_tc03() {
		String CName = verifyCategoryName.getText();
		CName = CName.replaceAll("\\s+", "");
		System.out.println(CName + "####");
		String ExcelCategoryName = ExcelData.getCellData("RatePlanCategoriesData", "CategoryNameTC_03", 2);
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
	/*
	 * Method to delete Category
	 */
	public RatePlanCategoriesPage deleteCategory() {
		try {
			deleteCategory.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * Method to verify delete message
	 * 
	 * @return boolean value
	 */
	public boolean verifyMessage() {
		if (verifyMessageDelete.isDisplayed()) {
			System.out.println("Category is Deleted");
			return true;
		} else {
			System.out.println("Category is not Deleted");
			return false;
		}
	}
}

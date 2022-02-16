package com.admin.pom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;
/*
 * Pom class for Add-Ons
 * @author Rudraksh Aggarwal
 */
public class AddOnsPage extends AbstractBasePage {
	
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
	
	public AddOnsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	 * Method to input data in fields for TC01
	 */
	public AddOnsPage inputTextFieldsAddOnsTc01() {
		nameTextField.click();
		nameTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Name_TC01", 2));
		Helper.implict(2);
		codeTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Code_TC01", 2));
		Helper.implict(2);
		shortDescriptionTextField.sendKeys(ExcelData.getCellData("AddOnsData", "ShortDescription_TC01", 2));
		Helper.implict(2);
		priceField.sendKeys(ExcelData.getCellData("AddOnsData", "Price_TC01", 2));
		Helper.implict(2);
		return null;
	}
	
	/*
	 * Method to input data in fields for TC02
	 */
	public AddOnsPage inputTextFieldsAddOnsTc02() {
		nameTextField.click();
		nameTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Name_TC02", 2));
		Helper.implict(2);
		codeTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Code_TC02", 2));
		Helper.implict(2);
		shortDescriptionTextField.sendKeys(ExcelData.getCellData("AddOnsData", "ShortDescription_TC02", 2));
		Helper.implict(2);
		priceField.sendKeys(ExcelData.getCellData("AddOnsData", "Price_TC02", 2));
		Helper.implict(2);
		return null;
	}
	
	/*
	 * Method to input data in fields for TC03
	 */
	public AddOnsPage inputTextFieldsAddOnsTc03() {
		nameTextField.click();
		nameTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Name_TC03", 2));
		Helper.implict(2);
		codeTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Code_TC03", 2));
		Helper.implict(2);
		shortDescriptionTextField.sendKeys(ExcelData.getCellData("AddOnsData", "ShortDescription_TC03", 2));
		Helper.implict(2);
		priceField.sendKeys(ExcelData.getCellData("AddOnsData", "Price_TC03", 2));
		Helper.implict(2);
		return null;
	}
	
	/*
	 * Method to input data for creating AddOn to be included in rate plan
	 */
	public AddOnsPage inputTextFieldsAddOnsRatePlan() {
		nameTextField.click();
		nameTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Name_TC02", 2));
		Helper.implict(2);
		codeTextField.sendKeys(ExcelData.getCellData("AddOnsData", "Code_TC02", 2));
		Helper.implict(2);
		shortDescriptionTextField.sendKeys(ExcelData.getCellData("AddOnsData", "ShortDescription_TC02", 2));
		Helper.implict(2);
		priceField.sendKeys(ExcelData.getCellData("AddOnsData", "Price_TC02", 2));
		Helper.implict(2);
		addOnActive.click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		System.out.println(strDate+"*****");
		addOnStartDate.sendKeys(strDate);
		return null;
	}
	
	/*
	 * Method to click on Save of AddOn
	 */
	public AddOnsPage clickOnSave() {
		savebutton.click();
		Helper.implict(4);
		return null;
	}
	
	/*
	 * Method to Verify the created AddOn
	 * @return boolean value
	 */
	public boolean verifyAddOnName() {
		if (e2.isDisplayed()) {
			String AddOnName = e2.getText();
			System.out.println(AddOnName + ": AddOn created");
			return true;
		} else
			return false;
	}
	
	/*
	 * Method to Verify the deleted AddOn
	 * @return boolean value
	 */
	public boolean verifyAddOnName_Delete() {
		if (e3.isDisplayed()) {
			System.out.println("Add-On is Deleted");
			return true;
		} else
			return false;
	}
	
	/*
	 * Method to select the AddOn
	 */
	public AddOnsPage clickOnCheckbox() {
		selectCheckbox.click();
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to click on Delete button
	 */
	public AddOnsPage clickOnDelete() {
		deleteButton.click();
		Helper.implict(2);
		return null;
	}
	
	/*
	 * Method to click on Yes button
	 */
	public AddOnsPage clickOnYes() {
		yesButton.click();
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to verify the Duplicate error message
	 * @return boolean value
	 */
	public boolean verifyDuplicate_tc03() {
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
	
	/*
	 * Method to click on Cancel button
	 */
	public AddOnsPage clickOnCancel() {
		cancelButton.click();
		driver.findElement(By.xpath("//*[@id='7']/li[1]/a")).click();
		Helper.implict(3);
		return null;
	}
}

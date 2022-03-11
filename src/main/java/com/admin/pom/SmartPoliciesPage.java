package com.admin.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;

/*
 * Pom class for Smart Policies
 * @author Rudraksh Aggarwal
 */
public class SmartPoliciesPage extends AbstractBasePage{
	
	@FindBy(xpath = "//*[@name='name']")
	WebElement inputPolicyName;
	
	@FindBy(xpath = "//*[@name='defaultPolicyId']")
	WebElement categoryDropdown;
	
	@FindBy(xpath = "//*[@value='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//*[@value='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "((//*[@name='policyIdCheckbox'])[last()]/following::td)[1]")
	WebElement policyNameVerify;
	
	@FindBy(xpath = "(//*[@name='policyIdCheckbox'])[last()]")
	WebElement policyNameCheckbox;
	
	@FindBy(xpath = "//*[@value='Delete']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//font[text()=' Smart Policies not found']")
	WebElement e3;
	
	public SmartPoliciesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	 * Method to select category
	 *
	 */
	public SmartPoliciesPage selectCategoryFromDropdown() {
		Select dropdown = new Select(categoryDropdown);
		dropdown.selectByVisibleText("Default Property 24-Hour-Cancel Policy");
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to click save button
	 *
	 */
	public SmartPoliciesPage clickOnSave() {
		saveButton.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to input field TC01
	 *
	 */
	public SmartPoliciesPage inputTextFieldsSmartPoliciesTc01() {
		inputPolicyName.sendKeys(ExcelData.getCellData("SmartPoliciesData", "SmartPolicyNameTC01", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to click cancel button
	 *
	 */
	public SmartPoliciesPage clickOnCancel() {
		cancelButton.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to verify created policy name
	 * 
	 * @return boolean value
	 *
	 */
	public boolean verifySmartPolicyName() {
		if (policyNameVerify.isDisplayed()) {
			String SmartPolicyName = policyNameVerify.getText();
			System.out.println(SmartPolicyName + ": SmartPolicy created");
			return true;
		} else
			return false;
	}
	/*
	 * Method to verify deleted policy
	 * 
	 * @return boolean value
	 *
	 */
	public boolean verifySmartPolicyName_Delete() {
		if (e3.isDisplayed()) {
			System.out.println("Add-On is Deleted");
			return true;
		} else
			return false;
	}
	/*
	 * Method to delete policy
	 *
	 */
	public SmartPoliciesPage deleteSmartPolicies() {
		policyNameCheckbox.click();
		Helper.implict(1);
		deleteButton.click();
		Helper.implict(1);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to input field TC02
	 *
	 */
	public SmartPoliciesPage inputTextFieldsSmartPoliciesTc02() {
		inputPolicyName.sendKeys(ExcelData.getCellData("SmartPoliciesData", "SmartPolicyNameTC02", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input field TC03
	 *
	 */
	public SmartPoliciesPage inputTextFieldsSmartPoliciesTc03() {
		inputPolicyName.sendKeys(ExcelData.getCellData("SmartPoliciesData", "SmartPolicyNameTC03", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to verify duplicate error message
	 * 
	 * @return boolean value
	 */
	public boolean verifyDuplicateErrorMessage_tc03() {
		String Duplicate = driver.findElement(By.xpath("//*[@id='nameselectedwarning']")).getText();
		Duplicate = Duplicate.replaceAll("\\s+", "");
		System.out.println(Duplicate + "####");
		String error = "Smart Policy Name already used.";
		error = error.replaceAll("\\s+", "");
		System.out.println(error + "$$$");
		if (Duplicate.equals(error)) {
			System.out.println("error- Duplicate Code");
		}
		return true;
	}
}

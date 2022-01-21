package com.admin.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class SmartPoliciesPage extends AbstractBasePage{
	
	ExcelData e = new ExcelData();

	public SmartPoliciesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

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
	
	public SmartPoliciesPage selectCategoryFromDropdown() throws InterruptedException {
		
		Select dropdown = new Select(categoryDropdown);
		dropdown.selectByVisibleText("Default Property 24-Hour-Cancel Policy");
		TestBase.implict(1);

		return null;
		
	}

	public SmartPoliciesPage clickOnSave() throws InterruptedException {
		saveButton.click();
		TestBase.implict(3);

		return null;
	}
	
	public SmartPoliciesPage inputTextFieldsSmartPoliciesTc01() throws Exception {
		inputPolicyName.sendKeys(e.getCellData("SmartPoliciesData", "SmartPolicyNameTC01", 2));
		TestBase.implict(1);

		return null;
	}
	
	public SmartPoliciesPage clickOnCancel() throws InterruptedException {
		cancelButton.click();
		TestBase.implict(3);

		return null;
	}
	
	
	public boolean verifySmartPolicyName_tc01() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("SmartPoliciesData", "SmartPolicyNameTC01", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Smart Policy Created");
			return true;
		} else {
			System.out.println("Smart Policy not found after deletion");
			return false;

		}
	}
	
	public SmartPoliciesPage deleteSmartPolicies() throws Exception {
		policyNameCheckbox.click();
		Thread.sleep(1000);
		deleteButton.click();
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();		
        alert.accept();	
        Thread.sleep(3000);
		return null;
	}
	
	
	public SmartPoliciesPage inputTextFieldsSmartPoliciesTc02() throws Exception {
		inputPolicyName.sendKeys(e.getCellData("SmartPoliciesData", "SmartPolicyNameTC02", 2));
		TestBase.implict(1);
		return null;
	}
	public boolean verifySmartPolicyName_tc02() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("SmartPoliciesData", "SmartPolicyNameTC02", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Smart Policy Created");
			return true;
		} else {
			System.out.println("Smart Policy not found after deletion");
			return false;

		}
	}
	
	public SmartPoliciesPage inputTextFieldsSmartPoliciesTc03() throws Exception {
		inputPolicyName.sendKeys(e.getCellData("SmartPoliciesData", "SmartPolicyNameTC03", 2));
		TestBase.implict(1);
		return null;
	}
	public boolean verifySmartPolicyName_tc03() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("SmartPoliciesData", "SmartPolicyNameTC03", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Smart Policy Created");
			return true;
		} else {
			System.out.println("Smart Policy not found after deletion");
			return false;

		}
	}
	
	public boolean verifyDuplicateErrorMessage_tc03() throws Exception {

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

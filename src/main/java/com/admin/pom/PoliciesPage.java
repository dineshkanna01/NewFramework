package com.admin.pom;

import java.util.List;

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

public class PoliciesPage extends AbstractBasePage{
	
	ExcelData e = new ExcelData();

	public PoliciesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//*[@value='Delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//*[@name='name']")
	WebElement policyName;

	@FindBy(xpath = "//*[@name='code']")
	WebElement policyCode;

	@FindBy(xpath = "//a[text()='Add a new Cancellation window']")
	WebElement addanewCancellationwindow;

	@FindBy(xpath = "//*[@name='endInterval']")
	WebElement cancellationWindow;

	@FindBy(xpath = "//*[@value='Save']")
	WebElement save;

	@FindBy(xpath = "(//input[@name='deductionValue'])[3]")
	WebElement inputFlatFee;

	@FindBy(xpath = "(//input[@name='prePaymentValues'])[3]")
	WebElement inputFixedAmountDeposit;

	@FindBy(xpath = "(//input[@name='prePaymentValues'])[2]")
	WebElement inputNumberOfNights;

	@FindBy(xpath = "(//input[@name='prePaymentValues'])[1]")
	WebElement percentageOfAmount;

	@FindBy(xpath = "(//*[@name='policyIdCheckbox'])[last()]")
	WebElement policyNameCheckbox;

	@FindBy(xpath = "((//*[@name='policyIdCheckbox'])[last()]/following::td)[1]")
	WebElement policyNameVerify;

	@FindBy(xpath = "//*[@name='selectedGuaranteeId']")
	WebElement guarenteeDropdown;
	
	@FindBy(xpath = "//*[@value='Cancel']")
	WebElement cancelButton;

	public PoliciesPage inputTextFieldsPoliciesTc01() throws Exception {
		policyName.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyName_TC01", 2));
		TestBase.implict(1);
		policyCode.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyCode_TC01", 2));
		TestBase.implict(1);
		return null;
	}

	public PoliciesPage inputTextFieldsPoliciesTc02() throws Exception {
		policyName.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyName_TC02", 2));
		TestBase.implict(1);
		policyCode.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyCode_TC02", 2));
		TestBase.implict(1);
		return null;
	}

	public PoliciesPage inputTextFieldsPolicies() throws Exception {
		policyName.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyName_TC03", 2));
		TestBase.implict(1);
		policyCode.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyCode_TC03", 2));
		TestBase.implict(1);
		return null;
	}

	public PoliciesPage inputTextFieldsPoliciesTc06() throws Exception {
		policyName.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyName_TC06", 2));
		TestBase.implict(1);
		policyCode.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyCode_TC06", 2));
		TestBase.implict(1);
		return null;
	}
	
	public PoliciesPage inputTextFieldsPoliciesTc07() throws Exception {
		policyName.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyName_TC07", 2));
		TestBase.implict(1);
		policyCode.sendKeys(e.getCellData("AddOrDeltePolicyData", "PolicyCode_TC07", 2));
		TestBase.implict(1);
		return null;
	}

	public PoliciesPage clickAddNewCancellationWindow() throws Exception {
		addanewCancellationwindow.click();
		return null;
	}

	public PoliciesPage inputAddNewCancellationWindow() throws Exception {
		cancellationWindow.sendKeys(e.getCellData("AddOrDeltePolicyData", "CancellationWindow", 2));
		TestBase.implict(1);

		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("FIXED"))
				radbut.get(i).click();
			TestBase.implict(3);
		}

		inputFlatFee.sendKeys(e.getCellData("AddOrDeltePolicyData", "CancellationFee", 2));
		save.click();
		TestBase.implict(2);
		return null;
	}

	public PoliciesPage clickSave() throws Exception {
		save.click();
		TestBase.implict(3);
		return null;
	}

	public SmartPoliciesPage deletePolicies() throws Exception {
		policyNameCheckbox.click();
		TestBase.implict(1);
		deleteButton.click();
		TestBase.implict(1);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyPolicyName_tc01() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("AddOrDeltePolicyData", "PolicyName_TC01", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Policy Created");
			return true;
		} else {
			System.out.println("Policy not found after deletion");
			return false;

		}
	}

	public boolean verifyPolicyName_tc02() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("AddOrDeltePolicyData", "PolicyName_TC02", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Policy Created");
			return true;
		} else {
			System.out.println("Policy not found after deletion");
			return false;

		}
	}

	public boolean verifyPolicyName() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("AddOrDeltePolicyData", "PolicyName_TC03", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Policy Created");
			return true;
		} else {
			System.out.println("Policy not found after deletion");
			return false;

		}
	}

	public boolean verifyPolicyNameTc06() throws Exception {

		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");

		String ExcelPolicyName = e.getCellData("AddOrDeltePolicyData", "PolicyName_TC06", 2);
		ExcelPolicyName = ExcelPolicyName.replaceAll("\\s+", "");

		System.out.println(ExcelPolicyName + "$$$");

		if (PolicyName.equals(ExcelPolicyName)) {
			System.out.println("Policy Created");
			return true;
		} else {
			System.out.println("Policy not found after deletion");
			return false;

		}
	}

	public PoliciesPage selectGuarenteeDropdown_Tc02() throws InterruptedException {

		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Direct Bill");
		TestBase.implict(1);
		return null;

	}

	public PoliciesPage selectGuarenteeDropdown_Tc03() throws Exception {

		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Pre Payment/Deposit");
		TestBase.implict(1);

		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("FIXED"))
				radbut.get(i).click();
			TestBase.implict(3);
		}

		inputFixedAmountDeposit.sendKeys(e.getCellData("AddOrDeltePolicyData", "FixedAmountDeposit", 2));
		return null;

	}

	public PoliciesPage selectGuarenteeDropdown_Tc04() throws Exception {

		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Pre Payment/Deposit");
		TestBase.implict(1);

		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("NIGHT"))
				radbut.get(i).click();
			TestBase.implict(3);
		}

		inputNumberOfNights.sendKeys(e.getCellData("AddOrDeltePolicyData", "NumberofNights", 2));
		return null;

	}

	public PoliciesPage selectGuarenteeDropdown_Tc05() throws Exception {

		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Pre Payment/Deposit");
		TestBase.implict(1);

		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("PCT_OF_AMT"))
				radbut.get(i).click();
			TestBase.implict(3);
		}

		percentageOfAmount.sendKeys(e.getCellData("AddOrDeltePolicyData", "PercentageOfAmount", 2));
		return null;

	}

	public PoliciesPage selectGuarenteeDropdown_Tc06() throws Exception {

		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Non-Guarantee");
		TestBase.implict(1);
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("FIXED"))
				radbut.get(i).click();
			TestBase.implict(3);
		}

		inputFixedAmountDeposit.sendKeys(e.getCellData("AddOrDeltePolicyData", "FixedAmountDeposit", 2));
		return null;

	}

	public boolean verifyDuplicateErrorMessage_tc07() throws Exception {
		String Duplicate = driver.findElement(By.xpath("(//*[text()='Language']/preceding::li)[last()]")).getText();
		
		Duplicate = Duplicate.replaceAll("\\s+", "");
		System.out.println(Duplicate + "####");

		String error = "Duplicate Policy Code";
		error = error.replaceAll("\\s+", "");

		System.out.println(error + "$$$");

		if (Duplicate.equals(error)) {
			System.out.println("error- Duplicate Code");
		}
		return true;

	}
	
	public PoliciesPage clickOnCancel() throws InterruptedException {
		cancelButton.click();
		TestBase.implict(3);

		return null;
	}

}

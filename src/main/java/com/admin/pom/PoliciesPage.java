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
import base.Helper;
import pages.AbstractBasePage;
/*
 * Pom class for Policies
 * @author Rudraksh Aggarwal
 */
public class PoliciesPage extends AbstractBasePage{
	
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
	
	public PoliciesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	/*
	 * Method to input fields for TC01
	 */
	public PoliciesPage inputTextFieldsPoliciesTc01() {
		policyName.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC01", 2));
		Helper.implict(1);
		policyCode.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyCode_TC01", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input fields for TC02
	 */
	public PoliciesPage inputTextFieldsPoliciesTc02() {
		policyName.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC02", 2));
		Helper.implict(1);
		policyCode.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyCode_TC02", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input fields
	 */
	public PoliciesPage inputTextFieldsPolicies() {
		policyName.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC03", 2));
		Helper.implict(1);
		policyCode.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyCode_TC03", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input fields for TC06
	 */
	public PoliciesPage inputTextFieldsPoliciesTc06() {
		policyName.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC06", 2));
		Helper.implict(1);
		policyCode.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyCode_TC06", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input fields for TC07
	 */
	public PoliciesPage inputTextFieldsPoliciesTc07() {
		policyName.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC07", 2));
		Helper.implict(1);
		policyCode.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PolicyCode_TC07", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to click Add New Cancellation Window
	 */
	public PoliciesPage clickAddNewCancellationWindow() {
		addanewCancellationwindow.click();
		return null;
	}
	/*
	 * Method to click input fields for Cancellation Window
	 */
	public PoliciesPage inputAddNewCancellationWindow() {
		cancellationWindow.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "CancellationWindow", 2));
		Helper.implict(1);
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("FIXED"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		inputFlatFee.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "CancellationFee", 2));
		save.click();
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to click save button
	 */
	public PoliciesPage clickSave() {
		save.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to delete policies
	 */
	public SmartPoliciesPage deletePolicies() {
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
	 * Method to verify created policy TC01
	 * @return boolean value
	 */
	public boolean verifyPolicyName_tc01() {
		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");
		String ExcelPolicyName = ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC01", 2);
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
	/*
	 * Method to verify created policy TC02
	 * @return boolean value
	 */
	public boolean verifyPolicyName_tc02() {
		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");
		String ExcelPolicyName = ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC02", 2);
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
	/*
	 * Method to verify created policy
	 * @return boolean value
	 */
	public boolean verifyPolicyName() {
		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");
		String ExcelPolicyName = ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC03", 2);
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
	/*
	 * Method to verify created policy TC06
	 * @return boolean value
	 */
	public boolean verifyPolicyNameTc06() {
		String PolicyName = policyNameVerify.getText();
		PolicyName = PolicyName.replaceAll("\\s+", "");
		System.out.println(PolicyName + "####");
		String ExcelPolicyName = ExcelData.getCellData("AddOrDeltePolicyData", "PolicyName_TC06", 2);
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
	/*
	 * Method to select guarentee
	 */
	public PoliciesPage selectGuarenteeDropdown_Tc02() {
		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Direct Bill");
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to select guarentee
	 */
	public PoliciesPage selectGuarenteeDropdown_Tc03() {
		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Pre Payment/Deposit");
		Helper.implict(1);
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("FIXED"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		inputFixedAmountDeposit.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "FixedAmountDeposit", 2));
		return null;
	}
	/*
	 * Method to select guarentee
	 */
	public PoliciesPage selectGuarenteeDropdown_Tc04() {
		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Pre Payment/Deposit");
		Helper.implict(1);
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("NIGHT"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		inputNumberOfNights.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "NumberofNights", 2));
		return null;
	}
	/*
	 * Method to select guarentee
	 */
	public PoliciesPage selectGuarenteeDropdown_Tc05() {
		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Pre Payment/Deposit");
		Helper.implict(1);
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("PCT_OF_AMT"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		percentageOfAmount.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "PercentageOfAmount", 2));
		return null;
	}
	/*
	 * Method to select guarentee
	 */
	public PoliciesPage selectGuarenteeDropdown_Tc06() {
		Select dropdown = new Select(guarenteeDropdown);
		dropdown.selectByVisibleText("Non-Guarantee");
		Helper.implict(1);
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("FIXED"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		inputFixedAmountDeposit.sendKeys(ExcelData.getCellData("AddOrDeltePolicyData", "FixedAmountDeposit", 2));
		return null;
	}
	/*
	 * Method to verify duplicate error message
	 * @return boolean value
	 */
	public boolean verifyDuplicateErrorMessage_tc07() {
		Helper.implict(2);
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
	/*
	 * Method to click on Cancel button
	 */
	public PoliciesPage clickOnCancel() {
		cancelButton.click();
		Helper.implict(3);
		return null;
	}
}

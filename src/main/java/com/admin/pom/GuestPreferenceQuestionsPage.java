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
public class GuestPreferenceQuestionsPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

	public GuestPreferenceQuestionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//*[@name='selectionType']")
	WebElement selectionTypeDropdown;

	@FindBy(xpath = "//*[@name='selectionType']/option[1]")
	WebElement selectionSingleType;

	@FindBy(xpath = "//*[@name='selectionType']/option[2]")
	WebElement selectionMultipleType;

	@FindBy(xpath = "//*[@name='selectionType']/option[3]")
	WebElement selectionFreeTextType;

	@FindBy(xpath = "//*[@name='questionText']")
	WebElement questionTextField;

	@FindBy(xpath = "//*[@name='questionLabel']")
	WebElement questionLabelTextField;

	@FindBy(xpath = "//*[@id='optionLabel']")
	WebElement option1Label;

	@FindBy(xpath = "//*[@id='optionTextIndex_1']")
	WebElement option1GuestQuestion;

	@FindBy(xpath = "//*[@name='save']")
	WebElement savebutton;

	@FindBy(xpath = "(//a[text()='Delete'])[last()]")
	WebElement deletebutton;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement oKbutton;

	@FindBy(xpath = "(//*[contains(@href,'editQuestion')])[last()]")
	WebElement editButton;
	
	@FindBy(xpath = "//*[@id='dataTable']/tbody/tr[last()]/td[2]")
	WebElement e2;
	
	@FindBy(xpath = "(//*[text()='Guest Preference Questions']/following::font)[last()]")
	WebElement e3;

	public GuestPreferenceQuestionsPage selectSingleType() throws InterruptedException {
		selectionTypeDropdown.click();
		selectionSingleType.click();
		TestBase.implict(5);


		return null;
	}

	public GuestPreferenceQuestionsPage selectMultipleType() throws InterruptedException {
		selectionTypeDropdown.click();
		selectionMultipleType.click();
		TestBase.implict(5);

		return null;
	}

	public GuestPreferenceQuestionsPage selectFreeTextType() throws InterruptedException {
		selectionTypeDropdown.click();
		selectionFreeTextType.click();
		TestBase.implict(5);

		return null;
	}

	public GuestPreferenceQuestionsPage inputTextFieldsSingleType() throws Exception {
		questionTextField.click();
		questionTextField.sendKeys(e.getCellData("GuestPrefQuesData", "Question_TC_01", 2));
		TestBase.implict(2);

		questionLabelTextField.sendKeys(e.getCellData("GuestPrefQuesData", "Question_Label_TC_01", 2));
		TestBase.implict(2);

		option1Label.sendKeys(e.getCellData("GuestPrefQuesData", "Option1_Label_TC_01", 2));
		TestBase.implict(2);

		option1GuestQuestion.sendKeys(e.getCellData("GuestPrefQuesData", "Option1_GuesOption_TC_01", 2));
		TestBase.implict(2);

		return null;
	}

	public GuestPreferenceQuestionsPage inputTextFieldsMultipleType() throws Exception {
		questionTextField.click();
		questionTextField.sendKeys(e.getCellData("GuestPrefQuesData", "Question_TC_02", 2));
		TestBase.implict(2);

		questionLabelTextField.sendKeys(e.getCellData("GuestPrefQuesData", "Question_Label_TC_02", 2));
		TestBase.implict(2);

		option1Label.sendKeys(e.getCellData("GuestPrefQuesData", "Option1_Label_TC_02", 2));
		TestBase.implict(2);

		option1GuestQuestion.sendKeys(e.getCellData("GuestPrefQuesData", "Option1_GuesOption_TC_02", 2));
		TestBase.implict(2);

		return null;
	}

	public GuestPreferenceQuestionsPage inputTextFieldsFreeTextType() throws Exception {
		questionTextField.click();
		questionTextField.sendKeys(e.getCellData("GuestPrefQuesData", "Question_TC_03", 2));
		TestBase.implict(2);

		questionLabelTextField.sendKeys(e.getCellData("GuestPrefQuesData", "Question_Label_TC_03", 2));
		TestBase.implict(2);
		return null;
	}

	public GuestPreferenceQuestionsPage clickOnSave() throws InterruptedException {
		savebutton.click();
		TestBase.implict(4);

		return null;
	}

	public GuestPreferenceQuestionsPage clickOnDelete() throws InterruptedException {
		deletebutton.click();
		TestBase.implict(3);
		return null;
	}

	public GuestPreferenceQuestionsPage clickOnOK() throws InterruptedException {
		oKbutton.click();
		TestBase.implict(3);
		return null;
	}

	public GuestPreferenceQuestionsPage clickOnEdit() throws InterruptedException {
		editButton.click();
		TestBase.implict(3);
		return null;
	}

	public GuestPreferenceQuestionsPage selectCategoryRadioButton() throws InterruptedException {
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {

			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("Room"))
				radbut.get(i).click();
			TestBase.implict(3);

		}
		return null;
	}

	public boolean verifyGuestPrefQuesName_tc01() throws Exception {
		if (e2.isDisplayed()) {
			String QuesName = e2.getText();
			System.out.println(QuesName + ": GuestPrefQues created");
			return true;

		} else
			return false;
	}
	
	
	public boolean verifyGuestPrefQuesName_tc02() throws Exception {
		if (e2.isDisplayed()) {
			String QuesName = e2.getText();
			System.out.println(QuesName + ": GuestPrefQues created");
			return true;

		} else
			return false;
	}
	

	public boolean verifyGuestPrefQuesName_tc03() throws Exception {
		if (e2.isDisplayed()) {
			String QuesName = e2.getText();
			System.out.println(QuesName + ": GuestPrefQues created");
			return true;

		} else
			return false;
	}
	
	public boolean verifyGuestPrefQuesName_Delete() throws Exception {
		if (e3.isDisplayed()) {
			System.out.println("Guest Preference Question is Deleted");
			return true;
		} else
			return false;
	}
	
	

	public boolean verifyGuestPrefQuesCategory() throws Exception {
		String CategoryName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[last()]/td[3]")).getText();
		CategoryName = CategoryName.replaceAll("\\s+", "");
		System.out.println(CategoryName + "####");

		String CategoryNameExpected = "Reservation";
		CategoryNameExpected = CategoryNameExpected.replaceAll("\\s+", "");

		System.out.println(CategoryNameExpected+"$$$$");

		if (CategoryName.equals(CategoryNameExpected)) {
			System.out.println("Category is Reservation");
			return true;
		} else {
			System.out.println("Category is Room");
			return false;

		}
	}

	public boolean verifyMaxOptionsAllowedField() throws Exception {

		WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Max Options Allowed')]"));
		TestBase.implict(3);

		if (e.isDisplayed()) {
			String s = driver.findElement(By.xpath("//*[contains(text(),'Max Options Allowed')]")).getText();
			s = s.replaceAll("\\s+", "");
			System.out.println(s + "####");
			System.out.println("Max Option Allowed Field is present");
			return true;

		} else {
			System.out.println("Max Option Allowed Field is not present after selecting Free Text");
			return false;

		}
	}
	public boolean verifyMaxOptionsAllowedInputField() throws Exception {

		WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Max Options Allowed')]/input"));
		TestBase.implict(3);

		if (e.isEnabled()) {
			e.click();
			System.out.println("Max Options Allowed Field is Accessible");
			return true;

		} else {
			System.out.println("Max Options Allowed Field is not Accessible");
			return false;

		}
	}
}

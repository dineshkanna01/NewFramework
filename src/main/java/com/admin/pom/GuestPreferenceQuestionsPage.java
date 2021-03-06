package com.admin.pom;
import java.util.List;
/*
 * Pom class for Guest Preference Questions
 * @author Rudraksh Aggarwal
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;

public class GuestPreferenceQuestionsPage extends AbstractBasePage {
	
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
	
	public GuestPreferenceQuestionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	/*
	 * Method to select single type
	 */
	public GuestPreferenceQuestionsPage selectSingleType() {
		selectionTypeDropdown.click();
		selectionSingleType.click();
		Helper.implict(5);
		return null;
	}
	/*
	 * Method to select multiple type
	 */
	public GuestPreferenceQuestionsPage selectMultipleType() {
		selectionTypeDropdown.click();
		selectionMultipleType.click();
		Helper.implict(5);
		return null;
	}
	/*
	 * Method to select Free Text Type
	 */
	public GuestPreferenceQuestionsPage selectFreeTextType() {
		selectionTypeDropdown.click();
		selectionFreeTextType.click();
		Helper.implict(5);
		return null;
	}
	/*
	 * Method to input data for single type
	 */
	public GuestPreferenceQuestionsPage inputTextFieldsSingleType() {
		questionTextField.click();
		questionTextField.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Question_TC_01", 2));
		Helper.implict(2);
		questionLabelTextField.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Question_Label_TC_01", 2));
		Helper.implict(2);
		option1Label.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Option1_Label_TC_01", 2));
		Helper.implict(2);
		option1GuestQuestion.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Option1_GuesOption_TC_01", 2));
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to input data for multiple type
	 */
	public GuestPreferenceQuestionsPage inputTextFieldsMultipleType() {
		questionTextField.click();
		questionTextField.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Question_TC_02", 2));
		Helper.implict(2);
		questionLabelTextField.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Question_Label_TC_02", 2));
		Helper.implict(2);
		option1Label.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Option1_Label_TC_02", 2));
		Helper.implict(2);
		option1GuestQuestion.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Option1_GuesOption_TC_02", 2));
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to input data for free text type
	 */
	public GuestPreferenceQuestionsPage inputTextFieldsFreeTextType() {
		questionTextField.click();
		questionTextField.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Question_TC_03", 2));
		Helper.implict(2);
		questionLabelTextField.sendKeys(ExcelData.getCellData("GuestPrefQuesData", "Question_Label_TC_03", 2));
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to click save button
	 */
	public GuestPreferenceQuestionsPage clickOnSave() {
		savebutton.click();
		Helper.implict(4);
		return null;
	}
	/*
	 * Method to click delete button
	 */
	public GuestPreferenceQuestionsPage clickOnDelete() {
		deletebutton.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to click Ok button
	 */
	public GuestPreferenceQuestionsPage clickOnOK() {
		oKbutton.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to click Edit button
	 */
	public GuestPreferenceQuestionsPage clickOnEdit() {
		editButton.click();
		Helper.implict(3);
		return null;
	}
	/*
	 * Method to select room category
	 */
	public GuestPreferenceQuestionsPage selectCategoryRadioButton() {
		List<WebElement> radbut = driver.findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("Room"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		return null;
	}
	/*
	 * Method to verify created guest preference question
	 * @return boolean value
	 */
	public boolean verifyGuestPrefQuesName() {
		if (e2.isDisplayed()) {
			String QuesName = e2.getText();
			System.out.println(QuesName + ": GuestPrefQues created");
			return true;
		} else
			return false;
	}
	/*
	 * Method to verify deleted guest preference question
	 * @return boolean value
	 */
	public boolean verifyGuestPrefQuesName_Delete() {
		if (e3.isDisplayed()) {
			System.out.println("Guest Preference Question is Deleted");
			return true;
		} else
			return false;
	}
	/*
	 * Method to verify guest preference question category
	 * @return boolean value
	 */
	public boolean verifyGuestPrefQuesCategory() {
		String CategoryName = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[last()]/td[3]")).getText();
		CategoryName = CategoryName.replaceAll("\\s+", "");
		System.out.println(CategoryName + "####");
		String CategoryNameExpected = "Reservation";
		CategoryNameExpected = CategoryNameExpected.replaceAll("\\s+", "");
		System.out.println(CategoryNameExpected + "$$$$");
		if (CategoryName.equals(CategoryNameExpected)) {
			System.out.println("Category is Reservation");
			return true;
		} else {
			System.out.println("Category is Room");
			return false;
		}
	}
	/*
	 * Method to verify Max Options Allowed Field enabled or not
	 * @return boolean value
	 */
	public boolean verifyMaxOptionsAllowedField() {
		WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Max Options Allowed')]"));
		Helper.implict(3);
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
	/*
	 * Method to verify Max Options Allowed Field interactable or not
	 * @return boolean value
	 */
	public boolean verifyMaxOptionsAllowedInputField() {
		WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Max Options Allowed')]/input"));
		Helper.implict(3);
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

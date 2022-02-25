package com.cc.pom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.pom.RatePlanPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class GroupKeywordSearchBookingPage extends TestBase {

	@FindBy(xpath = "//*[@id='addNewCategoryButton']/input")
	WebElement addNewCategoryButton;
	@FindBy(xpath = "//input[@name='categoryName']")
	WebElement categoryName;
	@FindBy(xpath = "(//*[@name='editCategoryLink'])[1]")
	WebElement verifyCategoryName;
	@FindBy(name = "name")
	WebElement name;
	@FindBy(name = "rateCode")
	WebElement ratePlanCode;
	@FindBy(name = "shortDescription")
	WebElement shortDescription;
	@FindBy(name = "bookingSDate")
	WebElement startDate;
	@FindBy(name = "checkInSDate")
	WebElement firstCheckInDate;
	@FindBy(xpath = "//*[@value='All']")
	WebElement roomCheckbox;
	@FindBy(name = "selectedCategoryId")
	WebElement category;
	@FindBy(xpath = "//select[@name='classification']")
	WebElement classifications;
	@FindBy(id = "chkCallCenter")
	WebElement callCenterCheckbox;
	@FindBy(xpath = "//button[text()='Create Search Tag']")
	WebElement searchTagButton;
	@FindBy(name = "rateSearchTag")
	WebElement searchTagField;
	@FindBy(id = "group-plan-input")
	WebElement groupKeywordFieldCC;
	@FindBy(xpath = "//button[text()='Search Group Rate']")
	WebElement searchGroupButton;
	@FindBy(xpath = "(//input[contains(@id,'rate_')])[1]")
	WebElement rateGridRate;
	@FindBy(xpath = "(//a[text()='Select'])[2]")
	WebElement selectRoom;
	
	@FindBy(xpath = "//tr[@class='ratePlanHeader'][last()]")
	WebElement categoryNameDel;
	@FindBy(name = "button2")
	WebElement deleteButton;
	@FindBy(xpath = "//input[@value='Yes']")
	WebElement yesButton;

	public GroupKeywordSearchBookingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to create Rate plan Category
	 */
	public GroupKeywordSearchBookingPage createCategory() {
		addNewCategoryButton.click();
		Helper.implict(1);
		categoryName.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "CategoryName", 2));
		return null;
	}

	/*
	 * Method to verify category name
	 * 
	 * @return boolean value
	 */
	public boolean verifyName() {
		String CName = verifyCategoryName.getText();
		CName = CName.replaceAll("\\s+", "");
		System.out.println(CName + "####");
		String ExcelCategoryName = ExcelData.CC_getCellData("GroupKeywordData", "CategoryName", 2);
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
	 * Method to input rate plan tc01
	 */
	public GroupKeywordSearchBookingPage inputRateplanTC01() {
		name.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		Helper.implict(1);
		ratePlanCode.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "RateTypeCode", 2));
		Helper.implict(1);
		Select dropdown = new Select(category);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("GroupKeywordData", "CategoryName", 2));
		shortDescription.sendKeys(ExcelData.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		Helper.implict(5);
		Select dropdown1 = new Select(classifications);
		dropdown1.selectByValue(ExcelData.CC_getCellData("GroupKeywordData", "Classification", 2));
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Helper.implict(1);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		startDate.sendKeys(strDate);
		Helper.implict(1);
		firstCheckInDate.sendKeys(strDate);
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to input rate plan tc02
	 */
	public GroupKeywordSearchBookingPage inputRateplanTC02() {
		name.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "RPName", 3));
		Helper.implict(1);
		ratePlanCode.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "RateTypeCode", 3));
		Helper.implict(1);
		Select dropdown = new Select(category);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("GroupKeywordData", "CategoryName", 2));
		shortDescription.sendKeys(ExcelData.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		Helper.implict(5);
		Select dropdown1 = new Select(classifications);
		dropdown1.selectByValue(ExcelData.CC_getCellData("GroupKeywordData", "Classification", 2));
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Helper.implict(1);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		startDate.sendKeys(strDate);
		Helper.implict(1);
		firstCheckInDate.sendKeys(strDate);
		Helper.implict(1);
		return null;
	}
	
	/*
	 * Method to input rate plan TC04
	 */
	public GroupKeywordSearchBookingPage inputRateplanTC04() {
		name.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "RPName", 4));
		Helper.implict(1);
		ratePlanCode.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "RateTypeCode", 4));
		Helper.implict(1);
		Select dropdown = new Select(category);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("GroupKeywordData", "CategoryName", 2));
		shortDescription.sendKeys(ExcelData.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		Helper.implict(5);
		Select dropdown1 = new Select(classifications);
		dropdown1.selectByValue(ExcelData.CC_getCellData("GroupKeywordData", "Classification", 2));
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Helper.implict(1);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		startDate.sendKeys(strDate);
		Helper.implict(1);
		firstCheckInDate.sendKeys(strDate);
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to create Group Search Tag
	 */
	public GroupKeywordSearchBookingPage createGroupSearchTag() {
		// searchTagButton.click();
		Helper.explicit(searchTagField, 10);
		searchTagField.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "SearchTag", 2));
		return null;
	}
	
	/*
	 * Method to create Group Search Tag TC04
	 */
	public GroupKeywordSearchBookingPage createGroupSearchTagTC04() {
		// searchTagButton.click();
		Helper.explicit(searchTagField, 10);
		searchTagField.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "SearchTag", 3));
		return null;
	}

	/*
	 * Method to select room type
	 */
	public GroupKeywordSearchBookingPage selectRoomType() {
		roomCheckbox.click();
		return null;
	}

	/*
	 * Method to search Group Keyword CC
	 */
	public void searchGroupKeywordCC() {
		Helper.explicit(groupKeywordFieldCC, 20);
		groupKeywordFieldCC.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "SearchTag", 2));
		searchGroupButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Method to search Group Keyword CC TC04
	 */
	public void searchGroupKeywordCCTC04() {
		Helper.explicit(groupKeywordFieldCC, 30);
		groupKeywordFieldCC.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "SearchTag", 4));
		searchGroupButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to get group Rate Plan NameCC TC01
	 */
	public void getRatePlanNameCCTC01() {
		String a = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		WebElement grpn = getDriver().findElement(By.xpath("//*[text()='" + a + "']"));
		String grpname = grpn.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 36, grpname);
	}

	/*
	 * Method to get group Rate Plan NameCC TC02
	 */
	public void getRatePlanNameCCTC02() {
		String a = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		WebElement grpn = getDriver().findElement(By.xpath("//*[text()='" + a + "']"));
		String grpname = grpn.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 36, grpname);

		String b = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 3));
		WebElement grpn1 = getDriver().findElement(By.xpath("//*[text()='" + b + "']"));
		String grpname1 = grpn1.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 36, grpname1);
	}
	
	/*
	 * Method to get group Rate Plan NameCC TC03
	 */
	public void getRatePlanNameCCTC03() {
		String a = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		WebElement grpn = getDriver().findElement(By.xpath("//*[text()='" + a + "']"));
		String grpname = grpn.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 36, grpname);

		String b = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 3));
		WebElement grpn1 = getDriver().findElement(By.xpath("//*[text()='" + b + "']"));
		String grpname1 = grpn1.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 36, grpname1);
	}
	
	/*
	 * Method to get group Rate Plan NameCC TC04
	 */
	public void getRatePlanNameCCTC04() {
		String a = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		WebElement grpn = getDriver().findElement(By.xpath("//*[text()='" + a + "']"));
		String grpname = grpn.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 36, grpname);

		String b = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 3));
		WebElement grpn1 = getDriver().findElement(By.xpath("//*[text()='" + b + "']"));
		String grpname1 = grpn1.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 36, grpname1);
		
		String c = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 4));
		WebElement grpn2 = getDriver().findElement(By.xpath("//*[text()='" + c + "']"));
		String grpname2 = grpn2.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 3, 36, grpname2);
	}

	/*
	 * Method to select Group Rate Plan for Booking CC
	 */
	public void selectGroupRatePlanBookingCC() {
		String a = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		WebElement grpn = getDriver().findElement(By.xpath("//*[text()='" + a + "']/following::div[2]"));
		grpn.click();

	}
	
	/*
	 * Method to select Rate Plan
	 */
	public GroupKeywordSearchBookingPage selectRatePlan() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		WebElement grpn = getDriver().findElement(By.xpath("//a[text()='" + a + "']/following::input[2]"));
		grpn.click();
		return null;
	}
	
	/*
	 * Method to input Field Rate
	 */
	public void inputFieldRate() {
		rateGridRate.clear();
		rateGridRate.sendKeys(ExcelData.CC_getCellData("GroupKeywordData", "Rate", 2));
	}
	
	/*
	 * Method to select Standard Room
	 */
	public void selectRoom() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2));
		System.out.println(a);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		room.click();
		Helper.implict(1);
		selectRoom.click();
	}
	
	/*
	 * Method to delete rate plans
	 */
	public RatePlanPage deleteRatePlans() {
		categoryNameDel.click();
		
	List<WebElement> a  =getDriver().findElements(By.xpath("//td[contains(text(),'groupRatePlan_')]//preceding::input[@name='rateIdCheckbox'][1]"));
	for(WebElement i : a) {
		i.click();
	}
		deleteButton.click();
		Helper.explicit(yesButton,50);
		yesButton.click();
		Helper.implict(4);
		return null;
	}
}

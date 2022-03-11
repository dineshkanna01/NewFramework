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

/*
 * Pom class for OfferAccessCodeBooking
 * @author Rudraksh Aggarwal
 */
public class OfferAccessCodeBookingPage extends TestBase {

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
	
	@FindBy(name = "selectedRatePlanName")
	WebElement rpAc;
	
	@FindBy(name = "go")
	WebElement go;
	
	@FindBy(xpath = "//*[contains(@onclick,'addNewRatePlanToAccessCode')]")
	WebElement clickAddAccessCode;
	
	@FindBy(name = "accessCode")
	WebElement acField;
	
	@FindBy(xpath = "(//td[contains(@id,'accessCode_')])[last()]")
	WebElement acVerify;
	
	@FindBy(xpath = "(//*[text()='Edit'])[last()]")
	WebElement editAC;
	
	@FindBy(xpath = "//input[@id='offer-code-input']")
	WebElement ocCCField;
	
	@FindBy(xpath = "//a[contains(text(),'offer code')]")
	WebElement rpnameCC;
	
	@FindBy(xpath = "(//a[text()='Select'])[2]")
	WebElement selectRoom;
	
	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	WebElement yesButtonCancel;
	
	@FindBy(xpath = "//*[text()='Your reservation has been cancelled']")
	WebElement cancelCodeHead;
	
	@FindBy(xpath = "//div[@class='bootbox-body']/strong")
	WebElement cancelCode;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButtonCancel;
	
	@FindBy(xpath = "(//a[text()='Delete'])[last()]")
	WebElement deleteAC;
	
	@FindBy(xpath = "//span[text()='OK']")
	WebElement okDeleteAC;
	
	@FindBy(xpath = "//div[@ng-show=\"!alternatehotelsmessage\"]")
	WebElement error;
	
	@FindBy(xpath = "//tr[@class='ratePlanHeader'][last()]")
	WebElement categoryNameDel;
	
	@FindBy(name = "button2")
	WebElement deleteButton;
	
	@FindBy(xpath = "//input[@value='Yes']")
	WebElement yesButton;

	public OfferAccessCodeBookingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to create Rate plan Category
	 */
	public OfferAccessCodeBookingPage createCategory() {
		addNewCategoryButton.click();
		Helper.implict(1);
		categoryName.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "CategoryName", 2));
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
		String ExcelCategoryName = ExcelData.CC_getCellData("OfferAccessCodeBooking", "CategoryName", 2);
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
	 * Method to input rate plan TC01
	 */
	public OfferAccessCodeBookingPage inputRateplanTC01() {
		name.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2));
		Helper.implict(1);
		ratePlanCode.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "RateTypeCode", 2));
		Helper.implict(1);
		Select dropdown = new Select(category);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("OfferAccessCodeBooking", "CategoryName", 2));
		shortDescription.sendKeys(ExcelData.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		Helper.implict(3);
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
	 * Method to select Rate Plan Rate grid update
	 */
	public OfferAccessCodeBookingPage selectRatePlanRateGrid() {
		Helper.sleep(2000);
		String a = (ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2));
		WebElement rp = getDriver().findElement(By.xpath("//a[text()='" + a + "']/following::input[2]"));
		rp.click();
		return null;
	}

	/*
	 * Method to search Rate Plan AC
	 */
	public void searchRatePlanAC() {
		rpAc.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2));
		Helper.sleep(3000);
		List<WebElement> li = getDriver().findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement i : li) {
			if (i.getText().equalsIgnoreCase(ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2))) {
				i.click();
			}
		}
		go.click();
	}

	/*
	 * Method to click add access code
	 */
	public void clickAddAccessCode() {
		Helper.explicit(clickAddAccessCode, 30);
		clickAddAccessCode.click();
	}

	/*
	 * Method to input access code TC01
	 */
	public void inputAccessCodeTC01() {
		Helper.explicit(acField, 30);
		acField.click();
		acField.clear();
		acField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 2));
	}

	/*
	 * Method to verify Access Code Admin TC01
	 */
	public boolean verifyAccessCodeAdminTC01() {
		if (acVerify.isDisplayed()) {
			String code = acVerify.getText();
			System.out.println(code + " :admin");
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 51, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to click edit access code
	 */
	public void clickEditAccessCode() {
		Helper.explicit(editAC, 30);
		editAC.click();
	}

	/*
	 * Method to input access code TC02
	 */
	public void inputAccessCodeTC02() {
		Helper.explicit(acField, 30);
		acField.click();
		acField.clear();
		acField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 3));
	}

	/*
	 * Method to input access code TC06_1
	 */
	public void inputAccessCodeTC06_1() {
		Helper.explicit(acField, 30);
		acField.click();
		acField.clear();
		acField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 4));
	}

	/*
	 * Method to input access code TC06_2
	 */
	public void inputAccessCodeTC06_2() {
		Helper.explicit(acField, 30);
		acField.click();
		acField.clear();
		acField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 5));
	}

	/*
	 * Method to verify Access Code Admin TC02
	 */
	public boolean verifyAccessCodeAdminTC02() {
		if (acVerify.isDisplayed()) {
			String code = acVerify.getText();
			System.out.println(code + " :admin");
			ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 51, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to verify Access Code Admin TC06_1
	 */
	public boolean verifyAccessCodeAdminTC06_1() {
		if (acVerify.isDisplayed()) {
			String code = acVerify.getText();
			System.out.println(code + " :admin");
			ExcelData.write_CellData("NormalSingleRoomBookingData", 3, 51, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to verify Access Code Admin TC06_2
	 */
	public boolean verifyAccessCodeAdminTC06_2() {
		if (acVerify.isDisplayed()) {
			String code = acVerify.getText();
			System.out.println(code + " :admin");
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 53, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to input offer Code CC TC02
	 */
	public void inputOfferCodeCCTC02() {
		Helper.explicit(ocCCField, 30);
		ocCCField.click();
		ocCCField.clear();
		ocCCField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 3));
	}

	/*
	 * Method to input offer Code CC TC06_1
	 */
	public void inputOfferCodeCCTC06_1() {
		Helper.explicit(ocCCField, 30);
		ocCCField.click();
		ocCCField.clear();
		ocCCField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 4));
	}

	/*
	 * Method to input offer Code CC TC06_2
	 */
	public void inputOfferCodeCCTC06_2() {
		Helper.explicit(ocCCField, 30);
		ocCCField.click();
		ocCCField.clear();
		ocCCField.sendKeys(ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 5));
	}

	/*
	 * Method to get offer rate plan name cc TC02
	 */
	public void getofferNameCCTC02() {
		String rp = "//a[contains(text(),'offer code')]";
		Helper.waitVisibility(120, rp);
		String rpn = rpnameCC.getText();
		String s = rpn;
		String[] split = s.split("offer");
		String stringbefore = split[0];
		String stringbefore1 = stringbefore.substring(0, (stringbefore.length()) - 1);
		stringbefore1 = stringbefore1.replaceAll("\\s+", "");
		System.out.println("rate plan name CC: " + stringbefore1);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 52, stringbefore1);
	}

	/*
	 * Method to get offerCode rate plan name cc TC06_1
	 */
	public void getofferCodeCCTC06_1() {
		String rp = "//a[contains(text(),'offer code')]";
		Helper.waitVisibility(120, rp);
		String rpn = rpnameCC.getText();
		String s = rpn;
		String[] split = s.split("offer");
		String stringbefore = split[0];
		String stringbefore1 = stringbefore.substring(0, (stringbefore.length()) - 1);
		stringbefore1 = stringbefore1.replaceAll("\\s+", "");
		System.out.println("rate plan name CC: " + stringbefore1);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 52, stringbefore1);
	}

	/*
	 * Method to get offerCode rate plan name cc TC06_2
	 */
	public void getofferCodeCCTC06_2() {
		String rp = "//a[contains(text(),'offer code')]";
		Helper.waitVisibility(120, rp);
		String rpn = rpnameCC.getText();
		String s = rpn;
		String[] split = s.split("offer");
		String stringbefore = split[0];
		String stringbefore1 = stringbefore.substring(0, (stringbefore.length()) - 1);
		stringbefore1 = stringbefore1.replaceAll("\\s+", "");
		System.out.println("rate plan name CC: " + stringbefore1);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 3, 52, stringbefore1);
	}

	/*
	 * Method to select Standard Room
	 */
	public void selectRoom() {
		try {
			Thread.sleep(6000);
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
	 * Method to verify Cancel Booking TC05
	 * 
	 */
	public boolean verifyCancelBookingTC05() {
		Helper.explicit(cancelButton, 30);
		cancelButton.click();
		Helper.explicit(yesButtonCancel, 30);
		yesButtonCancel.click();
		Helper.sleep(7000);
		String cancelhead = cancelCodeHead.getText();
		String code1 = cancelCode.getText();
		System.out.println(cancelhead + " and cancellation code is:" + code1);
		Helper.implict(3);
		if (cancelCode.isDisplayed()) {
			System.out.println("booking is cancelled");
			Helper.sleep(2000);
			return true;
		} else {
			System.out.println("booking is not cancelled");
			return false;
		}
	}

	/*
	 * Method to click Ok Cancel
	 */
	public void clickOkCancel() {
		Helper.explicit(okButtonCancel, 20);
		okButtonCancel.click();
	}

	/*
	 * Method to Delete access code
	 */
	public void DeleteAC() {
		Helper.explicit(deleteAC, 20);
		deleteAC.click();
		Helper.explicit(okDeleteAC, 5);
		okDeleteAC.click();
	}

	/*
	 * Method to verify deletion of access code
	 * 
	 */
	public boolean verifyDeleteAC() {
		String err = "//div[@ng-show='!alternatehotelsmessage']";
		Helper.waitVisibility(60, err);
		if (error.isDisplayed()) {
			String e = error.getText();
			System.out.println(e);
			System.out.println("access code is deleted");
			return true;
		} else {
			System.out.println("access code is  not deleted");
			return false;
		}
	}

	/*
	 * Method to delete rate plans
	 */
	public RatePlanPage deleteRatePlans() {
		categoryNameDel.click();
		String rptodel = ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2);
		List<WebElement> a = getDriver().findElements(
				By.xpath("//td[contains(text(),'" + rptodel + "')]//preceding::input[@name='rateIdCheckbox'][1]"));
		for (WebElement i : a) {
			i.click();
		}
		deleteButton.click();
		Helper.explicit(yesButton, 50);
		yesButton.click();
		Helper.implict(4);
		return null;
	}
}

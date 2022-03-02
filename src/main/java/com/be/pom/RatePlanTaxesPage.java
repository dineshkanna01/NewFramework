package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;
/*
* Pom class for Rate Plan Taxes Page
* @author Sudhakar Mourya
*/
public class RatePlanTaxesPage extends TestBase {
	
	@FindBy(id = "search_arrival_date")
	WebElement calender;
	
	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;
	
	@FindBy(id = "check-availability-btn")
	WebElement avalilibiltyButton;
	
	@FindBy(xpath = "(//button[@type='submit'])[last()]")
	WebElement bookNow;
	
	@FindBy(xpath = "(//input[@name='rateId1221'])[last()]")
	WebElement taxForBarRatePlan;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveRatePlanTaxes;
	
	@FindBy(xpath = "((//input[@name='taxIdsToDelete'])[last()]/following::td/a)[1]")
	WebElement editTax;
	
	@FindBy(xpath = "//td[@ng-bind='booking.tax | currencyEx']")
	WebElement taxAmount;
	
	@FindBy(xpath = "//li[text()='A tax with that code already exists. Please select a different code.']")
	WebElement errorMsg;
	

	public RatePlanTaxesPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
}
	
	/*
	 * Method to select dates booking engine
	 * 
	 */
	public RatePlanTaxesPage selectDate() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calender.click();
		Helper.implict(2);
		checkInDate.click();
		return null;
	}
	/*
	 * Method to click Availibility Button
	 * 
	 */
	public RatePlanTaxesPage clickAvailibilityButton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		avalilibiltyButton.click();
		Helper.implict(2);
		return null;
	}
	
	/*
	 * Method to click Book Now Button
	 */
	public RatePlanTaxesPage clickBookNowButton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookNow.click();
		Helper.implict(4);
		return null;
	}
	
	/*
	 * Method to click on newly created tax for bar rate plan
	 */
	public RatePlanTaxesPage clickOnLastTaxForBarRatePlan() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taxForBarRatePlan.click();
		Helper.implict(4);
		return null;
}
	
	/*
	 * Method to click on save button for rate plan taxes
	 */
	public RatePlanTaxesPage clickOnSaveRatePlanTaxes() {
		saveRatePlanTaxes.click();
		Helper.implict(6);
		return null;
}
	
	/*
	 * Method to click on city tax
	 */
	public RatePlanTaxesPage clickOnCityTax() {
		editTax.click();
		Helper.implict(4);
		return null;
}
	
	/*
	 * Method to get text for dublicate tax code error msg
	 */
	public String duplicateTaxCodeErrorMsg() {
		return errorMsg.getText();
}
	
	/*
	 * Method to get amount before tax for TC-01
	 */
	public void getAmountBeforeTaxTc01() {
		String a=taxAmount.getText();
		System.out.println("Amount before add tax : " + a);
		ExcelData.write_CellData("LoginPageData",1,8,a);
}
	
	/*
	 * Method to get amount after tax for TC-01
	 */
	public void getAmountAfterTaxTc01() {
		String a=taxAmount.getText();
		System.out.println("Amount after add tax : " + a);
		ExcelData.write_CellData("LoginPageData",1,9,a);
}
	
	/*
	 * Method to verify tax is added for TC-01
	 */
	public boolean verifyTaxAddedTc01() {
	String a= ExcelData.getCellData("LoginPageData","AmountBeforeAddTaxTc_01",2);
	String b= ExcelData.getCellData("LoginPageData","AmountAfterAddTaxTc_01",2);
	if(a.equalsIgnoreCase(b)) {
		System.out.println("Tax is not added");
		return true;
	}else {
		System.out.println("Tax is added ");
		return false;
	}
}
	
	/*
	 * Method to get amount before tax for TC-02
	 */
	public void getAmountBeforeTaxTc02() {
		String a=taxAmount.getText();
		System.out.println("Amount before add tax : " + a);
		ExcelData.write_CellData("LoginPageData",1,10,a);
}
	
	/*
	 * Method to get amount after tax for TC-02
	 */
	public void getAmountAfterTaxTc02() {
		String a=taxAmount.getText();
		System.out.println("Amount after add tax : " + a);
		ExcelData.write_CellData("LoginPageData",1,11,a);
}
	
	/*
	 * Method to verify tax is added for TC-02
	 */
	public boolean verifyTaxRemovedTc02() {
	String a= ExcelData.getCellData("LoginPageData","AmountBeforeAddTaxTc_02",2);
	String b= ExcelData.getCellData("LoginPageData","AmountAfterAddTaxTc_02",2);
	if(a.equalsIgnoreCase(b)) {
		System.out.println("Tax is not remove");
		return true;
	}else {
		System.out.println("Tax is remove ");
		return false;
	}
}
	
	/*
	 * Method to get amount before tax for TC-03
	 */
	public void getAmountBeforeTaxTc03() {
		String a=taxAmount.getText();
		System.out.println("Amount before add tax : " + a);
		ExcelData.write_CellData("LoginPageData",1,12,a);
}
	
	/*
	 * Method to get amount after tax for TC-03
	 */
	public void getAmountAfterTaxTc03()  {
		String a=taxAmount.getText();
		System.out.println("Amount after add tax : " + a);
		ExcelData.write_CellData("LoginPageData",1,13,a);
}
	
	/*
	 * Method to verify tax is added for TC-03
	 */
	public boolean verifyTaxModifiedTc03() {
	String a= ExcelData.getCellData("LoginPageData","AmountBeforeAddTaxTc_03",2);
	String b= ExcelData.getCellData("LoginPageData","AmountAfterAddTaxTc_03",2);
	if(a.equalsIgnoreCase(b)) {
		System.out.println("Tax is not modified");
		return true;
	}else {
		System.out.println("Tax is modified ");
		return false;
	}
}
}
	

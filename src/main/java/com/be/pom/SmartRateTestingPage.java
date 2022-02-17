package com.be.pom;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
* POM class to Apply Property Level Restriction
* @Author Uzair Asar
*/

public class SmartRateTestingPage extends TestBase {
	
	@FindBy(xpath = "//a[text()='Edit']")
	WebElement adminEditProperty;

	@FindBy(xpath = "(//input[@name='isSmartRate'])[1]")
	WebElement adminSmartRateEnable;

	@FindBy(xpath = "(//input[@name='isSmartRate'])[2]")
	WebElement adminSmartRateDisable;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement adminConfirmOkButton;

	@FindBy(xpath = "//div[text()='Rate Plans']")
	WebElement adminRatePlanTab;

	@FindBy(xpath = "//*[contains(@href,'g.do?method=display&brand_id=20&prop_id=50')]")
	WebElement adminManageSmartRate;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement adminEnableSmartPolicy;
	
	@FindBy(id = "smartPolicyId")
	WebElement adminSmartPolicyDropDown;
	
	@FindBy(xpath = "(//select[@name = 'smartPolicyId']//option[text()])[2]")
	WebElement adminSelectSmartPolicy;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement adminEnableBasicPolicy;
	
	@FindBy(id = "policyId")
	WebElement adminPolicyDropDown;

	@FindBy(xpath = "(//select[@name='policyId']//option[text()])[2]")
	WebElement adminSelectPolicy;

	@FindBy(xpath = "//input[@name='save']")
	WebElement adminSmartRateSaveButton;

	@FindBy(xpath = "//*[@id='8']/li[1]/a")
	WebElement ratePlanListAll;

	@FindBy(xpath = "(//*[@tf_colkey='name'][1]/following::td[33]/a[1])[1]")
	WebElement editBARRatePlan;
	
	@FindBy(id = "isSmartRatePlanYes")
	WebElement enableSmartRate;
	
	@FindBy(xpath = "(//*[contains(@href,'retrieveRateTypeDetails.do?rateTypeId=')])[3]")
	WebElement editRatePlan2;
	
	@FindBy(xpath = "//*[@id='smartRateTbl']/tbody/tr[3]/td")
	WebElement verifySmartRatePlan1;
	
	@FindBy(xpath = "//*[@id='smartRateTbl']/tbody/tr[4]/td")
	WebElement verifySmartRatePlan2;
	
	@FindBy(xpath = "//strong[text()='Smart Rate']")
	WebElement verifySmartRatePlanInBE;
	
	@FindBy(xpath = "(//a[text()='Offer details'])[last()]")
	WebElement SmartRatePlanOfferDetails;
	
	@FindBy(xpath = "//div[text()='Basic 24 hour cancellation policy']")
	WebElement verifySmartRatePlanBasicPolicy;
	
	@FindBy(id = "search_arrival_date")
	WebElement checkInCalander;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;
	
	@FindBy(id = "search_departure_date")
	WebElement checkOutCalander;

	@FindBy(xpath = "//td[text()='2']")
	WebElement checkOutDate;

	@FindBy(id = "check-availability-btn")
	WebElement checkAvailability;
	
	@FindBy(xpath = "//*[contains(@href,'/admin/action/rateGridInitAc')]")
	WebElement rateGrid;
	
	@FindBy(xpath = "//*[@name='C801']")
	WebElement selectRatePlan;
	
	@FindBy(xpath = "//*[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='startDate']")
	WebElement checkInGridDate;
	
	@FindBy(xpath = "//input[@name='endDate']")
	WebElement checkOutGridDate;
	
	@FindBy(xpath = "//*[@name='overrideRoomHierarchy']")
	WebElement overrideRoomHierarchy;

	@FindBy(xpath = "//*[@value='Daily Rate & Inventory']")
	WebElement dailyRateInvButton;
	
	@FindBy(xpath = "//*[@class='ms-selectall global']")
	WebElement selectAllRoomType;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement selectRoomTypedropdwn;
	
	@FindBy(id = "rooms_available_801")
	WebElement rateGridAvailability;
	
	@FindBy(xpath = "//*[@value='Quick Entry']")
	WebElement quickEntryBtn;

	@FindBy(xpath = "//*[@value='Confirm']")
	WebElement confirmBtn;

	@FindBy(xpath = "//*[@value='Update']")
	WebElement updateBtn;
	
	@FindBy(xpath = "(//span[@class='check-radio'])[1]")
	WebElement radioButtonSmartRate;
	
	@FindBy(xpath = "(//span[@class='check-radio'])[2]")
	WebElement radioButtonOtherRate;
	
	@FindBy(xpath = "(//td[@class='sideheader ng-binding'])[1]")
	WebElement verifySmartRateAmount;
	
	@FindBy(xpath = "(//span[@class='title'])[2]")
	WebElement adminVerifyRatePlanName;
	
	@FindBy(xpath = "//strong[text()='BAR']")
	WebElement beVerifyRatePlanName;
	
	@FindBy(xpath = "(//a[text()='Offer details'])[1]")
	WebElement beSmartRateOfferDetails;

	@FindBy(xpath = "(//b[@class='float-right popup-price ng-binding'])[1]")
	WebElement firstDayAmount;
	
	@FindBy(xpath = "(//b[@class='float-right popup-price ng-binding'])[2]")
	WebElement SecondDayAmount;
	
	@FindBy(xpath = "(//b[@class='float-right popup-price ng-binding'])[3]")
	WebElement thirdDayAmount;
	
	@FindBy(xpath = "(//a[text()='Offer details'])[2]")
	WebElement beOtherRateOfferDetails;
	
	@FindBy(xpath = "(//b[@class='float-right popup-price ng-binding'])[1]")
	WebElement beOtherRatePlanEachDayAmount;
	
	@FindBy(xpath = "//a[@class='close text-capitalize none-outline']")
	WebElement closeOfferDetails;

	public SmartRateTestingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to click on edit in property management
	 */

	public SmartRateTestingPage adminPropertyEdit() {
		Helper.implict(3);
		adminEditProperty.click();

		return null;
	}

	/*
	 * Method to enable Smart Rate Plan
	 */

	public SmartRateTestingPage adminEnableSamrtRate() {
		Helper.implict(3);
		adminSmartRateEnable.click();

		return null;
	}

	/*
	 * Method to disable Smart Rate Plan
	 */

	public SmartRateTestingPage adminDisableSamrtRate() {
		Helper.implict(3);
		adminSmartRateDisable.click();

		return null;
	}

	/*
	 * Method to click on ok
	 */

	public SmartRateTestingPage adminConfirmOkButton() {
		Helper.implict(3);
		adminConfirmOkButton.click();

		return null;
	}

	/*
	 * Method to click on Rate Plan Tab
	 */

	public SmartRateTestingPage adminRatePlanTab()  {
		Helper.implict(3);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminRatePlanTab.click();

		return null;
	}

	/*
	 * Method to verify Smart Rate Plan enabled 
	 * return boolean value
	 */

	public boolean verifyadminManageSmartRate() {
		Helper.implict(3);

		if (adminManageSmartRate.isDisplayed())
			System.out.println("Smart Rate is Enabled");

		return true;
	}

	/*
	 * Method to click on manage Smart Rate Plan Option
	 */

	public SmartRateTestingPage adminSelectManageSmartRateOption() {
		Helper.implict(3);
		adminManageSmartRate.click();
		return null;
	}

	/*
	 * Method to select Policy
	 */

	public SmartRateTestingPage adminSmartRatePolicySelect() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.implict(3);
		adminEnableBasicPolicy.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminPolicyDropDown.click();
		Helper.implict(3);
		adminSelectPolicy.click();
		return null;
	}

	/*
	 * Method to click on save button
	 */

	public SmartRateTestingPage adminSmartRateSaveButton() {
		Helper.implict(3);
		adminSmartRateSaveButton.click();
		return null;
	}

	/*
	 * Method to verify save button
	 */

	public String verifyAdminSmartRateSaveButton() {
		Helper.implict(3);
		String s = adminSmartRateSaveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	/*
	 * Method to click on list all rate Plan
	 */

	public SmartRateTestingPage adminListAllRatePlan(){
		Helper.implict(5);
		ratePlanListAll.click();
		return null;

	}

	/*
	 * Method to click on edit BAR rate Plan
	 */

	public SmartRateTestingPage editBARRatePlan() {
		Helper.implict(5);
		editBARRatePlan.click();
		enableSmartRate.click();
		return null;

	}

	/*
	 * Method to click on edit of second rate plan
	 */

	public SmartRateTestingPage editSmartRatePlan2() {
		Helper.implict(5);
		editRatePlan2.click();
		enableSmartRate.click();
		return null;

	}

	/*
	 * Method to verify rate plan added in smart rate plan
	 * return boolean value
	 */

	public boolean verifRatePlan1AddenInSmartRate() {
		Helper.implict(3);

		if (verifySmartRatePlan1.isDisplayed())
			System.out.println("Rate Plan 1 is added in Smart Rate");

		return true;
	}

	/*
	 * Method to verify rate plan 2 added in smart rate plan
	 * return boolean value
	 */

	public boolean verifRatePlan2AddenInSmartRate() {
		Helper.implict(3);

		if (verifySmartRatePlan2.isDisplayed())
			System.out.println("Rate Plan 2 is added in Smart Rate");

		return true;
	}

	/*
	 * Method to verify smart rate plan is added in BE
	 * return boolean value
	 */

	public boolean verifySmartRatePlanInBE()  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.implict(3);

		if (verifySmartRatePlanInBE.isDisplayed())
			System.out.println("Smart Rate Plan is added in BE");

		return true;
	}

	/*
	 * Method to click on offer details of rate plan
	 */

	public SmartRateTestingPage SmartRatePlanOfferDetails()  {
		Helper.implict(5);
		SmartRatePlanOfferDetails.click();
		return null;

	}

	/*
	 * Method to verify basic policy
	 * return boolean value
	 */

	public boolean verifySmartRatePlanBasicPolicy() {
		Helper.implict(3);

		if (verifySmartRatePlanBasicPolicy.isDisplayed())
			System.out.println("Basic policy set for Smart Rate Plan");

		return true;
	}

	/*
	 * Method to verify special policy
	 * return boolean value
	 */

	public boolean verifySmartRatePlanSpecialPolicy() {
		Helper.implict(3);

		if (verifySmartRatePlanBasicPolicy.isDisplayed())
			System.out.println("Special policy set for Smart Rate Plan");

		return true;
	}

	/*
	 * Method to check availability in BE
	 */

	public SmartRateTestingPage availabilityCheck()  {
		Helper.implict(3);
		checkInCalander.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);

		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(ExcelData.getCellData("SmartRate", "DateGap", 2));
		c.add(Calendar.DAY_OF_MONTH, m);
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		Helper.implict(3);
		
		checkOutCalander.click();
		Helper.implict(3);
		checkOutCalander.clear();
		checkOutCalander.sendKeys(newDate);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Helper.implict(3);
		
		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to enable smart policy in admin
	 */

	public SmartRateTestingPage adminSmartPolicy()  {
//		Helper.implict(5);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminEnableSmartPolicy.click();
		Helper.implict(5);
		adminSmartPolicyDropDown.click();
		Helper.implict(5);
		adminSelectSmartPolicy.click();
		return null;

	}

	/*
	 * Method to click on rate grid
	 */

	public SmartRateTestingPage selectRateGrid()  {
//		Helper.implict(3);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rateGrid.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select room and rate plan combination
	 */

	public SmartRateTestingPage selectRatePlan(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectRatePlan.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on continue button
	 */

	public SmartRateTestingPage continueButton(){
		continueButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select date range in rate grid
	 */

	public SmartRateTestingPage adminRateGriddateRange() {
		Helper.implict(3);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		String newDate = sdf.format(c.getTime());
		checkInGridDate.sendKeys(newDate);
		checkOutGridDate.sendKeys(newDate);
		
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select override button
	 */

	public SmartRateTestingPage clickoverrideRoomCheckbox() {
		overrideRoomHierarchy.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on daily inventory button
	 */

	public SmartRateTestingPage clickdailyRateInvbutton() {
		dailyRateInvButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify Rate plan name in admin
	 * return string value s
	 */

	public String adminVerifyRatePlanName() {
		Helper.implict(3);
		String s = adminVerifyRatePlanName.getText();
		
		System.out.println("Admin Rate Plan name:" +s);
		Helper.implict(3);
		return s;
	}

	/*
	 * Method to verify Rate plan name in BE
	 * return string value s
	 */

	public String beVerifyRatePlanName()  {
		Helper.implict(3);
		String s = beVerifyRatePlanName.getText();
		
		System.out.println("BE Rate Plan name:" +s);
		Helper.implict(3);
		return s;
	}

	/*
	 * Method to select all rooms in rate grid
	 */

	public SmartRateTestingPage selectALLRoomType()  {
		selectRoomTypedropdwn.click();
		Helper.implict(3);
		selectAllRoomType.click();
		System.out.println("All Rooms selected");

		return null;
	}

	/*
	 * Method to providing null availability
	 */

	public SmartRateTestingPage nullavailability() {
		Helper.implict(3);
		rateGridAvailability.sendKeys(ExcelData.getCellData("SmartRate", "nullAvailability", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to providing some availability in rate grid
	 */

	public SmartRateTestingPage availability() {
		Helper.implict(3);
		rateGridAvailability.sendKeys(ExcelData.getCellData("SmartRate", "Availability", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on quick entry button
	 */

	public SmartRateTestingPage clickQuickEntrybutton() {
		quickEntryBtn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on update button
	 */

	public SmartRateTestingPage clickUpdatebutton()  {
		updateBtn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on confirm button
	 */

	public SmartRateTestingPage clickConfirmbutton() {
		confirmBtn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select radio button for rate plan in BE
	 */

	public SmartRateTestingPage radioButtonSmartRate() {
		radioButtonSmartRate.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify smart rate amount
	 * return string value 
	 */

	public String verifySmartRateAmount() {
		String s = verifySmartRateAmount.getText();
		String subS = s.substring(4);
		System.out.println("Smart Rate Amount: "+subS);
		Helper.implict(3);
		return subS;
	}

	/*
	 * Method to select radio button of other rate plan
	 */

	public SmartRateTestingPage radioButtonOtherRate()  {
		radioButtonOtherRate.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify other rate plan rate amount
	 * return string value 
	 */

	public String verifyOtherRateAmount() {
		String s = verifySmartRateAmount.getText();
		String subS = s.substring(4);
		System.out.println("Other Rate Amount: "+subS);
		Helper.implict(3);
		return subS;
	}

	/*
	 * Method to click on offer detail of smart rate plan
	 */

	public SmartRateTestingPage smartRateOfferDetails() {
		beSmartRateOfferDetails.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on offer detail of another rate plan
	 */

	public String otherRateAmountDetails() {
		beOtherRateOfferDetails.click();
		Helper.implict(3);
		String s = beOtherRatePlanEachDayAmount.getText();
		String subS = s.substring(4);
		System.out.println("Each day Amount for other Rate Plan: "+subS);
		return subS;
	}

	/*
	 * Method to verify first day amount
	 * return string value
	 */

	public String firstDaySmartRateAmountDetails()  {
		Helper.implict(3);
		String s = firstDayAmount.getText();
		String subS = s.substring(4);
		System.out.println("First day Amount for Smart Rate Plan: "+subS);
		return subS;
	}

	/*
	 * Method to verify second day amount
	 * return string value
	 */

	public String secondDaySmartRateAmountDetails(){
		Helper.implict(3);
		String s = SecondDayAmount.getText();
		String subS = s.substring(4);
		System.out.println("Second day Amount for Smart Rate Plan: "+subS);
		return subS;
	}

	/*
	 * Method to verify third day amount
	 * return string value
	 */

	public String thirdDaySmartRateAmountDetails(){
		Helper.implict(3);
		String s = thirdDayAmount.getText();
		String subS = s.substring(4);
		System.out.println("Third day Amount for Samrt Rate Plan: "+subS);
		return subS;
	}

	/*
	 * Method to close offer details
	 */

	public SmartRateTestingPage closeOfferDetails() {
		Helper.implict(3);
		closeOfferDetails.click();
		Helper.implict(3);
		return null;
	}

}

package com.be.pom;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import base.Helper;

/*
 * Pom class for Dynamic Pricing Rule
 * @author Sudhakar Mourya
 */
public class DynamicPricingRulesPage extends Helper {

	@FindBy(id = "search_arrival_date")
	WebElement checkInCalender;

	@FindBy(id = "search_departure_date")
	WebElement checkOutCalender;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;

	@FindBy(id = "check-availability-btn")
	WebElement availability;

	@FindBy(xpath = "//button[@class='room-book-now-button']")
	WebElement bookNow;

	@FindBy(xpath = "//input[@name='name']")
	WebElement ruleName;

	@FindBy(xpath = "//input[@name='code']")
	WebElement ruleCode;

	@FindBy(xpath = "//input[@name='short_description']")
	WebElement shortDescription;

	@FindBy(id = "no_booking_date_window")
	WebElement bookingDateRadioButton;

	@FindBy(id = "compounddiscountType")
	WebElement discountType;

	@FindBy(xpath = "(//input[@name='discount_type'])[4]")
	WebElement allNightRadioButton;

	@FindBy(xpath = "//input[@name='all_nights_steady_percentage']")
	WebElement percentage;

	@FindBy(id = "rooms_all_0")
	WebElement checkboxBar;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement save;

	@FindBy(xpath = "(//input[@type='checkbox'])[last()]")
	WebElement lastCheckbox;

	@FindBy(xpath = "//a[contains(@href,'/admin/action/dpe/rule')]")
	WebElement listAllDpr;

	@FindBy(xpath = "//span[text()='Exciting Plan']")
	WebElement excitingPlan;

	@FindBy(xpath = "//span[text()='Latest Plan']")
	WebElement LatestPlan;

	@FindBy(xpath = "//input[@name='Delete']")
	WebElement delete;

	@FindBy(xpath = "(//a[contains(@href,'/admin/action/dpe/add_edit_rule.jsp?mode=Edit&dpe_property_id=81&display')])[1]")
	WebElement firstFewNights;

	@FindBy(xpath = "(//*[text()='Dynamic Pricing Rules'])[2]/following::li")
	WebElement errorMsgExistingCode;

	@FindBy(xpath = "//strong[@ng-show=\"!rp.average_discounted_nightly_price\"]")
	WebElement dprNotAdded;

	@FindBy(xpath = "//strike[@ng-bind='rp.average_nightly_price | currencyEx']")
	WebElement dprAdded;

	//strike[@ng-show=\"rp.average_discounted_nightly_price\"]
	//strike[@class="ng-binding ng-scope"]
	public DynamicPricingRulesPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to check Availability in BE
	 */
	public DynamicPricingRulesPage availabilityCheck() {
		Helper.implict(3);
		checkInCalender.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		availability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to check Click on Availability
	 */
	public DynamicPricingRulesPage clickOnCheckAvailability() {
		availability.click();
		return null;
	}

	/*
	 * Method to click on List All Dpr
	 */
	public DynamicPricingRulesPage clickOnListAllDpr() {
		listAllDpr.click();
		return null;
	}

	/*
	 * Method to Click on Booknow
	 */
	public DynamicPricingRulesPage clickOnBooknow() throws InterruptedException {
		Thread.sleep(3000);
		Helper.implict(5);
		bookNow.click();
		Helper.implict(5);
		return null;
	}

	/*
	 * Method to enter rule name
	 */
	public DynamicPricingRulesPage enterRuleName(String Name) {
		ruleName.sendKeys(Name);
		return null;
	}

	/*
	 * Method to enter rule code
	 */
	public DynamicPricingRulesPage enterRuleCode(String Code) {
		ruleCode.sendKeys(Code);
		return null;
	}

	/*
	 * Method to clear short description
	 */
	public DynamicPricingRulesPage clearShortDescription() {
		shortDescription.clear();
		return null;
	}

	/*
	 * Method to enter short description
	 */
	public DynamicPricingRulesPage enterShortDescription(String Description) {
		shortDescription.sendKeys(Description);
		return null;
	}

	/*
	 * Method to Click on Booking date
	 */
	public DynamicPricingRulesPage clickOnBookingDate() {
		bookingDateRadioButton.click();
		return null;
	}

	/*
	 * Method to select discount type
	 */
	public DynamicPricingRulesPage selectDiscountType() {
		Select s = new Select(discountType);
		s.selectByVisibleText("Percentage");
		return null;
	}

	/*
	 * Method to click on all night radio button
	 */
	public DynamicPricingRulesPage clickOnAllNightradioButton() {
		allNightRadioButton.click();
		return null;
	}

	/*
	 * Method to enter percentege
	 */
	public DynamicPricingRulesPage enterPercentage(String Percentage) {
		percentage.sendKeys(Percentage);
		return null;
	}

	/*
	 * Method to Click on Bar checkbox
	 */
	public DynamicPricingRulesPage clickOnBarCheckbox() {
		checkboxBar.click();
		return null;
	}

	/*
	 * Method to Click on save button
	 */
	public DynamicPricingRulesPage clickOnSave() {
		save.click();
		return null;
	}

	/*
	 * Method to Click on first few nights dpr
	 */
	public DynamicPricingRulesPage clickOnFirstFewNights() {
		firstFewNights.click();
		return null;
	}

	/*
	 * Method to Click on last checkbox
	 */
	public DynamicPricingRulesPage clickOnLastCheckbox() {
		lastCheckbox.click();
		return null;
	}

	/*
	 * Method to delete the dpr
	 */
	public DynamicPricingRulesPage clickOnDelete() throws InterruptedException {
		lastCheckbox.click();
		delete.click();
		getDriver().switchTo().alert().accept();
		return null;
	}

	/*
	 * Method to verify exciting plan text
	 */
	public boolean verifyExcitingPlanText() {
		if (excitingPlan.isDisplayed()) {
			System.out.println("Exciting Plan Text visible");
		}
		return true;
	}

	/*
	 * Method to verify latest plan text
	 */
	public boolean verifyLatestPlanText() {
		if (LatestPlan.isDisplayed()) {
			System.out.println("Latest Plan Text visible");
		}
		return true;
	}

	/*
	 * Method to verify existing code error msg
	 */
	public boolean verifyExistingCodeErrorMsg() {
		if (errorMsgExistingCode.isDisplayed()) {
			System.out.println("Error msg is displayed");
		}
		return true;
	}

	/*
	 * Method to verify dpr not added
	 */
	public boolean verifyDprNotAddedOnBar() {
		if (dprNotAdded.isDisplayed()) {
			System.out.println("DPR is not added");
		}
		return true;
	}

	/*
	 * Method to verify dpr added
	 */
	public boolean verifyDprAddedOnBar() {
		if (dprAdded.isDisplayed()) {
			System.out.println("DPR is added");
		}
		return true;
	}

	/*
	 * Method to select Day of Week
	 */
	public void selectDayofWeek() throws InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		String stringDay = sdf.format(new Date());
		String Day = stringDay.toLowerCase();
		System.out.println("Today is:" + stringDay);
		if (Day.equals("mon")) {
			String d = Day.substring(0, 1);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");} 
		else if (Day.equals("tue")) {
			String d = Day.substring(0, 2);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");
		}
		else if (Day.equals("wed")) {
			String d = Day.substring(0, 1);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");
		}
		else if (Day.equals("thu")) {
			String d = Day.substring(0, 2);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");
		}
		else if (Day.equals("fri")) {
			String d = Day.substring(0, 1);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");
		}
		else if (Day.equals("sat")) {
			String d = Day.substring(0, 2);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");
		}
		else if (Day.equals("sun")) {
			String d = Day.substring(0, 2);
			System.out.println(d);
			WebElement currentday = getDriver().findElement(By.xpath("//input[@name='dow_day_" + d + "']"));
			currentday.click();
			Helper.implict(4);
			WebElement currentday2 = getDriver().findElement(By.xpath("//input[@name='dow_p_" + d + "']"));
			currentday2.sendKeys("10");
		}
	}
}

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

public class PropertyLevelRestrictionPage extends TestBase {

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

	@FindBy(xpath = "//button[@class='room-book-now-button']")
	WebElement bookNow;

	@FindBy(xpath = "//*[contains(@href,'Restrictions.do?brand_id=20&prop_id=50')]")
	WebElement adminPropertyYieldRestrictionOption;

	@FindBy(xpath = "//input[@value='Not Allow']")
	WebElement adminDoNotAllowOption;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement adminSaveButton;

	@FindBy(xpath = "//input[@value='Allow']")
	WebElement adminAllowOption;

	@FindBy(xpath = "//div[@ng-hide='showRoomInfo']")
	WebElement errorText;

	@FindBy(xpath = "//input[@value='Not Allow After Time']")
	WebElement adminDoNotAllowAfterOption;

	@FindBy(id = "denySameDayReservationsAfterMin")
	WebElement minOption;

	@FindBy(xpath = "(//option[@value='1'])[2]")
	WebElement minSelect;

	@FindBy(xpath = "//input[@value='Y']")
	WebElement adminMaxLOSY;

	@FindBy(xpath = "//input[@value='N']")
	WebElement adminMaxLOSN;

	@FindBy(xpath = "//input[@name='maxLOS']")
	WebElement adminInputMaxLOS;

	@FindBy(xpath = "(//div//div//h3)[1]")
	WebElement maxLOSErrorText;

	@FindBy(xpath = "//input[@name='minLeadTime']")
	WebElement adminMinLeadTime;

	@FindBy(xpath = "//input[@name='maxLeadTime']")
	WebElement adminMaxLeadTime;

	@FindBy(xpath = "//a[text()='Start over']")
	WebElement startOver;

	public PropertyLevelRestrictionPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to check Availability in BE
	 */

	public PropertyLevelRestrictionPage availabilityCheck() {
		Helper.implict(3);
		checkInCalander.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);

		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to input check in date in BE
	 */

	public PropertyLevelRestrictionPage availabilityCheckDates() {
		Helper.implict(3);
		checkInCalander.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify Text in BE return string s
	 */

	public String verifyBookNowBtn() {
		String s = bookNow.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to select Property Yield Restriction
	 */

	public PropertyLevelRestrictionPage adminPropertyYeildRestriction() {
		Helper.implict(3);
		adminPropertyYieldRestrictionOption.click();
		return null;
	}

	/*
	 * Method to apply do not allow option
	 */

	public PropertyLevelRestrictionPage adminDoNotAllowOption() {
		Helper.implict(3);
		adminDoNotAllowOption.click();
		return null;
	}

	/*
	 * Method to save restriction
	 */

	public PropertyLevelRestrictionPage adminSave() {
		Helper.implict(3);
		adminSaveButton.click();
		return null;
	}

	/*
	 * Method to allow same day restriction
	 */

	public PropertyLevelRestrictionPage adminAllowOption() {
		Helper.implict(3);
		adminAllowOption.click();
		return null;
	}

	/*
	 * Method to verify text for no booking available return String s
	 */

	public String verifyNoBookingText() {
		Helper.implict(3);
		String s = errorText.getText();
		String subS = s.substring(0, 43);
		System.out.println("Error Text: " + subS);
		return subS;
	}

	/*
	 * Method to apply do not allow after restriction
	 */

	public PropertyLevelRestrictionPage adminDoNotAllowAfterOption() {
		Helper.implict(3);
		adminDoNotAllowAfterOption.click();
		Helper.implict(3);
		minOption.click();
		Helper.implict(3);
		minSelect.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to apply maxLOS restriction
	 */

	public PropertyLevelRestrictionPage adminImposeMaxLOS() {
		Helper.implict(3);
		adminMaxLOSY.click();
		Helper.implict(3);
		adminInputMaxLOS.clear();
		Helper.implict(3);
		adminInputMaxLOS.sendKeys(ExcelData.getCellData("PropertyRestriction", "MaxLOS", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to check Availability for maxLOS
	 */

	public PropertyLevelRestrictionPage availabilityCheckForMaxLOS() {
		Helper.implict(3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkInCalander.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(ExcelData.getCellData("PropertyRestriction", "MaxLOS", 2));
		c.add(Calendar.DAY_OF_MONTH, (m + 1));
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		Helper.implict(3);
		checkOutCalander.click();
		Helper.implict(3);
		checkOutCalander.clear();
		checkOutCalander.sendKeys(newDate);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.implict(3);
		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify maxLOS text
	 */

	public String verifyMaxLOSErrorText() {
		String s = maxLOSErrorText.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to remove maxLOS
	 */

	public PropertyLevelRestrictionPage adminRemoverMaxLOS() {
		Helper.implict(3);
		adminMaxLOSN.click();
		adminInputMaxLOS.clear();
		return null;
	}

	/*
	 * Method to apply min lead time restriction
	 */

	public PropertyLevelRestrictionPage adminMinLeadTime() {
		Helper.implict(3);
		adminMinLeadTime.sendKeys(ExcelData.getCellData("PropertyRestriction", "MinLeadTime", 2));
		return null;
	}

	/*
	 * Method to clear min lead time restriction
	 */

	public PropertyLevelRestrictionPage adminMinLeadTimeClear() {
		Helper.implict(3);
		adminMinLeadTime.clear();
		return null;
	}

	/*
	 * Method to clear max lead time restriction
	 */

	public PropertyLevelRestrictionPage adminMaxLeadTimeClear() {
		Helper.implict(3);
		adminMaxLeadTime.clear();
		return null;
	}

	/*
	 * Method to apply max lead time restriction
	 */

	public PropertyLevelRestrictionPage adminMaxLeadTime() {
		Helper.implict(3);
		adminMaxLeadTime.sendKeys(ExcelData.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		return null;
	}

	/*
	 * Method to check availability for max lead time restriction
	 */

	public PropertyLevelRestrictionPage availabilityCheckForMaxLeadTime() {
		Helper.implict(3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(ExcelData.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, m);
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		Helper.implict(3);
		checkInCalander.click();
		Helper.implict(3);
		checkInCalander.clear();
		checkInCalander.sendKeys(newDate);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.implict(3);
		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to check availability for min max lead time restriction
	 */

	public PropertyLevelRestrictionPage availabilityCheckForMinMaxLeadTime() {
		Helper.implict(3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkInCalander.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(ExcelData.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, m);
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		Helper.implict(3);
		checkInCalander.click();
		Helper.implict(3);
		checkInCalander.clear();
		checkInCalander.sendKeys(newDate);
		Helper.implict(3);
		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to check availability for min max lead time and maxLOS restriction
	 */

	public PropertyLevelRestrictionPage availabilityCheckForMinMaxLOSLeadTime() {
		Helper.implict(3);
		checkInCalander.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(ExcelData.getCellData("PropertyRestriction", "MaxLeadTime", 2));
		c.add(Calendar.DAY_OF_MONTH, (m + 1));
		String newDate = sdf.format(c.getTime());
		System.out.println(newDate);
		Helper.implict(3);

		checkOutCalander.click();
		Helper.implict(3);
		checkOutCalander.clear();
		checkOutCalander.sendKeys(newDate);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to check availability for min max lead time and maxLOS restriction
	 * error 2
	 */

	public PropertyLevelRestrictionPage availabilityCheckForMinMaxLOSLeadTime08() {
		Helper.implict(3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		checkInCalander.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		String Date = checkInCalander.getAttribute("value");
		System.out.println(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int m = Integer.valueOf(ExcelData.getCellData("PropertyRestriction", "MinLeadTime", 2));
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Helper.implict(3);

		checkAvailability.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on bookNow
	 */

	public PropertyLevelRestrictionPage bookNow() {
		Helper.implict(3);
		bookNow.click();
		return null;
	}

	/*
	 * Method to click on start over
	 */

	public PropertyLevelRestrictionPage startOver() {
		Helper.implict(3);
		startOver.click();
		return null;
	}

}

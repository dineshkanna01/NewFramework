package com.admin.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;

public class RatesandInventoryPage extends AbstractBasePage {

	public RatesandInventoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//*[@id='10']/li[3]/a")
	WebElement rateGrid;
	
	@FindBy(xpath = "//*[@name='C1361']")
	WebElement selectRatePlan;
	
	@FindBy(xpath = "//*[@name='C1668']")
	WebElement selectRatePlan2;
	
	@FindBy(xpath = "//*[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;
	
	@FindBy(xpath = "//*[@name='endDate']")
	WebElement enddate;
	
	@FindBy(xpath = "//*[@name='overrideRoomHierarchy']")
	WebElement overrideRoomHierarchy;
	
	@FindBy(xpath = "//*[@value='Daily Rate & Inventory']")
	WebElement dailyRateInvButton;
	
	@FindBy(xpath = "//*[@id='rate_1361']")
	WebElement rate;
	
	@FindBy(xpath = "//span[text()='Standard Room']")
	WebElement selectRoomTypedropdwn;
	
	@FindBy(xpath = "//span[text()='3 selected']")
	WebElement selectedRoomTypedropdwn;
	
	@FindBy(xpath = "//*[@class='ms-selectall global']")
	WebElement selectAllRoomType;
	
	@FindBy(xpath = "//*[@value='Quick Entry']")
	WebElement quickEntryBtn;
	
	@FindBy(xpath = "//*[@value='Confirm']")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//*[@value='Update']")
	WebElement updateBtn;
	
	@FindBy(xpath = "(//*[@value='true'])[1]")
	WebElement stickyRateCheck;
	
	@FindBy(xpath = "(//*[@value='true'])[2]")
	WebElement stickyInvCheck;
	
	@FindBy(xpath = "(//*[@value='false'])[3]")
	WebElement stickyRateUncheck;
	
	@FindBy(xpath = "(//*[@value='false'])[4]")
	WebElement stickyInvUncheck;
	
	@FindBy(xpath = "//*[@id='maxLOS_1361']")
	WebElement maxLOS;
	
	@FindBy(xpath = "//*[@id='minLOS_1361']")
	WebElement minLOS;
	
	@FindBy(xpath = "//*[@id='O_1361']")
	WebElement openYieldControl;
	
	@FindBy(xpath = "//*[@id='C_1361']")
	WebElement closedYieldControl;

	/*
	 * Method to select Rate Grid
	 */
	public RatesandInventoryPage selectRateGrid() {
		rateGrid.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select Rate Plan
	 */
	public RatesandInventoryPage selectRatePlan() {
		selectRatePlan.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select Rate Plan2
	 */
	public RatesandInventoryPage selectRatePlan2() {
		selectRatePlan2.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify Rate Plan
	 */
	public boolean verifyRatePlan(String Rateplan) {
		String RatePlan1 = driver.findElement(By.xpath("(//*[contains(text(),'BAR')])[2]")).getText();
		System.out.println(RatePlan1 + "####");
		if (Rateplan.equalsIgnoreCase(RatePlan1)) {
			System.out.println("Rate Plan Matched");
			return true;
		} else {
			System.out.println("Rate Plan not Matched");
			return false;
		}
	}

	/*
	 * Method to verify Rate Plan2
	 */
	public boolean verifyRatePlan2(String Rateplan2) {
		String RatePlan2 = driver.findElement(By.xpath("(//*[contains(text(),'Sanskriti')])[1]")).getText();
		System.out.println(RatePlan2 + "####");
		if (Rateplan2.equalsIgnoreCase(RatePlan2)) {
			System.out.println("Rate Plan2 Matched");
			return true;
		} else {
			System.out.println("Rate Plan2 not Matched");
			return false;
		}
	}

	/*
	 * Method to click continueButton
	 */
	public RatesandInventoryPage continueButton() {
		continueButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select DateRange
	 */
	public RatesandInventoryPage selectDateRange() {
		Helper.implict(3);
		startdate.sendKeys(ExcelData.getCellData("RateGrid", "Date", 2));
		Helper.implict(3);
		enddate.sendKeys(ExcelData.getCellData("RateGrid", "EndDate", 2));
		return null;
	}

	/*
	 * Method to click override RoomCheckbox
	 */
	public RatesandInventoryPage clickoverrideRoomCheckbox() {
		overrideRoomHierarchy.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click dailyRateInvbutton
	 */
	public RatesandInventoryPage clickdailyRateInvbutton() {
		dailyRateInvButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to updateRate
	 */
	public RatesandInventoryPage updateRate() {
		rate.sendKeys(ExcelData.getCellData("RateGrid", "Rate", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click QuickEntrybutton
	 */
	public RatesandInventoryPage clickQuickEntrybutton() {
		quickEntryBtn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click Updatebutton
	 */
	public RatesandInventoryPage clickUpdatebutton() {
		updateBtn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click Confirmbutton
	 */
	public RatesandInventoryPage clickConfirmbutton() {
		confirmBtn.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify Rate
	 */
	public boolean verifyRate() {
		List<WebElement> Rates = driver.findElements(By.xpath("//*[contains(@name,'rateOldRate')]"));
		String RateExcel = ExcelData.getCellData("RateGrid", "Rate", 2);
		// RateExcel = RateExcel.replaceAll("\\.0*$", "");
		System.out.println(RateExcel + "####");
		int flag = 1;
		for (WebElement ele : Rates) {
			String Rate = ele.getAttribute("value");
			System.out.println(Rate + "@####");
			if (Rate.equals(RateExcel)) {
				System.out.println("....Rates Matched....");
				flag = 1;
			} else {
				System.out.println("....Rates Did not Match....");
				flag = 0;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	/*
	 * Method to select ALLRoomType
	 */
	public RatesandInventoryPage selectALLRoomType() {
		selectRoomTypedropdwn.click();
		Helper.implict(3);
		selectAllRoomType.click();
		Helper.implict(3);
		selectedRoomTypedropdwn.click();
		System.out.println("All Rooms selected");
		return null;
	}

	/*
	 * Method to updateRateforDaysOfweek
	 */
	public RatesandInventoryPage updateRateforDaysOfweek() {
		rate.sendKeys(ExcelData.getCellData("RateGrid", "Rate", 2));
		Helper.implict(3);
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String day = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
		System.out.println(day);
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < checkbox.size(); i++) {
			String val = checkbox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase("All"))
				checkbox.get(i).click();
			if (val.equalsIgnoreCase(day))
				checkbox.get(i).click();
			Helper.implict(3);
		}
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to stickyCheck
	 */
	public RatesandInventoryPage stickyCheck() {
		Helper.implict(3);
		stickyRateCheck.click();
		stickyInvCheck.click();
		// Thread.sleep(1000);
		return null;
	}

	/*
	 * Method to stickyUnCheck
	 */
	public RatesandInventoryPage stickyUncheck() {
		stickyRateUncheck.click();
		stickyInvUncheck.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify stickyRates
	 * 
	 */
	public boolean verifyStickyRates() {
		List<WebElement> RateCheckbox = driver
				.findElements(By.xpath("//*[contains(@name,'stickyprice') and @type='checkbox']"));
		int flag = 1;
		for (WebElement ele : RateCheckbox) {
			if (ele.isSelected()) {
				flag = 1;
				System.out.println("Rate override checkbox selected : " + ele.isSelected());
			} else {
				System.out.println("Rate override checkbox is not selected : " + ele.isSelected());
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	/*
	 * Method to verify Sticky Inventory
	 * 
	 */
	public boolean verifyStickyInventory() {
		List<WebElement> InvCheckbox = driver
				.findElements(By.xpath("//*[contains(@name,'stickyinventory') and @type='checkbox']"));
		int flag = 1;
		for (WebElement ele : InvCheckbox) {
			if (ele.isSelected()) {
				flag = 1;
				System.out.println("Inventory override checkbox selected : " + ele.isSelected());
			} else {
				System.out.println("Inventory override checkbox is not selected :" + ele.isSelected());
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}
	
	/*
	 * Method to updateMinMaxLOS
	 * 
	 */
	public RatesandInventoryPage updateMinMaxLOS() {
		maxLOS.sendKeys(ExcelData.getCellData("RateGrid", "MaxLOS", 2));
		Helper.implict(3);
		minLOS.sendKeys(ExcelData.getCellData("RateGrid", "MinLOS", 2));
		return null;
	}

	/*
	 * Method to verifyMinLOS
	 * 
	 */
	public boolean verifyMinLOS() {
		List<WebElement> minLOS = driver.findElements(By.xpath("//*[contains(@id,'minLOS') and @class='input']"));
		String MinLOSExcel = ExcelData.getCellData("RateGrid", "MinLOS", 2);
		System.out.println(MinLOSExcel + ": MinLOS value in excel");
		int flag = 1;
		for (WebElement ele : minLOS) {
			String val = ele.getAttribute("value");
			System.out.println(val + ": MinLOS ######");
			if (val.equals(MinLOSExcel)) {
				System.out.println("MinLOS Matched");
				flag = 1;
			} else {
				System.out.println("MinLOS not Matched");
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	/*
	 * Method to verifyMaxLOS
	 * 
	 */
	public boolean verifyMaxLOS() {
		List<WebElement> maxLOS = driver.findElements(By.xpath("//*[contains(@id,'maxLOS') and @class='input']"));
		String MaxLOSExcel = ExcelData.getCellData("RateGrid", "MaxLOS", 2);
		System.out.println(MaxLOSExcel + ": MaxLOS value in excel");
		int flag = 1;
		for (WebElement ele : maxLOS) {
			String val = ele.getAttribute("value");
			System.out.println(val + ": MaxLOS ######");
			if (val.equals(MaxLOSExcel)) {
				System.out.println("MaxLOS Matched");
				flag = 1;
			} else {
				System.out.println("MaxLOS not Matched");
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	/*
	 * Method to openYieldControls
	 */
	public RatesandInventoryPage openYieldControls() {
		openYieldControl.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to closeYieldControls
	 */
	public RatesandInventoryPage closeYieldControls() {
		closedYieldControl.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verifyopenYieldControls
	 */
	public boolean verifyopenYieldControls() {
		List<WebElement> openYield = driver.findElements(By.xpath("(//*[contains(@name,'noc') and @value='O'])"));
		int flag = 1;
		for (WebElement ele : openYield) {
			if (ele.isSelected()) {
				flag = 1;
				System.out.println("Open Yield Control selected : " + ele.isSelected());
			} else {
				System.out.println("Open Yield Control is not selected : " + ele.isSelected());
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	/*
	 * Method to verifycloseYieldControls
	 */
	public boolean verifycloseYieldControls() {
		List<WebElement> closeYield = driver.findElements(By.xpath("(//*[contains(@name,'noc') and @value='C'])"));
		int flag = 1;
		for (WebElement ele : closeYield) {
			if (ele.isSelected()) {
				flag = 1;
				System.out.println("close Yield Control selected : " + ele.isSelected());
			} else {
				System.out.println("close Yield Control is not selected : " + ele.isSelected());
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}
}

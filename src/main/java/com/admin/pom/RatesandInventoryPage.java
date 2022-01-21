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
import base.TestBase;
import pages.AbstractBasePage;

public class RatesandInventoryPage extends AbstractBasePage {
	
	ExcelData e = new ExcelData();

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

	//	@FindBy(xpath = "(//*[contains(@src,'button_calendar.gif')])[1]")
	//	WebElement Startdateicon;

	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;
	//	
	//	@FindBy(xpath = "(//*[contains(@src,'button_calendar.gif')])[2]")
	//	WebElement Enddateicon;

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

	public RatesandInventoryPage selectRateGrid() throws InterruptedException {
		rateGrid.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage selectRatePlan() throws InterruptedException {
		selectRatePlan.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage selectRatePlan2() throws InterruptedException {
		selectRatePlan2.click();
		TestBase.implict(3);

		return null;
	}

	public boolean verifyRatePlan(String Rateplan) throws Exception {

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

	public boolean verifyRatePlan2(String Rateplan2) throws Exception {

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

	public RatesandInventoryPage continueButton() throws InterruptedException {
		continueButton.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage selectDateRange() throws Exception {
		// Startdateicon.click();
		TestBase.implict(3);
		startdate.sendKeys(e.getCellData("RateGrid", "Date", 2));
		//		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yy");
		//		 
		//		 //get current date time with Date()
		//		 Date date = new Date();
		//		 
		//		 // Now format the date
		//		 String date1= dateFormat.format(date);
		//		 System.out.println(date1+": Current date");
		//
		//		Startdate.sendKeys(date1);

		//		Enddateicon.click();
		TestBase.implict(3);
		//		Enddate.sendKeys(date1);
		enddate.sendKeys(e.getCellData("RateGrid", "EndDate", 2));
		return null;
	}

	public RatesandInventoryPage clickoverrideRoomCheckbox() throws InterruptedException {
		overrideRoomHierarchy.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage clickdailyRateInvbutton() throws InterruptedException {
		dailyRateInvButton.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage updateRate() throws Exception {
		rate.sendKeys(e.getCellData("RateGrid", "Rate", 2));
		TestBase.implict(3);

		return null;
	}

	public RatesandInventoryPage clickQuickEntrybutton() throws InterruptedException {
		quickEntryBtn.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage clickUpdatebutton() throws InterruptedException {
		updateBtn.click();
		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage clickConfirmbutton() throws InterruptedException {
		confirmBtn.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyRate() throws Exception {

		List<WebElement> Rates = driver.findElements(By.xpath("//*[contains(@name,'rateOldRate')]"));


		String RateExcel = e.getCellData("RateGrid", "Rate", 2);
		//RateExcel = RateExcel.replaceAll("\\.0*$", "");
		System.out.println(RateExcel + "####");

		int flag=1;
		for (WebElement ele : Rates) {
			String Rate = ele.getAttribute("value");
			System.out.println(Rate + "@####");
			if (Rate.equals(RateExcel)) {

				System.out.println("....Rates Matched....");
				flag=1;
			} else {
				System.out.println("....Rates Did not Match....");
				flag=0;
			}
		}

		if (flag == 1)
			return true;
		else
			return false;
	}

	public RatesandInventoryPage selectALLRoomType() throws InterruptedException {
		selectRoomTypedropdwn.click();
		TestBase.implict(3);
		selectAllRoomType.click();
		TestBase.implict(3);
		selectedRoomTypedropdwn.click();
		System.out.println("All Rooms selected");

		return null;
	}

	public RatesandInventoryPage updateRateforDaysOfweek() throws Exception {
		rate.sendKeys(e.getCellData("RateGrid", "Rate", 2));
		TestBase.implict(3);
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
			TestBase.implict(3);
		}

		TestBase.implict(3);

		return null;
	}

	public RatesandInventoryPage stickyCheck() throws InterruptedException {
		TestBase.implict(3);
		stickyRateCheck.click();
		stickyInvCheck.click();
		// Thread.sleep(1000);
		return null;
	}

	public RatesandInventoryPage stickyUncheck() throws InterruptedException {
		stickyRateUncheck.click();
		stickyInvUncheck.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyStickyRates() throws InterruptedException {

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

	public boolean verifyStickyInventory() throws InterruptedException {

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

	public RatesandInventoryPage updateMinMaxLOS() throws Exception {
		maxLOS.sendKeys(e.getCellData("RateGrid", "MaxLOS", 2));
		TestBase.implict(3);
		minLOS.sendKeys(e.getCellData("RateGrid", "MinLOS", 2));
		return null;
	}

	public boolean verifyMinLOS() throws Exception {
		List<WebElement> minLOS = driver.findElements(By.xpath("//*[contains(@id,'minLOS') and @class='input']"));

		String MinLOSExcel = e.getCellData("RateGrid", "MinLOS", 2);
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

	public boolean verifyMaxLOS() throws Exception {
		List<WebElement> maxLOS = driver.findElements(By.xpath("//*[contains(@id,'maxLOS') and @class='input']"));
		String MaxLOSExcel = e.getCellData("RateGrid", "MaxLOS", 2);
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

	public RatesandInventoryPage openYieldControls() throws InterruptedException {
		openYieldControl.click();

		TestBase.implict(3);
		return null;
	}

	public RatesandInventoryPage closeYieldControls() throws InterruptedException {
		closedYieldControl.click();

		TestBase.implict(3);
		return null;
	}

	public boolean verifyopenYieldControls() throws InterruptedException {

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

	public boolean verifycloseYieldControls() throws InterruptedException {

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

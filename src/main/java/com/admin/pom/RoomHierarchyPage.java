package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import pages.AbstractBasePage;

public class RoomHierarchyPage extends AbstractBasePage {
	ExcelData e = new ExcelData();

	public RoomHierarchyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@name='newbase']")
	WebElement baseRoom;

	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement startDate;

	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement endDate;

	@FindBy(id="saveButton")
	WebElement Save;

	@FindBy(xpath="//h1[text()='Administrator Home']")
	WebElement administratorName;


	@FindBy(xpath="//span[text()='Start Date and End Date should not be empty.']")
	WebElement roomHierarchyErrorMsg ;

	public RoomHierarchyPage selectBaseroom() throws Exception {
		Select s=new Select(baseRoom);
		s.selectByVisibleText(e.getCellData("Sheet1","baseRoom",2));
		Thread.sleep(2000);
		return null;
	}

	public RoomHierarchyPage enterStarDate1() throws Exception {
		startDate.sendKeys(e.getCellData("Sheet1","dateIn",2));
		Thread.sleep(2000);
		return null;
	}

	public RoomHierarchyPage enterStarDate2() throws Exception {
		startDate.sendKeys(e.getCellData("Sheet1","dateIn",3));
		Thread.sleep(2000);
		return null;
	}

	public RoomHierarchyPage enterEndDate1() throws Exception {
		endDate.sendKeys(e.getCellData("Sheet1","dateOut",2));
		Thread.sleep(2000);
		return null;
	}

	public RoomHierarchyPage enterEndDate2() throws Exception {
		endDate.sendKeys(e.getCellData("Sheet1","dateOut",3));
		Thread.sleep(2000);
		return null;
	}

	public RoomHierarchyPage clickOnSave() throws InterruptedException {
		Save.click();
		Thread.sleep(2000);
		return null;
	}

	public RoomHierarchyPage clearStartDate() {
		startDate.clear();
		return null;
	}

	public RoomHierarchyPage clearEndDate() {
		endDate.clear();
		return null;
	}

	public String administratorname() {
		return administratorName.getText();
	}

	public String roomHierarchyError() {
		return roomHierarchyErrorMsg.getText();
	}	
}

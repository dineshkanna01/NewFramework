package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;

/*
 * Pom class for Room Hierarchy
 * @author Sudhakar Mourya
 */
public class RoomHierarchyPage extends AbstractBasePage {

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

	@FindBy(id="addNewHierarchyButton")
	WebElement newHierarchy;
	
	/*
	 * Method for select base room
	 */
	public RoomHierarchyPage selectBaseroom(){
		Select s=new Select(baseRoom);
		s.selectByVisibleText(ExcelData.getCellData("Sheet1","baseRoom",2));
		Helper.implict(3);
		return null;
	}
	
	public RoomHierarchyPage btnNewHierarchy() {
		newHierarchy.click();
		return null;

	}

	/*
	 * Method for enter start date1
	 */
	public RoomHierarchyPage enterStarDate1() {
		startDate.sendKeys(ExcelData.getCellData("Sheet1","dateIn",2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method for enter start date2
	 */
	public RoomHierarchyPage enterStarDate2(){
		startDate.sendKeys(ExcelData.getCellData("Sheet1","dateIn",3));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method for enter end date1
	 */
	public RoomHierarchyPage enterEndDate1(){
		endDate.sendKeys(ExcelData.getCellData("Sheet1","dateOut",2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method for enter end date2
	 */
	public RoomHierarchyPage enterEndDate2(){
		endDate.sendKeys(ExcelData.getCellData("Sheet1","dateOut",3));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method for click on save
	 */
	public RoomHierarchyPage clickOnSave(){
		Save.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method for clear start date
	 */
	public RoomHierarchyPage clearStartDate() {
		startDate.clear();
		return null;
	}

	/*
	 * Method for clear end date
	 */
	public RoomHierarchyPage clearEndDate() {
		endDate.clear();
		return null;
	}

	/*
	 * Method for getting administrator name text
	 * @return String administrator name
	 */
	public String administratorname() {
		return administratorName.getText();
	}

	/*
	 * Method for getting room hierarchy error text
	 * @return String error msg
	 */
	public String roomHierarchyError() {
		return roomHierarchyErrorMsg.getText();
	}	
}

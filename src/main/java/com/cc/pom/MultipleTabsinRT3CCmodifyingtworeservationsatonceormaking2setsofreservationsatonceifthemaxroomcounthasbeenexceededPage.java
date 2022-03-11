package com.cc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/* POM class for MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded  
* @author Rudraksh Aggarwal
*/
public class MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceededPage
		extends TestBase {

	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dt")
	WebElement confirmcodeHeading;

	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dd")
	WebElement confirmcode;

	public MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceededPage(
			WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to verify Confirmation Code and store it in excel TC01_1
	 * 
	 */
	public boolean verifyConfirmationCodeTC01_1() {
		Helper.waitVisibility(50, "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dt");
		if (confirmcodeHeading.isDisplayed()) {
			String codehead = confirmcodeHeading.getText();
			String code = confirmcode.getText();
			System.out.println(codehead + " is :" + code);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 68, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
	
	/*
	 * Method to verify Confirmation Code and store it in excel TC01_2
	 * 
	 */
	public boolean verifyConfirmationCodeTC01_2() {
		Helper.waitVisibility(50, "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dt");
		if (confirmcodeHeading.isDisplayed()) {
			String codehead = confirmcodeHeading.getText();
			String code = confirmcode.getText();
			System.out.println(codehead + " is :" + code);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 68, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
	
	/*
	 * Method to verify if rooms are modified or not TC02_1
	 */
	public boolean verifyRoomModifyTC02_1() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomBefore", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("rooms are not modified TC02_1");
			return false;
		} else {
			System.out.println("rooms are modified TC02_1");
			return true;
		}
	}
	
	/*
	 * Method to verify if rooms are modified or not TC02_1
	 */
	public boolean verifyRoomModifyTC02_2() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomBefore", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("rooms are not modified TC02_2");
			return false;
		} else {
			System.out.println("rooms are modified TC02_2");
			return true;
		}
	}
}

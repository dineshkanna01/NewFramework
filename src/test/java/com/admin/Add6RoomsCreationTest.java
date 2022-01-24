package com.admin;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.Add6RoomsCreationPage;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;

import Utility.ExcelData;
import base.TestBase;

public class Add6RoomsCreationTest extends TestBase {

	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	Add6RoomsCreationPage arcp;
	SoftAssert soft;
	
	public Add6RoomsCreationTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		lp=new LoginPage(getDriver());	
		ahp=new AdministratorHomePage(getDriver());
		arcp=new Add6RoomsCreationPage(getDriver());
		soft= new SoftAssert();
	}
	
	@Test
	public void add6RoomsCreation_TC_01() throws Exception {
		extentTest = extent.startTest("add6RoomsCreation_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickOnRoomTab();
		ahp.clickOnAddNew();
		arcp.add6Rooms();
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(e.getCellData("Sheet1","roomName",2)));
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(e.getCellData("Sheet1","roomName",5)));
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(e.getCellData("Sheet1","roomName",3)));
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(e.getCellData("Sheet1","roomName",4)));
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(e.getCellData("Sheet1","roomName",6)));
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(e.getCellData("Sheet1","roomName",7)));
		soft.assertAll();
	}
	
    @Test
	public void add6RoomsCreation_TC_02() throws Exception {
		extentTest = extent.startTest("add6RoomsCreation_TC_02");
	    ahp.clickOnListAllRoom();
		arcp.clickOnEdit();
		arcp.editRoom();
		soft.assertTrue(arcp.verifyadd6RoomCreation_TC02());
        soft.assertAll();
      }
	
	 @Test
	 public void add6RoomsCreation_TC_03() throws Exception {
		extentTest = extent.startTest("add6RoomsCreation_TC_03");
		  ahp.clickOnAddNew();
		  arcp.enterRoomName(e.getCellData("Sheet1","roomName",8));
		  arcp.enterRoomCode(e.getCellData("Sheet1","roomCode",8));
		  arcp.clickOnBigsizeBed();
		  arcp.uploadImage();
		  arcp.enterExtraAdultPerRoomCharge("100");
		  arcp.enterExtraChildPerRoomCharge("30");
		  arcp.selectMaxNoOfAdultForDefaultprice("2");
		  arcp.enterMinAdultLimit("1");
		  arcp.enterMaxAdultLimit("3");
		  arcp.enterMinChildLimit("0");
		  arcp.enterMaxChildLimit("3");
		  arcp.enterTotalMaxOccupancy("6");
		  arcp.clickOnSave();
		  arcp.clickOnLastCheckbox();
		  arcp.clickOnDelete();
		  arcp.clickOnYes();
		  soft.assertTrue(arcp.verifyadd6RoomCreation_TC03(e.getCellData("Sheet1","roomName",8)));
		  soft.assertAll();
	}
	 
	@Test
	public void add6RoomsCreation_TC_04() throws Exception {
		  extentTest = extent.startTest("add6RoomsCreation_TC_04");
		  ahp.clickOnAddNew();
		  arcp.enterRoomName(e.getCellData("Sheet1","roomName",9));
		  arcp.enterRoomCode(e.getCellData("Sheet1","roomCode",9));
		  arcp.clickOnBigsizeBed();
		  arcp.uploadImage();
		  arcp.enterExtraAdultPerRoomCharge("100");
		  arcp.enterExtraChildPerRoomCharge("30");
		  arcp.selectMaxNoOfAdultForDefaultprice("2");
		  arcp.enterMinAdultLimit("1");
		  arcp.enterMaxAdultLimit("3");
		  arcp.enterMinChildLimit("0");
		  arcp.enterMaxChildLimit("3");
		  arcp.enterTotalMaxOccupancy("6");
		  arcp.clickOnSave();
		  soft.assertTrue(arcp.verifyadd6RoomCreation_TC04());
		  soft.assertAll();
		  lp.logout();	
	 }
	
	 @AfterSuite
	 public void report() throws Exception {
		mail();
		cmdPrompt();
	}
	 
}

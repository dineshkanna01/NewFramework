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

/*
 * Test class for Add 6 Room Creation 
 * @author Sudhakar Mourya
 */
public class Add6RoomsCreationTest extends TestBase {
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
	
	/*
	 * Method for add 6 room creation TC01
	 */
	@Test
	public void add6RoomsCreation_TC_01(){
		extentTest = extent.startTest("add6RoomsCreation_TC_01");
		try {
			lp.login();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickOnRoomTab();
		ahp.clickOnAddNew();
		try {
			arcp.add6Rooms();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			allureScreenshot("6 Room Created");
						
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(ExcelData.getCellData("Sheet1","roomName",2)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(ExcelData.getCellData("Sheet1","roomName",5)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(ExcelData.getCellData("Sheet1","roomName",3)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(ExcelData.getCellData("Sheet1","roomName",4)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(ExcelData.getCellData("Sheet1","roomName",6)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC01(ExcelData.getCellData("Sheet1","roomName",7)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soft.assertAll();
	}
	
	/*
	 * Method for add 6 room creation TC02
	 */
    @Test
	public void add6RoomsCreation_TC_02(){
		extentTest = extent.startTest("add6RoomsCreation_TC_02");
	    ahp.clickOnListAllRoom();
		arcp.clickOnEdit();
		try {
			arcp.editRoom();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			allureScreenshot("Room Edited");
		}
		try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC02());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        soft.assertAll();
      }
	
    /*
	 * Method for add 6 room creation TC03
	 */
	 @Test
	 public void add6RoomsCreation_TC_03(){
		extentTest = extent.startTest("add6RoomsCreation_TC_03");
		  ahp.clickOnAddNew();
		  arcp.enterRoomName(ExcelData.getCellData("Sheet1","roomName",8));
		  arcp.enterRoomCode(ExcelData.getCellData("Sheet1","roomCode",8));
		  arcp. entergdsCode(ExcelData.getCellData("Sheet1","gdsCode",8));
		  arcp.clickOnBigsizeBed();
		  try {
			arcp.uploadImage();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  arcp.enterExtraAdultPerRoomCharge("100");
		  arcp.enterExtraChildPerRoomCharge("30");
		  arcp.selectMaxNoOfAdultForDefaultprice("2");
		  arcp.enterMinAdultLimit("1");
		  arcp.enterMaxAdultLimit("3");
		  arcp.enterMinChildLimit("0");
		  arcp.enterMaxChildLimit("3");
		  arcp.enterTotalMaxOccupancy("6");
		  arcp.clickOnSave();
		  allureScreenshot("Room Created");
		  arcp.clickOnLastCheckbox();
		  arcp.clickOnDelete();
		  arcp.clickOnYes();
		  allureScreenshot("Room Deleted");
		  try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC03(ExcelData.getCellData("Sheet1","roomName",8)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  soft.assertAll();
		 
	}
	 
	 /*
	  * Method for add 6 room creation TC04
	  */
	@Test
	public void add6RoomsCreation_TC_04(){
		  extentTest = extent.startTest("add6RoomsCreation_TC_04");
		  ahp.clickOnAddNew();
		  arcp.enterRoomName(ExcelData.getCellData("Sheet1","roomName",9));
		  arcp.enterRoomCode(ExcelData.getCellData("Sheet1","roomCode",9));
		  arcp. entergdsCode(ExcelData.getCellData("Sheet1","gdsCode",9));
		  arcp.clickOnBigsizeBed();
		  try {
			arcp.uploadImage();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  arcp.enterExtraAdultPerRoomCharge("100");
		  arcp.enterExtraChildPerRoomCharge("30");
		  arcp.selectMaxNoOfAdultForDefaultprice("2");
		  arcp.enterMinAdultLimit("1");
		  arcp.enterMaxAdultLimit("3");
		  arcp.enterMinChildLimit("0");
		  arcp.enterMaxChildLimit("3");
		  arcp.enterTotalMaxOccupancy("6");
		  arcp.clickOnSave();
		  allureScreenshot("Existing room code error");
		  try {
			soft.assertTrue(arcp.verifyadd6RoomCreation_TC04());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  soft.assertAll();
		  arcp.deleteRoom();
			lp.logout();
	 }
	
	 @AfterSuite
	 public void report(){
		try {
			mail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmdPrompt();
	}

}

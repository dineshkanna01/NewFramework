package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AboutThePropertyPages;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;

import Utility.ExcelData;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

/*
 * Test class for  About the property Scenario
 * @author Ankita mohamanasingh
 */
public class AboutPropertyCreationScenario extends TestBase {
	
	public static Utilitylog logger;

	ExcelData e = new ExcelData();

	public AboutPropertyCreationScenario() {
		super();
		logger = new Utilitylog(AboutPropertyCreationScenario.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	AboutThePropertyPages atp;

	@BeforeMethod
	public void setup() {

		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		atp = new AboutThePropertyPages(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify that user should be able to create Room in the property")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:About the property dining creation scenario")
	@Story("About the property dining creation scenario")
	@Step("Verify that user should be able to create Room in the property")
	public void aboutPropertyRoomCreationScenario_TC_01() {
		extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_01");

		lp.clickClearButton();

		lp.login();

		ahp.selectBrand();

		ahp.selectProperty();

		ahp.selectPropertyManagement();

		//		 atp.enableAboutTheProperty();                       // For first time run for any property
		atp.selectAboutTheProperty();
		atp.clickAddaRoom();

		atp.addaRoomAboutTheProperty();
		atp.clickSave();
		allureScreenshot("RoomCreated");

		screenShot("RoomCreated");

		atp.verifyRoomCreated();
		Assert.assertTrue(atp.verifyRoomCreated());

	}
	
		@Test(priority = 2)
		@Description("Verify that user should be able to create multiple Room in the property")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that user should be able to create multiple Room in the property")
		public void aboutPropertyRoomCreationScenario_TC_02() {
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_02");
	
			atp.clickAddaRoom();
			atp.addMultipleRoomAboutTheProperty1();
			atp.clickSave();
			allureScreenshot("RoomCreated");
			Assert.assertTrue(atp.verifyMultipleRoom1Created());
			atp.clickAddaRoom();
			atp.addMultipleRoomAboutTheProperty2();
			atp.clickSave();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			Assert.assertTrue(atp.verifyMultipleRoom2Created());
		}
	
		@Test(priority = 3)
		@Description("Verify that user should not  be able to create room with duplicate code .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that user should not  be able to create room with duplicate code ")
		public void aboutPropertyRoomCreationScenario_TC_03() {
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_03");
	
			atp.clickAddaRoom();
			atp.createDuplicateRoom();
			atp.clickSave();
			atp.clickAddaRoom();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			atp.createDuplicateRoom();
			atp.clickSave();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			Assert.assertTrue(atp.verifyDuplicateRoomnotCreated());
	
		}
	
		@Test(priority = 4)
		@Description("Verify that user should be able to create  and delete Room in About  the property ")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that user should be able to create  and delete Room in About  the property")
		public void aboutPropertyRoomCreationScenario_TC_04() {
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_04");
	
			atp.selectAboutTheProperty();
			atp.clickAddaRoom();
			atp.addandDeleteRoomAboutTheProperty();
			atp.clickSave();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			Assert.assertTrue(atp.verifyCreatedRoom());
			atp.clickDelete();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			Assert.assertFalse(atp.verifyCreatedRoom());
	
		}
	
		@Test(priority = 5)
		@Description("Verify that user should be able to  delete already created  Room in About  the property .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that user should be able to  delete already created  Room in About  the property")
		public void aboutPropertyRoomCreationScenario_TC_05() {
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_05");
	
			atp.clickDelete();
			allureScreenshot("RoomDeleted");
	
			screenShot("RoomDeleted");
	
			Assert.assertTrue(atp.verifyDeletedRoom());
		}
	
		@Test(priority = 6)
		@Description("Verify that user should be able to create  and edit Room in About the property ")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that user should be able to create  and edit Room in About the property")
		public void aboutPropertyRoomCreationScenario_TC_06() {
	
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_06");
			atp.clickAddaRoom();
			atp.createForEditARoom();
			atp.clickSave();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			Assert.assertTrue(atp.verifyCreatedRoomForEdit());
			Assert.assertTrue(atp.verifyMeetingRoomEdited());
	
			atp.editTheCreatedRoom();
			atp.clickSave();
	
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			Assert.assertFalse(atp.verifyMeetingRoomEdited());
		}
	
		@Test(priority = 7)
		@Description("Verify that user should be able to  edit already existed Room in About the property  ")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that user should be able to  edit already existed Room in About the property")
		public void aboutPropertyRoomCreationScenario_TC_07() {
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_07");
	
			Assert.assertFalse(atp.verifyExistedMeetingRooomEdited());
	
			atp.editARoom();
			atp.clickSave();
			allureScreenshot("RoomCreated");
			screenShot("RoomCreated");
			Assert.assertTrue(atp.verifyExistedMeetingRooomEdited());
	
		}
	
		@Test(priority=8)
		@Description("Verify user is getting different sub - dropdown for different Service drop down  .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify that Verify user is getting different sub - dropdown for different Service drop down ")
		public void aboutPropertyRoomCreationScenario_TC_08() {
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_08");
			atp.clickAddaRoom();
			atp.serviceSubdropdownPresentation();
			atp.clickSave();
	
			atp.editServiceDropdown();
			
			atp.clickSave();
	
		}
	
	
		@Test(priority = 9)
		@Description("Verify user is getting automatically  correct calculation in Area text field after filling length and width text  field .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining creation scenario")
		@Story("About the property dining creation scenario")
		@Step("Verify calculated Area")
		public void aboutPropertyRoomCreationScenario_TC_09() {
	
			extentTest = extent.startTest("aboutPropertyRoomCreationScenario_TC_09");
			atp.clickAddaRoom();
			atp.verifyTheArea();
			atp.clickSave();
			Assert.assertTrue(atp.verifyCalculatedArea());
	
		}
	
		@Test(priority = 10)
		@Description("Verify that  User is able to create Dining .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User is able to create Dining ")
		public void aboutPropertyDiningCreationScenario_TC_01() {
	
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_01");
			atp.clickdiningaddalocation();
			atp.addaDiningAboutTheProperty();
			allureScreenshot("RoomCreated");
	
			screenShot("RoomCreated");
	
			atp.clickSave();
	
			allureScreenshot("DiningCreated");
	
			screenShot("DiningCreated");
	
			atp.verifyCreatedDining();
			Assert.assertTrue(atp.verifyCreatedDining());
	
		}
	
		@Test(priority = 11)
		@Description("Verify that  User is able to create multiple Dining   .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User is able to create multiple Dining")
		public void aboutPropertyDiningCreationScenario_TC_02() {
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_02");
	
			atp.clickdiningaddalocation();
			atp.addaMultipleDiningAboutTheProperty1();
			atp.clickSave();
			allureScreenshot("DiningCreated");
			screenShot("DiningCreated");
			Assert.assertTrue(atp.verifyMultipleDining1Created());
			atp.clickdiningaddalocation();
			atp.addaMultipleDiningAboutTheProperty2();
			atp.clickSave();
	
			allureScreenshot("DiningCreated");
			screenShot("DiningCreated");
			Assert.assertTrue(atp.verifyMultipleDining2Created());
	
		}
	
		@Test(priority = 12)
		@Description("Verify that  User should not be able to   create multiple Dining with same Code  .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User should not be able to   create multiple Dining with same Code  ")
		public void aboutPropertyDiningCreationScenario_TC_03() {
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_03");
			atp.clickdiningaddalocation();
			atp.invalidMultipleDiningAboutTheProperty();
			atp.clickSave();
			allureScreenshot("DiningCreated");
			screenShot("DiningCreated");
			atp.clickdiningaddalocation();
			atp.invalidMultipleDiningAboutTheProperty();
			atp.clickSave();
	
			allureScreenshot("DiningCannotCreated");
			screenShot("DiningCannotCreated");
			Assert.assertTrue(atp.verifyDuplicateDiningnotCreated());
	
		}
	
		@Test(priority = 13)
		@Description("Verify that  User should able to create and delete dining .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User should able to create and delete dining ")
		public void aboutPropertyDiningCreationScenario_TC_04() {
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_04");
			atp.selectAboutTheProperty();
			atp.clickdiningaddalocation();
			atp.createandDeleteDiningAboutTheProperty();
			atp.clickSave();
			allureScreenshot("DiningCreated");
			screenShot("DiningCreated");
			Assert.assertTrue(atp.verifyDiningCreated());
			atp.clickDeleteDining();
	
			allureScreenshot("DiningDeleted");
	
			screenShot("DiningDeleted");
			Assert.assertFalse(atp.verifyDiningCreated());
	
		}
	
		@Test(priority = 14)
		@Description("Verify that  User should able to create and edit dining .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User should able to create and edit dining")
		public void aboutPropertyDiningCreationScenario_TC_05() {
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_05");
	
			atp.clickdiningaddalocation();
			atp.createForEditDiningAboutTheProperty();
			atp.clickSave();
	
			allureScreenshot("DiningCreated");
			
			screenShot("DiningCreated");
			Assert.assertTrue(atp.verifyCreatedDiningForEdit()); 
			Assert.assertTrue(atp.verifyExistedDiningEdited());
	
			atp.editCreatedDiningAboutTheProperty();atp.clickSave();
	
			allureScreenshot("DiningEdited");
			
			screenShot("DiningEdited");
			
			Assert.assertFalse(atp.verifyExistedDiningEdited());
	
		}
	
		@Test(priority = 15)
		@Description("Verify that  User should able to edit existed dining .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User should able to edit existed dining ")
		public void aboutPropertyDiningCreationScenario_TC_06() {
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_06");
	
			Assert.assertFalse(atp.verifyExistedDiningEdited());
			atp.editExistedDiningAboutTheProperty();
			atp.clickSave();
			allureScreenshot("DiningEdited");
			screenShot("DiningEdited");
			Assert.assertTrue(atp.verifyExistedDiningEdited());
	
		}
	
		@Test(priority = 16)
		@Description("Verify that  User should able to delete existed dining .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property dining cretaion")
		@Story("About the property dining cretaion")
		@Step("Verify that  User should able to delete existed dining")
		public void aboutPropertyDiningCreationScenario_TC_07() {
			extentTest = extent.startTest("aboutPropertyDiningCreationScenario_TC_07");
	
			atp.clickDeleteDining();
			allureScreenshot("DiningDeleted");
			screenShot("DiningDeleted");
			Assert.assertTrue(atp.verifyDiningDeleted());
	
		}
	
		@Test(priority = 17)
		@Description("Verify that  User should able to create Airport Location .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User should able to create Airport Location ")
		public void aboutPropertyAirportCreationScenario_TC_01() {
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_01");
	
			atp.clickairportlocation();
			atp.createNearbyAirportLocationAboutTheProperty();
			atp.clickSave();
			allureScreenshot("AirportLocationCreated");
			screenShot("AirportLocationCreated");
			atp.verifyCreatedAirportlocation();
			Assert.assertTrue(atp.verifyCreatedAirportlocation());
	
		}
	
		@Test(priority = 18)
		@Description("Verify that  User is able to   create  multiple Property Near By Airport location .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User is able to   create  multiple Property Near By Airport location ")
		public void aboutPropertyAirportCreationScenario_TC_02() {
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_02");
	
			atp.clickairportlocation();
			atp.createMultipleNearbyAirportLocationAboutTheProperty1();
			atp.clickSave();
			allureScreenshot("AirportLocationCreated");
			screenShot("AirportLocationCreated");
			Assert.assertTrue(atp.verifyMultipleAirport1Created());
			atp.clickairportlocation();
			atp.createMultipleNearbyAirportLocationAboutTheProperty2();
			atp.clickSave();
	
			allureScreenshot("AirportLocationCreated");
			screenShot("AirportLocationCreated");
			Assert.assertTrue(atp.verifyMultipleAirport2Created());
	
		}
	
		@Test(priority = 19)
		@Description("Verify that  User is able to   create  and delete Property Near By Airport location .")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User is able to   create  and delete Property Near By Airport location ")
		public void aboutPropertyAirportCreationScenario_TC_03() {
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_03");
	
			atp.clickairportlocation();
			atp.createAndDeleteNearbyAirportLocationAboutTheProperty();
			atp.clickSave();
			allureScreenshot("AirportLocationCreated");
			screenShot("AirportLocationCreated");
			Assert.assertTrue(atp.verifyCreatedAirport());
			atp.clickDeleteAirport();
	
			allureScreenshot("AirportLocationDeleted");
			screenShot("AirportLocationDeleted");
			Assert.assertFalse(atp.verifyCreatedAirport());
	
		}
	
		@Test(priority = 20)
		@Description("Verify that  User should not be able to create multiple Property Near By Airport with same code")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User should not be able to create multiple Property Near By Airport with same code")
		public void aboutPropertyAirportCreationScenario_TC_04() {
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_04");
	
			atp.clickairportlocation();
			atp.DuplicateNearbyAirportLocationAboutTheProperty();
			atp.clickSave();
			allureScreenshot("AirportLocationCreated");
			screenShot("AirportLocationCreated");
			atp.clickairportlocation();
			atp.DuplicateNearbyAirportLocationAboutTheProperty();
			atp.clickSave();
	
			allureScreenshot("AirportLocationCannotCreated");
			screenShot("AirportLocationCannotCreated");
			Assert.assertTrue(atp.verifyDuplicateAirportnotCreated());
	
		}
	
		@Test(priority = 21)
		@Description("Verify that  User should not be able to create and edit Property Near By Airport with same code")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User should  able to create and edit  Property Near By Airport ")
		public void aboutPropertyAirportCreationScenario_TC_05() {
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_05");
			atp.selectAboutTheProperty();
			atp.clickairportlocation();
			atp.createForEditNearbyAirportLocationAboutTheProperty();
			atp.clickSave();
	
			allureScreenshot("AirportLocationCreated");
			screenShot("AirportLocationCreated");
				
			
	
		Assert.assertTrue(atp.verifyCreatedAirportForEdit());
		Assert.assertTrue(atp.verifyEditedAirport());
	
		atp.EditCreatedNearbyAirportLocationAboutTheProperty();
		atp.clickSave();
	
		allureScreenshot("AirportLocationEdited");
		screenShot("AirportLocationEdited");
	    Assert.assertFalse(atp.verifyEditedAirport());
	
		}
	
		@Test(priority = 22)
		@Description("Verify that  User should not be able to  edit already created Property Near By Airport ")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User should  able to  edit already created Property Near By Airport ")
		public void aboutPropertyAirportCreationScenario_TC_06() {
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_06");
	
			Assert.assertFalse(atp.verifyExistedAirportEdited());
			atp.editAlreadyCreatedNearbyAirportLocationAboutTheProperty();
			atp.clickSave();
			allureScreenshot("AirportLocationEdited");
			screenShot("AirportLocationEdited");
			Assert.assertTrue(atp.verifyExistedAirportEdited());
	
		}
	
		@Test(priority = 23)
		@Description("Verify that  User should  be able to  delete already created Property Near By Airport with same code")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Airport information")
		@Story("About the property Naearby Airport information")
		@Step("Verify that  User should  able to delete already Property Near By Airport with same code")
		public void aboutPropertyAirportCreationScenario_TC_07() {
	
			extentTest = extent.startTest("aboutPropertyAirportCreationScenario_TC_07");
	
			atp.clickDeleteAirport();
			allureScreenshot("AirportLocationDeleted");
			screenShot("AirportLocationDeleted");
			Assert.assertTrue(atp.verifyAirportDeleted());
	
		}
	
		@Test(priority = 24)
		@Description("Verify that  User should  be able to create nearby Attraction information")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Attraction")
		@Story("About the property Naearby Attraction information")
		@Step("Verify that  User should able to create nearby Attraction information")
		public void aboutPropertyNearbyAttractionCreationScenario_TC_01() {
	
			extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_01");
			atp.clickNearbyAttractionlocation();
			atp.addaNearbyAttractionTheProperty();
			atp.clickSave();
			allureScreenshot("NearbyAttractionCreated");
			screenShot("NearbyAttractionCreated");
			atp.verifyNearbyAttractionCreated();
			Assert.assertTrue(atp.verifyNearbyAttractionCreated());
	
		}
	
		@Test(priority = 25)
		@Description("Verify that  User should  be able to create multiple nearby Attraction information")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Attraction")
		@Story("About the property Naearby Attraction information")
		@Step("Verify that  User should able to create multiple nearby Attraction information")
		public void aboutPropertyNearbyAttractionCreationScenario_TC_02() {
			extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_02");
	
			atp.clickNearbyAttractionlocation();
			atp.addMultipleNearbyAttractionTheProperty1();
			atp.clickSave();
			allureScreenshot("NearbyAttractionCreated");
			screenShot("NearbyAttractionCreated");
			Assert.assertTrue(atp.verifyMultipleNearbyAttraction1Created());
			atp.clickNearbyAttractionlocation();
			atp.addMultipleNearbyAttractionTheProperty2();
			atp.clickSave();
	
			allureScreenshot("NearbyAttractionCreated");
			
			screenShot("NearbyAttractionCreated");
			
				
				
			Assert.assertTrue(atp.verifyMultipleNearbyAttraction2Created());
	
		}
	
		@Test(priority = 26)
		@Description("Verify that  User should  be able to create and delete nearby Attraction information")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:About the property Naearby Attraction")
		@Story("About the property Naearby Attraction information")
		@Step("Verify that  User should able to create and delete nearby Attraction information")
		public void aboutPropertyNearbyAttractionCreationScenario_TC_03() {
			extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_03");
	
			atp.clickNearbyAttractionlocation();
			atp.addAndDeleteNearbyAttractionTheProperty();
			atp.clickSave();
			allureScreenshot("NearbyAttractionCreated");
			screenShot("NearbyAttractionCreated");
			Assert.assertTrue(atp.verifyCreatedNearbyAttraction());
	
			atp.clickDeleteNearbyAttraction();
	
			allureScreenshot("NearbyattractionDeleted");
			
			screenShot("NearbyattractionDeleted");
			Assert.assertFalse(atp.verifyCreatedNearbyAttraction());
	
	}
	
	@Test(priority = 27)
	@Description("Verify that  User should not  able to create duplicate nearby Attraction information")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:About the property Naearby Attraction")
	@Story("About the property Naearby Attraction information")
	@Step("Verify that  User should not  able to create duplicate nearby Attraction information")
	public void aboutPropertyNearbyAttractionCreationScenario_TC_04() {
	
			extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_04");
			atp.clickNearbyAttractionlocation();
			atp.addDuplicateNearbyAttractionTheProperty();
			atp.clickSave();
			allureScreenshot("NearbyAttractionCreated");
			screenShot("NearbyAttractionCreated");
	
			atp.clickNearbyAttractionlocation();
			atp.addDuplicateNearbyAttractionTheProperty();
			atp.clickSave();
			allureScreenshot("NearbyAttractionCannotCreated");
			screenShot("NearbyAttractionCanotCreated");
			Assert.assertTrue(atp.verifyDuplicateNearbyAttraction1Created());
	
	}
	
	@Test(priority = 28)
	@Description("Verify that  User should able to add and edit nearby Attraction information")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:About the property Naearby Attraction")
	@Story("About the property Naearby Attraction information")
	@Step("Verify that  User should able to add and edit nearby Attraction information")
	public void aboutPropertyNearbyAttractionCreationScenario_TC_05() {

		extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_05");
		atp.selectAboutTheProperty();
		atp.clickNearbyAttractionlocation();
		atp.addForEditNearbyAttractionTheProperty();
		atp.clickSave();

		allureScreenshot("NearbyAttractionCreated");

		screenShot("NearbyAttractionCreated");

		Assert.assertTrue(atp.verifyCreatedNearbyAttractionForEdit());
		Assert.assertTrue(atp.verifyEditedNearbyAttraction());

		atp.editTheAddedNearbyAttractionTheProperty();atp.clickSave();

		allureScreenshot("NearbyAttractionEdited");

		screenShot("NearbyAttractionEdited");

		Assert.assertFalse(atp.verifyEditedNearbyAttraction());

	}

	@Test(priority = 29)
	@Description("Verify that  User should able to edit already created nearby Attraction information")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:About the property Naearby Attraction")
	@Story("About the property Naearby Attraction information")
	@Step("Verify that  User should able to edit already created nearby Attraction information")
	public void aboutPropertyNearbyAttractionCreationScenario_TC_06() {
		extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_06");

		Assert.assertFalse(atp.verifyExistedNearbyAttractionEdited());
		atp.editAlreadyCreatedNearbyAttractionTheProperty();
		atp.clickSave();
		allureScreenshot("NearbyAttractionEdited");

		screenShot("NearbyAttractionEdited");

		Assert.assertTrue(atp.verifyExistedNearbyAttractionEdited());

	}

	@Test(priority = 30)
	@Description("Verify that  User should able to delete already created nearby Attraction information")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:About the property Naearby Attraction")
	@Story("About the property Naearby Attraction information")
	@Step("Verify that  User should able to delete already created nearby Attraction information")
	public void aboutPropertyNearbyAttractionCreationScenario_TC_07() {
		extentTest = extent.startTest("aboutPropertyNearbyAttractionCreationScenario_TC_07");
		atp.clickDeleteNearbyAttraction();
		allureScreenshot("NearbyAttractionDeleted");

		screenShot("NearbyAttractionDeleted");

		Assert.assertTrue(atp.verifyNearbyAttractionDeleted());
	}
	
	@Test(priority = 31)
	public void deleteAllCreatedAboutTheProperty() throws InterruptedException {
		atp.deleteAlreadyCreatedMeetingroomTheProperty();
		
		atp.deleteAlreadyCreatedDiningTheProperty();
		
		atp.deleteAlreadyCreatedAirportTheProperty();
		
		atp.deleteAlreadyCreatedNearbyAttractionTheProperty();
		
		allureScreenshot("AboutThePropertyDeleted");

		screenShot("AboutThePropertyDeleted");

		lp.logout();
	}
	
		@AfterSuite
		public void report() throws Exception {
	
			mail();
	
			cmdPrompt();
		}

}

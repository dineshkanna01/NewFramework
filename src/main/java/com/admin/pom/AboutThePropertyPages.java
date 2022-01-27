package com.admin.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
* POM class to About the property
* @Author Ankita Mohamanasingh
*/

public class AboutThePropertyPages extends AbstractBasePage {
	ExcelData e = new ExcelData();
	public WebDriver driver;

	@FindBy(xpath = "//a[text()='Channels']")
	WebElement channelsOption;

	@FindBy(xpath = "//a[text()='Add New Channel Group']")
	WebElement addNewChannel;

	@FindBy(xpath = "//select[@name='selectedChannelGroupName']")
	WebElement selectChannel;

	@FindBy(xpath = "//option[@value='GDS']")
	WebElement GDSChannel;

	@FindBy(xpath = "//input[@value='Sabre']")
	WebElement channelType;

	@FindBy(xpath = "//input[@id='0chainCode']")
	WebElement chainCode;

	@FindBy(xpath = "//input[@id='0']")
	WebElement hotelCode;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement saveChannelButton;

	@FindBy(xpath = "//*[contains(@href,'AboutProperty')]")
	WebElement aboutTheProperty;

	@FindBy(xpath = "//a[text()=' Add a Room  ']")
	WebElement addaRoom;

	@FindBy(xpath = "//input[@name='name']")
	WebElement roomName;

	@FindBy(xpath = "//input[@name='code']")
	WebElement code;

	@FindBy(xpath = "(//input[@name='name']/preceding::li)[last()]")
	WebElement duplicateCode;

	@FindBy(xpath = "//select[@name='selectedTypeValue']")
	WebElement type;

	@FindBy(xpath = "//option[@value='Conference']")
	WebElement conference;

	@FindBy(xpath = "//select[@name='categoryId']")
	WebElement services;

	@FindBy(xpath = "//option[@value='1']")
	WebElement presentation;

	@FindBy(xpath = "//option[@value='2']")
	WebElement roomSetup;

	@FindBy(xpath = "//select[@name='subCategoryId']")
	WebElement serviceSubcatagory;

	@FindBy(xpath = "//option[@value='40']")
	WebElement whiteboard;

	@FindBy(xpath = "//option[@value='45']")
	WebElement spotlight;

	@FindBy(xpath = "//input[@name='capacity']")
	WebElement capacity;

	@FindBy(xpath = "//select[@name='selectedUntisValue']")
	WebElement units;

	@FindBy(xpath = "//option[@value='ft']")
	WebElement ft;

	@FindBy(xpath = "//input[@name='area']")
	WebElement area;

	@FindBy(xpath = "//input[@name='save']")
	WebElement save;

	@FindBy(xpath = "//option[@value='Custom']")
	WebElement custom;

	@FindBy(xpath = "//option[@value='2']")
	WebElement roomSetUp;

	@FindBy(xpath = "//option[@value='46']")
	WebElement tableAvail;

	@FindBy(xpath = "(//input[@name='chkMeetingRoomIds'])[last()]")
	WebElement deleteMeetingRoom;

	@FindBy(xpath = "//input[@name='button2']")
	WebElement delete;

	@FindBy(xpath = "//a[text()=\" New Year special\"]")
	WebElement newYearSpecialEdit;

	@FindBy(xpath = "((//input[@name='chkMeetingRoomIds'])[last()]/following::td/a)[1]")
	WebElement createAndEdit;

	@FindBy(name = "area")
	WebElement editArea;

	@FindBy(xpath = "//input[@name='length']")
	WebElement length;

	@FindBy(xpath = "//input[@name='width']")
	WebElement width;

	@FindBy(xpath = "((//input[@name='chkMeetingRoomIds'])/following::td/a)[2]")
	WebElement multipleRoom1;

	@FindBy(xpath = "((//input[@name='chkMeetingRoomIds'])/following::td/a)[3]")
	WebElement multipleRoom2;

	@FindBy(xpath = "//a[text()=' Add Location  ']")
	WebElement diningAddLocation;

	@FindBy(xpath = "//input[@name='restaurantName']")
	WebElement restaurantName;

	@FindBy(xpath = "//input[@name='code']")
	WebElement restaurantCode;

	@FindBy(xpath = "//select[@name='selectedProximityValue']")
	WebElement restaurantProximity;

	@FindBy(xpath = "//option[@value='Nearby']")
	WebElement restaurantNearby;

	@FindBy(xpath = "//option[@value='Offsite']")
	WebElement restaurantOffsite;

	@FindBy(xpath = "//option[@value='Onsite']")
	WebElement restaurantOnsite;

	@FindBy(xpath = "//select[@name='selectedCuisineValue']")
	WebElement restaurantCusine;

	@FindBy(xpath = "//option[@value='Asian']")
	WebElement restaurantCusineAsian;

	@FindBy(xpath = "//option[@value='Barbeque']")
	WebElement restaurantCusineBarbeque;

	@FindBy(xpath = "//option[@value='French']")
	WebElement restaurantCusineFrench;

	@FindBy(xpath = "//input[@name='distanceAway']")
	WebElement restaurantDistanceAway;

	@FindBy(xpath = "//input[@name='save']")
	WebElement restaurantSave;

	@FindBy(xpath = "(//input[@value='Delete'])[2]")
	WebElement diningDeleteButton;

	@FindBy(xpath = "(//input[@name='chkDiningIds'])[last()]")
	WebElement deleteDiningName;

	@FindBy(xpath = "((//input[@name='chkDiningIds'])[last()]/following::td/a)[1]")
	WebElement editDining;

	@FindBy(xpath = "(//input[@name='restaurantName']/preceding::li)[last()]")
	WebElement duplicateDiningCode;

	@FindBy(xpath = "(//input[@name='distanceAway'])")
	WebElement editDiningDistanceAway;

	@FindBy(xpath = "((//input[@name='chkDiningIds'])/following::td/a)[2]")
	WebElement multipleDining1;

	@FindBy(xpath = "((//input[@name='chkDiningIds'])/following::td/a)[3]")
	WebElement multipleDining2;

	@FindBy(xpath = "(//a[text()=' Add Location  '])[2]")
	WebElement airportAddLocation;

	@FindBy(xpath = "(//input[@name='airportName'])")
	WebElement airportName;

	@FindBy(xpath = "(//input[@name='code'])")
	WebElement airportCode;

	@FindBy(xpath = "(//input[@name='distanceAway'])")
	WebElement airportDistanceAway;

	@FindBy(xpath = "(//select[@name='selectedTranspotationMethod'])")
	WebElement airportTransportationMethod;

	@FindBy(xpath = "(//option[@value='Bus'])")
	WebElement airportTransportationMethodBus;

	@FindBy(xpath = "(//option[@value='Taxi'])")
	WebElement airportTransportationMethodTaxi;

	@FindBy(xpath = "//input[@name='save']")
	WebElement airportSave;

	@FindBy(xpath = "((//input[@name='chkAirportIds'])[last()]/following::td/a)[1]")
	WebElement airportEdit;

	@FindBy(xpath = "((//input[@name='chkAirportIds'])/following::td/a)[2] ")
	WebElement multipleAirport1;

	@FindBy(xpath = "((//input[@name='chkAirportIds'])/following::td/a)[3]")
	WebElement multipleAirport2;

	@FindBy(xpath = "(//input[@name='airportName']/preceding::li)[last()]")
	WebElement airportDuplicateCode;

	@FindBy(xpath = "(//input[@name='chkAirportIds'])[last()]")
	WebElement airportDeleteCode;

	@FindBy(xpath = "(//input[@value='Delete'])[3]")
	WebElement airportDeleteButton;

	@FindBy(xpath = "(//a[text()=' Add Location  '])[3]")
	WebElement nearbyAttractionAddLocation;

	@FindBy(xpath = "(//input[@name='attractionName'])")
	WebElement nearbyAttractionName;

	@FindBy(xpath = "(//input[@name='code'])")
	WebElement nearbyAttractionCode;

	@FindBy(xpath = "(//select[@name='selectedTypeValue'])")
	WebElement nearbyAttractionType;

	@FindBy(xpath = "(//option[@value='Army base'])")
	WebElement nearbyAttractionTypeArmyBase;

	@FindBy(xpath = "(//option[@value='Auditorium'])")
	WebElement nearbyAttractionTypeAuditorium;

	@FindBy(xpath = "(//option[@value='Amusement park'])")
	WebElement nearbyAttractionTypeAmusmentpark;

	@FindBy(xpath = "(//input[@name='distanceAway'])")
	WebElement nearbyAttractionDistanceAway;

	@FindBy(xpath = "(//select[@name='selectedTranspotationMethod'])")
	WebElement nearbyAttractionTransportationMethod;

	@FindBy(xpath = "(//option[@value='Bus'])")
	WebElement nearbyAttractionTransportationMethodBus;

	@FindBy(xpath = "(//option[@value='Taxi'])")
	WebElement nearbyAttractionTransportationMethodTaxi;

	@FindBy(xpath = "(//option[@value='Subway'])")
	WebElement nearbyAttractionTransportationMethodSubway;

	@FindBy(xpath = "((//input[@name='chkAttractionIds'])[last()]/following::td/a)[1]")
	WebElement nearbyAttractionEdit;

	@FindBy(xpath = "((//input[@name='chkAttractionIds'])/following::td/a)[2] ")
	WebElement nearbyMultipleAttraction1;

	@FindBy(xpath = "((//input[@name='chkAttractionIds'])/following::td/a)[3] ")
	WebElement nearbyMultipleAttraction2;

	@FindBy(xpath = "(//input[@name='attractionName']/preceding::li)[last()]")
	WebElement attractionDuplicateCode;

	@FindBy(xpath = "(//input[@name='chkAttractionIds'])[last()]")
	WebElement nearbyAttractionDeleteCode;

	@FindBy(xpath = "(//input[@value='Delete'])[4]")
	WebElement nearbyAttractionDeleteButton;

	@FindBy(xpath = "((//input[@name='chkMeetingRoomIds'])[last()]/following::td[4])")
	WebElement areaInRoomTable;

	@FindBy(xpath = "((//input[@name='chkDiningIds'])[last()]/following::td)[5]")
	WebElement distanceInDiningTable;

	@FindBy(xpath = "((//input[@name='chkAirportIds'])[last()]/following::td[4])")
	WebElement airportDistanceTable;

	@FindBy(xpath = "((//input[@name='chkAttractionIds'])[last()]/following::td[4])")
	WebElement attractionDistanceTable;

	@FindBy(name="chkMeetingRoomIds")
	WebElement chk1;
	
	
	public AboutThePropertyPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	*Method to Enable About the property
	*
	*/

	public AboutThePropertyPages selectAboutTheProperty()  {
		TestBase.implict(3);
		aboutTheProperty.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to click on Add a room
	* 
	*/
	public AboutThePropertyPages clickAddaRoom()  {
		TestBase.implict(3);
		addaRoom.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to click on Save
	* 
	*/
	public AboutThePropertyPages clickSave()  {
		TestBase.implict(3);
		save.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to delete
	* 
	*/
	public AboutThePropertyPages clickDelete()  {

		deleteMeetingRoom.click();
		TestBase.implict(3);
		delete.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to click dining add location
	* 
	*/
	public AboutThePropertyPages clickdiningaddalocation()  {
		diningAddLocation.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to delete dining
	* 
	*/
	public AboutThePropertyPages clickDeleteDining()  {
		deleteDiningName.click();
		diningDeleteButton.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to click on Airport Location
	*
	*/

	public AboutThePropertyPages clickairportlocation()  {
		airportAddLocation.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to delete Airport Location
	* 
	*/

	public AboutThePropertyPages clickDeleteAirport()  {
		airportDeleteCode.click();
		airportDeleteButton.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to click on Nearby attractionlocation
	* 
	*/

	public AboutThePropertyPages clickNearbyAttractionlocation()  {
		nearbyAttractionAddLocation.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to delete Nearby attractionlocation
	* 
	*/
	public AboutThePropertyPages clickDeleteNearbyAttraction()  {
		nearbyAttractionDeleteCode.click();
		nearbyAttractionDeleteButton.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to enable About the property
	* 
	*/
	public AboutThePropertyPages enableAboutTheProperty()  {
		TestBase.implict(3);
		channelsOption.click();

		addNewChannel.click();
		TestBase.implict(3);
		selectChannel.click();
		TestBase.implict(3);
		GDSChannel.click();
		TestBase.implict(3);
		channelType.click();
		TestBase.implict(3);
		chainCode.sendKeys(e.getCellData("Channel", "ChainCode", 2));
		TestBase.implict(3);
		hotelCode.sendKeys(e.getCellData("Channel", "HotelCode", 2));
		TestBase.implict(3);

		saveChannelButton.click();
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to Create Meeting Room in About the property
	* 
	*/
	public AboutThePropertyPages addaRoomAboutTheProperty()  {

		roomName.sendKeys(e.getCellData("MeetingRoomMR", "RoomName", 2));
		code.sendKeys(e.getCellData("MeetingRoomMR", "Code", 2));
		type.click();
		conference.click();
		services.click();
		roomSetUp.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		tableAvail.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area", 2));

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to verify Created Meeting Room in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyRoomCreated()  {

		if (createAndEdit.isDisplayed()) {
			System.out.println("Room created");
			return true;
		} else {
			System.out.println("Room not Created");
			return false;

		}
	}

	/*
	* Method to Create multiple Meeting Room1 in About the property
	* 
	*/
	public AboutThePropertyPages addMultipleRoomAboutTheProperty1()  {

		roomName.sendKeys(e.getCellData("MeetingRoomMR", "RoomName2", 2));
		code.sendKeys(e.getCellData("MeetingRoomMR", "Code2", 2));
		type.click();
		custom.click();
		services.click();
		presentation.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		whiteboard.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area2", 2));

		return null;
	}
	
	/*
	* Method to Create multiple Meeting Room2 in About the property
	* 
	*/

	public AboutThePropertyPages addMultipleRoomAboutTheProperty2() {

		roomName.sendKeys(e.getCellData("MeetingRoomMR", "RoomName3", 2));
		code.sendKeys(e.getCellData("MeetingRoomMR", "Code3", 2));
		type.click();
		conference.click();
		services.click();
		presentation.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		whiteboard.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area3", 2));

		return null;
	}
	/*
	* Method to verify  multiple Meeting Room1 in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyMultipleRoom1Created()  {

		if (multipleRoom1.isDisplayed()) {
			System.out.println("Multiple Room1 created");
			return true;
		} else {
			System.out.println("Multiple Room1 not Created");
			return false;
		}
	}
	/*
	* Method to verify  multiple Meeting Room2 in About the property
	* return boolean value
	*/
	public boolean verifyMultipleRoom2Created()  {

		if (multipleRoom2.isDisplayed()) {
			System.out.println("Multiple Room2 created");
			return true;
		} else {
			System.out.println("Multiple Room2 not Created");
			return false;
		}

	}
	/*
	* Method to create duplicate room in About the property
	* 
	*/

	public AboutThePropertyPages createDuplicateRoom()  {

		roomName.sendKeys(e.getCellData("MeetingRoomMR", "RoomName4", 2));

		TestBase.implict(3);
		code.sendKeys(e.getCellData("MeetingRoomMR", "Code4", 2));
		type.click();
		custom.click();
		services.click();
		presentation.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		whiteboard.click();
//			Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area4", 2));

		return null;

	}
	/*
	* Method to verify duplicate room not created in About the property
	* 
	*/
	public boolean verifyDuplicateRoomnotCreated()  {
		if (duplicateCode.isDisplayed()) {
			System.out.println("Duplicate room not created");
			return true;
		} else {
			System.out.println("Duplicate room  created");
			return false;

		}
	}
	/*
	* Method to create and delete meeting room  in About the property
	* 
	*/

	public AboutThePropertyPages addandDeleteRoomAboutTheProperty()  {

		roomName.sendKeys(e.getCellData("MeetingRoomMR", "RoomName5", 2));
		code.sendKeys(e.getCellData("MeetingRoomMR", "Code5", 2));
		type.click();
		custom.click();
		services.click();
		presentation.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		whiteboard.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area5", 2));

		TestBase.implict(3);

		return null;
	}
	/*
	* Method to verify  meeting room created in About the property
	*  returns boolean value
	* 
	*/

	public boolean verifyCreatedRoom()  {
		String ActText = createAndEdit.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("MeetingRoomMR", "RoomName5", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" room created");
			return true;
		} else {
			System.out.println(" room not created");
			return false;

		}
	}
	
	/*
	* Method to verify  meeting room deleted in About the property 
	* returns boolean value
	* 
	*/

	public boolean verifyDeletedRoom()  {
		String ActText = createAndEdit.getText();
		System.out.println(ActText + " Actual Text");

		if (createAndEdit.isDisplayed()) {
			System.out.println(" room not deleted");
			return true;
		} else {
			System.out.println(" room deleted");
			return false;

		}
	}
	/*
	* Method to create  meeting room  for edition in About the property
	 
	*/


	public AboutThePropertyPages createForEditARoom()  {

		roomName.sendKeys(e.getCellData("MeetingRoomMR", "RoomName4", 2));
		code.sendKeys(e.getCellData("MeetingRoomMR", "Code4", 2));
		type.click();
		custom.click();
		services.click();
		presentation.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		whiteboard.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area4", 2));

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to edit  meeting room in About the property
	* 
	*/

	public AboutThePropertyPages editTheCreatedRoom()  {
		createAndEdit.click();
		editArea.clear();
		area.sendKeys(e.getCellData("MeetingRoomMR", "Area5", 2));

		return null;
	}
	/*
	* Method to  verify   meeting room creaed in About the property 
	* returns boolean value
	*
	*/
	public boolean verifyCreatedRoomForEdit()  {
		String ActText = createAndEdit.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("MeetingRoomMR", "RoomName4", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equals(expText)) {
			System.out.println(" Meeting room  created");
			return true;
		} else {
			System.out.println(" Meeting room deleted");
			return false;

		}
	}
	/*
	* Method to  verify   meeting room edited in About the property
	*  returns boolean value
	*
	*/
	public boolean verifyMeetingRoomEdited()  {
		String ActText = areaInRoomTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("MeetingRoomMR", "Area4", 2));
		System.out.println(expText + " " + "ExpectedText");

	    if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Meeting Room not editied");
			return true;
		} else {
			System.out.println(" Meeting Room edited");
			return false;

		}
	}
	/*
	* Method to  edit existed   meeting room  in About the property
	*
	*/
	public AboutThePropertyPages editARoom()  {
		createAndEdit.click();
		TestBase.implict(3);
		editArea.clear();

		area.sendKeys(e.getCellData("MeetingRoomMR", "Area", 2));

		return null;
	}
	/*
	* Method to verify  existed   meeting room edited in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyExistedMeetingRooomEdited()  {
		String ActText = areaInRoomTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
//		String expText=(e.getCellDataAnk("Dining2", "DistanceAway6", 2));
//		System.out.println(expText+" "+"ExpectedText");

		String expText = e.getCellData("MeetingRoomMR", "Area", 2);
		expText = expText.replaceAll("\\s+", "");

		
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Meeting Room editied");
			return true;
		} else {
			System.out.println(" MeetingRoom not edited");
			return false;

		}
	}
	/*
	* Method to  create meeting room for different service drop down in About the property
	* 
	*/

	public AboutThePropertyPages serviceSubdropdownPresentation()  {

		roomName.sendKeys(e.getCellData("MeetingRoom2", "RoomName8", 2));

		TestBase.implict(3);
		code.sendKeys(e.getCellData("MeetingRoom2", "Code8", 2));
		type.click();
		custom.click();
		// services.click();
		// presentation.click();
		// TestBase.implict(3);

		Select dropdown = new Select(services);
		dropdown.selectByIndex(1);
		String abc = dropdown.getFirstSelectedOption().getText();

		System.out.println(abc);

		Assert.assertEquals(verifyServiceSubdropdown(), "Flip chart and markers");
//		serviceSubcatagory.click();
//		whiteboard.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));

		System.out.println("For " +abc+ ": sub dropdown is " + verifyServiceSubdropdown());
		capacity.sendKeys("100");
		units.click();
		ft.click();
		area.sendKeys(e.getCellData("MeetingRoom2", "Area8", 2));

		return null;

	}
	/*
	* Methods to  edit service dropdown   meeting room  in About the property
	*
	*/
	public AboutThePropertyPages editServiceDropdown()   {
		createAndEdit.click();

		Select dropdown = new Select(services);
		dropdown.selectByIndex(2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String abc = dropdown.getFirstSelectedOption().getText();

		System.out.println(abc);

		Assert.assertEquals(verifyServiceSubdropdown(), "Dance floor");
		System.out.println("For " +abc+ ": sub dropdown is " + verifyServiceSubdropdown());

		return null;
	}
	
	/*
	* Method to  verify different service dropdown getting different subdropdown  meeting room  in About the property
	*  returns String
	* 
	*/

	public String verifyServiceSubdropdown()  {
		Select dropdown = new Select(serviceSubcatagory);
		String abc = dropdown.getFirstSelectedOption().getText();

		System.out.println(abc);

		return abc;

	}
	/*
	* Method to  get calculated area  meeting room  in About the property
	*
	*/
	public AboutThePropertyPages verifyTheArea()  {

		roomName.sendKeys(e.getCellData("MeetingRoom2", "RoomName10", 2));

		TestBase.implict(3);
		code.sendKeys(e.getCellData("MeetingRoom2", "Code10", 2));
		type.click();
		custom.click();
		services.click();
		presentation.click();
		TestBase.implict(3);
		serviceSubcatagory.click();
		whiteboard.click();
//		Capacity.sendKeys(e.getCellDataAnk("MeetingRoom","Capacity", 2));
		capacity.sendKeys("100");
		units.click();
		ft.click();
		length.sendKeys(e.getCellData("MeetingRoom2", "length10", 2));
		width.sendKeys(e.getCellData("MeetingRoom2", "width10", 2));
		area.click();
		TestBase.implict(3);

		return null;

	}
	/*
	* Method to verify calculated area is correct in meeting room  in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyCalculatedArea()  {
		
		String ActText = areaInRoomTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");

		String expText = e.getCellData("MeetingRoom2", "Area10", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Meeting Room Area calculating correctly");
			return true;
		} else {
			System.out.println(" MeetingRoom Area not calculating correctly");
			return false;

		}
	}
	/*
	* Method to add dining in About the property
	* 
	*/

	public AboutThePropertyPages addaDiningAboutTheProperty()  {

		restaurantName.sendKeys(e.getCellData("Dining", "RestaurantName1", 2));

		restaurantCode.sendKeys(e.getCellData("Dining", "Code1", 2));

		restaurantProximity.click();

		restaurantNearby.click();

		restaurantCusine.click();

		restaurantCusineAsian.click();

		restaurantDistanceAway.sendKeys(e.getCellData("Dining", "DistanceAway1", 2));

		return null;
	}
	/*
	*Method to verify added dining in About the property
	* returns boolean value
	* 
	*/

	public boolean verifyCreatedDining()  {

		if (editDining.isDisplayed()) {
			System.out.println("Dining created");
			return true;
		} else {
			System.out.println("Dining not Created");
			return false;

		}
	}
	/*
	* Method to add multiple dining1 in About the property
	* 
	*/


	public AboutThePropertyPages addaMultipleDiningAboutTheProperty1()  {

		restaurantName.sendKeys(e.getCellData("Dining", "RestaurantName2", 2));

		restaurantCode.sendKeys(e.getCellData("Dining", "Code2", 2));
		TestBase.implict(3);
		restaurantProximity.click();

		restaurantOnsite.click();

		restaurantCusine.click();

		restaurantCusineBarbeque.click();

		restaurantDistanceAway.sendKeys(e.getCellData("Dining", "DistanceAway2", 2));
		TestBase.implict(3);
		return null;
	}
	/*
	* Method to add multiple dining2 in About the property
	*
	*/
	public AboutThePropertyPages addaMultipleDiningAboutTheProperty2()  {

		restaurantName.sendKeys(e.getCellData("Dining", "RestaurantName3", 2));

		restaurantCode.sendKeys(e.getCellData("Dining", "Code3", 2));

		restaurantProximity.click();

		restaurantOffsite.click();

		restaurantCusine.click();

		restaurantCusineFrench.click();

		restaurantDistanceAway.sendKeys(e.getCellData("Dining", "DistanceAway3", 2));
		return null;

	}
	/*
	* Method to verify added multiple dining1 in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyMultipleDining1Created()  {

		if (multipleDining1.isDisplayed()) {
			System.out.println("Multiple Dining1 created");
			return true;
		} else {
			System.out.println("Multiple Dining2 not Created");
			return false;
		}
	}
	/*
	* Method to verify added multiple dining2 in About the property 
	* returns boolean value
	* 
	*/

	public boolean verifyMultipleDining2Created() {

		if (multipleDining2.isDisplayed()) {
			System.out.println("Multiple Dining1 created");
			return true;
		} else {
			System.out.println("Multiple Dining2 not Created");
			return false;
		}

	}
	/*
	* Method to  added  dining for duplcate code in About the property
	* 
	*/

	public AboutThePropertyPages invalidMultipleDiningAboutTheProperty()  {

		restaurantName.sendKeys(e.getCellData("Dining", "RestaurantName4", 2));

		restaurantCode.sendKeys(e.getCellData("Dining", "Code4", 2));

		restaurantProximity.click();

		restaurantOnsite.click();

		restaurantCusine.click();

		restaurantCusineBarbeque.click();

		restaurantDistanceAway.sendKeys(e.getCellData("Dining", "DistanceAway4", 2));
		TestBase.implict(3);
		return null;

	}
	/*
	* Method to  verify  dining for duplcate code in About the property 
	* returns boolean value
	*
	*/
	public boolean verifyDuplicateDiningnotCreated()  {
		if (duplicateDiningCode.isDisplayed()) {
			System.out.println("Duplicate dining not created");
			return true;
		} else {
			System.out.println("Duplicate dining  created");
			return false;

		}
	}
	/*
	* Method to create dining for deletion in About the property
	*
	*/
	public AboutThePropertyPages createandDeleteDiningAboutTheProperty()  {

		restaurantName.sendKeys(e.getCellData("Dining2", "RestaurantName6", 2));

		restaurantCode.sendKeys(e.getCellData("Dining2", "Code6", 2));

		restaurantProximity.click();

		restaurantOnsite.click();

		restaurantCusine.click();

		restaurantCusineBarbeque.click();

		restaurantDistanceAway.sendKeys(e.getCellData("Dining2", "DistanceAway6", 2));

		return null;

	}
	/*
	* Method to verify dining for deletion created in About the property 
	* returns boolean value
	*
	*/
	public boolean verifyDiningCreated()  {
		String ActText = editDining.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("Dining2", "RestaurantName6", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Dining created");
			return true;
		} else {
			System.out.println(" Dining deletd");
			return false;

		}
	}
	/*
	* Method to created dining edited in About the property
	* 
	*/

	public boolean verifyDiningEdited()  {
		String ActText = distanceInDiningTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");

		String expText = e.getCellData("Dining2", "VerifyDistance6", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Dining not editied");
			return true;
		} else {
			System.out.println(" Dining edited");
			return false;

		}
	}

	/*
	* Method to created dining deleted in About the property
	* 
	*/
	public boolean verifyDiningDeleted() {
		String ActText = editDining.getText();
		System.out.println(ActText + " Actual Text");

		if (editDining.isDisplayed()) {
			System.out.println(" dining not deleted");
			return true;
		} else {
			System.out.println(" dining deleted");
			return false;

		}
	}
	/*
	* Method to edit existed dining in About the property
	* 
	*/
	public AboutThePropertyPages editExistedDiningAboutTheProperty()  {
		editDining.click();
		editDiningDistanceAway.clear();
		editDiningDistanceAway.sendKeys(e.getCellData("Dining2", "DistanceAway6", 2));

		TestBase.implict(2);

		return null;
	}
	/*
	* Method to existed dining edited in About the property
	* 
	*/
	public boolean verifyExistedDiningEdited()  {
		String ActText = distanceInDiningTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
//		String expText=(e.getCellDataAnk("Dining2", "DistanceAway6", 2));
//		System.out.println(expText+" "+"ExpectedText");

		String expText = e.getCellData("Dining2", "VerifyDistance6", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Dining editied");
			return true;
		} else {
			System.out.println(" Dining not edited");
			return false;

		}
	}
	/*
	* Method to create dining for edition in About the property
	* 
	*/
	public AboutThePropertyPages createForEditDiningAboutTheProperty()  {

		restaurantName.sendKeys(e.getCellData("Dining2", "RestaurantName6", 2));

		restaurantCode.sendKeys(e.getCellData("Dining2", "Code6", 2));

		restaurantProximity.click();

		restaurantOnsite.click();

		restaurantCusine.click();

		restaurantCusineBarbeque.click();

		restaurantDistanceAway.sendKeys(e.getCellData("Dining2", "DistanceAway6", 2));

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to edit created dining  in About the property
	* 
	*/
	public AboutThePropertyPages editCreatedDiningAboutTheProperty()  {

		editDining.click();
		editDiningDistanceAway.clear();
		editDiningDistanceAway.sendKeys(e.getCellData("Dining", "DistanceAway4", 2));

		return null;

	}
	/*
	* Method to verify created dining edited in About the property 
	* returns boolean value
	* 
	*/
	public boolean verifyCreatedDiningForEdit()  {
		String ActText = editDining.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("Dining2", "RestaurantName6", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equals(expText)) {
			System.out.println(" Cusine Dining created");
			return true;
		} else {
			System.out.println(" Cusine dining deleted");
			return false;

		}
	}
	/*
	* Method to create Airport location in About the property
	*
	*/
	public AboutThePropertyPages createNearbyAirportLocationAboutTheProperty()  {

		airportName.sendKeys(e.getCellData("Airport1", "AirportName1", 2));

		airportCode.sendKeys(e.getCellData("Airport1", "Code1", 2));

		airportDistanceAway.sendKeys(e.getCellData("Airport1", "DistanceAway1", 2));

		airportTransportationMethod.click();

		airportTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to  verify created Airport location in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyCreatedAirportlocation()  {

		if (airportEdit.isDisplayed()) {
			System.out.println("Airport created");
			return true;
		} else {
			System.out.println("Airport not Created");
			return false;

		}
	}
	/*
	* Method to  create multiple Airport location1 in About the property 
	* 
	*/

	public AboutThePropertyPages createMultipleNearbyAirportLocationAboutTheProperty1()  {

		airportName.sendKeys(e.getCellData("Airport1", "AirportName2", 2));

		airportCode.sendKeys(e.getCellData("Airport1", "Code2", 2));

		airportDistanceAway.sendKeys(e.getCellData("Airport1", "DistanceAway2", 2));

		airportTransportationMethod.click();

		airportTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to  create multiple Airport location2 in About the property
	* 
	*/
	public AboutThePropertyPages createMultipleNearbyAirportLocationAboutTheProperty2()  {
		airportName.sendKeys(e.getCellData("Airport1", "AirportName3", 2));

		airportCode.sendKeys(e.getCellData("Airport1", "Code3", 2));

		airportDistanceAway.sendKeys(e.getCellData("Airport1", "DistanceAway3", 2));

		airportTransportationMethod.click();

		airportTransportationMethodTaxi.click();

		TestBase.implict(3);
		return null;

	}
	/*
	* Method to  verify  multiple Airport location1 created in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyMultipleAirport1Created()  {

		if (multipleAirport1.isDisplayed()) {
			System.out.println("Multiple Airport1 created");
			return true;
		} else {
			System.out.println("Multiple Airport1 not Created");
			return false;
		}
	}
	/*
	* Method to  verify  multiple Airport location2 created in About the property 
	* returns boolean value
	* 
	*/
	public boolean verifyMultipleAirport2Created() {

		if (multipleAirport2.isDisplayed()) {
			System.out.println("Multiple Airport2 created");
			return true;
		} else {
			System.out.println("Multiple Airport2 not Created");
			return false;
		}

	}
	/*
	* Method to create  Airport location for deletion in About the property
	* 
	*/
	public AboutThePropertyPages createAndDeleteNearbyAirportLocationAboutTheProperty()  {

		airportName.sendKeys(e.getCellData("Airport1", "AirportName4", 2));

		airportCode.sendKeys(e.getCellData("Airport1", "Code4", 2));

		airportDistanceAway.sendKeys(e.getCellData("Airport1", "DistanceAway4", 2));

		airportTransportationMethod.click();

		airportTransportationMethodBus.click();

		TestBase.implict(3);

		return null;

	}
	/*
	* Method to verify  Airport location for deletion created in About the property 
	* returns boolean value
	* 
	*/
	public boolean verifyCreatedAirport()  {
		String ActText = airportEdit.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("Airport1", "AirportName4", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Airport created created");
			return true;
		} else {
			System.out.println(" Airport  not created");
			return false;

		}
	}
	/*
	* Method to verify created  Airport location for deleted in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyDeletedAirport()  {
		String ActText = airportEdit.getText();
		System.out.println(ActText + " Actual Text");

		if (airportEdit.isDisplayed()) {
			System.out.println(" Airport not deleted");
			return true;
		} else {
			System.out.println(" Airport deleted");
			return false;

		}
	}
	/*
	* Method to create duplicate Airport location  in About the property
	* 
	*/
	public AboutThePropertyPages DuplicateNearbyAirportLocationAboutTheProperty() {

		airportName.sendKeys(e.getCellData("Airport2", "AirportName5", 2));

		airportCode.sendKeys(e.getCellData("Airport2", "Code5", 2));

		airportDistanceAway.sendKeys(e.getCellData("Airport2", "DistanceAway5", 2));

		airportTransportationMethod.click();

		airportTransportationMethodBus.click();

		TestBase.implict(3);

		return null;

	}
	/*
	* Method to verify duplicate Airport location is not created  in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyDuplicateAirportnotCreated()  {
		if (airportDuplicateCode.isDisplayed()) {
			System.out.println("Duplicate airport not created");
			return true;
		} else {
			System.out.println("Duplicate airport  created");
			return false;

		}
	}
	/*
	* Method to verify created Airport location deleted  in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyAirportDeleted()  {
		String ActText = airportEdit.getText();
		System.out.println(ActText + " Actual Text");

		if (airportEdit.isDisplayed()) {
			System.out.println(" Airport not deleted");
			return true;
		} else {
			System.out.println(" Airport deleted");
			return false;

		}
	}
	/*
	* Method to create Airport location for edition in About the property
	* 
	*/
	public AboutThePropertyPages createForEditNearbyAirportLocationAboutTheProperty()  {

		airportName.sendKeys(e.getCellData("Airport2", "AirportName7", 2));

		airportCode.sendKeys(e.getCellData("Airport2", "Code7", 2));

		airportDistanceAway.sendKeys(e.getCellData("Airport2", "DistanceAway7", 2));

		airportTransportationMethod.click();

		airportTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to edit created Airport location in About the property
	*
	*/
	public AboutThePropertyPages EditCreatedNearbyAirportLocationAboutTheProperty()  {

		airportEdit.click();

		airportDistanceAway.clear();

		airportDistanceAway.sendKeys(e.getCellData("Airport2", "DistanceAway5", 2));

		TestBase.implict(3);
		return null;

	}
	/*
	* Method to verify created Airport location for edition is created in About the property 
	* returns boolean value
	*
	*/
	public boolean verifyCreatedAirportForEdit()  {
		String ActText = airportEdit.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("Airport2", "AirportName7", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equals(expText)) {
			System.out.println(" Airport created");
			return true;
		} else {
			System.out.println(" Airport deleted");
			return false;

		}
	}
	/*
	* Method to created Airport location for edition is edited in About the property
	* 
	*/

	public boolean verifyEditedAirport()  {
		String ActText = airportDistanceTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
		String expText = e.getCellData("Airport2", "EditedDistanceAway7", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Airport distance not edited");
			return true;
		} else {
			System.out.println("Airport distance  edited ");
			return false;

		}
	}
	/*
	*Method to edit existed Airport location in About the property
	* 
	*/

	public AboutThePropertyPages editAlreadyCreatedNearbyAirportLocationAboutTheProperty()  {

		airportEdit.click();

		airportDistanceAway.clear();

		airportDistanceAway.sendKeys(e.getCellData("Airport2", "DistanceAway7", 2));
		TestBase.implict(3);

		return null;
	}
	/*
	* Method to verify existed Airport location  editeded  in About the property
	*  returns boolean value
	*
	*/
	public boolean verifyExistedAirportEdited() {
		String ActText = airportDistanceTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
		String expText = e.getCellData("Airport2", "EditedDistanceAway7", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Airport  distance  editied");
			return true;
		} else {
			System.out.println(" Airport distance not edited");
			return false;

		}
	}
	/*
	* Method to create Nearby Attraction  in About the property
	*
	*/
	public AboutThePropertyPages addaNearbyAttractionTheProperty()  {

		nearbyAttractionName.sendKeys(e.getCellData("Attraction", "AttractionName", 2));
		nearbyAttractionCode.sendKeys(e.getCellData("Attraction", "Code", 2));
		nearbyAttractionType.click();
		nearbyAttractionTypeArmyBase.click();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction", "DistanceAway", 2));
		nearbyAttractionTransportationMethod.click();
		nearbyAttractionTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	*Method to verify  Nearby Attraction created in About the property
	* returns boolean value
	* 
	*/
	public boolean verifyNearbyAttractionCreated() {

		if (nearbyAttractionEdit.isDisplayed()) {
			System.out.println("Nearby Attraction Created Successfully");
			return true;
		} else {
			System.out.println("Nearby Attraction creation unsuccessful");
			return false;

		}
	}
	/*
	* Method to create multiple Nearby Attraction1 in About the property
	*
	*/

	public AboutThePropertyPages addMultipleNearbyAttractionTheProperty1()  {

		nearbyAttractionName.sendKeys(e.getCellData("Attraction", "AttractionName2", 2));
		TestBase.implict(3);
		nearbyAttractionCode.sendKeys(e.getCellData("Attraction", "Code2", 2));
		nearbyAttractionType.click();
		nearbyAttractionTypeArmyBase.click();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction", "DistanceAway2", 2));
		nearbyAttractionTransportationMethod.click();
		nearbyAttractionTransportationMethodBus.click();
		return null;
	}
	/*
	* Method to create multiple Nearby Attraction2 in About the property
	*\
	*/
	public AboutThePropertyPages addMultipleNearbyAttractionTheProperty2()  {

		nearbyAttractionName.sendKeys(e.getCellData("Attraction", "AttractionName3", 2));
		nearbyAttractionCode.sendKeys(e.getCellData("Attraction", "Code3", 2));
		nearbyAttractionType.click();
		nearbyAttractionTypeArmyBase.click();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction", "DistanceAway3", 2));
		nearbyAttractionTransportationMethod.click();
		nearbyAttractionTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to verify multiple Nearby Attraction1 created in About the property 
	* returns boolean value
	* 
	*/
	public boolean verifyMultipleNearbyAttraction1Created()  {

		if (nearbyMultipleAttraction1.isDisplayed()) {
			System.out.println("Nearby Attraction1 Created Successfully");
			return true;
		} else {
			System.out.println("Nearby Attraction1 creation unsuccessful");
			return false;

		}
	}
	/*
	* Method to verify multiple Nearby Attraction2 created in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyMultipleNearbyAttraction2Created()  {

		if (nearbyMultipleAttraction2.isDisplayed()) {
			System.out.println("Nearby Attraction2 Created Successfully");
			return true;
		} else {
			System.out.println("Nearby Attraction2 creation unsuccessful");
			return false;

		}
	}
	/*
	* Method to create Nearby Attraction for delete in About the property
	* 
	*/
	public AboutThePropertyPages addAndDeleteNearbyAttractionTheProperty()  {

		nearbyAttractionName.sendKeys(e.getCellData("Attraction2", "AttractionName5", 2));
		nearbyAttractionCode.sendKeys(e.getCellData("Attraction2", "Code5", 2));
		nearbyAttractionType.click();
		nearbyAttractionTypeArmyBase.click();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction2", "DistanceAway5", 2));
		nearbyAttractionTransportationMethod.click();
		nearbyAttractionTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to verify Nearby Attraction created in About the property
	*  returns boolean value
	*
	*/
	public boolean verifyCreatedNearbyAttraction()  {
		String ActText = nearbyAttractionEdit.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("Attraction2", "AttractionName5", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Nearby attraction created");
			return true;
		} else {
			System.out.println(" near by attraction not created");
			return false;

		}
	}
	/*
	* Method to verify  Nearby Attraction deleted in About the property 
	* returns boolean value
	* 
	*/
	public boolean verifyDeletedNearbyAttraction()  {
		String ActText = nearbyAttractionEdit.getText();
		System.out.println(ActText + " Actual Text");

		if (nearbyAttractionEdit.isDisplayed()) {
			System.out.println(" room not deleted");
			return true;
		} else {
			System.out.println(" room deleted");
			return false;

		}
	}
	/*
	* Method to create duplicate Nearby Attraction for delete in About the property
	* 
	*/
	public AboutThePropertyPages addDuplicateNearbyAttractionTheProperty()  {

		nearbyAttractionName.sendKeys(e.getCellData("Attraction2", "AttractionName4", 2));
		nearbyAttractionCode.sendKeys(e.getCellData("Attraction2", "Code4", 2));
		nearbyAttractionType.click();
		nearbyAttractionTypeArmyBase.click();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction2", "DistanceAway4", 2));
		nearbyAttractionTransportationMethod.click();
		nearbyAttractionTransportationMethodBus.click();

		TestBase.implict(3);
		return null;
	}
	/*
	* Method to verify duplicate Nearby Attraction not created  in About the property 
	* returns boolean value
	* 
	*/
	public boolean verifyDuplicateNearbyAttraction1Created()  {

		if (attractionDuplicateCode.isDisplayed()) {
			System.out.println("Duplicate Attraction not Created ");
			return true;
		} else {
			System.out.println("Duplicate Attraction  Created ");
			return false;

		}

	}
	/*
	* Method to create Nearby Attraction for edit in About the property
	* 
	*/
	public AboutThePropertyPages addForEditNearbyAttractionTheProperty()  {

		nearbyAttractionName.sendKeys(e.getCellData("Attraction2", "AttractionName6", 2));
		nearbyAttractionCode.sendKeys(e.getCellData("Attraction2", "Code6", 2));
		nearbyAttractionType.click();
		nearbyAttractionTypeArmyBase.click();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction2", "DistanceAway6", 2));
		nearbyAttractionTransportationMethod.click();
		nearbyAttractionTransportationMethodBus.click();
		return null;
	}
	/*
	*Method to verify Nearby Attraction for edit created in About the property 
	*returns boolean value
	* 
	*/
	public boolean verifyCreatedNearbyAttractionForEdit()  {
		String ActText = nearbyAttractionEdit.getText();
		System.out.println(ActText + " Actual Text");
		String expText = (e.getCellData("Attraction2", "AttractionName6", 2));
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equals(expText)) {
			System.out.println(" Nearby Attraction created");
			return true;
		} else {
			System.out.println(" Nearby Attraction deleted");
			return false;

		}
	}
	/*
	* Method to verify Nearby Attraction edited in About the property
	*  returns boolean value
	* 
	*/
	public boolean verifyEditedNearbyAttraction()  {
		String ActText = attractionDistanceTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
		String expText = e.getCellData("Attraction2", "EditedDistanceAway6", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" NearbyAttraction distance not edited");
			return true;
		} else {
			System.out.println("NearbyAttraction distance  edited ");
			return false;

		}
	}
	/*
	* Method to edit created Nearby Attraction in About the property
	* 
	*/
	public AboutThePropertyPages editTheAddedNearbyAttractionTheProperty()  {
		nearbyAttractionEdit.click();
		nearbyAttractionDistanceAway.clear();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction2", "DistanceAway7", 2));

		return null;
	}
	/*
	* Method to edit existed Nearby Attraction in About the property
	* 
	*/

	public AboutThePropertyPages editAlreadyCreatedNearbyAttractionTheProperty()  {
		nearbyAttractionEdit.click();
		nearbyAttractionDistanceAway.clear();
		nearbyAttractionDistanceAway.sendKeys(e.getCellData("Attraction2", "DistanceAway6", 2));

		return null;
	}
	/*
	* Method to verify existed Nearby Attraction edited in About the property
	*  returns boolean value
	* 
	*/

	public boolean verifyExistedNearbyAttractionEdited()  {
		String ActText = attractionDistanceTable.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText + " Actual Text");
		String expText = e.getCellData("Attraction2", "EditedDistanceAway6", 2);
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" NearbyAttraction  distance  editied");
			return true;
		} else {
			System.out.println(" NearbyAttraction distance not edited");
			return false;

		}
	}
	/*
	* Method to verify  Nearby Attraction deleted  in About the property 
	* returns boolean value
	* 
	*/


	public boolean verifyNearbyAttractionDeleted()  {
		String ActText = nearbyAttractionEdit.getText();
		System.out.println(ActText + " Actual Text");

		if (airportEdit.isDisplayed()) {
			System.out.println(" Nearby attraction not deleted");
			return true;
		} else {
			System.out.println(" Nearby attraction deleted");
			return false;

		}
	}
}

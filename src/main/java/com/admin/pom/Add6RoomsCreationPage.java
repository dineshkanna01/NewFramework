package com.admin.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * Pom class for Add 6 Room Creation 
 * @author Sudhakar Mourya
 */
public class Add6RoomsCreationPage extends AbstractBasePage{
	 ExcelData e = new ExcelData();
		
	 public Add6RoomsCreationPage(WebDriver driver) {
	 super(driver);
	 
	 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//input[@name='name']")
	 WebElement roomName;
	
	 @FindBy(xpath="//input[@name='code']")
	 WebElement roomCode; 
	 
	 @FindBy(xpath="(//input[@name='selectedBedIds'])[1]")
	 WebElement bigsizeBed; 
	 
	 @FindBy(xpath="(//input[@name='selectedBedIds'])[2]")
	 WebElement doubleBed; 
	 
	 @FindBy(xpath="(//input[@name='selectedBedIds'])[3]")
	 WebElement marvelousBed; 
	 
     @FindBy(xpath="(//input[@name='selectedBedIds'])[2]")
     WebElement exquisiteBed; 
     
     @FindBy(xpath="//input[@name='extraAdultPerRoomCharge']")
     WebElement extraAdultPerRoomCharge; 
     
     @FindBy(xpath="//input[@name='extraChildPerRoomCharge']")
     WebElement extraChildPerRoomCharge; 
     
     @FindBy(xpath="//select[@name='maxOccupantsForDefaultPrice']")
     WebElement maxNoOfAdultForDefaultPrice; 
     
     @FindBy(xpath="//input[@name='minAdultOccupancy']")
     WebElement minAdult; 
   
     @FindBy(xpath="//input[@name='maxAdultOccupancy']")
     WebElement maxAdult; 
     
     @FindBy(xpath="//input[@name='minChilOccupancy']")
     WebElement minChild; 
     
     @FindBy(xpath="//input[@name='maxChilOccupancy']")
     WebElement maxChild; 
     
     @FindBy(xpath="//input[@name='totalMaxOccupancy']")
     WebElement totalOccupancy; 
     
     @FindBy(xpath="//input[@name='save']")
     WebElement saveButton; 
     
     @FindBy(xpath="//input[@name='save'][2]")
     WebElement editSave;
     
     @FindBy(xpath="(//input[@type='checkbox'])[last()]")
     WebElement lastCheckbox; 
     
     @FindBy(xpath="//input[@name='delete']")
     WebElement delete; 
     
     @FindBy(xpath="//input[@value='Yes']")
     WebElement yesButton; 
     
  
     @FindBy(xpath="//input[@type='file']")
     WebElement pegsImage ;  
     
     @FindBy(xpath=" (//a[contains(@href,'displayEditRoom')])[last()]")
     WebElement edit;  
     
     @FindBy(xpath="//li[text()='Duplicate Code']")
     WebElement roomDuplicateCode ; 
     
     @FindBys(@FindBy(xpath=" //table[@id='dataTable']//tr/td[3]"))
 	 List<WebElement> allRoomName;
     
     @FindBy(xpath="//table[@id='dataTable']//tr[8]/td[4]")
     WebElement editedRoomCode ; 
  
     
   /*
    * Method for enter room name
    */
     public Add6RoomsCreationPage enterRoomName(String name)  {
	 roomName.sendKeys(name);
     return null;
     }
     
     /*
      * Method for enter room code
      */
     public Add6RoomsCreationPage enterRoomCode(String code){
     roomCode.sendKeys(code);
     return null;
     }
     
     /*
      * Method for enter bed types
      */
     public Add6RoomsCreationPage clickOnBigsizeBed() {
	 bigsizeBed.click();
     return null;
     }

     /*
      * Method for click on bed
      */
     public Add6RoomsCreationPage clickOnDoubleBed() {
     doubleBed.click();
     return null;
     }

     /*
      * Method for click on bed
      */
     public Add6RoomsCreationPage clickOnMarvelousBed() {
     marvelousBed.click();
     return null;
     }

     /*
      * Method for click on bed
      */
     public Add6RoomsCreationPage clickOnExquisiteBed() {
     exquisiteBed.click();
     return null;
     }
     /*
      * Method for enter extra adult per room charge
      */
     public Add6RoomsCreationPage enterExtraAdultPerRoomCharge(String charge) {
     extraAdultPerRoomCharge.sendKeys(charge);
     return null;
     }

     /*
      * Method for enter extra child per room charge
      */
     public Add6RoomsCreationPage enterExtraChildPerRoomCharge(String charge) {
     extraChildPerRoomCharge.sendKeys(charge);
     return null;
     }
     
     /*
      * Method for select max no of adult for default price
      */
     public Add6RoomsCreationPage selectMaxNoOfAdultForDefaultprice(String person) {
     Select s=new Select(maxNoOfAdultForDefaultPrice);
     s.selectByVisibleText(person);
     return null;
     }
     
     /*
      * Method for enter min adult limit
      */
     public Add6RoomsCreationPage enterMinAdultLimit(String adult) {
     minAdult.sendKeys(adult);
     return null;
     }
     
     /*
      * Method for enter max adult limit
      */
     public Add6RoomsCreationPage enterMaxAdultLimit(String adult) {
     maxAdult.sendKeys(adult);
     return null;
     }

     /*
      * Method for enter min child limit
      */
     public Add6RoomsCreationPage enterMinChildLimit(String Child) {
     minChild.sendKeys(Child);
     return null;
     }

     /*
      * Method for enter max child limit 
      */
     public Add6RoomsCreationPage enterMaxChildLimit(String Child) {
     maxChild.sendKeys(Child);
     return null;
     }
     
     /*
      * Method for enter total max occupancy
      */
     public Add6RoomsCreationPage enterTotalMaxOccupancy(String total) {
     totalOccupancy.sendKeys(total);
     return null;
     }
     
     /*
      * Method for click on save button
      */
     public Add6RoomsCreationPage clickOnSave() {
	 saveButton.click();
	 TestBase.implict(5);
     return null;
     }
     
     /*
      * Method for click on delete button
      */
     public Add6RoomsCreationPage clickOnDelete() {
     delete.click();
     return null;
     }
     
     /*
      * Method for click on yes button
      */
     public Add6RoomsCreationPage clickOnYes() {
     yesButton.click();
     return null;
         }
     
     /*
      * Method for click on last checkbox
      */
     public Add6RoomsCreationPage clickOnLastCheckbox() {
     lastCheckbox.click();
     return null;
         }
     
     /*
      * Method for click on edit
      */
     public Add6RoomsCreationPage clickOnEdit() {
     edit.click();
      return null;
      }
     
     /*
      * Method for upload image
      */
     public Add6RoomsCreationPage uploadImage() throws Exception {
	 pegsImage.sendKeys("C:\\Users\\Dinesh.Kanna\\Desktop\\DB.jpg");
     return null;
     }
     
     /*
      * Method for add 6 room 
      */
      public Add6RoomsCreationPage add6Rooms() throws Exception {
      AdministratorHomePage ahp=new AdministratorHomePage(driver);
      TestBase.implict(5);
	  enterRoomName(e.getCellData("Sheet1","roomName",2));
	  TestBase.implict(5);
      enterRoomCode(e.getCellData("Sheet1","roomCode",2));
      clickOnBigsizeBed();
      uploadImage();
      TestBase.implict(4);
      enterExtraAdultPerRoomCharge("100");
      enterExtraChildPerRoomCharge("30");
      selectMaxNoOfAdultForDefaultprice("2");
      enterMinAdultLimit("1");
      enterMaxAdultLimit("3");
      enterMinChildLimit("0");
      enterMaxChildLimit("3");
      enterTotalMaxOccupancy("6");
      clickOnSave();
      
     
      ahp.clickOnAddNew();
      enterRoomName(e.getCellData("Sheet1","roomName",5));
      enterRoomCode(e.getCellData("Sheet1","roomCode",5));
      clickOnMarvelousBed();
      uploadImage();
      TestBase.implict(4);
      enterExtraAdultPerRoomCharge("100");
      enterExtraChildPerRoomCharge("30");
      selectMaxNoOfAdultForDefaultprice("2");
      enterMinAdultLimit("1");
      enterMaxAdultLimit("3");
      enterMinChildLimit("0");
      enterMaxChildLimit("3");
      enterTotalMaxOccupancy("6");
      clickOnSave();
      
      
      ahp.clickOnAddNew();
      enterRoomName(e.getCellData("Sheet1","roomName",3));
      enterRoomCode(e.getCellData("Sheet1","roomCode",3));
      clickOnBigsizeBed();
      uploadImage();
      enterExtraAdultPerRoomCharge("50");
      enterExtraChildPerRoomCharge("20");
      selectMaxNoOfAdultForDefaultprice("1");
      enterMinAdultLimit("1");
      enterMaxAdultLimit("2");
      enterMinChildLimit("0");
      enterMaxChildLimit("2");
      enterTotalMaxOccupancy("4");
      clickOnSave();
    
      ahp.clickOnAddNew();
      enterRoomName(e.getCellData("Sheet1","roomName",4));
      enterRoomCode(e.getCellData("Sheet1","roomCode",4));
      clickOnDoubleBed();
      uploadImage();
      enterExtraAdultPerRoomCharge("100");
      enterExtraChildPerRoomCharge("30");
      selectMaxNoOfAdultForDefaultprice("1");
      enterMinAdultLimit("1");
      enterMaxAdultLimit("1");
      enterMinChildLimit("0");
      enterMaxChildLimit("2");
      enterTotalMaxOccupancy("3");
      clickOnSave();
      
      
      ahp.clickOnAddNew();
      enterRoomName(e.getCellData("Sheet1","roomName",6));
      enterRoomCode(e.getCellData("Sheet1","roomCode",6));
      clickOnExquisiteBed();
      uploadImage();
      enterExtraAdultPerRoomCharge("100");
      enterExtraChildPerRoomCharge("50");
      selectMaxNoOfAdultForDefaultprice("1");
      enterMinAdultLimit("1");
      enterMaxAdultLimit("1");
      enterMinChildLimit("0");
      enterMaxChildLimit("2");
      enterTotalMaxOccupancy("3");
      clickOnSave();
      
    
      ahp.clickOnAddNew();
      enterRoomName(e.getCellData("Sheet1","roomName",7));
      enterRoomCode(e.getCellData("Sheet1","roomCode",7));
      TestBase.implict(3);
      clickOnExquisiteBed();
      uploadImage();
      TestBase.implict(3);
      enterExtraAdultPerRoomCharge("100");
      enterExtraChildPerRoomCharge("50");
      selectMaxNoOfAdultForDefaultprice("3");
      enterMinAdultLimit("1");
      enterMaxAdultLimit("2");
      enterMinChildLimit("0");
      enterMaxChildLimit("2");
      enterTotalMaxOccupancy("4");
      clickOnSave();
      TestBase.implict(3);
      return null;
    }
     
      /*
       * Method for edit 6 room
       */
     public Add6RoomsCreationPage editRoom() throws Exception {
     roomCode.clear();
    
     enterRoomCode(e.getCellData("Sheet1","roomCode",10));
	 extraAdultPerRoomCharge.clear();
	
	 enterExtraAdultPerRoomCharge("80");
	 extraChildPerRoomCharge.clear();
	
	 enterExtraChildPerRoomCharge("40");
	
	 selectMaxNoOfAdultForDefaultprice("1");
	 editSave.click();
	 TestBase.implict(3);

	 return null;
    }
    
     /*
      * Method for verify TC01
      */
     public boolean verifyadd6RoomCreation_TC01( String name) throws Exception {
    	 for (WebElement SingleName : allRoomName) {
				String a = SingleName.getText();
				if(a.equals(name)) {
					return true;	
				}
			}
			return false;
		}
     
     /*
      * Method for verify TC02
      */
     public boolean verifyadd6RoomCreation_TC02() throws Exception {
			 String actText=editedRoomCode.getText();
 			 String expText=e.getCellData("Sheet1","roomCode",10);
            if(actText.equals(expText)) {
      		 System.out.println("Room edited successfully");
      	     return true;
      	      }
      	 else {
      		 System.out.println("Testcase is failed");
      	 }
      		return false;
      	 }
     
     /*
      * Method for verify TC03
      */
     public boolean verifyadd6RoomCreation_TC03( String name) throws Exception {
    	 for (WebElement SingleName : allRoomName) {
				String a = SingleName.getText();
				if(a.equals(name)) {
					return false;	
				}
			}
			return true;
		}
     
     /*
      * Method for verify TC04
      */
     public boolean verifyadd6RoomCreation_TC04() throws Exception {
    	     TestBase.implict(5);
			 String actText=roomDuplicateCode.getText();
			 TestBase.implict(5);
 			 String expText=e.getCellData("Sheet1","roomErrorMsg",2);
             if(actText.equals(expText)) {
      		 System.out.println("Room not created with exist code, TC passed");
      	     return true;
      	      }
      	 else {
      		 System.out.println("Testcase is failed");
      	 }
      		return false;
      	 }
}
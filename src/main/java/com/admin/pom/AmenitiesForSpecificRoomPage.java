package com.admin.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * Pom class for Amenities For Specific Room
 * @author Sudhakar Mourya
 */
public class AmenitiesForSpecificRoomPage extends AbstractBasePage {
	ExcelData e = new ExcelData();
	
	public AmenitiesForSpecificRoomPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement amenitiesName;
	
    @FindBy(xpath="(//input[@type='radio'])[1]")
	WebElement specificToOnlySomeRooms;
    
    @FindBy(xpath="(//input[@type='radio'])[2]")
  	WebElement commonToAllRooms;
	
    @FindBy(xpath="(//input[@type='radio'])[3]")
  	WebElement propertyAmenity;
    
    @FindBy(xpath="//input[@value='Save']")
  	WebElement saveButton;
    
    @FindBy(xpath="(//a[text()='Delete'])[last()]")
  	WebElement delete;
	
    @FindBy(xpath="(//a[text()='Edit'])[last()]")
  	WebElement edit;
    
    @FindBy(xpath="//a[text()='+ Add an amenity']")
  	WebElement addAmenity;
    
    @FindBy(xpath="//td[text()='Parking']")
  	WebElement parking;
    
    @FindBy(xpath="//td[text()='Free Wifi']")
  	WebElement freeWifi;
    
    @FindBy(xpath="//td[text()='Kitchen Facility']")
  	WebElement kitchenFacility;
    
    @FindBy(xpath="//td[text()='Evening Snacks']")
  	WebElement eveningSnaks;
    
    @FindBys(@FindBy(xpath="//table//table[5]//tr/td[2]"))
	List<WebElement> allAmenityName;
    
    
   /*
    * Method for enter amenities name 
    */
   public AmenitiesForSpecificRoomPage enterAmenitiesName(String name) {
   amenitiesName.sendKeys(name);
    return null;
	 }
   
   /*
    * Method for select property amenities
    */
   public AmenitiesForSpecificRoomPage selectPropertyAmenities() {
	propertyAmenity.click();
	return null;
	  }
	
   /*
    * Method for select common room amenities
    */
   public AmenitiesForSpecificRoomPage selectCommonRoomAmenities() {
		commonToAllRooms.click();
   	return null;
   	  }
   
   /*
    * Method for select room specific amenities
    */
   public AmenitiesForSpecificRoomPage selectRoomSpecificAmenities() {
    specificToOnlySomeRooms.click();
     return null;
      }
   
   /*
    * Method for clear amenities name
    */
   public AmenitiesForSpecificRoomPage clearAmenitiesName() {
     amenitiesName.clear();
     return null;
      }
   
   /*
    * Method for click on save
    */
    public AmenitiesForSpecificRoomPage clickOnSave() {
	saveButton.click();
	return null;
	 }
	
    /*
     * Method for click on delete
     */
    public AmenitiesForSpecificRoomPage clickOnDelete() {
    delete.click();
    driver.switchTo().alert().accept();
    return null;
	 }
     
    /*
     * Method for click on edit
     */
    public AmenitiesForSpecificRoomPage clickOnEdit() {
    edit.click();
    return null;
     }
     
    /*
     * Method for click on add amenities
     */
    public AmenitiesForSpecificRoomPage clickOnAddAmenities() {
   	addAmenity.click();
    return null;
     }
   
    /*
     * Method for verify TC01
     */
    public boolean verifyAmentitiesForSpecificRoom_TC01(){
		String actText=parking.getText();
		String expText=e.getCellData("Sheet1","amenitiesName",2);
    	 if(actText.equals(expText)) {
    		 System.out.println("Type-property amenities is created");
    	     return true;
    	 }
    	 else {
    		 System.out.println("Testcase is failed");
    	 }
    		return false;
    	 }
    
    /*
     * Method for verify TC02
     */
     public boolean verifyAmentitiesForSpecificRoom_TC02(){
			String actText=freeWifi.getText();
			String expText=e.getCellData("Sheet1","amenitiesName",3);
     	 if(actText.equals(expText)) {
     		 System.out.println("Type-common to all room created");
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
     public boolean verifyAmentitiesForSpecificRoom_TC03(){
			String actText=kitchenFacility.getText();
			String expText=e.getCellData("Sheet1","amenitiesName",4);
      	 if(actText.equals(expText)) {
      		 System.out.println("Type-specific to some room only created");
      	     return true;
      	 }
      	 else {
      		 System.out.println("Testcase is failed");
      	 }
      		return false;
      	 }
     
     /*
      * Method for verify TC04
      */
     public boolean verifyAmentitiesForSpecificRoom_TC04(){
			String actText=eveningSnaks.getText();
			String expText=e.getCellData("Sheet1","amenitiesName",5);
       	 if(actText.equals(expText)) {
       		 System.out.println("Amenities edit successfully");
       	     return true;
       	 }
       	 else {
       		 System.out.println("Testcase is failed");
       	 }
       		return false;
       	 }
     
     /*
      * Method for verify TC05
      */
     public boolean verifyAmentitiesForSpecificRoom_TC05(String name) {
		for (WebElement SingleName : allAmenityName) {
			String a = SingleName.getText();
			if(a.equals(name)) {
				return false;	
			}
		}
		return true;
    }
}

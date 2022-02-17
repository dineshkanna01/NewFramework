package com.admin.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;

/*
* POM class to create different Channels
* @Author Uzair Asar
*/
public class ChannelPage extends AbstractBasePage{
	
	@FindBy(xpath = "//div[text()='Property Management']")
	WebElement propertyManagementTab;

	@FindBy(xpath = "//a[text()='Channels']")
	WebElement channelsOption;

	@FindBy(xpath = "//a[text()='Add New Channel Group']")
	WebElement addNewChannel;

	@FindBy(xpath = "//select[@name='selectedChannelGroupName']")
	WebElement selectChannel;

	@FindBy(xpath = "//option[@value='GDS']")
	WebElement GDSChannel;

	@FindBy(xpath = "//input[@value='Amadeus']")
	WebElement channelType;

	@FindBy(xpath = "//input[@id='3chainCode']")
	WebElement chainCode;

	@FindBy(xpath = "//input[@id='3']")
	WebElement hotelCode;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement saveChannelButton;

	@FindBy(xpath = "//td[text()='GDS']")
	WebElement verifyGDSText;

	@FindBy(xpath = "(//input[@name='propChannels'])[last()]")
	WebElement selectToDelete;

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//option[@value='PMS']")
	WebElement PMSChannel;

	@FindBy(xpath = "//*[text()='Add New Channel']")
	WebElement newChannelPMS;

	@FindBy(xpath = "//select[@name='channelType']")
	WebElement channelTypePMS;

	@FindBy(xpath = "//option[@value='PMS_HTNG_2008A_RATE_AMOUNT_UPDATE']")
	WebElement selectChannelTypePMS;

	@FindBy(xpath = "//input[@name='requestUri']")
	WebElement externalURI;

	@FindBy(xpath = "//input[@name='retryInterval']")
	WebElement retryInterval;

	@FindBy(xpath = "//input[@name='maxRetryCount']")
	WebElement maxRetryCount;

	@FindBy(xpath = "//td[text()='PMS']")
	WebElement verifyPMSText;

	@FindBy(xpath = "//li[text()='Request URI is required']")
	WebElement verifyURIBlankText;
	
	@FindBy(xpath = "//li[text()='Retry interval is either not given, too big, or not a number. Enter a number that is not higher than 2,147,483,646. Use 0 for no retry interval.']")
	WebElement verifyRetryIntervalBlankText;
	
	@FindBy(xpath = "//li[text()='Max retry count is either not given, too big, or not a number. Enter a number that is not higher than 255. Use 0 for no max retry count.']")
	WebElement verifyMaxRetryCountBlankText;

	public ChannelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	 * Method to open Property Tab
	 */
	
	public ChannelPage openPropertyTab(){
		Helper.implict(3);
		propertyManagementTab.click();
		return null;
	}

	/*
	 * Method to click ok on pop up
	 */
	
	public void alertPopUp(){
		Helper.implict(3);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/*
	 * Method to open channel
	 */
	
	public ChannelPage openChannels() {
		Helper.implict(3);
		channelsOption.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select a channel
	 */
	
	public ChannelPage selectingChannel(){
		addNewChannel.click();
		Helper.implict(3);
		selectChannel.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to create a GDS channel
	 */
	
	public ChannelPage addGDS() {
		GDSChannel.click();
		Helper.implict(3);
		channelType.click();
		Helper.implict(3);
//		Helper.explicit(3);
		chainCode.sendKeys(ExcelData.getCellData("Channel", "ChainCode", 2));
//		Helper.explicit(3);
		Helper.implict(3);
		hotelCode.sendKeys(ExcelData.getCellData("Channel", "HotelCode", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify save button
	 * returns string s
	 */
	
	public String verifySaveButton() {
		String s = saveChannelButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	/*
	 * Method to click on save button
	 */
	
	public ChannelPage saveButton() {
		saveChannelButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify GDS created
	 * returns string s
	 */
	
	public String verifyGDSChannel() {
		String s = verifyGDSText.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to select channel to delete
	 */
	
	public ChannelPage deleteChannelSelected() {
		Helper.implict(3);
		selectToDelete.click();
		return null;
	}

	/*
	 * Method to verify delete button
	 * returns string s
	 */
	
	public String verifyDeleteButton() {
		String s = deleteButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	/*
	 * Method to click on delete button
	 */
	
	public ChannelPage deleteButton() {
		Helper.implict(3);
		deleteButton.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to add PMS channel
	 */
	
	public ChannelPage addPMS() {
		Helper.implict(3);
		PMSChannel.click();
		Helper.implict(3);
		newChannelPMS.click();
		Helper.implict(3);
		channelTypePMS.click();
		Helper.implict(3);
		selectChannelTypePMS.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to provide uri
	 */
	
	public ChannelPage URI() {
		externalURI.sendKeys(ExcelData.getCellData("Channel", "ExternalURI", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify blank URI error
	 * returns string s
	 */
	
	public String verifyURIBlankText() {
		String s = verifyURIBlankText.getText();
		System.out.println(s);
		Helper.implict(3);
		return s;
	}

	/*
	 * Method to provide retry interval data
	 */
	
	public ChannelPage retryInterval(){
		retryInterval.sendKeys(ExcelData.getCellData("Channel", "RetryInterval", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify blank retry interval error
	 * returns string s
	 */
	
	public String verifyRetryIntervalBlankText(){
		String s = verifyRetryIntervalBlankText.getText();
		System.out.println(s);
		Helper.implict(3);
		return s;
	}

	/*
	 * Method to provide max retry count data
	 */
	
	public ChannelPage maxRetryCount(){
		maxRetryCount.sendKeys(ExcelData.getCellData("Channel", "MaxRetryCount", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify blank max retry count error
	 * returns string s
	 */
	
	public String verifyMaxRetryCountBlankText(){
		String s = verifyMaxRetryCountBlankText.getText();
		System.out.println(s);
		Helper.implict(3);
		return s;
	}

	/*
	 * Method to verify PMS channel created
	 * returns string s
	 */
	
	public String verifyPMSChannel() {
		String s = verifyPMSText.getText();
		System.out.println(s);
		return s;

	}
}

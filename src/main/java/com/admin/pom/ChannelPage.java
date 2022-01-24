package com.admin.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class ChannelPage extends AbstractBasePage{

	ExcelData e = new ExcelData();

	public ChannelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

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

	public ChannelPage openPropertyTab() throws InterruptedException {
		TestBase.implict(3);
		propertyManagementTab.click();
		return null;
	}
	
	public void alertPopUp() throws InterruptedException {
		TestBase.implict(3);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public ChannelPage openChannels() throws InterruptedException {
		TestBase.implict(3);
		channelsOption.click();
		TestBase.implict(3);
		return null;
	}

	public ChannelPage selectingChannel() throws InterruptedException {
		addNewChannel.click();
		TestBase.implict(3);
		selectChannel.click();
		TestBase.implict(3);
		return null;
	}

	public ChannelPage addGDS() throws Exception {
		GDSChannel.click();
		TestBase.implict(3);
		channelType.click();
		TestBase.implict(3);
		chainCode.sendKeys(e.getCellData("Channel", "ChainCode", 2));
		TestBase.implict(3);
		hotelCode.sendKeys(e.getCellData("Channel", "HotelCode", 2));
		TestBase.implict(3);
		return null;
	}

	public String verifySaveButton() {
		String s = saveChannelButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	public ChannelPage saveButton() throws InterruptedException {
		saveChannelButton.click();
		TestBase.implict(3);
		return null;
	}

	public String verifyGDSChannel() {
		String s = verifyGDSText.getText();
		System.out.println(s);
		return s;
	}

	public ChannelPage deleteChannelSelected() throws InterruptedException {
		TestBase.implict(3);
		selectToDelete.click();
		return null;
	}

	public String verifyDeleteButton() throws InterruptedException {
		String s = deleteButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	public ChannelPage deleteButton() throws InterruptedException {
		TestBase.implict(3);
		deleteButton.click();
		TestBase.implict(3);
		return null;
	}

	public ChannelPage addPMS() throws Exception {
		TestBase.implict(3);
		PMSChannel.click();
		TestBase.implict(3);
		newChannelPMS.click();
		TestBase.implict(3);
		channelTypePMS.click();
		TestBase.implict(3);
		selectChannelTypePMS.click();
		TestBase.implict(3);
		return null;
	}

	public ChannelPage URI() throws Exception {
		externalURI.sendKeys(e.getCellData("Channel", "ExternalURI", 2));
		TestBase.implict(3);
		return null;
	}

	public String verifyURIBlankText() throws InterruptedException {
		String s = verifyURIBlankText.getText();
		System.out.println(s);
		TestBase.implict(3);
		return s;
	}

	public ChannelPage retryInterval() throws Exception {
		retryInterval.sendKeys(e.getCellData("Channel", "RetryInterval", 2));
		TestBase.implict(3);
		return null;
	}
	
	public String verifyRetryIntervalBlankText() throws InterruptedException {
		String s = verifyRetryIntervalBlankText.getText();
		System.out.println(s);
		TestBase.implict(3);
		return s;
	}

	public ChannelPage maxRetryCount() throws Exception {
		maxRetryCount.sendKeys(e.getCellData("Channel", "MaxRetryCount", 2));
		TestBase.implict(3);
		return null;
	}

	public String verifyMaxRetryCountBlankText() throws InterruptedException {
		String s = verifyMaxRetryCountBlankText.getText();
		System.out.println(s);
		TestBase.implict(3);
		return s;
	}
	
	public String verifyPMSChannel() {
		String s = verifyPMSText.getText();
		System.out.println(s);
		return s;

	}
}

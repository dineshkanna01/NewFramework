package com.cc.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.pom.RatePlanPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 * POM class for VerifyingFilters_allthelinksandSortingonAvailabilityPagePage
 * @author Rudraksh Aggarwal
 */
public class VerifyingFilters_allthelinksandSortingonAvailabilityPagePage extends TestBase {

	@FindBy(xpath = "//*[@id='addNewCategoryButton']/input")
	WebElement addNewCategoryButton;
	@FindBy(xpath = "//input[@name='categoryName']")
	WebElement categoryName;
	@FindBy(xpath = "(//*[@name='editCategoryLink'])[1]")
	WebElement verifyCategoryName;
	@FindBy(name = "name")
	WebElement name;
	@FindBy(xpath = "(//input[contains(@id,'rate_')])[1]")
	WebElement rateGridRate;
	@FindBy(xpath = "//a[@href='#/rates/all/']")
	WebElement rateTabCC;
	@FindBy(xpath = "//span[text()='Group by room type'][last()]")
	WebElement grouByroomTabCC;
	@FindBy(name = "rateCode")
	WebElement ratePlanCode;
	@FindBy(name = "shortDescription")
	WebElement shortDescription;
	@FindBy(name = "bookingSDate")
	WebElement startDate;
	@FindBy(name = "checkInSDate")
	WebElement firstCheckInDate;
	@FindBy(xpath = "//*[@value='All']")
	WebElement roomCheckbox;
	@FindBy(name = "selectedCategoryId")
	WebElement category;
	@FindBy(xpath = "//span[contains(@class,\"bootstrap-switch-handle-off\")]")
	WebElement groupByRatePlan;
	@FindBy(xpath = "//select[contains(@class,\"price-sort-select\")]")
	WebElement priceFilterDropdown;
	@FindBy(xpath = "(//a[contains(@class,'hotel-room-name') and contains(@data-target,'#roomInfoModal')])[1]")
	WebElement groupbyRoom;
	@FindBy(xpath = "(//*[text()='BAR'])[1]/preceding::input[1]")
	WebElement rpBar;
	@FindBy(xpath = "(//a[contains(@href,'displayEditRoom')])[1]")
	WebElement editRoom;
	@FindBy(xpath = "(//a[contains(@href,'displayEditRoom')])[1]/preceding::td[3]")
	WebElement roomNameAdmin;
	@FindBy(xpath = "(//input[contains(@id,'selectedBedId')])[last()]/following::td[1]")
	WebElement bedTypeNameAdmin;
	@FindBy(xpath = "(//input[contains(@id,'selectedBedId')])[last()]")
	WebElement bedTypeNameAdminCheckBox;
	@FindBy(xpath = "//input[@name ='save'][2]")
	WebElement savebutton;
	@FindBy(xpath = "//a[contains(@href,'method=addNew')]")
	WebElement addNewBedType;
	@FindBy(name = "name")
	WebElement bedNameField;
	@FindBy(name = "code")
	WebElement bedCodeField;
	@FindBy(xpath = "//input[@name='save']")
	WebElement saveBedType;
	@FindBy(xpath = "(//a[text()='Delete'])[last()]")
	WebElement deleteBedType;
	@FindBy(xpath = "//span[text()='OK']")
	WebElement ok;
	@FindBy(xpath = "//tr[@class='ratePlanHeader'][last()]")
	WebElement categoryNameDel;
	@FindBy(name = "button2")
	WebElement deleteButton;
	@FindBy(xpath = "//input[@value='Yes']")
	WebElement yesButton;
	@FindBy(xpath = "(//a[text()='Select'])[1]")
	WebElement selectRoom;

	public VerifyingFilters_allthelinksandSortingonAvailabilityPagePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to create Rate plan Category
	 */
	public OfferAccessCodeBookingPage createCategory() {
		addNewCategoryButton.click();
		Helper.implict(1);
		categoryName.sendKeys(ExcelData.CC_getCellData("FiltersData", "CategoryName", 2));
		return null;
	}

	/*
	 * Method to verify category name
	 * 
	 * @return boolean value
	 */
	public boolean verifyName() {
		String CName = verifyCategoryName.getText();
		CName = CName.replaceAll("\\s+", "");
		System.out.println(CName + " observed value");
		String ExcelCategoryName = ExcelData.CC_getCellData("FiltersData", "CategoryName", 2);
		ExcelCategoryName = ExcelCategoryName.replaceAll("\\s+", "");
		System.out.println(ExcelCategoryName + " excel value");
		if (CName.equals(ExcelCategoryName)) {
			System.out.println("Category created");
			return true;
		} else {
			System.out.println("Category Deleted");
			return false;
		}
	}

	/*
	 * Method to input rate plan TC01
	 */
	public OfferAccessCodeBookingPage inputRateplanTC01() {
		name.sendKeys(ExcelData.CC_getCellData("FiltersData", "rpname", 2));
		Helper.implict(1);
		ratePlanCode.sendKeys(ExcelData.CC_getCellData("FiltersData", "rpcode", 2));
		Helper.implict(1);
		Select dropdown = new Select(category);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("FiltersData", "CategoryName", 2));
		shortDescription.sendKeys(ExcelData.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		Helper.implict(3);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		startDate.sendKeys(strDate);
		Helper.implict(1);
		firstCheckInDate.sendKeys(strDate);
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to select Rate Plan Rate grid update
	 */
	public OfferAccessCodeBookingPage selectRatePlanRateGrid() {
		Helper.sleep(2000);
		String a = (ExcelData.CC_getCellData("FiltersData", "rpname", 2));
		WebElement rp = getDriver().findElement(By.xpath("//a[text()='" + a + "']/following::input[2]"));
		rp.click();
		return null;
	}

	/*
	 * Method to input Field Rate
	 */
	public void inputFieldRate() {
		rateGridRate.clear();
		rateGridRate.sendKeys(ExcelData.CC_getCellData("FiltersData", "Rate", 2));
	}

	/*
	 * Method to input Field Rate TC02
	 */
	public void inputFieldRateTC02() {
		rateGridRate.clear();
		rateGridRate.sendKeys(ExcelData.CC_getCellData("FiltersData", "Rate", 3));
	}

	/*
	 * Method to click Rate Tab CC
	 */
	public void clickRateTabCC() {
		Helper.explicit(rateTabCC, 10);
		rateTabCC.click();
	}

	/*
	 * Method to click Room Tab CC
	 */
	public void clickgroupByRoomTabCC() {
		Helper.explicit(grouByroomTabCC, 10);
		grouByroomTabCC.click();
	}

	/*
	 * Method to select Rp Bar
	 */
	public void selectRpBar() {
		Helper.explicit(rpBar, 20);
		rpBar.click();
	}

	/*
	 * Method to select Rate Plan CC
	 */
	public void selectRatePlanCC() {
		String b = (ExcelData.CC_getCellData("FiltersData", "rpname", 2));
		WebElement grpn2 = getDriver().findElement(By.xpath("//*[text()='" + b + "']/following::div[2]"));
		grpn2.click();
	}

	/*
	 * Method to select Rate Plan CC TC09
	 */
	public void selectRatePlansCCTC09() {
		Helper.sleep(5000);
		String c = (ExcelData.CC_getCellData("FiltersData", "rpname", 3));
		WebElement grpn = getDriver().findElement(By.xpath("//*[text()='" + c + "']/following::div[2]"));
		grpn.click();
		
		String b = (ExcelData.CC_getCellData("FiltersData", "rpname", 2));
		WebElement grpn2 = getDriver().findElement(By.xpath("//*[text()='" + b + "']/following::div[2]"));
		grpn2.click();
	}

	/*
	 * Method to get Rate Plan Names CC
	 */
	public void getRatePlanNameCC() {
		String xp2 = "(//div[contains(@class,'hotel-rate-details-container')]//a[contains(@data-target,'#rateInfoModal')])[1]";
		Helper.waitVisibility(20, xp2);
		WebElement b = getDriver().findElement(By.xpath(xp2));
		String b1 = b.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 54, b1);
	}

	/*
	 * Method to get Room Names CC
	 */
	public void getRoomNamesCC() {
		Helper.waitVisibility(20,
				"(//a[contains(@class,'hotel-room-name') and contains(@data-target,'#roomInfoModal')])[1]");
		String a = groupbyRoom.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 55, a);
	}

	/*
	 * Method to select Filter LowtoHigh
	 */
	public void selectFilterLowtoHigh() {
		Select a = new Select(priceFilterDropdown);
		a.selectByValue("low");
	}

	/*
	 * Method to select Filter High to Low
	 */
	public void selectFilterHightoLow() {
		Select a = new Select(priceFilterDropdown);
		a.selectByValue("high");
	}

	/*
	 * Method to select Filter normal
	 */
	public void selectFilterNomral() {
		Select a = new Select(priceFilterDropdown);
		a.selectByValue("");
	}

	/*
	 * Method to take SS and Compare Before After Low to High
	 */
	public boolean takeSSandCompareBeforeAfterLowtoHigh(String filename1, String filename2) throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		File outputfile = new File(f1 + ".png");
		ImageIO.write(screenshot1.getImage(), "PNG", outputfile);
		String destination = System.getProperty("user.dir") + "/target/ImagesCompare/" + f1 + ".png";
		File finalDestination = new File(destination);
		FileUtils.moveFile(outputfile, finalDestination);
		selectFilterLowtoHigh(); // call or make function to update the image
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different for low to high filter TC02");
			return true;
		} else {
			System.out.println("Both images are same for low to high filter TC02");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After High to Low
	 */
	public boolean takeSSandCompareBeforeAfterHighToLow(String filename1, String filename2) throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		selectFilterHightoLow(); // call or make function to update the image
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different for high to low filter TC03");
			return true;
		} else {
			System.out.println("Both images are same for high to low filter TC03");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After Low to High Room
	 */
	public boolean takeSSandCompareBeforeAfterLowtoHighRoom(String filename1, String filename2) throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		selectFilterLowtoHigh(); // call or make function to update the image
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different for low to high room filter TC05");
			return true;
		} else {
			System.out.println("Both images are same for low to high room filter TC05");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After High to Low sRoom
	 */
	public boolean takeSSandCompareBeforeAfterHightoLowRoom(String filename1, String filename2) throws IOException {
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		selectFilterHightoLow(); // call or make function to update the image
		Helper.sleep(2000);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different for high to low room filter TC06");
			return true;
		} else {
			System.out.println("Both images are same for high to low room filter TC06");
			return false;
		}
	}

	/*
	 * Method to delete images compare folder
	 */
	public void delFolder() throws IOException {
		String destination = System.getProperty("user.dir") + "/target/ImagesCompare/";
		FileUtils.deleteDirectory(new File(destination));
	}

	/*
	 * Method to click Edit first Room in prop
	 */
	public void clickEditRoom() {
		Helper.waitVisibility(20, "(//a[contains(@href,'displayEditRoom')])[1]");
		editRoom.click();
	}

	/*
	 * Method to get first room name admin
	 */
	public String getRoomNameAdmin() {
		Helper.explicit(roomNameAdmin, 10);
		String rn = roomNameAdmin.getText();
		System.out.println("First room name admin:" + rn);
		return rn;
	}

	/*
	 * Method to click add new bed Type
	 */
	public void clickAddNewbedType() {
		Helper.explicit(addNewBedType, 15);
		addNewBedType.click();
		Helper.implict(3);

	}

	/*
	 * Method to input bed type
	 */
	public void createBedType() {
		Helper.explicit(bedNameField, 15);
		bedNameField.sendKeys(ExcelData.CC_getCellData("FiltersData", "BedName", 2));
		Helper.implict(1);
		bedCodeField.sendKeys(ExcelData.CC_getCellData("FiltersData", "BedCode", 2));
		Helper.implict(1);
		saveBedType.click();
		Helper.sleep(2000);
	}

	/*
	 * Method to get last Bed Type name Admin
	 */
	public String getBedTypenameAdmin() {
		Helper.explicit(bedTypeNameAdmin, 10);
		String bd = bedTypeNameAdmin.getText();
		System.out.println("Last bed type name admin:" + bd);
		return bd;
	}

	/*
	 * Method to select Bed Type
	 */
	public void selectBedType() {
		Helper.explicit(bedTypeNameAdminCheckBox, 20);
		bedTypeNameAdminCheckBox.click();
		Helper.implict(5);
		savebutton.click();
		Helper.sleep(1500);
	}

	/*
	 * Method to deselect Bed Type
	 */
	public void deselectBedType() {
		Helper.explicit(bedTypeNameAdminCheckBox, 20);
		bedTypeNameAdminCheckBox.click();
		savebutton.click();
		Helper.sleep(1500);
	}

	/*
	 * Method to delete Bed Type
	 */
	public void deleteBedType() {
		Helper.explicit(deleteBedType, 10);
		deleteBedType.click();
		Helper.waitVisibility(10, "//span[text()='OK']");
		ok.click();
		Helper.sleep(2000);
	}

	/*
	 * Method to enter Dates and Click Bed Type Filtert CC
	 */
	public void selectBedTypeFilter() {
		Helper.sleep(1000);
		String b = (ExcelData.CC_getCellData("FiltersData", "BedName", 2));
		WebElement e = getDriver().findElement(By.xpath("(//*[text()='" + b + "'])[1]/preceding::input[1]"));
		e.click();
	}

	/*
	 * Method to take SS and Compare Before After selecting and deselecting checkbox
	 * for bedtype
	 */
	public boolean takessandComparebeforeAfterSelectingBedTypeCheckbox(String filename1, String filename2)
			throws IOException {
		Helper.sleep(7000);
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		selectBedTypeFilter();
		Helper.sleep(500);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different for bed type filter TC07");
			return true;
		} else {
			System.out.println("Both images are same for bed type filter TC07");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After selecting and deselecting checkbox
	 * for room type
	 */
	public boolean takessandComparebeforeAfterSelectingRoomTypeCheckbox(String filename1, String filename2)
			throws IOException {
		Helper.sleep(5000);
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		selectRoom();
		Helper.sleep(500);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different for room type filter TC08");
			return true;
		} else {
			System.out.println("Both images are same Both images are different for room type filter TC08");
			return false;
		}
	}

	/*
	 * Method to take SS and Compare Before After selecting and deselecting checkbox
	 * for rate plan
	 */
	public boolean takessandComparebeforeAfterSelectingRatePlanCheckbox(String filename1, String filename2)
			throws IOException {
		Helper.sleep(7000);
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		selectRpBar(); // deselect
		Helper.sleep(500);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different Both images are different for rate plan type filter TC09");
			return true;
		} else {
			System.out.println("Both images are same different for rate plan type filter TC09");
			return false;
		}
	}
	
	/*
	 * Method to take SS and Compare Before After selecting and deselecting checkbox
	 * for rate plan and room type
	 */
	public boolean takessandComparebeforeAfterSelectingRatePlanAndRoomTypeCheckbox(String filename1, String filename2)
			throws IOException {
		Helper.sleep(7000);
		String f1 = filename1;
		String f2 = filename2;
		Object output = ((JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio");
		String value = String.valueOf(output);
		float windowDPR = Float.parseFloat(value);
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot1.getImage(), "PNG", new File(System.getProperty("user.dir") + "/target/"
				+ File.separator + "ImagesCompare" + File.separator + "/" + f1 + ".png"));
		Helper.sleep(2000);
		selectRoom();
		Helper.sleep(500);
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.scaling(windowDPR))
				.takeScreenshot(getDriver());
		ImageIO.write(screenshot2.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/target/ImagesCompare/" + f2 + ".png"));
		BufferedImage actualImage = screenshot1.getImage();
		BufferedImage expectedImage = screenshot2.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		Helper.sleep(2000);
		if (diff.hasDiff()) {
			System.out.println("Both images are different different for rate plan type and room type filter TC10");
			return true;
		} else {
			System.out.println("Both images are same different for rate plan type and room type filter TC10");
			return false;
		}
	}

	/*
	 * Method to select Standard Room
	 */
	public void selectRoom() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2));
		System.out.println(a);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		room.click();
		Helper.implict(1);
	}

	/*
	 * Method to delete rate plans
	 */
	public RatePlanPage deleteRatePlans() {
		categoryNameDel.click();
		String b = (ExcelData.CC_getCellData("FiltersData", "rpname", 2));
		List<WebElement> a = getDriver().findElements(
				By.xpath("//td[contains(text(),'" + b + "')]//preceding::input[@name='rateIdCheckbox'][1]"));
		for (WebElement i : a) {
			i.click();
		}
		deleteButton.click();
		Helper.explicit(yesButton, 50);
		yesButton.click();
		Helper.implict(4);
		return null;
	}
}

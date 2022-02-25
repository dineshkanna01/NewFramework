package base;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelData;

public class Helper extends TestBase{

	@SuppressWarnings("deprecation")
	public static WebElement explicit(WebElement name, int sec) {
		WebDriverWait wait = new WebDriverWait(getDriver(), sec);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(name));
		return element;
	}

	public static void refreshBE() {
		getDriver().get("https://alh.qa-igt.reztrip3-qa.com/");
	}

	public static ArrayList<String> switchTabs() {
		ArrayList<String> tab = new ArrayList<String>(getDriver().getWindowHandles());
		return tab;
	}

	public static void switchWindow(int num) {
		getDriver().switchTo().window(switchTabs().get(num));
	}

	//	Waits
	@SuppressWarnings("deprecation")
	public static void implict(int num) {
		getDriver().manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}

	public static void javaScript(String xPath) {
		WebElement element = getDriver().findElement(By.xpath(xPath));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	/*
	 * Method to click view button for same cc code as in confirmation page
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static void clickviewButton() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2);
		WebDriverWait wait = new WebDriverWait(getDriver(),120);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + a + "']/following::button[1]")));
		element.click();
		// WebElement e = getDriver().findElement(By.xpath("//*[text()='" + a +
		// "']/following::button[1]"));
		// e.click();
	}

	/*
	 * Method to refresh
	 * 
	 */
	public static void refresh() {
		getDriver().navigate().refresh();
	}

	public static void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void refreshAdmin(String url) {
		getDriver().get(prop.getProperty(url));
	}

}

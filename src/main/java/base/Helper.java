package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelData;

public class Helper extends TestBase{

	public static WebDriver driver;
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

	public static JavascriptExecutor js = (JavascriptExecutor)getDriver();

	public static String javaScript(String xPath) {
		WebElement element = getDriver().findElement(By.xpath(xPath));
		js.executeScript("arguments[0].click();", element);
		return xPath;
	}

	public static String jsSendkeys(String xPath, String argName) {
		WebElement element = getDriver().findElement(By.xpath(xPath));
		js.executeScript("arguments[0].click();", element);
		js.executeScript("arguments[0].value='"+argName+"';", element);
		return xPath;
	}

	public static void scrollBy(int v1, int v2) {
		js.executeScript("window.scrollBy("+v1+", "+v2+")");
	}

	public static void eleXpath(String xPath, String data) {
		WebElement a = getDriver().findElement(By.xpath(xPath));
		a.sendKeys(data);
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

	public static void coXpath() {
		String a = ExcelData.getCellData("MobileB", "Country", 2);
		WebElement e = getDriver().findElement(By.xpath("(//li[text()='"+a+"'])[1]"));
		e.click();
	}

	public static void coXpath2() {
		String a = ExcelData.getCellData("MobileB", "Country", 2);
		WebElement e = getDriver().findElement(By.xpath("//li[@ng-click=\"select(item)\"]"));
		e.click();
	}

	public static void stXpath() {
		//select[@placeholder="State"]//child::option[text()="Delhi"]
		String a = ExcelData.getCellData("MobileB", "State", 2);
		WebElement e = getDriver().findElement(By.xpath("//select[@placeholder=\"State\"]//child::option[text()='"+a+"']"));
		e.click();
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

	public static void currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date " + currentDate);
		sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='" + currentDate + "'])[1]")));
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	public static void nextDate() {
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date " + nextDaydate);
		WebElement b = getDriver().findElement(By.xpath("(//*[text()='" + nextDaydate + "'])[1]"));
		try {
			b.click();
		} catch (Exception e) {
			System.out.println("NA");
		}

	}

	public static WebElement actions(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		//		a.click();
		return ele;
	}

	public static WebElement xPath(String xpathName) {
		WebElement w = getDriver().findElement(By.xpath(xpathName));
		return null;
	}

	public static WebElement abcd(String xpath) {
		WebElement name = getDriver().findElement(By.xpath(xpath));
		return name;
	}

	public static void refreshURL() {
		getDriver().navigate().to("https://mio.qa-igt.reztrip3-qa.com/mobile");
	}

	/*
	 * Method to click view button for same cc code as in confirmation page for rt3viceversatc
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static void clickviewButtonRt3ViceVersa() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2);
		WebDriverWait wait = new WebDriverWait(getDriver(),120);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + a + "']/following::button[1]")));
		element.click();
		// WebElement e = getDriver().findElement(By.xpath("//*[text()='" + a +
		// "']/following::button[1]"));
		// e.click();
	}

	/*
	 * Method to wait till element is visible
	 * 
	 */
	public static void waitVisibility(int wait2 ,String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(),wait2);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}


}

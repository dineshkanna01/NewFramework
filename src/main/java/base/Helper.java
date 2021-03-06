package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelData;
import Utility.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper extends TestBase{

	public static WebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor)getDriver();
	public static Robot r;
	public static Actions action = new Actions(getDriver());

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

	public static void clickEle(String xPath) {
		WebElement a = getDriver().findElement(By.xpath(xPath));
		a.click();
	}

	public static void coXpath() {
		String a = ExcelData.getCellData("MobileB", "Country", 2);
		WebElement e = getDriver().findElement(By.xpath("(//li[text()='"+a+"'])[1]"));
		e.click();
	}

	@SuppressWarnings("unused")
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

	public static void refreshAdmin(String url) {
		getDriver().get(prop.getProperty(url));
	}

	@SuppressWarnings("deprecation")
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

	@SuppressWarnings("unused")
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


	public static void mouseOver(String path) {
		
		WebElement a = getDriver().findElement(By.xpath(path));
		action.moveToElement(a).contextClick(a).perform();
	}
	
	public static void robotClass() {
		Robot r;
		try {
			r = new Robot();
			for (int i = 1; i <=5; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static String paste() {
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_V);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_V);
		Helper.sleep(3000);
		action.sendKeys(Keys.COMMAND, "l").sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.COMMAND, "v").sendKeys(Keys.ENTER).build().perform();
		Helper.sleep(3000);
		return null;
		
	}
	
	public static void copyAndPaste() {
		WebElement promoUrl = getDriver().findElement(By.xpath("//a[contains(text(),'promoRate')]"));
		String attribute = promoUrl.getAttribute("href");
		System.out.println("copiedUrl: "+attribute);
//		js.executeScript("window.open(\""+attribute+"\")");
		Helper.sleep(10000);
	}
	
	public static void copiedUrl(String emulation, int w, int h) {
		WebElement promoUrl = getDriver().findElement(By.xpath("//a[contains(text(),'promoRate')]"));
		String attribute = promoUrl.getAttribute("href");
		System.out.println("copiedUrl: "+attribute);
		WebDriverManager.chromedriver().setup();
		Map<String, String> deviceMobEmu= new HashMap<String, String>();
		deviceMobEmu.put("deviceName", emulation);
		//		deviceMobEmu.put("deviceName", "Moto G4");
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", deviceMobEmu);
		tdriver.set(new ChromeDriver(chromeOptions));

		Dimension d = new Dimension(w, h);
		getDriver().manage().window().setSize(d);

//		getDriver().manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		getDriver().manage().timeouts().implicitlyWait(TestUtils.IMPLICITWAIT, TimeUnit.SECONDS);
		getDriver().get(attribute);
		String title = getDriver().getTitle();
		System.out.println(title);
		String currentUrl = getDriver().getCurrentUrl();
		System.out.println(currentUrl);
		Helper.sleep(3000);
//		String data = ExcelData.getCellData("LoginPageData", "UrlData", 5);
//		System.out.println("Verify Url: "+data);
//		getDriver().get("https://www.google.co.in/");
	}
	
	public static void openNewTab() {
		getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		String a = "window.open('about:blank','_blank');";
		((JavascriptExecutor) getDriver()).executeScript(a);
		ArrayList<String> tab = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tab.get(1));
//		getDriver().get("https://www.google.co.in/");
	}
	
	/*
	 * Method for explicit wait
	 */
	public static WebElement explicit(WebElement name, int sec) {
		WebDriverWait wait = new WebDriverWait(getDriver(), sec);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(name));
		return element;
	}

	/*
	 * Method to reopen BE in same tab
	 * 
	 */
	public static void refreshBE() {
		sleep(1000);
		getDriver().get("https://alh.qa-igt.reztrip3-qa.com/");
	}
	
	/*
	 * Method to reopen cc in same tab
	 * 
	 */
	public static void refreshCC() {
		sleep(1000);
		getDriver().get("https://alh.qa-igt.reztrip3-qa.com/cc");
	}

	public static ArrayList<String> switchTabs() {
		ArrayList<String> tab = new ArrayList<String>(getDriver().getWindowHandles());
		return tab;
	}

	/*
	 * Method to switch window
	 * 
	 */
	public static void switchWindow(int num) {
		getDriver().switchTo().window(switchTabs().get(num));
	}

	/*
	 * Method for implicit wait
	 * 
	 */
	public static void implict(int num) {
		getDriver().manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
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
	}

	/*
	 * Method to refresh
	 * 
	 */
	public static void refresh() {
		getDriver().navigate().refresh();
	}
	/*
	 * Method to wait 
	 * 
	 */
	public static void sleep(int num) {
		try {
		Thread.sleep(num);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
	
	/*
	 * Method to wait till element is visible
	 * 
	 */
	public static void waitVisibility(int wait2 ,String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(),wait2);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	/*
	* Method to open config IBE
	*
	*/
	public static void openconfigIBE() {
	getDriver().get("https://demo.qa-igt.reztrip3-qa.com/IBEconfig/");
	}
}

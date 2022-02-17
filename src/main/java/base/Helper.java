package base;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

}

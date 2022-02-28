package mobiletesting;

import org.testng.annotations.Test;

import base.TestBase;
import pages.MBPages;

public class MBTest extends TestBase {

//	public static Utilitylog logger;
	MBPages mbp;

	public MBTest() {
		super();
//		logger = new Utilitylog(MBTest.class.getName());
		mbp= new MBPages(getDriver());
	}

	@Test
	public void checkingBooking() throws Exception {
		mobileTest("Moto G4", 318,850);
//		Helper.javaScript("//a[@aria-label=\"dismiss cookie message\"]");
//		driver.findElement(By.xpath("//a[@aria-label=\"dismiss cookie message\"]")).click();
//		Thread.sleep(5000);
		mbp.dateSelection();
		mbp.noAdult();
		mbp.selectRoom();
		mbp.avlOffers();
		mbp.comReservation();
		
	}

}

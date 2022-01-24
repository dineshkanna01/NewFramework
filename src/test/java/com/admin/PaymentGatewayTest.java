package com.admin;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.PaymentGatewayPage;

import Utility.ExcelData;
import base.TestBase;

public class PaymentGatewayTest extends TestBase {

	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	PaymentGatewayPage pgp;
	SoftAssert soft;
	
	public PaymentGatewayTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
	    lp=new LoginPage(getDriver());	
		ahp=new AdministratorHomePage(getDriver());
		pgp=new PaymentGatewayPage(getDriver());
		soft= new SoftAssert();
	}

	@Test
	public void paymentGateway_TC_01() throws Exception {
		extentTest = extent.startTest("PaymentGateway_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		ahp.clickPropertyManagementTab();
		ahp.clickPaymentGatewayTab();
		pgp.clickEnableButton();
		pgp.clickYesButton();
		pgp.selectPaymentGateway(e.getCellData("Sheet1","paymentGateway",2));
		pgp.clearMerchantId();
		pgp.merchantId_JCC();
		pgp.clearAccessCode();
		pgp.accessCode_JCC();
		pgp.clearSecureHashSecret();
		pgp.secureHashSecret_JCC();
		pgp.delayTime();
		pgp.orderTime();
		pgp.clickUpdateButton();
		String actText=pgp.administratorname();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Payment Gateway has updated");
		soft.assertAll();
	}
	
	@Test
	public void paymentGateway_TC_02() throws Exception {
		extentTest = extent.startTest("PaymentGateway_TC_02");
		ahp.clickPaymentGatewayTab();
		pgp.clickEnableButton();
		pgp.clickYesButton();
		pgp.selectPaymentGateway(e.getCellData("Sheet1","paymentGateway",3));
		pgp.delayTime();
		pgp.orderTime();
		pgp.clickUpdateButton();
		String actText=pgp.administratorname();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Payment Gateway has updated");
		soft.assertAll();
	}
	
	@Test
	public void paymentGateway_TC_03() throws Exception {
		extentTest = extent.startTest("PaymentGateway_TC_03");
		ahp.clickPaymentGatewayTab();
		pgp.clickEnableButton();
		pgp.clickYesButton();
		pgp.selectPaymentGateway(e.getCellData("Sheet1","paymentGateway",4));
		pgp.clearSecureHashSecret();
		pgp.secureHashSecret_SHIFT4();
		pgp.clearDelayTime();
		pgp.delayTime_SHIFT4();
		pgp.orderTime();
		pgp.clickUpdateButton();
		String actText=pgp.administratorname();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Payment Gateway has updated");
		soft.assertAll();
	}
	
	@Test
	public void paymentGateway_TC_04() throws Exception {
		extentTest = extent.startTest("PaymentGateway_TC_04");
		ahp.clickPaymentGatewayTab();
		pgp.clickEnableButton();
		pgp.clickYesButton();
		pgp.selectPaymentGateway(e.getCellData("Sheet1","paymentGateway",5));
		pgp.clearMerchantId();
		pgp.merchantId_SIMPLEPAY();
		pgp.clearAccessCode();
		pgp.accessCode_SIMPLEPAY();
		pgp.clearSecureHashSecret();
		pgp.secureHashSecret_SIMPLEPAY();
		pgp.delayTime();
		pgp.orderTime();
		pgp.clickUpdateButton();
		String actText=pgp.administratorname();
		String expText=e.getCellData("Sheet1","AdministratorText",2);
		soft.assertEquals(actText, expText,"Payment Gateway has updated");
		soft.assertAll();
		lp.logout();
	}

    @AfterSuite
	public void report() throws Exception {
	mail();
	cmdPrompt();
	}
    
}

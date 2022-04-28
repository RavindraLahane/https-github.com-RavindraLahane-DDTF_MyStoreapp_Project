/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author Perennial
 *
 */
public class EndToEndTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage  paymentpage;
	OrderSummary ordersummary;
	OrderConfirmationPage orderconfirmationpage;	
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {
		indexpage = new  IndexPage();
		searchresultpage=indexpage.searchProduct("t-shirt");
		addToCartPage=searchresultpage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddTocart();
		orderpage=addToCartPage.clickOnProceedToCheckOut();
		loginpage=orderpage.clickOnCheckOut();
		addresspage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"), addresspage);
		shippingpage=addresspage.clickOnCheckOut();
		shippingpage.checkTheTerms();
		paymentpage=shippingpage.clickOnProceedToCheckOut();
		ordersummary=paymentpage.clickOnPaymentMethod();
		orderconfirmationpage=ordersummary.clickOnconfirmOrderBtn();
		String actualMessage = orderconfirmationpage.validateConfirmMessage();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);	
	}
}

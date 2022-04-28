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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Perennial
 *
 */
public class HomePageTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage  homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void wishListTest() {
	 indexpage = new  IndexPage();
	 loginpage=indexpage.clickOnSignIn();
	 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"),homepage);
	 boolean result = homepage .validateMyWishList();
	 Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryandDetailsTest() {
	 indexpage = new  IndexPage();
	 loginpage=indexpage.clickOnSignIn();
	 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"),homepage);
	 boolean result = homepage.validateOrderHistory();
	 Assert.assertTrue(result);
	}
	
	
}

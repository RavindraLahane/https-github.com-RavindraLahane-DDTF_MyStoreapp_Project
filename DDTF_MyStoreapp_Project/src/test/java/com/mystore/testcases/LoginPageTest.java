package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	AddressPage  homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "Credentials", dataProviderClass = DataProviders.class,groups= {"Smoke","Sanity"})
	public void loginTest(String uname,String pswd) {
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("user is going to click on SignIn");
	    loginpage = indexpage.clickOnSignIn();
	    Log.info("Enter Username and Password");
	    //homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	    homepage = loginpage.login1(uname,pswd,homepage);
	    String actualURL=homepage.getCurrentURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("login is Success");
	    Log.endTestCase("loginTest");
	}

}

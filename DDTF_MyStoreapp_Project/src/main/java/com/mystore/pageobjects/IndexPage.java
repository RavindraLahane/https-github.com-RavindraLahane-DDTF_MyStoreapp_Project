package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	// Declaration int a;
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;

	//Constructor int a=10;
	public IndexPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	//Usage- action method -Non Static Method
	public LoginPage clickOnSignIn () {
		Action.fluentWait(signInBtn,10);
		Action.click(getDriver(),signInBtn);
		return new LoginPage();
		//signInBtn.click();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(),myStoreLogo);
	}
	
	public String getMyStoreTitle () {
		String MyStoreTitle = getDriver().getTitle();
		return MyStoreTitle;
	}
	
	public SearchResultPage searchProduct (String productName) {
		Action.type(searchProductBox,productName );
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
}

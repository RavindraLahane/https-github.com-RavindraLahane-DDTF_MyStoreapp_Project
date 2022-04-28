/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Perennial
 *
 */
public class AddressPage extends BaseClass {
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	 public ShippingPage clickOnCheckOut() {
		 Action.click(getDriver(), ProceedToCheckOut);
		 return new ShippingPage();
	 }

	public String getCurrentURL() {
		String adresspageURL =Action.getDriver().getCurrentUrl();
		return adresspageURL;
	}
}

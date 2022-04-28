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
public class AddToCartPage extends BaseClass {
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addtocartBtn;
	
	@FindBy(xpath="//i[@class='icon-ok']")
	WebElement addtocartmessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCkeckOutBtn;
	
	
	
	 public AddToCartPage () 
	 {
			PageFactory.initElements(getDriver(), this);
	 }
	 
	 public void enterQuantity(String quantity1) {
		 Action.type(quantity, quantity1);
	 }
     
	 public void selectSize(String size1) {
		 Action.selectByVisibleText(size,size1);
	 }
	 
	 public void clickOnAddTocart() {
		 Action.click(getDriver(),addtocartBtn);
	 }
	 
	 public boolean validateAddToCart()  {
		Action.fluentWait(addtocartmessage,20);
		return Action.isDisplayed(getDriver(), addtocartmessage);
	 }
	 
	 public OrderPage clickOnProceedToCheckOut() throws Exception {
		Action.fluentWait(addtocartmessage,10);
		Action.JSClick(getDriver(), proceedToCkeckOutBtn);
		return new OrderPage();
	 }
}

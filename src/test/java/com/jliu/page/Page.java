package com.jliu.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	 protected final WebDriver driver;
	@FindBy(id = "header")
	WebElement header;	
 
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 public boolean isPageLoaded()
	 { 
		 if (waitForJStoLoad() && header.isDisplayed())
			 return true;
		 return false;
	 }
	 
	 public boolean waitForJStoLoad() {
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  if (js.executeScript("return document.readyState").toString().equals("complete")){  
			  return true;
		  } 
		  return false;
	 }
}

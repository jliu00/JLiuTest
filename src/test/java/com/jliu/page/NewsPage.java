package com.jliu.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage{
	 protected final WebDriver driver;
	 
	 @FindBy(id = "header")
	 WebElement header;	
	 
	 @FindBy(linkText = "Just In")
	 WebElement n_justin;
	 	 
	 public NewsPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 public JustInPage navigate()
	 {
		 this.n_justin.click();
		 return new JustInPage(driver);
	 }
	 
	 public NewsPage navigate(String linkText)
	 {
		 //map 
		 return new NewsPage(driver);		//news program page
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

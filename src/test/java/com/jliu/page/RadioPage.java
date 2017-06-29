package com.jliu.page;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioPage extends Page {
//	protected final WebDriver driver;
	@FindBy(id="right-arrow")
	WebElement right_arrow;
	
	@FindBy(className="at-a-glance")
	WebElement menu;
	
	@FindBy(id="search-simple-input-query")
	WebElement search_input;
	
	@FindBy(id="search-simple-input-submit")
	WebElement search_submit;
	
	
	
	public RadioPage(WebDriver driver) {
		 super(driver);
	 }
	 
	 public RadioPage naviProgram(String linkText) throws InterruptedException{
		 WebElement prog = driver.findElement(By.linkText("Programs"));
		 
		 WebElement to =driver.findElement(By.linkText(linkText));
		 Actions action = new Actions(driver);
		 
		 action.moveToElement(prog).build().perform();
		 Thread.sleep(1000);
		 action.moveToElement(to).build().perform();
		 to.click();
		 
		 return new RadioProgramPage(driver);
	 }
	 
	 public RadioPage naviOnAir() {		//to last
		
		 List<WebElement> allElements = menu.findElements(By.tagName("li"));
		 WebElement guide = allElements.get(allElements.size()-1);
		 WebElement last = allElements.get(allElements.size()-2);
		 
		 while(!guide.isDisplayed())
		 right_arrow.click();
		 
		 System.out.println(last.toString());
		 last.click();
		 return new RadioProgramPage(driver);
	 }
	 
	 public RadioPage search(String keyword){
		 search_input.sendKeys(keyword);
		 search_submit.click();
		 return new RadioPage(driver);
	 }
}

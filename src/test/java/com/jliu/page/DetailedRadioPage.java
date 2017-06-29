package com.jliu.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailedRadioPage extends RadioPage {

	 @FindBy(id = "twitter-widget-0")
	 WebElement twitterFrame;	
	 
	 @FindBy(xpath = "//iframe[@title='fb:share_button Facebook Social Plugin']")
	 WebElement fbFrame;
	 
//	 @FindBy(className = "ico ico-download")
	 @FindBy(xpath = "//a[@class='ico ico-download']")
	 WebElement download;
	 
	 @FindBy(xpath = "//a[@class='ico ico-audio modrewrite']")
	 WebElement listen;
	
	public DetailedRadioPage(WebDriver driver) {
		super(driver);
	}
	
	public void facebookShare(){
		String title;
		driver.manage().window().maximize();
		driver.switchTo().frame(fbFrame);
		driver.findElement(By.tagName("button")).click();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);	
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Facebook"));		
		title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		Assert.assertTrue(title.contains("Facebook")); 
	}
/*
 * 	public void facebookShare(){
		String title;
		
		driver.switchTo().frame(fbFrame);
		driver.findElement(By.tagName("button")).click();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);	
		}
		
		title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		Assert.assertTrue(title.contains("Facebook")); 
	}	
 */
	
	public void twitterShare(){
		String title;
		driver.manage().window().maximize();
		driver.switchTo().frame(twitterFrame);
		driver.findElement(By.linkText("Tweet")).click();
		


		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Share a link on Twitter"));
		title = driver.getTitle();
		System.out.println(title);
		driver.close();

		Assert.assertTrue(title.contains("Share a link on Twitter")); 
	}
	
	public void download(){
		String src = download.getAttribute("href");
		download.click();		
//		System.out.println(src);
//		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(src));
	}
	
	public ListenPage listen(){
		String src = listen.getAttribute("href");
		listen.click();		
	
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		return new ListenPage(driver);
//		System.out.println(src);
//		System.out.println(driver.getCurrentUrl());
//
//		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(src));	
		
	}
}

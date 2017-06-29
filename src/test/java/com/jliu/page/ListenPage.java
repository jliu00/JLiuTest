package com.jliu.page;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListenPage {//extends RadioPage{
	protected final WebDriver driver;
	
	 @FindBy(id = "player")
	 WebElement player;	
	 
	public ListenPage(WebDriver driver){
//		 super(driver);
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public boolean isPlayerLoaded(){
		System.out.println(driver.getTitle());
		return player.isDisplayed();
	}
}

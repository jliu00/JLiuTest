package com.jliu.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoPage extends NewsPage {

	@FindBy(className="jwplayer-video")
	WebElement video;
	
	
	public VideoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void checkVideo(){
//		video.getAttribute("style");
		Assert.assertTrue(video.isDisplayed());
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String status = js.executeScript("document.getElementsByTagName(\"video\")[0].readyState").toString();		
//		Assert.assertTrue(status.equals("4"));
	}
}

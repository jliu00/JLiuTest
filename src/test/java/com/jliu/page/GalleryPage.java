package com.jliu.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GalleryPage extends NewsPage {

	@FindBy(className="imageGallery")
	WebElement gallery;
	
	@FindBy(className="lSPager")
	WebElement pager;
	
	public GalleryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void checkGallery(){
		List<WebElement> allElements = gallery.findElements(By.tagName("li"));
		WebElement img = allElements.get(0).findElement(By.tagName("img"));
		Assert.assertTrue(img.isDisplayed());
		
		allElements = pager.findElements(By.tagName("li"));
		for(int i=0; i<10 && i<allElements.size();i++) {
			WebElement elem = allElements.get(i);
			img = elem.findElement(By.tagName("img"));
			Assert.assertTrue(img.isDisplayed());
		}
	}
}

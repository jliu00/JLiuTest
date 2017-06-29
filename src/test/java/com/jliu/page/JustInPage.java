package com.jliu.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JustInPage extends NewsPage { 

	 
	@FindBy(className="article-index")
	WebElement article_index;	
	 
	 public JustInPage(WebDriver driver) {
		 super(driver);
		 if (!driver.getTitle().contains("Just In"))
			 throw new IllegalStateException("This is not Just In Page, current page" +
					 "is: " +driver.getCurrentUrl());
		 PageFactory.initElements(driver, this);
	 }

	 public boolean validateIndex() {
		 List<WebElement> allElements = article_index.findElements(By.tagName("li"));
		 List<WebElement> title;
		 List<WebElement> timestamp;
		 List<WebElement> text;
		 for (WebElement li_elem: allElements) {
			 title = li_elem.findElements(By.tagName("h3"));
			 timestamp = li_elem.findElements(By.xpath("//p[not(@class)]"));
			 text = li_elem.findElements(By.xpath("//p[(@class='published')]"));
			 
			 if(title.size() ==0 || timestamp.size() ==0 || text.size()==0)
				 return false;
		 }
		 return true;
	 }
}

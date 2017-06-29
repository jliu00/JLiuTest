package com.jliu.page;

import org.openqa.selenium.WebDriver;

public class RadioProgramPage extends RadioPage {

	public RadioProgramPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean checkTitle(String title){
		System.out.println(driver.getTitle());
		return driver.getTitle().contains(title);
	}

}

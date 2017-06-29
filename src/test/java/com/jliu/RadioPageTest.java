package com.jliu;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jliu.page.DetailedRadioPage;
import com.jliu.page.JustInPage;
import com.jliu.page.ListenPage;
import com.jliu.page.NewsPage;
import com.jliu.page.RadioProgramPage;
import com.jliu.page.RadioPage;

public class RadioPageTest {

	WebDriver driver;
	String url_radio = "http://www.abc.net.au/radionational/"; 


	@Before
	public void setUp() throws Exception {
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		System.out.println("setup");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("teardown");
	}
	
	@Test
	public void testRadioPageNavi() throws InterruptedException{
		String progName = "Big Ideas";
		driver.get(url_radio);
		RadioPage radioPage = new RadioPage(driver);
		Assert.assertTrue(radioPage.isPageLoaded());
		
		RadioProgramPage programPage = (RadioProgramPage) radioPage.naviProgram(progName);
		Assert.assertTrue(programPage.checkTitle(progName));
	}
	
	@Test
	public void testRadioNaviOnAir(){
		driver.get(url_radio);
		RadioPage radioPage = new RadioPage(driver);
		Assert.assertTrue(radioPage.isPageLoaded());
		RadioProgramPage programPage = (RadioProgramPage) radioPage.naviOnAir();
//		Assert.assertTrue(programPage.checkTitle(progName));		
	}
	
	@Test
	public void testRadioSearch(){
		String keyword = "Big Ideas";
		driver.get(url_radio);
		RadioPage radioPage = new RadioPage(driver);
		Assert.assertTrue(radioPage.isPageLoaded());
		RadioPage searchPage = radioPage.search(keyword);		//SearchPage
//		Assert		
	}

	@Test
	public void testFBShare() {
		String url = "http://www.abc.net.au/radionational/programs/bigideas/the-past-is-always-with-us/8650218";
		driver.get(url);
		DetailedRadioPage detailedPage = new DetailedRadioPage(driver);
		Assert.assertTrue(detailedPage.isPageLoaded());
		detailedPage.facebookShare();
	}
	
	@Test
	public void testTweet() {
		String url = "http://www.abc.net.au/radionational/programs/bigideas/the-past-is-always-with-us/8650218";
		driver.get(url);
		DetailedRadioPage detailedPage = new DetailedRadioPage(driver);
		detailedPage.twitterShare();
	}
	
	@Test	
	public void testDownload() {
		String url = "http://www.abc.net.au/radionational/programs/bigideas/the-past-is-always-with-us/8650218";
		driver.get(url);
		DetailedRadioPage detailedPage = new DetailedRadioPage(driver);
		detailedPage.download();
	}	
	
	@Test	
	public void testListen() {
		String url = "http://www.abc.net.au/radionational/programs/bigideas/the-past-is-always-with-us/8650218";
		driver.get(url);
		DetailedRadioPage detailedPage = new DetailedRadioPage(driver);
		ListenPage listenPage;
		listenPage = detailedPage.listen();
		Assert.assertTrue(listenPage.isPlayerLoaded());
	}

}

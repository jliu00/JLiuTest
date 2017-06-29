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

import com.jliu.page.GalleryPage;
import com.jliu.page.JustInPage;
import com.jliu.page.NewsPage;
import com.jliu.page.RadioProgramPage;
import com.jliu.page.RadioPage;
import com.jliu.page.VideoPage;

public class NewsPageTest {

	WebDriver driver;
	String url_news = "http://www.abc.net.au/news/"; 
	String url_justin = "http://www.abc.net.au/news/justin/";


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
	public void testNewsPageLoad() throws Exception {
		driver.get(url_news);
		NewsPage newsPage = new NewsPage(driver);
		Assert.assertTrue(newsPage.isPageLoaded());
	}
	
	@Test
	public void testNewsPageNavi(){
		driver.get(url_news);
		NewsPage newsPage = new NewsPage(driver);
		Assert.assertTrue(newsPage.isPageLoaded());
		
		JustInPage justinPage = newsPage.navigate();
		Assert.assertTrue(justinPage.validateIndex());
	}
	
	@Test
	public void testGallery() {
		String url = "http://www.abc.net.au/news/2017-02-10/abc-open-pic-of-the-week/8256256";
		driver.get(url);
		GalleryPage galleryPage = new GalleryPage(driver);
		Assert.assertTrue(galleryPage.isPageLoaded());
		galleryPage.checkGallery();
	}
	@Test
	public void testVideo() {
		String url = "http://www.abc.net.au/news/2017-02-09/weatherill-promises-to-intervene-dramatically/8254908";
		driver.get(url);
		VideoPage videoPage = new VideoPage(driver);
		Assert.assertTrue(videoPage.isPageLoaded());
		videoPage.checkVideo();
	}
}

package com.jliu;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.gson.Gson;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class APITest {
	
	public static String propDomain; ;
	String url_path;
	
	@Before
	public void setUp() throws Exception {
		String domain = System.getProperty("propDomain");	//or property file //mvn -DpropDomain="abc.com" -Dtest=APITest test
		
		if(domain == null) domain = "program.abcradio.net.au";
		
		url_path = "http://"+domain+"/api/v1/programs/";
//		System.out.println(url_path);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("teardown");
	
	}
	
	@DataProvider
	public static Object[][] dp_apikey_list() {
	    return new Object[][]{
	        {"ppJj0E8g2R"},
	        {"ppxa2Amj2b"}
	        //api list here
	    };
	}	
	
	public class Program{
		String entity;
		String arid;
		String title;
		String mini_synopsis;
		String short_synopsis;
		String medium_synopsis;
		String created_utc;
		String last_updated_utc;
		String service_airport_code;
	}
	
	@Test
	@UseDataProvider(value="dp_apikey_list")
	public void testApi(String apikey)
	{
		String response = getResult(apikey);
		
		Gson gson = new Gson();
		Program program = gson.fromJson(response, Program.class);
		//verify each member of program
		Assert.assertTrue(!program.entity.isEmpty());
		Assert.assertTrue(!program.arid.isEmpty());
		Assert.assertTrue(!program.title.isEmpty());
		Assert.assertTrue(!program.mini_synopsis.isEmpty());
		//...
	}
	
	public String getResult(String apikey){			
		String jsonResponse = new String();
		try{
			URL url = new URL(url_path+apikey+".json");
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : "
				+ conn.getResponseCode());
				}	
			
			Scanner scan = new Scanner(url.openStream());

			while (scan.hasNext())
				jsonResponse += scan.nextLine();

			scan.close();
		    conn.disconnect();
		    
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonResponse;
	}	
	
	public static void main(String[] args) {
//		new APITest().getResult("http://program.abcradio.net.au/api/v1/programs/ppJj0E8g2R.json");
//		new APITest().getResult("ppJj0E8g2R");
	}
}

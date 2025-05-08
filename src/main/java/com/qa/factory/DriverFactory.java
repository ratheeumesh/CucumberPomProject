 package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver webDriver;
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	
	/**
	 * This method helps to initialize the thread local driver on the basis of
	 * given driver (b_chrome, b_firefox, b_safari).
	 * @param driver_name
	 * @return
	 */
	public WebDriver init_driver(String driver_name) {
		
		System.out.println("Init browser value is: "+ driver_name);
		
		// we can use here Switch case, if else.
		if(driver_name.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(driver_name=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(driver_name=="safari") {
		//	WebDriverManager.chromedriver().setup(); - x_safari is not having binaries.
			tlDriver.set(new SafariDriver());
		}
		else {
		System.out.println("Please pass the correct browser value: " + driver_name) ;
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	

}

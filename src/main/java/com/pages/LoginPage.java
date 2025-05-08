/**
 * 
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 */
public class LoginPage {
	
	// Three main things (By locator, Constructor, Page actions).
	// Use encapsulation property here as: By locator (private), Page actions (public).
	
	private WebDriver webDriver;
	private By emailId= By.id("username");
	private By passwd = By.id("password");
	private By loginButton= By.id("login");
	
	
	public LoginPage(WebDriver driver) {
		this.webDriver = driver;
	}
	
	public String getLoginPageTitle() {
		    return webDriver.getTitle();
	}
	
	public void enterUsername(String username) {
		webDriver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pswrd) {
		webDriver.findElement(passwd).sendKeys(pswrd);
	}
	
	public void clickOnLogin() {
		webDriver.findElement(loginButton).click();
	}

}

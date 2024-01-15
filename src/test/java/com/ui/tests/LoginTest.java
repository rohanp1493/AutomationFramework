package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		//driver.get("https://automationpractice.techwithjatin.com/");
		
		BrowserUtility browserUtility = new BrowserUtility(driver);
		browserUtility.navigateToWebsite("https://automationpractice.techwithjatin.com/");
		
		//maximize the browser
		browserUtility.maximizeWindow();
		
		//click on sign in link
		By signInLinkLocator = By.xpath("//a[contains(text(), 'Sign in')]");
		browserUtility.clickOn(signInLinkLocator);
		
		//Enter email and password
		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "fipad42714@pazard.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "Admin@1234");
		
		//Click on Login Button
		By submitLoginButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonLocator);
		
		
	}

}

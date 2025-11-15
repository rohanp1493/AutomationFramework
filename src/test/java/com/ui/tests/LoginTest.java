package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.LandingPage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		
		LandingPage landingPage =  new LandingPage(driver);
		String userName = landingPage.goToLoginPage().peformLogin("fipad42714@pazard.com", "Admin@1234").getUserName();
		System.out.println(userName);
		
		
	}

}

package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.ENV.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public final class LandingPage extends BrowserUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	public LandingPage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); //To call Parent class constructor to child class constructor
		//navigateToWebsite(PropertiesUtil.readProperties(QA, "URL"));
		navigateToWebsite(JSONUtility.readJson(QA).getUrl());
	}
	
	

	public LandingPage(WebDriver lamdaDriver) {
		super(lamdaDriver);
	}



	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	

}

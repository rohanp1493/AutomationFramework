package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.testng.annotations.BeforeMethod;

import com.ui.pages.LandingPage;
import com.utility.BrowserUtility;

public class BaseTest {
	
	LandingPage landingPage;
	@BeforeMethod(description ="Load the LandingPage of the Website ")
	public void setUp() {
		landingPage =  new LandingPage(CHROME);
	}
	
	public BrowserUtility getInstance() {
		return landingPage;
	}
}

package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LandingPage;

public class LoginTest {
	
		LandingPage landingPage;
		
		@BeforeMethod(description ="Load the LandingPage of the Website ")
		public void setUp() {
			landingPage =  new LandingPage(CHROME);
		}
	
		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"})
		public void validLoginTest() {
		assertEquals(landingPage.goToLoginPage().peformLogin("fipad42714@pazard.com", "Admin@1234").getUserName(), "Rohan Patil");
	}

}

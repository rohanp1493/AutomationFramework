package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LandingPage;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;

public class LoginTest {
	
		LandingPage landingPage;
		
		@BeforeMethod(description ="Load the LandingPage of the Website ")
		public void setUp() {
			landingPage =  new LandingPage(CHROME);
		}
	
		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"}, 
				dataProviderClass=com.ui.dataproviders.LoginDataProviders.class, dataProvider="LoginTestProvider")
		public void verifyLoginTest(User user) {
		assertEquals(landingPage.goToLoginPage().peformLogin(user.getEmail(), user.getPassword()).getUserName(), "Rohan Patil");
	}
		
		
		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"}, 
				dataProviderClass=com.ui.dataproviders.LoginDataProviders.class, dataProvider="LoginTestCSVDataProvider")
		public void verifyoginTestCSV(User user) {
		assertEquals(landingPage.goToLoginPage().peformLogin(user.getEmail(), user.getPassword()).getUserName(), "Rohan Patil");
	}
		
		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"}, 
				dataProviderClass=com.ui.dataproviders.LoginDataProviders.class, dataProvider="LoginTestExcelDataProvider")
		public void verifyoginTestExcel(User user) {
		assertEquals(landingPage.goToLoginPage().peformLogin(user.getEmail(), user.getPassword()).getUserName(), "Rohan Patil");
	}
		
		

}

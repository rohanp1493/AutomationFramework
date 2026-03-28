package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.LandingPage;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListerner.class})
public class LoginTest extends BaseTest{
	
		Logger logger = LoggerUtility.getLogger(this.getClass());
		
	
		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"}, 
				dataProviderClass=com.ui.dataproviders.LoginDataProviders.class, dataProvider="LoginTestProvider")
		public void verifyLoginTest(User user) {
		assertEquals(landingPage.goToLoginPage().peformLogin(user.getEmail(), user.getPassword()).getUserName(), "Rohan Patil");
	}
		
		
//		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"}, 
//				dataProviderClass=com.ui.dataproviders.LoginDataProviders.class, dataProvider="LoginTestCSVDataProvider")
//		public void verifyoginTestCSV(User user) {
//		assertEquals(landingPage.goToLoginPage().peformLogin(user.getEmail(), user.getPassword()).getUserName(), "Rohan Patil");
//	}
		
//		@Test(description = "Verify login using with valid login credentials", groups= {"e2e", "sanity"}, 
//				dataProviderClass=com.ui.dataproviders.LoginDataProviders.class, dataProvider="LoginTestExcelDataProvider",
//				retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
//		public void verifyoginTestExcel(User user) {
//			logger.info("Started my login excel test");
//		assertEquals(landingPage.goToLoginPage().peformLogin(user.getEmail(), user.getPassword()).getUserName(), "Rohan Patil");
//		logger.info("login excel test completed");
//	}
		
		

}

package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.LandingPage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;

public class BaseTest {

	LandingPage landingPage;
	private boolean isLamdaTest;
	
	@Parameters({"browser", "isLamdaTest", "isHeadless"})
	@BeforeMethod(description = "Load the LandingPage of the Website ")
	public void setUp(
			@Optional("chrome") String browser,
			@Optional("false") boolean isLamdaTest, 
			@Optional("true")boolean isHeadless, ITestResult result) {
		this.isLamdaTest = isLamdaTest;
		WebDriver lamdaDriver;
		if (isLamdaTest) {
			lamdaDriver = LamdaTestUtility.intializeLamdaTestSession(browser, result.getMethod().getMethodName());
			landingPage = new LandingPage(lamdaDriver);

		} else {

			landingPage = new LandingPage(CHROME, isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return landingPage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLamdaTest) {
			LamdaTestUtility.quitSession();
		} else {
			landingPage.getDriver().quit();
		}
	}
}

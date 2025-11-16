package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.LandingPage;

public class LoginTest {

	public static void main(String[] args) {
		
		LandingPage landingPage =  new LandingPage(CHROME);
		String userName = landingPage.goToLoginPage().peformLogin("fipad42714@pazard.com", "Admin@1234").getUserName();
		System.out.println(userName);
		
		
	}

}

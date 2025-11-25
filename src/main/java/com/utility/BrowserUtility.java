package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}else {
			System.err.println("Invalid Browser Name.... Please select chrome, firefox, edge");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}else {
			System.err.println("Invalid Browser Name.... Please select chrome, firefox, edge");
		}
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void navigateToWebsite(String url) {
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "\\screenshots\\" + name + " - " + timeStamp +  ".png";
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}

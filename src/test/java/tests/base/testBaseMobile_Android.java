package tests.base;

import java.net.MalformedURLException;

import org.testng.annotations.*;

import helpers.automation.AndroidAutomator;
import helpers.automation.WebAutomator;
import io.appium.java_client.android.AndroidDriver;


public class testBaseMobile_Android {
	protected AndroidAutomator automator;
	protected AndroidDriver driver;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
		automator = new AndroidAutomator();
		driver = automator.driverAndroid();
	}
	
	@AfterClass
	@AfterMethod
	public void Flush() {
		
	}

	
	protected AndroidDriver getDriver(){
		return this.driver;
	}
}

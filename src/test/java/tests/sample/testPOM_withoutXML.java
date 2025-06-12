package tests.sample;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helpers.automation.WebAutomator;
import helpers.browsers.Browser;
import helpers.util.JSONHandler;
import helpers.pages.sample.AppointmentReservationPage;
import helpers.pages.sample.LoginPage;
import helpers.pages.sample.MainPageHealthcarePage;

import tests.base.testBase_withoutXML;

public class testPOM_withoutXML extends testBase_withoutXML {
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	AppointmentReservationPage reservationPage;
	String titleExpected = "CURA Healthcare Service";
	
	
	
	@Test
	public void testLogin() throws Exception {
		String testUrl = JSONHandler.getJSONContent("parameters.json","URLCura");
		this.getAutomator().goTo(testUrl);
		this.automator.maximizeWindows();
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}
	
	@Test
	public void realizarReserva() throws Exception {
		testLogin();
		reservationPage = new AppointmentReservationPage(this.getAutomator());
		//reservationPage.realizarReserva();
	}
	
	//String mainTitleActual = mainPage.getMainTitle();
	//assertEquals(mainTitleActual, titleExpected);
}

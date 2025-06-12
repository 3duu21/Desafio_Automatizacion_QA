package tests.sample;


import java.time.Duration;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helpers.automation.WebAutomator;
import helpers.browsers.Browser;
import helpers.pages.sample.AppointmentReservationPage;
import helpers.pages.sample.LoginPage;
import helpers.pages.sample.MainPageHealthcarePage;

import tests.base.testBase;

public class testPOM extends testBase {
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	AppointmentReservationPage reservationPage;
	String titleExpected = "CURA Healthcare Service";
	
	
	//Test de Login con parámetros (Correr con testng.xml o testPOMSuite.xml)
	public void testLogin(String testUrl) throws Exception {
		this.getAutomator().goTo(testUrl);
		this.getAutomator().maximizeWindows();
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}
	
	@Test
	@Parameters({"testUrl"})
	public void realizarReserva(String testUrl) throws Exception {
		testLogin(testUrl);
		reservationPage = new AppointmentReservationPage(this.getAutomator());
		//¡reservationPage.realizarReserva();
	}
	
	//String mainTitleActual = mainPage.getMainTitle();
	//assertEquals(mainTitleActual, titleExpected);
}

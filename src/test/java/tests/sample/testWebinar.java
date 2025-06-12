package tests.sample;

import helpers.exceptions.NoSuchPropertyFileException;
import helpers.pom.WorkWithLogin;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helpers.exceptions.MissingPropertyException;
import helpers.pages.MainPage;
import helpers.pages.TestingAutomatizadoPage;

import tests.base.testBase;

public class testWebinar extends testBase {
	MainPage mainPageQAlified;
	TestingAutomatizadoPage testAutPage;
	
	@Test
	public void test() throws Exception, MissingPropertyException {
		mp.loadProperties("parameters");
		this.getAutomator().goTo(mp.getProp("url_demo"));
		this.getAutomator().maximizeWindows();
		Thread.sleep(3000);
		
		mainPageQAlified = new MainPage(automator);
		mainPageQAlified.clickSaberMasTestAutomatizado();
		
		testAutPage = new TestingAutomatizadoPage(automator);
		testAutPage.clickBotonContactanos();
	}

	public static class myFirstTestClass extends testBase {



		//Logger
		private static final org.apache.logging.log4j.Logger logger= LogManager.getLogger(myFirstTestClass.class);



		@Test
		@Parameters({"host"})
		public void loginTestCase(String host){

			logger.info("Navigate to the url of QAlified {}",host);
			this.automator.goTo(host); //host + "/login"
			this.automator.maximizeWindows();

			WorkWithLogin loginTestCase = new WorkWithLogin(automator);
			loginTestCase.clickContact();
			loginTestCase.contactInformation("James Bond","My name is Bond, James Bond...");
			loginTestCase.verifyEnteredName();
			loginTestCase.verifyMessage();


		}


	}

	public static class myFirstTestClass2 extends testBase {


		//Logger
		private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger( myFirstTestClass2.class);


		@Test
		@Parameters({"testUrl"})
		public void loginTestCase(String testUrl) throws NoSuchPropertyFileException, MissingPropertyException {

			logger.info("Navigate to the url of CURA Healthcare Service{}",testUrl);
			this.automator.goTo(testUrl);
			this.automator.maximizeWindows();
			mp.loadProperties("credentials");

			WorkWithLogin LoginCURA = new WorkWithLogin(automator);
			LoginCURA.clickMakeAppointment();
			LoginCURA.loginCURA(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
			LoginCURA.clickLogin();
			LoginCURA.verifyLogin();

		}



	}

	public static class testFirstClass extends testBase{

		@Test
		public void FirstTest() {
			String TestUrl = "https://qalified.com/";
			automator.goTo(TestUrl);
			automator.back();
			automator.forward();
			automator.refresh();
			automator.closeBrowser();
		}

	}
}

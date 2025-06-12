package helpers.pages.sample;
import org.openqa.selenium.By;

import helpers.automation.WebAutomator;
import java.util.Map.Entry;


public class AppointmentConfirmationPage {
	
	WebAutomator automator;
	
	By buttonGoToHomePage = By.linkText("Go to Homepage");
	
	public AppointmentConfirmationPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void goToHomePage() {
		this.automator.find(buttonGoToHomePage).click();
	}
	
}

package helpers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import helpers.automation.WebAutomator;

public class MainPage {
	WebAutomator automator;
	
	By saberMasTestAutomatizado = By.xpath("//li/a[@href='https://qalified.com/es/testing-automatizado/']");
	
	public MainPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void moveToBtn() throws InterruptedException {
		Actions actions = new Actions(automator.getDriver());
		WebElement element = automator.getDriver().findElement(saberMasTestAutomatizado);
		
		actions.moveToElement(element).build().perform();
	}
	
	public void clickSaberMasTestAutomatizado() throws InterruptedException {
		this.moveToBtn();
		this.automator.find(saberMasTestAutomatizado).click();
	}

}

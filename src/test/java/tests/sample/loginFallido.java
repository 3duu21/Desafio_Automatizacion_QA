package tests.sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helpers.exceptions.MissingPropertyException;
import helpers.exceptions.NoSuchPropertyFileException;
import helpers.util.JSONHandler;

import tests.base.testBase_withoutXML;

public class loginFallido extends testBase_withoutXML {
  
	//Test de login hardcodeado para que falle
	@Test
  public void testLoginFallido() throws MissingPropertyException, NoSuchPropertyFileException {
	  
	  this.automator.goTo(JSONHandler.getJSONContent("parameters.json", "URLCura"));
	  this.automator.find(By.cssSelector("error")).click();
  }
}


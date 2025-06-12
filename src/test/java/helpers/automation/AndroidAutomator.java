package helpers.automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import helpers.util.JSONHandler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map.Entry;
import org.junit.Test;
import org.openqa.selenium.*;

public class AndroidAutomator {
	protected AndroidDriver androidDriver;
	
	@Test
	public AndroidDriver driverAndroid() throws MalformedURLException {
		//Parámetros JSON utilizados
		String localAddress = JSONHandler.getJSONContent("androidParameters.json","localAddress");
		String deviceName = JSONHandler.getJSONContent("androidParameters.json","deviceName");
		String fileName = JSONHandler.getJSONContent("androidParameters.json","fileName");
		
		
		//Obtención de la aplicación a utilizar
		String pathApk = new File("app/"+fileName).getAbsolutePath();
		
		//Configuración del driver	
		UiAutomator2Options options = new UiAutomator2Options()
		.setDeviceName(deviceName)
		.setApp(pathApk);
		/*
		androidDriver = new AndroidDriver(new URL(localAddress), options)
		.manage()
		.timeouts()
		.implicitlyWait(Duration.ofSeconds(5));
		*/
		return androidDriver;
		
	}
	
	public void OpenApp() {
		
	}

}

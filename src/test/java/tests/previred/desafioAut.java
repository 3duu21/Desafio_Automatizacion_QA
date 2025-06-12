package tests.previred;

import helpers.exceptions.MissingPropertyException;
import helpers.exceptions.NoSuchPropertyFileException;
import helpers.pages.previred.MainPage;
import helpers.pages.sample.MainPageHealthcarePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.base.testBase;

import java.io.IOException;

public class desafioAut extends testBase {
    MainPage mainPage;
    @Test
    @Parameters({"testUrl"})
    //Se trae el parámetro "testUrl" del archivo testng.xml
    public void FlujoPreviRedCompra(String testUrl) throws MissingPropertyException, IOException, InterruptedException, NoSuchPropertyFileException {
        this.automator.goTo(testUrl);
        this.getAutomator().maximizeWindows();

        //Homepage
        mainPage = new MainPage(this.getAutomator());
        mainPage.ingresarProducto1("iPod Classic");
        mainPage.ingresarProducto2("iMac");
        mainPage.registrar("Eduardo","Zapata", "99999999", "Calle 123", "Santiago", "123123");
        mainPage.checkout();
        mainPage.historial();
        mainPage.cerrarSesion();
    }
}

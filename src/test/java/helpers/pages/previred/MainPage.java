package helpers.pages.previred;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import helpers.automation.WebAutomator;
import helpers.util.ScreenshotAndCompare;
import org.openqa.selenium.By;
import helpers.util.CSVHandler;
import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import tests.base.testBase;

import java.io.IOException;


public class MainPage extends testBase {
    WebAutomator automator;
    ExtentTest test;

    By btnAddIpodClassic = By.xpath("//span[normalize-space()='Add to Cart']");
    By btnAddImac = By.xpath("//span[normalize-space()='Add to Cart']");
    By inputSearch = By.name("search");
    By btnSearch = By.xpath("//button[@class='btn btn-default btn-lg']");
    By btnCart = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
    By btnCheckout = By.xpath("//strong[normalize-space()='Checkout']");
    By inputEmail = By.id("input-payment-email");
    By inputPass = By.id("input-payment-password");
    By inputPassConfirm = By.id("input-payment-confirm");
    By inputNombre = By.id("input-payment-firstname");
    By inputApellido = By.id("input-payment-lastname");
    By inputTelefono = By.id("input-payment-telephone");
    By inputDir1 = By.id("input-payment-address-1");
    By inputCity = By.id("input-payment-city");
    By inputCodPostal = By.id("input-payment-postcode");
    By selectCountry = By.id("input-payment-country");
    By selectZone = By.id("input-payment-zone");
    By checkPolicy = By.name("agree");
    By btnRegistrar = By.id("button-register");
    By btnContinueRegister = By.id("button-account");
    By btnContinueDeliveryDetails = By.id("button-shipping-address");
    By btnContinueDeliveryMethod = By.id("button-shipping-method");
    By btnContinuePaymentMethod = By.id("button-payment-method");
    By btnConfirmPay = By.id("button-confirm");
    By btnCashOnDelivey = By.xpath("//label[normalize-space()='Cash On Delivery']");

    By btnMyAccount = By.xpath("//span[normalize-space()='My Account']");
    By btnHistory = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Order History')]");
    By btnLogout = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Logout')]");

    By textIpodClassic = By.xpath("//a[normalize-space()='iPod Classic']");
    By textImac = By.xpath("//a[normalize-space()='iMac']");
    By textDeliveriMethod = By.xpath("//label[normalize-space()='Flat Shipping Rate - $5.00']");
    By textStatus = By.xpath("//td[normalize-space()='Pending']");




    public MainPage(WebAutomator automator) {
        this.automator = automator;
        this.test = testBase.extent.createTest("Flujo de compra completo");
    }

    public void ingresarProducto1(String text) throws IOException {
        test.log(Status.INFO, "Buscando producto: iPod Classic");
        automator.find(inputSearch).setText(text);
        automator.find(btnSearch).click();
        automator.find(btnAddIpodClassic).click();

        ScreenshotAndCompare shotHelper = new ScreenshotAndCompare();
        shotHelper.sparkTakeScreenshotOnly("Producto Ipod Classic agregado", automator, test);
    }
    public void ingresarProducto2(String text) throws IOException {
        test.log(Status.INFO, "Buscando producto: iMac");
        automator.find(inputSearch).clear();
        automator.find(inputSearch).setText(text);
        automator.find(btnSearch).click();
        automator.find(btnAddImac).click();
        ScreenshotAndCompare shotHelper = new ScreenshotAndCompare();
        shotHelper.sparkTakeScreenshotOnly("Producto Imac agregado", automator, test);
    }

    public void registrar(String Nombre, String Apellido, String Telefono, String address1, String City, String PostCode) {
        try {
            // Leer el primer usuario desde CSV
            CSVHandler csv = new CSVHandler("src/files/users.csv");
            csv.loadDataFromCSVWithHeader();

            for (CSVRecord record : csv.getRecords()) {
                String email = record.get("email");
                String pass = record.get("password");
                String passConfirm = record.get("passwordConfirm");

                // Flujo de pago
                automator.find(btnCart).click();

                //Validacion productos
                Thread.sleep(1000);
                String textoIpodClassic = automator.find(textIpodClassic).getText();
                Assert.assertEquals(textoIpodClassic, "iPod Classic", "El nombre del producto no es el esperado.");
                test.log(Status.PASS, "Validacion correcta de Ipod Classic");

                String textoImac = automator.find(textImac).getText();
                Assert.assertEquals(textoImac, "iMac", "El nombre del producto no es el esperado.");
                test.log(Status.PASS, "Validacion correcta Imac");
                ScreenshotAndCompare shotHelper = new ScreenshotAndCompare();

                test.log(Status.INFO, "Proceso de Checkout");
                automator.find(btnCheckout).click();
                shotHelper.sparkTakeScreenshotOnly("Paso Checkout", automator, test);
                automator.find(btnContinueRegister).click();
                shotHelper.sparkTakeScreenshotOnly("Click en continuar el registro", automator, test);
                automator.find(inputNombre).setText(Nombre);
                shotHelper.sparkTakeScreenshotOnly("Nombre agregado", automator, test);
                automator.find(inputApellido).setText(Apellido);
                shotHelper.sparkTakeScreenshotOnly("Apellido agregado", automator, test);
                automator.find(inputEmail).setText(email);
                shotHelper.sparkTakeScreenshotOnly("Email agregado", automator, test);
                automator.find(inputTelefono).setText(Telefono);
                shotHelper.sparkTakeScreenshotOnly("Telefono agregado", automator, test);
                automator.find(inputPass).setText(pass);
                shotHelper.sparkTakeScreenshotOnly("Password agregado", automator, test);
                automator.find(inputPassConfirm).setText(passConfirm);
                shotHelper.sparkTakeScreenshotOnly("Pass confirm agregado", automator, test);
                automator.find(inputDir1).setText(address1);
                shotHelper.sparkTakeScreenshotOnly("Direccion agregado", automator, test);
                automator.find(inputCity).setText(City);
                shotHelper.sparkTakeScreenshotOnly("Ciudad agregado", automator, test);
                automator.find(inputCodPostal).setText(PostCode);
                shotHelper.sparkTakeScreenshotOnly("Codigo postal agregado", automator, test);
                automator.find(selectCountry).selectByVisibleText("Chile");
                shotHelper.sparkTakeScreenshotOnly("Pais agregado", automator, test);
                Thread.sleep(1000);
                automator.find(selectZone).selectByVisibleText("Region Metropolitana");
                shotHelper.sparkTakeScreenshotOnly("Region agregado", automator, test);

                // Aceptar términos y registrar
                automator.find(checkPolicy).click();
                shotHelper.sparkTakeScreenshotOnly("Click en el check de las politicas de seguridad", automator, test);
                automator.find(btnRegistrar).click();
                shotHelper.sparkTakeScreenshotOnly(" Registro completo", automator, test);

                break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkout() throws InterruptedException, IOException {
        ScreenshotAndCompare shotHelper = new ScreenshotAndCompare();

        Thread.sleep(1000);
        automator.find(btnContinueDeliveryDetails).click();
        shotHelper.sparkTakeScreenshotOnly("Delivery Details completado", automator, test);
        Thread.sleep(1000);

        //Validacion productos
        String textoDeliveriMethod = automator.find(textDeliveriMethod).getText();
        Assert.assertEquals(textoDeliveriMethod, "Flat Shipping Rate - $5.00", "El nombre del delivery no es el esperado.");
        Thread.sleep(1000);

        automator.find(btnContinueDeliveryMethod).click();
        shotHelper.sparkTakeScreenshotOnly("Delivery Method completado", automator, test);
        Thread.sleep(1000);
        automator.find(checkPolicy).click();
        Thread.sleep(1000);
        automator.find(btnCashOnDelivey).click();
        Thread.sleep(1000);
        automator.find(btnContinuePaymentMethod).click();
        shotHelper.sparkTakeScreenshotOnly("Payment Method completado", automator, test);
        Thread.sleep(1000);
        automator.find(btnConfirmPay).click();
        Thread.sleep(1000);
        shotHelper.sparkTakeScreenshotOnly("Proceso completado", automator, test);

    }

    public void historial() throws InterruptedException, IOException {
        test.log(Status.INFO, "Verificacion en historial de pedidos");
        Thread.sleep(1000);
        automator.find(btnMyAccount).click();
        automator.find(btnHistory).click();

        String textoEstado = automator.find(textStatus).getText();
        Assert.assertEquals(textoEstado, "Pending", "El estado no es Pending.");
        test.log(Status.PASS, "El pedido esta correctamenten en Pending");
        ScreenshotAndCompare shotHelper = new ScreenshotAndCompare();
        shotHelper.sparkTakeScreenshotOnly("Historial del pedido", automator, test);

        Thread.sleep(1000);
    }

    public void cerrarSesion() throws InterruptedException {
        Thread.sleep(1000);
        test.log(Status.INFO, "Cerrando sesion");
        automator.find(btnMyAccount).click();
        automator.find(btnLogout).click();

    }

}

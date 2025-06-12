package tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import helpers.automation.WebAutomator;
import helpers.browsers.Browser;
import helpers.config.SparkConfig;
import helpers.util.PropertiesHandler;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

import org.testng.asserts.SoftAssert;

public class testBase {

	protected WebAutomator automator;
	protected PropertiesHandler mp;
	protected SoftAssert softAssert = new SoftAssert();

	// Logger
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(testBase.class);

	// Reporte
	protected static ExtentReports extent;
	protected static ExtentTest test;

	@BeforeSuite
	public void initReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("sparkreports/SparkReport.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Reporte de Automatización");
		spark.config().setReportName("Evidencias QA Previred");

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("QA", "Automatización Selenium");
	}

	@BeforeMethod
	@Parameters({"browser", "isHeadless", "max_wait"})
	public void setUpDriver(@Optional("chrome") String browser, @Optional("false") Boolean isHeadless, @Optional("30") long max_wait) throws Exception {
		Browser b = Browser.valueOf(browser.toUpperCase());
		automator = new WebAutomator(b, isHeadless, true, Duration.ofSeconds(max_wait));
		mp = new PropertiesHandler();
	}

	@AfterMethod
	public void tearDownDriver() throws Exception {
		if (automator != null) {
			automator.closeAll();
		}
		if (extent != null) {
			extent.flush(); // Guarda el reporte
		}
		softAssert.assertAll();
	}

	protected WebAutomator getAutomator() {
		return this.automator;
	}

	public static ExtentTest getTestLogger(String testName) {
		test = extent.createTest(testName);
		return test;
	}
}

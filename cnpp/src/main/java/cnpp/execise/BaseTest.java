package cnpp.execise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import cnpp.Framework.Config;
import cnpp.utils.DriverUtils1;


public class BaseTest {
	public WebDriver driver;

	@AfterSuite
	public void closeService() {
		DriverUtils1.stopService();
	}

	@BeforeMethod
	public void initDriver() {
		Config config = new Config("config.properties");
		System.setProperty("cnpp.uitest.browser", config.getConfig("cnpp.uitest.browser"));
		driver = DriverUtils1.getDriver();
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}

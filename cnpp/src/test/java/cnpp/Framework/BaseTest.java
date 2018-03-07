package cnpp.Framework;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import cnpp.PageObjects.HomePageObject;
import cnpp.PageObjects.LoginPageObject;

public class BaseTest {
	public static WebDriver driver;
	HomePageObject hpo = new HomePageObject(driver);
	LoginPageObject lpo = new LoginPageObject(driver);

	@AfterSuite
	public void closeService() {
		DriverUtils.stopService();
	}

	@BeforeClass
	public void initDriver() {
		Config config = new Config("config.properties");
		System.setProperty("cnpp.uitest.browser", config.getConfig("cnpp.uitest.browser"));
		Reporter.log("--> Open CNPP");
		driver = DriverUtils.getDriver();
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}

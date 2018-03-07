package cnpp.TestCases.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import cnpp.DataProvider.TestDataFactory;
import cnpp.Framework.Config;
import cnpp.Framework.DriverUtils;

public class LuanchBrowserTest {
	public WebDriver driver;
	public void initDriver() {
		Config config = new Config("config.properties");
		System.setProperty("cnpp.uitest.browser", config.getConfig("browserName"));
		driver = DriverUtils.getDriver();
	}
	@Test(dataProviderClass = TestDataFactory.class, dataProvider = "loginTestData")
	public void testLogin_success() {
		driver.get("https://frontcnpp.cube-net.pub/en/");
	}
}


//public class LuanchBrowserTest {
//	public static void main(String[] arg) throws InterruptedException {
//		WebDriver driver = DriverUtils.getDriver();
//	}
//}
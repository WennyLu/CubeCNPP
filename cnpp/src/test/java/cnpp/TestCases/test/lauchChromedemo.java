package cnpp.TestCases.test;

import org.openqa.selenium.WebDriver;

import cnpp.Framework.Config;
import cnpp.Framework.DriverUtils;



//public class lauchChromedemo {
//	public static void main(String[] arg) throws InterruptedException {
//		WebDriver driver = DriverUtils1.getDriver();
//		driver.get("https://frontcnpp.cube-net.pub/en/");
//		Thread.sleep(2000);
//	}
//}

public class lauchChromedemo {
	public static WebDriver driver;
		public static void main(String[] args) {
			Config config = new Config("config.properties");
			System.setProperty("cnpp.uitest.browser", config.getConfig("cnpp.uitest.browser"));
			driver = DriverUtils.getDriver();
//			System.setProperty("cnpp.uitest.browser", "firefox");
//			WebDriver driver = DriverUtils1.getDriver();
//			driver.get("https://frontcnpp.cube-net.pub/en/");

	}
}


package cnpp.Framework;


import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtils {

	private static DriverService service;
	private static final Logger logger = LogManager.getLogger();
	private static String browser;

	static {
		browser = System.getProperty("cnpp.uitest.browser", "firefox"); 
		logger.info("Get system properties: cnpp.uitest.browser = "+browser);

		if("firefox".equalsIgnoreCase(browser)) {
			service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"))) 
				.usingAnyFreePort()
				.usingDriverExecutable(new File("C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe")) 
				.build(); 
		}else if("chrome".equalsIgnoreCase(browser)) {
			service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("E:\\tools\\seleniumForStudents\\chromedriver.exe"))
					.usingAnyFreePort() 
					.build();
		}else if("ie".equalsIgnoreCase(browser)){
			// not yet implemenent
			service = null;
		}else {
			logger.error("Unsupported browser type, pls check system properties:cnpp.uitest.browser");
			throw new RuntimeException("Unsupported browser type, pls check system properties:cnpp.uitest.browser");
		}
		try {
			service.start(); 
			logger.info("Driver started");
		} catch (IOException e) {
			logger.error("Service start failed, reason is: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		
		WebDriver driver = null;
		DesiredCapabilities caps = null;

		if("firefox".equalsIgnoreCase(browser)) {
			caps = DesiredCapabilities.firefox();
		}else if("chrome".equalsIgnoreCase(browser)) {
			// not yet implemenent
			caps = null;
		}else if("ie".equalsIgnoreCase(browser)){
			// not yet implemenent
			caps = null;
		}else {
			logger.error("Unsupported browser type, pls check system properties:cnpp.uitest.browser");
			throw new RuntimeException("Unsupported browser type, pls check system properties:cnpp.uitest.browsers");
		}
		driver = new WrappedRemoteWebDriver(service.getUrl(), caps);
		return driver;
	}

	public static void stopService() {
		logger.info("Driver service stopped");
		service.stop();
	}
}

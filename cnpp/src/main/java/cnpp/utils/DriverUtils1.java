package cnpp.utils;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtils1 {

	private static DriverService service;

	private static String browser;

	static {
		browser = System.getProperty("cnpp.uitest.browser", "firefox"); 

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
			throw new RuntimeException("未支持的浏览器类型，请检查系统属性cnpp.uitest.browser");
		}
		try {
			service.start(); 
		} catch (IOException e) {
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
			throw new RuntimeException("未支持的浏览器类型，请检查系统属性cnpp.uitest.browser");
		}
		driver = new RemoteWebDriver(service.getUrl(), caps);
		return driver;
	}

	public static void stopService() {
		service.stop();
	}
}

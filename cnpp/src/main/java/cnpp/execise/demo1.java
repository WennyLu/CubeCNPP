package cnpp.execise;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class demo1 {
	public static void main(String[] args) {
		GeckoDriverService service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(
						new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe")).build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.firefox());
		// FirefoxOptions firefoxOptions = new FirefoxOptions();
		// firefoxOptions.setProfile(new FirefoxProfile(new File("C:\\TEMP")));
		// WebDriver driver = new FirefoxDriver(service,firefoxOptions);
		driver.get("https://frontcnpp.cube-net.pub/en/");
		driver.close();
		service.stop();

	}
}
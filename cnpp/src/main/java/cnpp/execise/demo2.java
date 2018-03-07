package cnpp.execise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demo2 {
public static void main(String[] args){
	System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://frontcnpp.cube-net.pub/en/");
}
}

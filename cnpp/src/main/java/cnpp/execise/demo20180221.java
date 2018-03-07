package cnpp.execise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demo20180221 {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("Open Chrome");}
	@Test
	public void OpenCube() throws Exception {
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Reporter.log("Open CNPP");
		String[] resultArray = {driver.getTitle()};
		System.out.println("CNPP title is:" + driver.getTitle());
		String[] expectArray = {"Decathlon"};
		assertArrayEquals(expectArray, resultArray);
		
				Thread.sleep(2000);
	}
	private void assertArrayEquals(String[] expectArray, String[] resultArray) {
	}


}

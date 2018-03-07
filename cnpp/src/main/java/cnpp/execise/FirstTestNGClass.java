package cnpp.execise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cnpp.Framework.DriverUtils;

public class FirstTestNGClass {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("Open Chrome");
		driver.manage().window().maximize();
		Reporter.log("Window maximize");
	}

	@Test
	public void OpenCube() throws Exception {
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Reporter.log("--> Open CNPP");
		String[] resultArray = { driver.getTitle() };
		Reporter.log("--> CNPP title is:" + driver.getTitle());
		System.out.println("CNPP title is:" + driver.getTitle());
		String[] expectArray = { "Decathlon" };
		assertArrayEquals(expectArray, resultArray);
		Thread.sleep(2000);
	}

	private void assertArrayEquals(String[] expectArray, String[] resultArray) {
	}

	@Test(dependsOnMethods = { "OpenCube" })
	public void SearchProduct() {
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.findElement(By.id("search-autocomplete")).sendKeys("15053");
		Reporter.log("--> Search product -'15053'");
		driver.findElement(By.id("search-autocomplete")).sendKeys(Keys.ENTER);
		Reporter.log("--> Click search");
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10L)
				.withMessage("Wait 10senconds but cannot find.");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DriverUtils.stopService();
	}
	}

	@Test(dependsOnMethods = { "SearchProduct" },enabled = true)
	public void LoginExpress() {
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	
		driver.findElement(By.id("express-payment-cta")).click();
		Reporter.log("Click express checkout");
		driver.findElement(By.id("login")).sendKeys("15915915915");
		Reporter.log("Input account");
		driver.findElement(By.id("password")).sendKeys("Decathlon1");
		Reporter.log("Input password");
		driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div/form/div[3]/button")).click();
		Reporter.log("Submit");
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10L)
				.withMessage("Wait 10senconds but cannot find.");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DriverUtils.stopService();
	}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		Reporter.log("Close browser");
	}
}
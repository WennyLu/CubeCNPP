package cnpp.TestCases.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import cnpp.Framework.BaseTest;
import cnpp.Framework.DriverUtils;

public class FirstTestNGClass extends BaseTest{

	@Test
	public void OpenCube() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Reporter.log("--> Open CNPP");
		String[] resultArray = { driver.getTitle() };
		Reporter.log("--> CNPP title is:" + driver.getTitle());
		System.out.println("CNPP title is:" + driver.getTitle());
		String[] expectArray = { "Decathlon" };
		assertArrayEquals(expectArray, resultArray);
		Thread.sleep(2000);
	

		driver.findElement(By.id("search-autocomplete")).sendKeys("15053");
		Reporter.log("--> Search product -'15053'");
		Thread.sleep(5000);
		driver.findElement(By.id("search-autocomplete")).sendKeys(Keys.ENTER);
		Reporter.log("--> Click search");
		Thread.sleep(5000);
	
	

		driver.findElement(By.cssSelector("button[id=express-payment-cta]")).click();
		Reporter.log("Click express checkout");
		driver.findElement(By.id("login")).sendKeys("15915915915");
		Reporter.log("Input account");
		driver.findElement(By.id("password")).sendKeys("Decathlon1");
		Reporter.log("Input password");
		driver.findElement(By.id("signin-block")).click();
		Reporter.log("Submit");
		Thread.sleep(5000);
		
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

	private void assertArrayEquals(String[] expectArray, String[] resultArray) {
	}
}
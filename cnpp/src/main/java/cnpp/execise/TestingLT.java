package cnpp.execise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cnpp.utils.DriverUtils1;

public class TestingLT {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils1.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/");
			driver.findElement(By.linkText("[软件测试新手上路]")).click();
			List<WebElement> threads = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			System.out.println(threads.size());
			threads.get(0).findElement(By.xpath("tr/th/a[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("[软件测试新手上路]")).click();
			threads = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			threads.get(1).findElement(By.xpath("tr/th/a[3]")).click();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		} finally {
			DriverUtils1.stopService();
			
		}
	}
}

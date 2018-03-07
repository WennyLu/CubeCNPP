package cnpp.execise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cnpp.Framework.DriverUtils;
import cnpp.utils.DriverUtils1;

public class TestingTLDemo2 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils1.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/");
			TestingLTPageIndex indexPage = new TestingLTPageIndex(driver);
			indexPage.forum_1_link.click();
			TestingLTPageForum1 forum1Page = new TestingLTPageForum1(driver);
			forum1Page.clickTopic(1);
			Thread.sleep(2000);
			driver.findElement(By.linkText("[软件测试新手上路]")).click();
			forum1Page.clickTopic(2);
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
}

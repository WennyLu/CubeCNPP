package cnpp.PageObjects;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	private WebDriver driver;
	// login_input
	@FindBy(name = "login")
	private WebElement login_input;

	// validate_button
	@FindBy(id = "validate-block")
	private WebElement validate_button;

	
	// password_click
	@FindBy(css = "div[id=password-block]")
	private WebElement password_click;
	
	// password_input
	@FindBy(css = "input[id=password]")
	private WebElement password_input;

	// signin_button
	@FindBy(id = "signin-block")
	private WebElement signin_button;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click_login_input(String phonenum) throws Throwable {
		System.out.println("Now I'm doing --> Input account number");
		login_input.click();
		login_input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		login_input.sendKeys(Keys.DELETE);
		login_input.sendKeys(phonenum);
		Thread.sleep(2000);
	}

	public void click_validate_button() throws InterruptedException {
		System.out.println("Now I'm doing --> Click validate button");
		validate_button.click();
		Thread.sleep(3000);
	}

	public void click_password_input(String password) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			Thread.sleep(10000);
//			password_input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//			password_input.sendKeys(Keys.DELETE);
			password_input.sendKeys(password);
			Thread.sleep(2000);

	}

	public void click_signin_button() throws Throwable {
		System.out.println("Now I'm doing --> Click singin button");
		signin_button.click();
		Thread.sleep(9000);
	}

	public void assert_alert_text(String expectedText) throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		assertEquals(actualText, expectedText);
		Thread.sleep(2000);
	}
}

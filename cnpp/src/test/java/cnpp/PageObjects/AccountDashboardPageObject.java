package cnpp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDashboardPageObject {

	// logout_button
	@FindBy(id = "logout-button")
	private WebElement logout_button;

	// confirmlogout_button
	@FindBy(id = "logout-confirmation-button")
	private WebElement confirmlogout_button;

	public void click_logout_button() throws Throwable {
		Thread.sleep(5000);
		System.out.println("Now I'm doing --> Logout from account dashboard");
		logout_button.click();
		Thread.sleep(2000);
		System.out.println("Now I'm doing --> Confirm logout");
		confirmlogout_button.click();
		Thread.sleep(5000);
	}

	public AccountDashboardPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

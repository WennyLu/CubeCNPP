package cnpp.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	// my account_link
	@FindBy(xpath = ".//*[@id='dropdown-account']/span[1]")
	private WebElement myaccount_link;

	// logined_text
	@FindBy(xpath = "//*[@id='hdr-customers-identity']")
	private WebElement logined_text;
	
	// search_input
	@FindBy(id = "search-autocomplete")
	private WebElement search_input;
	
	// logout_button
	@FindBy(className ="panel logout accordion-toggle")
	private WebElement logout_button;
	
	// language_button
	@FindBy(id = "dropdown-lang")
	private WebElement language_button;
	
	// languageCN_option
	@FindBy(css = ".drop-lang-list > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)")
	private WebElement languageCN_button;
	
	// languageEN_option
	@FindBy(css = ".drop-lang-list > li:nth-child(2) > a:nth-child(1) > span:nth-child(1)")
	private WebElement languageEN_button;
	
	public void select_languageCN() throws Throwable{
		System.out.println("Now I'm doing --> Select language CN");
		language_button.click();
		Thread.sleep(5000);
		languageCN_button.click();
		Thread.sleep(5000);
	}
	
	public void select_languageEN() throws Throwable{
		System.out.println("Now I'm doing --> Select language EN");
		language_button.click();
		Thread.sleep(5000);
		languageEN_button.click();
		Thread.sleep(5000);
	}
	
	public void click_logou_button() throws Throwable{
		System.out.println("Now I'm doing --> Logout from homepage");
		logout_button.click();
		Thread.sleep(5000);
	}
	
	public void input_search_input(String Product) throws Throwable{
		System.out.println("Now I'm doing --> Search " + Product);
		search_input.sendKeys(Product);
		search_input.sendKeys(Keys.ENTER);
		Thread.sleep(9000);
	}

	public HomePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void click_myaccount_link() throws Throwable {
		System.out.println("Now I'm doing --> Click MY ACCOUNT");
		myaccount_link.click();
		Thread.sleep(5000);
	}

	public void assert_logined_link(String expectedText) throws Throwable {
		String actualText = logined_text.getText();
		// assertEquals(actualText, expectedLoginedText);
		assert actualText == expectedText;
		System.out.println("Pass");
		Thread.sleep(2000);
	}

	// private void assertEquals(String actualText, String expectedLoginedText)
	// {s
	// // TODO Auto-generated method stub
	// }
}

package cnpp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPageObject {
	
	// genderFemale_option
	@FindBy(css = "div.row:nth-child(9) > div:nth-child(1) > div:nth-child(3) > label:nth-child(1) > span:nth-child(2)")
	private WebElement genderFemale_option;
	
	// lastname_input
	@FindBy(xpath ="//*[@id='lastname']")
	private WebElement lastname_input;
	
	// firstname_input
	@FindBy(xpath ="//*[@id='firstname']")
	private WebElement firstname_input;
	
	// password_input
	@FindBy(xpath = "//*[@id='password']")
	private WebElement password_input;
	
	// receivenews_option
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/form/div[1]/div[3]/div/div/div[2]/label/span")
	private WebElement receivenews_option;
	
	// createaccount_button
	@FindBy(css = "button[id=create-button]")
	private WebElement createaccount_button;
	
	public void click_createaccount_button() throws Throwable{
		System.out.println("Now I'm doing --> Click create account button");
		createaccount_button.click();
		Thread.sleep(2000);
	}
	
	public void select_receivenews_option() throws Throwable{
		System.out.println("Now I'm doing --> Select don't reveive news");
		receivenews_option.click();
		Thread.sleep(2000);
	}
	
	public void input_password_input() throws Throwable{
		System.out.println("Now I'm doing --> Input password");
		password_input.sendKeys("Decathlon1");
		Thread.sleep(2000);
	}
	
	public void input_firstname_input() throws Throwable{
		System.out.println("Now I'm doing --> Input first name");
		firstname_input.sendKeys("TTT");
		Thread.sleep(2000);
	}
	
	public void input_lastname_input() throws Throwable{
		System.out.println("Now I'm doing --> Input last name");
		lastname_input.sendKeys("testing");
		Thread.sleep(2000);
	}
	
	public void select_genderFemale_option() throws Throwable {
		Thread.sleep(8000);
		System.out.println("Now I'm doing --> Select Gender option : Female");
		genderFemale_option.click();
		Thread.sleep(2000);
	}
	
	public CreateAccountPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

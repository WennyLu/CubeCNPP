package cnpp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentListPageObject {

	// unionpay_option
	@FindBy(xpath = "/html/body/div[2]/div/section/div/section/div/section[5]")
	private WebElement unionpay_option;
	
	// pay_button
	@FindBy(css = "button.dkt-checkout-primary-button:nth-child(4)")
	private WebElement pay_button;
	
	public void click_pay_button(){
		pay_button.click();
	}
	
	public void select_unionpay_option() throws Throwable{
		System.out.println("Now I'm doing --> Select unionpay");
		unionpay_option.click();
		Thread.sleep(2000);
	}
	
	
	public PaymentListPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

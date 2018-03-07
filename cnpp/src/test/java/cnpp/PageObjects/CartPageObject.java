package cnpp.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageObject {
	
	// proceedtoorder_button
	@FindBy(css = "button.dkt-checkout-primary-button:nth-child(2)")
	private WebElement proceedtoorder_button;
	
	// productqty_input
	@FindBy(className = "quantity-input")
	private WebElement productqty_input;
	
	public void input_productqty_input(String qtynum) throws Throwable{
		System.out.println("Now I'm doing --> Input product qty");
//		productqty_input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		productqty_input.sendKeys(Keys.BACK_SPACE);
		productqty_input.sendKeys(Keys.BACK_SPACE);
		productqty_input.sendKeys(Keys.BACK_SPACE);
		productqty_input.sendKeys(qtynum);
		Thread.sleep(2000);
	}
	

	public void click_proceedtoorder_button() throws Throwable{
		System.out.println("Now I'm doing --> Click proceed to order");
		proceedtoorder_button.click();
		Thread.sleep(15000);
	}
	

	public CartPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

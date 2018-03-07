package cnpp.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPageObject {
	
	// pickupinstore_dropdownbox
	@FindBy(css = "fieldset[id=cartridgeDivIdPick]")
	private WebElement pickupinstore_dropdownbox;
	
	// firststore_option
	@FindBy(xpath = "/html/body/div[1]/div/section/div/section/form/fieldset[2]/div/div/div/div[2]/div[1]/div/label/span")
	private WebElement firststore_option;
	
	// name_input
	@FindBy(id = "recipient-0070088800888")
	private WebElement name_input;
	
	// phonenum_input
	@FindBy(id = "mobilephone-0070088800888")
	private WebElement phonenum_input;
	
	// gotopayment_button
	@FindBy(css = "button.dkt-checkout-primary-button:nth-child(4)")
	private WebElement gotopayment_button;
	
	// homedelivery_dropdownbox
	@FindBy(css = "fieldset[id=panel-home-delivery]")
	private WebElement homedelivery_dropdownbox;
	
	// shunfeng_option
	@FindBy(css = ".container-heading-info > span:nth-child(2)")
	private WebElement shunfeng_option;
	
	public void select_shunfeng_option() throws Throwable{
		System.out.println("Now I'm doing --> Select shunfeng express");
		shunfeng_option.click();
		Thread.sleep(2000);
	}
	
	public void select_homedelivery_dropdownbox() throws Throwable{
		System.out.println("Now I'm doing --> Select home delivery");
		homedelivery_dropdownbox.click();
		Thread.sleep(2000);
	}
	
	public void click_gotopayment_button() throws Throwable{
		System.out.println("Now I'm doing --> Click go to payment");
		gotopayment_button.click();
		Thread.sleep(5000);
	}
	
	public void select_firststore_option() throws Throwable{
		System.out.println("Now I'm doing --> Select first store");
		firststore_option.click();
		name_input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		name_input.sendKeys(Keys.DELETE);
		name_input.sendKeys("wenyi");
		phonenum_input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		phonenum_input.sendKeys(Keys.DELETE);
		phonenum_input.sendKeys("15915915915");	
		Thread.sleep(2000);
		
	}
	
	public void select_pickupinstore_option() throws Throwable{
		System.out.println("Now I'm doing --> Select pick up in store");
		pickupinstore_dropdownbox.click();
		Thread.sleep(2000);
	}
	
	
	
	
	public ShippingPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

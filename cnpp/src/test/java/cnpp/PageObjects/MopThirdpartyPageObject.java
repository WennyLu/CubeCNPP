package cnpp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MopThirdpartyPageObject {

	// unionpay
	@FindBy(className = "b700000000000163 mbc")
	private WebElement unionpay_jianshebank_option;
	
	public void select_unionpay_jianshebank_option(){
		unionpay_jianshebank_option.click();
	}
	
	
	public MopThirdpartyPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

package cnpp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPageObject {

	// productnum1_select
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/article[1]/div[2]/div/div[1]/div/a/picture/img")
	private WebElement productnum1_select;
	
	public void productnum1_select() throws Throwable{
		System.out.println("Now I'm doing --> Select a product");
		productnum1_select.click();
		Thread.sleep(5000);
	}
	
	
	public ProductListPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

package cnpp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageObject_TShirt {
	
//	private WebDriver dr;
	// size_button
//	@FindBy(id = "js-sizes-layout")
	@FindBy(css = "div[id=js-sizes-layout]")
	private WebElement size_button;

	// EU38_option
	@FindBy(xpath = "/html/body/div[4]/div[3]/div[3]/div[5]/div[1]/ul/li[3]")
	private WebElement EU38_option;

	// addtocart_button
	@FindBy(id = "ctaButton")
	private WebElement addtocart_button;

	// mycart_button
	@FindBy(id = "header-my-cart")
	private WebElement mycart_button;
	
	// writeareview_button
	@FindBy(className = "button-action")
	private WebElement writeareview_button;
	
	public void click_writeareview_button() throws Throwable{
		System.out.println("Now I'm doing --> Click write a review");
		writeareview_button.click();
		Thread.sleep(5000);
	}

	public void click_mycart_button() throws Throwable {
		System.out.println("Now I'm doing --> Click my cart");
		mycart_button.click();
		Thread.sleep(5000);
	}

	public void click_addtocart_button() throws Throwable {
		System.out.println("Now I'm doing --> Click add to cart");
		addtocart_button.click();
		Thread.sleep(5000);
	}

	public void select_size_button() throws Throwable {
		
//		Select select = new Select(size_button);
//				for(WebElement e: select.getOptions())
//					e.click();
//				select.selectByIndex(1);
		size_button.click();;
		Thread.sleep(3000);
//		EU38_option.click();
	}
	
//	public void mouseMove() throws Exception {
//
//        Actions act = new Actions(dr);
//        WebElement dropDown = dr.findElement(By.cssSelector("div[id=js-sizes-layout]"));
//        WebElement user = dr.findElement(By.xpath("/html/body/div[4]/div[3]/div[3]/div[5]/div[1]/ul/li[3]]"));
//        act.click(dropDown).perform();
//        act.moveToElement(user).click().perform();
//        act.moveByOffset(20, 30).click().perform();
//    }

	public ProductPageObject_TShirt(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}

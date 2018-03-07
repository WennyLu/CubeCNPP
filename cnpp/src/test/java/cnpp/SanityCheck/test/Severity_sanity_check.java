package cnpp.SanityCheck.test;

import org.testng.Reporter;
import org.testng.annotations.Test;


import cnpp.Framework.BaseTest;
import cnpp.Framework.Config;
import cnpp.Framework.DriverUtils;
import cnpp.PageObjects.AccountDashboardPageObject;
import cnpp.PageObjects.CartPageObject;
import cnpp.PageObjects.CreateAccountPageObject;
import cnpp.PageObjects.HomePageObject;
import cnpp.PageObjects.LoginPageObject;
import cnpp.PageObjects.PaymentListPageObject;
import cnpp.PageObjects.ProductListPageObject;
import cnpp.PageObjects.ProductPageObject_TShirt;
import cnpp.PageObjects.ShippingPageObject;

public class Severity_sanity_check extends BaseTest {

	@Test(groups = { "Test_login" })
	public void Test_login() throws Throwable {
		System.out.println("[CASE] *** Login from homepage ***");

		LoginPageObject lpo = new LoginPageObject(driver);
		HomePageObject hpo = new HomePageObject(driver);

		System.out.println("--> Open CNPP url");
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Thread.sleep(5000);
		hpo.click_myaccount_link();
		lpo.click_login_input((String) "15915915915");
		// lpo.click_validate_button();
		lpo.click_password_input((String) "Decathlon1");
		lpo.click_signin_button();
	}

	@Test(groups = { "Test_addProductToCart" }, dependsOnGroups = { "Test_login" })
	// Feature: Buy [China]
	// Scenario Functionality 14 : Pay with E-Bank
	public void Test_addProductToCart() throws Throwable {
		System.out.println("[CASE] *** Search a product add to cart ***");

		HomePageObject hpo = new HomePageObject(driver);
		ProductPageObject_TShirt ppot = new ProductPageObject_TShirt(driver);
		CartPageObject cpo = new CartPageObject(driver);

		// try {
		// driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		hpo.input_search_input((String) "15053");
		ppot.click_addtocart_button();
		ppot.click_mycart_button();
		cpo.input_productqty_input((String) "1");
		cpo.click_proceedtoorder_button();

		// WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 20L)
		// .withMessage("Wait 10senconds but cannot find.");
		// Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// System.out.println(alert.getText());
		// alert.accept();
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// DriverUtils.stopService();
		// }
	}

	@Test(groups = { "Test_homedelivery" }, dependsOnGroups = { "Test_addProductToCart" })
	public void Test_homedelivery() throws Throwable {
		System.out.println("[CASE] *** Home delivery ***");

		ShippingPageObject spo = new ShippingPageObject(driver);
		PaymentListPageObject plpo = new PaymentListPageObject(driver);

		Thread.sleep(2000);
		spo.select_homedelivery_dropdownbox();
		spo.select_shunfeng_option();
		spo.click_gotopayment_button();

		plpo.select_unionpay_option();
		plpo.click_pay_button();
	}

	@Test(groups = { "Test_pickUpInStore" })
	public void Test_pickUpInStore() throws Throwable {
		System.out.println("[CASE] *** Pick up in store ***");
		ShippingPageObject spo = new ShippingPageObject(driver);

		Thread.sleep(8000);
		spo.select_pickupinstore_option();
		spo.select_firststore_option();

	}

	@Test(dependsOnGroups = { "Test_pickUpInStore" })
	public void Test_unionpay() throws Throwable {
		System.out.println("[CASE] *** Pay by unionpay ***");
		ShippingPageObject spo = new ShippingPageObject(driver);
		PaymentListPageObject plpo = new PaymentListPageObject(driver);

		spo.click_gotopayment_button();
		plpo.select_unionpay_option();
		plpo.click_pay_button();

		System.out.println("Now I'm doing --> Check result");
		String[] resultArray = { driver.getTitle() };
		Reporter.log("--> Third party directing page's title is:" + driver.getTitle());
		System.out.println("Third party directing page's title is:" + driver.getTitle());
		String[] expectArray = { "支付" };
		assertArrayEquals(expectArray, resultArray);
		Thread.sleep(2000);

	}

	private void assertArrayEquals(String[] expectArray, String[] resultArray) {
	}

	@Test
	// Feature: CIS - CUST [China]
	// Scenario Functionality 230: [CN] - Create an account with no loyalty card
	// - Email Only
	public void Test_createAccount() throws Throwable {
		System.out.println("[CASE] *** Create an account ***");
		// Given A non-registered user with unique mobile and email
		LoginPageObject lpo = new LoginPageObject(driver);
		HomePageObject hpo = new HomePageObject(driver);
		CreateAccountPageObject capo = new CreateAccountPageObject(driver);

		System.out.println("--> Open CNPP url");
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Thread.sleep(5000);
		hpo.click_myaccount_link();
		lpo.click_login_input((String) "12018030116");
		lpo.click_validate_button();
		capo.select_genderFemale_option();
		capo.input_lastname_input();
		capo.input_firstname_input();
		capo.input_password_input();
		// capo.select_receivenews_option();
		capo.click_createaccount_button();

		// lpo.click_validate_button();
		// When User goes to the login page and types his email
		// When On the create account page, user clicks on Male
		// And On the create account page, user types his/her last name
		// And On the create account page, user types his/her first name
		// And On the create account page, user types password "Password123"
		// And On the create account page, user clicks NO for I would like to
		// receive news...
		// And On the create account page, user validates
		// And System redirects to the home page

	}

	@Test(dependsOnGroups = { "Test_login" })
	// Feature: CIS - CUST [Core]
	// Scenario Functionality 785: [CORE] - Log in, restart browser to be logged
	// out, and log in again
	public void Test_loginRestartBrowserAndLoginAgain() throws Throwable {
		System.out.println("[CASE] *** Log in, restart browser to be logged ***");
		AccountDashboardPageObject adpo = new AccountDashboardPageObject(driver);
		HomePageObject hpo = new HomePageObject(driver);
		LoginPageObject lpo = new LoginPageObject(driver);

		hpo.click_myaccount_link();
		adpo.click_logout_button();
		driver.quit();
		Config config = new Config("config.properties");
		System.setProperty("cnpp.uitest.browser", config.getConfig("cnpp.uitest.browser"));
		driver = DriverUtils.getDriver();
		System.out.println("--> Open CNPP url");
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Thread.sleep(5000);
		hpo.click_myaccount_link();
		lpo.click_login_input((String) "15915915915");
		// lpo.click_validate_button();
		lpo.click_password_input((String) "Decathlon1");
		lpo.click_signin_button();

	}

	@Test
	// Feature: CIS - CUST [Core]
	// Scenario Test Case 157: [CORE] - Logout
	public void Test_logout() throws Throwable {
		System.out.println("[CASE] *** Logout ***");
		AccountDashboardPageObject adpo = new AccountDashboardPageObject(driver);
		HomePageObject hpo = new HomePageObject(driver);
		hpo.click_myaccount_link();
		adpo.click_logout_button();
	}

	@Test
	// Feature: Cross [Core]
	// Scenario Search Hints & Popup Results
	public void Test_searchHintsPopupResults() throws Throwable {
		System.out.println("[CASE] *** Search Hints & Popup Results ***");

		HomePageObject hpo = new HomePageObject(driver);
		ProductListPageObject plpo = new ProductListPageObject(driver);

		System.out.println("--> Open CNPP url");
		driver.get("https://frontcnpp.cube-net.pub/en/");
		hpo.input_search_input((String) "nrt");
		plpo.productnum1_select();

	}

	@Test
	// Feature: Get [Core]
	// Scenario Functionality 438 :Test Case 737: CHKO-01-S4_If the user is not
	// logged in / it connects
	public void Test_notLoginItConnects() throws Throwable {
		System.out.println("[CASE] *** Add product to cart without login ***");

		HomePageObject hpo = new HomePageObject(driver);
		ProductPageObject_TShirt ppot = new ProductPageObject_TShirt(driver);
		CartPageObject cpo = new CartPageObject(driver);
		LoginPageObject lpo = new LoginPageObject(driver);

		// try {
		// driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.get("https://frontcnpp.cube-net.pub/en/");
		Thread.sleep(5000);
		hpo.input_search_input((String) "15053");
		ppot.click_addtocart_button();
		ppot.click_mycart_button();
		cpo.input_productqty_input((String) "1");
		cpo.click_proceedtoorder_button();
		lpo.click_login_input((String) "15915915915");
		// lpo.click_validate_button();
		lpo.click_password_input((String) "Decathlon1");
		lpo.click_signin_button();

	}

	@Test
	// Feature: Search & Choose [China]
	// Scenario Functionality 836: User can change page language
	public void Test_changePageLanguage() throws Throwable {
		System.out.println("[CASE] *** User can change page language ***");
		HomePageObject hpo = new HomePageObject(driver);

		driver.get("https://frontcnpp.cube-net.pub/zh/");
		Thread.sleep(5000);
		hpo.select_languageEN();
	}

	@Test
	// Feature: Search & Choose - Services & Reviews [Core]
	// Scenario Functionality 638,680,681,837: Test Case 1040 : [CORE] - post a
	// review link
	public void Test_postAReviewLlik() throws Throwable {
		System.out.println("[CASE] *** Post a review link ***");

		HomePageObject hpo = new HomePageObject(driver);
		ProductPageObject_TShirt ppot = new ProductPageObject_TShirt(driver);

		hpo.input_search_input((String) "15053");
		ppot.click_writeareview_button();
	}

}

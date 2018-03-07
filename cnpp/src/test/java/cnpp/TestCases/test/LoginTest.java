package cnpp.TestCases.test;

import org.testng.annotations.Test;

//import cnpp.DataProvider.TestDataFactory;
import cnpp.Framework.BaseTest;
import cnpp.PageObjects.HomePageObject;
import cnpp.PageObjects.LoginPageObject;

public class LoginTest extends BaseTest {

//	@Test(dataProviderClass = TestDataFactory.class, dataProvider = "LoginTestData")
	@Test(enabled = true)
	public void testLogin_success() throws Throwable {
		System.out.println("[CASE] *** testLogin_success ***");
		// 1. Open homepage
		System.out.println("--> Open CNPP url");
		driver.get("https://frontcnpp.cube-net.pub/en/");
		// 2. Click MY ACCOUNT
		System.out.println("Now I'm doing --> Click MY ACCOUNT");
		HomePageObject hpo = new HomePageObject(driver);
		hpo.click_myaccount_link();
		// 3. Fill out phone num
		System.out.println("Now I'm doing --> Input account number");
		LoginPageObject lpo = new LoginPageObject(driver);
		lpo.click_login_input((String)"15915915915");
		// 4. Click VALIDATE
//		System.out.println("Now I'm doing --> Click validate button");
//		lpo.click_validate_button();
		// 5. Fill out password
		System.out.println("Now I'm doing --> Input password");
		lpo.click_password_input((String)"Decathlon1");
		// 6. Click SINGIN
		System.out.println("Now I'm doing --> Click singin button");
		lpo.click_signin_button();
		// 7. Assert login succ
//		hpo.assert_logined_link(expectedLoginedText);
		
//		if(phonenum.equals("")||password.equals("")){
//			lpo.assert_alert_text(expectedLoginedText);
//		}else{
//		lpo.assert_login_result_text(expectedLoginedText);
//		}
	}
	
}

package cnpp.DataProvider;


import org.testng.annotations.DataProvider;

import cnpp.Framework.ReadExcel;

public class TestDataFactory {
	@DataProvider(name = "LoginTestData")
	public static Object[][] getLoginTestData() {
		return ReadExcel.getDataFromExcel("test-data.xlsx", "LoginData");
	}

}

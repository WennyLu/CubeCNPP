package cnpp.TestCases.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDemo1 {

	@BeforeSuite
	public void beforeSuite1() {
		System.out.println("- 【Before Suite】 -");
	}

	@AfterSuite
	public void afterSuite1() {
		System.out.println("- 【After Suite】 -");
	}

	@BeforeTest
	public void beforeTest1() {
		System.out.println("--- ++Before Test1++ ---");
	}

	@AfterTest
	public void afterTest1() {
		System.out.println("--- ++After Test1++ ---");
	}

	@BeforeClass
	public void beforeClass1() {
		System.out.println("----- [Before Class TestDome1] -----");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("----- [After Class TestDome1] -----");
	}
	
	@BeforeMethod
	public void beforeMethod1(){
		System.out.println("------- ==Before Method TestDemo1== -------");
	}
	
	@AfterMethod
	public void aeforeMethod1(){
		System.out.println("------- ==After Method TestDemo1== -------");
	}
	
	@Test
	public void case1(){
		System.out.println("--------- Method Case AA ---------");
	}

}

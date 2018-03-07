package cnpp.TestCases.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDemo3 {
	@BeforeTest
	public void beforeTest1() {
		System.out.println("--- Before Test3 ---");
	}

	@AfterTest
	public void afterTest1() {
		System.out.println("--- After Test3 ---");
	}

	@BeforeClass
	public void beforeClass1() {
		System.out.println("----- Before Class TestDome3 -----");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("----- After Class TestDome3 -----");
	}
	
	@BeforeMethod
	public void beforeMethod1(){
		System.out.println("------- Before Method TestDemo3 -------");
	}
	
	@AfterMethod
	public void aeforeMethod1(){
		System.out.println("------- After Method TestDemo3 -------");
	}
	
	@Test
	public void case3(){
		System.out.println("--------- Method Case CC ---------");
	}

	@Test
	public void case4(){
		System.out.println("--------- Method Case DD ---------");
	}
}

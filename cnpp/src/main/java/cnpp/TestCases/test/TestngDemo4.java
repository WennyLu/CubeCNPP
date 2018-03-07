package cnpp.TestCases.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngDemo4 {
	@BeforeClass
	public void beforeClass1() {
		System.out.println("----- Before Class TestDome4 -----");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("----- After Class TestDome4 -----");
	}
	
	@BeforeMethod
	public void beforeMethod1(){
		System.out.println("------- Before Method TestDemo4 -------");
	}
	
	@AfterMethod
	public void aeforeMethod1(){
		System.out.println("------- After Method TestDemo4 -------");
	}
	
	@Test
	public void case5(){
		System.out.println("--------- Method Case EE ---------");
	}

	@Test
	public void case6(){
		System.out.println("--------- Method Case FF ---------");
	}
}

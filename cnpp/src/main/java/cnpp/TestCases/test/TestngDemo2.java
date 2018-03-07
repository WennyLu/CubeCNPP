package cnpp.TestCases.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngDemo2 {
	@BeforeClass
	public void beforeClass1() {
		System.out.println("----- [Before Class TestDome2] -----");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("----- [After Class TestDome2] -----");
	}
	
	@BeforeMethod
	public void beforeMethod1(){
		System.out.println("------- ==Before Method TestDemo2== -------");
	}
	
	@AfterMethod
	public void aeforeMethod1(){
		System.out.println("------- ==After Method TestDemo2== -------");
	}
	
	@Test
	public void case2(){
		System.out.println("--------- Method Case BB ---------");
	}
}

package com.resolver.qa.testcase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resolver.qa.base.TestBase;
import com.resolver.qa.pages.HomePage;
import com.resolver.qa.util.TestUtil;



public class HomeTestCase extends TestBase{

	private HomePage ObjHome;
	
	public HomeTestCase() {
		super();// pro keyword is initialize by super() keyword, pro is available in TestBase class 
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		ObjHome=new HomePage();
		
	}
	
	@Test(priority = 1,description = "Login to App")
	public void Test1() {
		boolean actualEmail=ObjHome.verifyEmail();
		boolean actualPass=ObjHome.verifyPassword();
		boolean actualSignin=ObjHome.verifySignin();
		Assert.assertTrue(actualEmail);
		Assert.assertTrue(actualPass);
		Assert.assertTrue(actualSignin);
		ObjHome.loginToApp(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@Test(priority = 2,description = "Verify List Items")
	public void Test2() {
		int Actual=ObjHome.verifyListSize().size();
		
		String actuListItem2=ObjHome.verifyListItem2();
		int actualBadgeValue=ObjHome.verifyBadgevalue();
		Assert.assertEquals(Actual, 3);
		Assert.assertTrue(actuListItem2.contains("List Item 2"));
		Assert.assertEquals(actualBadgeValue,6);		
	}
	
	@Test(priority = 3,description = "Verify the Options")
	public void Test3() {
		String actOption1=ObjHome.verifyOption1Text();
		Assert.assertTrue(actOption1.contains("Option 1"));
		ObjHome.clickOption1();
		ObjHome.clickOnOption3();
		String actOption3=ObjHome.verifyOption1Text();
		Assert.assertTrue(actOption3.contains("Option 3"));
		
	}
	
	
	@Test(priority = 4,description = "verify button")
	public void Test4() {
		boolean actButton=ObjHome.verifyEnabledButton();
		Assert.assertTrue(actButton);
		boolean actButton1=ObjHome.verifyDisabledButton();
		Assert.assertFalse(actButton1);
		
	}
	
	
	@Test(priority = 5,description = "Verify Alert Message")
	public void Test5() {
		boolean actButton=ObjHome.verifyBtn5Display();
		Assert.assertTrue(actButton);
		ObjHome.clickBtn5Display();
		String act=ObjHome.verifyTest5Alert();
		Assert.assertTrue(act.contains("You clicked a button!"));
		Assert.assertFalse(ObjHome.verifyDisabledBtn5());
	}
	
	@Test(priority = 6,description = "verify Table Grid")
	public void Test6() {
		String act=ObjHome.getDataTable();
		Assert.assertEquals(act, "Ventosanzap");
	}
	
	
	@AfterMethod
	public void teardown() {
		dr.close();
	}
	
}

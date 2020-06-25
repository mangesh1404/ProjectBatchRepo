package com.onlineproject;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage login;
	
	@BeforeSuite
	public void setUp() {
		initialization();
		login= new LoginPage();
		
	}
	@Test(priority=-1)
	public void launchLogin() {
		Assert.assertTrue(false);
	}
	@Test(priority=0)
	public void loginTest() {
		login.typeUname(prop.getProperty("username"));
		login.typePass(prop.getProperty("password"));
		login.clickButton();
	}
	
	@Test(priority=2, dependsOnMethods="loginTest",alwaysRun=true)
	public void titleTest() {
		login.titleTest();
		
	}
	
	
}

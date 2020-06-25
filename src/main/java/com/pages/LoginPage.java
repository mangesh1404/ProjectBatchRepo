package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(xpath = "//button")
	private WebElement login_Button;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeUname(String userName) {
		uname.sendKeys(userName);
	}
	public void typePass(String password) {
		pass.sendKeys(password);
	}
	public void clickButton() {
		login_Button.click();
	}
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		
	}
	
	
}

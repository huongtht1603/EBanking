package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

public class login {
	
	private WebDriver driver;
	WaitHelper waitHelper;
	
	@FindBy(name="j_idt10:j_idt12")
	public WebElement username;
	
	@FindBy(name="j_idt10:j_idt14")
	public WebElement password;
	
	@FindBy(name="j_idt10:j_idt16")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id='growl_container']/div/div/div[2]/p")
	public WebElement warningMessage;
	
	@FindBy(xpath="//*//*[@id='top']/div/div/div[2]/div/ul/li[7]/a")
	public WebElement usernameLnk;
	
	@FindBy(linkText="Đăng xuất")
	public WebElement LogoutTab;
	
	@FindBy(linkText="Tạo tài khoản")
	public WebElement registrationLnk;
	
	
	public login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void enterUsername () {
		this.username.sendKeys(Constants.username);
	}
	
	public void enterUsername (String username) {
		this.username.sendKeys(username);
	}
	
	public void enterPassword () {
		this.password.sendKeys(Constants.password);
	}
	
	public void enterPassword (String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginbutton() {
		waitHelper.WaitForElement(this.loginBtn, 3);
		loginBtn.click();		
	}
	
	public void isSignInSuccess(String username) {
		String actual_name= usernameLnk.getText();
		assertTrue(actual_name.contains(username));
	}
	
	public void isErrorMessageDisplay(String input) {
		warningMessage.isDisplayed();
		String actual_msg= warningMessage.getText();
		assertTrue(actual_msg.contains(input));
	}
	
	public void clickLogoutbutton () {
		waitHelper.WaitForElement(this.LogoutTab, 3);
		LogoutTab.click();		
	}
	
	public void isSignOutSuccess () {
		waitHelper.WaitForElement(this.registrationLnk, 3);
		registrationLnk.isEnabled();
	}
}

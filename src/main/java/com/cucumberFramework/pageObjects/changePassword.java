package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;


public class changePassword {
	
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	
	@FindBy(name="j_idt10:j_idt12")
	public WebElement username;
	
	@FindBy(name="j_idt10:j_idt14")
	public WebElement password;
	
	@FindBy(name="j_idt10:j_idt16")
	public WebElement loginBtn;
	
	@FindBy(linkText="Đổi mật khẩu")
	public WebElement changePasswordTab;
	
	@FindBy(id="j_idt24:j_idt28")
	public WebElement currentPassword;
	
	@FindBy(id="j_idt24:pwd1")
	public WebElement newPassword;
	
	@FindBy(id="j_idt24:pwd2")
	public WebElement newPasswordConfirm;
	
	@FindBy(name="j_idt24:j_idt32")
	public WebElement changePasswordBtn;
	
	@FindBy(id="primefacesmessagedlg")
	public WebElement message;
	
	public changePassword(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void logIn() {
		this.username.sendKeys(Constants.username);
		this.password.sendKeys(Constants.password);
		waitHelper.WaitForElement(this.loginBtn, 3);
		loginBtn.click();
	}
	
	public void login(String password) {
		this.username.sendKeys(Constants.username);
		this.password.sendKeys(password);
		waitHelper.WaitForElement(this.loginBtn, 3);
		loginBtn.click();
	}
	
	public void clickChangePasswordTab () {
		waitHelper.WaitForElement(this.changePasswordTab, 3);
		changePasswordTab.click();		
	}
	
	public void enterCurrentPassword (String currentPassword) {
		this.currentPassword.sendKeys(currentPassword);	
	}
	
	public void enterNewPassword (String newPassword) {
		this.newPassword.sendKeys(newPassword);	
	}
	
	public void enterNewPasswordConfirm (String newPasswordConfirm) {
		this.newPasswordConfirm.sendKeys(newPasswordConfirm);	
	}
	
	public void clickChangePasswordButton () {
		waitHelper.WaitForElement(this.changePasswordBtn, 3);
		changePasswordBtn.click();		
	}
	
	public void isSuccessMessageDisplay (String input) {
		String actual_msg= message.getText();
		assertTrue(actual_msg.contains(input));
	}
	
	public void isErrorMessageDisplay (String input) {
		String actual_msg= message.getText();
		assertTrue(actual_msg.contains(input));
	}
}

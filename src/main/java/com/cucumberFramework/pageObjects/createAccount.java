package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.createAccount;


public class createAccount {

	private WebDriver driver;
	private WaitHelper waitHelper;
	
	@FindBy(name="j_idt10:j_idt12")
	public WebElement username;
	
	@FindBy(name="j_idt10:j_idt14")
	public WebElement password;
	
	@FindBy(name="j_idt10:j_idt16")
	public WebElement loginBtn;
	
	@FindBy(linkText="Mở tài khoản")
	public WebElement createAccountTab;
	
	@FindBy(xpath="//*[@id='j_idt23:j_idt27']/div[3]/span")
	public WebElement accountTypeDD;
	
	@FindBy(xpath="//*[@id='j_idt23:j_idt27_panel']/div/ul/li[3]")
	public WebElement savingsAccountItem;
	
	@FindBy(name="j_idt23:j_idt31")
	public WebElement summitBtn;
	
	@FindBy(xpath="//*[@id='primefacesmessagedlg']/div[2]")
	public WebElement successMsg;
	
	@FindBy(xpath = "//*[@id='j_idt8:messages_container']/div/div/div[2]/span")
	public WebElement errorMsg;
	
	
	public createAccount(WebDriver driver){
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
	
	public void clickCreateAccountTab () {
		waitHelper.WaitForElement(this.createAccountTab, 3);
		createAccountTab.click();		
	}
	
	public void selectAccountType() {
		waitHelper.WaitForElement(this.accountTypeDD, 3);
		accountTypeDD.click();
		waitHelper.WaitForElement(this.savingsAccountItem, 3);
		savingsAccountItem.click();
	}
	
	public void clickCreateAccountButton () {
		waitHelper.WaitForElement(this.summitBtn, 3);
		summitBtn.click();		
	}
	
	public void isSuccessMessageDisplay (String input) {
		successMsg.isDisplayed();
		String actual_msg= successMsg.getText();
		assertTrue(actual_msg.contains(input));
	}
	
	public void isErrorMessageDisplay (String input) {
		errorMsg.isDisplayed();
		String actual_msg= errorMsg.getText();
		assertTrue(actual_msg.contains(input));
	}
}

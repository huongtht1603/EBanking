package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;


public class accountInfo {
	
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	@FindBy(name="j_idt10:j_idt12")
	public WebElement username;
	
	@FindBy(name="j_idt10:j_idt14")
	public WebElement password;
	
	@FindBy(name="j_idt10:j_idt16")
	public WebElement loginBtn;
	
	@FindBy(xpath="//*//*[@id='top']/div/div/div[2]/div/ul/li[7]/a")
	public WebElement usernamelnk;
	
	@FindBy(linkText="Thông tin cá nhân")
	public WebElement accountInfoTab;
	
	@FindBy(id="j_idt24:j_idt28")
	public WebElement nameResult;
	
	@FindBy(id="j_idt24:j_idt30")
	public WebElement dobResult;
	
	@FindBy(id="j_idt24:j_idt32")
	public WebElement idResult;
	
	@FindBy(id="j_idt24:j_idt34")
	public WebElement phoneResult;
	
	@FindBy(id="j_idt24:j_idt36")
	public WebElement addressResult;
	
	@FindBy(id="j_idt24:j_idt38")
	public WebElement emailResult;
	
	public accountInfo(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void logIn() {
		driver.get(Constants.application_URL);
		this.username.sendKeys(Constants.username);
		this.password.sendKeys(Constants.password);
		waitHelper.WaitForElement(this.loginBtn, 3);
		loginBtn.click();
	}

	public void isUsernameDisplay(String username) {
		String actual_name= usernamelnk.getText();
		assertTrue(actual_name.contains(username));
	}
	
	public void clickAccountInfoTab() {
		waitHelper.WaitForElement(this.accountInfoTab, 3);
		accountInfoTab.click();
	}

	public void isRegisteredDataCorrect(String name, String dob, String id, String phone, String address, String email) {
		accountInfoTab.click();
		String name_actual= nameResult.getText();
		assertTrue(name_actual.contains(name));
		String dob_actual= dobResult.getText();
		assertTrue(dob_actual.contains(dob));
		String id_actual= idResult.getText();
		assertTrue(id_actual.contains(id));
		String phone_actual= phoneResult.getText();
		assertTrue(phone_actual.contains(phone));
		String address_actual= addressResult.getText();
		assertTrue(address_actual.contains(address));
		String email_actual= emailResult.getText();
		assertTrue(email_actual.contains(email));
	}
}

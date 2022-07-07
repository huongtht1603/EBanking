package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

import cucumber.api.java.en.When;

public class internalTransfer {

	private WebDriver driver;
	private WaitHelper waitHelper;

	@FindBy(name = "j_idt10:j_idt12")
	public WebElement username;

	@FindBy(name = "j_idt10:j_idt14")
	public WebElement password;

	@FindBy(name = "j_idt10:j_idt16")
	public WebElement loginBtn;

	@FindBy(linkText = "Chuyển khoản")
	public WebElement internalTransferTab;

	@FindBy(xpath = "//*[@id='j_idt23:j_idt28']/div[3]/span")
	public WebElement accountDD;
	
	@FindBy(xpath = "//*[@id='j_idt23:j_idt28_panel']/div/ul/li[3]")
	public WebElement accountItem;

	@FindBy(id = "j_idt23:j_idt35")
	public WebElement beneficiaryAcc;

	@FindBy(id = "j_idt23:j_idt40")
	public WebElement value;

	@FindBy(id = "j_idt23:j_idt42")
	public WebElement details;

	@FindBy(name = "j_idt23:j_idt44")
	public WebElement confirmBtn;

	@FindBy(xpath = "//*[@id='j_idt8:messages_container']/div/div/div[2]/span")
	public WebElement message;
	
	
	public internalTransfer(WebDriver driver){
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

	public void clickInternalTransferTab() {
		waitHelper.WaitForElement(this.internalTransferTab, 3);
		internalTransferTab.click();
	}

	public void selectSourceAccount() {
		waitHelper.WaitForElement(this.accountDD, 3);
		accountDD.click();
		waitHelper.WaitForElement(this.accountItem, 3);
		accountItem.click();
	}

	public void enterBeneficiaryAccount(String input) {
		this.beneficiaryAcc.clear();
		this.beneficiaryAcc.sendKeys(input);
	}

	public void enterValueOfTransfer(String value) {
		this.value.clear();
		this.value.sendKeys(value);
	}

	public void enterDetailOfPayment(String detail) {
		waitHelper.WaitForElement(this.details, 3);
		this.details.sendKeys(detail);
	}

	public void clickConfirmButton() {
		waitHelper.WaitForElement(this.confirmBtn, 3);
		confirmBtn.click();
	}

	public void isErrorMessageDisplay (String msg) {
		message.isDisplayed();
		String actual_msg= message.getText();
		assertTrue(actual_msg.contains(msg));
	}
}

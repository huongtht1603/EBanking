package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;



public class externalTransfer extends AbstractPage {

	private WebDriver driver;
	private WaitHelper waitHelper;

	@FindBy(name = "j_idt10:j_idt12")
	public WebElement username;

	@FindBy(name = "j_idt10:j_idt14")
	public WebElement password;

	@FindBy(name = "j_idt10:j_idt16")
	public WebElement loginBtn;

	@FindBy(linkText = "Liên Ngân Hàng")
	public WebElement externalTransferTab;

	@FindBy(xpath = "//*[@id='j_idt23:j_idt28']/div[3]/span")
	public WebElement accountDD;
	
	@FindBy(xpath = "//*[@id='j_idt23:j_idt28_panel']/div/ul/li[4]")
	public WebElement accountItem;

	@FindBy(id = "j_idt23:soucre")
	public WebElement beneficiaryAcc;
	
	@FindBy(id = "j_idt23:nameSoucre")
	public WebElement beneficiaryName;
	
	@FindBy(xpath = "//*[@id='j_idt23:country']/div[3]")
	public WebElement bankDD;
	
	@FindBy(xpath = "//*[@id='j_idt23:country_panel']/div/ul/li[2]")
	public WebElement bankItem;
	
	@FindBy(xpath = "//*[@id='j_idt23:city']/div[3]")
	public WebElement branchDD;
	
	@FindBy(xpath = "//*[@id='j_idt23:city_panel']/div/ul/li[2]")
	public WebElement branchItem;
	
	@FindBy(name = "j_idt23:j_idt45")
	public WebElement details;
	
	@FindBy(name = "j_idt23:tranf")
	public WebElement value;

	@FindBy(xpath = "//*[@id='j_idt23:msgs_container']/div/div/div[2]/p")
	public WebElement errorMsg;
	
	
	public externalTransfer(WebDriver driver){
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
		waitHelper.WaitForElement(this.externalTransferTab, 3);
		externalTransferTab.click();
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
	
	public void enterBeneficiaryName(String input) {
		this.beneficiaryName.clear();
		this.beneficiaryName.sendKeys(input);
	}
	
	public void selectBank() throws InterruptedException {
		waitHelper.WaitForElement(this.bankDD, 3);
		bankDD.click();
		Thread.sleep(5000);
		waitHelper.WaitForElement(this.bankItem, 3);
		bankItem.click();
	}
	
	public void selectBranch() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",branchDD);
		waitHelper.WaitForElement(this.branchDD, 20);
		branchDD.click();
		waitHelper.WaitForElement(this.branchItem, 3);
		branchItem.click();
	}

	public void enterDetailOfPayment(String detail) {
		waitHelper.WaitForElement(this.details, 3);
		this.details.sendKeys(detail);
	}
	
	public void enterValueOfTransfer(String value) {
		this.value.clear();
		this.value.sendKeys(value);
	}

	public void Confirm() {
		this.value.sendKeys(Keys.ENTER);
	}

	public void isErrorMessageDisplay (String msg) {
		errorMsg.isDisplayed();
		String actual_msg= errorMsg.getText();
		assertTrue(actual_msg.contains(msg));
	}
}

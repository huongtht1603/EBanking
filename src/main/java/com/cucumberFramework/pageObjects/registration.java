package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.Constants;

public class registration extends AbstractPage {

	private WebDriver driver;
	WaitHelper waitHelper;
	
	@FindBy(linkText="Tạo tài khoản")
	public WebElement registrationLnk;
	
	@FindBy(name="j_idt9:soucre")
	public WebElement username;

	@FindBy(name="j_idt9:pwd1")
	public WebElement password;
	
	@FindBy(name="j_idt9:pwd2")
	public WebElement confirmPassword;
	
	@FindBy(name="j_idt9:key")
	public WebElement name;
	
	@FindBy(name="j_idt9:phone")
	public WebElement phone;
	
	@FindBy(xpath="//*[@id='j_idt9:mask']/button/span[1]")
	public WebElement datepicker;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a")
	public WebElement dob;
	
	@FindBy(xpath="//*[@id='j_idt9:console']/tbody/tr/td[3]/div/div[2]/span")
	public WebElement femaleItem;
	
	@FindBy(xpath="//*[@id='j_idt9:country']/div[3]/span")
	public WebElement cityDD;
	
	@FindBy(xpath="//*[@id='j_idt9:country_panel']/div/ul/li[2]")
	public WebElement danangItem;
	
	@FindBy(name="j_idt9:cmnd")
	public WebElement idNumber;
	
	@FindBy(name="j_idt9:email")
	public WebElement email;
	
	@FindBy(name="j_idt9:j_idt27")
	public WebElement registryBtn;
	
	@FindBy(xpath="//table[@id='j_idt9:display']/tbody/tr[2]/td/input")
	public WebElement agreeBtn;
	
	@FindBy(xpath="//*[@id='primefacesmessagedlg']/div[2]")
	public WebElement notification;
	
	public registration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	
	public void clickRegistrationLink () {
		waitHelper.WaitForElement(this.registrationLnk, 3);
		registrationLnk.click();	
	}
	
	public void enterRandomUsername() {
		waitHelper.WaitForElement(this.username, 3);
		Constants.usernameauto = randomText(8);
		this.username.sendKeys(Constants.usernameauto);
	}
	
	public void enterPasswordAndConfirmPassword() {
		waitHelper.WaitForElement(this.password, 3);
		this.password.sendKeys(Constants.password);
		waitHelper.WaitForElement(this.confirmPassword, 3);
		this.confirmPassword.sendKeys(Constants.password);
	}
	
	public void enterRandomName() {
		waitHelper.WaitForElement(this.name, 3);
		Constants.name = randomText(8);
		this.name.sendKeys(Constants.name);
	}
	
	public void enterRandomPhone() {
		waitHelper.WaitForElement(this.phone, 3);
		Constants.phone = "09" + randomNumberString(8);
		this.phone.sendKeys(Constants.phone);
	}
	
	public void selectDOB () {
		waitHelper.WaitForElement(this.datepicker, 3);
		datepicker.click();	
		waitHelper.WaitForElement(this.dob, 3);
		dob.click();	
	}
	
	public void selectGender () {
		waitHelper.WaitForElement(this.femaleItem, 3);
		femaleItem.click();		
	}
	
	public void selectCity () {
		waitHelper.WaitForElement(this.cityDD, 3);
		cityDD.click();	
		waitHelper.WaitForElement(this.danangItem, 3);
		danangItem.click();
	}
	
	public void enterRandomIdNumber() {
		waitHelper.WaitForElement(this.idNumber, 3);
		Constants.idNumber = "20" + randomNumberString(7);
		this.idNumber.sendKeys(Constants.idNumber);
	}
	
	public void enterRandomEmail() {
		waitHelper.WaitForElement(this.email, 3);
		Constants.email = "testUser" + randomNumberString(4).toLowerCase() + "@gmail.com";		
		System.out.println(Constants.email);
		this.email.sendKeys(Constants.email);
	}
	
	public void clickRegistryButton () {
		waitHelper.WaitForElement(this.registryBtn, 3);
		registryBtn.click();
	}
	
	public void clickAgreeButton(){
		waitHelper.WaitForElement(this.agreeBtn, 3);
		agreeBtn.click();
	}
	
	public void isSuccessMessageDisplay (String input) {
		notification.isDisplayed();
		String actual_msg= notification.getText();
		assertTrue(actual_msg.contains(input));
	}
	
	
}

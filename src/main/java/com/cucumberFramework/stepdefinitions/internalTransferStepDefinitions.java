package com.cucumberFramework.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.internalTransfer;
import com.cucumberFramework.testBase.TestBase;


public class internalTransferStepDefinitions extends TestBase {
	
	
	internalTransfer internalTransfer = new internalTransfer(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("^login the page by username and password$")
	public void login_page() throws Throwable {
		driver.get(Constants.application_URL);
		internalTransfer.logIn();
	}
	
	@When("^internal transfer money page has been loaded$")
	public void internal_transfer_money_page_has_been_loaded() throws Throwable {
		internalTransfer.clickInternalTransferTab();
	}
	
	@When("^select first item for Tài khoản nguồn$")
	public void select_first_item_for_Tài_khoản_nguồn() throws Throwable {
		internalTransfer.selectSourceAccount();
	}

	@When("^enter \"([^\"]*)\" to Tài khoản nhận$")
	public void enter_to_Tài_khoản_nhận(String input) throws Throwable {
		internalTransfer.enterBeneficiaryAccount(input);
	}

	@When("^enter \"([^\"]*)\" to Số tiền$")
	public void enter_to_Số_tiền(String input) throws Throwable {
		internalTransfer.enterValueOfTransfer(input); 
	}

	@When("^enter \"([^\"]*)\" to Nội dung thanh toán$")
	public void enter_to_Nội_dung_thanh_toán(String input) throws Throwable {
		internalTransfer.enterDetailOfPayment(input);    
	}    

	@When("^click on a confirm button$")
	public void click_on_a_confirm_button() throws Throwable {
		internalTransfer.clickConfirmButton();
	}

	@Then("^message shown up is \"([^\"]*)\"$")
	public void message_shown_up_is (String msg) throws Throwable {
		internalTransfer.isErrorMessageDisplay(msg);
	}
}

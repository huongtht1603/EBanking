package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.externalTransfer;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class externalTransferStepDefiniti extends TestBase {
	

	externalTransfer externalTransfer = new externalTransfer(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("^Logined the page by username and password$")
	public void logined_the_page_by_username_and_password() throws Throwable {
		driver.get(Constants.application_URL);
		externalTransfer.logIn();
	}

	@Given("^external transfer money page has been loaded$")
	public void external_transfer_money_page_has_been_loaded() throws Throwable {
		externalTransfer.clickInternalTransferTab();
	}

	@When("^select third item for Tài khoản nguồn$")
	public void select_third_item_for_Tài_khoản_nguồn() throws Throwable {
		externalTransfer.selectSourceAccount();
	}
	
	@When("^providing \"([^\"]*)\" to Tài khoản nhận$")
	public void providing_to_Tài_khoản_nhận(String input) throws Throwable {
		externalTransfer.enterBeneficiaryAccount(input);
	}

	@When("^enter \"([^\"]*)\" to Tên tài khoản nhận$")
	public void enter_to_Tên_tài_khoản_nhận(String input) throws Throwable {
		externalTransfer.enterBeneficiaryName(input);
	}

	@When("^select Ngân hàng Đông Á for Ngân hàng$")
	public void select_Ngân_hàng_Đông_Á_for_Ngân_hàng() throws Throwable {
	    externalTransfer.selectBank();
	}

	@When("^select Chi nhánh Đà Nẵng for Chi nhánh$")
	public void select_Chi_nhánh_Đà_Nẵng_for_Chi_nhánh() throws Throwable {
		externalTransfer.selectBranch();
	}

	@When("^providing \"([^\"]*)\" to Nội dung chuyển tiên$")
	public void providing_to_Nội_dung_chuyển_tiên(String input) throws Throwable {
		externalTransfer.enterDetailOfPayment(input);
	}

	@When("^providing \"([^\"]*)\" to Số tiền$")
	public void providing_to_Số_tiền(String input) throws Throwable {
		externalTransfer.enterValueOfTransfer(input);
	}

	@When("^click on confirm button$")
	public void click_on_confirm_button() throws Throwable {
		externalTransfer.Confirm();
	}
	
	@Then("^The error message \"([^\"]*)\" is displayed$")
	public void the_error_message_is_displayed(String input) throws Throwable {
		externalTransfer.isErrorMessageDisplay(input);	
	}

}

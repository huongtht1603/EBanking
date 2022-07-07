package com.cucumberFramework.stepdefinitions;


import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.createAccount;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class createAccountStepDefinitions extends TestBase {


		createAccount createAccount = new createAccount(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		
		
		@Given("^log in page by username and password$")
		public void log_in_page() throws Throwable {
			driver.get(Constants.application_URL);
			createAccount.logIn();
		}

		@When("^create account page has been loaded$")
		public void create_account_page_has_been_loaded() throws Throwable {
			createAccount.clickCreateAccountTab();
		}
		
		@When("^select savings account for account type$")
		public void select_savings_account_for_account_type() throws Throwable {
			createAccount.selectAccountType();   
		}

		@When("^click on a create account button$")
		public void click_on_an_create_account_button() throws Throwable {
			createAccount.clickCreateAccountButton();
		}
		
		@Then("^validate the outcome is as \"([^\"]*)\"$")
		public void validate_the_outcome_is_as(String msg) throws Throwable {
			createAccount.isSuccessMessageDisplay(msg);
		}
		
		@Then("^validate an outcome is as \"([^\"]*)\"$")
		public void validate_an_outcome_is_as(String msg) throws Throwable {
			createAccount.isErrorMessageDisplay(msg);
		}
}

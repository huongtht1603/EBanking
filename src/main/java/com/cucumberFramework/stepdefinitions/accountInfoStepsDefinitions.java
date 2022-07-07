package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.accountInfo;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class accountInfoStepsDefinitions extends TestBase  {

	accountInfo accountInfo = new accountInfo(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	@Given("^Sign in the page by username and password$")
	public void log_in() throws Throwable {
		accountInfo.logIn();
	}

	@When("^click on View account profile tab$")
	public void i_click_on_View_account_profile_tab() throws Throwable {
		accountInfo.clickAccountInfoTab();
	}

	@Then("^compare entered data in registration form \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_compared_entered_data_in_registration_form(String name, String dob, String id, String phone, String address, String email) throws Throwable {
		accountInfo.isRegisteredDataCorrect(name, dob, id, phone, address, email);
	}
}

package com.cucumberFramework.stepdefinitions;


import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.changePassword;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class changePasswordStepDefinitions extends TestBase  {

	changePassword changePassword = new changePassword(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("^log in the page by username and password$")
	public void log_in_page() throws Throwable {
		driver.get(Constants.application_URL);
		changePassword.logIn();
	}
	
	@Given("^log in the page by username and password as \"([^\"]*)\"$")
	public void log_in_page_by_username_and_password(String password) throws Throwable {
		driver.get(Constants.application_URL);
		changePassword.login(password);
	}

	@Given("^Change password page has been loaded$")
	public void Change_password_page_has_been_loaded() throws Throwable {
		changePassword.clickChangePasswordTab();
	}
	
	@When("^enter current password \"([^\"]*)\"$")
	public void enter_current_password(String currentPassword) throws Throwable {
	    changePassword.enterCurrentPassword(currentPassword);
	}
	
	@When("^enter new password \"([^\"]*)\"$")
	public void enter_new_password(String newPassword) throws Throwable {
		changePassword.enterNewPassword(newPassword);
	}

	@When("^enter new password confirm \"([^\"]*)\"$")
	public void enter_new_password_confirm(String newPasswordConfirm) throws Throwable {
		changePassword.enterNewPasswordConfirm(newPasswordConfirm);
	}

	@When("^click on Change password button$")
	public void click_on_Change_password_button() throws Throwable {
	    changePassword.clickChangePasswordButton();
	}

	@Then("^the success message is as \"([^\"]*)\"$")
	public void the_success_message_is_as (String msg) throws Throwable {
		changePassword.isSuccessMessageDisplay(msg);
	}
	
	@Then("^the displayed message is as \"([^\"]*)\"$")
	public void the_displayed_message_is_as (String msg) throws Throwable {
		changePassword.isErrorMessageDisplay(msg);
	}
}

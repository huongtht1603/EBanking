
package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.login;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStepDefinitions extends TestBase  {

	login login = new login(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("^Be on an login page url$")
	public void be_on_an_login_page_url() throws Throwable {
		 driver.get(Constants.application_URL);
	}

	@When("^enter username$")
	public void enter_username_as() throws Throwable {
		login.enterUsername();
	}

	@When("^enter password$")
	public void enter_password_as() throws Throwable {
		login.enterPassword();
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    login.clickLoginbutton();
	}
	
	@Then("^Be logged in and I see the Home page with name displayed as \"([^\"]*)\"$")
	public void be_logged_in_and_I_see_the_Home_page_with_name_displayed_as(String username) throws Throwable {
		login.isSignInSuccess(username);
	}
	
	@When("^enter an username as (.+)$")
	public void enter_email(String username) throws Throwable {
		login.enterUsername(username);
	}

	@And("^enter a password for login as (.+)$")
	public void enter_password_for_login_as(String password) throws Throwable {
		login.enterPassword(password);
	}
	
	@Then("^an error mesage as (.+)$")
	public void an_error_mesage_as (String msg) throws Throwable {
		login.isErrorMessageDisplay(msg);
	}
	
	@When("^click on logout button$")
	public void click_on_logout_button() throws Throwable {
		login.clickLogoutbutton();
	}
	
	@Then("^being on login page$")
	public void being_on_login_page() throws Throwable {
		login.isSignOutSuccess();
	}
	
}
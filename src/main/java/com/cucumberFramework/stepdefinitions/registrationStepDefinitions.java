package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.registration;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class registrationStepDefinitions extends TestBase {

	registration registration = new registration(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("^Being on an url$")
	public void i_am_on_an_url() throws Throwable {
	    driver.get(Constants.application_URL);
	}

	@When("^click on Tạo tài khoản link$")
	public void click_on_Tạo_tài_khoản_link() throws Throwable {
	    registration.clickRegistrationLink();
	}
	
	@Then("^registration form has been displayed$")
	public void registration_form_has_been_displayed() throws Throwable {
		registration.registryBtn.isDisplayed();
	}
	
	@Then("^enter random username$")
	public void enter_random_username () throws Throwable {
		registration.enterRandomUsername();
	}

	@Then("^enter password and confirm password$")
	public void enter_password_and_confirm_password() throws Throwable {
		registration.enterPasswordAndConfirmPassword();
	}

	@Then("^enter random name$")
	public void enter_random_name() throws Throwable {
		registration.enterRandomName();
	}

	@Then("^enter random phone$")
	public void enter_random_phone() throws Throwable {
	    registration.enterRandomPhone();
	}

	@When("^select random date for date of birth dropdown$")
	public void select_random_date_for_date_of_birth_dropdown() throws Throwable {
	    registration.selectDOB();
	}

	@When("^choose Nữ$")
	public void choose_Nữ() throws Throwable {
	    registration.selectGender();
	}

	@When("^select Thanh pho Da Nang$")
	public void select_Thanh_pho_Da_Nang() throws Throwable {
	    registration.selectCity();
	}

	@Then("^enter random id number$")
	public void enter_random_id_number() throws Throwable {
	    registration.enterRandomIdNumber();
	}

	@Then("^enter random email$")
	public void enter_random_email() throws Throwable {
	    registration.enterRandomEmail();
	}

	@When("^click on registry button$")
	public void click_on_registry_button() throws Throwable {
	    registration.clickRegistryButton();
	}
	
	@When("^click on agree button$")
	public void click_on_agree_button() throws Throwable {
	    registration.clickAgreeButton();
	}

	@Then("^the message shown up is \"([^\"]*)\"$")
	public void the_message_shown_up_is (String msg) throws Throwable {
		registration.isSuccessMessageDisplay(msg);
	}

}

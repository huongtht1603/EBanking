
@tag
Feature: Create account

Background:
	Given log in page by username and password
	And create account page has been loaded

  @SmokeTest, @RegressionTest
  Scenario: OA_02 Verify create account function by selecting kind of account in dropdown

    When select savings account for account type
    And click on a create account button
    Then validate the outcome is as "Mở tài khoản thành công"
    
  @SmokeTest, @RegressionTest
  Scenario: OA_03 Verify Create account function without selecting any kind of acount in dropdown
  
    When click on a create account button
    Then validate an outcome is as "Mời chọn loại tài khoản"

 


@tag
Feature: Account information module

Background:
 Given Sign in the page by username and password

  @RegressionTest
  Scenario: VA_01 Verify account profile information in account profile page is the same to registration information

    When click on View account profile tab
    Then compare entered data in registration form "iviettech" "18/11/2001" "201502485" "0984222860" "Thanh pho Da Nang" "iviettechst46@gmail.com"
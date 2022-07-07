Feature: Login page


Background:
	Given Be on an login page url
 
 
  @SmokeTest, @RegressionTest
  Scenario: LI_03 Verify login function with valid data
    When enter username
    And enter password
    And click on login button
    Then Be logged in and I see the Home page with name displayed as "iviettech" 
  
    
  @RegressionTest
  Scenario Outline: LI_04 Verify error message if providing unregistered/incorrect username
                    LI_06 Verify error message if inputing correct username and wrong password
                    
    When enter an username as <username>
    And enter a password for login as <password>
    And click on login button
    Then an error mesage as <errorMessage>

    Examples:
      | username | password      |errorMessage                |
      | st462022 | S@T46!        |Sai tài khoản hoặc mật khẩu |
      | st123456 | iviettech2022 |Tài khoản không tồn tại     |
      
      
  @SmokeTest, @RegressionTest
  Scenario: LO_01 Verify user is able to log out when clicking on "Đăng xuất" button
    When enter username
    And enter password
    And click on login button
    Then Be logged in and I see the Home page with name displayed as "iviettech" 
    And click on logout button
    Then being on login page
   
    
    
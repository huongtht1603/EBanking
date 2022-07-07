
@tag
Feature: Change password page

		@SmokeTest, @RegressionTest
  Scenario: CP_02 Verify change password function when providing valid data
  	Given log in the page by username and password
		And Change password page has been loaded
    When enter current password "iviettech2022"
    And enter new password "iviettech2023"
    And enter new password confirm "iviettech2023"
    And click on Change password button
    Then the success message is as "Đổi mật khẩu thành công"
    
    @SmokeTest, @RegressionTest
  Scenario: CP_02 Verify change password function when providing valid data
  	Given log in the page by username and password as "iviettech2023"
    And Change password page has been loaded
    When enter current password "iviettech2023"
    And enter new password "iviettech2022"
    And enter new password confirm "iviettech2022"
    And click on Change password button
    Then the success message is as "Đổi mật khẩu thành công"
    
    @RegressionTest
  Scenario: CP_04 Verify change password function when providing incorect current password
 		Given log in the page by username and password
    And Change password page has been loaded
    When enter current password "iviettech2023"
    And enter new password "iviettech2024"
    And enter new password confirm "iviettech2024"
    And click on Change password button
    Then the displayed message is as "Mật khẩu cũ không đúng" 




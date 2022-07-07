
@tag
Feature: Registration

  @SmokeTest, @RegressionTest
  Scenario: RE_04 Verify registration function with valid data to all fields
 		Given Being on an url
    When click on Tạo tài khoản link
    Then registration form has been displayed
    And enter random username
    And enter password and confirm password
    And enter random name
    And enter random phone
    And select random date for date of birth dropdown
    And choose Nữ
    And select Thanh pho Da Nang
    And enter random id number
    And enter random email
    And click on registry button
    And click on agree button
    Then the message shown up is "Đăng kí tài khoản thành công, vui lòng vào Email để kích hoạt tài khoản."


    
    
    
    



 

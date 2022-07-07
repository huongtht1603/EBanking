
@tag
Feature: External transfer

  @SmokeTest, @RegressionTest
  Scenario: ETM_11 Verify error message if transfering value of transfer money is greater than balance
    Given Logined the page by username and password
    And external transfer money page has been loaded
    When select third item for Tài khoản nguồn
    And providing "10001111" to Tài khoản nhận 
    And enter "Nguyen Van A" to Tên tài khoản nhận 
    And select Ngân hàng Đông Á for Ngân hàng
    And select Chi nhánh Đà Nẵng for Chi nhánh
    And providing "Happy Wedding" to Nội dung chuyển tiên
    And providing "1500000" to Số tiền
    And click on confirm button
    Then The error message "Số tiền quá qui định" is displayed
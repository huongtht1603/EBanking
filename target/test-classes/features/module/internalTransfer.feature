
@tag
Feature: Internal transfer

Background:
   Given login the page by username and password
   And internal transfer money page has been loaded
	
	
  @RegressionTest
  Scenario: ITM_07 Verify error mesage when providing invalid account of beneficiary
  
    When select first item for Tài khoản nguồn
    And enter "*(&&&abcdhj " to Tài khoản nhận 
    And enter "100000" to Số tiền
    And enter "Happy Wedding" to Nội dung thanh toán
    And click on a confirm button
    Then message shown up is "Tài khoản không hợp lệ"
    
    
  @SmokeTest, @RegressionTest
  Scenario: ITM_09 Verify error mesage when providing the same account of sender and beneficiary
    When select first item for Tài khoản nguồn
    And enter "100002426" to Tài khoản nhận 
    And enter "100000" to Số tiền
    And enter "Happy Wedding" to Nội dung thanh toán
    And click on a confirm button
    Then message shown up is "Tài khoản không hợp lệ, quý khách vui lòng kiểm tra lại." 


  @RegressionTest
  Scenario: ITM_11 Verify error message if entering invalid data to "Số tiền" field
    When select first item for Tài khoản nguồn
    And enter "100002410" to Tài khoản nhận 
    And enter "+_+15abc" to Số tiền
    And enter "Happy Wedding" to Nội dung thanh toán
    And click on a confirm button
    Then message shown up is "Số tiền không hợp lệ"
    

    
    
    
    



 

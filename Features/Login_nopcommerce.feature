Feature: Login nopcommerce

	@sanity
  Scenario: Successfull Login With Valid Credentials
    Given User Launch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And User Enters Email As "admin@yourstore.com" and Password As "admin"
    And Click On Login
    Then Page Title After Login Should Be "Dashboard / nopCommerce administration"
    When User Click On Log Out Link
    Then Page Title After Logout Should Be "Your store. Login"
    And Close Browser

	@regression
  Scenario Outline: Login Data Driven <!--to perform datadriven testing in cucumber we use "Scenario Outline"-->
    Given User Launch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And User Enters Email As "<email>" and Password As "<password>"
    And Click On Login
    Then Page Title After Login Should Be "Dashboard / nopCommerce administration"
    When User Click On Log Out Link
    Then Page Title After Logout Should Be "Your store. Login"
    And Close Browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |

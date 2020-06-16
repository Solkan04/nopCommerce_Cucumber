Feature: Customer nopcommerce

  Background: 
    Given User Launch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And User Enters Email As "admin@yourstore.com" and Password As "admin"
    And Click On Login
    Then User Can View Dashboard
    When User Click On Customers Menu
    And Click On Customers Menu Item

	@sanity
  Scenario: Add a New Customer
    And Click On Add New Button
    Then User Can View Add New Customer Page
    When User Enter Customer Info
    And Click On Save Button
    Then User Can View Confirmation Message "The new customer has been added successfully."
    And Close Browser
	
	@regression
  Scenario: Search Customer By EmailID
    And Enter Customer Email
    When Click On Search button
    Then User Should Find Email In The Search Table
    And Close Browser

	@regression
  Scenario: Search Customer By Name
    And Enter Customer FirstName
    And Enter Customer LastName
    When Click On Search button
    Then User Should Find Name In The Search Table
    And Close Browser

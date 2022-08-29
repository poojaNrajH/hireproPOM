Feature: Hireprous login

  #Scenario-1
  @RegressionTest
  Scenario: Login page field validation
    Given User navigate to Hireprous page
    When user verifies Hireprous logo
    And User verifies login page fields

  #Scenario-2
  @RegressionTest
  Scenario: Login to application with Invalid user credentials
    Given User is on the Hireprous page
    When User enters invalid username and password
    And User clicks on the Log IN button
    Then User verifes the error message for invalid credentials
   

  #Scenario-3
  @SmokeTest
  Scenario: Login to application with valid user credentials
    Given User is on Hireprous login page
    When User enters username and password
    And User clicks on Log IN button
    Then User login must be successful
    
 

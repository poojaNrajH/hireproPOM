Feature: Checking Recruitment functionality
  
  #Scenario-1
	@RegressionTest
  Scenario: Recuruitment page field validation
    Given User navigate to the Dashboard page by logging in Hireprous page
    When User clicks on  Recruitment from top menu
    Then User will be redirected to Recruitment process page
    And User clicks on Job Request menu
    Then User will be redirected to the JOb Request list page successfully
    And User verifies fields on the Job Request list page

  #Scenario-2
  #@RegressionTest
  #Scenario: Recruitment field and error message validation
    #Given User is on Job Request page
    #When User clicks on New Job Request button
    #Then User will be redirected to Add job request page
    #And User verifies fields on add job request page
    #And User clicks on the Save button without entering the mandatory fields and verifies error meassage
#
  #Scenario-3
  #@SmokeTest
  #Scenario: Filling Job Request creation
    #Given User navigate to the Recruitment page by logging in Hireprous page
    #When User clicks on  Recruitment from top
    #Then User will redirected to Recruitment process page
    #And User clicks on Job Request tab
    #And User clicks on the new Job Request button
    #And User has to fill the details of Customer Name, Recruitment Role, Business Unit, No. of Openings, Location,  Currency Type, Pay Range, Pay Frequency, Employment Type, Project Start Date, Placement For, Remote Working, Recruiter, Email, Firstname, Lastname, Location, Pay Range, Contract Duration,Job Description, Mandatory Skills, Optional Skills and save the Job request
    #

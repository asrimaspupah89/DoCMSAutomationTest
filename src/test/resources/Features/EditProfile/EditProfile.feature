#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Author Dimas Wisnu S
#Date 12 April 2023
#Description Edit Profile functionality test
@SmokeScenario
Feature: feature to test Edit Profile functionality
	
	@SmokeTest
  Scenario: check NonMandatory payload data validation on Edit Profile
    Given browser is on meta page
    #When user click skip metadata tour
    And user clicks on profile button
    And user click skip profile tour
    When user enters blank and blank
    #And user clicks on save button
    Then user got message full name required
	
  @SmokeTest
  Scenario Outline: check Mandatory payload data validation on Edit Profile
    Given browser is on meta page
    #When user click skip metadata tour
    And user clicks on profile button
    And user click skip profile tour
    When user enters <FirstName> and <LastName>
    Then user clicks on save changes button
    #Then user got message edited succes

    Examples: 
      | FirstName |  | LastName |
      | dimas     |  | wisnu    |
      | akun      |  | demoo    |

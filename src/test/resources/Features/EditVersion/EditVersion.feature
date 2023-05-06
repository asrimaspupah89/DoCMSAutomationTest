#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Author Dimas Wisnu S
#Date 12 April 2023
#Description Edit Version functionality test
@SmokeScenario
Feature: feature to test Edit Version functionality
	
	@SmokeTest
  Scenario: check NonMandatory payload data validation on Edit Version
    Given browser is on metadata page
    #When user click skip metadata tour
    And user clicks on manage content button
    And user click skip manage content tour
    And user clicks on edit icon
    When user enters blank
    #And user clicks on save button
    Then user got message new version name required
	
  @SmokeTest
  Scenario Outline: check Mandatory payload data validation on Edit Version
    Given browser is on metadata page
    #When user click skip metadata tour
    And user clicks on manage content button
    And user click skip manage content tour
    And user clicks on edit icon
    When user enters <NewVersionName>
    And user clicks on save button
    Then user got message edited success

    Examples: 
      | NewVersionName |  
      | Ver1.1.1       |   
      | 11             |

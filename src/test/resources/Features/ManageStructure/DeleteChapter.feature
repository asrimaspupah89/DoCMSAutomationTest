#Author
#Date
#Description

@SmokeScenario
Feature: Feature to delete chapter in manage content functionality
  
  @SmokeTest
  Scenario: Steps about how to delete chapter in manage content successfully 
    Given browser is opened
    And user is on manage content page
    When user clicks on manage structure bar
    And user navigated to manage structure bar
    And user clicks delete button on chapter list
    Then chapter is deleted

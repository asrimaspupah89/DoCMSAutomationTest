#Author: Khansa Rafifah Taqiyyah
#Date : 26-04-2023
#Description

@SmokeScenario
Feature: Feature to delete chapter in manage content functionality
  
  @SmokeTest
  Scenario: Steps about how to delete chapter in manage content successfully 
    Given browser is opened
    And user is on cms page
    When user clicks on manage content
    And user clicks on manage structure bar
    Then user clicks delete button on chapter list

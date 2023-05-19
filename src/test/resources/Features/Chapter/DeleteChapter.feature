#Author: Ryrie Ceisha Ramadhanty
#Date: 30 April 2023
#Description: Delete Chapter DoCMS

@SmokeScenario
Feature: feature delete chapter
  
@SmokeTest
  Scenario: Delete Chapter is successful with Valid Input
    Given The browser is opened
    And The user is on cms page
    When The user clicks on chapter page
    And The user clicks on list chapter
    Then user clicks delete button on chapter list
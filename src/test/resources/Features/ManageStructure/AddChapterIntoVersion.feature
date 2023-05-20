#Author: Ryrie Ceisha Ramadhanty
#Date: 30 April 2023
#Description: Add Chapter into Version DoCMS

@SmokeScenario
Feature: feature add chapter in manage structure
  
@SmokeTest
  Scenario: Add chapter is successful with Valid Input
    Given User has opened the browser
    And User has navigated on the login page
    When The user clicks on manage content bar
    And The user clicks on manage structure bar
    And The user clicks add chapters
    And The user clicks one chapter
    Then The user clicks add
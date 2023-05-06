#Author
#Date
#Description

@SmokeScenario
Feature: Feature to create new section functionality
  
  @SmokeTest
  Scenario: Steps about how to make new section successful 
    Given browser is opened
    And user is on section page
    When user clicks on add new button
    And user navigated to section editor
    And user enters inisection and laginyobainsections
    And user clicks on create button
    Then new section is created

  @SmokeTest
  Scenario Outline: Steps about how to make new section successful 
    Given browser is opened
    And user is on section page
    When user clicks on add new button
    And user navigated to section editor
    And user enters <Section Title> and <Content>
    And user clicks on create button
    Then new section is created
    
    Examples: 
      | Section Title  | Content              | 
      | empty          | konten baru nih gais | 
      | SectionXX      | empty                |
      | empty          | empty                |
      
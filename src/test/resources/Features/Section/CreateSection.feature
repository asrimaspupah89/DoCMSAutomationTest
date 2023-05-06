#Author: Khansa Rafifah Taqiyyah
#Date : 05-04-2023
#Description

@SmokeScenario
Feature: Feature to create new section functionality
  
  @SmokeTest
  Scenario: Steps about how to make new section successful 
    Given browser is open
    And user is on section page
    When user clicks on add new button
    And user enters inisection and laginyobainsections
    Then user clicks on create button

  @SmokeTest
  Scenario Outline: Steps about how to make new section successful 
    Given browser is opened
    And user is on section page
    When user clicks on add new button
    And user enters <SectionTitle> and <Content>
    Then user clicks on create button
    
    Examples: 
      | SectionTitle   | Content              | 
      | empty          | konten baru nih gais | 
      | SectionXX      | empty                |
      | empty          | empty                |
      

@SmokeScenario
Feature: Metadata Feature

@SmokeTest
Scenario: User edits metadata
	Given browser is on meta page
	And user clicks on metadata button
 #And user click skip metadata tour
	When user enters <Title> 
	And user clicks on save changes button
	Then user got message edited succes
	
	Examples: 
	| Title |  
	| DocCMS |   
	
#@SmokeTest
#Scenario: User edits metadata with blank fields
#	Given browser is on meta page
#	And user clicks on metadata button
#	And user click skip metadata tour
#	When user enters blank and blank
#	And user clicks on save changes button
#	Then user got message full name required
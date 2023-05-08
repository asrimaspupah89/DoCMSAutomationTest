@SmokeScenario
Feature: AddSection Feature

@SmokeTest
Scenario: User add section
	Given browser is on meta page
	And user clicks on manage content button
	And user click skip Manage Version tour
	And user clicks on manage stucture button
	And user clicks on add section button
	And user clicks on section into chapter button
	Then user clicks on add button
#	Then user got message add succes
	
	
#	When user enters <Title> 
#	And user clicks on save changes button
#	Then user got message edited succes
	
#	Examples: 
#	| Title |  
#	| DocCMS |   
#	
#@SmokeTest
#Scenario: User edits metadata with blank fields
#	Given browser is on meta page
#	And user clicks on metadata button
#	And user click skip metadata tour
#	When user enters blank and blank
#	And user clicks on save changes button
#	Then user got message full name required
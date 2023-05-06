#Author: Ihsan Fauzan Hanif
#Date: 13 April 2023
#Description: Table of content
@PortalTableOfContentFeature
Feature: feature to test table of content functionality

	@ValidScenario
  Scenario: Daftar konten pada section yang tampil yang bisa dilihat pada sisi kanan. (hanya visible di tampilan desktop).
    Given browser terbuka
    Then buka portal dokumentasi
    And maksimalkan tampilan browser
    When pilih dokumentasi v201524011
    When terdapat content dengan heading: "<listHeading>"
    Then bandingkan dengan TOC
  Examples:
  	| listHeading |
  	| h1 					|
  	| h1, h2			|
  	| h2					|
  
  @InvalidScenario
  Scenario: Daftar konten pada section yang tampil yang bisa dilihat pada sisi kanan. (hanya visible di tampilan desktop).
    Given browser terbuka
    Then buka portal dokumentasi
    And maksimalkan tampilan browser
    When pilih dokumentasi v201524011
    When terdapat content dengan heading: "<listHeading>"
    Then bandingkan dengan TOC
  Examples:
  	| listHeading |
  	| h3 					|
  	| h4 					|
  	| h5 					|
  	| h6 					|
  	| h1, h2, h3	|
  	| <empty> 		|

#Author: Salma Syawalan Putriadhinia
#Create Date: 26 April 2023
#Last Updated: 6 Mei 2023
#Description: Create new chapter

@CreateChapterFeature
Feature: feature to test create chapter functionality

  @ValidScenario
  Scenario: Create chapter is successful
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol add new
    And user menginputkan judul chapter chapt_test dan memilih versi demo
    And klik tombol save
    Then sistem dinavigasikan ke halaman manage chapter
    
  @InvalidScenario
  Scenario: Title field is filled but the version is empty
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol add new
    And user menginputkan judul chapter [blank] dan memilih versi demo
    Then tombol save disabled
    And user tetap berada di form pengisian

	@InvalidScenario
  Scenario: The version is choosed but the title field is empty
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol add new
    And user menginputkan judul chapter chapt_test dan memilih versi [blank]
    Then tombol save disabled
    And user tetap berada di form pengisian
    
  @InvalidScenario
  Scenario: The version and title fields are empty
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol add new
    And user menginputkan judul chapter [blank] dan memilih versi [blank]
    Then tombol save disabled
    And user tetap berada di form pengisian
#Author: Salma Syawalan Putriadhinia
#Create Date: 29 April 2023
#Last Updated: 6 Mei 2023
#Description: Edit chapter

@EditChapterFeature
Feature: feature to test edit chapter functionality

  @ValidScenario
  Scenario: Edit chapter is successful
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol page terakhir
    And klik edit pada chapter chapt_test
    And mengganti judul menjadi chapt_test_updated
    And klik tombol update
    Then sistem dinavigasikan ke halaman manage chapter
    
  @InvalidScenario
  Scenario: Title field is empty
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol page terakhir
    And klik edit pada chapter chapt_test
    And mengganti judul menjadi [blank]
    Then tombol update disabled
    And user tetap berada di form edit

	@ValidScenario
  Scenario: No title update
    Given browser terbuka
    Given user berada di home page dengan username Quasar dan password 12345678
    When klik tombol chapter
    And klik tombol page terakhir
    And klik edit pada chapter chapt_test
    And klik tombol update
    Then sistem dinavigasikan ke halaman manage chapter
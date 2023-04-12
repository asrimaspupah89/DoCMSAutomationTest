#Author: Rangga Yudha Yudistira
#Date: 12 April 2023
#Description: Navigasi halaman feature

@ChapterNavigasiHalamanFeature
Feature: feature to test navigation page functionality

  @ValidScenario
  Scenario: Next page with next button
    Given browser terbuka
    Given user berada di home page dengan username rangyuds dan password ranggayudha
    When membuka sidebar
    Then sidebar terbuka
    When klik tombol chapter
    And klik tombol next page
    Then sistem menampilkan halaman dua dari chapter
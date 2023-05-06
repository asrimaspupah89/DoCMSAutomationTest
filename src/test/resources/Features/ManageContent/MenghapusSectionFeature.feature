#Author: Ihsan Fauzan Hanif
#Date: 25 April 2023
#Description: Menghapus version
@ManageContentMenghapusSectionFeature
Feature: feature to test menghapus section functionality

	@ValidScenario
  Scenario: Menghapus section dari chapter pada version yang terpilih, section yang dipilih terhapus dari chapter yang dipilih. Case: hanya ada satu section pada chapter
    Given browser terbuka
    Given user berada di home page dengan username ihsan dan password 11111111
    And maksimalkan tampilan browser
    When klik tombol manage content
    Then klik tab manage structure
    And klik dropdown versi
    When klik versi v201524011
    When list yang memiliki satu section ditemukan
    Then klik tombol hapus pada section
    Then periksa keberhasilan penghapusan section

	@ValidScenario
	Scenario: Menghapus section dari chapter pada version yang terpilih, section yang dipilih terhapus dari chapter yang dipilih. Case: ada dua section pada chapter
    Given browser terbuka
    Given user berada di home page dengan username ihsan dan password 11111111
    And maksimalkan tampilan browser
    When klik tombol manage content
    Then klik tab manage structure
    And klik dropdown versi
    When klik versi v201524011
    When list yang memiliki dua section ditemukan
    Then klik tombol hapus pada section
    Then periksa keberhasilan penghapusan section

#Author: Rifatia Yumna Salma
#Description: Section

@PortalSection
Feature: feature to test Section functionality

	@SectionTestDefault
  Scenario: Menampilkan data section default.
    Given browser terbuka
    When buka portal docms
    And maksimalkan tampilan
    Then bandingkan dengan Konten
    
  @SectionTestChoose
  Scenario: Menampilkan data section yang dipilih user.
    Given browser terbuka
    When buka portal docms
    And maksimalkan tampilan
    And pilih section "<listSection>"
    Then bandingkan dengan Konten
  Examples:
  	| listSection 	|
  	| Gallery Grid	|
  	| Sass					|
    

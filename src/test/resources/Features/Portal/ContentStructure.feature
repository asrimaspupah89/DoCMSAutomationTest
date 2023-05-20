#Author: Rifatia Yumna Salma
#Description: Content Structure

@PortalContentStructure
Feature: feature to test Content Structure functionality

	@ContentStructure1
  Scenario: Content structure tampil di sidebar saat user membuka laman portal.
    Given browser opened
    When portal docms
    And fullscreen tampilan
    Then periksa keberadaan content structure
    
  @ContentStructure2
  Scenario: Content structure dapat diklik untuk menavigasikan ke section yang dipilih
    Given browser terbuka
    When buka portal docms
    And maksimalkan tampilan
    Then pilih section "Gallery Grid"
    
  @ContentStructure3
  Scenario: Content structure dapat diklik untuk menavigasikan ke section yang dipilih
    Given browser opened
    When portal docms
    And fullscreen tampilan
    Then cari judul dan subjudul pada sidebar
  
  
  
  
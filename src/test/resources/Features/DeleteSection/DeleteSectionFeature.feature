#Author: Anna Kurniaty

@DeletesectionFeature
Feature: feature untuk menguji fungsionalitas penghapusan section 

	@ValidScenario
	Scenario: Menghapus section 
	Given user berada pada halaman section
	When user menekan tombol delete pada section dengan nama <sectionName>
	Then pesan berhasil menghapus versi tampil
	
		Examples: 
		| sectionName 								|
		| select - ver na select      |
	
	

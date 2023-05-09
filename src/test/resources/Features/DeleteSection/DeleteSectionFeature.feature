#Author: Anna Kurniaty

@DeletesectionFeature
Feature: feature untuk menguji fungsionalitas penghapusan section 

	@ValidScenario
	Scenario: Menghapus section kosong
	Given user berada pada halaman manage section
	And terdapat section kosong dengan nama <sectionName>
	When user menekan tombol delete pada section dengan nama <sectionName>
	Then pesan berhasil menghapus versi tampil
	
		Examples: 
		| sectionName |
		| paw2.0      |
	
	
	xpath skip tour
	//*[@id="v-step-13c4820d"]/div[2]/button[1]
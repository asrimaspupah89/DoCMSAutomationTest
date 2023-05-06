#Author: Muhammad Fauzi Rizki Hamdalah
#Date: 18 April 2023
#Description: Membuat versi dokumentasi baru

@DeleteVersionFeature
Feature: feature untuk menguji fungsionalitas penghapusan versi dokumentasi

	@ValidScenario
	Scenario: Menghapus versi kosong
	Given user berada pada halaman manage content
	And terdapat versi kosong dengan nama <versionName>
	When user menekan tombol delete pada version dengan nama <versionName>
	Then pesan berhasil menghapus versi tampil
	
		Examples: 
		| versionName |
		| paw2.0      |
	
	@ValidScenario
	Scenario: Menghapus versi berisi satu chapter
	Given user berada pada halaman manage content
	And terdapat versi berisi satu chapter dengan nama <versionName>
	When user menekan tombol delete pada version dengan nama <versionName>
	Then pesan berhasil menghapus versi tampil
	
		Examples: 
		| versionName |
		| paw3.0      |
		
	@ValidScenario
	Scenario: Menghapus versi berisi lebih dari satu chapter
	Given user berada pada halaman manage content
	And terdapat versi berisi lebih dari satu chapter dengan nama <versionName>
	When user menekan tombol delete pada version dengan nama <versionName>
	Then pesan berhasil menghapus versi tampil
	
		Examples: 
		| versionName |
		| paw4.0      |
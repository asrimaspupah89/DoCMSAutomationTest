#Author: Muhammad Fauzi Rizki Hamdalah
#Date: 17 April 2023
#Description: Membuat versi dokumentasi baru

@AddVersionFeature
Feature: feature untuk menguji fungsionalitas pembuatan versi baru untuk dokumentasi

	@ValidScenario
	Scenario: Membuat versi dengan mengisikan nama versi
	Given user berada pada halaman manage content
	When user menekan tombol create version
	And menginputkan nama versi <versionName>
	And menekan tombol create
	Then pesan berhasil membuat versi baru tampil
	
		Examples: 
		| versionName |
		| paw1.0      |
	
	@InvalidScenario
	Scenario: Membuat versi tanpa mengisikan nama versi
	Given user berada pada halaman manage content
	When user menekan tombol create version
	Then user tidak dapat menekan tombol create
	
	@InvalidScenario
	Scenario: Membatalkan membuat versi
	Given user berada pada halaman manage content
	When user menekan tombol create version
	And user menekan tombol cancel
	Then pesan berhasil membuat versi baru tidak tampil 
	
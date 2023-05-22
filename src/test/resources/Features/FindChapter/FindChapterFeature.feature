#Anna Kurniaty
#Date
#Description
@FindChapterFeature
Feature: feature to test find chapter funcionality 

  @ValidScenario
  Scenario: check search section is successful with keyword available in database
    Given user berada pada halaman chapter
    When user menekan kolom find chapter <keyword>
    Then system show chapter

    Examples: 
      | keyword   			|
      | chapter012	    |
      
  @InvalidScenario
  Scenario: check find chapter is unsuccessful with keyword not available in database
    Given user berada pada halaman chapter
    When user menekan kolom find chapter <keyword>
    Then system show message No result found

    Examples: 
      | keyword    |
      | Video      |
      
  @InvalidScenario
  Scenario: check find chapter is unsuccessful with name author as keyword 
    Given user berada pada halaman chapter
    When user menekan kolom find chapter <keyword>
    Then system show message No result found 
    
    Examples: 
      | keyword    |
      | Annakrnt  |
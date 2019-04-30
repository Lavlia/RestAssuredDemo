Feature: This feature verifies GET operation on starships from SW universe

  Scenario: Get a list of starships from SW universe
    When User wants to get a list of starships
    Then Status code should be 200

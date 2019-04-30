Feature: This feature verifies GET operation on starships from SW universe

  @GetOperation
  Scenario Outline: Get a list of starships from SW universe
    When User wants to get a list of starships from different <pages>
    Then Status code should be 200
    Examples:
      | pages |
      | 1     |
      | 2     |
      | 3     |
      | 4     |

Feature: This feature verifies multiple GET operation on vehicles from SW universe

  @GetOperation
  Scenario: Get vehicles from SW universe
    When User wants to retrieve information about vehicles
      | id |
      | 4  |
      | 7  |
      | 14 |
    Then User response code should be 200

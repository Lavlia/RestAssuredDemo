Feature: This feature verifies POST operation on a library website

  @PostDeleteOperation
  Scenario: Add a new book in library with valid data
    When User sets the following payload and sends POST request
      | name                       | isbn | aisle | author   | id    |
      | Automated Software Testing | 333  | 03    | John Doe | 33303 |
    Then The status code should be 200
Feature: This feature verifies DELETE operation on a library website

  @PostDeleteOperation
  Scenario: Remove a book from library website
    When User wants to remove a book with valid id
    Then Response should have status code 200
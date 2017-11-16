
Feature: Testing different request on the student app
  @issue:123
  Scenario: Check if student app is accessed by users
    When User send a GET request to the list endpoint
    Then Must get back a valid status code 200

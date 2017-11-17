Feature: Testing different request on the student app

  @SMOKE
  @issue:123
  Scenario: Check if student app is accessed by users
    When User send a GET request to the list endpoint
    Then Must get back a valid status code 200


  @issue:456
  Scenario Outline: Check if student was created
    When I send POST request for student's creation with parameter <firstName>, <lastName>, <email>, <programme>, <course>
    Then New possition student <firstName> should be created
    Examples:
      | firstName | lastName | email           | programme | course |
      | test3     | test3    | test3@gmail.com | CS        | P      |
      | test4     | test4    | test4@gmail.com | F         | JS     |




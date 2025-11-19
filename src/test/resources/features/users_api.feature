Feature: Users API Testing

  Background:
    Given the JSONPlaceholder API is available

  Scenario: Get all users
    When I send a GET request to "/users"
    Then the response status code should be 200
    And the response should contain 10 users
    And each user should have complete profile information

  Scenario: Get specific user
    When I send a GET request to "/users/1"
    Then the response status code should be 200
    And the response field "id" should be 1
    And the response field "name" should be "Leanne Graham"
    And the response field "username" should be "Bret"
    And the response should have nested field "address.city"
    And the response should have nested field "company.name"

  Scenario: Get user posts
    When I send a GET request to "/users/1/posts"
    Then the response status code should be 200
    And all posts in response should have userId 1

  Scenario: Get user albums
    When I send a GET request to "/users/1/albums"
    Then the response status code should be 200
    And all albums in response should have userId 1

  Scenario: Get user todos
    When I send a GET request to "/users/1/todos"
    Then the response status code should be 200
    And all todos in response should have userId 1

  Scenario: Validate user data structure
    When I send a GET request to "/users/1"
    Then the response status code should be 200
    And the user should have valid address structure
    And the user should have valid company structure
    And the user email should be in valid format
    And the user phone should be present

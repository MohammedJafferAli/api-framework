Feature: Comments API Testing

  Background:
    Given the JSONPlaceholder API is available

  Scenario: Get all comments
    When I send a GET request to "/comments"
    Then the response status code should be 200
    And the response should contain 500 comments
    And each comment should have "postId", "id", "name", "email", and "body" fields

  Scenario: Get specific comment
    When I send a GET request to "/comments/1"
    Then the response status code should be 200
    And the response field "id" should be 1
    And the response field "postId" should be 1
    And the response should have field "name"
    And the response should have field "email"
    And the response should have field "body"

  Scenario: Get comments for specific post
    When I send a GET request to "/posts/1/comments"
    Then the response status code should be 200
    And all comments in response should have postId 1

  Scenario: Get comments with query parameter
    When I send a GET request to "/comments?postId=1"
    Then the response status code should be 200
    And all comments in response should have postId 1

  Scenario: Create new comment
    Given I load test data from "new_comment.json"
    When I send a POST request to "/comments" with body from test data
    Then the response status code should be 201
    And the response field "id" should be 501
    And the response field "postId" should be 1

  Scenario: Validate email format in comments
    When I send a GET request to "/comments/1"
    Then the response status code should be 200
    And the response field "email" should be a valid email format

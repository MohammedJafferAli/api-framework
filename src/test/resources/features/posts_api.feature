Feature: Posts API Testing

  Background:
    Given the JSONPlaceholder API is available

  Scenario: Get all posts
    When I send a GET request to "/posts"
    Then the response status code should be 200
    And the response should contain 100 posts
    And each post should have "userId", "id", "title", and "body" fields

  Scenario: Get specific post by ID
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response field "id" should be 1
    And the response field "userId" should be 1
    And the response should have field "title"
    And the response should have field "body"

  Scenario: Get non-existent post
    When I send a GET request to "/posts/999"
    Then the response status code should be 404

  Scenario: Create new post
    Given I load test data from "new_post.json"
    When I send a POST request to "/posts" with body from test data
    Then the response status code should be 201
    And the response field "id" should be 101
    And the response field "title" should be "Test Post"

  Scenario: Update existing post
    Given I load test data from "update_post.json"
    When I send a PUT request to "/posts/1" with body from test data
    Then the response status code should be 200
    And the response field "id" should be 1
    And the response field "title" should be "Updated Post"

  Scenario: Partially update post
    Given I load test data from "patch_post.json"
    When I send a PATCH request to "/posts/1" with body from test data
    Then the response status code should be 200
    And the response field "title" should be "Patched Title"

  Scenario: Delete post
    When I send a DELETE request to "/posts/1"
    Then the response status code should be 200

  Scenario Outline: Get posts by user ID
    When I send a GET request to "/posts?userId=<userId>"
    Then the response status code should be 200
    And all posts in response should have userId <userId>

    Examples:
      | userId |
      | 1      |
      | 5      |
      | 10     |

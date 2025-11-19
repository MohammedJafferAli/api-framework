Feature: JSONPlaceholder API Smoke Tests

  Background:
    Given the JSONPlaceholder API is available

  Scenario: Basic API connectivity test
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response field "id" should be 1

  Scenario: Create and verify post
    Given I load test data from "post_data.json"
    When I send a POST request to "/posts" with body from test data
    Then the response status code should be 201
    And the response field "title" should be "Test Post"

Feature: Error Handling and Edge Cases

  Background:
    Given the JSONPlaceholder API is available

  Scenario Outline: Test non-existent resource IDs
    When I send a GET request to "<endpoint>"
    Then the response status code should be 404

    Examples:
      | endpoint      |
      | /posts/999    |
      | /users/999    |
      | /comments/999 |
      | /albums/999   |
      | /todos/999    |

  Scenario Outline: Test boundary values
    When I send a GET request to "<endpoint>"
    Then the response status code should be <expectedStatus>

    Examples:
      | endpoint   | expectedStatus |
      | /posts/0   | 404           |
      | /posts/-1  | 404           |
      | /users/0   | 404           |
      | /users/-1  | 404           |

  Scenario: Test malformed JSON in POST request
    When I send a POST request to "/posts" with malformed JSON
    Then the response status code should be 400

  Scenario: Test missing required fields in POST
    When I send a POST request to "/posts" with body "{}"
    Then the response status code should be 201
    And the response should handle missing fields gracefully

  Scenario: Test invalid HTTP methods
    When I send a PATCH request to "/posts"
    Then the response status code should be 404

  Scenario: Test special characters in query parameters
    When I send a GET request to "/posts?title=test%20with%20spaces"
    Then the response status code should be 200

  Scenario: Test response time performance
    When I send a GET request to "/posts"
    Then the response status code should be 200
    And the response time should be less than 2000 milliseconds

  Scenario: Test large dataset response
    When I send a GET request to "/photos"
    Then the response status code should be 200
    And the response should contain 5000 photos
    And the response time should be less than 5000 milliseconds

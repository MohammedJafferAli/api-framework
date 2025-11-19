package com.api.framework.stepdefinitions;

import com.api.framework.actions.ApiActions;
import com.api.framework.utils.TestDataManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ApiStepDefinitions {
    private Response response;
    private Map<String, Object> testData;
    private long responseTime;

    @Given("the JSONPlaceholder API is available")
    public void the_jsonplaceholder_api_is_available() {
        // Base setup - API availability check can be added here
    }

    @Given("I load test data from {string}")
    public void i_load_test_data_from(String fileName) {
        testData = TestDataManager.loadTestData(fileName);
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        long startTime = System.currentTimeMillis();
        response = ApiActions.performGetRequest(endpoint);
        responseTime = System.currentTimeMillis() - startTime;
    }

    @When("I send a POST request to {string} with body from test data")
    public void i_send_a_post_request_with_body_from_test_data(String endpoint) {
        response = ApiActions.performPostRequest(endpoint, testData);
    }

    @When("I send a PUT request to {string} with body from test data")
    public void i_send_a_put_request_with_body_from_test_data(String endpoint) {
        response = ApiActions.performPutRequest(endpoint, testData);
    }

    @When("I send a PATCH request to {string} with body from test data")
    public void i_send_a_patch_request_with_body_from_test_data(String endpoint) {
        response = ApiActions.performPatchRequest(endpoint, testData);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = ApiActions.performDeleteRequest(endpoint);
    }

    @When("I send a POST request to {string} with malformed JSON")
    public void i_send_a_post_request_with_malformed_json(String endpoint) {
        response = ApiActions.performPostRequestWithMalformedJson(endpoint);
    }

    @When("I send a POST request to {string} with body {string}")
    public void i_send_a_post_request_with_body(String endpoint, String body) {
        response = ApiActions.performPostRequestWithStringBody(endpoint, body);
    }

    @When("I send a PATCH request to {string}")
    public void i_send_a_patch_request_to(String endpoint) {
        response = ApiActions.performPatchRequest(endpoint, "{}");
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        ApiActions.validateStatusCode(response, statusCode);
    }

    @Then("the response field {string} should be {string}")
    public void the_response_field_should_be(String fieldPath, String expectedValue) {
        ApiActions.validateResponseField(response, fieldPath, expectedValue);
    }

    @Then("the response field {string} should be {int}")
    public void the_response_field_should_be_int(String fieldPath, int expectedValue) {
        ApiActions.validateResponseField(response, fieldPath, expectedValue);
    }

    @Then("the response should contain {int} posts")
    public void the_response_should_contain_posts(int expectedCount) {
        List<Object> posts = response.jsonPath().getList("$");
        Assert.assertEquals(posts.size(), expectedCount, "Posts count mismatch");
    }

    @Then("the response should contain {int} comments")
    public void the_response_should_contain_comments(int expectedCount) {
        List<Object> comments = response.jsonPath().getList("$");
        Assert.assertEquals(comments.size(), expectedCount, "Comments count mismatch");
    }

    @Then("the response should contain {int} users")
    public void the_response_should_contain_users(int expectedCount) {
        List<Object> users = response.jsonPath().getList("$");
        Assert.assertEquals(users.size(), expectedCount, "Users count mismatch");
    }

    @Then("the response should contain {int} photos")
    public void the_response_should_contain_photos(int expectedCount) {
        List<Object> photos = response.jsonPath().getList("$");
        Assert.assertEquals(photos.size(), expectedCount, "Photos count mismatch");
    }

    @Then("each post should have {string}, {string}, {string}, and {string} fields")
    public void each_post_should_have_required_fields(String field1, String field2, String field3, String field4) {
        List<Map<String, Object>> posts = response.jsonPath().getList("$");
        for (Map<String, Object> post : posts) {
            Assert.assertTrue(post.containsKey(field1.replace("\"", "")), "Missing field: " + field1);
            Assert.assertTrue(post.containsKey(field2.replace("\"", "")), "Missing field: " + field2);
            Assert.assertTrue(post.containsKey(field3.replace("\"", "")), "Missing field: " + field3);
            Assert.assertTrue(post.containsKey(field4.replace("\"", "")), "Missing field: " + field4);
        }
    }

    @Then("each comment should have {string}, {string}, {string}, {string}, and {string} fields")
    public void each_comment_should_have_required_fields(String field1, String field2, String field3, String field4, String field5) {
        List<Map<String, Object>> comments = response.jsonPath().getList("$");
        for (Map<String, Object> comment : comments) {
            Assert.assertTrue(comment.containsKey(field1.replace("\"", "")), "Missing field: " + field1);
            Assert.assertTrue(comment.containsKey(field2.replace("\"", "")), "Missing field: " + field2);
            Assert.assertTrue(comment.containsKey(field3.replace("\"", "")), "Missing field: " + field3);
            Assert.assertTrue(comment.containsKey(field4.replace("\"", "")), "Missing field: " + field4);
            Assert.assertTrue(comment.containsKey(field5.replace("\"", "")), "Missing field: " + field5);
        }
    }

    @Then("the response should have field {string}")
    public void the_response_should_have_field(String fieldName) {
        Assert.assertTrue(response.jsonPath().get(fieldName.replace("\"", "")) != null, "Missing field: " + fieldName);
    }

    @Then("the response should have nested field {string}")
    public void the_response_should_have_nested_field(String fieldPath) {
        Assert.assertTrue(response.jsonPath().get(fieldPath.replace("\"", "")) != null, "Missing nested field: " + fieldPath);
    }

    @Then("all posts in response should have userId {int}")
    public void all_posts_should_have_userId(int expectedUserId) {
        List<Map<String, Object>> posts = response.jsonPath().getList("$");
        for (Map<String, Object> post : posts) {
            Assert.assertEquals(post.get("userId"), expectedUserId, "UserId mismatch in post");
        }
    }

    @Then("all comments in response should have postId {int}")
    public void all_comments_should_have_postId(int expectedPostId) {
        List<Map<String, Object>> comments = response.jsonPath().getList("$");
        for (Map<String, Object> comment : comments) {
            Assert.assertEquals(comment.get("postId"), expectedPostId, "PostId mismatch in comment");
        }
    }

    @Then("all albums in response should have userId {int}")
    public void all_albums_should_have_userId(int expectedUserId) {
        List<Map<String, Object>> albums = response.jsonPath().getList("$");
        for (Map<String, Object> album : albums) {
            Assert.assertEquals(album.get("userId"), expectedUserId, "UserId mismatch in album");
        }
    }

    @Then("all todos in response should have userId {int}")
    public void all_todos_should_have_userId(int expectedUserId) {
        List<Map<String, Object>> todos = response.jsonPath().getList("$");
        for (Map<String, Object> todo : todos) {
            Assert.assertEquals(todo.get("userId"), expectedUserId, "UserId mismatch in todo");
        }
    }

    @Then("the response field {string} should be a valid email format")
    public void the_response_field_should_be_valid_email(String fieldPath) {
        String email = response.jsonPath().getString(fieldPath.replace("\"", ""));
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Assert.assertTrue(Pattern.matches(emailRegex, email), "Invalid email format: " + email);
    }

    @Then("each user should have complete profile information")
    public void each_user_should_have_complete_profile() {
        List<Map<String, Object>> users = response.jsonPath().getList("$");
        for (Map<String, Object> user : users) {
            Assert.assertTrue(user.containsKey("id"), "Missing user id");
            Assert.assertTrue(user.containsKey("name"), "Missing user name");
            Assert.assertTrue(user.containsKey("username"), "Missing username");
            Assert.assertTrue(user.containsKey("email"), "Missing user email");
            Assert.assertTrue(user.containsKey("address"), "Missing user address");
            Assert.assertTrue(user.containsKey("phone"), "Missing user phone");
            Assert.assertTrue(user.containsKey("website"), "Missing user website");
            Assert.assertTrue(user.containsKey("company"), "Missing user company");
        }
    }

    @Then("the user should have valid address structure")
    public void the_user_should_have_valid_address_structure() {
        Map<String, Object> address = response.jsonPath().getMap("address");
        Assert.assertTrue(address.containsKey("street"), "Missing address street");
        Assert.assertTrue(address.containsKey("city"), "Missing address city");
        Assert.assertTrue(address.containsKey("zipcode"), "Missing address zipcode");
        Assert.assertTrue(address.containsKey("geo"), "Missing address geo");
    }

    @Then("the user should have valid company structure")
    public void the_user_should_have_valid_company_structure() {
        Map<String, Object> company = response.jsonPath().getMap("company");
        Assert.assertTrue(company.containsKey("name"), "Missing company name");
        Assert.assertTrue(company.containsKey("catchPhrase"), "Missing company catchPhrase");
        Assert.assertTrue(company.containsKey("bs"), "Missing company bs");
    }

    @Then("the user email should be in valid format")
    public void the_user_email_should_be_valid() {
        String email = response.jsonPath().getString("email");
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Assert.assertTrue(Pattern.matches(emailRegex, email), "Invalid email format: " + email);
    }

    @Then("the user phone should be present")
    public void the_user_phone_should_be_present() {
        String phone = response.jsonPath().getString("phone");
        Assert.assertNotNull(phone, "Phone number is missing");
        Assert.assertFalse(phone.trim().isEmpty(), "Phone number is empty");
    }

    @Then("the response should handle missing fields gracefully")
    public void the_response_should_handle_missing_fields_gracefully() {
        // JSONPlaceholder creates posts even with empty body, so we just verify it responds
        Assert.assertTrue(response.jsonPath().get("id") != null, "Response should contain an ID");
    }

    @Then("the response time should be less than {int} milliseconds")
    public void the_response_time_should_be_less_than(int maxTime) {
        Assert.assertTrue(responseTime < maxTime, "Response time " + responseTime + "ms exceeds limit of " + maxTime + "ms");
    }
}

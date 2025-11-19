package com.api.framework.actions;

import com.api.framework.utils.ApiClient;
import com.api.framework.utils.Logger;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiActions {

    @Step("Performing GET request to: {endpoint}")
    public static Response performGetRequest(String endpoint) {
        Logger.info("Performing GET request to: " + endpoint);
        Response response = ApiClient.get(endpoint);
        Logger.info("Response status: " + response.getStatusCode());
        Allure.addAttachment("Response Body", "application/json", response.getBody().asString());
        return response;
    }

    @Step("Performing POST request to: {endpoint}")
    public static Response performPostRequest(String endpoint, Object body) {
        Logger.info("Performing POST request to: " + endpoint);
        Allure.addAttachment("Request Body", "application/json", body.toString());
        Response response = ApiClient.post(endpoint, body);
        Logger.info("Response status: " + response.getStatusCode());
        Allure.addAttachment("Response Body", "application/json", response.getBody().asString());
        return response;
    }

    @Step("Performing PUT request to: {endpoint}")
    public static Response performPutRequest(String endpoint, Object body) {
        Logger.info("Performing PUT request to: " + endpoint);
        Allure.addAttachment("Request Body", "application/json", body.toString());
        Response response = ApiClient.put(endpoint, body);
        Logger.info("Response status: " + response.getStatusCode());
        Allure.addAttachment("Response Body", "application/json", response.getBody().asString());
        return response;
    }

    @Step("Performing PATCH request to: {endpoint}")
    public static Response performPatchRequest(String endpoint, Object body) {
        Logger.info("Performing PATCH request to: " + endpoint);
        Allure.addAttachment("Request Body", "application/json", body.toString());
        Response response = ApiClient.patch(endpoint, body);
        Logger.info("Response status: " + response.getStatusCode());
        Allure.addAttachment("Response Body", "application/json", response.getBody().asString());
        return response;
    }

    @Step("Performing DELETE request to: {endpoint}")
    public static Response performDeleteRequest(String endpoint) {
        Logger.info("Performing DELETE request to: " + endpoint);
        Response response = ApiClient.delete(endpoint);
        Logger.info("Response status: " + response.getStatusCode());
        return response;
    }

    @Step("Performing POST request with malformed JSON to: {endpoint}")
    public static Response performPostRequestWithMalformedJson(String endpoint) {
        Logger.info("Performing POST request with malformed JSON to: " + endpoint);
        Response response = ApiClient.postWithMalformedJson(endpoint);
        Logger.info("Response status: " + response.getStatusCode());
        return response;
    }

    @Step("Performing POST request with string body to: {endpoint}")
    public static Response performPostRequestWithStringBody(String endpoint, String body) {
        Logger.info("Performing POST request with string body to: " + endpoint);
        Allure.addAttachment("Request Body", "text/plain", body);
        Response response = ApiClient.postWithStringBody(endpoint, body);
        Logger.info("Response status: " + response.getStatusCode());
        Allure.addAttachment("Response Body", "application/json", response.getBody().asString());
        return response;
    }

    @Step("Validating status code. Expected: {expectedStatusCode}")
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Logger.info("Validating status code. Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code mismatch");
    }

    @Step("Validating response field: {fieldPath}")
    public static void validateResponseField(Response response, String fieldPath, Object expectedValue) {
        Object actualValue = response.jsonPath().get(fieldPath);
        Logger.info("Validating field: " + fieldPath + ". Expected: " + expectedValue + ", Actual: " + actualValue);
        Assert.assertEquals(actualValue, expectedValue, "Field value mismatch for: " + fieldPath);
    }

    @Step("Validating response time < {maxTimeMs}ms")
    public static void validateResponseTime(Response response, long maxTimeMs) {
        long responseTime = response.getTime();
        Logger.info("Validating response time. Expected: < " + maxTimeMs + "ms, Actual: " + responseTime + "ms");
        Assert.assertTrue(responseTime < maxTimeMs, "Response time exceeded limit");
    }
}

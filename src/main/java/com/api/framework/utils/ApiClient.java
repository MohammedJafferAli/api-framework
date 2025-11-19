package com.api.framework.utils;

import com.api.framework.config.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiClient {
    
    static {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
    }

    public static RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .filter(new AllureRestAssured())
                .timeout(ConfigManager.getRequestTimeout(), TimeUnit.SECONDS)
                .header("Content-Type", "application/json");
    }

    public static Response get(String endpoint) {
        return getRequestSpec().get(endpoint);
    }

    public static Response post(String endpoint, Object body) {
        return getRequestSpec().body(body).post(endpoint);
    }

    public static Response put(String endpoint, Object body) {
        return getRequestSpec().body(body).put(endpoint);
    }

    public static Response patch(String endpoint, Object body) {
        return getRequestSpec().body(body).patch(endpoint);
    }

    public static Response delete(String endpoint) {
        return getRequestSpec().delete(endpoint);
    }

    public static Response getWithParams(String endpoint, Map<String, Object> params) {
        return getRequestSpec().params(params).get(endpoint);
    }

    public static Response postWithMalformedJson(String endpoint) {
        return getRequestSpec()
                .body("{invalid json")
                .post(endpoint);
    }

    public static Response postWithStringBody(String endpoint, String body) {
        return getRequestSpec()
                .body(body)
                .post(endpoint);
    }
}

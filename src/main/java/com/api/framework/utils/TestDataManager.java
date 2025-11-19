package com.api.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class TestDataManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> loadTestData(String fileName) {
        try (InputStream input = TestDataManager.class.getClassLoader().getResourceAsStream("testdata/" + fileName)) {
            return objectMapper.readValue(input, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data: " + fileName, e);
        }
    }

    public static <T> T loadTestDataAs(String fileName, Class<T> clazz) {
        try (InputStream input = TestDataManager.class.getClassLoader().getResourceAsStream("testdata/" + fileName)) {
            return objectMapper.readValue(input, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data: " + fileName, e);
        }
    }
}

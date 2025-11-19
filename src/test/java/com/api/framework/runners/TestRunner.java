package com.api.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.api.framework.stepdefinitions"},
        plugin = {
                "pretty",
                "html:reports/html/cucumber-reports",
                "json:reports/json/Cucumber.json",
                "junit:reports/xml/Cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

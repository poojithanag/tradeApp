package com.company.tradeapp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/com/company/tradeapp",
        glue = "com.company.tradeapp",
        tags = "@test")
public class RunCukesTest {
}


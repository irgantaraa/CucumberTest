package com.juaracoding.utils;

public enum ScenarioTests {
    T1("Successful login with valid credentials"),
    T2("Failed login with invalid credentials"),
    T3("Failed login with empty username"),
    T4("Failed login with empty password"),
    // Checkout
    T5("Successfully checkout a product"),
    T6("Failed checkout due to empty checkout information");

    private String scenarioTestName;

    ScenarioTests(String value) {
        scenarioTestName = value;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }
}

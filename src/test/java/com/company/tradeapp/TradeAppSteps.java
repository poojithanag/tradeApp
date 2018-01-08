package com.company.tradeapp;

import cucumber.api.java8.En;

public class TradeAppSteps implements En {
    private TradeApp tradeApp;

    public TradeAppSteps() {
        Given("^I have the files trades and inst$", () -> {
            tradeApp = new TradeApp();
        });

        When("^I specify (.*?) and (.*?)$", (String StartDate, String EndDate) -> {
            tradeApp.setDateRange(StartDate, EndDate);
        });

        Then("^I see list of trade instruments and its volume printed in the specified date range$", () -> {
            tradeApp.filterByDateRange(true);
        });
        Then("^I see list of trade instruments and its volume printed not in the specified date range$", () -> {
            tradeApp.filterByDateRange(false);
        });
    }
}


package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.TestCasesPage;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class TestCasesTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Then("I am able to view {string} in the heading")
    public void iAmAbleToViewInTheHeading(String pageHeading) {
        Assert.assertEquals(new TestCasesPage().getPageHeadingText(),pageHeading,"Not navigated to Test Cases page,");
        log.info("Verifying page heading....");
    }
}

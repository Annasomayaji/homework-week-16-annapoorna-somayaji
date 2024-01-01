package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class PageNavigationTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);
    HomePage homePage = new HomePage();

    @When("I click on scroll up arrow")
    public void iClickOnScrollUpArrow() {
        homePage.clickOnScrollUpArrow();
        log.info("Clicking on scroll up arrow at the bottom of the page....");
    }

    @Then("I should see {string} in the carousel heading")
    public void iShouldSeeInTheCarouselHeading(String expectedHeadingTextInCarousel) {
        Assert.assertEquals(homePage.getSubPageHeadingInTopCarouselText(), expectedHeadingTextInCarousel, "Sub heading in top carousel not visible. ");
        log.info("Verifying the top carousel text....");
    }

    @When("I scroll back up the page")
    public void iScrollBackUpThePage() {
        homePage.scrollUpToTop();

    }
}

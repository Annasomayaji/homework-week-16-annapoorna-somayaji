package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class SubscriptionTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @When("I scroll down to the footer and verify the heading")
    public void iScrollDownToTheFooterAndVerifyTheHeading() {
        new HomePage().scrollDownToSubscriptionHeading();
        log.info("Scrolling down to the footer....");
    }


    @And("I am able to subscribe successfully with email {string}")
    public void iAmAbleToSubscribeSuccessfullyWithEmail(String email) {
        new HomePage().enterSubscriptionEmail(email); //append the email to random string in POM class
        new HomePage().clickOnSubscriptionSubmitButton();
        log.info("Subscribing to update....");
        Assert.assertEquals(new HomePage().getSubscriptionSuccessMessage(), "You have been successfully subscribed!", "Subscription unsuccessful.");
        log.info("Verifying success message....");
    }

    @Given("I am on {string} page")
    public void iAmOnPage(String topNavTab) throws InterruptedException {
        new HomePage().selectTabFromTopNavBar(topNavTab);
    }
}

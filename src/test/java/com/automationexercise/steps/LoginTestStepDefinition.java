package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class LoginTestStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("User is on homepage")
    public void userIsOnHomepage() {

    }

    @And("I enter {string} and {string} in the credentials to login")
    public void iEnterAndInTheCredentialsToLogin(String email, String password) {
        new LoginPage().enterLoginEmail(email);
        new LoginPage().enterPassword(password);
        new LoginPage().clickOnLoginButton();
        log.info("Login credentials entered and submitted....");

    }


    @Then("I can view {string} error message")
    public void iCanViewErrorMessage(String errorMessage) {
        Assert.assertEquals(new LoginPage().getIncorrectCredentialErrorMessageText(), errorMessage, "Error message not displayed");
        log.info("Error message verified....");
    }

    @Given("I login with valid credentials {string} and {string}")
    public void iLoginWithValidCredentialsAnd(String email, String password) {
        new LoginPage().enterLoginEmail(email);
        new LoginPage().enterPassword(password);
        new LoginPage().clickOnLoginButton();

    }
}

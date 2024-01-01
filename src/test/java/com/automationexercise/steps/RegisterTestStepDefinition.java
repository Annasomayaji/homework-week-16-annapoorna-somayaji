package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class RegisterTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("I navigated to homepage")
    public void iNavigatedToHomepage() {

    }

    @When("I observe the homepage")
    public void iObserveTheHomepage() {

    }


    @Then("I can view {string} tab is selected")
    public void iCanViewTabIsSelected(String topNavTab) {
        Assert.assertTrue(new HomePage().isTopNavTabSelected(topNavTab));
        log.info("Verifying home page....");
    }

    @When("I click on {string} from the top navigation bar")
    public void iClickOnFromTheTopNavigationBar(String topNavTab) throws InterruptedException {
        Thread.sleep(5000); //to give enough time to close the advertisement manually
        new HomePage().selectTabFromTopNavBar(topNavTab);


    }

    @Then("I should see {string} in the heading")
    public void iShouldSeeInTheHeading(String pageHeading) throws InterruptedException {
        //System.out.println("Heading: "+new LoginPage().getSighUpTitleText(pageHeading));
        Assert.assertEquals(new UtilityMethodPage().getPageHeadingText(pageHeading), pageHeading, "User not navigated to Login page page.");
        log.info("Heading text verified....");
    }


    @And("I enter following details to sign up")
    public void iEnterFollowingDetailsToSignUp(DataTable dataTable) {
        List<String> loginInfo = dataTable.asList(String.class);
        new LoginPage().enterName(loginInfo.get(0));
        new LoginPage().enterSignUpEmail(loginInfo.get(1));
        new LoginPage().clickOnSignUpButton();
        log.info("SignUp completed....");

    }

    @And("I enter following details to register")
    public void iEnterFollowingDetailsToRegister(DataTable dataTable) {
        List<String> registerInfo = dataTable.asList(String.class);
        new SignUpPage().clickOnTitleRadioButton(registerInfo.get(0));
        new SignUpPage().enterPassword(registerInfo.get(1));
        new SignUpPage().selectDateFromDropDown(registerInfo.get(2));
        new SignUpPage().selectMonthFromDropDown(registerInfo.get(3));
        new SignUpPage().selectYearFromDropDown(registerInfo.get(4));
        log.info("Details entered up to DOB....");
    }

    @And("I select newsletter and special offers checkboxes")
    public void iSelectNewsletterAndSpecialOffersCheckboxes() {
        new SignUpPage().clickOnNewsLetterCheckBox();
        new SignUpPage().clickOnOffersCheckBox();
        log.info("Check boxes clicked....");

    }

    @And("I enter following details to continue register")
    public void iEnterFollowingDetailsToContinueRegister(DataTable dataTable1) {
        List<String> registerInfo = dataTable1.asList(String.class);
        new SignUpPage().enterFirstName(registerInfo.get(0));
        new SignUpPage().enterLastName(registerInfo.get(1));
        new SignUpPage().enterAddress(registerInfo.get(2));
        new SignUpPage().selectCountryFromDropDown(registerInfo.get(3));
        new SignUpPage().enterState(registerInfo.get(4));
        new SignUpPage().enterCity(registerInfo.get(5));
        new SignUpPage().enterZipCode(registerInfo.get(6));
        new SignUpPage().enterMobileNumber(registerInfo.get(7));
        log.info("Registration information entered up to mobile number....");

    }

    @And("click on create account button")
    public void clickOnCreateAccountButton() {
        new SignUpPage().clickOnCreateAccount();
        log.info("Create account button clicked....");

    }

    @Then("I should see a success message {string}")
    public void iShouldSeeASuccessMessage(String successMessage) {
        Assert.assertEquals(new AccountCreatedPage().getPageHeading(), successMessage, "The registration unsuccessful.");
        log.info("Success message text verified....");

    }

    @When("I click on continue button")
    public void iClickOnContinueButton() {

        new AccountCreatedPage().clickOnContinueButton();


    }

    @And("I enter {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void iEnter(String name, String email, String title, String password, String date, String month, String year, String fname, String lname, String address, String country, String state, String city, String zipcode, String mobile) {
        new LoginPage().enterName(name);
        String randomString =new LoginPage().getRandomStr(5);
        //System.out.println("randomString: " + randomString);
        String randomEmail = randomString + email;
        new LoginPage().enterSignUpEmail(randomEmail);
        new LoginPage().clickOnSignUpButton();
        log.info("SignUp completed....");

        new SignUpPage().clickOnTitleRadioButton(title);
        new SignUpPage().enterPassword(password);
        new SignUpPage().selectDateFromDropDown(date);
        new SignUpPage().selectMonthFromDropDown(month);
        new SignUpPage().selectYearFromDropDown(year);
        log.info("Details entered up to DOB....");

        new SignUpPage().enterFirstName(fname);
        new SignUpPage().enterLastName(lname);
        new SignUpPage().enterAddress(address);
        new SignUpPage().selectCountryFromDropDown(country);
        new SignUpPage().enterState(state);
        new SignUpPage().enterCity(city);
        new SignUpPage().enterZipCode(zipcode);
        new SignUpPage().enterMobileNumber(mobile);
        log.info("Registration information entered up to mobile number....");


    }


    @Then("I can view {string} {string} tab is visible")
    public void iCanViewTabIsVisible(String text, String userName) {
        String loggedInText = new HomePage().isLoggedInAsUserNameTabDisplayed();
        Assert.assertEquals(loggedInText, text + " " + userName, "Logged in as User is not displayed.");
        log.info("The login status verified....");
    }


    @And("I click on Continue button in Account deleted page")
    public void iClickOnContinueButtonInAccountDeletedPage() {
        new AccountDeletedPage().clickOnContinueButton();
        log.info("Continue button clicked....");
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        Assert.assertEquals(new SignUpPage().getExistingEmailErrorMessageText(), errorMessage, "Error message not displayed.");
        log.info("Error message verified....");
    }

    @And("I sign up with {string} and existing email {string}")
    public void iSignUpWithAndExistingEmail(String name, String email) {
        new LoginPage().enterName(name);
        new LoginPage().enterSignUpEmail(email);
        new LoginPage().clickOnSignUpButton();
        log.info("Verifying error message....");
    }
}

package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ContactUsTestStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);


    @Given("I am on {string} page and van view {string} heading")
    public void iAmOnPageAndVanViewHeading(String topNavTab, String heading) throws InterruptedException {
        new HomePage().selectTabFromTopNavBar(topNavTab);
        Assert.assertEquals(new ContactUsPage().getGetInTouchHeadingText(),heading,"Not navigated to contact us page.");
        log.info("Selecting navigation tab and verifying navigated page....");
    }


    @When("I provide information {string}, {string}, {string}, {string}, {string} on the form and submit")
    public void iProvideInformationOnTheFormAndSubmit(String name, String email, String subject, String message, String filePath) {
        new ContactUsPage().enterName(name);
        new ContactUsPage().enterEmail(email);
        new ContactUsPage().enterSubject(subject);
        new ContactUsPage().enterMessage(message);
        new ContactUsPage().sendFileThroughChooseFile(filePath);
        new ContactUsPage().clickOnSubmitButton();
        new ContactUsPage().handleAlertPopUp();
        log.info("Submitting contact form....");

    }

    @Then("I should be able to view the success message {string}")
    public void iShouldBeAbleToViewTheSuccessMessage(String successMessage) {
        Assert.assertEquals(new ContactUsPage().getSuccessMessageText(), successMessage, "form not submitted.");
        log.info("verifying success message....");

    }


    @When("I click on Home button")
    public void iClickOnHomeButton() {
        new ContactUsPage().clickOnHomeButton();
        log.info("Clicking on home button....");
    }

    @When("I provide information {string}, {string}, {string}, {string}, {string} and submit")
    public void iProvideInformationAndSubmit(String name, String email, String subject, String message, String filePath) throws AWTException {
        new ContactUsPage().enterName(name);
        new ContactUsPage().enterEmail(email);
        new ContactUsPage().enterSubject(subject);
        new ContactUsPage().enterMessage(message);
       // new ContactUsPage().sendFileThroughChooseFile(filePath);

        //File upload using ROBOT class
        // creating object of Robot class
        Robot rb = new Robot();

        //Copying file path to clipboard
        StringSelection str=new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress((KeyEvent.VK_ENTER));
        rb.keyRelease(KeyEvent.VK_ENTER);

        new ContactUsPage().clickOnSubmitButton();
        new ContactUsPage().handleAlertPopUp();
        log.info("Submitting contact form....");
    }
}

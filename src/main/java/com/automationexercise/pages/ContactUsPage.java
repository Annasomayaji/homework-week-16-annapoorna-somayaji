package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends Utility {

    //Elements

    @CacheLookup
    @FindBy(name = "name")
    WebElement nameField;

    @CacheLookup
    @FindBy(name = "email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "message")
    WebElement messageField;
    @CacheLookup
    @FindBy(name = "subject")
    WebElement subjectField;
    @CacheLookup
    @FindBy(name = "upload_file")
    WebElement uploadFileButton;
    @CacheLookup
    @FindBy(name = "submit")
    WebElement submitButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "(//h2[@class='title text-center'])[2]")
    WebElement getInTouchHeading;




    //Methods

    public void enterName(String name) {
        sendTextToElement(nameField, name);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);

    }

    public void enterSubject(String subject) {
        sendTextToElement(subjectField, subject);
    }

    public void enterMessage(String message) {
        sendTextToElement(messageField, message);
    }

    public void sendFileThroughChooseFile(String path){
        sendTextToElement(uploadFileButton,path);
    }

    public void clickOnSubmitButton(){
        clickOnElement(submitButton);
    }

    public String getSuccessMessageText(){
        return getTextFromElement(successMessage);
    }

    public String getGetInTouchHeadingText(){
        return getTextFromElement(getInTouchHeading);
    }

    public void clickOnHomeButton(){
        clickOnElement(homeButton);
    }
    public void handleAlertPopUp(){
        acceptAlert();
    }
}

package com.automationexercise.pages;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    //Elements
    @CacheLookup
    // @FindBy(xpath = "//div[@class='signup-form']/h2")
    @FindBy(xpath = "//div[@class='row']//h2 ")
    List<WebElement> pageTitles;

    @CacheLookup
    @FindBy(name = "name")
    WebElement nameField;
    @CacheLookup
    @FindBy(xpath = "//form[@action='/signup']//input[@name='email']")
    WebElement signUpEmailField;
    @CacheLookup
    @FindBy(xpath = "//form[@action='/login']//input[@name='email']")
    WebElement loginEmailField;
    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signUpButton;
   @CacheLookup
    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;
   @CacheLookup
    @FindBy(xpath = "//form[@action='/login']/p")
    WebElement incorrectCredentialMessage;


    //Methods

    /**
     * This method verifies all headings on the Login page based on the parameter passed
     */
//    public String getSighUpTitleText(String heading) {
//        String titleText = null;
//        for (WebElement title : pageTitles) {
//            if (title.getText().contains(heading)) {
//                titleText = title.getText();
//                break;
//            }
//        }
//        return titleText;
//    }



    public void enterName(String name) {
        sendTextToElement(nameField, name);
    }

    public void enterSignUpEmail(String email) {
        String randomString=getRandomString(4);
        String randomEmail=randomString+email;
        sendTextToElement(signUpEmailField, randomEmail);
    }
    public String getRandomStr(int length){
        return getRandomString(length);
    }

    public void enterLoginEmail(String email) {
        sendTextToElement(loginEmailField, email);
    }

    public void enterPassword(String pwd) {
        sendTextToElement(password, pwd);
    }


    public void clickOnSignUpButton() {
        signUpButton.submit();
    }
   public void clickOnLoginButton() {
        loginButton.submit();
    }

    public String getIncorrectCredentialErrorMessageText(){
        return getTextFromElement(incorrectCredentialMessage);
    }

}

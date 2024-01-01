package com.automationexercise.pages;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Utility {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    //Elements
    @CacheLookup
    @FindBy(xpath = "//h2/b")
    WebElement pageHeading;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;


    //Methods
    public String getPageHeading() {
        log.info("Getting the page heading....");
        return getTextFromElement(pageHeading);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }


}

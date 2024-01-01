package com.automationexercise.pages;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends Utility {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);


    //Elements

    @CacheLookup
    @FindBy(xpath = "//h2/b")
    WebElement pageHeading;


    //Methods
    public String getPageHeadingText() {
        return getTextFromElement(pageHeading);
    }

}

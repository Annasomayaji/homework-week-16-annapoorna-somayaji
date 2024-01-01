package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UtilityMethodPage extends Utility {

    /**
     * This page contains elements and methods that are shared across multiple web pages.
     */

    //Elements
    @CacheLookup
    // @FindBy(xpath = "//div[@class='signup-form']/h2")
    @FindBy(xpath = "//div[@class='row']//h2 ")
    List<WebElement> pageTitles;





    //Methods
    public String getPageHeadingText(String heading) throws InterruptedException {
        Thread.sleep(5000); //Thread sleep given to give enough time to close ads manually
        return getPageTitleText(heading, pageTitles);  //Utility method
    }


}

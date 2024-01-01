package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;



    //Methods
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }

}

package com.automationexercise.pages;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends Utility {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    //Elements
    @CacheLookup
    @FindBy(xpath = "//h2/b[text()[contains(.,'Account')]]")
    WebElement pageHeading;

    @CacheLookup
    @FindBy(xpath = "//div[@class='clearfix']/div[@class='radio-inline']//span/input")
    List<WebElement> titleRadioButtons;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "days")
    WebElement dateDropDown;
    @CacheLookup
    @FindBy(id = "months")
    WebElement monthDropDown;
    @CacheLookup
    @FindBy(id = "years")
    WebElement yearDropDown;
    @CacheLookup
    @FindBy(id = "newsletter")
    WebElement newsLetterCheckBox;
    @CacheLookup
    @FindBy(id = "optin")
    WebElement offersCheckBox;
    @CacheLookup
    @FindBy(id = "first_name")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "last_name")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address;

    @CacheLookup
    @FindBy(id = "country")
    WebElement countryDropDown;

    @CacheLookup
    @FindBy(id = "state")
    WebElement state;
    @CacheLookup
    @FindBy(id = "city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "zipcode")
    WebElement zipCode;
    @CacheLookup
    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(xpath = "//form[@action='/signup']/p")
    WebElement existingEmailErrorMessage;



    //Methods
    public String getPageHeading() {
        return getTextFromElement(pageHeading);
    }

    public void clickOnTitleRadioButton(String text) {
        for (WebElement radioButton : titleRadioButtons) {
            if (radioButton.getAttribute("value").contains(text)) {
                radioButton.click();
                break;
            }
        }
    }

    public void enterPassword(String pWord) {
        sendTextToElement(password, pWord);
    }

    public void selectDateFromDropDown(String date) {
        Select select = new Select(dateDropDown);
        select.selectByVisibleText(date);
    }

    public void selectMonthFromDropDown(String month) {
        Select select = new Select(monthDropDown);
        select.selectByVisibleText(month);
    }

    public void selectYearFromDropDown(String year) {
        Select select = new Select(yearDropDown);
        select.selectByVisibleText(year);
    }

    public void clickOnNewsLetterCheckBox() {
        newsLetterCheckBox.click();
    }

    public void clickOnOffersCheckBox() {
        offersCheckBox.click();
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        sendTextToElement(lastName, lName);
    }

    public void enterAddress(String add) {
        sendTextToElement(address, add);
    }

    public void selectCountryFromDropDown(String country) {
        Select select = new Select(countryDropDown);
        select.selectByVisibleText(country);
    }

    public void enterState(String st) {
        sendTextToElement(state, st);
    }

    public void enterCity(String cty) {
        sendTextToElement(city, cty);
    }

    public void enterZipCode(String zip) {
        sendTextToElement(zipCode, zip);
    }

    public void enterMobileNumber(String mobile) {
        sendTextToElement(mobileNumber, mobile);
    }

    public void clickOnCreateAccount(){
        clickOnElement(createAccountButton);
    }

    public String getExistingEmailErrorMessageText(){
        return getTextFromElement(existingEmailErrorMessage);
    }


}

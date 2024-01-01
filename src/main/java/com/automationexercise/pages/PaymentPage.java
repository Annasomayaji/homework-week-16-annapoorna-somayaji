package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(name = "name_on_card")
    WebElement nameOnCard;
    @CacheLookup
    @FindBy(name = "card_number")
    WebElement cardNumber;
    @CacheLookup
    @FindBy(name = "cvc")
    WebElement cvcField;
    @CacheLookup
    @FindBy(name = "expiry_month")
    WebElement expiryMonth;
    @CacheLookup
    @FindBy(name = "expiry_year")
    WebElement expiryYear;

    @CacheLookup
    @FindBy(id= "submit")
    WebElement confirmOrderButton;


    //Methods

    public void enterNameOnCard(String name) {
        sendTextToElement(nameOnCard, name);
    }

    public void enterCardNumber(String cardNum) {
        sendTextToElement(cardNumber, cardNum);
    }

    public void enterCVC(String cvc) {
        sendTextToElement(cvcField, cvc);
    }

    public void enterExpiryMonth(String month) {
        sendTextToElement(expiryMonth, month);
    }

    public void enterExpiryYear(String year) {
        sendTextToElement(expiryYear, year);
    }

    public void confirmOrder(){
        clickOnElement(confirmOrderButton);
    }
}

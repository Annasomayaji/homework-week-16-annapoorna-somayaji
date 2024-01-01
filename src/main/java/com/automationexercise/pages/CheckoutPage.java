package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//ul[@id='address_delivery']/li")
    List<WebElement> addressInfo;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='address_invoice']/li")
    List<WebElement> billingAddressInfo;

    @CacheLookup
    @FindBy(xpath = "//tr[@id='product-2']/td/p")
    List<WebElement> orderInfo;

    @CacheLookup
    @FindBy(xpath = "//tr[@id='product-2']/td/button")
    WebElement orderQuantity;
    @CacheLookup
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentTextArea;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;


    //Methods
    public List<String> getAddressLines() {
        List<String> allAddressLines = new ArrayList<>();
        for (WebElement addressLine : addressInfo) {
            if (!addressLine.getText().isEmpty()) {
                allAddressLines.add(addressLine.getText());
            }
        }
        return allAddressLines;
    }
    public List<String> getBillingAddressLines() {
        List<String> allBillingAddressLines = new ArrayList<>();
        for (WebElement addressLine : billingAddressInfo) {
            if (!addressLine.getText().isEmpty()) {
                allBillingAddressLines.add(addressLine.getText());
            }
        }
        return allBillingAddressLines;
    }

    public List<String> getorderInfo() {
        List<String> orderDetails = new ArrayList<>();
        for (WebElement order : orderInfo) {
            if (!order.getText().isEmpty()) {
                orderDetails.add(order.getText());
            }
        }
        orderDetails.add(orderQuantity.getText());
        return orderDetails;
    }

    public void enterComment(String comment){
        sendTextToElement(commentTextArea,comment);
    }

    public void clickOnPlaceOrder(){
        clickOnElement(placeOrderButton);
    }

}

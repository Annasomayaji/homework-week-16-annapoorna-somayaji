package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class PaymentDonePage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//b[text()='Order Placed!']")
    WebElement orderPlacedHeading;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Download Invoice']")
    WebElement downloadInvoiceButton;


    //Methods
    public String getOrderSuccessMessageTExt() {
        return getTextFromElement(orderPlacedHeading);
    }

    public void clickOnDownloadInvoice(){
        clickOnElement(downloadInvoiceButton);
    }

    public boolean isInvoiceDownloaded(String fileName) {
        boolean flag = false;
        String downloadPath = "C:\\Users\\annus\\Downloads";
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
                if (file.getName().equalsIgnoreCase(fileName)) {
                    flag = true;
                    break;
                }
            }
        return flag;
    }

}

package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsPage extends Utility {

    //Elements

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']")
    WebElement productInformationPanel;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement productHeading;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/p")
    List<WebElement> productDetails;


    @CacheLookup
    @FindBy(id = "quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement price;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add to cart']\t")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Write Your Review']")
    WebElement reviewHeading;

    @CacheLookup
    @FindBy(id = "name")
    WebElement yourNameForReviewField;
    @CacheLookup
    @FindBy(id = "email")
    WebElement emailAddressForReviewField;

    @CacheLookup
    @FindBy(id = "review")
    WebElement addReviewField;
    @CacheLookup
    @FindBy(id = "button-review")
    WebElement submitReviewButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']/span")
    WebElement reviewSuccess;





    //Methods

    public boolean isProductInfoPanelVisible() {
        return productInformationPanel.isDisplayed();
    }

    public String getProductHeading() {
        return getTextFromElement(productHeading);
    }

    public String getProductPrice() {
        return getTextFromElement(price);
    }

    /**
     *This method gets the texts from list os WebElements and returns them as array list
     */
    public List<String> getProductDetails(){
        List<String> detailsList=new ArrayList<>();
        for(WebElement detail:productDetails){
            detailsList.add(getTextFromElement(detail));
        }
        return detailsList;
    }

    public void increaseQuantity(String qty){
        //Clear the text in the quantity field (using keyboard methods of Actions class) and enter new quantity
        selectAndClearInputField(quantity); //calling Actions method in Utility class to clear the field

        //actions.sendKeys("d");
        sendTextToElement(quantity,qty);

    }
    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }

    public String getWriteAReviewHeadingText(){
        return reviewHeading.getText();
    }

    public void enterNameInReview(String name){
        sendTextToElement(yourNameForReviewField,name);
    }

    public void enterEmailInReview(String email){
        sendTextToElement(emailAddressForReviewField,email);
    }

    public void enterReviewMessage(String review){
        sendTextToElement(addReviewField,review);
    }

    public void clickOnSubmit(){
        clickOnElement(submitReviewButton);
    }

    public String getReviewSuccessMessageText(){
        return getTextFromElement(reviewSuccess);
    }
}

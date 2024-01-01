package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@class='single-products']")
    List<WebElement> allProducts;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']")
    List<WebElement> addToCartButtonsOnHover;

    @CacheLookup
    @FindBy(xpath = "//div[@class='choose']")
    List<WebElement> viewProductLinks;
    @CacheLookup
    @FindBy(id = "search_product")
    WebElement searchField;
    @CacheLookup
    @FindBy(id = "submit_search")
    WebElement searchSubmitButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingButton;

    @CacheLookup
    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement viewCartButton;


    //Methods

    /**
     * This method clicks on the 'view product' link of the product sent in the parameter
     * First, It gets the item number in string format in the parameter and replaces all the chars and parses
     * Then, It clicks on the item
     */
    public void clickOnViewProductLink(String itemNumber) throws NumberFormatException {
        //System.out.println("Item String: "+ itemNumber.replaceAll("[a-zA-Z]",""));
        int item = Integer.parseInt(itemNumber.replaceAll("[a-zA-Z]", ""));
        // System.out.println("item: "+item);
        clickOnElement(viewProductLinks.get(item - 1)); // item-1 because index starts from 0 for arrayList
    }


    public void enterSearchProduct(String productName) {
        sendTextToElement(searchField, productName);
    }

    public void clickOnSubmitButton() {
        clickOnElement(searchSubmitButton);
    }

    public void hoverAndClickOnProduct(String itemNumber){
        //System.out.println("Item String: "+ itemNumber.replaceAll("[a-zA-Z]",""));
        int item=Integer.parseInt(itemNumber.replaceAll("[a-zA-Z]",""));

        mouseHoverToElement(allProducts.get(item-1));// item-1 because index starts from 0 for arrayList

        //use JavaScript Executor to click on element that might be hidden
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",addToCartButtonsOnHover.get(item-1));
        //clickOnElement(addToCartButtonsOnHover.get(item-1));
    }

    public void clickOnContinueShoppingButton(){
        clickOnElement(continueShoppingButton);
    }

    public void clickOnViewCartButton(){
        clickOnElement(viewCartButton);
    }

}

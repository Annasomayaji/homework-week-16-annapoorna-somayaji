package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ViewCartPage extends Utility {

    //Elements

    @CacheLookup
    @FindBy(xpath = "//td/h4/a")
    List<WebElement> productsInCart;
    @CacheLookup
    @FindBy(xpath = "//tr/td/h4/a")
    List<WebElement> productsDescriptionInCart;

    @CacheLookup
    @FindBy(xpath = "//td[@class='cart_price']/p")
    List<WebElement> priceInCart;

    @CacheLookup
    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    List<WebElement> quantityInCart;

    @CacheLookup
    @FindBy(xpath = "//td[@class='cart_total']/p")
    List<WebElement> totalPriceInCart;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr/td[4]")
    List<WebElement> quantityFieldOfProducts;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement proceedToCheckOutButton;
    @CacheLookup
    @FindBy(xpath = "//u[text()='Register / Login']")
    WebElement registerOrLoginButton;

    @CacheLookup
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement deleteItemButton;

    @CacheLookup
    @FindBy(xpath = "//tbody//td/h4/a")
    List<WebElement> prodcutsInCart;


    //Methods

    public int getTotalNumberOfProducts() {
        return productsInCart.size(); //returns the number of products currently in the cart
    }

    public List<String> getProductDetails(int index) {
        List<String> productDetails = new ArrayList<>();
        productDetails.add(getTextFromElement(productsInCart.get(index)));
        productDetails.add(getTextFromElement(priceInCart.get(index)));
        productDetails.add(getTextFromElement(quantityInCart.get(index)));
        productDetails.add(getTextFromElement(totalPriceInCart.get(index)));
        return productDetails;
    }

    public String getProductInCart(int index) {
        return getTextFromElement(productsInCart.get(index));
    }


    public void getProductName(){

    }


    public String getQuantityInCart(String nameOfProduct) {

        int loopCount=0;
        for(WebElement products:productsDescriptionInCart){
            if(products.getText().equalsIgnoreCase(nameOfProduct)){
                loopCount++;
              break;
            }

        }

        //here 'loopCount' has the row number for us to get quantity text from
        return quantityFieldOfProducts.get(loopCount-1).getText();

    }

    public void clickOnProceedToCheckOut(){
        clickOnElement(proceedToCheckOutButton);
    }
    public void clickOnRegisterOrLogin(){
        clickOnElement(registerOrLoginButton);
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteItemButton);
    }

    /**
     *This method gets the product name we are looking for from excel
     * The product had been deleted from cart
     * The method will look through all the products in the cart
     * If the product looking for is found, it is added to arraylist
     * if none found array list returns empty.  If it is empty, it confirms product deletion from cart
     */
    public boolean isProductDeleted(String productName){
        driver.navigate().refresh();
        List<String> str=new ArrayList<>();
        System.out.println("Products in cart: "+ productsInCart);
        for(WebElement product:prodcutsInCart){
            if(product.getText().equalsIgnoreCase(productName)){
                System.out.println("product name: "+product.getText());
               str.add(product.getText());
            }
        }
        return str.isEmpty();
    }

}

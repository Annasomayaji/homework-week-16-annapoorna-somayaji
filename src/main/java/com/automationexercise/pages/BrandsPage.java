package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandsPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy (xpath = "//div[@class='brands-name']//li/a")
    List<WebElement> brands;
  @CacheLookup
    @FindBy (xpath = "//div[@class='single-products']")
    List<WebElement> productsDisplayedUnderBrand;





    //Methods
    public void selectTheBrand(String brandName){

        for(WebElement brand:brands){
          //  System.out.println("Brand name text: "+ brand.getText()); //debug purpose
            if(brand.getText().contains(brandName)){
                waitUntilElementIsClickable(brand,5); //to avoid getting StaleElementException
                brand.click();
            }
        }
    }

    public boolean AreProductsDisplayedUnderBrand(){
        return (!productsDisplayedUnderBrand.isEmpty()); //returns true if products are displayed
    }


}

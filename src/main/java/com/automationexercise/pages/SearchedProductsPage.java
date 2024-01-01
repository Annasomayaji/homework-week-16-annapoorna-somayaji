package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchedProductsPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'/category_products')]")
    List<WebElement> searchCategories;  //on the left side panel of web page
    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> individualCategory; //items in individual category such as Dress, Tops etc

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> searchResults;  //result of initial search on product page


    //Methods

    //getting the result of initial search  and storing in an arrayList to compare
    public ArrayList<String> getSearchResults(){
        ArrayList<String> allSearchResult=new ArrayList<>();
        for (WebElement e:searchResults){
            allSearchResult.add(e.getText());
        }
        return allSearchResult;
    }

    /**
     *This method gets the items from search term from different categories and
     * compares whether the initial search result contains all the items from matching categories
     *
     * Currently, the method retains the items from initial search result in an array list
     * And the items of the matching search category from the left panel in another array list.
     * However, the assertion is failing
     */

    public ArrayList<String> getProductCategoryText(String searchTerm , ArrayList<String> allSearchResults) throws InterruptedException {
        ArrayList<String> productCategories = new ArrayList<>();
        for (WebElement category : searchCategories) {
            //  System.out.println("category: "+ category.getText());   ----->getText() does not work as the category element is hidden
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String s = (String) js.executeScript("return jQuery(arguments[0]).text();", category);
            if (s.toLowerCase().contains(searchTerm)) {  //if any left side panel category matches the search term, click on that category
                System.out.println("category: " + s);
                productCategories.add(s);
                js.executeScript("arguments[0].click()", category);

                ArrayList<String> itemList=new ArrayList<>();
                for(WebElement singleItem:individualCategory){
                   itemList.add(singleItem.getText());
                } //store the items in that category

                System.out.println("all search Result: "+allSearchResults);//debug purpose
                System.out.println("itemList: "+itemList);//debug purpose


                Assert.assertTrue(allSearchResults.containsAll(itemList)); //Comparing initial search result with product category items
                Thread.sleep(5000);
                driver.navigate().back(); //going back to loop because some search terms are in more than one category
                                            //example: 'dress' search term is in both 'Women' and 'Kids' category
            }

        }
        return productCategories;
    }

//    public void clickOnCategory(String category){
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript()
//    }


}

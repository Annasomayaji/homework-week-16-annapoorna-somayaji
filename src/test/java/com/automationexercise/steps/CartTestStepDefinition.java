package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.excelutility.ExcelReader;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.pages.ViewCartPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CartTestStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    HomePage homePage = new HomePage();

    @And("I add {string} item to cart continue shopping")
    public void iAddItemToCartContinueShopping(String itemNumber) {
        new ProductsPage().hoverAndClickOnProduct(itemNumber);
        new ProductsPage().clickOnContinueShoppingButton();
        log.info("Adding item to cart and continuing shopping....");

    }

    @And("I add {string} item to cart")
    public void iAddItemToCart(String itemNumber) {
        new ProductsPage().hoverAndClickOnProduct(itemNumber);
        new ProductsPage().clickOnViewCartButton();
        log.info("Adding item to cart and clicking on view cart button....");

    }


    @Then("I am able to see the right products with product name , price , quantity and total price in the cart")
    public void iAmAbleToSeeTheRightProductsWithProductNamePriceQuantityAndTotalPriceInTheCart(DataTable dataTable) {
        List<List<String>> productDetails = dataTable.asLists(String.class);
        System.out.println("expected product details: " + productDetails);
        SoftAssert softAssert = new SoftAssert();
        int index = 0;
        for (List<String> rowOfProduct : productDetails) { //3 rows

            //getting individual product in cart
            List<String> pDetails = new ViewCartPage().getProductDetails(index); //actual product details in the cart
            System.out.println("individual row in expected: " + rowOfProduct);
            System.out.println("individual row in cart: " + pDetails);

            //comparing with individual row of expected product details to actual product details
            // Assert.assertTrue(pDetails.containsAll(rowOfProduct), "Product in the cart does not match");
            Assert.assertEquals(rowOfProduct, pDetails, "Product in the cart does not match");
            // Assert.assertEquals(new ViewCartPage().getProductInCart(index++),rowOfProduct.get(0),"Product name is incorrect.");

        }

        log.info("Verifying the cart....");

    }

    @When("I increase quantity to number {string} and add")
    public void iIncreaseQuantityToNumberAndAdd(String quantity) {
        new ProductDetailsPage().increaseQuantity(quantity);
        new ProductDetailsPage().clickOnAddToCartButton();
        log.info("Increasing quantity and adding....");

    }

    @And("I view cart")
    public void iViewCart() {
        new ProductsPage().clickOnViewCartButton();
        log.info("Clicking on view cart button in success message....");
    }

    @Then("I can see quantity number {string} for product name {string} in the cart for the product")
    public void iCanSeeQuantityNumberForProductNameInTheCartForTheProduct(String quantity, String nameOfTheProductAdded) {
        String actualQuantity = new ViewCartPage().getQuantityInCart(nameOfTheProductAdded);
        log.info("Fetching the quantity of the required row in cart....");
        Assert.assertEquals(actualQuantity, quantity, "Quantity in the cart is incorrect.");
        log.info("Verifying quantity field....");
    }


    @When("I select a product to add to cart from sheet name {string} and row number {string}")
    public void iSelectAProductToAddToCartFromSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException {

        HomePage homePage = new HomePage();
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/products-to-add-data.xlsx", sheetName);
        String productName = testdata.get(Integer.parseInt(rowNumber)).get("productname");
        log.info("Obtaining test data from excel sheet....");

        //This line returns where was the product in the list os products
        int count = new HomePage().getProductToAdd(productName);
        log.info("Finding the required product....");
        //This line clicks on the corresponding 'add to cart' button based on the product select
        homePage.clickOnAddToCartButton(count);
        log.info("Clicking on add to cart button....");


    }

    @And("I click on delete item icon")
    public void iClickOnDeleteItemIcon() {
        new ViewCartPage().clickOnDeleteButton();
        log.info("Clicking on delete item icon....");
    }


    @Then("I can see that the product from sheet name {string} and row number {string} is removed")
    public void iCanSeeThatTheProductFromSheetNameAndRowNumberIsRemoved(String sheetName, String rowNumber) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/products-to-add-data.xlsx", sheetName);
        String productName = testdata.get(Integer.parseInt(rowNumber)).get("productname");
        log.info("Obtaining test data from excel sheet....");
        Assert.assertTrue(new ViewCartPage().isProductDeleted(productName), "Product is still in the cart");
        log.info("Verifying product is deleted....");
    }

    @And("I enter product name to search from sheet name {string} and row number {string}")
    public void iEnterProductNameToSearchFromSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/search-and-add-ExcelData.xlsx", sheetName);
        String searchTerm = testdata.get(Integer.parseInt(rowNumber)).get("searchTerms");
        new ProductsPage().enterSearchProduct(searchTerm);
        new ProductsPage().clickOnSubmitButton();
        log.info("Searching products....");
    }

    @When("I select a product to add to cart from from the search result sheet name {string} and row number {string}")
    public void iSelectAProductToAddToCartFromFromTheSearchResultSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException {
        HomePage homePage = new HomePage();
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/search-and-add-ExcelData.xlsx", sheetName);
        String productName = testdata.get(Integer.parseInt(rowNumber)).get("productname");
        log.info("Obtaining test data from excel sheet....");

        //This line returns where was the product in the list os products
        int count = new HomePage().getProductToAdd(productName);
        log.info("Finding the required product....");
        //This line clicks on the corresponding 'add to cart' button based on the product select
        homePage.clickOnAddToCartButton(count);
        log.info("Clicking on add to cart button....");

    }


    @When("I scroll to recommended items and add an item {string}")
    public void iScrollToRecommendedItemsAndAddAnItem(String productName) {

        //scroll to recommended items
        new HomePage().scrollDownToRecommendedItems();
        log.info("Scrolling down to recommended products....");
        homePage.hoverOnRecommendedItem(productName);
        log.info("Hovering on the product and clicking on add to cart button...");

    }
}

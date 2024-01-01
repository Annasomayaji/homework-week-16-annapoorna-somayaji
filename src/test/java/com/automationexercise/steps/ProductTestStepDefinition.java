package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.excelutility.ExcelReader;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.pages.SearchedProductsPage;
import com.automationexercise.pages.UtilityMethodPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductTestStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @When("I click on the {string} item")
    public void iClickOnTheItem(String itemNumber) {
        new ProductsPage().clickOnViewProductLink(itemNumber);
        log.info("Clicking on 'view product' link....");
    }

    @Then("I am on product information page")
    public void iAmOnProductInformationPage() {
        Assert.assertTrue(new ProductDetailsPage().isProductInfoPanelVisible(), "Not navigated to product detail page.");
        log.info("Verifying product detail page is displayed....");
    }


    @And("I can view product details from sheet name {string} and row number {string}")
    public void iCanViewProductDetailsFromSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/exceldata.xlsx", sheetName);
        String productName = testdata.get(Integer.parseInt(rowNumber)).get("productname");
        Assert.assertEquals(new ProductDetailsPage().getProductHeading(), productName, "Product name does not match");

        String productPrice = testdata.get(Integer.parseInt(rowNumber)).get("price");
        Assert.assertEquals(new ProductDetailsPage().getProductPrice(), productPrice, "Price does not match");

        String category = testdata.get(Integer.parseInt(rowNumber)).get("category");
        // String price = testdata.get(Integer.parseInt(rowNumber)).get("price");
        String availability = testdata.get(Integer.parseInt(rowNumber)).get("availability");
        String condition = testdata.get(Integer.parseInt(rowNumber)).get("condition");
        String brand = testdata.get(Integer.parseInt(rowNumber)).get("brand");

        List<String> productsDetailsExpected = new ArrayList<>();
        productsDetailsExpected.add(0, category);
        productsDetailsExpected.add(1, availability);
        productsDetailsExpected.add(2, condition);
        productsDetailsExpected.add(3, brand);

        List<String> productDetailsActual = new ProductDetailsPage().getProductDetails();

        Assert.assertEquals(productsDetailsExpected, productDetailsActual, "Details do not match.");
        log.info("Verifying product details on the products page....");
    }

    /**
     * This method gets the search terms from excel data sheet and enters them in search field
     */
    @And("I enter product name from sheet name {string} and row number {string}")
    public void iEnterProductNameFromSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/searchExcelData.xlsx", sheetName);
        String searchTerm = testdata.get(Integer.parseInt(rowNumber)).get("searchTerms");
        new ProductsPage().enterSearchProduct(searchTerm);
        new ProductsPage().clickOnSubmitButton();
        log.info("Searching products....");
    }


    @Then("I am able to view the {string} in the result")
    public void iAmAbleToViewTheInTheResult(String searchedProductsHeading) throws InterruptedException {
        Assert.assertEquals(new UtilityMethodPage().getPageHeadingText(searchedProductsHeading), searchedProductsHeading, "The searched products heading not displayed.");
        log.info("Verifying searched products page heading....");
    }


    @And("I can view the products related to search from sheet name {string} and row number {string}")
    public void iCanViewTheProductsRelatedToSearchFromSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException, InterruptedException {
        ArrayList<String> allSearchResults = new SearchedProductsPage().getSearchResults();
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/searchExcelData.xlsx", sheetName);
        String searchTerm = testdata.get(Integer.parseInt(rowNumber)).get("searchTerms");
        System.out.println((new SearchedProductsPage().getProductCategoryText(searchTerm, allSearchResults)));
//        ArrayList<String> productCategory=new SearchedProductsPage().getProductCategoryText(searchTerm);
//        for (String category : productCategory) {
//
//        }
    }

    @Then("I should see {string} is visible")
    public void iShouldSeeIsVisible(String reviewHeading) {
        Assert.assertEquals(new ProductDetailsPage().getWriteAReviewHeadingText(), reviewHeading, "Write a Review is not displayed.");
        log.info("Verifying Write a review element....");
    }

    @When("I submit review with name {string}, email {string}, review message {string}")
    public void iSubmitReviewWithNameEmailReviewMessage(String name, String email, String reviewMessage) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.enterNameInReview(name);
        productDetailsPage.enterEmailInReview(email);
        productDetailsPage.enterReviewMessage(reviewMessage);
        productDetailsPage.clickOnSubmit();
        log.info("Entering review and submitting....");

    }

    @Then("I should see a success message {string} displayed")
    public void iShouldSeeASuccessMessageDisplayed(String successMessage) {
        Assert.assertEquals(new ProductDetailsPage().getReviewSuccessMessageText(),successMessage,"Success message is not displayed");
        log.info("Verifying review success message....");
    }
}

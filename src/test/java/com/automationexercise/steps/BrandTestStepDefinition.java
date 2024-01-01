package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.excelutility.ExcelReader;
import com.automationexercise.pages.BrandsPage;
import com.automationexercise.pages.UtilityMethodPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BrandTestStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @When("I select a brand from sheet name {string} and row number {string}")
    public void iSelectABrandFromSheetNameAndRowNumber(String sheetName, String rowNumber) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/brand-excel-data.xlsx", sheetName);
        String brandName = testdata.get(Integer.parseInt(rowNumber)).get("brandname");
        log.info("Obtaining brand data from excel sheet....");

        //try catch block below to catch Stale Element Not found exception
        //And provided explicit wait in selectTheBrand() method
        try{
        new BrandsPage().selectTheBrand(brandName);
        log.info("Clicking on the brand name....");
        }
        catch (Exception e){
            System.out.println("Exception encountered: "+e.getMessage());
        }

    }

    @Then("I should see brand name from sheet name {string} and row number {string} in the heading")
    public void iShouldSeeBrandNameFromSheetNameAndRowNumberInTheHeading(String sheetName, String rowNumber) throws IOException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("src/test/resources/testdata/brand-excel-data.xlsx", sheetName);
        String expectedHeading = testdata.get(Integer.parseInt(rowNumber)).get("brandHeading");
        System.out.println("actual heading: " + new UtilityMethodPage().getPageHeadingText(expectedHeading));
        Assert.assertEquals(new UtilityMethodPage().getPageHeadingText(expectedHeading), expectedHeading);

    }

    @And("I should see brand products are displayed")
    public void iShouldSeeBrandProductsAreDisplayed() {
        Assert.assertTrue(new BrandsPage().AreProductsDisplayedUnderBrand(), "Products are not displayed.");
        log.info("Verifying if the products are displayed on the page....");
    }

    @When("I click on another brand {string}")
    public void iClickOnAnotherBrand(String brandName) {
        try {
            new BrandsPage().selectTheBrand(brandName);
            log.info("Clicking on the brand name....");
        }catch (Exception e){
            System.out.println("Exception encountered: "+e.getMessage());
        }
    }
}

package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.CategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class CategoryTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @When("I select the {string} category")
    public void iSelectTheCategory(String text) {
        new CategoryPage().clickOnCategory(text);
        log.info("Clicking on category option....");
    }

    @And("I select the sub category {string}")
    public void iSelectTheSubCategory(String subCategoryName) {
        new CategoryPage().clickOnSubCategory(subCategoryName);
        log.info("Clicking on sub category....");
    }

    @Then("I can see {string} in breadcrumb")
    public void iCanSeeInBreadcrumb(String breadcrumb) {
        Assert.assertEquals(new CategoryPage().getBreadCrumbText(),breadcrumb,"Not in the correct sub category page.");
    log.info("Verifying the breadcrumb....");
    }
}

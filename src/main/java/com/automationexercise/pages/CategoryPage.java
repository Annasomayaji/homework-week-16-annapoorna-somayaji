package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//h4[@class='panel-title']/a")
    List<WebElement> categoryTitles;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'panel-collapse')]//li/a")
    List<WebElement> subCategories;

    @CacheLookup
    @FindBy(xpath = "//div[@class='breadcrumbs']//li[2]")
    WebElement breadCrumb;


    //Methods
    public void clickOnCategory(String categoryName) {
        for (WebElement category : categoryTitles) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                category.click();
            }
        }
    }

    public void clickOnSubCategory(String subCategoryName) {

        for (WebElement subCategory : subCategories) {
            if (subCategory.getText().equalsIgnoreCase(subCategoryName)) {
                waitUntilElementIsClickable(subCategory, 5);
                subCategory.click();
            }
        }
    }

    public String getBreadCrumbText() {
        driver.navigate().refresh();
        return getTextFromElement(breadCrumb);
    }
}

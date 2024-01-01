package com.automationexercise.pages;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    //Elements
    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a")
    List<WebElement> topNavElements;

    @CacheLookup
    @FindBy(xpath = "//div[@class='logo pull-left']")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//a[text()[normalize-space()='Logged in as']]")
    WebElement loggedInTopNavTab;
    @CacheLookup
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionHeading;
    @CacheLookup
    @FindBy(id = "susbscribe_email")
    WebElement subscriptionEmail;
    @CacheLookup
    @FindBy(id = "subscribe")
    WebElement subscriptionSubmitButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement subscriptionSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    List<WebElement> allProducts;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']")
    List<WebElement> addToCartButtons;

    @CacheLookup
    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    WebElement recommendedItemsHeading;
//    @CacheLookup
//    @FindBy(xpath = "(//div[@class='carousel-inner'])[2]")
//    List<WebElement> recommendedItemsInCarousel;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='item active'])[2]//div[@class='single-products']//p")
    List<WebElement> recommendedItemsInCarousel;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='carousel-inner'])[1]//div[@class='item active']//h2")
    WebElement subHeadingInTopCarousel;


    @CacheLookup
    @FindBy(xpath = "(//div[@class='item active'])[2]//a")
    List<WebElement> addToCartButtonsInCarousel;

    @CacheLookup
    @FindBy(id = "scrollUp")
    WebElement scrollBackUpArrow;


    //Methods

    /**
     * This method will verify if the correct page is displayed when a tab is selected
     * by checking the colour change in the selected tab link.
     *
     * @param tabName
     * @return
     */
    public boolean isTopNavTabSelected(String tabName) {
        boolean isSelected = false;
        for (WebElement navigationTab : topNavElements) {
            System.out.println("Tabs: " + navigationTab.getText());
            if (navigationTab.getText().contains(tabName)) {
                isSelected = (navigationTab.getAttribute("style").contains("orange"));
                // System.out.println("Color: "+ navigationTab.getAttribute("style"));
                // System.out.println("is selected: "+isSelected);
            }
        }
        log.info("Navigation tab selection verified....");
        return isSelected;
    }

    /**
     * This method will click on any tab on the top navigation bar sent as the parameter
     *
     * @param tabName
     */
    public void selectTabFromTopNavBar(String tabName) throws InterruptedException {
        driver.getCurrentUrl();
        waitUntilVisibilityOfElementLocated(topNavElements, 5);
        for (WebElement navigationTab : topNavElements) {
            if (navigationTab.getText().contains(tabName)) {
                navigationTab.click();
                Thread.sleep(5000);
                break;
            }
        }
        log.info("Navigation tab is clicked on....");
    }

    public String isLoggedInAsUserNameTabDisplayed() {
        // System.out.println("Logged in text: "+loggedInTopNavTab.getText());
        return getTextFromElement(loggedInTopNavTab);

    }

    public String getSubscriptionHeadingText() {
        return getTextFromElement(subscriptionHeading);
    }

    public void enterSubscriptionEmail(String email) {
        String randomStr = getRandomString(5);

        sendTextToElement(subscriptionEmail, randomStr + email);
    }

    public void clickOnSubscriptionSubmitButton() {
        subscriptionSubmitButton.submit();
    }

    public String getSubscriptionSuccessMessage() {
        return getTextFromElement(subscriptionSuccessMessage);
    }


    public void scrollDownToSubscriptionHeading() {
        scrollIntoView(subscriptionHeading);
    }

    public void scrollDownToRecommendedItems() {
        scrollIntoView(recommendedItemsHeading);
    }

    /**
     * This method finds what position the desired product is at in the list of products
     */
    public int getProductToAdd(String productName) {

        int count = 0;
        for (WebElement product : allProducts) {
            if (product.getText().equalsIgnoreCase(productName)) {
                break;
            }
            count++; //increase count until 'if loop' matches the product
        }
        return count;
    }


    /**
     * This method finds the corresponding 'add to cart' button for the desired product chosen at runtime
     */

    public void clickOnAddToCartButton(int count) {
        int index = 0;

        //loop until button matching the product is found using the products position in the list(count) as reference
        for (WebElement addToCartButton : addToCartButtons) {

            //When the corresponding 'add to cart' button found, click on it
            if (index == count) {
                //This button could be hidden, So using JS Executor interface
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", addToCartButton);
                break;
            }
            index++;
        }

    }

    public void hoverOnRecommendedItem(String productName) {
        int count = 0;

        for (WebElement e : recommendedItemsInCarousel) {
//            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
//            wait.until(ExpectedConditions.attributeContains(recommendedItemsInCarousel.get(0),"class","item active" ));
            waitUntilVisibilityOfElementLocated(recommendedItemsInCarousel, 10);
            System.out.println("Items in carousel: " + e.getText());
            if (e.getText().equalsIgnoreCase(productName)) {
                mouseHoverToElement(e);
                break;
            }
            count++;
        }
        clickOnAddToCart(count); //call this method to click on corresponding 'add to cart' button
    }

    public void clickOnAddToCart(int count) {
        int index = 0;
        for (WebElement button : addToCartButtonsInCarousel) {

            if (index == count) {
                clickOnElement(button);
                break;
            }
            index++;
        }

    }

    public void clickOnScrollUpArrow() {
        clickOnElement(scrollBackUpArrow);
    }

    public String getSubPageHeadingInTopCarouselText() {
        return getTextFromElement(subHeadingInTopCarousel);
    }

    public void scrollUpToTop(){
       scrollIntoView(subHeadingInTopCarousel);
    }

}

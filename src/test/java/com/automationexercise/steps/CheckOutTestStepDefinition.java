package com.automationexercise.steps;

import com.automationexercise.browserfactory.ManageBrowser;
import com.automationexercise.pages.CheckoutPage;
import com.automationexercise.pages.PaymentDonePage;
import com.automationexercise.pages.PaymentPage;
import com.automationexercise.pages.ViewCartPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class CheckOutTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        new ViewCartPage().clickOnProceedToCheckOut();
        log.info("Clicking on proceed to checkout button....");

    }


    @And("I click on Register and Login link")
    public void iClickOnRegisterAndLoginLink() {

        new ViewCartPage().clickOnRegisterOrLogin();
        log.info("Clicking on register/login button....");
    }


    @Then("I can see the address details")
    public void iCanSeeTheAddressDetails(DataTable dataTable) {
        List<String> actualAddressLines = new CheckoutPage().getAddressLines();
        List<String> expectedAddressLines = dataTable.asList(String.class);
        System.out.println("Actual address: " + actualAddressLines); //debug purpose
        System.out.println("expected address: " + expectedAddressLines);//debug purpose

        Assert.assertEquals(actualAddressLines,expectedAddressLines, "Address saved is incorrect.");
        log.info("Verifying address info....");
    }

    @And("I can see the billing address details")
    public void iCanSeeTheBillingAddressDetails(DataTable dataTable) {
        List<String> actualBillingAddressDetails=new CheckoutPage().getBillingAddressLines();
        List<String> expectedBillingAddressDetails=dataTable.asList(String.class);
        Assert.assertEquals(expectedBillingAddressDetails, actualBillingAddressDetails, "Address do not match");
    }

    @And("I can see order details")
    public void iCanSeeOrderDetails(DataTable dataTable) {

        List<String> expectedOrderInfo = dataTable.asList(String.class);
        List<String> actualOrderInfo = new CheckoutPage().getorderInfo();
        System.out.println("Actual order info: " + actualOrderInfo);//debug purpose
        System.out.println("expected order info: " + expectedOrderInfo);//debug purpose
        Assert.assertTrue(actualOrderInfo.equals(expectedOrderInfo));
        log.info("Verifying order info....");

    }

    @And("I enter comment {string} and place order")
    public void iEnterCommentAndPlaceOrder(String comment) {
        new CheckoutPage().enterComment(comment);
        log.info("Entering comment in the comment field....");

        new CheckoutPage().clickOnPlaceOrder();
        log.info("Clicking place order....");

    }

    @And("I enter payment information name {string}, card number {string}, CVC {string}, Expiration {string}, Year {string}")
    public void iEnterPaymentInformationNameCardNumberCVCExpirationYear(String name, String cardNumber, String cvc, String month, String year) {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.enterNameOnCard(name);
        paymentPage.enterCardNumber(cardNumber);
        paymentPage.enterCVC(cvc);
        paymentPage.enterExpiryMonth(month);
        paymentPage.enterExpiryYear(year);
        log.info("Entering card details on payment page....");

    }

    @And("I place order")
    public void iPlaceOrder() {
        new PaymentPage().confirmOrder();
        log.info("Clicking on confirm order....");
    }


    @When("I download invoice and verify download for file {string}")
    public void iDownloadInvoiceAndVerifyDownloadForFile(String fileName) {
        new PaymentDonePage().clickOnDownloadInvoice();
        log.info("Clicking on download invoice button....");
        boolean isDownloaded=new PaymentDonePage().isInvoiceDownloaded(fileName);
        Assert.assertTrue(isDownloaded,"Invoice is not downloaded.");
        log.info("Verifying invoice download....");
    }
}

package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.DetailedProductDescPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ShippingDetailsPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC_04_CompletePurchase extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC_04_CompletePurchase.class);

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class, groups = {"regression"})
    void addToCart() throws InterruptedException {
        logger.info("===== Starting TC_04_CompletePurchase Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickLapAndTab();
            logger.debug("Clicked on 'Laptops & Tablets'");

            hp.clickAllLapAndTab();
            logger.debug("Clicked on 'Show All Laptops & Tablets'");

            ProductsPage pp = new ProductsPage(getDriver());
            pp.productSelect();
            logger.debug("Selected product");

            DetailedProductDescPage dp = new DetailedProductDescPage(getDriver());
            dp.changeDate();
            logger.debug("Changed delivery date");

            dp.addToCart();
            logger.info("Clicked on 'Add to Cart'");

            dp.checkout();
            logger.info("Proceeded to Checkout");

            CheckoutPage cp = new CheckoutPage(getDriver());
            cp.clickLoginLink();
            logger.debug("Clicked on Login link");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("lekhamca.g4@gmail.com");
            lp.setPwd("Sample123");
            lp.clickLogin();
            logger.info("Logged in with provided credentials");

            ShippingDetailsPage sdp = new ShippingDetailsPage(getDriver());
            sdp.selectShippingAddress();
            logger.debug("Selected shipping address");

            sdp.fillShippingAndPaymentDetails();
            logger.debug("Filled shipping and payment details");

            sdp.confirmOrder();
            logger.info("Order confirmed");

            boolean status = sdp.confirmationPage().isDisplayed();
            logger.debug("Order confirmation status: " + status);

            Assert.assertTrue(status, "Order confirmation page not displayed.");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in complete purchase test", ae);
            Assert.fail("Assertion failed: " + ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected exception during complete purchase test", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }

        logger.info("===== TC_04_CompletePurchase Test Completed =====");
    }
}

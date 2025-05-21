package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DetailedProductDescPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC_05_AddToWishList extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC_05_AddToWishList.class);

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"regression"})
    void addToWishList() throws InterruptedException {
        logger.info("===== Starting TC_05_AddToWishList Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            logger.debug("Clicked on My Account");

            hp.clickLogin();
            logger.debug("Navigated to Login page");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("lekhamca.g4@gmail.com");
            lp.setPwd("Sample123");
            lp.clickLogin();
            logger.info("Logged in with provided credentials");

            hp.clickLogoOpenCart();
            logger.debug("Clicked on OpenCart logo to go to homepage");

            hp.clickLapAndTab();
            hp.clickAllLapAndTab();
            logger.debug("Navigated to Laptops & Tablets section");

            ProductsPage pp = new ProductsPage(getDriver());
            pp.productSelect();
            logger.debug("Selected product from list");

            DetailedProductDescPage dp = new DetailedProductDescPage(getDriver());
            dp.addToWishList();
            logger.info("Clicked on Add to Wishlist");

            String message = dp.successMsg().getText();
            logger.debug("Success message: " + message);

            Assert.assertTrue(message.contains("Success"), "Wishlist confirmation message not found.");
            logger.info("Add to Wishlist test passed.");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in Wishlist test", ae);
            Assert.fail("Test failed due to assertion: " + ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected error during Wishlist test", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }

        logger.info("===== TC_05_AddToWishList Test Completed =====");
    }
}

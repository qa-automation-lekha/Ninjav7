package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DetailedProductDescPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC_03_AddToCart extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC_03_AddToCart.class);

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class, groups = {"sanity", "regression"})
    void addToCart() throws InterruptedException {
        logger.info("===== Starting TC_03_AddToCart Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickLapAndTab();
            logger.debug("Clicked on 'Laptops & Tablets'");

            hp.clickAllLapAndTab();
            logger.debug("Clicked on 'Show All Laptops & Tablets'");

            ProductsPage pp = new ProductsPage(getDriver());
            pp.productSelect();
            logger.debug("Selected a product");

            DetailedProductDescPage dp = new DetailedProductDescPage(getDriver());
            dp.changeDate();
            logger.debug("Set delivery date");

            dp.addToCart();
            logger.info("Clicked on 'Add to Cart'");

            String message = dp.successMsg().getText();
            logger.debug("Success message received: " + message);

            boolean isAdded = message.contains("Success");

            Assert.assertTrue(isAdded, "Add to Cart message did not contain 'Success'");
            logger.info("Add to Cart verified successfully");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in Add to Cart test", ae);
            Assert.fail("Assertion failed: " + ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected exception in Add to Cart test", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }

        logger.info("===== TC_03_AddToCart Test Completed =====");
    }
}

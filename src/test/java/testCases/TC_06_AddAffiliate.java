package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.MyAffiliatePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC_06_AddAffiliate extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC_06_AddAffiliate.class);

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"regression"})
    void addToWishList() throws InterruptedException {
        logger.info("===== Starting TC_06_AddAffiliate Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            logger.debug("Clicked on My Account");

            hp.clickLogin();
            logger.debug("Clicked on Login");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("lekhamca.g4@gmail.com");
            lp.setPwd("Sample123");
            lp.clickLogin();
            logger.info("Logged in successfully");

            MyAccountPage map = new MyAccountPage(getDriver());
            map.clickAddAffiliate();
            logger.debug("Navigated to Add Affiliate page");

            MyAffiliatePage mp = new MyAffiliatePage(getDriver());
            mp.fillTextBoxes("Amazon", "Amazon.com", "T1234", "LG");
            logger.info("Filled affiliate form details");

            boolean status = mp.successMsg();
            logger.debug("Affiliate success message status: " + status);

            Assert.assertTrue(status, "Affiliate details not added successfully.");
            logger.info("TC_06_AddAffiliate Test Passed");

        } catch (AssertionError ae) {
            logger.error("Assertion failed: ", ae);
            Assert.fail("Test failed due to assertion error: " + ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected error occurred: ", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }

        logger.info("===== TC_06_AddAffiliate Test Completed =====");
    }
}

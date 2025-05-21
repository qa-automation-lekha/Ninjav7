package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC_01_LaunchApplication extends BaseClass {

	private static final Logger logger = LogManager.getLogger(TC_01_LaunchApplication.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLaunchApplication() {
        logger.info("Starting test: TC01_LaunchApplication");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object initialized");

            String title = getDriver().getTitle();
            logger.debug("Page title retrieved: " + title);

            Assert.assertEquals(title, "Your store of fun");
            logger.info("Page title assertion passed");

        } catch (AssertionError ae) {
            logger.error("Assertion failed: Page title did not match", ae);
            Assert.fail("Page title mismatch: " + ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in testLaunchApplication", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }

        logger.info("Test completed: TC01_LaunchApplication");
    }
}

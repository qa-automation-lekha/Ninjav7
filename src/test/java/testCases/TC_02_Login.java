package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC_02_Login extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC_02_Login.class);

    @Test(groups = {"sanity", "regression", "datadriven"}, 
          dataProvider = "LoginData", 
          dataProviderClass = DataProviders.class, 
          retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLogin(String email, String pwd) {

        logger.info("===== Starting TC02_Login Test for user: " + email + " =====");

        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            logger.debug("Clicked 'My Account'");

            hp.clickLogin();
            logger.debug("Navigated to Login page");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            logger.debug("Entered email: " + email);

            lp.setPwd(pwd);
            logger.debug("Entered password");

            lp.clickLogin();
            logger.info("Clicked on login");

            MyAccountPage ap = new MyAccountPage(getDriver());
            boolean status = ap.getMyAccount().isDisplayed();
            logger.debug("Login status: " + status);

            if (status) {
                logger.info("Login successful for user: " + email);
                ap.clickMyAccountDropDown();
                ap.clickLogout();
                logger.info("User logged out successfully");
            }

            Assert.assertTrue(status, "Login failed for user: " + email);

        } catch (AssertionError ae) {
            logger.error("Assertion failed for user: " + email, ae);
            Assert.fail("Assertion Error: " + ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected error during login test for user: " + email, e);
            Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
        }

        logger.info("===== Completed TC02_Login Test for user: " + email + " =====");
    }
}

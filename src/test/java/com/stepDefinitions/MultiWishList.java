package com.stepDefinitions;

import com.actions.LoginPageAction;
import com.actions.WishListActions;
import com.driver.DriverClass;
import com.pages.LaunchPages;
import com.utils.ConfigReader;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class MultiWishList {


    private static final Logger logger = LogManager.getLogger(WishList.class);

    LoginPageAction lpa = new LoginPageAction();
    LaunchPages lp = new LaunchPages(DriverClass.getDriver());
    WishListActions wla = new WishListActions();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        String url = ConfigReader.getProperties().getProperty("url");
        lp.launchApplication(url);

        logger.info("User launched application URL: " + url);

        Assert.assertTrue(DriverClass.getDriver().getCurrentUrl().contains("route=common/home"),
                "Home page not launched properly");
    }

    @Given("the user is a registered user")
    public void the_user_is_a_registered_user() {

        lpa.launchWebUrl();
        lpa.clickMyAccountLink();
        lpa.enterEmailAndPass("testlogin@gmail.com", "testlogin");
        lpa.clickLoginButton();

        String actual = lpa.LoginSuccessMsg();
        String expected = "My Account";

        Assert.assertEquals(actual, expected, "Login Failed");
        logger.info("Login Successful");
    }


}

package com.stepDefinitions;

import com.actions.LoginPageAction;
import com.actions.WishListActions;
import com.driver.DriverClass;
import com.pages.LaunchPages;
import com.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class WishList {

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

    @Given("the user navigates to the Top Products section")
    public void the_user_navigates_to_the_top_products_section() {

        wla.scrollToTopProducts();
        logger.info("Scrolled to Top Products section");
    }

    @When("the user selects the {string} product and adds it to the wishlist")
    public void the_user_selects_the_product_and_adds_it_to_the_wishlist(String productName) {

        wla.addIMacToWishlist();
        logger.info("Added product to wishlist: " + productName);
    }

    @Then("a wishlist success notification should be displayed")
    public void a_wishlist_success_notification_should_be_displayed() {

        String msg = wla.getWishlistSuccessMessage();
        logger.info("Wishlist Notification: " + msg);

        Assert.assertTrue(msg.contains("Success"),
                "Wishlist success message not displayed. Actual: " + msg);
    }

    @Then("the user clicks the wishlist link from the notification popup")
    public void the_user_clicks_the_wishlist_link_from_the_notification_popup() {

        wla.clickWishlistLinkFromPopup();
        logger.info("Clicked wishlist link from popup");
    }

    @Then("the user should be redirected to the {string} page")
    public void the_user_should_be_redirected_to_the_page(String pageName) {

        wla.waitForWishlistPage();

        String actualTitle = wla.getCurrentPageTitle();
        logger.info("Actual Page Title: " + actualTitle);

        Assert.assertTrue(actualTitle.contains(pageName),
                "User not redirected to correct page. Expected: " + pageName + " but got: " + actualTitle);
    }

    @And("the wishlist product details should match the selected product")
    public void the_wishlist_product_details_should_match_the_selected_product() {

        String actualProductName = wla.getWishlistProductName();
        String actualPrice = wla.getWishlistProductPrice();

        logger.info("Wishlist Product Name: " + actualProductName);
        logger.info("Wishlist Product Price: " + actualPrice);

        Assert.assertEquals(actualProductName, "iMac",
                "Wishlist product name mismatch");

        Assert.assertFalse(actualPrice.isEmpty(),
                "Wishlist product price is empty");
    }

    @When("the user adds multiple products to the wishlist")
    public void theUserAddsMultipleProductsToTheWishlist() {

    }

    @Then("all selected products should be displayed in the wishList page")
    public void allSelectedProductsShouldBeDisplayedInTheWishListPage() {
    }
}
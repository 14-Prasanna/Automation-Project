package com.actions;

import com.driver.DriverClass;
import com.pages.WishListPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishListActions {

    WebDriver driver = DriverClass.getDriver();
    WishListPage wp = new WishListPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public void scrollToTopProducts() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(wp.homeLogo)).click();
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(wp.homeLogoAlt)).click();
            } catch (Exception ex) {
                System.out.println("Home Logo not clickable, continuing...");
            }
        }

        wait.until(ExpectedConditions.visibilityOf(wp.topProductsHeading));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", wp.topProductsHeading);

        System.out.println("Scrolled to Top Products section");
    }

    public void addIMacToWishlist() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        WebElement imacBox = wait.until(ExpectedConditions.visibilityOf(wp.imacListingBox));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", imacBox);

        try { Thread.sleep(600); } catch (InterruptedException ignored) {}

        actions.moveToElement(imacBox).perform();

        try { Thread.sleep(700); } catch (InterruptedException ignored) {}

        js.executeScript(
                "var el = arguments[0];" +
                        "el.style.setProperty('display','block','important');" +
                        "el.style.setProperty('opacity','1','important');" +
                        "el.style.setProperty('visibility','visible','important');",
                wp.imacWishlistBtn
        );

        js.executeScript("arguments[0].click();", wp.imacWishlistBtn);

        System.out.println("Clicked Wishlist button via JS click");
    }

    public String getWishlistSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(wp.successNotification));
        return wp.successNotification.getText().trim();
    }

    public void clickWishlistLinkFromPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(wp.wishlistPopupLink)).click();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void waitForWishlistPage() {
        wait.until(ExpectedConditions.visibilityOf(wp.myWishListTitle));
    }

    public String getWishlistProductName() {
        wait.until(ExpectedConditions.visibilityOf(wp.wishListProductName));
        return wp.wishListProductName.getText().trim();
    }

    public String getWishlistProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(wp.wishListProductPrice));
        return wp.wishListProductPrice.getText().trim();
    }
}
package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverClass;
import com.pages.ProductPage;

public class productPageAction extends BaseAction {

    WebDriver driver = DriverClass.getDriver();
    ProductPage pp = new ProductPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private static Logger log = LogManager.getLogger(productPageAction.class);
    public String getBrandName() {
        try {
            log.info("Getting brand name");
            String text = pp.BrandName.getText();
            log.info("Brand name: " + text);
            return text;
        } catch (Exception e) {
            log.error("Failed to get brand name", e);
            throw e;
        }
    }

    public String getInstockAvailability() {
        try {
            log.info("Getting In-stock availability");
            String text = pp.availability.getText();
            log.info("Availability: " + text);
            return text;
        } catch (Exception e) {
            log.error("Failed to get in-stock availability", e);
            throw e;
        }
    }

    public String getOutStockAvailability() {
        try {
            log.info("Getting Out-of-stock availability");
            String text = pp.availabilityOutOfStock.getText();
            log.info("Out-of-stock: " + text);
            return text;
        } catch (Exception e) {
            log.error("Failed to get out-of-stock availability", e);
            throw e;
        }
    }

    public String getPrice() {
        try {
            log.info("Getting product price");
            return pp.productPrice.getText();
        } catch (Exception e) {
            log.error("Failed to get price", e);
            throw e;
        }
    }

    public String getProductTitle() {
        try {
            log.info("Getting product title");
            return pp.productTitle.getText();
        } catch (Exception e) {
            log.error("Failed to get product title", e);
            throw e;
        }
    }

    public void setQuantity(String quantity) {
        try {
            log.info("Setting quantity: " + quantity);
            sendKeys(pp.quantityBox, quantity);
        } catch (Exception e) {
            log.error("Failed to set quantity", e);
            throw e;
        }
    }

    public String getQuantity() {
        try {
            return pp.quantityBox.getAttribute("value");
        } catch (Exception e) {
            log.error("Failed to get quantity", e);
            throw e;
        }
    }

    public void clickAskQuestion() {
        try {
            log.info("Clicking Ask Question");
            wait.until(ExpectedConditions.elementToBeClickable(pp.questionForm));
            click(pp.questionForm);
        } catch (Exception e) {
            log.error("Failed to click Ask Question", e);
            throw e;
        }
    }

    public void setName(String yourName) {
        try {
            log.info("Entering name: " + yourName);
            wait.until(ExpectedConditions.visibilityOf(pp.name));
            sendKeys(pp.name, yourName);
        } catch (Exception e) {
            log.error("Failed to set name", e);
            throw e;
        }
    }

    public void setEmail(String yourEmail) {
        try {
            log.info("Entering email: " + yourEmail);
            sendKeys(pp.email, yourEmail);
        } catch (Exception e) {
            log.error("Failed to set email", e);
            throw e;
        }
    }

    public void setSubject(String yourSubject) {
        try {
            log.info("Entering subject: " + yourSubject);
            sendKeys(pp.subject, yourSubject);
        } catch (Exception e) {
            log.error("Failed to set subject", e);
            throw e;
        }
    }

    public void setMessage(String yourMessage) {
        try {
            log.info("Entering message");
            sendKeys(pp.Message, yourMessage);
        } catch (Exception e) {
            log.error("Failed to set message", e);
            throw e;
        }
    }

    public void clickSendMessage() {
        try {
            log.info("Clicking Send Message");
            wait.until(ExpectedConditions.elementToBeClickable(pp.sendMessage));
            click(pp.sendMessage);
        } catch (Exception e) {
            log.error("Failed to click send message", e);
            throw e;
        }
    }

    public String getAlertMessage() {
        try {
            log.info("Getting alert message");

            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='alert alert-success alert-notification w-50 alert-dismissible']")));

            String msg = alert.getText().replace("×", "").trim();

            log.info("Alert message: " + msg);
            return msg;

        } catch (Exception e) {
            log.error("Failed to get alert message", e);
            throw e;
        }
    }

    public void clickAddToCart() {
        try {
            log.info("Clicking Add to Cart");
            click(pp.addToCartBtn);
        } catch (Exception e) {
            log.error("Failed to click Add to Cart", e);
            throw e;
        }
    }

    public void clickWishListBtn() {
        try {
            log.info("Clicking Wishlist button");
            click(pp.wishListBtn);
        } catch (Exception e) {
            log.error("Failed to click wishlist", e);
            throw e;
        }
    }

    public String getAddTocartConfirmation() {
        try {
            log.info("Getting Add to Cart confirmation");
            String msg = wait.until(ExpectedConditions.visibilityOf(pp.sizeRequired)).getText();
            log.info("Cart message: " + msg);
            return msg;
        } catch (Exception e) {
            log.error("Failed to get cart confirmation", e);
            throw e;
        }
    }

    public String getWishListConfirmation() {
        try {
            log.info("Getting wishlist confirmation");
            return wait.until(ExpectedConditions.visibilityOf(pp.wishList)).getText();
        } catch (Exception e) {
            log.error("Failed to get wishlist message", e);
            throw e;
        }
    }

    public void clickSoftwareBreadcrumb() {
        try {
            log.info("Clicking Software breadcrumb");
            wait.until(ExpectedConditions.elementToBeClickable(pp.softwareBreadCrumb));
            click(pp.softwareBreadCrumb);
        } catch (Exception e) {
            log.error("Failed breadcrumb click", e);
            throw e;
        }
    }

    public String getMadatoryFieldsMessage() {
        try {
            log.info("Getting mandatory fields message");
            return wait.until(ExpectedConditions.visibilityOf(pp.mandatoryFields)).getText();
        } catch (Exception e) {
            log.error("Failed to get mandatory fields message", e);
            throw e;
        }
    }

    public void clickMinus() {
        try {
            log.info("Clicking minus button");
            wait.until(ExpectedConditions.elementToBeClickable(pp.minusBtn));
            click(pp.minusBtn);
        } catch (Exception e) {
            log.error("Failed to click minus", e);
            throw e;
        }
    }

    public void clickAddToCartbutton() {
        try {
            log.info("Clicking Add to Cart button");
            wait.until(ExpectedConditions.elementToBeClickable(pp.addToCartButton));
            click(pp.addToCartButton);
        } catch (Exception e) {
            log.error("Failed Add to Cart button", e);
            throw e;
        }
    }

    public void viewCartPP() {
        try {
            log.info("Clicking View Cart popup");
            wait.until(ExpectedConditions.elementToBeClickable(pp.viewCartPopUpButton));
            click(pp.viewCartPopUpButton);
        } catch (Exception e) {
            log.error("Failed to open cart popup", e);
            throw e;
        }
    }

    public void clickCompareBtn() {
        try {
            log.info("Clicking Compare button");
            wait.until(ExpectedConditions.elementToBeClickable(pp.compareBtn));
            click(pp.compareBtn);
        } catch (Exception e) {
            log.error("Failed compare button", e);
            throw e;
        }
    }

    public String getConfirmationMessage() {
        try {
            log.info("Getting comparison confirmation message");
            return wait.until(ExpectedConditions.visibilityOf(pp.productComparisonMessage)).getText();
        } catch (Exception e) {
            log.error("Failed to get comparison message", e);
            throw e;
        }
    }

    public void clickCart() {
        try {
            log.info("Clicking cart button");
            wait.until(ExpectedConditions.elementToBeClickable(pp.cartButton));
            click(pp.cartButton);
        } catch (Exception e) {
            log.error("Failed to click cart", e);
            throw e;
        }
    }

    public String getQuantityInCart() {
        try {
            log.info("Getting quantity from cart");
            return wait.until(ExpectedConditions.visibilityOf(pp.quantityField)).getAttribute("value");
        } catch (Exception e) {
            log.error("Failed to get cart quantity", e);
            throw e;
        }
    }

    public void clickViewCompare() {
        try {
            log.info("Clicking View Compare");
            wait.until(ExpectedConditions.elementToBeClickable(pp.viewCompare));
            click(pp.viewCompare);
        } catch (Exception e) {
            log.error("Failed to click view compare", e);
            throw e;
        }
    }
}
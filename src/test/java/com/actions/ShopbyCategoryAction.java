package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverClass;
import com.pages.LaunchPages;
import com.pages.ShopbyCategoryPage;
import com.utils.ConfigReader;

public class ShopbyCategoryAction {

    private static final Logger log =
            LogManager.getLogger(ShopbyCategoryAction.class);

    WebDriverWait wait =
            new WebDriverWait(
                    DriverClass.getDriver(),
                    Duration.ofSeconds(20));

    LaunchPages lp =
            new LaunchPages(DriverClass.getDriver());

    ShopbyCategoryPage sbcp =
            new ShopbyCategoryPage(
                    DriverClass.getDriver());

    public void launchWebUrl() {

        try {

            DriverClass.getDriver().get(
                    ConfigReader.getProperties()
                            .getProperty("url"));

            DriverClass.getDriver()
                    .manage()
                    .timeouts()
                    .implicitlyWait(
                            Duration.ofSeconds(10));

            log.info(
                    "Application launched successfully");

        } catch (Exception e) {

            log.error(
                    "Failed to launch application",
                    e);

            throw e;
        }
    }

    public void clickShopByCategory() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOf(
                            sbcp.shopByCategoryMenu));

            wait.until(
                    ExpectedConditions
                            .elementToBeClickable(
                                    sbcp.shopByCategoryMenu));

            sbcp.shopByCategoryMenu.click();

            log.info(
                    "Clicked Shop By Category Menu");

        } catch (Exception e) {

            log.error(
                    "Unable to click Shop By Category Menu",
                    e);

            throw e;
        }
    }

    public void selectCategory(String category) {

        try {

            switch (category.toLowerCase()) {

                case "desktops & monitors":

                    wait.until(
                            ExpectedConditions
                                    .elementToBeClickable(
                                            sbcp.desktopsCategory));

                    sbcp.desktopsCategory.click();

                    log.info(
                            "Selected Desktops & Monitors");
                    break;

                case "web cameras":

                    wait.until(
                            ExpectedConditions
                                    .elementToBeClickable(
                                            sbcp.cameras));

                    sbcp.cameras.click();

                    log.info(
                            "Selected Web Cameras");
                    break;

                case "phone, tablets & ipod":

                    wait.until(
                            ExpectedConditions
                                    .elementToBeClickable(
                                            sbcp.tablets));

                    sbcp.tablets.click();

                    log.info(
                            "Selected Phone, Tablets & Ipod");
                    break;

                case "laptops & notebooks":

                    wait.until(
                            ExpectedConditions
                                    .elementToBeClickable(
                                            sbcp.laptops));

                    sbcp.laptops.click();

                    log.info(
                            "Selected Laptops & Notebooks");
                    break;

                default:

                    throw new IllegalArgumentException(
                            "Unsupported category: "
                                    + category);
            }

        } catch (Exception e) {

            log.error(
                    "Failed to select category",
                    e);

            throw e;
        }
    }

    public String getPageTitle() {

        String title = "";

        try {

            title =
                    DriverClass.getDriver().getTitle();

            log.info(
                    "Page title fetched successfully");

        } catch (Exception e) {

            log.error(
                    "Unable to fetch page title",
                    e);
        }

        return title;
    }
}
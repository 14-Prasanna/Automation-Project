package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.ConfigReader;
import com.driver.DriverClass;
import com.pages.ShopByCategoryPage;

public class ShopByCategoryAction {

    private static final Logger log = LogManager.getLogger(ShopByCategoryAction.class);

    WebDriver driver = DriverClass.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    ShopByCategoryPage sbcp = new ShopByCategoryPage(driver);

    public void launchWebUrl() {

        try {

        	driver.get(ConfigReader.getProperties().getProperty("url"));;

            driver.manage().window().maximize();

            log.info("Application launched successfully");

        } catch (Exception e) {

            log.error("Failed to launch application : " + e.getMessage());
        }
    }

    public void clickShopByCategory() {

        try {

            wait.until(ExpectedConditions.elementToBeClickable(sbcp.shopByCategoryMenu));

            sbcp.shopByCategoryMenu.click();

            log.info("Clicked Shop By Category Menu");

        } catch (Exception e) {

            log.error("Unable to click Shop By Category Menu : " + e.getMessage());
        }
    }

    public void selectCategory(String category) {

        try {

            if (category.equalsIgnoreCase("Desktops & Monitors")) {

                wait.until(ExpectedConditions.elementToBeClickable(sbcp.desktopsCategory));

                sbcp.desktopsCategory.click();

                log.info("Selected Desktops & Monitors");

            }

            else if (category.equalsIgnoreCase("Web Cameras")) {

                wait.until(ExpectedConditions.elementToBeClickable(sbcp.cameras));

                sbcp.cameras.click();

                log.info("Selected Web Cameras");

            }

            else if (category.equalsIgnoreCase("Phone, Tablets & Ipod")) {

                wait.until(ExpectedConditions.elementToBeClickable(sbcp.tablets));

                sbcp.tablets.click();

                log.info("Selected Phone, Tablets & Ipod");

            }

            else if (category.equalsIgnoreCase("Laptops & Notebooks")) {

                wait.until(ExpectedConditions.elementToBeClickable(sbcp.laptops));

                sbcp.laptops.click();

                log.info("Selected Laptops & Notebooks");

            }

            else {

                log.error("Invalid Category Name : " + category);
            }

        } catch (Exception e) {

            log.error("Failed to select category : " + e.getMessage());
        }
    }

    public String getPageTitle() {

        String title = "";

        try {

            title = driver.getTitle();

            log.info("Page title fetched successfully");

        } catch (Exception e) {

            log.error("Unable to fetch page title : " + e.getMessage());
        }

        return title;
    }
}
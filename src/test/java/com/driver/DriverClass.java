package com.driver;

import com.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverClass {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private static final Logger logger =
            LogManager.getLogger(DriverClass.class);

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void initDriver() {

        try {

            String browser =
                    ConfigReader.getProperties()
                            .getProperty("browser");

            String headlessValue =
                    ConfigReader.getProperties()
                            .getProperty("headless");

            boolean headless =
                    headlessValue != null
                    && headlessValue.equalsIgnoreCase("true");

            logger.info("Initializing Browser: "
                    + browser);

            logger.info("Headless Mode: "
                    + headless);

            // CHROME
            if (browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options =
                        new ChromeOptions();

                if (headless) {

                    options.addArguments("--headless=new");
                }

                options.addArguments("--start-maximized");

                driver.set(new ChromeDriver(options));

            }

            // FIREFOX
            else if (browser.equalsIgnoreCase("firefox")) {

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions options =
                        new FirefoxOptions();

                // IMPORTANT FIX
                if (headless) {

                    options.addArguments("-headless");
                }

                driver.set(new FirefoxDriver(options));
            }

            // INVALID BROWSER
            else {

                logger.error("Invalid Browser Name: "
                        + browser);

                throw new RuntimeException(
                        "Invalid Browser Name: "
                        + browser);
            }

            getDriver().manage().window().maximize();

            logger.info("Browser launched successfully");

        } catch (Exception e) {

            logger.error("Driver Initialization Failed");

            e.printStackTrace();

            throw e;
        }
    }

    public static void quitDriver() {

        try {

            if (getDriver() != null) {

                logger.info("Closing browser session");

                getDriver().quit();

                driver.remove();
            }

        } catch (Exception e) {

            logger.error("Error while closing browser");

            e.printStackTrace();
        }
    }
}
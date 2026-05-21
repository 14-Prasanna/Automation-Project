package com.driver;

import com.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverClass {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(DriverClass.class);

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void initDriver() {

        String browser = ConfigReader.getProperties().getProperty("browser");
        String headlessValue = ConfigReader.getProperties().getProperty("headless");

        boolean headless = headlessValue != null &&
                headlessValue.equalsIgnoreCase("true");

        logger.info("Initializing Browser: " + browser);
        logger.info("Headless Mode: " + headless);

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Headless
            if (headless) {
                options.addArguments("--headless=new");
            }

            // Recommended options for Jenkins / Headless
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-blink-features=AutomationControlled");

            // Page load strategy
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            // Headless
            if (headless) {
                options.addArguments("--headless");
            }

            // Window size
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");

            driver.set(new FirefoxDriver(options));

        } else {

            logger.error("Invalid Browser Name: " + browser);
            throw new RuntimeException("Invalid Browser Name: " + browser);
        }

        // Maximize browser
        getDriver().manage().window().maximize();

        // Delete cookies
        getDriver().manage().deleteAllCookies();

        // Page load timeout
        getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(60));

        // Script timeout
        getDriver().manage().timeouts()
                .scriptTimeout(Duration.ofSeconds(30));

        logger.info("Browser launched successfully");
    }

    public static void quitDriver() {

        if (getDriver() != null) {

            logger.info("Closing browser session");

            getDriver().quit();

            driver.remove();
        }
    }
}

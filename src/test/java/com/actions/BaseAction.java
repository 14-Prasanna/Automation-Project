package com.actions;

import com.driver.DriverClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BaseAction {

    public void click(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String msg) {

        try {

            element.clear();
            element.sendKeys(msg);

        } catch (Exception e) {

            ((JavascriptExecutor) DriverClass.getDriver())
                    .executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            element);

            element.clear();
            element.sendKeys(msg);
        }
    }

    // THIS METHOD WAS MISSING
    public void sendKeysWithEnter(WebElement element, String msg) {

        try {

            element.clear();
            element.sendKeys(msg, Keys.ENTER);

        } catch (Exception e) {

            ((JavascriptExecutor) DriverClass.getDriver())
                    .executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            element);

            element.clear();
            element.sendKeys(msg, Keys.ENTER);
        }
    }
}
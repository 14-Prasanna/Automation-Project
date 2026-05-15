package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopByCategoryPage extends BasePage {

    public ShopByCategoryPage(WebDriver driver) {

        super(driver);
    }

    // Shop By Category Menu
    @FindBy(xpath="//body[1]/div[1]/div[5]/header[1]/div[3]/div[1]/div[1]/div[2]/a[1]/span[1]/*[name()='svg']/*[name()='use']")
    public WebElement shopByCategoryMenu;
    // Desktops & Monitors
    @FindBy(xpath = "//span[normalize-space()='Desktops and Monitors']")
    public WebElement desktopsCategory;

    // Web Cameras
    @FindBy(xpath = "//span[normalize-space()='Web Cameras']")
    public WebElement cameras;

    // Phone, Tablets & Ipod
    @FindBy(xpath = "//span[normalize-space()='Phone, Tablets & Ipod']")
    public WebElement tablets;

    // Laptops & Notebooks
    @FindBy(xpath = "//span[normalize-space()='Laptops & Notebooks']")
    public WebElement laptops;
}

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class FilterPage {

	WebDriver driver;

	public FilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='mz-filter-panel-0-0']//input[@placeholder='Minimum Price']")
	public WebElement minimumPrice;

	@FindBy(xpath = "//div[@id='mz-filter-panel-0-0']//input[@placeholder='Maximum Price']")
	public WebElement maxPrice;

	@FindBy(xpath = "//label[@for='mz-fm-0-8']")
	public WebElement Applebtn;

//	@FindBy(xpath = "//label[@for='mz-fss-0--1']")
//	public WebElement inStockCheckBox;
//
//	@FindBy(xpath = "//select[@id='input-sort-212403']")
//	public WebElement sortBy;
//
//	@FindBy(xpath = "//*[@id='input-sort-212403']/option[6]")
//	public WebElement Name;
//
//	@FindBy(xpath = "//select[@id='input-limit-212402']")
//	public WebElement show;
//
//	@FindBy(xpath = "//*[@id='input-limit-212402']/option[1]")
//	public WebElement showProduct;
}
package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.pages.FilterPage;

public class FilterPageAction extends BasePageAction {

	FilterPage fp;
	WebDriver driver;

	public FilterPageAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		fp = new FilterPage(driver);
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void enterMinimumPrice(String minPrice) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\"div[id='mz-filter-panel-0-0'] input[placeholder='Minimum Price']\")", fp.minimumPrice, minPrice);
	}

	public void enterMaximumPrice(String maxPrice) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', {bubbles: true}));", fp.maxPrice, maxPrice);
	}
	public void FilterBymanufacture() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fp.Applebtn);
	}
	
}
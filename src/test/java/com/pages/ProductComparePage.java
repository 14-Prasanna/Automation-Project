package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage{

	public ProductComparePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	@FindBy(xpath = "//p[normalize-space()='You have not chosen any products to compare.']")
	public WebElement noProducts;
	@FindBy(xpath = "//strong[normalize-space()='iMac']")
	public WebElement iMacTitle;
	@FindBy(xpath = "//strong[normalize-space()='Canon EOS 5D']")
	public WebElement CanonSDtitle;

}

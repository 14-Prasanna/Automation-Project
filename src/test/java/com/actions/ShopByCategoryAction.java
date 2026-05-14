package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.driver.DriverClass;

public class ShopByCategoryAction extends DriverClass {
    WebDriver driver =DriverClass.getDriver();
	public void launchApplication() {

		driver.get("https://ecommerce-playground.lambdatest.io/");
		driver.manage().window().maximize();
	}

	public void clickShopByCategory() {

		driver.findElement(By.xpath("//span[text()='Shop by Category']")).click();
	}

	public void selectCategory(String category) {

		driver.findElement(By.linkText(category)).click();
	}

	public String getPageTitle() {

		return driver.getTitle();
	}
}
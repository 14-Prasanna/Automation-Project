package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.driver.DriverClass;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=DriverClass.getDriver();
		PageFactory.initElements(driver, true);
	}

}

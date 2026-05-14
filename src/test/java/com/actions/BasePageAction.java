package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageAction {

	WebDriver driver;

	public BasePageAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
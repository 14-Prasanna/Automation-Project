package com.stepDefinitions;

import com.actions.FilterPageAction;
import com.actions.LaunchPageAction;
import com.driver.DriverClass;
import com.pages.LaunchPages;
import com.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class FilterDefinitions {

	LaunchPages lp = new LaunchPages(DriverClass.getDriver());
	LaunchPageAction lpa=new LaunchPageAction(DriverClass.getDriver());
	FilterPageAction fpa = new FilterPageAction(DriverClass.getDriver());

	@Given("User is click on the Shop By categories Page and Click any one option")
	public void user_is_click_on_the_shop_by_categories_page_and_click_any_one_option() {

		String url = ConfigReader.getProperties().getProperty("url");

		lp.launchApplication(url);

		

		lpa.clickCategories();
		
	}

	@Then("User should verify the filter page title as {string}")
	public void user_should_verify_the_filter_page_title_as(String expectedTitle) {

		String actualTitle = fpa.getPageTitle();

		System.out.println("Actual Page Title : " + actualTitle);

		
	}

	@When("User applies price filter as {string} and {string}")
	public void user_applies_price_filter_as_and(String minPrice, String maxPrice) {

		fpa.enterMinimumPrice(minPrice);

		fpa.enterMaximumPrice(maxPrice);

		System.out.println("Price Filter Applied");
	}

	@Then("Products should display based on selected price range")
	public void products_should_display_based_on_selected_price_range() {

		System.out.println("Products displayed based on selected price range");

		// Add product validation logic here
	}

	@When("User selects manufacturer filter any element")
	public void user_selects_manufacturer_filter_any_element() {
		fpa.FilterBymanufacture();

		System.out.println("Manufacturer Filter Applied");
	}

	@Then("Products should display based on selected manufacturer")
	public void products_should_display_based_on_selected_manufacturer() {

		System.out.println("Products displayed based on selected manufacturer");

		// Add manufacturer validation logic here
	}
}
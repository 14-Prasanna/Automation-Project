@Smoke @ShopByCategory
Feature: Shop By Category Navigation -- Samiha 13/05/2026
  Description:
  Verify that the user is able to navigate to different product categories
  using the Shop By Category menu in the ecommerce application.

  Background:
    Given the user launches the ecommerce application

  @ValidCategoryNavigation
  Scenario Outline: Verify user can navigate using valid Shop By Category options
    When the user clicks on the Shop by Category menu
    And the user selects the  category
    Then the user should navigate to the Category page and the page title should contain "<Expected Title>"

    Examples:
      | Expected Title |
      | Monitors       |
      | Web Cameras    |
      | Tablets        |
      | Laptops        |

@WishlistFeature
Feature: Prasanna Venkatesh K / 15-05-2026  Wishlist Feature - LambdaTest Playground
  Description: Validate Wishlist functionality end-to-end

  Background:
    Given the user is on the home page
    And the user is a registered user
    And the user navigates to the Top Products section

  @WishlistFeature @Smoke @ProductAdded
  Scenario: Add iMac product to wishlist
    When the user selects the "iMac" product and adds it to the wishlist
    Then a wishlist success notification should be displayed
    And the user clicks the wishlist link from the notification popup
    Then the user should be redirected to the "My Wish List" page
    And the wishlist product details should match the selected product

  @Regression @MultipleProduct
  Scenario: Add multiple products to wishlist
    When the user adds multiple products to the wishlist
    Then all selected products should be displayed in the wishList page
#
#  @Regression @ValidateProductDetails
#  Scenario: Validate wishlist product details
#    When the user click the iMac product and add to the wishlist
#    And the user clicks wishList button
#    Then the application should navigate to the MyWishList page
#    And the user should see correct product name "iMac"
#    And the user should see correct product price
#    And the user should see correct stock status
#
#  @Smoke @RemoveProduct
#  Scenario: Remove product from wishlist
#    When the user click the iMac product and add to the wishlist
#    And the user clicks wishList button
#    Then the application should navigate to the MyWishList page
#    When the user removes the product from wishlist
#    Then the product should be removed successfully from wishList
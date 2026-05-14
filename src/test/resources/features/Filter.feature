Feature: Product Filter Functionality

  Background:
    Given User is click on the Shop By categories Page and Click any one option

  @VerifyFilterPage
  Scenario: Validate filter page title
    Then User should verify the filter page title as "Tablets"

  @VerifyPricefilter
  Scenario: Validate filter by price
    When User applies price filter as "100" and "1000"
    Then Products should display based on selected price range

  @verifyByManufacture
  Scenario: Validate filter by manufacturer
    When User selects manufacturer filter any element
    Then Products should display based on selected manufacturer

  
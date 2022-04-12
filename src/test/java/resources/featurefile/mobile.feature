Feature: Mobile Search functionality validation
  User should be able to add and verify nokia mobile text message 'Added to cart' successfully

  @Smoke @Regression
  Scenario: User should be able to search the laptop in the search bar and add to the cart
    Given I am on homepage
    When I enter "mobile phone"
    And click on search bar
    And  click on Nokia check box
    And click on the product "Nokia XR20 5G | Android 11 | Unlocked Smartphone | Dual SIM | US Version | 6/128GB | 6.67-Inch Screen | 48MP Dual Camera | Polar Night"
    And change the quantity to "2"
    And click on add to cart button
    Then verify  message displayed "Added to Cart"
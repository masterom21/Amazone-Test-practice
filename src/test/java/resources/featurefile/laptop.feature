Feature: Laptop Search functionality validation
  User should be able to add and verify lenovo laptop text message 'Added to cart' successfully

  @Smoke @Sanity @Regression
  Scenario: User should be able to search the laptop in the search bar and add to the cart
    Given I am on homepage
    When I enter "laptop"
    And click on search bar
    And  click on Lenovo check box
    And click on the product "Lenovo ThinkBook 13s Gen 2 Intel Laptop 2022, 13.3" IPS 300 nits, 11th Intel i7-1165G7(up to 4.7GHz) 16GB RAM, 512GB SSD, Backlit Keyboard, Fingerprint Reader, Win 10 Pro"
    And change the quantity to "3"
    And click on add to cart button
    Then verify the message displayed "Added to Cart"

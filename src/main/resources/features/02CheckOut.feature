Feature: Checkout Process

  Scenario: Successful checkout process
    Given I am logged in to the application
    When I add a product to the cart
    And I proceed to checkout
    And I provide valid checkout information
    And I finish the checkout process
    Then I should see the order confirmation page

  Scenario: Failed checkout process with empty information
    Given I am logged in to the application
    When I add a product to the cart
    And I proceed to checkout
    And I provide empty checkout information
    Then I should see an error message indicating that the information is required
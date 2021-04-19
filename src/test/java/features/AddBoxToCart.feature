Feature: Add Box to Cart
  Add a random popular box to the shopping cart

  Scenario Outline: As a customer I add a popular box to the shopping cart
    Given I am navigated to the home page
    When I click on a <popular box> popular box
    And I add the <popular box> popular box to my shopping cart
    And I go to my shopping cart
    Then I can see the <popular box> popular box in my shopping cart

    Examples:
    | popular box |
    | pamper     |
    | birthday   |
    | adventure  |
    | getaway    |


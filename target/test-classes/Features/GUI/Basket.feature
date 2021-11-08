Feature: Add products to Basket and Validate

  @gui_basket_registerUSer
  Scenario Outline: Verify Products added to basket
    Given As a user I am on the takealot.com Homepage
    And  I register as a new user
    And verify a new user is created
    When I add the "<watchName>" to basket
    Then I verify the "<watchName>" is added in the basket
    And I verify the qty is 1 on the basket

    Examples:
     | watchName                                             |
     | Garmin Forerunner 45S Sports Smartwatch (39mm) - Iris |
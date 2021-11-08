Feature: Search products on takealot.com website

  @gui_search_fail
  Scenario: Search products on takealot.com
    Given As a user I am on the takealot.com Homepage
    When I search for "watches" on the search bar
    And I select brand "Garmin"
    And I search for "Garmin QuickFit 22mm Silicone Watch Band - Amp Yellow" in the searchbar
    Then I should able to see "Garmin QuickFit 22mm Silicone Watch Band - Amp Yellow" in the search results

  @gui_search_fail1
  Scenario: Search products on takealot.com
    Given As a user I am on the takealot.com Homepage
    When I search for "watches" on the search bar
    And I select brand "Garmin"
    And I search for "Garmin Forerunner 45S Sports Watch Black" in the searchbar
    Then I should able to see "Garmin Forerunner 45S Sports Watch Blackw" in the search results

  @gui_search_registerUSer_fail
  Scenario Outline: Search products on takealot.com as a registered user
    Given As a user I am on the takealot.com Homepage
    And  I register as a new user
    And verify a new user is created
    When I search for "<product>" on the search bar
    And I select brand "<brand>"
    And I search for "<watchName>" in the searchbar
    Then I should able to see "<watchName>" in the search results
    Examples:
      | product | brand  | watchName                                             |
      | watches | Garmin | Garmin Forerunner 45S Sports Watch Black              |

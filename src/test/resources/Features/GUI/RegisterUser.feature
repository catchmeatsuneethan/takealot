Feature: Register a new user in takealot.com website

  @gui_register
  Scenario: As a new user register with takealot.com
    Given As a user I am on the takealot.com Homepage
    When I register as a new user
    Then verify a new user is created
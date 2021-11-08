Feature:OpenWeather API - Onecall with longitude and laitidue

  @Api
  Scenario: Verify with longitude and laitidue OneCall API
    Given I made a Get request on "onecall?" API with Latitude "33.44",Longitude "-94.04" "exclude=hourly,daily"
    When the status code should be 200
    Then I should verify the response from the server with following response:
      | lat   | lon    | timezone        |
      | 33.44 | -94.04 | America/Chicago |


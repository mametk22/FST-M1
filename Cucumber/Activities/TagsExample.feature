Feature: Basic syntax for cucumber files

  Scenario: This is Scenario1
    Given User is on TS homepage
    When User clicks About Us button
    Then About Us page should open
    And Close the browser

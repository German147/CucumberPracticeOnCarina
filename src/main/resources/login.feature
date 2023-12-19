Feature: feature to test login functionality

  Scenario: Check login is successful with a valid credential

    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigating to the home page

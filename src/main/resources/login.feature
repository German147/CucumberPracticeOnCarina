Feature: feature to test login functionality

  Scenario: Check login is successful with a valid credential

    Given user is on login page
    When user enters username and password
    Then Product title must be present

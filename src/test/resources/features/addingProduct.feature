Feature: SauceDemo web Page Practice
  It is created a log in and add product to chart.

  @demo
  Scenario: SauceDemo open page - Log in - add product to chart - check product is added.
    Given user is on login page
    When user enters username and password
    And if DB product is present it is added to chart
    Then Product title must be present in chart orders
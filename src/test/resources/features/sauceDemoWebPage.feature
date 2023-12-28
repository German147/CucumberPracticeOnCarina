Feature: SauceDemo web Page Practice
  In order to use Cucumber in my project, I want to check how to test SauceDemo Web page

  @demo
  Scenario: SauceDemo open page - passing
    Given user is on login page
    When user enters username and password
    Then Product title must be present
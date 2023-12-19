Feature: SauceDemo web Page Practice
  In order to use Cucumber in my project, I want to check how to test SauceDemo Web page

  @demo
  Scenario: SauceDemo open page - passing
    Given I am on main page
    When I log in.
    Then Products page should be opened
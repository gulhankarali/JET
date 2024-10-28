@Login
Feature: As a customer I want to order food
  Scenario: Order food
    Given I am in the initial screen
    When click the "Initial" button
    Then I am in the "Cookies" screen
    And click the "Cookie settings" button on Cookies screen
    And click the "Enter address manually" button on the next screen

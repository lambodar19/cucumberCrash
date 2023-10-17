Feature: Login Function Test for orange HRM

  Background:
  Given I am on the OpenHRM login screen

  Scenario: Successful login with valid credentials
    Given I have entered valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid credentials
    When I entered invalid "<username>" and "<password>"
    When I click on Login button
    Then show error message "<Error Message>"
    Examples:
      | username | password | Error Message       |
      | test     | test     | Invalid credentials |
      | test1    | test1    | Invalid credentials |
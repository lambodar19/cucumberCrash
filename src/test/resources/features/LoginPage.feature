Feature: Login Function Test for orange HRM

  Scenario: Successful login with valid credentials
    Given I have entered valid username "Admin" and password "admin123"
    When I click on the login button
    Then I should be logged in successfully
    And The title of the page should be "OrangeHRM"

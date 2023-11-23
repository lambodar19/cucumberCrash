Feature: Dashboard All Validations
  Background:
    Given user is already logged in
    |username|password|
    |   Admin    |       admin123 |

    Scenario: User verifies dashboard landing
    When user sees the dashboard icon
    Then user is on dashboard screen

Feature: Checking login functionality

  Scenario: Successful Login with Valid Credentials
    Given User is on Login Page
    When User enters Credentials to LogIn
      | Admin | admin123 |
    Then Message displayed Login Successfully

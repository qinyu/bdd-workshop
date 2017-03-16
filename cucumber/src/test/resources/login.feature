Feature: Login WordPress

  Background:
    Given open the home page
    When click login

  @happy
  Scenario: Successful open login page
    Then open the login page successful

  @happy @smoke
  Scenario: login WordPress Successfully
    When login with username "admin" and password "123456"
    Then login successfully

  @fail @smoke
  Scenario Outline: login WordPress failed
    When login with username "<user>" and password "<password>"
    Then login failed with message "<error>"
    Examples:
      | user  | password | error                                                                                    |
      | admin | 111111   | ERROR: The password you entered for the username admin is incorrect. Lost your password? |
      | qinyu | 123456   | ERROR: Invalid username. Lost your password?                                             |
      | admin |          | ERROR: The password field is empty.                                                      |
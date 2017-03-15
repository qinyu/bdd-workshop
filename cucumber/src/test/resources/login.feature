Feature: Login WordPress

  Scenario: Successful open login page
    Given open the home page
    When click login
    Then open the login page successful

  @smoke
  Scenario: login WordPress Successfully
    Given open the home page
    When click login
    When login with username "admin" and password "123456"
    Then login successfully
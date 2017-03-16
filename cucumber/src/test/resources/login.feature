Feature: Login WordPress
  Background:
    Given open the home page
    When click login

  Scenario: Successful open login page
    Then open the login page successful

  Scenario: login WordPress Successfully
    When login with username "admin" and password "123456"
    Then login successfully

  Scenario: login WordPress failed
    When login with username "admin" and password "1234567"
    Then login failed with message "ERROR: The password you entered for the username admin is incorrect. Lost your password?"


  Scenario: login WordPress failed
    When login with username "admin" and password "1234567"
    Then login failed with message "ERROR: The password you entered for the username admin is incorrect. Lost your password?"


  Scenario: login WordPress failed
    When login with username "admin" and password "1234567"
    Then login failed with message "ERROR: The password you entered for the username admin is incorrect. Lost your password?"

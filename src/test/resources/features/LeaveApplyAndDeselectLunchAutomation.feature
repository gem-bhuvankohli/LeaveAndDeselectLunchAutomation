@test1
Feature: Leave Apply and Deselect Lunch Automation

  Scenario: Implementing login functionality
    Given  Verify error handling for invalid credentials or SSO failure
    Then   Verify successful login via credentials
    Then   Verify website loaded successfully with url "https://mymis.geminisolutions.com/"

  Scenario: Automatic leave apply
    Given Verify leave date functionality (From-Till)
    When  Verify reason box
    And   Verify availability checkbox
    Then  Verify leave apply

  Scenario: Automatic deselect lunch
    Given Verify entries in Apply For Lunch
    Then  Verify deletion of matching entries

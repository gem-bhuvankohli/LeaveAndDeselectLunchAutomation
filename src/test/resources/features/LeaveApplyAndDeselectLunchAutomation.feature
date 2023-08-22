@AutomatingMIS
Feature: Leave Apply and Deselect Lunch Automation

  Scenario: Implementing login functionality
    Given the user attempts to log in with invalid credentials or encounters SSO failure
    Then an appropriate error message should be displayed

    Given the user successfully logs in using valid credentials
    Then the website should load successfully with the URL "https://mymis.geminisolutions.com/"

  Scenario: Automatic leave apply
    Given the user verifies the functionality to select leave dates (From-Till)
    When the user verifies the presence of the reason input box
    And the user verifies the functionality of the availability checkbox
    Then the user should be able to apply for leave automatically

  Scenario: Automatic deselect lunch
    Given the user verifies the entries in the "Apply For Lunch" section
    Then the user verifies the ability to delete matching entries for lunch application

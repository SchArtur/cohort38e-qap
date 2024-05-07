Feature: Search

  Background: open browser
    Given User launch Chrome browser
    When User open ilcarro Home Page

  @validSearch
  Scenario: Successful car search
    And User enter city "Berlin"
    And User click on dropdown with name of city
    And User click on datePicker
    And User click on dates in datePicker
    And User click button search!
    Then User checked success message after search

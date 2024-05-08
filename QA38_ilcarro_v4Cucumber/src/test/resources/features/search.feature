Feature: Search

  Background: open browser
    Given User launch Chrome browser
    When User open ilcarro Home Page

  @validSearch
  Scenario: Successful car search
    And User enter city "Haifa"
    And User click on dropdown with name of city
    And User click on datePicker
    And User click on dates in datePicker
    And User click button Yalla!
    Then User checked success adding car after search

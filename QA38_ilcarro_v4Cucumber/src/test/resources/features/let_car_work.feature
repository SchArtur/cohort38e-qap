Feature: LetTheCarWork

  Background: open browser
    Given User launch Chrome browser
    When User open ilcarro Home Page
    And User click Log in link

  @unValidSearchs
  Scenario: Unsuccessful ability to rent car
    And User enter email "neuer+1@gm.com", and password  "Manuel1234!"
    And User click Y'alla!
    And User click Let the car work link
    And User enter address "Amsterdam Airport Schiphol (AMS), Aankomstpassage, Schiphol, Netherlands", manufacture "Germany", model "Audi RS8", year "2022", seats "2", carClass "passenger сar", registrationNumber "D2JYJ6WFOG", and price "900"
    And User click fuel
    And User choose option petrol in fuel dropdown
    And User fill about
    And User add photo
    And User click button Submit
    And User click button Ok
    And User checked unsuccessful message after submit

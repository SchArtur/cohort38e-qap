Feature: LetTheCarWork

  Background: open browser
    Given User launch Chrome browser
    When User open ilcarro Home Page
    And User click Log in link

  @unValidSearch
  Scenario: Unsuccessful ability to rent car
    And User enter email "neuer+1@gm.com", and password  "Manuel1234!"
    And User click Y'alla!
    And User click Let the car work link
    And User enter address "Haifa", manufacture "Germany", model "Audi RS8", year "2022", seats "2", carClass "passenger сar", registrationNumber "D2JYJ6WFOGGAB", and price "900"
    And User click fuel
    And User choose option petrol in fuel dropdown
    And User fill about
    And User add photo
    And User click button Submit
    And User checked successful message after submit

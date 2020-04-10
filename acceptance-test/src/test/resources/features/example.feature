@Facility
Feature: User would like to get facilities

  Scenario: User should be able to get all facilities
    Given the following facilities exists in the library
      | description                 |
      | Twinkle twinkle little star |
    When user requests for all facilities
    Then the user gets the following facilities
      | description                 |
      | Twinkle twinkle little star |

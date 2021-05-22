@regression
Feature: Another Function

  Scenario: another scenario

    Given the user is on the "search" page
    When registration filter is year "2018" and "bis" selected
    And sorting option is as "Niedrigster Preis" selected
    Then all cars' registrations should be 2018 and "older"
    And all cars are sorted by price "ascending1"
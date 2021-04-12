Feature: Search Function
  @wip
    #1
  Scenario: verify using "first registiration filter" and "price sorting"
    #2
    Given the user is on the "search" page
    #3
    When registration filter is year "2015" and "ab" selected
    #4
    And sorting option is as "Höchster Preis" selected
    #5
    Then all cars' registrations should be 2015 and "newer"
    #6
    And all cars are sorted by price "descending"

    #1 scenario methods are parameterized for versatility and reusability.
    #2 only "search" page is available. future page adding is possible.
    #3 any year(string) and "ab" or "bis" can be selected.
    #4 other sort options also can be entered ex:"Niedrigster Preis".
    #5 any year(int) together with "newer" and "older" options are selectable
    #6 "ascending" or "descending" options are available for verifying.
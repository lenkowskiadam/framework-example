Feature: Automate second test cases from exercise

  Scenario: Test scenario three
    Given user go to https://qualityminds.com/de/karriere/stellenangebote/
    When he validate that at least one job offer is available
    And in the first (top, left) box click Erfahre mehr
    Then job offer is displayed
    When user click send button
    Then validation message were displayed for 4 fields

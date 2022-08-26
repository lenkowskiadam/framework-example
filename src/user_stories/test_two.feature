Feature: Automate second test cases from exercise

  Scenario: Test scenario one
    Given user is on QualityMinds page
    When he check that he see English version
    Then British flag is displayed on page navigation bar (en.png)
    When he hover over ABOUT US
    Then Submenu is displayed
    When he click on EVENTS
    Then Event page is displayed

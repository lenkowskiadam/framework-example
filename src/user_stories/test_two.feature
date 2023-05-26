Feature: Automate second test cases from exercise

  Scenario: Test scenario one
    Given user is on QualityMinds page
    When he check that he see English version
    Then British flag is displayed on page navigation bar (en.png)

    When he hover over ABOUT US
    Then Submenu is displayed

    When he click on EVENTS
    Then Event page is displayed

    When user in 'Search for events' bar type 2021 and click Find Events
    Then results page displays 'Now onwards' option

    When user click down arrow next to 'Now onwards'
    Then calendar is displayed

    When user navigate through the calendar to December 2021 and select day 31
    Then 'Now onwards' is replaced with 'December 31, 2021 onwards'
    And result is ICSTTP 2021, dated 2022-01-04
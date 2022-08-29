Feature: Automate first test cases from exercise

  Scenario: Test scenario one
    Given user is on QualityMinds page
    When he hover over the language manu and click German flag
    Then German version of the page is displayed
    And page url is https://qualityminds.com/de/
    When he hover over Portfolio and click Automatisiertes Testen
    Then Automatisiertes Testen page is displayed
    When he check Kontaktiere Uns button
    Then there will be link with: mailto:testing@qualityminds.de
    When user navigate back to www.qualityminds.com
    Then user is on QualityMinds page
    And british flag is displayed on page navigation bar
    When user hover over Services and click Test Automation
    Then Automation page is displayed
    When user hover language menu and click German flag
    Then Automatisieres Testen page is displayed
    And pages from after click on Automatisiertes Testen and German flag are the same
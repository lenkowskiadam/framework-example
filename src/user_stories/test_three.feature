Feature: Automate second test cases from exercise

  Scenario: Test scenario three
    Given user go to https://qualityminds.com/de/karriere/stellenangebote/
    When he validate that at least one job offer is available
    And in the first (top, left) box click Erfahre mehr
    Then job offer is displayed
    When user click send button
    Then validation message were displayed for 4 fields
    When user type a name in Vorname und Nachname input
    Then validation message under filled-in input is not displayed anymore
    And validation messages is displayed for remaining 3 fields
    When user In email input enter smiling face emoji (Unicode U+1F60A)
    Then validation message changed from “This field is required” to “Please enter a valid email address"
    When user read the first 10 words of job description on the left panel
    And copy them to Bewerbungsschreiben input
    Then validation message under filled-in input is not displayed anymore
    When user attach file with DATEIEN HOCHLADEN button
    Then file name is displayed on the button
    When user check the checkbox for Datenschutzerklärung
    Then checkbox is ticked
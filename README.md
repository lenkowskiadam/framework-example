
* Master branch contains three test cases for interview.
* Framework is built using Page Object Pattern so in 'src/main/java' folder you will find two packages one with 'configuration' and 'pages' with all pages that was used to write tests.
* In 'src/test/java/tests' you will find three test cases.
* In 'src/user_stories' you will find user stories wrote in Gherkin language and Cucumber tool. They are ready to implement to this framework.  

## Setup
* Clone the repo.
* Install dependencies 'mvn install'.

## Running tests
* To run test click on play button on the left side.
* To run all tests select 'tests' in top menu and click play button.

## Change browser
* By default tests are run on Chrome browser, to change for Firefox go to 'tests.AbstractTest' and change from 'Chrome' to 'Firefox' in 'String browserName'.

## Reports
* Reports are provided by Allure.
* To generate and view report after test write in terminal 'allure serve allure-results' and perform.

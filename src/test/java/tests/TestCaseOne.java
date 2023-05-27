package tests;

import org.testng.annotations.Test;
import pages.AutomatisiertesTestenPage;
import pages.HomePage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class TestCaseOne extends AbstractTest {

    @Title("Test case one")
    @Description("Test case one for interview")
    @Test
    public void testCaseOne() {

        HomePage homePage = new HomePage(driver);

        //GIVEN user is on main page
        homePage.checkPageIsDisplayed();

        //WHEN he changed language to German
        homePage.changeLanguageToGerman();

        //AND go to Automatisiertes Testen Page
        homePage.goToAutomatisiertesTestenPage();

        AutomatisiertesTestenPage automatisiertesTestenPage = new AutomatisiertesTestenPage(driver);

        //AND check contact us button
        automatisiertesTestenPage.checkKontaktiereUnsButton();

        //AND go to home page
        automatisiertesTestenPage.goToHomePage();

        //THEN page is displayed
        homePage.checkPageIsDisplayed();

        //AND british flag is displayed on page navigation bar
        homePage.verifyEnglishVersion();

        //WHEN we go to Test Automation Page
        homePage.goToTestAutomationPage();

        //AND click on the German flag
        homePage.clickOnGermanFlagAndCheckPage();

        //THEN pages are the same
        homePage.checkIfPagesAreTheSame();
    }
}
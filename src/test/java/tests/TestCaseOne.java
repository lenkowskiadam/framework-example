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
        homePage.checkPageIsDisplayed();
        homePage.changeLanguageToGerman();
        homePage.goToAutomatisiertesTestenPage();

        AutomatisiertesTestenPage automatisiertesTestenPage = new AutomatisiertesTestenPage(driver);
        automatisiertesTestenPage.checkKontaktiereUnsButton();
        automatisiertesTestenPage.goToHomePage();

        homePage.checkPageIsDisplayed();
        homePage.verifyEnglishVersion();
        homePage.goToTestAutomationPage();
        homePage.clickOnGermanFlagAndCheckPage();
        homePage.checkIfPagesAreTheSame();
    }
}
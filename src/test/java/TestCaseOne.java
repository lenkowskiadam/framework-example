import org.testng.annotations.Test;
import pages.AutomatisiertesTestenPage;
import pages.HomePage;

public class TestCaseOne extends AbstractTest {

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
    }
}

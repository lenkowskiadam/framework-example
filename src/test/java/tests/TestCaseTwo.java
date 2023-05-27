package tests;

import org.testng.annotations.Test;
import pages.EventsPage;
import pages.HomePage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class TestCaseTwo extends AbstractTest {

    private final String eventName = "2021";

    @Title("Test case two")
    @Description("Test case two for interview")
    @Test
    public void testCaseTwo() {

        //GIVEN user is on the QM page
        HomePage homePage = new HomePage(driver);
        homePage.checkPageIsDisplayed();

        //WHEN he check that this is English version
        homePage.verifyEnglishVersion();

        //THEN About Us menu is visible
        homePage.checkAboutUsSubmenuIsDisplayed();

        //WHEN he go to Event Submenu
        homePage.goToEventSubmenu();
        EventsPage eventsPage = new EventsPage(driver);

        //AND accept cookie banner
        eventsPage.acceptCookieBanner();

        //THEN "No results found" information is visible
        eventsPage.checkNoResultsFound();
    }
}
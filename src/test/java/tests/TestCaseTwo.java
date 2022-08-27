package tests;

import org.testng.annotations.Test;
import pages.EventsPage;
import pages.HomePage;

public class TestCaseTwo extends AbstractTest{

    private final String eventName = "2021";

    @Test
    public void testCaseTwo() {
        HomePage homePage = new HomePage(driver);
        homePage.checkPageIsDisplayed();
        homePage.verifyEnglishVersion();
        homePage.checkAboutUsSubmenuIsDisplayed();
        homePage.goToEventSubmenu();

        EventsPage eventsPage = new EventsPage(driver);
        eventsPage.searchEvents(eventName);
        eventsPage.checkSearchingResult();
        eventsPage.acceptCookieBanner();
        eventsPage.checkCalendar();
        eventsPage.goToDecemberAndSelectDay();
        eventsPage.checkNowOnwardsOptionButton();
        eventsPage.checkEventsTitle();
        eventsPage.checkEventDate();

    }
}

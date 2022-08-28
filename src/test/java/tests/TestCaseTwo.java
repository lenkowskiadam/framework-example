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
        HomePage homePage = new HomePage(driver);
        homePage.checkPageIsDisplayed();
        homePage.verifyEnglishVersion();
        homePage.checkAboutUsSubmenuIsDisplayed();
        homePage.goToEventSubmenu();

        EventsPage eventsPage = new EventsPage(driver);
        eventsPage.acceptCookieBanner();
        eventsPage.searchEvents(eventName);
        eventsPage.checkSearchingResult();
        eventsPage.checkCalendar();
        eventsPage.goToDecemberAndSelectDay();
        eventsPage.checkNowOnwardsOptionButton();
        eventsPage.checkEventsTitle();
        eventsPage.checkEventDate();
    }
}
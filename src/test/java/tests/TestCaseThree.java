package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobOfferPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class TestCaseThree extends AbstractTest {

    @Title("Test case three")
    @Description("Test case three for interview")
    @Test
    public void testThree() {
        HomePage homePage = new HomePage(driver);
        homePage.goToJobOfferPage();

        JobOfferPage jobOfferPage = new JobOfferPage(driver);
        jobOfferPage.checkPageTitle();
        jobOfferPage.acceptCookieBanner();
        jobOfferPage.checkJobsOffers();
        jobOfferPage.clickOnFirstJobOffer();
        jobOfferPage.checkValidationMessage();
        jobOfferPage.typeNameAndValidateMessages();
        jobOfferPage.insertEmojiAndValidateMessages();
        jobOfferPage.takeWordsFromDescriptionAndCopy();
        jobOfferPage.attachFile();
        jobOfferPage.clickAndCheckOnCheckbox();
    }
}
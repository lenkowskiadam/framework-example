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

        //GIVEN user is on the home page
        HomePage homePage = new HomePage(driver);

        //WHEN he go to Job Offer page
        homePage.goToJobOfferPage();

        //THEN page title is correct
        JobOfferPage jobOfferPage = new JobOfferPage(driver);
        jobOfferPage.checkPageTitle();

        //WHEN he accept cookie banner
        jobOfferPage.acceptCookieBanner();

        //AND check if there is more than one job offer
        jobOfferPage.checkJobsOffers();

        //AND click on the first job offer
        jobOfferPage.clickOnFirstJobOffer();

        //AND check validation of all fields
        jobOfferPage.checkValidationMessage();

        //AND add name to the first field and validate all
        jobOfferPage.typeNameAndValidateMessages();

        //AND add emoji and validate all fields
        jobOfferPage.insertEmojiAndValidateMessages();

        //AND take first 10 words from job description and pass to description filed
        jobOfferPage.takeWordsFromDescriptionAndCopy();

        //AND attach file
        jobOfferPage.attachFile();


        jobOfferPage.clickAndCheckOnCheckbox();
    }
}
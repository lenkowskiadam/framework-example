package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobOfferPage;

public class TestCaseThree extends AbstractTest {

    @Test
    public void testThree() {

        HomePage homePage = new HomePage(driver);
        homePage.goToJobOfferPage();

        JobOfferPage jobOfferPage = new JobOfferPage(driver);
        jobOfferPage.checkPageTitle();
    }
}
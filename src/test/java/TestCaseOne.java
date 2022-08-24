import org.testng.annotations.Test;
import pages.HomePage;

public class TestCaseOne extends AbstractTest {

    @Test
    public void testCaseOne() {
        HomePage homePage = new HomePage(driver);
        homePage.changeLanguageToGerman();
    }

}

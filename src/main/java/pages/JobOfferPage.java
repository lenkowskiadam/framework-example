package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class JobOfferPage extends AbstractPage{

    @FindBy(xpath = "//h1[@class='et_pb_module_header']")
    WebElement pageTitle;

    @Step("Check page title")
    public void checkPageTitle(){
        String expectedTitle = "Stellenangebote";
        Assert.assertEquals(expectedTitle, pageTitle.getText());
    }

    public JobOfferPage(WebDriver driver) {
        super(driver);
    }
}
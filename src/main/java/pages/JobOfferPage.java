package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class JobOfferPage extends AbstractPage{

    @FindBy(xpath = "//h1[@class='et_pb_module_header']")
    WebElement pageTitle;

    @FindBy(xpath = "//div[@id='awsm-grid-item-35043']//a")
    WebElement firstJobOffer;

    @FindBy(xpath = "//button[@class='cmplz-btn cmplz-accept']")
    WebElement acceptCookieBannerButton;

    @Step("Check page title")
    public void checkPageTitle(){
        String expectedTitle = "Stellenangebote";
        Assert.assertEquals(expectedTitle, pageTitle.getText());
    }

    @Step("Validate that at least one job is available")
    public void checkJobsOffers(){
        List<WebElement> numberOfElements = driver.findElements(By.xpath("//a[@class='awsm-job-item']"));
        int number = numberOfElements.size();
        Assert.assertTrue(number > 1);

    }

    @Step("Click on the first job offer")
    public void clickOnFirstJobOffer(){
        firstJobOffer.click();

    }

    @Step("Accept cookie banner")
    public void acceptCookieBanner() {
        acceptCookieBannerButton.click();
    }

    public JobOfferPage(WebDriver driver) {
        super(driver);
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class AutomatisiertesTestenPage extends AbstractPage {

    private final int MAX_WAIT = 30;
    private final String email = "mailto:testing@qualityminds.de";

    @FindBy(xpath = "//a[contains(@class,'et_pb_bg_layout_light')]")
    WebElement kontaktiereUnsButton;

    @Step("Check Kontaktiere Uns button")
    public void checkKontaktiereUnsButton() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.visibilityOf(kontaktiereUnsButton));

        String text = kontaktiereUnsButton.getAttribute("href");
        String[] parts = text.split("subject");
        String emailPart = parts[0].replace("?", " ").trim();
        String rest = parts[1];

        Assert.assertEquals(emailPart, email);
    }

    @Step("Go to the home page")
    public void goToHomePage() {
        driver.navigate().to("http://www.qualityminds.com");
    }

    public AutomatisiertesTestenPage(WebDriver driver) {
        super(driver);
    }
}
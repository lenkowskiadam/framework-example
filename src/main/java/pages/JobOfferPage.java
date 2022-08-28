package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class JobOfferPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='et_pb_module_header']")
    WebElement pageTitle;

    @FindBy(xpath = "//div[@id='awsm-grid-item-35043']//a")
    WebElement firstJobOffer;

    @FindBy(xpath = "//button[@class='cmplz-btn cmplz-accept']")
    WebElement acceptCookieBannerButton;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'text-group')]//div")
    WebElement messageBelowNameField;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'email-group')]//div")
    WebElement messageBelowEmailField;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'tel-group')]//div")
    WebElement messageBelowTelephoneField;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'textarea-group')]//div")
    WebElement messageBelowTextField;

    @FindBy(xpath = "//input[@id='awsm-application-submit-btn']")
    WebElement sendButton;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'text-group')]//input")
    WebElement nameField;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'email-group')]//input")
    WebElement emailField;

    @Step("Check page title")
    public void checkPageTitle() {
        String expectedTitle = "Stellenangebote";
        Assert.assertEquals(expectedTitle, pageTitle.getText());
    }

    @Step("Validate that at least one job is available")
    public void checkJobsOffers() {
        List<WebElement> numberOfElements = driver.findElements(By.xpath("//a[@class='awsm-job-item']"));
        int number = numberOfElements.size();
        Assert.assertTrue(number > 1);

    }

    @Step("Click on the first job offer")
    public void clickOnFirstJobOffer() {
        firstJobOffer.click();

    }

    @Step("Accept cookie banner")
    public void acceptCookieBanner() {
        acceptCookieBannerButton.click();
    }

    @Step("Check validation message on fields")
    public void checkValidationMessage() {
        sendButton.click();
        String message = "Dies ist ein Pflichtfeld.";

        Assert.assertEquals(message, messageBelowNameField.getText());
        Assert.assertEquals(message, messageBelowEmailField.getText());
        Assert.assertEquals(message, messageBelowTelephoneField.getText());
        Assert.assertEquals(message, messageBelowTextField.getText());
    }

    @Step("Type name and check validation fields")
    public void typeNameAndValidateMessages() {
        nameField.sendKeys("Adam");
        String message = "Dies ist ein Pflichtfeld.";

        Assert.assertNotEquals(message, messageBelowNameField.getText());
        Assert.assertEquals(message, messageBelowEmailField.getText());
        Assert.assertEquals(message, messageBelowTelephoneField.getText());
        Assert.assertEquals(message, messageBelowTextField.getText());
    }

    @Step("Insert emoji and check message")
    public void insertEmojiAndValidateMessages() {
        String emoji="😊";
        StringSelection stringSelection = new StringSelection(emoji);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        emailField.sendKeys(Keys.SHIFT, Keys.INSERT);
        messageBelowEmailField.click();
        String message = "Bitte gebe eine gültige E-Mail-Adresse ein.";

        Assert.assertEquals(message, messageBelowEmailField.getText());
    }

    public JobOfferPage(WebDriver driver) {
        super(driver);
    }
}
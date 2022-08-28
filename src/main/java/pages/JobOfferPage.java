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

    @FindBy(xpath = "//div[@class='awsm-job-entry-content entry-content']//p[@class='has-medium-font-size'][1]")
    WebElement jobDescriptionFirstParagraph;

    @FindBy(xpath = "//form[@id='awsm-application-form']//div[contains(@class,'textarea-group')]//textarea")
    WebElement textField;

    @FindBy(xpath = "//input[@id='awsm-application-file']")
    WebElement attachFileButton;

    @FindBy(xpath = " //div[@class='custom-input']")
    WebElement attachFileAfterUpload;

    @FindBy(xpath = "//input[@id='awsm_form_privacy_policy']")
    WebElement checkboxForDatenschutzerklärung;

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
        try {
            emailField.sendKeys("\uD83D\uDE0A");
        } catch (Exception ex) {
            System.out.println("Failed for Chrome trying other way");
        }
        try {
            String emoji = "\uD83D\uDE0A";
            StringSelection stringSelection = new StringSelection(emoji);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            emailField.sendKeys(Keys.SHIFT, Keys.INSERT);
            messageBelowEmailField.click();
        } catch (Exception exc) {
            System.out.println("Failed");
        }
        String message = "Bitte gebe eine gültige E-Mail-Adresse ein.";
        Assert.assertEquals(message, messageBelowEmailField.getText());
    }

    @Step("Take first 10 words from job description and copy to bewerbungsschreiben input ")
    public void takeWordsFromDescriptionAndCopy() {
        String text = jobDescriptionFirstParagraph.getText();
        String[] parts = text.split("Schwerpunkt");
        String firstPart = parts[0];
        String rest = parts[1];
        textField.sendKeys(firstPart);

        String message = "Dies ist ein Pflichtfeld.";
        Assert.assertNotEquals(message, messageBelowNameField.getText());
    }

    @Step("Attach file with DATEIEN HOCHLADEN button")
    public void attachFile() {
        attachFileButton.sendKeys("/Users/adamlenkowski/Documents/Java_Selnium_Projects/quality_minds/src/main/resources/sample.pdf");
        String pdfName = "sample.pdf";
        Assert.assertEquals(pdfName, attachFileAfterUpload.getText());
    }

    @Step("Click on checkbox and check if is selected")
    public void clickAndCheckOnCheckbox() {
        WebElement element = checkboxForDatenschutzerklärung;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Assert.assertTrue(checkboxForDatenschutzerklärung.isSelected());
    }

    public JobOfferPage(WebDriver driver) {
        super(driver);
    }
}
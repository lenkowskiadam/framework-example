package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventsPage extends AbstractPage {

    private final int MAX_WAIT = 30;

    @FindBy(xpath = "//input[@id='tribe-events-events-bar-keyword']")
    WebElement searchForEventsField;

    @FindBy(xpath = "//button[@name='submit-bar']")
    WebElement findEventsButton;

    @FindBy(xpath = "//div[contains(@class,'dot--third')]//div[contains(@class,'message--notice')]//li")
    WebElement searchingResult;

    @FindBy(xpath = "//span[contains(@class,'tribe-common-a11y-hidden')]")
    WebElement nowOnwardsOption;

    @FindBy(xpath = "//button[contains(@class,'top-bar__datepicker-button')]")
    WebElement datePickerButton;

    @FindBy(xpath = "//div[contains(@class,'datepicker-dropdown dropdown-menu')]")
    WebElement calendar;

    @FindBy(xpath = "//button[@class='cmplz-btn cmplz-accept']")
    WebElement acceptCookieBannerButton;

    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev']")
    WebElement previewDateButton;

    @FindBy(xpath = "//td[@data-date='1640908800000']")
    WebElement thirtyFirstOfDecemberButton;

    @FindBy(xpath = "//a[contains(@class,'tribe-common-anchor-thin')]")
    WebElement eventsTitle;

    @FindBy(xpath = "//time[@class='tribe-events-calendar-list__event-datetime']")
    WebElement eventDate;

    public void searchEvents(String eventsName) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(searchForEventsField));
        searchForEventsField.sendKeys(eventsName);
        findEventsButton.click();
    }

    public void checkSearchingResult() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.visibilityOf(searchingResult));

        String resultMessage = "There were no results found for \"2021\".";
        String actualResult = searchingResult.getText();
        Assert.assertEquals(resultMessage, actualResult);

        String buttonName = "Now onwards";
        Assert.assertEquals(buttonName, nowOnwardsOption.getText());
    }

    public void checkCalendar() {
        datePickerButton.click();
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.visibilityOf(calendar));
    }

    public void acceptCookieBanner() {
        acceptCookieBannerButton.click();
    }

    public void goToDecemberAndSelectDay() {
        for (int i = 0; i < 8; i++) {
            previewDateButton.click();
        }
        thirtyFirstOfDecemberButton.click();
    }

    @SneakyThrows
    public void checkNowOnwardsOptionButton(){
        Thread.sleep(2000);
        String buttonText = "December 31, 2021 onwards";
        Assert.assertEquals(buttonText, nowOnwardsOption.getText());
    }

    public void checkEventsTitle(){
        String expectedTitle = "ICSTTP 2021";
        String title = eventsTitle.getAttribute("title");
        String[] parts = title.split(":");
        String topic = parts[0];
        String rest = parts[1];

        Assert.assertEquals(expectedTitle, topic);
    }

    public void checkEventDate(){
        String expectedDate = "2022-01-04";
        String date = eventDate.getAttribute("datetime");

        Assert.assertEquals(expectedDate, date);
    }

    public EventsPage(WebDriver driver) {
        super(driver);
    }
}
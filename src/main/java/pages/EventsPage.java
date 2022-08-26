package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventsPage extends AbstractPage{

    private final int MAX_WAIT = 30;


    @FindBy(xpath = "//input[@id='tribe-events-events-bar-keyword']")
    WebElement searchForEventsField;

    @FindBy(xpath = "//button[@name='submit-bar']")
    WebElement findEventsButton;

    @FindBy(xpath = "//div[contains(@class,'dot--third')]//div[contains(@class,'message--notice')]//li")
    WebElement searchingResult;

    @FindBy(xpath = "//span[contains(@class,'tribe-common-a11y-hidden')]")
    WebElement nowOnwardsOption;

    public void searchEvents(String eventsName){
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(searchForEventsField));
        searchForEventsField.sendKeys(eventsName);
        findEventsButton.click();
    }

    public void checkSearchingResult(){
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.visibilityOf(searchingResult));

        String resultMessage = "There were no results found for \"2021\".";
        String actualResult = searchingResult.getText();
        Assert.assertEquals(resultMessage, actualResult);

        String buttonName = "Now onwards";
        Assert.assertEquals(buttonName, nowOnwardsOption.getText());
    }

    public EventsPage(WebDriver driver) {
        super(driver);
    }
}

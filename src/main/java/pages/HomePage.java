package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    private final int MAX_WAIT = 30;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,'menu-item-wpml-ls-18-en')]")
    WebElement changeLanguageMenu;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,'menu-item-wpml-ls-18-en')]//img[@alt='DE']")
    WebElement germanFlag;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,'menu-item-wpml-ls-18-en')]//img[@alt='EN']")
    WebElement britishFlag;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,'mega-menu')]")
    WebElement portfolioMenu;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'automatisiertes-testen')]")
    WebElement automatisiertesTestenButton;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,'menu-item-2527')]")
    WebElement servicesMenu;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class, 'menu-item-14241')]//a[contains(@href,'test-automation')]")
    WebElement testAutomationButton;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,' menu-item-3080')]//ul[@class='sub-menu']")
    WebElement aboutUsSubmenu;

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,' menu-item-3080')]")
    WebElement aboutUsMenu;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'events')]")
    WebElement eventsButton;

    @SneakyThrows
    public void changeLanguageToGerman() {
        Actions action = new Actions(driver);
        WebElement el = changeLanguageMenu;
        action.moveToElement(el).moveToElement(germanFlag).click().build().perform();
        Thread.sleep(3000);

        String expectedUrl = "https://qualityminds.com/de/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void checkPageIsDisplayed() {
        String pageTitle = "QualityMinds | Homepage";
        Assert.assertEquals(pageTitle, driver.getTitle());
    }

    @SneakyThrows
    public void goToAutomatisiertesTestenPage() {
        Actions action = new Actions(driver);
        WebElement el = portfolioMenu;
        action.moveToElement(el).moveToElement(automatisiertesTestenButton).click().build().perform();
        Thread.sleep(1000);

        String expectedUrl = "https://qualityminds.com/de/services/qa-kernkompetenzen/automatisiertes-testen/";
        String urlAfterClickOnTestenButton = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, urlAfterClickOnTestenButton);
    }

    public void verifyEnglishVersion() {
        String nationality = "EN";
        String flag = britishFlag.getAttribute("alt");

        Assert.assertEquals(flag, nationality);

    }

    @SneakyThrows
    public void goToTestAutomationPage() {
        Actions action = new Actions(driver);
        WebElement el = servicesMenu;
        action.moveToElement(el).moveToElement(testAutomationButton).click().build().perform();
        Thread.sleep(1000);

        String expectedUrl = "https://qualityminds.com/services/core-qa-services/test-automation/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @SneakyThrows
    public void clickOnGermanFlagAndCheckPage() {
        Actions action = new Actions(driver);
        WebElement el = changeLanguageMenu;
        action.moveToElement(el).moveToElement(germanFlag).click().build().perform();
        Thread.sleep(1000);

        String expectedUrl = "https://qualityminds.com/de/services/qa-kernkompetenzen/automatisiertes-testen/";
        String urlAfterClickOnFlag = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, urlAfterClickOnFlag);
    }

    public void checkIfPagesAreTheSame() {
        String currentUrl = driver.getCurrentUrl();
        Actions action = new Actions(driver);
        WebElement el = portfolioMenu;
        action.moveToElement(el).moveToElement(automatisiertesTestenButton).click().build().perform();
        String newUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, newUrl);
    }

    public void checkAboutUsSubmenuIsDisplayed() {
        Actions action = new Actions(driver);
        WebElement el = aboutUsMenu;
        action.moveToElement(el).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
        wait.until(ExpectedConditions.visibilityOf(aboutUsSubmenu));
        Assert.assertEquals(true, aboutUsSubmenu.isDisplayed());
    }

    @SneakyThrows
    public void goToEventSubmenu() {
        Actions action = new Actions(driver);
        WebElement el = aboutUsMenu;
        action.moveToElement(el).moveToElement(eventsButton).click().build().perform();

        Thread.sleep(1000);
        String expectedUrl = "https://qualityminds.com/events/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}

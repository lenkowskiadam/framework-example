package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends AbstractPage {

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



    public void changeLanguageToGerman() {
        Actions action = new Actions(driver);
        WebElement el = changeLanguageMenu;
        action.moveToElement(el).moveToElement(germanFlag).click().build().perform();

        String expectedUrl = "https://qualityminds.com/de/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public void checkPageIsDisplayed() {
        String pageTitle = "QualityMinds | Homepage";
        Assert.assertEquals(pageTitle, driver.getTitle());
    }

    public void goToAutomatisiertesTestenPage() {
        Actions action = new Actions(driver);
        WebElement el = portfolioMenu;
        action.moveToElement(el).moveToElement(automatisiertesTestenButton).click().build().perform();

        String expectedUrl = "https://qualityminds.com/de/services/qa-kernkompetenzen/automatisiertes-testen/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public void verifyEnglishVersion() {
        String nationality = "EN";
        String flag = britishFlag.getAttribute("alt");

        Assert.assertEquals(flag, nationality);

    }

    public HomePage(WebDriver driver) {
            super(driver);
        }
    }

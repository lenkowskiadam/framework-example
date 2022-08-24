package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//ul[@id='top-menu']//li[contains(@class,'menu-item-wpml-ls-18-en')]")
    WebElement changeLanguageMenu;

    @FindBy(xpath = "//img[@alt='DE']")
    WebElement germanFlag;

    public void changeLanguageToGerman(){
        Actions action = new Actions(driver);
        WebElement el = changeLanguageMenu;
        action.moveToElement(el).moveToElement(germanFlag).click().build().perform();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}

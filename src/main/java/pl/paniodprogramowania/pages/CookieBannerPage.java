package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookieBannerPage extends BasePage {

    public CookieBannerPage(WebDriver driver) {
        super(driver);
    }

    private final By cookieAcceptBtn = By.xpath("//button//div[contains(text(),'ciasteczka')]");

    @Override
    public boolean isLoaded() {
        return !driver.findElements(cookieAcceptBtn).isEmpty();
    }

    public boolean acceptIfVisible() {
        if (isLoaded()) {
            click(cookieAcceptBtn);
            return true;
        }
        return false;
    }
}

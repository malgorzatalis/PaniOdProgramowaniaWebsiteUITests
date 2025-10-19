package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    private final By logoMenuBtn = By.cssSelector("a[href='/']");
    private final By meMenuBtn = By.cssSelector("a[href='/about-me']");
    private final By beginnerMenuBtn = By.cssSelector("a[href=/course-from-zero']");
    private final By advanceMenuBtn = By.cssSelector("a[href=/course-for-it']");
    private final By trialMenuBtn = By.cssSelector("a[href=/code-better-than-ai']");
    private final By shopMenuBtn = By.cssSelector("a[href=/shop']");
    private final By loginMenuBtn = By.xpath("//button[.//div[normalize-space(text())='Zaloguj się']]");


    @Override
    public boolean isLoaded() {
        return isDisplayed(logoMenuBtn);
    }

    public void goToAboutMe() {
        click(meMenuBtn);
    }

    public void goToBeginnerCourse() {
        click(beginnerMenuBtn);
    }

    public void goToAdvanceCourse() {
        click(advanceMenuBtn);
    }

    public void goToTrailCourse() {
        click(trialMenuBtn);
    }

    public void goToShop() {
        click(shopMenuBtn);
    }

    public void openLogin(){
        click(loginMenuBtn);
    }
}

package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    private final By logoMenuBtn = By.cssSelector("a[href='/']");
    private final By meMenuBtn = By.cssSelector("a[href='/about-me']");
    private final By beginnerMenuBtn = By.cssSelector("a[href='/course-from-zero']");
    private final By advanceMenuBtn = By.cssSelector("a[href='/course-for-it']");
    private final By trialMenuBtn = By.cssSelector("a[href='/code-better-than-ai']");
    private final By shopMenuBtn = By.cssSelector("a[href='/shop']");
    private final By loginMenuBtn = By.xpath("//button[.//div[normalize-space(text())='Zaloguj się']]");
    private final By burgerMenuBtn = By.xpath("//button[.//svg[contains(@d,'M2 6a1 1')]]");
    private final By mobileMenuContainer = By.cssSelector(" div.u.v.w.h.f.x.q.b.c.r");


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

    public void goToTrialCourse() {
        click(trialMenuBtn);
    }

    public void goToShop() {
        click(shopMenuBtn);
    }

    public void openLogin(){
        click(loginMenuBtn);
    }

    public List<String> getMenuItemsTxt(){
        return driver.findElements(By.cssSelector("nav a"))
                .stream()
                .map(WebElement::getText)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    public boolean isBurgerMenuVisible(){
        return isDisplayed(burgerMenuBtn);
    }

    public void waitForBurgerToAppear(){
        waitVisible(burgerMenuBtn);
    }

    public boolean isMobileMenuOpen(){
        return isDisplayed(mobileMenuContainer);
    }
}

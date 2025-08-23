package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideNavPage extends BasePage {
    public SideNavPage(WebDriver driver) {
        super(driver);
    }

    private final By logoMenuBtn = By.cssSelector("a[href='/']");
    private final By lessonMenuBtn = By.cssSelector("a[href='/']");
    private final By blogMenuBtn = By.cssSelector("a[href='/blog']");
    private final By videoMenuBtn = By.cssSelector("a[href='/videos']");
    private final By shopMenuBtn = By.cssSelector("a[href='/shop']");
    private final By contactMenuBtn = By.cssSelector("a[href='/contact']");

    @Override
    public boolean isLoaded() {
        return isDisplayed(logoMenuBtn);
    }

    public void goToBlog() {
        click(blogMenuBtn);
    }

    public void goToLesson() {
        click(lessonMenuBtn);
    }

    public void goToShop() {
        click(shopMenuBtn);
    }

    public void goToVideo() {
        click(videoMenuBtn);
    }

    public void goToContact() {
        click(contactMenuBtn);
    }
}

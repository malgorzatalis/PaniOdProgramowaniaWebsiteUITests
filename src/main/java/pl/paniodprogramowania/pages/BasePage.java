package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By logoButtonMenu = By.cssSelector(".t.k");
    private final By cookieAcceptButton = By.xpath("/html/body/div[2]/div/section/section/section/div/div/button[1]");
    private final By moreButton = By.xpath("//*[@id=\"react-aria-:R3j6:\"]/div/div/svg/path");
    private final By lessonButtonMenu = By.cssSelector(".bd.bh.bf");
    private final By blogButtonMenu = By.cssSelector(".bd.cf.bf");
    private final By videoButtonMenu = By.xpath("//div[text()='Wideo']");
    private final By shopButtonMenu = By.cssSelector(".bd.bh.bf");
    private final By contactButtonMenu = By.cssSelector(".bd.cf.bf");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Boolean isDisplayed() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(logoButtonMenu));
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element SVG nie jest wyświetlany: " + e.getMessage());
            return false;
        }
    }

    public void clickCookieAcceptButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            button.click();
            System.out.println("Kliknięto przycisk akceptacji ciasteczek.");
        } catch (Exception e) {
            System.out.println("Nie znaleziono lub nie można kliknąć przycisku akceptacji ciasteczek: " + e.getMessage());
        }
    }
}

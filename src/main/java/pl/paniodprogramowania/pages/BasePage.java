package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, defaultTimeout());
    }

    protected boolean isDisplayed(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty()) {
            return false;
        }
        return elements.get(0).isDisplayed();
    }

    protected Duration defaultTimeout() {
        return Duration.ofSeconds(10);
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClick(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitClick(locator).click();
    }

    protected boolean exists(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public abstract boolean isLoaded();
}

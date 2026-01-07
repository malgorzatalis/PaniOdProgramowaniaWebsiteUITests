package pl.paniodprogramowania.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pl.paniodprogramowania.pages.CookieBannerPage;

import java.io.ByteArrayInputStream;
import java.time.Duration;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String BASE_URL = "https://paniodprogramowania.pl";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(BASE_URL);

        new CookieBannerPage(driver).acceptIfVisible();
    }

    @AfterMethod(alwaysRun = true)
    public void attachOnFailure(ITestResult result) {
        if (driver != null && result.getStatus() == ITestResult.FAILURE) {
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment("Screenshot" + result.getName(), "image/png", new ByteArrayInputStream(png), ".png");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

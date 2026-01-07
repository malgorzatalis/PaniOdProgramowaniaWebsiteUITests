package pl.paniodprogramowania.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.paniodprogramowania.pages.HeaderPage;

import java.util.List;

public class HeaderPageTest extends BaseTest {
    private HeaderPage headerPage;

    @BeforeMethod
    public void initHeaderPage() {
        headerPage = new HeaderPage(driver);
        Assert.assertTrue(headerPage.isLoaded(), "Header is not visible");
    }

    @Test
    public void shouldLoadHeaderAndListMenuItems() {
        List<String> items = headerPage.getMenuItemsTxt();

        Assert.assertFalse(items.isEmpty(), "Menu items list is empty");
        Assert.assertTrue(items.stream().allMatch(s -> !s.trim().isEmpty()), "Some menu items are blank");

        Assert.assertTrue(
                items.stream().anyMatch(s -> s.trim().equalsIgnoreCase("Sklep")),
                "'Sklep' does not exist"
        );

        Assert.assertTrue(
                items.stream().anyMatch(s -> s.trim().toLowerCase().contains("kurs")),
                "No 'kurs' in the menu"
        );
    }

    @Test
    public void shouldHaveExpectedMenuItems() {
        List<String> items = headerPage.getMenuItemsTxt();

        Assert.assertFalse(items.isEmpty(), "Menu items list is empty");

        Assert.assertTrue(items.stream().anyMatch(s -> s.equalsIgnoreCase("O mnie")), "Missing: O mnie");
        Assert.assertTrue(items.stream().anyMatch(s -> s.toLowerCase().contains("stawiasz pierwsze kroki")), "Missing: Stawiasz pierwsze kroki?");
        Assert.assertTrue(items.stream().anyMatch(s -> s.toLowerCase().contains("już pracujesz")), "Missing: Już pracujesz w IT?");
        Assert.assertTrue(items.stream().anyMatch(s -> s.toLowerCase().contains("darmowy mini kurs")), "Missing: Darmowy mini kurs");
        Assert.assertTrue(items.stream().anyMatch(s -> s.toLowerCase().contains("moje wystąpienia")), "Missing: Moje wystąpienia");
        Assert.assertTrue(items.stream().anyMatch(s -> s.equalsIgnoreCase("Sklep")), "Missing: Sklep");
    }

    @Test
    public void shouldFailAndAttachScreenshot() {
        Assert.assertTrue(false, "Intentional failure to verify Allure report");
    }

}

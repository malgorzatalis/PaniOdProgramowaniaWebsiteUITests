package pl.paniodprogramowania.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest extends BaseTest{
    @Test
    public void openBrowserAndGoToPage() {
        driver.get("https://www.paniodprogramowania.pl");
    }
}

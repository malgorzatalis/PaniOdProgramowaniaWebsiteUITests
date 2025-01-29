package pl.paniodprogramowania.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePageTest extends BaseTest {
    @Test
    public void isDisplayedElement(){
        assertTrue(basePage.isDisplayed(), "Element powinien być wyświetlany");
    }
}
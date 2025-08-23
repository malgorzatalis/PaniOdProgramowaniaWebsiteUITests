package pl.paniodprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.paniodprogramowania.pages.CookieBannerPage;

public class ExampleTest extends BaseTest {

    @Test
    public void cookieBannerVisibleAndAcceptable(){
        CookieBannerPage cookieBannerPage = new CookieBannerPage(driver);

        Assert.assertTrue(cookieBannerPage.isLoaded());
        Assert.assertTrue(cookieBannerPage.acceptIfVisible());
        Assert.assertFalse(cookieBannerPage.isLoaded());
    }

}

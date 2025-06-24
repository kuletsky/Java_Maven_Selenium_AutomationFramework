package empower.com;

import empower.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    void testMainTitleHomePage() {
        String title = new HomePage(getDriver())
                .getTextOfMainTitle();

        Assert.assertEquals(title, "Get good at money");
    }

    @Test
    void testURLHomePage() {
        String url = new HomePage(getDriver())
                .getUrlOfMainPage();

        Assert.assertEquals(url, "https://www.empower.com/");

    }
}

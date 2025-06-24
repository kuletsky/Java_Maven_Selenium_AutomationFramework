package empower.com;

import empower.com.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    void testMainTitleHomePage() {
        String title = new HomePage(getDriver())
                .getTextOfMainTitle();
        Assert.assertEquals(title, "Get good at money");
    }

    @Test testURLHomePage() {
        String url
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.empower.com/");

    }
}

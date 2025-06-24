package empower.com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    void testHomePage() {
        String title = driver.findElement(By.cssSelector("h1")).getText();

        Assert.assertEquals(title, "Get good at money");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.empower.com/");
    }
}

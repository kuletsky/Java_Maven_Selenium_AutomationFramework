package empower.com.pages;

import empower.com.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginCenterPage extends BasePage {

    public LoginCenterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    private WebElement headingPage;

    public String getHeadingPage() {
        return waitUntilVisible10(headingPage).getText();
    }
}

package empower.com.pages;

import empower.com.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlanServiceCenterPage extends BasePage {

    public PlanServiceCenterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".site-tagline")
    private WebElement headingPage;

    @FindBy(xpath = "//header//span[text()='Login']")
    private WebElement loginButton;

    public String getHeadingPage() {
        return waitUntilVisible10(headingPage).getText();
    }

}

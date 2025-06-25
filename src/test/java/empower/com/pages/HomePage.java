package empower.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    private WebElement heading;

    public String getTextOfMainHeading() {
        return heading.getText();
    }

    public String getUrlOfMainPage() {
        return getDriver().getCurrentUrl();
    }
}

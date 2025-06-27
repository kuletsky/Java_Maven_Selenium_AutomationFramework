package empower.com.components;

import empower.com.pages.BasePage;
import empower.com.pages.HomePage;
import empower.com.pages.LoginCenterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHeader extends BasePage {

    public BaseHeader(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(css = "footer")
    private WebElement footer;

    @FindBy(css = ".stacked-logo")
    private WebElement empowerLogo;

    @FindBy(xpath = "//*[text()='Individuals']")
    private WebElement individualsMenu;


    public LoginCenterPage clickLoginButton() {
        waitUntilClickable10(loginButton).click();

        return new LoginCenterPage(getDriver());
    }

    public BaseHeader clickEmpowerLogo() {
        waitUntilClickable10(empowerLogo).click();

        return this;
    }

    public HomePage getHeaderIndividuals() {
        waitUntilClickable10(individualsMenu).click();

        return new HomePage(getDriver());
    }

    public BaseHeader scrollToBottom() {
        new Actions(getDriver())
                .moveToElement(footer)
                .perform();

        return this;
    }

    public boolean isHeaderScrolled() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(driver -> driver.findElement(By.id("main-header-nav"))
                        .getAttribute("style")
                        .contains("height: 60px"));
    }
}

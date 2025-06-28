package empower.com.components;

import empower.com.common.BasePage;
import empower.com.pages.IndividualsPage;
import empower.com.pages.LoginCenterPage;
import empower.com.pages.OnBoardingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderIndividualsComponent extends BasePage {

    public HeaderIndividualsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header//span[text()='Open an account']")
    private WebElement openAccountButton;

    @FindBy(css = "a[data-once='nav-main-contextual-link-click']")
    private List<WebElement> actualContextualMenu;

    @FindBy(css = "button[data-once*='desktopPrimaryNav']")
    private List<WebElement> actualPrimaryMenu;

    @FindBy(xpath = "//header//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(css = ".stacked-logo")
    private WebElement empowerLogo;


    public IndividualsPage clickEmpowerLogo() {
        empowerLogo.click();

        return new IndividualsPage(getDriver());
    }

    public OnBoardingPage clickOpenAccountButton() {
        waitUntilClickable10(openAccountButton).click();

        return new OnBoardingPage(getDriver());
    }

    public LoginCenterPage clickLoginButton() {
        waitUntilClickable10(loginButton).click();

        return new LoginCenterPage(getDriver());
    }

    public List<String> getActualContextualMenu() {
        return waitUntilVisibleAll10(actualContextualMenu)
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }

    public List<String> getActualPrimaryMenu() {
        return waitUntilVisibleAll10(actualPrimaryMenu)
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }
}

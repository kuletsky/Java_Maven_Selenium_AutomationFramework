package empower.com.components;

import empower.com.common.BasePage;
import empower.com.pages.IndividualsPage;
import empower.com.pages.PlanServiceCenterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeaderPlanSponsorsComponent extends BasePage {

    @FindBy(css = ".stacked-logo")
    private WebElement empowerLogo;

    @FindBy(xpath = "//header//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(css = "a[data-once='nav-main-contextual-link-click']")
    private List<WebElement> actualContextualMenu;

    @FindBy(css = "button[data-once*='desktopPrimaryNav']")
    private List<WebElement> actualPrimaryMenu;

    @FindBy(css = "footer")
    private WebElement footer;


    public HeaderPlanSponsorsComponent(WebDriver driver) {
        super(driver);
    }

    public IndividualsPage clickEmpowerLogo() {
        empowerLogo.click();

        return new IndividualsPage(getDriver());
    }

    public PlanServiceCenterPage clickLoginButton() {
        waitUntilClickable10(loginButton).click();

        return new PlanServiceCenterPage(getDriver());
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

    public HeaderPlanSponsorsComponent scrollToBottom() {
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
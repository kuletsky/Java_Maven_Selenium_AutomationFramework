package empower.com.components;

import empower.com.common.BasePage;
import empower.com.pages.IndividualsPage;
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


    @FindBy(css = "footer")
    private WebElement footer;

    @FindBy(css = ".stacked-logo")
    private WebElement empowerLogo;

    @FindBy(xpath = "//*[text()='Individuals']")
    private WebElement individualsMenu;

    @FindBy(xpath = "//*[text()='Plan Sponsors']")
    private WebElement PlanSponsorsMenu;


    public IndividualsPage clickEmpowerLogo() {
        empowerLogo.click();

        return new IndividualsPage(getDriver());
    }

    public HeaderIndividualsComponent getHeaderIndividuals() {
        waitUntilClickable10(individualsMenu).click();

        return new HeaderIndividualsComponent(getDriver());
    }

    public HeaderPlanSponsorsComponent getHeaderPlanSponsors() {
        waitUntilClickable10(PlanSponsorsMenu).click();

        return new HeaderPlanSponsorsComponent(getDriver());
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

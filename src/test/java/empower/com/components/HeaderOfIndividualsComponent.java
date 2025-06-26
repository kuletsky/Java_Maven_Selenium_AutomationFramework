package empower.com.components;

import empower.com.pages.BasePage;
import empower.com.pages.OnBoardingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderOfIndividualsComponent extends BasePage {

    public HeaderOfIndividualsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(xpath = "//header//span[text()='Open an account']")
    private WebElement openAccountButton;


    public String getTextOfMainHeading() {
        return heading.getText();
    }

    public OnBoardingPage clickOpenAccountButton() {
        waitUntilClickable10(openAccountButton).click();

        return new OnBoardingPage(getDriver());
    }
}

package empower.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderIndividualsMenu extends BasePage{

    public HeaderIndividualsMenu(WebDriver driver) {
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

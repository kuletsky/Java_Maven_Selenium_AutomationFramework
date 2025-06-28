package empower.com.pages;

import empower.com.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IndividualsPage extends BasePage {
    
    public IndividualsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(xpath = "//div[@data-drupal-block-name='hero_header']//span[text()='Open an account']")
    private WebElement openAccountButton;


    public String getTextOfMainHeading() {
        return heading.getText();
    }

    public OnBoardingPage clickOpenAccountButton() {
         waitUntilClickable10(openAccountButton).click();

        return new OnBoardingPage(getDriver());
    }
    
}

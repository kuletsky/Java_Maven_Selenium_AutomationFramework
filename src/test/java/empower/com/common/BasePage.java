package empower.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class BasePage {
    private final WebDriver driver;
    private WebDriverWait wait5;
    private WebDriverWait wait10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }
    
    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;
    }

    protected WebElement waitUntilClickable10(WebElement element) {
        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUntilVisible10(WebElement element) {
        return getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    protected List<WebElement> waitUntilVisibleAll10(List<WebElement> elements) {
        return getWait10().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}

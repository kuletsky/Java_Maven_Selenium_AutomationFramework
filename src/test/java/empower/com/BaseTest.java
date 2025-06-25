package empower.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait5;
    WebDriverWait wait10;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.empower.com");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
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
}

package com.empower.tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderIndividualsTest extends BaseTest {

    @Test
    public void testHeaderEmpowerLogo() {
        getDriver().get("https://www.empower.com/products-solutions");

        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.className("stacked-logo"))).click();
        String actualHeading = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/");
        Assert.assertEquals(actualHeading, "Get good at money");
    }

    @Test
    public void testLoginPageURL() {
        getDriver().get("https://www.empower.com/");

        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='login']"))).click();
        String actualHeading = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/login-v1");
        Assert.assertEquals(actualHeading, "Where would you like to log in?");
    }

    @Test
    public void testOpenAccountURL() {
        getDriver().get("https://www.empower.com/");

        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.id("block-empulsify-signup-register"))).click();
        String actualHeading = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h3-alt"))).getText();
        System.out.println(actualHeading);

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/onboarding-v2");
        Assert.assertEquals(actualHeading, "Please confirm the type of account you want to open");
    }

    @Test
    public void testContextualMenuLinksDesktop() {
        getDriver().get("https://www.empower.com/");

        List<String> expectedText = Arrays.asList("Individuals", "Plan Sponsors", "Financial Professionals"); 

        List<WebElement> actualNavLinks = getWait10().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[data-once='nav-main-contextual-link-click']")));

        List<String> actualText = actualNavLinks.stream()
            .map(WebElement::getText)
            .map(String::trim)
            .collect(Collectors.toList());

        for (String expected : expectedText) {
            Assert.assertTrue(actualText.contains(expected),
            "Expected link text not found: " + expected);
        }
    }

    @Test
    public void testPrimaryMenuLinksDesktop() {
        getDriver().get("https://www.empower.com/");

        List<String> expectedText = Arrays.asList("Products & Solutions", "Tools", "Learn", "Why Empower");

        List<WebElement> actualNavLinks = getWait10().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[data-once*='desktopPrimaryNav']")));

        List<String> actualText = actualNavLinks.stream()
            .map(WebElement::getText)
            .map(String::trim)
            .collect(Collectors.toList());

        for (String expected : expectedText) {
            Assert.assertTrue(actualText.contains(expected),
            "Expected link text not found: " + expected);
        }
    }

    @Test
    public void testScrollingHeader() {
        getDriver().get("https://www.empower.com/");

        List<WebElement> actualNavLinks = getWait10().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[data-once='nav-main-contextual-link-click']")));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.id("block-empulsify-legal")));

        boolean isDisplayedMenu = getWait10().until(ExpectedConditions.invisibilityOfElementLocated(By.className("contextual-nav-row")));

        Assert.assertTrue(isDisplayedMenu, "Contextual menu still visible after scroll");
    }
}

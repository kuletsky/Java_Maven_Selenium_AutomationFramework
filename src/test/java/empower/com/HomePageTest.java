package com.empower.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.empower.pages.HomePage;


public class HomePageTest extends BaseTest {
    
    @Test 
    public void testMaimHeadingOfHomePage() {
        String actualHeading = new HomePage(getDriver())
            .getTextOfMainHeading();
        
        Assert.assertEquals(actualHeading, "Get good at money");
    }

    @Test
    public void testOpenAccountButton() {
        String actualURL = new HomePage(getDriver())
            .clickOpenAccountButton()
            .getCurrentUrl();

        Assert.assertTrue(actualURL.contains("onboarding-v2"));
    }

    @Test
    public void testHeaderEmpowerLogo() {
        getDriver().get("https://www.empower.com/products-solutions");

        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("stacked-logo"))).click();
        String actualHeading = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/");
        Assert.assertEquals(actualHeading, "Get good at money");
    }

    @Test
    public void testFooterEmpowerLogo() {
        getDriver().get("https://www.empower.com/products-solutions");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.className("logo"))).click();
        String actualHeading = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/");
        Assert.assertEquals(actualHeading, "Get good at money");
    }

}

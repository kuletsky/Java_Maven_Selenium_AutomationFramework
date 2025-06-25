package com.empower.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(xpath = "//text()='Open an account'")
    private WebElement openAccountButton;


    public String getTextOfMainHeading() {
        return heading.getText();
    }

    public HomePage clickOpenAccountButton() {
        // waitUntilClickable10(openAccountButton).click();
        getWait10().until(ExpectedConditions.elementToBeClickable(By.xpath("//text()='Open an account'")));
        
        return this;
    }

    public String getCurrentUrl() {
        System.out.println(getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl();   
             
    }
    
}

package empower.com.tests;

import empower.com.components.HeaderIndividualsComponent;
import empower.com.pages.LoginCenterPage;
import empower.com.pages.OnBoardingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderIndividualsTest extends BaseTest {

    @Test
    public void testOpenAccountButtonFunctionality() {
        OnBoardingPage onBoardingPage = new HeaderIndividualsComponent(getDriver())
                .clickOpenAccountButton();

        Assert.assertTrue(onBoardingPage.getCurrentUrl().contains("onboarding-v2"));
        Assert.assertEquals(onBoardingPage.getHeadingOfPop(),
                "Please confirm the type of account you want to open");
    }

    @Test
    public void testLoginButtonFunctionality() {
        LoginCenterPage loginCenterPage = new HeaderIndividualsComponent(getDriver())
                .clickLoginButton();

        Assert.assertTrue(loginCenterPage.getCurrentUrl().contains("login-v1"));
        Assert.assertEquals(loginCenterPage.getHeadingPage(),
                "Where would you like to log in?");
    }

    @Test
    public void testContextualMenuLinksDesktop() {
        List<String> expectedContextualMenu = Arrays.asList("Individuals", "Plan Sponsors", "Financial Professionals");

        List<String> actualContextualMenu = new HeaderIndividualsComponent(getDriver())
                .getActualContextualMenu();

        Assert.assertEquals(actualContextualMenu, expectedContextualMenu);
        Assert.assertEquals(actualContextualMenu.size(), 3);
    }

    @Test
    public void testPrimaryMenuLinksDesktop() {
        List<String> expectedPrimaryMenu = Arrays.asList("Products & Solutions", "Tools", "Learn", "Why Empower");

        List<String> actualPrimaryMenu = new HeaderIndividualsComponent(getDriver())
                .getActualPrimaryMenu();

        Assert.assertEquals(actualPrimaryMenu, expectedPrimaryMenu);
        Assert.assertEquals(actualPrimaryMenu.size(), 4);
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

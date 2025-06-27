package empower.com.tests;

import empower.com.components.BaseHeader;
import empower.com.components.HeaderIndividualsComponent;
import empower.com.pages.HomePage;
import empower.com.pages.LoginCenterPage;
import empower.com.pages.OnBoardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HeaderIndividualsTest extends BaseTest {

    @Test
    public void testEmpowerLogoFunctionality() {
        String actualHeading = new BaseHeader(getDriver())
                .getHeaderIndividuals()
                .getTextOfMainHeading();

        Assert.assertEquals(actualHeading, "Get good at money");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/");
    }

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
        LoginCenterPage loginCenterPage = new BaseHeader(getDriver())
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
        BaseHeader headerIndividuals = new BaseHeader(getDriver())
                .scrollToBottom();

        Assert.assertTrue(headerIndividuals.isHeaderScrolled());
    }

}

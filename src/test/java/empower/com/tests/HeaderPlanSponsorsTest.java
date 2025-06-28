package empower.com.tests;

import empower.com.common.BaseTest;
import empower.com.components.BaseHeader;
import empower.com.components.HeaderPlanSponsorsComponent;
import empower.com.pages.PlanServiceCenterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HeaderPlanSponsorsTest extends BaseTest {

    @Test
    public void testEmpowerLogoFunctionality() {
        String actualHeading = new BaseHeader(getDriver())
                .getHeaderPlanSponsors()
                .clickEmpowerLogo()
                .getTextOfMainHeading();

        Assert.assertEquals(actualHeading, "Get good at money");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.empower.com/");
    }

    @Test
    public void testLoginButtonFunctionality() {
        PlanServiceCenterPage page = new BaseHeader(getDriver())
                .getHeaderPlanSponsors()
                .clickLoginButton();

        Assert.assertTrue(page.getCurrentUrl().contains("plan.empower-retirement.com/planweb"));
        Assert.assertEquals(page.getHeadingPage(), "PLAN SERVICE CENTER");
    }

    @Test
    public void testContextualMenuLinksDesktop() {
        List<String> expectedContextualMenu = Arrays.asList("Individuals", "Plan Sponsors", "Financial Professionals");

        List<String> actualContextualMenu = new BaseHeader(getDriver())
                .getHeaderPlanSponsors()
                .getActualContextualMenu();

        Assert.assertEquals(actualContextualMenu, expectedContextualMenu);
        Assert.assertEquals(actualContextualMenu.size(), 3);
    }

    @Test
    public void testPrimaryMenuLinksDesktop() {
        List<String> expectedPrimaryMenu = Arrays.asList("Markets", "Solutions", "Experience", "Learn", "Why Empower");

        List<String> actualPrimaryMenu = new BaseHeader(getDriver())
                .getHeaderPlanSponsors()
                .getActualPrimaryMenu();

        Assert.assertEquals(actualPrimaryMenu, expectedPrimaryMenu);
        Assert.assertEquals(actualPrimaryMenu.size(), 5);
    }

    @Test
    public void testScrollingHeader() {
        HeaderPlanSponsorsComponent headerPlanSponsors = new BaseHeader(getDriver())
                .getHeaderPlanSponsors()
                .scrollToBottom();

        Assert.assertTrue(headerPlanSponsors.isHeaderScrolled());
    }
}

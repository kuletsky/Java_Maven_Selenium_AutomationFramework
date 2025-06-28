package empower.com.tests;


import empower.com.common.BaseTest;
import empower.com.pages.IndividualsPage;
import empower.com.pages.OnBoardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IndividualsTest extends BaseTest {
    
    @Test 
    public void testMainHeadingIndividualsPage() {
        String actualHeading = new IndividualsPage(getDriver())
            .getTextOfMainHeading();
        
        Assert.assertEquals(actualHeading, "Get good at money");
    }

    @Test
    public void testOpenAccountButtonFunctionality() {
        OnBoardingPage onBoardingPage = new IndividualsPage(getDriver())
                .clickOpenAccountButton();

        Assert.assertTrue(onBoardingPage.getCurrentUrl().contains("onboarding-v2"));
        Assert.assertEquals(onBoardingPage.getHeadingOfPop(),
                "Please confirm the type of account you want to open");
    }
}

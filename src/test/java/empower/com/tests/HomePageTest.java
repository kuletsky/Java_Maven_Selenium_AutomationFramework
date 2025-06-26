package empower.com.tests;


import empower.com.pages.HomePage;
import empower.com.pages.OnBoardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {
    
    @Test 
    public void testMaimHeadingOfHomePage() {
        String actualHeading = new HomePage(getDriver())
            .getTextOfMainHeading();
        
        Assert.assertEquals(actualHeading, "Get good at money");
    }

    @Test
    public void testOpenAccountButtonFunctionality() {
        OnBoardingPage onBoardingPage = new HomePage(getDriver())
                .clickOpenAccountButton();

        Assert.assertTrue(
                onBoardingPage.getCurrentUrl().contains("onboarding-v2")
        );

        Assert.assertEquals(
                onBoardingPage.getHeadingOfPop(),
                "Please confirm the type of account you want to open"
        );
    }
}
